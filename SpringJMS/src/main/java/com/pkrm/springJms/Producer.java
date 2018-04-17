package com.pkrm.springJms;

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

	public void sendMessage(final String messageText){
		template.send(new MessageCreator() {

			public Message createMessage(Session session) throws JMSException {
				System.out.println("Sent message '" +messageText + "'");
				return session.createTextMessage(messageText);

			}

		});
		
	}



	public static void main(String[] args) throws Exception {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(
				"Producer.xml");

		Producer obj = (Producer) context.getBean("Producer");
		obj.sendMessage("I am producer");
		Thread.sleep(1000);
		context.close();
		

	}

}
