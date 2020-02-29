package com.activemq.demo.test;

import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.JMSException;
import javax.jms.Session;

import com.activemq.demo.conf.ConnectionConfig;
import com.activemq.demo.conf.ConnectionFactories;
import com.activemq.demo.conf.SessionConfig;
import com.activemq.demo.sending.QueueSendingMessage;

public class TestClass {

	public void testSendingQueueMessage() throws JMSException {
		ConnectionFactories connectionFactoryObj = new ConnectionFactories();
		ConnectionConfig connectionConfObj = new ConnectionConfig();
		SessionConfig sessionConfObj = new SessionConfig();
		
		QueueSendingMessage sendMessageObj = new QueueSendingMessage();
		
		/* sending message to Queue 1  */
		ConnectionFactory cf = connectionFactoryObj.createConnectionFactory();
		Connection conn = connectionConfObj.createConnection(cf);
		Session session = sessionConfObj.createSession(conn);
		sendMessageObj.sendTextMessageToQueue("Hello Nana!", session);
		session.close();
		conn.close();
	}
	
}
