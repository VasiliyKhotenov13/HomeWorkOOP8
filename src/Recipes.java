import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class Recipes {

    private double PRICE = 0;
    private String recipeName;
    private Map<Product, Integer> products = new HashMap<>();

//    public Recipes(String recipeName,
//            ProductService productService) throws ProductException {
//        if (recipeName == null || recipeName.isEmpty() || recipeName.isBlank()) {
//            throw new ProductException("АЛЯРМА! Поля заполнены не полнстью!");
//        }
//        this.productService = productService;
//        this.recipeName = recipeName;
//        for (Product item : productService.getProducts()) {
//            PRICE += item.getCost();
//        }
//        this.allPrice = PRICE;
//
//    }

    public Recipes(String recipeName) {
        this.recipeName = recipeName;
    }

    public void addProd(Product product, int quantity) {
        if (quantity <= 0) {
            quantity = 1;
        }
        if (this.products.containsKey(product)) {
            this.products.put(product, this.products.get(product) + quantity);
        } else {
            this.products.put(product, quantity);
        }
    }
    public double fullPricesRecipes(){
        for (Map.Entry<Product, Integer> product : this.products.entrySet()) {
            PRICE += product.getKey().getCost() * product.getValue();
        }
        return PRICE;
    }

    public Map<Product, Integer> getProducts() {
        return products;
    }

    public String getRecipeName() {
        return recipeName;
    }

    @Override
    public String toString() {
        return products.toString().replace("[","").replace("]","")
                .replace("{","").replace("}","");
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Recipes recipes = (Recipes) o;
        return Double.compare(recipes.PRICE, PRICE) == 0 && Objects.equals(recipeName, recipes.recipeName) && Objects.equals(products, recipes.products);
    }

    @Override
    public int hashCode() {
        return Objects.hash(PRICE, recipeName, products);
    }
}
