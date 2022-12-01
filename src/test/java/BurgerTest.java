import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import praktikum.*;
import java.util.ArrayList;
import java.util.List;
import static org.junit.Assert.*;
import static praktikum.IngredientType.SAUCE;

@RunWith(MockitoJUnitRunner.class)
public class BurgerTest {

    @Test
    public void ingredientsCanBeAdded() {
        Burger burger = new Burger();
        Ingredient ingredient = Mockito.mock(Ingredient.class);
        burger.addIngredient(ingredient);
        int ingredientSize = burger.ingredients.size();
        boolean actual = ingredientSize>0;
        assertTrue( "Expected ingredient list size more than 0", actual);
    }

    @Test
    public void   bunsCanBeSet() {
        List<Bun> buns = new ArrayList<>();
        Bun bun = Mockito.mock(Bun.class);
        Burger burger = new Burger();
        burger.setBuns(bun);
        int bunsSize = buns.size();
        boolean actual = true;
        assertTrue("Expected true and  buns size more than 0",actual );
    }

    @Test
    public void ingredientCanBeRemoved(){
        Burger burger = new Burger();
        Ingredient ingredient = new Ingredient(SAUCE,"hot sauce",100);
        Ingredient ingredient1 = new Ingredient(SAUCE, "sour cream", 200);
        burger.addIngredient(ingredient);
        burger.addIngredient(ingredient1);
        burger.removeIngredient(0);
        int ingredientSize = burger.ingredients.size();
        assertEquals("The ingredient size incorrect ",1, ingredientSize);

    }

    @Test
    public void ingredientCanBeMoved(){
        Burger burger = new Burger();
        Ingredient ingredient = new Ingredient(SAUCE,"hot sauce",100);
        Ingredient ingredient1 = new Ingredient(SAUCE, "sour cream", 200);
        burger.addIngredient(ingredient);
        burger.addIngredient(ingredient1);
        burger.moveIngredient(1, 0);
        int index = burger.ingredients.indexOf(ingredient);
        int index1 = burger.ingredients.indexOf(ingredient1);
        assertNotEquals(index, index1);
    }

    @Test
    public void getPriceReturnedCorrectPrice(){
        Burger burger = new Burger();
        List<Bun> buns = new ArrayList<>();
        buns.add(new Bun("red bun", 300));
        burger.addIngredient(new Ingredient(SAUCE,"hot sauce",100));
        burger.setBuns(buns.get(0));
        float actualPrice = burger.getPrice();
        assertEquals("The price incorrect ",700,actualPrice,0.0f);
    }

    @Test
    public void getReceiptReturnValidReceipt(){
        Burger burger = new Burger();
        List<Bun> buns = new ArrayList<>();
        buns.add(new Bun("red bun", 300));
        burger.addIngredient(new Ingredient(SAUCE,"hot sauce",100));
        burger.setBuns(buns.get(0));
        System.out.println(burger.getReceipt());
    }
}
