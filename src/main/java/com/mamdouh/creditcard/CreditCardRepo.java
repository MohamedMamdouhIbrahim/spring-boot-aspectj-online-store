package com.mamdouh.creditcard;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CreditCardRepo extends JpaRepository<CreditCard,Long>
{
	CreditCard findByCardholder(String cardholder);
	
	CreditCard save(CreditCard creditCard);

}
