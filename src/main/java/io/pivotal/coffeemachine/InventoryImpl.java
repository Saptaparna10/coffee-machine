package io.pivotal.coffeemachine;

import java.util.*;

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

	public void deduct(String name, Integer amount) {
		if(ingredients.containsKey(name)) {
			if(ingredients.get(name) >= amount) {
				ingredients.put(name, ingredients.get(name)-amount);
			}
		}
	}

}
