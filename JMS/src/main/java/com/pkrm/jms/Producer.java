package com.pkrm.jms;

import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.Destination;
import javax.jms.MessageProducer;
import javax.jms.Session;
import javax.jms.TextMessage;

import org.apache.activemq.ActiveMQConnection;
import org.apache.activemq.ActiveMQConnectionFactory;
import org.apache.log4j.Logger;
import org.springframework.jms.JmsException;

public class Producer {
	private static org.apache.log4j.Logger logger = Logger.getLogger(Producer.class);
	private static final String URL = ActiveMQConnection.DEFAULT_BROKER_URL;

	private static String QUEUE_NAME = "SAMPLE_QUEUE";

	public void sendMessage(String messageText) throws Exception {
		Connection connection=null;
		try {
		ConnectionFactory connectionFactory = new ActiveMQConnectionFactory(URL);
		 connection = (Connection) connectionFactory.createConnection();
		connection.start();

		Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
		Destination destination = session.createQueue(QUEUE_NAME);
		MessageProducer producer = session.createProducer(destination);
		TextMessage message = session.createTextMessage(messageText);

		producer.send(message);
		logger.info("Sent message '" + message.getText()+ "'");

//		 connection.close();
	}
	
	catch(JmsException e) {
		logger.error(e.getMessage());
	}
		finally {
			connection.close();
		}
	}
	public static void main(String[] args) throws Exception {
		Producer producer = new Producer();
		producer.sendMessage("JMS Producer Sent a Text Messagegtff ");
	}

}
