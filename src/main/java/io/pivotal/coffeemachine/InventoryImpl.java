package io.pivotal.coffeemachine;

import java.util.*;

import io.pivotal.coffeemachine.exception.IngredientNotFoundException;
import io.pivotal.coffeemachine.exception.OutOfStockException;

public class InventoryImpl implements Inventory {

	private Map<String, Integer> ingredients;

	public InventoryImpl() {
		ingredients = new HashMap<>();
		ingredients.put("coffee", 10);
		ingredients.put("cream", 10);
		ingredients.put("sugar", 10);
	}

	public Map<String, Integer> getIngredients() {
		return this.ingredients;
	}

	public void deduct(String name, Integer amount) throws IngredientNotFoundException, OutOfStockException {
		
		if(!ingredients.containsKey(name))
			throw new IngredientNotFoundException("Ingredient " + name +" is not found");
		else if(ingredients.get(name) < amount)
			throw new OutOfStockException(name + " is out of stock");
		else {
			ingredients.put(name, ingredients.get(name)-amount);
		}
	}

}
