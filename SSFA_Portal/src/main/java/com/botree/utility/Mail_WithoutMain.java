package com.botree.utility;

import java.util.Properties;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

public class Mail_WithoutMain {

	
	public void Create() {
		final String username = "hariram27091997@gmail.com";
	    final String password = "hzgscspwzjugyidv";
	    String fromMail = "hariram27091997@gmail.com";
	    String ToMail = "balavb0927@gmail.com";

	    Properties props = new Properties();
	    props.put("mail.smtp.auth", "true");
	    props.put("mail.smtp.starttls.enable", "true");
	    props.put("mail.smtp.host", "smtp.office365.com");
	    props.put("mail.smtp.port", "587");

	    Session session = Session.getInstance(props,
	            new javax.mail.Authenticator() {
	                protected PasswordAuthentication getPasswordAuthentication() {
	                    return new PasswordAuthentication(username, password);
	                }
	            });

	    Message message = new MimeMessage(session);
	    
	    try {
	    	
	    	message.setFrom(new InternetAddress(fromMail));
	    	message.addRecipient(Message.RecipientType.TO, new InternetAddress(ToMail));
	    	message.setSubject("Report");
	        message.setText("PFA");
	       
	       
	        MimeBodyPart messageBodyPart = new MimeBodyPart();

	        Multipart multipart = new MimeMultipart();

	        messageBodyPart = new MimeBodyPart();
	        String file = "C:\\Users\\balaji.vijayakumar\\SSFA_New-02-02\\Qng_SSFA_SaaS\\test-output\\ExtentReports\\Report.html";
	        String fileName = "emailable-report.html";
	        DataSource source = new FileDataSource(file);
	        messageBodyPart.setDataHandler(new DataHandler(source));
	        messageBodyPart.setFileName(fileName);
	        multipart.addBodyPart(messageBodyPart);

	        message.setContent(multipart);

	        System.out.println("Sending");

	        Transport.send(message);

	        System.out.println("Done");

	    } catch (MessagingException e) {
	        e.printStackTrace();
	    }
	    
	   
	}
	public static void main(String[] args) {
	
		Mail_WithoutMain without = new Mail_WithoutMain();
		without.Create();
	}
}
