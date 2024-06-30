package praktikum;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

@RunWith(Parameterized.class)
public class BunTest {
    private final String expectedName;
    private final float expectedPrice;

    public BunTest(String expectedName, float expectedPrice) {
        this.expectedName = expectedName;
        this.expectedPrice = expectedPrice;
    }

    @Parameterized.Parameters(name = "{index}. Название: {0}, цена: {1}")
    public static Object[][] data() {
        return new Object[][]{
                {"Ранч Бургер", 50f},
                {"Мини бургер", 35f}
        };
    }

    @Test
    public void getName() {
        // Создаем объект
        Bun bun = new Bun(expectedName, expectedPrice);
        Assert.assertEquals("Вернулось не правильное имя", expectedName, bun.getName());
    }

    @Test
    public void getPrice() {
        // Создаем объект
        Bun bun = new Bun(expectedName, expectedPrice);
        Assert.assertEquals("Вернулось не правильная цена", expectedPrice, bun.getPrice(), 0.01f);
    }
}