package com.activemq.demo.consume;

import javax.jms.JMSException;
import javax.jms.MessageConsumer;
import javax.jms.MessageListener;
import javax.jms.Queue;
import javax.jms.Session;

public class QueueConsume {
	
	/* Consume Queue Destination  */
	public MessageConsumer consumeFromQueue(Session session, String destination, MessageListener messageListener) 
			throws JMSException {
		Queue queue = session.createQueue(destination);
		MessageConsumer consumer = session.createConsumer(queue);
		consumer.setMessageListener(messageListener);
		return consumer;
		
		/* belum digunakan 
		boolean someCondition = true;
		while (someCondition) {
			Message message = consumer.receive(500);
			if (null != message) {
				// Do Something With Message
				
			}
		} */
	}
}
