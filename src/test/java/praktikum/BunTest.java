package praktikum;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class BunTest {

    @Test
    public void getNameTest() {
        Bun bun = new Bun("Вкусная булка", 50);
        assertEquals("Вкусная булка", bun.getName());
    }

    @Test
    public void getPriceTest() {
        Bun bun = new Bun("Вкусная булка", 50);
        assertEquals(50, bun.getPrice(), 0);
    }
}
