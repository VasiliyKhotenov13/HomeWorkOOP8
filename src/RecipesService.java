import java.util.HashSet;
import java.util.Set;

public class RecipesService {

    private final Set<Recipes> recipesSet = new HashSet<>();

    public void addRecipes(Recipes recipe) throws ProductException {
        if (recipesSet.contains(recipe)) {
            throw new ProductException("Данный рецепт существует в списке!");
        } else {
            recipesSet.add(recipe);
        }
    }

    public Set<Recipes> getRecipesSet() {
        return recipesSet;
    }

    public void delete(Recipes recipes) {
        System.out.println("Из списка удалён рецепт: " + recipes);
        recipesSet.remove(recipes);
    }
}
