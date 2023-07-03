package com.qa.apple.test.automation.exceptions;

public class AppleException extends Throwable {
	
private static final long serialVersionUID = 1L;
	
	public static String failureMessage = "";
	
	public AppleException(String message)
	{
		super(message);
		
		failureMessage = message;
		
	}

}
