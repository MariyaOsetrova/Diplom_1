package praktikum;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

@RunWith(Parameterized.class)
public class IngredientTest {

    private final IngredientType expectedType;
    private final String expectedName;
    private final float expectedPrice;

    public IngredientTest(IngredientType expectedType, String expectedName, float expectedPrice) {
        this.expectedType = expectedType;
        this.expectedName = expectedName;
        this.expectedPrice = expectedPrice;

    }

    @Parameterized.Parameters(name = "{index}. Название: {0}, цена: {1}, тип: {2}")
    public static Object[][] data() {
        return new Object[][]{
                {IngredientType.FILLING, "Ранч Бургер", 50f},
                {IngredientType.SAUCE, "Мини бургер", 35f}
        };
    }

    @Test
    public void getPrice() {
        Ingredient ingredient = new Ingredient(expectedType, expectedName, expectedPrice);
        Assert.assertEquals("Вернулась не правильная цена", expectedPrice, ingredient.getPrice(), 0.01f);
    }

    @Test
    public void getName() {
        Ingredient ingredient = new Ingredient(expectedType, expectedName, expectedPrice);
        Assert.assertEquals("Вернулось не правильное имя", expectedName, ingredient.getName());
    }

    @Test
    public void getType() {
        Ingredient ingredient = new Ingredient(expectedType, expectedName, expectedPrice);
        Assert.assertEquals("Вернулся не правильный тип", expectedType, ingredient.getType());
    }
}