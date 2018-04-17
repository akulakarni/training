package com.pkrm.clientservice;

import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.Session;
import javax.jms.TextMessage;

import org.apache.log4j.Logger;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;

public class Client {
	private static Logger logger = Logger.getLogger(Client.class);
	private final JmsTemplate template;

	private Destination responseQueue;

	public Client(JmsTemplate template, Destination responseQueue) {
		this.template = template;
		this.responseQueue = responseQueue;
	}

	public void sendMessage(final String messageText) {
		template.send(new MessageCreator() {
			public Message createMessage(Session session) throws JMSException {
				logger.info("Sent message '" + messageText + "'");

				TextMessage createTextMessage = session
						.createTextMessage(messageText);
				createTextMessage.setJMSReplyTo(responseQueue);
				return createTextMessage;
			}
		});

		
	}

	public static void main(String[] args) throws InterruptedException,
			JMSException {
		final ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(
				"client-context.xml");

		Client obj = (Client) context.getBean("client");
		obj.sendMessage("Spring JMS Message Client");
		Thread.sleep(1000);
		context.close();

	}

}
