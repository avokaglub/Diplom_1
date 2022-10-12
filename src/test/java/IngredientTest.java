import praktikum.Ingredient;
import praktikum.IngredientType;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import static org.junit.Assert.*;

@RunWith(Parameterized.class)
public class IngredientTest {
    private final IngredientType ingredientType;
    private final String ingredientName;
    private final float ingredientPrice;

    public IngredientTest(IngredientType ingredientType, String ingredientName, float ingredientPrice) {
        this.ingredientType = ingredientType;
        this.ingredientName = ingredientName;
        this.ingredientPrice = ingredientPrice;
    }

    @Parameterized.Parameters
    public static Object[][] getTestData() {
        return new Object[][] {
                {IngredientType.SAUCE, "Соус", 10},
                {IngredientType.FILLING, "Начинка", 15},
        };
    }

    @Test
    public void getPriceTest() {
        Ingredient ingredient = new Ingredient(ingredientType, ingredientName, ingredientPrice);
        assertEquals(ingredientPrice, ingredient.getPrice(), 0.0);
    }

    @Test
    public void getNameTest() {
        Ingredient ingredient = new Ingredient(ingredientType, ingredientName, ingredientPrice);
        assertEquals("Ingredient names not equals", ingredientName, ingredient.getName());
    }

    @Test
    public void getTypeTest() {
        Ingredient ingredient = new Ingredient(ingredientType, ingredientName, ingredientPrice);
        assertEquals("Ingredient names not equals", ingredientType, ingredient.getType());
    }
}