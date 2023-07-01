package com.mamdouh.creditcard;

import org.springframework.stereotype.Service;

import com.mamdouh.product.Item;

@Service
public class CreditCardservice {
	
	private CreditCardRepo repo;
	
	void pay(CreditCard c,Item i,CreditCard t) {
		
		if(c.getBalance()>i.getPrice()) {
			
			c.setBalance(c.getBalance()-i.getPrice());
			t.setBalance(t.getBalance()+i.getPrice());
			repo.save(c);
			repo.save(t);
		}
		else throw new IllegalArgumentException("you don't have enough amount!");
	}

}
