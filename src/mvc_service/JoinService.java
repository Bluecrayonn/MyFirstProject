package mvc_service;

import java.util.UUID;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMessage.RecipientType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class JoinService {
	@Autowired
	JavaMailSender sender;
	
	/*
	 *특정 이메일 주소로 인증키를 보내는 기능을 만들자]
	 * java 에 mail api 를 사용하면 쉽게 해결할 수 있다.
	
	 */
	public boolean sendAuthEmail(String email) {
		
		String[] keys=UUID.randomUUID().toString().split("-");
		String serial=keys[0]+keys[1];

		MimeMessage msg=sender.createMimeMessage();
		try {
			msg.addRecipients(RecipientType.TO, email);
			msg.setSubject("인증키의발송인거신것");
			msg.setText("이거슨 그러한것인증키인거신것"+serial,"UTF-8");		
			sender.send(msg);
			return true;
			
		} catch (MessagingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}

}
