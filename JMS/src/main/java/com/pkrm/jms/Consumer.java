package com.pkrm.jms;

import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageConsumer;
import javax.jms.Session;
import javax.jms.TextMessage;

import org.apache.activemq.ActiveMQConnection;
import org.apache.activemq.ActiveMQConnectionFactory;
import org.apache.log4j.Logger;

public class Consumer {
	private static org.apache.log4j.Logger logger = Logger.getLogger(Consumer.class);
	private static final String URL = ActiveMQConnection.DEFAULT_BROKER_URL;
	private static String QUEUE_NAME = "SAMPLE_QUEUE";
	
	public String recieveMessage() throws JMSException {
		Connection connection =null;
		String text = null;
		try {
		ConnectionFactory connectionFactory = new ActiveMQConnectionFactory(URL);
		connection = connectionFactory.createConnection();
		connection.start();
		Session session = connection.createSession(false,Session.AUTO_ACKNOWLEDGE);
		
		Destination destination = session.createQueue(QUEUE_NAME);
		MessageConsumer consumer = session.createConsumer(destination);
		Message message = consumer.receive();
		
		if (message instanceof TextMessage) {
			TextMessage textMessage = (TextMessage) message;
			text = textMessage.getText();
		}
		connection.close();
		
	}
	
	
	catch(Exception e) {
		logger.error(e.getMessage());
	}
	
	
	finally {
		connection.close();
	}
		return text;
	}
		public static void main(String[] args) throws JMSException {
			Consumer consumer = new Consumer();
			logger.info("Received message '" + consumer.recieveMessage()
					+ "'");
		}
	}


