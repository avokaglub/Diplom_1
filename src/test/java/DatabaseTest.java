import org.junit.Before;
import org.junit.Test;
import praktikum.Bun;
import praktikum.Database;
import praktikum.Ingredient;

import java.util.List;
import static org.junit.Assert.assertFalse;

public class DatabaseTest {
    Database database;

    @Before
    public void setUp() {
        this.database = new Database();
    }

    @Test
    public void availableBunsTest() {
        List<Bun> bunsList = this.database.availableBuns();
        assertFalse(bunsList.isEmpty());
    }

    @Test
    public void availableIngredientsTest() {
        List<Ingredient> ingredientsList = this.database.availableIngredients();
        assertFalse(ingredientsList.isEmpty());
    }
}