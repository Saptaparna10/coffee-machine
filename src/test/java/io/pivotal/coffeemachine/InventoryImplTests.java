package io.pivotal.coffeemachine;

public class InventoryImplTests extends InventoryTests {

	@Override
	protected Inventory getInventory() {
		return new InventoryImpl();
	}

}
