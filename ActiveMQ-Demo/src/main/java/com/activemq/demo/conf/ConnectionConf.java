package com.activemq.demo.conf;

import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.JMSException;
import javax.jms.QueueConnection;
import javax.jms.QueueConnectionFactory;
import javax.jms.TopicConnection;
import javax.jms.TopicConnectionFactory;
import javax.jms.XAConnection;
import javax.jms.XAConnectionFactory;
import javax.jms.XAQueueConnection;
import javax.jms.XAQueueConnectionFactory;
import javax.jms.XATopicConnection;
import javax.jms.XATopicConnectionFactory;

/* 
 * Create Connection
 * 
 *  */

public class ConnectionConf {
	

	public Connection createConnection(ConnectionFactory cf) 
			throws JMSException {
		return cf.createConnection();
	}

	public XAConnection createXAConnection(XAConnectionFactory cf) 
			throws JMSException {
		return cf.createXAConnection();
	}

	public QueueConnection createQueueConnection(QueueConnectionFactory cf) 
			throws JMSException {
		return cf.createQueueConnection();
	}

	public XAQueueConnection createXAQueueConnection(XAQueueConnectionFactory cf) 
			throws JMSException {
		return cf.createXAQueueConnection();
	}

	public TopicConnection createTopicConnection(TopicConnectionFactory cf) 
			throws JMSException {
		return cf.createTopicConnection();
	}

	public XATopicConnection createXATopicConnection(XATopicConnectionFactory cf) 
			throws JMSException {
		return cf.createXATopicConnection();
	}
	
}
