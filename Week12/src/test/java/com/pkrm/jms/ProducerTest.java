package com.pkrm.jms;

import static org.junit.Assert.*;

import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.JMSException;
import javax.jms.MessageConsumer;
import javax.jms.MessageProducer;
import javax.jms.Queue;
import javax.jms.Session;
import javax.jms.TextMessage;

import org.apache.activemq.ActiveMQConnection;
import org.apache.activemq.spring.ActiveMQConnectionFactory;
import org.junit.Test;

import junit.framework.Assert;

public class ProducerTest {

	@Test
	public void test() throws JMSException {
		final String URL = ActiveMQConnection.DEFAULT_BROKER_URL;
		  final ConnectionFactory connectionFactory = new ActiveMQConnectionFactory();
		    final Queue queue;
		    final Connection connection = connectionFactory.createConnection();
		    final Session session = connection.createSession(true,
		            Session.AUTO_ACKNOWLEDGE);
		    {
		        queue = session.createQueue("test");
		    }
		    {
		        final MessageProducer producer = session.createProducer(queue);
		        final TextMessage message = session.createTextMessage("testing");
		        producer.send(message);
		    }
		    {
		        final MessageConsumer consumer = session.createConsumer(queue);
		        final TextMessage message = (TextMessage) consumer.receiveNoWait();
		        // "message" is null at this point
		        Assert.assertEquals("testing", message.getText());
		    }
		}
	}


