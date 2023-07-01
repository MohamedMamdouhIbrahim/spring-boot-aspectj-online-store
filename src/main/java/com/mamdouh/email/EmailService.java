package com.mamdouh.email;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import lombok.AllArgsConstructor;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.scheduling.annotation.Async;
@Service
@AllArgsConstructor
public class EmailService  implements EmailSender{
	 private final static Logger LOGGER = LoggerFactory
	            .getLogger(EmailService.class);
	
	@Autowired
	private  JavaMailSender javaMailSender;//there may be a problem here bacause we are making autowiring and no raal bean exists

	@Override
	@Async
	public void send(String to, String email) {
		   try {
	            MimeMessage mimeMessage = javaMailSender.createMimeMessage();
	            MimeMessageHelper helper =
	                    new MimeMessageHelper(mimeMessage, "utf-8");
	            helper.setText(email, true);
	            helper.setTo(to);
	            helper.setSubject("Confirm your email");
	            helper.setFrom("hello@amigoscode.com");
	            javaMailSender.send(mimeMessage);
	        } catch (MessagingException e) {
	            LOGGER.error("failed to send email", e);
	            throw new IllegalStateException("failed to send email");
	        }
	}

}
