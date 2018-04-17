package com.pkrm.jms;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.Session;

import org.apache.log4j.Logger;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;

public class Producer {
	private static org.apache.log4j.Logger logger = Logger.getLogger(Producer.class);
	private final JmsTemplate template;

	public Producer(JmsTemplate template) {
		this.template = template;
	}

	public void sendMessage(final String messageText) {
		template.send(new MessageCreator() {

			public Message createMessage(Session session) throws JMSException {
				logger.info("Sent message '" + messageText + "'");
				return session.createTextMessage(messageText);

			}

		});

	}

	public static void main(String[] args) throws Exception {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("jmsContext.xml");

		Producer obj = (Producer) context.getBean("Producer");
		String jsonString = "{\"person\":{\"userId\":4227,\"userName\":\"sakhil\",\"firstName\":\"akhil\",\"lastName\":\"reddy\"},\"roles\":[\"Manager\",\"Developer\",\"Lead\",\"Product Manager\"]}";
		obj.sendMessage(jsonString);
		Thread.sleep(1000);
		context.close();
	}

}
