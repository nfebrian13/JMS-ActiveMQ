package com.activemq.demo.test;

import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.JMSException;
import javax.jms.MessageConsumer;
import javax.jms.MessageListener;
import javax.jms.QueueConnection;
import javax.jms.QueueConnectionFactory;
import javax.jms.QueueSession;
import javax.jms.Session;
import javax.jms.TextMessage;
import javax.jms.TopicConnection;
import javax.jms.TopicConnectionFactory;
import javax.jms.TopicSession;
import javax.jms.TopicSubscriber;

import com.activemq.demo.conf.ConnectionConfig;
import com.activemq.demo.conf.ConnectionFactories;
import com.activemq.demo.conf.SessionConfig;
import com.activemq.demo.consume.QueueConsume;
import com.activemq.demo.consume.TopicConsume;
import com.activemq.demo.sending.QueueSendingMessage;
import com.activemq.demo.sending.TopicSendingMessage;

public class TestClass {

	ConnectionFactories connectionFactoryObj = new ConnectionFactories();
	ConnectionConfig connectionConfObj = new ConnectionConfig();
	SessionConfig sessionConfObj = new SessionConfig();

	QueueSendingMessage sendQueueMessageObj = new QueueSendingMessage();
	TopicSendingMessage sendTopicMessageObj = new TopicSendingMessage();

	QueueConsume queueConsumeMessageObj = new QueueConsume();
	TopicConsume topicConsumeMessageObj = new TopicConsume();

	public void testSendingQueueMessage() throws JMSException {
		/* sending message to Queue 1 */
		ConnectionFactory cf = connectionFactoryObj.createConnectionFactory();
		Connection conn = connectionConfObj.createConnection(cf);
		Session session = sessionConfObj.createSession(conn);
		sendQueueMessageObj.sendTextMessageToQueue("Hello Nana!", session);
		session.close();
		conn.close();
	}

	public void testSendingQueueMessage2() throws JMSException {
		/* sending message to Queue 1.1 */
		QueueConnectionFactory cf = connectionFactoryObj.createQueueConnectionFactory();
		QueueConnection conn = connectionConfObj.createQueueConnection(cf);
		QueueSession session = sessionConfObj.createQueueSession(conn);
		sendQueueMessageObj.sendTextMessageToQueue("Another Message Nana!", session);
		session.close();
		conn.close();
	}

	public void testSendingTopicMessage() throws JMSException {
		/* sending message to Topic 2 */
		ConnectionFactory cf = connectionFactoryObj.createConnectionFactory();
		Connection conn = connectionConfObj.createConnection(cf);
		Session session = sessionConfObj.createSession(conn);
		sendTopicMessageObj.sendTextMessageToTopic("Test Message Topic", session);
		session.close();
		conn.close();
	}

	public void testSendingTopicMessage2() throws JMSException {
		/* sending message to Topic 2.1 */
		TopicConnectionFactory cf = connectionFactoryObj.createTopicConnectionFactory();
		TopicConnection conn = connectionConfObj.createTopicConnection(cf);
		TopicSession session = sessionConfObj.createTopicSession(conn);
		sendTopicMessageObj.sendTextMessageToTopic("Another Message Topic", session);
		session.close();
		conn.close();
	}

	public void testConsumingQueueMessage() throws JMSException {
		/* consuming queue message */
		MessageListener message = null;
		ConnectionFactory cf = connectionFactoryObj.createConnectionFactory();
		final Connection conn = connectionConfObj.createConnection(cf);
		final Session session = sessionConfObj.createSession(conn);
		final MessageConsumer consumer = queueConsumeMessageObj.consumeFromQueue(session, "NANA_DESTINATION", message);
		System.out.println("haha " + consumer.toString());
		conn.start();

		// Free resources
		Runtime.getRuntime().addShutdownHook(new Thread() {
			@Override
			public void run() {
				try {
					super.run();
					conn.stop();
					consumer.close();
					session.close();
					conn.close();
				} catch (Exception e) {
					// TODO: handle exception
					e.printStackTrace();
				}
			}
		});
	}

	public void testConsumingTopicMessage() throws JMSException {
		/* consuming queue message Topic */
		MessageListener message = null;
		ConnectionFactory cf = connectionFactoryObj.createConnectionFactory();
		final Connection conn = connectionConfObj.createConnection(cf);
		final Session session = sessionConfObj.createSession(conn);
		final MessageConsumer consumer = topicConsumeMessageObj.consumeFromTopic(session, "NANA_TEST_TOPIC", message);
		System.out.println("Topic is: " + consumer.toString());
		conn.start();

		// Free resources
		Runtime.getRuntime().addShutdownHook(new Thread() {
			@Override
			public void run() {
				try {
					super.run();
					conn.stop();
					consumer.close();
					session.close();
					conn.close();
				} catch (Exception e) {
					// TODO: handle exception
					e.printStackTrace();
				}
			}
		});
	}

	public void testConsumingDurableSubsMessage() throws JMSException {
		/* consuming topic message durable subscription */
		ConnectionFactory cf = connectionFactoryObj.createConnectionFactory();
		final Connection conn = connectionConfObj.createConnection(cf);
		conn.setClientID("MyUniqueClientId");
		final Session session = sessionConfObj.createSession(conn);
		final TopicSubscriber topicSubscriber = topicConsumeMessageObj.consumeFromTopicDurableSubsription(session, "NANA_TEST_TOPIC",
				(message -> {
					if (message instanceof TextMessage) {
						TextMessage txtMessage = (TextMessage) message;
						try {
							System.out.println(txtMessage.getText());
						} catch (JMSException e) {
							// TODO: handle exception
							e.printStackTrace();
						}
					}
				}));

		conn.start();

		// Free resources
		Runtime.getRuntime().addShutdownHook(new Thread() {
			@Override
			public void run() {
				try {
					super.run();
					conn.stop();
					topicSubscriber.close();
					session.close();
					conn.close();

					// if you are finished with subscription
					session.unsubscribe("test-subsription-nana");
				} catch (Exception e) {
					// TODO: handle exception
					e.printStackTrace();
				}
			}
		});

	}

}
