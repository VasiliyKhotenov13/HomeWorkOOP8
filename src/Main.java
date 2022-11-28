import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class Main {
    private static Random RANDOM = new Random();

    public static void main(String[] args) throws ProductException {

        Product banana = new Product("Бананы", 100, 0.5);
        Product meatBeef = new Product("Говядина", 450, 2.3);
        Product sweet = new Product("Конфеты", 200, 0.3);
        Product sugar = new Product("Сахар", 80, 1.2);
        Product tomatoes = new Product("Помидоры", 150, 1.7);
        Product butter = new Product("Сливочное масло", 300, 0.5);
        Product potato = new Product("Картошка", 60, 2.0);
        Product cheese = new Product("Сыр", 800, 1);

        ProductService listOfProduct = new ProductService();
        listOfProduct.add(banana);
        listOfProduct.add(tomatoes);
        listOfProduct.add(meatBeef);
        listOfProduct.add(sugar);
        listOfProduct.add(sweet);
        listOfProduct.add(butter);
        listOfProduct.add(potato);
        listOfProduct.add(cheese);

        System.out.println(listOfProduct);
        System.out.println();

        listOfProduct.delete(banana);
//        listOfProduct.add(tomatoes);

        System.out.println(listOfProduct);
        System.out.println();


        ProductService productsBNP = new ProductService();
        productsBNP.add(potato);
        productsBNP.add(butter);
        productsBNP.add(meatBeef);

        RecipesService itemS = new RecipesService();
        Recipes beefNPotatoes = new Recipes("Картошка с мясом", productsBNP);
        itemS.addRecipes(beefNPotatoes);
        System.out.println(beefNPotatoes.toString());
        System.out.println("Цена рецепта " + beefNPotatoes.getRecipeName() +
                " составлет " + beefNPotatoes.getAllPrice() + " рублей!");

        Set<Integer> number = new HashSet<>();
        Set<Integer> numberRemove = new HashSet<>();
        for (int i = 1; i <= 20; i++) {
            number.add(RANDOM.nextInt(1001));
        }
        for (Integer number1 : number) {
            if (!(number1 % 2 == 0)) {
                numberRemove.add(number1);
            } else {
                System.out.print(number1 + " ");
            }
        }
        for (Integer number1 : numberRemove) {
            number.remove(number1);
        }
        System.out.println();
        System.out.println(numberRemove);
        System.out.println(number);
    }
}