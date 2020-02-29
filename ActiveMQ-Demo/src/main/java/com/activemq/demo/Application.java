package com.activemq.demo;

import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.JMSException;
import javax.jms.MessageProducer;
import javax.jms.Queue;
import javax.jms.QueueConnection;
import javax.jms.QueueConnectionFactory;
import javax.jms.QueueSender;
import javax.jms.QueueSession;
import javax.jms.Session;
import javax.jms.TextMessage;
import javax.jms.Topic;
import javax.jms.TopicConnection;
import javax.jms.TopicConnectionFactory;
import javax.jms.TopicPublisher;
import javax.jms.TopicSession;
import javax.jms.XAConnection;
import javax.jms.XAConnectionFactory;
import javax.jms.XAQueueConnection;
import javax.jms.XAQueueConnectionFactory;
import javax.jms.XAQueueSession;
import javax.jms.XASession;
import javax.jms.XATopicConnection;
import javax.jms.XATopicConnectionFactory;
import javax.jms.XATopicSession;

import org.apache.activemq.ActiveMQConnectionFactory;
import org.apache.activemq.ActiveMQXAConnectionFactory;

public class Application {

	/* Creating connection factory */

	public ConnectionFactory createConnectionFactory() {
		return new ActiveMQConnectionFactory("tcp://localhost:61616");
	}

	public XAConnectionFactory createXAConnectionFactory() {
		return new ActiveMQXAConnectionFactory("tcp://localhost:61616");
	}

	public QueueConnectionFactory createQueueConnectionFactory() {
		return new ActiveMQConnectionFactory("tcp://localhost:61616");
	}

	public XAQueueConnectionFactory createXAQueueConnectionFactory() {
		return new ActiveMQXAConnectionFactory("tcp://localhost:61616");
	}

	public TopicConnectionFactory createTopicConnectionFactory() {
		return new ActiveMQConnectionFactory("tcp://localhost:61616");
	}

	public XATopicConnectionFactory createXATopicConnectionFactory() {
		return new ActiveMQXAConnectionFactory("tcp://localhost:61616");
	}

	/* Create Connection */

	public Connection createConnection(ConnectionFactory cf) throws JMSException {
		return cf.createConnection();
	}

	public XAConnection createXAConnection(XAConnectionFactory cf) throws JMSException {
		return cf.createXAConnection();
	}

	public QueueConnection createQueueConnection(QueueConnectionFactory cf) throws JMSException {
		return cf.createQueueConnection();
	}

	public XAQueueConnection createXAQueueConnection(XAQueueConnectionFactory cf) throws JMSException {
		return cf.createXAQueueConnection();
	}

	public TopicConnection createTopicConnection(TopicConnectionFactory cf) throws JMSException {
		return cf.createTopicConnection();
	}

	public XATopicConnection createXATopicConnection(XATopicConnectionFactory cf) throws JMSException {
		return cf.createXATopicConnection();
	}

	/* Create Session */

	public Session createSession(Connection connection) throws JMSException {
		return connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
	}

	public XASession createXASession(XAConnection connection) throws JMSException {
		return connection.createXASession();
	}

	public QueueSession createQueueSession(QueueConnection connection) throws JMSException {
		return connection.createQueueSession(false, Session.AUTO_ACKNOWLEDGE);
	}

	public XAQueueSession createXAQueueSession(XAQueueConnection connection) throws JMSException {
		return connection.createXAQueueSession();
	}

	public TopicSession createTopicSession(TopicConnection connection) throws JMSException {
		return connection.createTopicSession(false, Session.AUTO_ACKNOWLEDGE);
	}

	public XATopicSession createXATopicSession(XATopicConnection connection) throws JMSException {
		return connection.createXATopicSession();
	}

	/* Sending message to queue 1 */
	public void sendTextMessageToQueue(String message, Session session) throws JMSException {
		Queue queue = session.createQueue("TEST_DESTINATION");
		TextMessage msg = session.createTextMessage(message);
		MessageProducer messageProducer = session.createProducer(queue);
		messageProducer.send(msg);
	}
	
	/* Sending message to queue 1.1 */
	public void sendTextMessageToQueue(String message, QueueSession session) throws JMSException {
		Queue queue = session.createQueue("TEST_DESTINATION");
		TextMessage msg = session.createTextMessage(message);
		QueueSender messageProducer = session.createSender(queue);
		messageProducer.send(msg);
	}
	
	/* Sending message to topic 2 */
	public void sendTextMessageToTopic(String message, Session session) throws JMSException {
		Topic topic = session.createTopic("TEST_TOPIC");
		TextMessage msg = session.createTextMessage(message);
		MessageProducer messageProducer = session.createProducer(topic);
		messageProducer.send(msg);
	}
	
	/* Sending message to topic 2.1 */
	public void sendTextMessageToTopic(String message, TopicSession session) throws JMSException {
		Topic topic = session.createTopic("TEST_TOPIC");
		TextMessage msg = session.createTextMessage(message);
		TopicPublisher topicPublisher = session.createPublisher(topic);
		topicPublisher.send(msg);
	}
	
	/* Consume Destination  */

	/* Main Class */
	public static void main(String[] args) throws Exception {
		
		/* sending message to Queue 1
		Application app = new Application();
		ConnectionFactory cf = app.createConnectionFactory();
		Connection conn = app.createConnection(cf);
		Session session = app.createSession(conn);
		app.sendTextMessageToQueue("Test Message", session);
		session.close();
		conn.close(); */
		
		/* sending message to Queue 1.1
		Application app = new Application();
		QueueConnectionFactory cf = app.createQueueConnectionFactory();
		QueueConnection conn = app.createQueueConnection(cf);
		QueueSession session = app.createQueueSession(conn);
		app.sendTextMessageToQueue("Another Message", session);
		session.close();
		conn.close(); */
		
		/* sending message to Topic 2 
		Application app = new Application();
		ConnectionFactory cf = app.createConnectionFactory();
		Connection conn = app.createConnection(cf);
		Session session = app.createSession(conn);
		app.sendTextMessageToTopic("Test Message", session);
		session.close();
		conn.close();  */
		
		/* sending message to Topic 2.1 */
		Application app = new Application();
		TopicConnectionFactory cf = app.createTopicConnectionFactory();
		TopicConnection conn = app.createTopicConnection(cf);
		TopicSession session = app.createTopicSession(conn);
		app.sendTextMessageToTopic("Another Message", session);
		session.close();
		conn.close();  
		
	}
}
