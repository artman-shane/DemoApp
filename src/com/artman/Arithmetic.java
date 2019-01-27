package com.artman;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Purpose: This is the application that receives the post from the webpage and
 * 			passes the attributes into the interface (handler).
 * 
 * @author artieman1
 *
 */
public class Arithmetic extends HttpServlet {

	private ApplicationController theAppController = new ApplicationController();
	private String command;
	
	/**
	 * Purpose: runs the first time the application runs. Used to construct the
	 * 			hashmap. The key is the "value" of the checkboxes
	 */
	public void init() {
		theAppController.mapCommand("add", new MathAdd());
		theAppController.mapCommand("multiply", new MathMultiply());
		theAppController.mapCommand("divide", new MathDivide());
		theAppController.mapCommand("subtract", new MathSubtract());
	}
	
	/**
	 * Purpose: this is called when the post method calls it from tomcat.
	 * 
	 * @param HttpServletRequest
	 * @param HttpServletResponse
	 * 
	 */
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException {
		
		// parsing float value from string in the parameter
		float num1 = Float.parseFloat(req.getParameter("num1"));
		float num2 = Float.parseFloat(req.getParameter("num2"));
		
		// parsing the operation request from the webpage
		command = req.getParameter("operation");
		
		// float is returned as the result from the operation after handling the request 
		// through the application controller.
		float result = theAppController.handleRequest(command, num1, num2);
		
		// Returns the result to the webpage to be displayed
		PrintWriter out = res.getWriter();
		out.println("The result it: " + result);
		
		
	}
}
