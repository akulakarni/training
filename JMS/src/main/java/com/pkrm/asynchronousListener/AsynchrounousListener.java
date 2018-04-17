package com.pkrm.asynchronousListener;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;

import org.apache.log4j.Logger;

public class AsynchrounousListener implements MessageListener {
	private static org.apache.log4j.Logger logger = Logger.getLogger(AsynchrounousListener.class);
	public void onMessage(Message message) {
		if (message instanceof TextMessage) {
			try {
				TextMessage textMessage = (TextMessage) message;
				logger.info(textMessage.getText());
			} catch (JMSException e) {
				logger.error(e.getMessage());
			}
		}

	}

		
	}
	


