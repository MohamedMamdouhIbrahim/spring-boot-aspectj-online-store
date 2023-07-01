package com.mamdouh.registration;

import java.util.function.Predicate;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.stereotype.Service;


@Service
public class EmailValidator implements Predicate<String> {

	@Override
	public boolean test(String t) {
		// TODO Auto-generated method stub
	    // Regex pattern for email validation
	    String regex = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}$";
	    // Compile the pattern
	    Pattern pattern = Pattern.compile(regex);
	    // Match the email against the pattern
	    Matcher matcher = pattern.matcher(t);
	    return matcher.matches();
	}

}
