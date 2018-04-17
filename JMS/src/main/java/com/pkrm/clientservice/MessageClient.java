package com.pkrm.clientservice;

import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageConsumer;
import javax.jms.MessageProducer;
import javax.jms.Session;
import javax.jms.TemporaryQueue;
import javax.jms.TextMessage;

import org.apache.activemq.ActiveMQConnection;
import org.apache.activemq.ActiveMQConnectionFactory;
import org.apache.log4j.Logger;
import org.apache.xbean.spring.context.ClassPathXmlApplicationContext;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;

public class MessageClient {
	private static org.apache.log4j.Logger logger = Logger.getLogger(MessageClient.class);
	private static final String URL = ActiveMQConnection.DEFAULT_BROKER_URL;

	private static String QUEUE_NAME = "SAMPLE_QUEUE";

	public String retrieve(String id) throws JMSException {
		Connection connection=null;
		try {
		
		
		// Getting JMS connection from the server and starting it
		ConnectionFactory connectionFactory = new ActiveMQConnectionFactory(URL);
		 connection = connectionFactory.createConnection();
		connection.start();

		
		Session session = connection.createSession(false,
				Session.AUTO_ACKNOWLEDGE);
		Destination destination = session.createQueue(QUEUE_NAME);

		MessageProducer producer = session.createProducer(destination);

		TextMessage message = session.createTextMessage();
		message.setText(id);

		TemporaryQueue temporaryQueue = session.createTemporaryQueue();
		message.setJMSReplyTo(temporaryQueue);

		logger.info(message.getText());

		producer.send(message);

		MessageConsumer consumer = session.createConsumer(temporaryQueue);

		Message responseMessage = consumer.receive(60 * 1000);
		TextMessage textMessage = (TextMessage) responseMessage;
		logger.info("response message test " + textMessage.getText());

		return textMessage.getText();
		}
		catch(Exception e) {
			logger.error(e.getMessage());
			return null;
		}
		finally {
			connection.close();
		}
	

	}

	public static void main(String[] args) throws JMSException {
		MessageClient client = new MessageClient();
		logger.info("Received message '" + client.retrieve("Message Client")
				+ "'");
	}
}
	


