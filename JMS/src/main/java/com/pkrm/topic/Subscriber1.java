package com.pkrm.topic;

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

public class Subscriber1 {
	private static final String URL = ActiveMQConnection.DEFAULT_BROKER_URL;

	private static String TOPIC_NAME = "SAMPLE_TOPIC";

	public String recieveMessage() throws JMSException {
		
		ConnectionFactory connectionFactory = new ActiveMQConnectionFactory(URL);
		Connection connection = connectionFactory.createConnection();
		connection.start();

	
		Session session = connection.createSession(false,
				Session.AUTO_ACKNOWLEDGE);

		
		Destination destination = session.createTopic(TOPIC_NAME);

	
		MessageConsumer consumer = session.createConsumer(destination);

	
		Message message = consumer.receive();

	
		String text = null;
		if (message instanceof TextMessage) {
			TextMessage textMessage = (TextMessage) message;
			text = textMessage.getText();
		}
		connection.close();
		return text;
	}

/*	public static void main(String[] args) throws JMSException {
		Subscriber1 consumer = new Subscriber1();
		System.out.println("Received message '" + consumer.recieveMessage()
				+ "'");
	}*/

}
