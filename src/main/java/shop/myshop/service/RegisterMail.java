package shop.myshop.service;

import java.io.UnsupportedEncodingException;
import java.util.Random;

import javax.mail.MessagingException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMessage.RecipientType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class RegisterMail implements MailServiceInter  {

	@Autowired
	JavaMailSender emailsender; 

	private String authCode; 

	@Override
	public MimeMessage createMessage(String to) throws MessagingException, UnsupportedEncodingException {

	    MimeMessage message = emailsender.createMimeMessage();
	    message.addRecipients(RecipientType.TO, to);
	    message.setSubject("200OK 회원가입 이메일 인증");

	    StringBuilder emailMsg = new StringBuilder();
	    emailMsg.append("<div style='background-color: #f2f2f2; padding: 20px; font-family: Arial, sans-serif;'>")
	            .append("<div style='max-width: 600px; margin: 0 auto; padding: 40px; background-color: white; border: 1px solid #eaeaea;'>")
	            .append("<h3 style='color: #7a7f80; margin-top: 0;'>회원가입 인증 코드</h3>")
	            .append("<div style='font-size: 16px;'>")
	            .append("<p>아래 인증 코드를 회원가입 페이지에 입력해주세요.</p>")
	            .append("<p style='font-size: 24px; font-weight: bold; padding: 20px 0;'>" + authCode + "</p>")
	            .append("<p style='font-size: 14px; color: #6c757d;'>본 이메일은 발신 전용입니다. 문의사항은 고객센터로 문의해주세요.</p>")
	            .append("</div>")
	            .append("</div>")
	            .append("</div>");


	    String msg = emailMsg.toString();
	    message.setText(msg, "utf-8", "html");
	    message.setFrom(new InternetAddress("발신인 이메일", "200OK_Admin"));

	    return message;
	}

	// 랜덤 인증 
	@Override
	public String createKey() {
	    StringBuilder key = new StringBuilder();
	    Random rnd = new Random();
	    final String CHARS = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";

	    for (int i = 0; i < 6; i++) {
	        int index = rnd.nextInt(CHARS.length());
	        char c = CHARS.charAt(index);
	        key.append(c);
	    }

	    return key.toString();
	}


	// 발송
	@Override
	public String sendSimpleMessage(String to) throws Exception {

		authCode = createKey(); 

		MimeMessage message = createMessage(to); 
		try {
			emailsender.send(message);
		} catch (MailException e) {
			e.printStackTrace();
			throw new IllegalArgumentException();
		}


		return authCode; 
	}
}
