package io.pivotal.coffeemachine;

import org.junit.Test;

import io.pivotal.coffeemachine.exception.IngredientNotFoundException;
import io.pivotal.coffeemachine.exception.OutOfStockException;

public class InventoryImplTests extends InventoryTests {

	@Override
	protected Inventory getInventory() {
		return new InventoryImpl();
	}

	@Test(expected=OutOfStockException.class)
	public void deductShouldThrowOutOfStockException() throws OutOfStockException, IngredientNotFoundException {
		Inventory inventory = getInventory();
		inventory.deduct("coffee", 11);
	}
	
	@Test(expected=IngredientNotFoundException.class)
	public void deductShouldThrowIngredientNotFoundException() throws IngredientNotFoundException, OutOfStockException {
		Inventory inventory = getInventory();
		inventory.deduct("coke", 1);
	}
}
