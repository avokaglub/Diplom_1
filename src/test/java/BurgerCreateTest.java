import org.junit.*;
import org.junit.rules.ErrorCollector;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import praktikum.Bun;
import praktikum.Burger;
import praktikum.Ingredient;
import praktikum.IngredientType;

import static org.hamcrest.CoreMatchers.containsString;
import static org.junit.Assert.*;
import static org.junit.Assert.assertEquals;

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
    // String bunName, float bunPrice, IngredientType ingredientType, String ingredientName, float ingredientPrice, float totalPrice
    // "black bun", "white bun", "red bun"
    // IngredientType SAUCE FILLING
    public static Object[][] getTestData() {
        return new Object[][] {
                {"black bun", 100, IngredientType.FILLING, "Начинка", 50, 250},
                {"white bun", 200, IngredientType.SAUCE, "Соус", 25, 425},
                {"red bun", 230, IngredientType.SAUCE, "Соус", 20, 480},
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
        Bun testBun = new Bun(this.bunName, this.bunPrice);
        Burger burger = new Burger();
        burger.setBuns(testBun);
        System.out.println(burger.getReceipt());
    }

    @Test
    public void addIngredientTest() {
        Bun testBun = new Bun(this.bunName, this.bunPrice);
        Burger burger = new Burger();
        Ingredient ingredient = new Ingredient(this.ingredientType, this.ingredientName, this.ingredientPrice);
        burger.setBuns(testBun);
        burger.addIngredient(ingredient);
        System.out.println(burger.getReceipt());
    }

    @Test
    public void removeIngredientTest() {
        Bun testBun = new Bun(this.bunName, this.bunPrice);
        Burger burger = new Burger();
        burger.setBuns(testBun);

        Ingredient ingredient = new Ingredient(this.ingredientType, this.ingredientName, this.ingredientPrice);
        burger.addIngredient(ingredient);

        System.out.println(burger.getPrice());
        System.out.println("===============");
        System.out.println(burger.getReceipt());
        burger.removeIngredient(0);
        System.out.println("===============");
        System.out.println(burger.getReceipt());
    }

    @Test
    public void moveIngredientTest() {
        Bun testBun = new Bun(this.bunName, this.bunPrice);
        Burger burger = new Burger();
        burger.setBuns(testBun);

        Ingredient firstIngredient = new Ingredient(this.ingredientType, this.ingredientName, this.ingredientPrice);
        burger.addIngredient(firstIngredient);
        Ingredient secondIngredient = new Ingredient(IngredientType.SAUCE, "Соус", 0);
        burger.addIngredient(secondIngredient);

        System.out.println("===============");
        System.out.println(burger.getReceipt());
        burger.moveIngredient(0, 1);
        System.out.println("===============");
        System.out.println(burger.getReceipt());
    }

    @Test
    public void getPriceTest() {
        Bun testBun = new Bun(this.bunName, this.bunPrice);
        Burger burger = new Burger();
        burger.setBuns(testBun);

        Ingredient firstIngredient = new Ingredient(this.ingredientType, this.ingredientName, this.ingredientPrice);
        burger.addIngredient(firstIngredient);

        float burgerPrice = burger.getPrice();
        assertEquals("Burger prices not equals", this.totalPrice, burgerPrice, 0.0);
    }

    @Test
    public void getReceiptTest() {
        Bun testBun = new Bun(this.bunName, this.bunPrice);
        Burger burger = new Burger();
        burger.setBuns(testBun);

        Ingredient firstIngredient = new Ingredient(this.ingredientType, this.ingredientName, this.ingredientPrice);
        burger.addIngredient(firstIngredient);

        //Ingredient firstIngredient = new Ingredient(IngredientType.FILLING, "Помидорка", 10);
        //burger.addIngredient(firstIngredient);
        //Ingredient secondIngredient = new Ingredient(IngredientType.SAUCE, "Соус", 15);
        //burger.addIngredient(secondIngredient);

        String receipt = burger.getReceipt();
        System.out.println("===============");
        System.out.println(receipt);

        //collector.checkThat(containsString(firstIngredient.getName()));
        assertTrue("Рецепт не содержит добавленный ингридиент",
                receipt.contains(firstIngredient.getName()));

        assertEquals("Burger prices not equals", this.totalPrice, burger.getPrice(), 0.0);
    }
}