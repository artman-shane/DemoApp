package com.artman;

import java.util.HashMap;

/**
 * Purpose: this is the application controller that orchestrates the operation
 * 			for this arithmetic application
 * @author artieman1
 *
 */
public class ApplicationController {

	/* 
	 * The HashMap will be used to store the operation value supplied
	 * from the calling web-page to the implemented interface
	 */
	private HashMap<String, Handler> handlerMap = new HashMap(); 

	/**
	 * Purpose: the handleRequest method is passed the command to apply and
	 * 			two values of type float to operate on.
	 * 
	 * @param String - the value that is returned from the checkboxes in the webpage
	 * @param float - the first value to operate on returned from the webpage
	 * @param float - the second value to operate on returned from the webpage
	 * @return float - the returned value to the calling method for presentation
	 * 					into the webpage
	 */
	public float handleRequest(String command, float _num1, float _num2) {
		Handler aCommandHandler = handlerMap.get(command);
		
		// Valid result muse have been found in the hashmap
		if (aCommandHandler != null) {
			return (float) aCommandHandler.handleIt(_num1, _num2);
		}
		return 0;
	}
	
	/**
	 * Purpose: used to map values between the operand and the implemented interface
	 * 			method
	 * 
	 * @param String - the key that is used to provide the mapping from the checkboxes (value)
	 * 					to the name of the implemented interface (method).
	 * @param Handler - the interface that provides the framework for the implemented operate
	 * 					methods. 
	 */
	public void mapCommand(String aCommand, Handler acHandler) {
		handlerMap.put(aCommand, acHandler);
	}
}
