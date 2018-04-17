package com.pkrm.clientservice;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.MessageProducer;
import javax.jms.Session;
import javax.jms.TextMessage;

import org.apache.log4j.Logger;

import com.pkrm.asynchronousListener.Consumer;

public class AsynchronousMessageListener implements MessageListener {

	private static org.apache.log4j.Logger logger = Logger.getLogger(AsynchronousMessageListener.class);
		private Session session;

		public AsynchronousMessageListener(Session session) {
			this.session = session;
		}

		public void onMessage(Message message) {
			try {
				if (message instanceof TextMessage) {

					TextMessage textMessage = (TextMessage) message;

					String id = textMessage.getText();
					logger.info("ID" + id);
					
					String replyMessage = "Successfully Processed " + id;
					MessageProducer createProducer = session.createProducer(message
							.getJMSReplyTo());

					createProducer.send(session.createTextMessage(replyMessage));

					createProducer.setTimeToLive(6000);

				}
			} catch (JMSException e) {
				logger.error(e.getMessage());
			}

		}


	}


