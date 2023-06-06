package shop.myshop.service;

import java.io.UnsupportedEncodingException;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;


public interface MailServiceInter {

	// 메일 작성
	MimeMessage createMessage(String to) throws MessagingException, UnsupportedEncodingException;
	

	// 랜덤 인증 
	String createKey();

	// 메일 발송
	String sendSimpleMessage(String to) throws Exception;
}
