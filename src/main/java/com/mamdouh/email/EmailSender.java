package com.mamdouh.email;

public interface EmailSender {
	
	public void send(String to, String email) throws IllegalStateException;


}
