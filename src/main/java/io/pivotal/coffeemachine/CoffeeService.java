package io.pivotal.coffeemachine;

import java.util.*;

public class CoffeeService {

	private Inventory inventory;
	private Map<String, Double> menu;
	private Map<String, Map<String, Integer>> coffeeComponents;

	public CoffeeService(Inventory inventory) {
		this.inventory = inventory;
		this.menu = new HashMap<>();
		coffeeComponents = new HashMap<>();

		menu.put("coffee", 2.75);
		menu.put("cappuccino", 2.90);
		menu.put("caffe mocha", 3.90);

		Map<String, Integer> ingredients = null;
		
		ingredients = new HashMap<>();

		ingredients.put("coffee", 2);
		ingredients.put("sugar", 1);

		coffeeComponents.put("coffee", ingredients);
		
		ingredients = new HashMap<>();

		ingredients.put("coffee", 2);
		ingredients.put("sugar", 1);
		ingredients.put("cream", 2);

		coffeeComponents.put("cappuccino", ingredients);

		ingredients = new HashMap<>();

		ingredients.put("coffee", 1);
		ingredients.put("sugar", 1);
		ingredients.put("cream", 1);

		coffeeComponents.put("caffe mocha", ingredients);
	}

	/**
	 * Returns the menu for this coffee machine.
	 *
	 * @return a map of drink name to drink cost
	 */
	public Map<String, Double> getMenu() {
		return menu;
	}

	/**
	 * Make a drink using the given name. Ingredients for the drink are deducted from the inventory.
	 *
	 * @param name the name of the drink
	 */
	public Drink makeDrink(String name) {
		
		Drink drink=null;
		if(menu.containsKey(name)) {
			Map<String, Integer> requiredIngredients = coffeeComponents.get(name);

			for (Map.Entry<String, Integer> ingredient : requiredIngredients.entrySet()) {
				inventory.deduct(ingredient.getKey(), ingredient.getValue());
			}

			drink = new Drink();
			drink.setName(name);
			drink.setIngredients(requiredIngredients);
			
		}
		return drink;
	}
	
	public void addDrinkToMenu(Drink drink) {

		coffeeComponents.put(drink.getName().toLowerCase(), drink.getIngredients());
		menu.put(drink.getName().toLowerCase(), drink.getCost());

	}
}
