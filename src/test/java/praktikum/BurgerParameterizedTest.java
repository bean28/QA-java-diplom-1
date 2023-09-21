package praktikum;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.List;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class BurgerParameterizedTest {
    static Database database = new Database();
    Bun bun;
    List<Ingredient> ingredients;
    float price;
    String receipt;

    public BurgerParameterizedTest(Bun bun, List<Ingredient> ingredient, float price, String receipt) {
        this.ingredients = ingredient;
        this.bun = bun;
        this.price = price;
        this.receipt = receipt;
    }

    @Parameterized.Parameters(name = "Состав бургера: {0} {1} {2} {3}")
    public static Object[][] parametersOfBurger() {
        return new Object[][]{
                {database.availableBuns().get(0),
                        List.of(database.availableIngredients().get(1), database.availableIngredients().get(3)),
                        500,
                        "(==== black bun ====)\n" +
                        "= sauce sour cream =\n" +
                        "= filling cutlet =\n" +
                        "(==== black bun ====)\n" +
                        "\n" +
                        "Price: 500,000000\n"},
                {database.availableBuns().get(1),
                        List.of(database.availableIngredients().get(2), database.availableIngredients().get(4)),
                        900,
                        "(==== white bun ====)\n" +
                        "= sauce chili sauce =\n" +
                        "= filling dinosaur =\n" +
                        "(==== white bun ====)\n" +
                        "\n" +
                        "Price: 900,000000\n"},
                {database.availableBuns().get(2),
                        List.of(database.availableIngredients().get(1), database.availableIngredients().get(2)),
                        1100,
                        "(==== red bun ====)\n" +
                        "= sauce sour cream =\n" +
                        "= sauce chili sauce =\n" +
                        "(==== red bun ====)\n" +
                        "\n" +
                        "Price: 1100,000000\n"}
        };
    }

    @Test
    public void getPriceTest() {
        Burger burger = new Burger();
        burger.setBuns(bun);

        for (Ingredient ingredient : ingredients) {
            burger.addIngredient(ingredient);
        }

        float actualPrice = burger.getPrice();
        assertEquals(price, actualPrice, 0);
    }

    @Test
    public void getReceiptTest() {
        Burger burger = new Burger();
        burger.setBuns(bun);

        for (Ingredient ingredient : ingredients) {
            burger.addIngredient(ingredient);
        }

        String actualReceipt = burger.getReceipt();
        assertEquals(receipt, actualReceipt);
    }
}
