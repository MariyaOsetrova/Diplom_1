package praktikum;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class BurgerTest {
    @Mock
    Bun bunMegaBig;
    @Mock
    Ingredient ingredientFilling;
    @Mock
    Ingredient ingredientSauce;

    @Test
    public void setBuns() {
        Burger burger = new Burger();
        burger.setBuns(bunMegaBig);
        assertEquals(bunMegaBig.getName(), burger.bun.getName());
    }

    @Test
    public void removeIngredient() {
        Burger burger = new Burger();
        //добавляем ингридиент - начинку
        burger.addIngredient(ingredientFilling);
        //удаляем ингридиент
        burger.removeIngredient(0);
        //проверяем есть ли ингридиент
        assertTrue(burger.ingredients.isEmpty());
    }

    @Test
    public void moveIngredient() {
        Burger burger = new Burger();
        //добавляем ингридиенты
        burger.addIngredient(ingredientFilling);
        burger.addIngredient(ingredientSauce);
        //меняем местами
        burger.moveIngredient(0, 1);
        assertEquals("Не верный индекс у ингридиента", ingredientFilling, burger.ingredients.get(1));
        assertEquals("Не верный индекс у ингридиента", ingredientSauce, burger.ingredients.get(0));
    }

    @Test
    public void getPrice() {
        Burger burger = new Burger();
        when(bunMegaBig.getPrice()).thenReturn(150f);
        burger.setBuns(bunMegaBig);
        when(ingredientFilling.getPrice()).thenReturn(50f);
        burger.addIngredient(ingredientFilling);
        assertEquals("Не верная цена", 350f, burger.getPrice(), 0.01);

    }

    @Test
    public void getReceipt() {
        Burger burger = new Burger();
        burger.setBuns(bunMegaBig);
        burger.addIngredient(ingredientFilling);
        burger.addIngredient(ingredientSauce);
        when(bunMegaBig.getName()).thenReturn("большая булка");
        when(ingredientSauce.getName()).thenReturn("сырный соус");
        when(ingredientFilling.getName()).thenReturn("куринная котлета");
        when(ingredientSauce.getType()).thenReturn(IngredientType.SAUCE);
        when(ingredientFilling.getType()).thenReturn(IngredientType.FILLING);
        when(bunMegaBig.getPrice()).thenReturn(50f);
        when(ingredientSauce.getPrice()).thenReturn(50f);
        when(ingredientFilling.getPrice()).thenReturn(100f);
        String expectedReceipt = String.format("(==== большая булка ====)%n"
                + ("= filling куринная котлета =%n")
                + ("= sauce сырный соус =%n")
                + "(==== большая булка ====)%n"
                + "%n" + "Price: 250,000000%n");
        assertEquals("Не верый чек", expectedReceipt, burger.getReceipt());

    }
}