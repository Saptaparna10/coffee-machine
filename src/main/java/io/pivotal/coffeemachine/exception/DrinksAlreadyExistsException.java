package io.pivotal.coffeemachine.exception;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * This is a custom exception
 * @author saptaparnadas
 *
 */
public class DrinksAlreadyExistsException extends Exception{

	private final static Logger LOGGER = Logger.getLogger(DrinksAlreadyExistsException.class.getName());

	private static final long serialVersionUID = 1L;
	
	public DrinksAlreadyExistsException(String message) {
		super(message);
		LOGGER.log(Level.WARNING, message);
	}

}
