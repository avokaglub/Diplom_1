import praktikum.Bun;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import static org.junit.Assert.*;

@RunWith(Parameterized.class)
public class BunTest {
    private final String bunName;
    private final float bunPrice;
    private Bun testBun;

    public BunTest(String bunName, float bunPrice) {
        this.bunName = bunName;
        this.bunPrice = bunPrice;
        this.testBun = new Bun(this.bunName, this.bunPrice);
    }

    @Parameterized.Parameters(name = "Тестовые данные: название булочки [{0}], цена булочки [{1}]")
    public static Object[][] getTestData() {
        return new Object[][] {
                {"black bun", 100},
                {"white bun", 200},
                {"red bun", 300}
        };
    }

    @Test
    public void getNameTest() {
        assertEquals("Название булочки не совпадает с ожидаемым", this.bunName, this.testBun.getName());
    }

    @Test
    public void getPriceTest() {
        assertEquals("Цена булочки не совпадает с ожидаемой", this.bunPrice, this.testBun.getPrice(), 0.0);
    }
}