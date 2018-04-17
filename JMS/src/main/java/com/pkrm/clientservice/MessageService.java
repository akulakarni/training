package com.pkrm.clientservice;

import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.MessageConsumer;
import javax.jms.Session;

import org.apache.activemq.ActiveMQConnection;
import org.apache.activemq.ActiveMQConnectionFactory;
import org.apache.log4j.Logger;

public class MessageService {
	private static org.apache.log4j.Logger logger = Logger.getLogger(MessageService.class);
	private static final String URL = ActiveMQConnection.DEFAULT_BROKER_URL;
	private static String QUEUE_NAME = "SAMPLE_QUEUE";

	public void processMessage() throws JMSException, InterruptedException {
		Connection connection=null;
		try {
		ConnectionFactory connectionFactory = new ActiveMQConnectionFactory(URL);
	    connection = connectionFactory.createConnection();
		connection.start();
		Session session = connection.createSession(false,
				Session.AUTO_ACKNOWLEDGE);
		Destination destination = session.createQueue(QUEUE_NAME);
		MessageConsumer consumer = session.createConsumer(destination);
		consumer.setMessageListener(new AsynchronousMessageListener(session));
		logger.info("waiting for messages");
		for (int i = 0; i < 100; i++) {
			Thread.sleep(1000);
			logger.info("hi");
		}
		//System.out.println();

		
		}
		catch(Exception e) {
			logger.error(e.getMessage());
	}
		finally {
			connection.close();
		}
	}
	public static void main(String[] args) throws JMSException,
			InterruptedException {
		MessageService consumer = new MessageService();
		consumer.processMessage();
	}


	}
	
