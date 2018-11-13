package io.pivotal.coffeemachine;

import java.util.*;

import org.junit.Before;
import org.junit.Test;

import io.pivotal.coffeemachine.exception.DrinkNotFoundException;
import io.pivotal.coffeemachine.exception.IngredientNotFoundException;
import io.pivotal.coffeemachine.exception.OutOfStockException;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.entry;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

/**
 * Tests for {@link CoffeeService}.
 */
public class CoffeeServiceTests {

	private CoffeeService machine;

	private Inventory inventory;

	@Before
	public void setUp() {
		this.inventory = mock(Inventory.class);
		this.machine = new CoffeeService(this.inventory);
	}

	@Test
	public void getMenu() {
		Map<String, Double> menu = this.machine.getMenu();
		assertThat(menu).contains(entry("coffee", 2.75));
		assertThat(menu).contains(entry("cappuccino", 2.90));
		assertThat(menu).contains(entry("caffe mocha", 3.90));
	}

	@Test
	public void makeDrink() throws IngredientNotFoundException, OutOfStockException, DrinkNotFoundException {
		this.machine.makeDrink("cappuccino");
		verify(this.inventory).deduct("coffee", 2);
		verify(this.inventory).deduct("sugar", 1);
		verify(this.inventory).deduct("cream", 2); //changed as per README
	}
	
	@Test(expected=DrinkNotFoundException.class)
	public void makeDrinkShouldThrowException() throws IngredientNotFoundException, OutOfStockException, DrinkNotFoundException {
		this.machine.makeDrink("americano");
		verify(this.inventory).deduct("coffee", 2);
		verify(this.inventory).deduct("sugar", 1);
	}
	
	@Test
	public void addDrinkToMenu() {
		
		Map<String, Double> menu = this.machine.getMenu();
		Drink d = new Drink();
		d.setName("macchiato");
		d.setCost(3.55);
		
		Map<String, Integer> ingredient = new HashMap<String, Integer>();
		ingredient.put("coffee", 3);
		ingredient.put("sugar", 2);
		ingredient.put("cream", 1);
		d.setIngredients(ingredient);
		machine.addDrinkToMenu(d);
		
		assertThat(menu).contains(entry("macchiato", 3.55));
	}

}