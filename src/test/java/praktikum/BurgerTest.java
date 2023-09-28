package praktikum;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.times;

@RunWith(MockitoJUnitRunner.class)
public class BurgerTest {
    @Mock
    Bun bun;
    @Mock
    Ingredient ingredient1;
    @Mock
    Ingredient ingredient2;
    @Mock
    Ingredient ingredient3;

    @Test
    public void getPriceTest() {
        Mockito.when(bun.getPrice()).thenReturn(Float.valueOf(50));
        Mockito.when(ingredient1.getPrice()).thenReturn(Float.valueOf(100));
        Mockito.when(ingredient2.getPrice()).thenReturn(Float.valueOf(150));
        Mockito.when(ingredient3.getPrice()).thenReturn(Float.valueOf(120));

        Burger burger = new Burger();
        burger.setBuns(bun);
        burger.addIngredient(ingredient1);
        burger.addIngredient(ingredient2);
        burger.addIngredient(ingredient3);

        float price = burger.getPrice();

        Mockito.verify(bun).getPrice();
        Mockito.verify(ingredient1).getPrice();
        Mockito.verify(ingredient2).getPrice();
        Mockito.verify(ingredient3).getPrice();
        assertEquals(470, price, 0);
    }

    @Test
    public void getReceiptTest() {
        Mockito.when(bun.getPrice()).thenReturn(Float.valueOf(50));
        Mockito.when(bun.getName()).thenReturn("Вкусная булка");
        Mockito.when(ingredient1.getPrice()).thenReturn(Float.valueOf(100));
        Mockito.when(ingredient1.getType()).thenReturn(IngredientType.SAUCE);
        Mockito.when(ingredient1.getName()).thenReturn("Поливочка");
        Mockito.when(ingredient2.getPrice()).thenReturn(Float.valueOf(150));
        Mockito.when(ingredient2.getType()).thenReturn(IngredientType.FILLING);
        Mockito.when(ingredient2.getName()).thenReturn("Котлетка");

        Burger burger = new Burger();
        burger.setBuns(bun);
        burger.addIngredient(ingredient1);
        burger.addIngredient(ingredient2);

        String actualReceipt = burger.getReceipt();
        Mockito.verify(bun).getPrice();
        Mockito.verify(bun, times(2)).getName();
        Mockito.verify(ingredient1).getPrice();
        Mockito.verify(ingredient1).getName();
        Mockito.verify(ingredient1).getType();
        Mockito.verify(ingredient2).getPrice();
        Mockito.verify(ingredient2).getName();
        Mockito.verify(ingredient2).getType();
        assertEquals("(==== Вкусная булка ====)\n" +
                "= sauce Поливочка =\n" +
                "= filling Котлетка =\n" +
                "(==== Вкусная булка ====)\n" +
                "\n" +
                "Price: 350,000000\n", actualReceipt);
    }
}
