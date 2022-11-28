import java.util.HashSet;
import java.util.Set;

public class ProductService {
    private final Set<Product> products = new HashSet<>();

    public void add(Product product) throws ProductException {
        if (!products.add(product)) {
            throw new ProductException("Данный продукт уже находится в списке!");
        }
        product.checkBuy();
    }

    public Set<Product> getProducts() {
        return products;
    }

    public void delete(Product product) {
        System.out.println("Из списка удалён продукт: " + product.getNameProduct());
        products.remove(product);
    }

    @Override
    public String toString() {
        StringBuilder allProducts = new StringBuilder();
        for (Product product : products){
            allProducts.append(product);
        }
        return allProducts.toString();
    }
}
