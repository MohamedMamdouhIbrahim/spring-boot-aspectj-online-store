package com.mamdouh.registration.tocken;

import java.time.LocalDateTime;
import java.util.Optional;

import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class ConfirmationTockenService {
	
	private ConfirmatonTockenRepo confirmatonTockenRepo;
	public void saveConfirmationTocken(ConfirmationTocken confirmationTocken) 
	{
		confirmatonTockenRepo.save(confirmationTocken);
	}
	  public Optional<ConfirmationTocken> getToken(String token) {
	        return confirmatonTockenRepo.findByTocken(token);
	    }

	    public int setConfirmedAt(String token) {
	        return confirmatonTockenRepo.updateConfirmedAt(
	                token, LocalDateTime.now());
	    }
}
