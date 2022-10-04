import praktikum.Bun;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import static org.junit.Assert.*;

@RunWith(Parameterized.class)
public class BunTest {
    private final String bunName;
    private final float bunPrice;
    //private Bun testBun;

    public BunTest(String bunName, float bunPrice) {
        this.bunName = bunName;
        this.bunPrice = bunPrice;
    }

    @Before
    public void setUp() {
        //this.testBun = new Bun(this.bunName, this.bunPrice);
    }

    @After
    public void tearDown() {
    }

    @Parameterized.Parameters(name = "Test data: bunName [{0}], bunPrice [{1}]")
    public static Object[][] getTestData() {
        return new Object[][] {
                {"black bun", 100},
                {"white bun", 200},
                {"red bun", 300}
        };
    }

    @Test
    public void getNameTest() {
        Bun testBun = new Bun(this.bunName, this.bunPrice);
        assertEquals("Buns names not equals", bunName, testBun.getName());
    }

    @Test
    public void getPriceTest() {
        Bun testBun = new Bun(this.bunName, this.bunPrice);
        assertEquals("Buns prices not equals", bunPrice, testBun.getPrice(), 0.0);
    }
}