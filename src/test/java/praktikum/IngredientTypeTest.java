package praktikum;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class IngredientTypeTest {

    @Test
    public void getSauceTypeTest() {
        assertEquals(IngredientType.valueOf("SAUCE"), IngredientType.SAUCE);
    }

    @Test
    public void getFillingTypeTest() {
        assertEquals(IngredientType.valueOf("FILLING"), IngredientType.FILLING);
    }

}
