package com.activemq.demo.conf;

import javax.jms.Connection;
import javax.jms.JMSException;
import javax.jms.QueueConnection;
import javax.jms.QueueSession;
import javax.jms.Session;
import javax.jms.TopicConnection;
import javax.jms.TopicSession;
import javax.jms.XAConnection;
import javax.jms.XAQueueConnection;
import javax.jms.XAQueueSession;
import javax.jms.XASession;
import javax.jms.XATopicConnection;
import javax.jms.XATopicSession;

/*  
 * Creating Session Factory
 * 
 * */

public class SessionConfig {

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

}
