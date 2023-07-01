package com.mamdouh.user;

import java.time.LocalDateTime;
import java.util.UUID;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.mamdouh.registration.EmailValidator;
import  com.mamdouh.registration.tocken.ConfirmationTocken;
import com.mamdouh.registration.tocken.ConfirmationTockenService;

import lombok.AllArgsConstructor;


@Service
@AllArgsConstructor
public class ApplicationUserService implements UserDetailsService {

	private  UserRepo userRepo;
	private EmailValidator e;
	private BCryptPasswordEncoder bCryptPasswordEncoder;
	private ConfirmationTockenService confirmationTockenService;
	
	private final static String USER_NOT_FOUND =
			"user with email %s not found";
	
	public ApplicationUserService(UserRepo userRepo) {
		
		this.userRepo = userRepo;
	}
	
	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		return userRepo.findByEmail(email).orElseThrow(() ->
		new UsernameNotFoundException(String.format(USER_NOT_FOUND,email))
				
				);
	}

	
	public String signUpUser(AppUser appUser) 
	{
		boolean userExists = userRepo.findByEmail(appUser.getEmail()).isPresent();
		if(userExists) 
		{
			throw new IllegalStateException("email already taked");
		}
		String encodedPassword = bCryptPasswordEncoder.encode(appUser.getPassword());
		appUser.setPassword(encodedPassword);
		userRepo.save(appUser);
		
		String token = UUID.randomUUID().toString();
		ConfirmationTocken confirmationTocken = new ConfirmationTocken(
				token,
				LocalDateTime.now()
				,LocalDateTime.now().plusMinutes(15),appUser);
		confirmationTockenService.saveConfirmationTocken(confirmationTocken);
		return token;
	}
	 public int enableAppUser(String email) {
	        return userRepo.enableAppUser(email);
	    }
	 
	 public void updateUserName(AppUser appUser,String firstname, String lastname,String email) 
	 { 
		 if(firstname!=null) {
			 appUser.setFirstName(firstname);
			 }
		 if(lastname!=null)
		 {
			 appUser.setLastname(lastname);
		 }
		 if((email!=null)&& e.test(email)) 
		 {
			 appUser.setEmail(email);
		 }
		 
	 }
	
	
}
