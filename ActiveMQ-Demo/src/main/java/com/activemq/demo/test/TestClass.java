package com.activemq.demo.test;

import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.JMSException;
import javax.jms.QueueConnection;
import javax.jms.QueueConnectionFactory;
import javax.jms.QueueSession;
import javax.jms.Session;
import javax.jms.TopicConnection;
import javax.jms.TopicConnectionFactory;
import javax.jms.TopicSession;

import com.activemq.demo.conf.ConnectionConfig;
import com.activemq.demo.conf.ConnectionFactories;
import com.activemq.demo.conf.SessionConfig;
import com.activemq.demo.sending.QueueSendingMessage;
import com.activemq.demo.sending.TopicSendingMessage;

public class TestClass {
	
	ConnectionFactories connectionFactoryObj = new ConnectionFactories();
	ConnectionConfig connectionConfObj = new ConnectionConfig();
	SessionConfig sessionConfObj = new SessionConfig();
	QueueSendingMessage sendQueueMessageObj = new QueueSendingMessage();
	TopicSendingMessage sendTopicMessageObj = new TopicSendingMessage();
	
	
	public void testSendingQueueMessage() throws JMSException {
		/* sending message to Queue 1  */
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
		/* sending message to Topic 2.1  */
		TopicConnectionFactory cf = connectionFactoryObj.createTopicConnectionFactory();
		TopicConnection conn = connectionConfObj.createTopicConnection(cf);
		TopicSession session = sessionConfObj.createTopicSession(conn);
		sendTopicMessageObj.sendTextMessageToTopic("Another Message Topic", session);
		session.close();
		conn.close(); 
	}
	
	/* consuming queue message 
	MessageListener message = null;
	Application app = new Application();
	ConnectionFactory cf = app.createConnectionFactory();
	final Connection conn = app.createConnection(cf);
	final Session session = app.createSession(conn);
	final MessageConsumer consumer = app.consumeFromDestination(session,"TEST_DESTINATION", message);
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
	}); */
	
	
	/* consuming queue message Topic 
	MessageListener message = null;
	Application app = new Application();
	ConnectionFactory cf = app.createConnectionFactory();
	final Connection conn = app.createConnection(cf);
	final Session session = app.createSession(conn);
	final MessageConsumer consumer = app.consumeFromTopic(session,"TEST_TOPIC", message);
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
	});  */
	
	/* consuming topic message durable subscription  
	Application app = new Application();
	ConnectionFactory cf = app.createConnectionFactory();
	final Connection conn = app.createConnection(cf);
	conn.setClientID("MyUniqueClientId");
	final Session session = app.createSession(conn);
	final TopicSubscriber topicSubscriber = 
			app.consumeFromTopicDurableSubsription(session,"TEST_TOPIC", (message -> {
				if (message  instanceof TextMessage) {
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
				session.unsubscribe("test-subsription");
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
		}
	});  */
	
	
}
