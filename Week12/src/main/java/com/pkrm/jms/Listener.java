package com.pkrm.jms;

import java.io.IOException;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.pkrm.Dao.PersonDao;
import com.pkrm.Dao.PersonDaoImpl;
import com.pkrm.personPojo.JsonToJava;
import com.pkrm.personPojo.JsonToJavaPojo;

public class Listener implements MessageListener {

	public void onMessage(Message message) {
		ApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
		PersonDao personDao = (PersonDaoImpl) context.getBean(PersonDaoImpl.class);

		try {
			if (message instanceof TextMessage) {
				TextMessage textMessage = (TextMessage) message;
				System.out.println("Received message '" + textMessage.getText() + "'");
				JsonToJava jsonMapper = new JsonToJava();
				try {
					JsonToJavaPojo javaObject = jsonMapper.json(textMessage.getText());
					personDao.addUser(javaObject);

				} catch (IOException e) {

					e.printStackTrace();
				}
			}
		} catch (JMSException e) {
			e.printStackTrace();
		}

	}

	public static void main(String[] args) throws InterruptedException {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("jmsContext.xml");
		Thread.sleep(1000);
		context.close();

	}
}
