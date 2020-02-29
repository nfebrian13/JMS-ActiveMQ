package com.activemq.demo.consume;

import javax.jms.JMSException;
import javax.jms.MessageConsumer;
import javax.jms.MessageListener;
import javax.jms.Session;
import javax.jms.Topic;
import javax.jms.TopicSubscriber;

public class TopicConsume {

	/* Consume Topic Destination */
	public MessageConsumer consumeFromTopic(Session session, String destination, MessageListener messageListener)
			throws JMSException {
		Topic topic = session.createTopic(destination);
		MessageConsumer consumer = session.createConsumer(topic);
		consumer.setMessageListener(messageListener);
		return consumer;
	}

	/* Consume Topic Durable subscription */
	public TopicSubscriber consumeFromTopicDurableSubsription(Session session, String destination,
			MessageListener messageListener) throws JMSException {
		Topic topic = session.createTopic(destination);
		TopicSubscriber consumer = session.createDurableSubscriber(topic, "test-subsription");
		consumer.setMessageListener(messageListener);
		return consumer;
	}
}
