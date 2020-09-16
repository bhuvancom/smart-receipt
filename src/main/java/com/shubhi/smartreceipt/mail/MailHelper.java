package com.shubhi.smartreceipt.mail;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;

public class MailHelper {

	@Autowired
	private JavaMailSender javaMailSender;

	public void sendMail(String to, String text) {
		SimpleMailMessage message = new SimpleMailMessage();
		message.setFrom("smart-receipt@noreply.com");
		message.setTo(to);
		message.setSubject("Message test");
		message.setText(text);
		javaMailSender.send(message);
	}
}
