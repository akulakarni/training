package com.pkrm.clientservice;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.Session;
import javax.jms.TextMessage;

import org.apache.log4j.Logger;
import org.springframework.jms.support.converter.MessageConverter;
import org.springframework.messaging.converter.MessageConversionException;

import com.pkrm.springJms.Consumer;



public class DefaultMessageConverter implements MessageConverter{
	private static org.apache.log4j.Logger logger = Logger.getLogger(DefaultMessageConverter.class);
	public Object fromMessage(Message message){
TextMessage textMessage = (TextMessage) message;
try {
	return textMessage.getText();
} catch (JMSException e) {
    logger.error(e.getMessage());
}
catch(MessageConversionException e1) {
	logger.error(e1.getMessage());
}
return textMessage;
}

public Message toMessage(Object object, Session session)
	 {
TextMessage message = null;
try {
	message = session.createTextMessage(object.toString());
} catch (JMSException e) {
	logger.error(e.getMessage());
	
}
catch(MessageConversionException e1) {
	logger.error(e1.getMessage());
}
return message;
}

}
