package io.pivotal.coffeemachine.exception;

import java.util.logging.Level;
import java.util.logging.Logger;

public class IngredientNotFoundException extends Exception {

	private final static Logger LOGGER = Logger.getLogger(IngredientNotFoundException.class.getName());

	private static final long serialVersionUID = 1L;

	public IngredientNotFoundException(String message) {
		super(message);
		LOGGER.log(Level.WARNING, message);
	}
}
