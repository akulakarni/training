package com.pkrm.topic;

import javax.jms.JMSException;

import org.apache.log4j.Logger;



public class Subscriber {
	private static org.apache.log4j.Logger logger = Logger.getLogger(Subscriber.class);
	/*private static final String URL = ActiveMQConnection.DEFAULT_BROKER_URL;

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
	}*/
	public static void main(String[] args) throws JMSException {
		Subscriber1 consumer = new Subscriber1();
		logger.info("Received message1 '" + consumer.recieveMessage()
				+ "'");
		Subscriber2 consumer1 = new Subscriber2();
		logger.info("Received message2 '" + consumer1.recieveMessage()
				+ "'");
	
	
	}

}
