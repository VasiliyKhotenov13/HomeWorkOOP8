import java.util.Objects;

public class Recipes {

    private double PRICE = 0;
    private ProductService productService;
    private String recipeName;
    private double allPrice;

    public Recipes(String recipeName,
            ProductService productService) throws ProductException {
        if (recipeName == null || recipeName.isEmpty() || recipeName.isBlank()) {
            throw new ProductException("АЛЯРМА! Поля заполнены не полнстью!");
        }
        this.productService = productService;
        this.recipeName = recipeName;
        for (Product item : productService.getProducts()) {
            PRICE += item.getCost();
        }
        this.allPrice = PRICE;

    }

    public ProductService getProductService() {
        return productService;
    }

    public String getRecipeName() {
        return recipeName;
    }

    public double getAllPrice() {
        return allPrice;
    }

    public void setProductService(ProductService productService) {
        this.productService = productService;
    }

    public void setAllPrice(double allPrice) {
        this.allPrice = allPrice;
    }

    @Override
    public String toString() {
        return productService.toString().replace("[","").replace("]","");
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Recipes recipes = (Recipes) o;
        return Objects.equals(productService, recipes.productService) && Objects.equals(recipeName, recipes.recipeName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(productService, recipeName);
    }
}
