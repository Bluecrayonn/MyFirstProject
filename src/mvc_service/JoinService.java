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
	 *Ư�� �̸��� �ּҷ� ����Ű�� ������ ����� ������]
	 * java �� mail api �� ����ϸ� ���� �ذ��� �� �ִ�.
	
	 */
	public boolean sendAuthEmail(String email) {
		
		String[] keys=UUID.randomUUID().toString().split("-");
		String serial=keys[0]+keys[1];

		MimeMessage msg=sender.createMimeMessage();
		try {
			msg.addRecipients(RecipientType.TO, email);
			msg.setSubject("����Ű�ǹ߼��ΰŽŰ�");
			msg.setText("�̰Ž� �׷��Ѱ�����Ű�ΰŽŰ�"+serial,"UTF-8");		
			sender.send(msg);
			return true;
			
		} catch (MessagingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}

}
