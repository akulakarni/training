package com.pkrm.asynchronousListener;

import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.MessageProducer;
import javax.jms.Session;
import javax.jms.TextMessage;

import org.apache.activemq.ActiveMQConnection;
import org.apache.activemq.ActiveMQConnectionFactory;
import org.apache.log4j.Logger;

public class Producer {
	private static org.apache.log4j.Logger logger = Logger.getLogger(Producer.class);
	private static final String URL = ActiveMQConnection.DEFAULT_BROKER_URL;

	private static String QUEUE_NAME = "SAMPLE_QUEUE";

	public void sendMessage(String messageText) throws JMSException {
		Connection connection=null;
		try {
		ConnectionFactory connectionFactory = new ActiveMQConnectionFactory(URL);
		connection = connectionFactory.createConnection();
		connection.start();
		
		Session session = connection.createSession(false,
				Session.AUTO_ACKNOWLEDGE);
		
		Destination destination = session.createQueue(QUEUE_NAME);
		
		MessageProducer producer = session.createProducer(destination);

		TextMessage message = session.createTextMessage(messageText);
		
		logger.info("Sent message '" + message.getText() + "'");

		connection.close();
		}
		catch(Exception e) {
			logger.error(e.getMessage());
		}
		finally {
			connection.close();
		}
	}

	public static void main(String[] args) throws JMSException {
		Producer producer = new Producer();
		producer.sendMessage("I am producer");
	}




	}


