package com.mamdouh.creditcard;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class CreditCard {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	Long id;
	String Card_number;
	String Cardholder;
	String Expiration;
	String Security_code;
	String Issuer; // - A string representing the name of the credit card issuer (e.g. Visa, Mastercard, etc.).
	Type type; //- An enumeration representing the type of credit card (e.g. credit, debit, prepaid).
	float balance;// - A decimal representing the current balance on the card.
	public String getCard_number() {
		return Card_number;
	}
	public void setCard_number(String card_number) {
		Card_number = card_number;
	}
	public String getCardholder() {
		return Cardholder;
	}
	public void setCardholder(String cardholder) {
		Cardholder = cardholder;
	}
	public String getExpiration() {
		return Expiration;
	}
	public void setExpiration(String expiration) {
		Expiration = expiration;
	}
	public String getSecurity_code() {
		return Security_code;
	}
	public void setSecurity_code(String security_code) {
		Security_code = security_code;
	}
	public String getIssuer() {
		return Issuer;
	}
	public void setIssuer(String issuer) {
		Issuer = issuer;
	}
	public Type getType() {
		return type;
	}
	public void setType(Type type) {
		this.type = type;
	}
	public float getBalance() {
		return balance;
	}
	public void setBalance(float balance) {
		this.balance = balance;
	}


	
	
	
	
}
