package com.pkrm.jms;

import java.io.IOException;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;

import org.apache.log4j.Logger;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.pkrm.Dao.PersonDao;
import com.pkrm.Dao.PersonDaoImpl;
import com.pkrm.personPojo.JsonToJava;
import com.pkrm.personPojo.JsonToJavaPojo;

public class Listener implements MessageListener {
	private static org.apache.log4j.Logger logger = Logger.getLogger(Listener.class);
	private static org.apache.log4j.Logger toFile = Logger.getLogger("Logger");
	public void onMessage(Message message) {
		ApplicationContext context = new ClassPathXmlApplicationContext("SpringTransaction.xml");
		PersonDao personDao = (PersonDao) context.getBean("personDao");

		try {
			if (message instanceof TextMessage) {
				TextMessage textMessage = (TextMessage) message;
				logger.info("Received message '" + textMessage.getText() + "'");
				toFile.info("Received message '" + textMessage.getText() + "'");
				JsonToJava jsonMapper = new JsonToJava();
				try {
					JsonToJavaPojo javaObject = jsonMapper.json(textMessage.getText());
					personDao.addUser(javaObject);

				} catch (IOException e) {

				  logger.error(e.getMessage());
				  toFile.error(e.getMessage());
				}
			}
		} catch (JMSException e) {
			logger.error(e.getMessage());
			toFile.error(e.getMessage());
		}

	}

	public static void main(String[] args) throws InterruptedException {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("jmsContext.xml");
		Thread.sleep(1000);
		context.close();

	}

}
