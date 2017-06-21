package com.sis;

public class FootballTeamException extends Exception{

	private String errorMessage;
	 
	public String getErrorMessage() {
		return errorMessage;
	}
	public FootballTeamException(String errorMessage) {
		super(errorMessage);
		this.errorMessage = errorMessage;
	}
	
}
