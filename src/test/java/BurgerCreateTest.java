import praktikum.Bun;
import praktikum.Burger;
import praktikum.Ingredient;
import praktikum.IngredientType;
import org.junit.*;
import org.junit.rules.ErrorCollector;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.*;
import static org.junit.Assert.assertEquals;
import static org.hamcrest.Matchers.*;

@RunWith(Parameterized.class)
public class BurgerCreateTest {
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
                {"white bun", 200, IngredientType.SAUCE, "Кунжутный соус", 25, 425},
                {"red bun", 230, IngredientType.SAUCE, "Кунжутный соус", 20, 480},
        };
    }

    public BurgerCreateTest(String bunName, float bunPrice, IngredientType ingredientType,
                            String ingredientName, float ingredientPrice, float totalPrice) {
        this.bunName = bunName;
        this.bunPrice = bunPrice;
        this.ingredientType = ingredientType;
        this.ingredientName = ingredientName;
        this.ingredientPrice = ingredientPrice;
        this.totalPrice = totalPrice;
    }

    @Test
    public void setBunsTest() {
        Burger burger = new Burger();
        burger.setBuns(new Bun(this.bunName, this.bunPrice));
        assertTrue("В рецепте нет добавленной булочки", burger.getReceipt().contains(this.bunName));
    }

    @Test
    public void addIngredientTest() {
        Burger burger = new Burger();
        burger.setBuns(new Bun(this.bunName, this.bunPrice));
        burger.addIngredient(new Ingredient(this.ingredientType, this.ingredientName, this.ingredientPrice));
        assertEquals("Стоимость бургера не совпадает с ожидаемой", this.totalPrice, burger.getPrice(), 0.0);
    }

    @Test
    public void removeIngredientTest() {
        Burger burger = new Burger();
        burger.setBuns(new Bun(this.bunName, this.bunPrice));
        Ingredient ingredient = new Ingredient(this.ingredientType, this.ingredientName, this.ingredientPrice);
        burger.addIngredient(ingredient);
        burger.removeIngredient(0);
        assertFalse("В рецепте бургера есть удаленный ингредиент", burger.ingredients.contains(ingredient));
    }

    //@Test
    public void getPriceTest() {
        Burger burger = new Burger();
        burger.setBuns(new Bun(this.bunName, this.bunPrice));
        burger.addIngredient(new Ingredient(this.ingredientType, this.ingredientName, this.ingredientPrice));
        assertEquals("Стоимость бургера не совпадает с ожидаемой", this.totalPrice, burger.getPrice(), 0.0);
    }

    //@Test
    public void getReceiptTest() {
        Burger burger = new Burger();
        burger.setBuns(new Bun(this.bunName, this.bunPrice));
        burger.addIngredient(new Ingredient(this.ingredientType, this.ingredientName, this.ingredientPrice));
        collector.checkThat(burger.getReceipt(), containsString(this.ingredientName));
        collector.checkThat(burger.getPrice(), equalTo(this.totalPrice));
    }
}