package com.activemq.demo.sending;

import javax.jms.DeliveryMode;
import javax.jms.JMSException;
import javax.jms.MessageProducer;
import javax.jms.Session;
import javax.jms.TextMessage;
import javax.jms.Topic;
import javax.jms.TopicPublisher;
import javax.jms.TopicSession;

public class TopicSendingMessage {
	
	/* Sending message to topic 2 */
	public void sendTextMessageToTopic(String message, Session session) throws JMSException {
		Topic topic = session.createTopic("NANA_TEST_TOPIC");
		TextMessage msg = session.createTextMessage(message);
		MessageProducer messageProducer = session.createProducer(topic);
		messageProducer.send(msg);
	}

	/* Sending message to topic 2.1 */
	public void sendTextMessageToTopic(String message, TopicSession session) throws JMSException {
		Topic topic = session.createTopic("NANA_TEST_TOPIC");
		TextMessage msg = session.createTextMessage(message);
		TopicPublisher topicPublisher = session.createPublisher(topic);
		topicPublisher.send(msg);
	}
	
	/* Sending message to topic 2.2 (priorities) */
	public void sendTextMessageToTopicPriorities(String message, Session session) throws JMSException {
		Topic topic = session.createTopic("NANA_TEST_TOPIC");
		TextMessage msg = session.createTextMessage(message);
		MessageProducer messageProducer = session.createProducer(topic);
		messageProducer.setPriority(9); // 0-9, 9 Highest, all messages, 4 default
		messageProducer.setTimeToLive(1000);// milisecon, 0 default - doesnt expire
		messageProducer.send(msg, DeliveryMode.NON_PERSISTENT,
				9, // priority
				20000); // time to live
	}
}
