package com.activemq.demo.conf;

import javax.jms.ConnectionFactory;
import javax.jms.QueueConnectionFactory;
import javax.jms.TopicConnectionFactory;
import javax.jms.XAConnectionFactory;
import javax.jms.XAQueueConnectionFactory;
import javax.jms.XATopicConnectionFactory;

import org.apache.activemq.ActiveMQConnectionFactory;
import org.apache.activemq.ActiveMQXAConnectionFactory;

/*  
 * Connection Factory
 * 
 * */

public class ConnectionFactories {

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
	
	
	
}
