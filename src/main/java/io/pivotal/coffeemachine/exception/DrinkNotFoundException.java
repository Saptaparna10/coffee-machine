package io.pivotal.coffeemachine.exception;

import java.util.logging.Level;
import java.util.logging.Logger;

public class DrinkNotFoundException extends Exception{
	
	private final static Logger LOGGER = Logger.getLogger(DrinkNotFoundException.class.getName());

	private static final long serialVersionUID = 1L;
	
	public DrinkNotFoundException(String message) {
		super(message);
		LOGGER.log(Level.WARNING, message);
	}
}
