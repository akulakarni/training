package com.pkrm.jms;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.TextMessage;

import org.apache.log4j.Logger;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jms.JmsException;
import org.springframework.jms.core.JmsTemplate;



public class Consumer {
	private static org.apache.log4j.Logger logger = Logger.getLogger(Consumer.class);
	private final JmsTemplate template;

	public Consumer(JmsTemplate template) {
		this.template = template;
	}

	public String recieveMessage(){
		try {
			Message message = template.receive();
			if (message instanceof TextMessage) {
				TextMessage textMessage = (TextMessage) message;
				return textMessage.getText();
			}
		} catch (JmsException e) {
			logger.error(e.getMessage());
		} catch (JMSException e) {
			logger.error(e.getMessage());
		}
		return null;
	}



	public static void main(String[] args) throws InterruptedException, JMSException {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(
				"jmsContext.xml");

		Consumer obj = (Consumer) context.getBean("Consumer");
		logger.info("Received message '" + obj.recieveMessage() + "'");
		Thread.sleep(1000);
		context.close();

	}
}
