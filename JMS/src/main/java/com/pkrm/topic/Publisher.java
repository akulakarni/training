package com.pkrm.topic;

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



public class Publisher {
	private static org.apache.log4j.Logger logger = Logger.getLogger(Publisher.class);
	private static final String URL = ActiveMQConnection.DEFAULT_BROKER_URL;

	private static String TOPIC_NAME = "SAMPLE_TOPIC";

	public void sendMessage(String messageText) throws JMSException {
		
		ConnectionFactory connectionFactory = new ActiveMQConnectionFactory(URL);
		Connection connection = connectionFactory.createConnection();
		connection.start();

	
		Session session = connection.createSession(false,
				Session.AUTO_ACKNOWLEDGE);

		Destination destination = session.createTopic(TOPIC_NAME);

	
		MessageProducer producer = session.createProducer(destination);

		TextMessage message = session.createTextMessage(messageText);

		producer.send(message);
		logger.info("Sent message '" + message.getText() + "'");

		connection.close();
	}

	public static void main(String[] args) throws JMSException {
		Publisher publisher = new Publisher();
		publisher.sendMessage("Hello");
		
	}


}
