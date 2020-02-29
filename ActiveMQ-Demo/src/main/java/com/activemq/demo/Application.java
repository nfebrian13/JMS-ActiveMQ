package com.activemq.demo;

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

	public TopicConnection createTopicQueueConnection(TopicConnectionFactory cf) throws JMSException {
		return cf.createTopicConnection();
	}

	public XATopicConnection createXATopicQueueConnection(XATopicConnectionFactory cf) throws JMSException {
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

	public TopicSession createQueueSession(TopicConnection connection) throws JMSException {
		return connection.createTopicSession(false, Session.AUTO_ACKNOWLEDGE);
	}

	public XATopicSession createXAQueueSession(XATopicConnection connection) throws JMSException {
		return connection.createXATopicSession();
	}

}
