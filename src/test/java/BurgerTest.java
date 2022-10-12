import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ErrorCollector;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import praktikum.Bun;
import praktikum.Burger;
import praktikum.Ingredient;
import praktikum.IngredientType;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

@RunWith(Parameterized.class)
public class BurgerTest {
    Burger burger;
    String bunName;
    float bunPrice;
    IngredientType ingredientType;
    String ingredientName;
    float ingredientPrice;
    float totalPrice;

    @Rule
    public ErrorCollector collector = new ErrorCollector();

    @Parameterized.Parameters
    public static Object[][] getTestData() {
        return new Object[][] {
                {"black bun", 100, IngredientType.FILLING, "Начинка", 50, 250},
                {"white bun", 200, IngredientType.SAUCE, "Соус", 25, 425},
                {"red bun", 230, IngredientType.SAUCE, "Соус", 20, 480},
        };
    }

    public BurgerTest(String bunName, float bunPrice,
                      IngredientType ingredientType, String ingredientName, float ingredientPrice, float totalPrice) {
        this.bunName = bunName;
        this.bunPrice = bunPrice;
        this.ingredientType = ingredientType;
        this.ingredientName = ingredientName;
        this.ingredientPrice = ingredientPrice;
        this.totalPrice = totalPrice;
        this.burger = new Burger();
    }

    @Test
    public void setBunsTest() {
        burger.setBuns(new Bun(bunName, bunPrice));
        assertTrue("В рецепте нет добавленной булочки", burger.getReceipt().contains(bunName));
    }

    @Test
    public void addIngredientTest() {
        burger.setBuns(new Bun(bunName, bunPrice));
        burger.addIngredient(new Ingredient(ingredientType, ingredientName, ingredientPrice));
        assertTrue("В рецепте нет добавленного ингредиента", burger.getReceipt().contains(ingredientName));
    }

    @Test
    public void removeIngredientTest() {
        burger.setBuns(new Bun(bunName, bunPrice));
        burger.addIngredient(new Ingredient(ingredientType, ingredientName, ingredientPrice));
        burger.removeIngredient(0);
        assertFalse("В рецепте есть ингредиент, который был удален", burger.getReceipt().contains(ingredientName));
    }

    @Test
    public void moveIngredientTest() {
        burger.setBuns(new Bun(bunName, bunPrice));
        Ingredient firstIngredient = new Ingredient(ingredientType, ingredientName, ingredientPrice);
        burger.addIngredient(firstIngredient);
        burger.addIngredient(new Ingredient(IngredientType.SAUCE, "Соус терияки", 0));
        burger.moveIngredient(0, 1);
        assertTrue("Не изменился порядок ингредиентов бургера после их перемещения", burger.ingredients.get(1).equals(firstIngredient));
    }

}