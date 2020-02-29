package com.activemq.demo.sending;

import javax.jms.JMSException;
import javax.jms.MessageProducer;
import javax.jms.Queue;
import javax.jms.QueueSender;
import javax.jms.QueueSession;
import javax.jms.Session;
import javax.jms.TextMessage;

public class QueueSendingMessage {
	
	/* Sending message to queue 1 */
	public void sendTextMessageToQueue(String message, Session session) throws JMSException {
		Queue queue = session.createQueue("NANA_DESTINATION");
		TextMessage msg = session.createTextMessage(message);
		MessageProducer messageProducer = session.createProducer(queue);
		messageProducer.send(msg);
	}
	
	/* Sending message to queue 1.1 */
	public void sendTextMessageToQueue(String message, QueueSession session) throws JMSException {
		Queue queue = session.createQueue("NANA_DESTINATION");
		TextMessage msg = session.createTextMessage(message);
		QueueSender messageProducer = session.createSender(queue);
		messageProducer.send(msg);
	}
}
