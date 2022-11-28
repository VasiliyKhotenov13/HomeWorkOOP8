import java.util.Objects;

public class Product {

    private final String nameProduct;
    private int cost;
    private double weight;
    private boolean buy;
    private boolean check;

    public Product(String nameProduct, int cost, double weight) throws ProductException {
        this.nameProduct = nameProduct;
        this.cost = cost;
        this.weight = weight;
        if (nameProduct == null || nameProduct.isEmpty() || nameProduct.isBlank()) {
            throw new ProductException("Заполните карточку товара полностью");
        }
        if (cost <= 0 || weight <= 0) {
            throw new ProductException("Проверьте! Не все поля заполнены!");
        }
    }

    public String getNameProduct() {
        return nameProduct;
    }

    public int getCost() {
        return cost;
    }

    public double getWeight() {
        return weight;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }
    public void checkBuy(){
        this.buy = true;
    }
    public void buy() {
        buy = true;
    }


    @Override
    public String toString() {
        return "Продукт: " + nameProduct +
                ", полная цена: " + cost +
                ", вес: " + weight + '.';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return cost == product.cost && Double.compare(product.weight, weight) == 0 && Objects.equals(nameProduct, product.nameProduct);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nameProduct, cost, weight);
    }
}
