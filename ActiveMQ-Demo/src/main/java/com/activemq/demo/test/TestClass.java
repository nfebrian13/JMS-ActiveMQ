package com.activemq.demo.test;

import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.JMSException;
import javax.jms.QueueConnection;
import javax.jms.QueueConnectionFactory;
import javax.jms.QueueSession;
import javax.jms.Session;

import com.activemq.demo.conf.ConnectionConfig;
import com.activemq.demo.conf.ConnectionFactories;
import com.activemq.demo.conf.SessionConfig;
import com.activemq.demo.sending.QueueSendingMessage;

public class TestClass {
	
	ConnectionFactories connectionFactoryObj = new ConnectionFactories();
	ConnectionConfig connectionConfObj = new ConnectionConfig();
	SessionConfig sessionConfObj = new SessionConfig();
	QueueSendingMessage sendMessageObj = new QueueSendingMessage();
	
	public void testSendingQueueMessage() throws JMSException {
		/* sending message to Queue 1  */
		ConnectionFactory cf = connectionFactoryObj.createConnectionFactory();
		Connection conn = connectionConfObj.createConnection(cf);
		Session session = sessionConfObj.createSession(conn);
		sendMessageObj.sendTextMessageToQueue("Hello Nana!", session);
		session.close();
		conn.close();
	}
	
	public void testSendingQueueMessage2() throws JMSException {
		/* sending message to Queue 1.1 */
		QueueConnectionFactory cf = connectionFactoryObj.createQueueConnectionFactory();
		QueueConnection conn = connectionConfObj.createQueueConnection(cf);
		QueueSession session = sessionConfObj.createQueueSession(conn);
		sendMessageObj.sendTextMessageToQueue("Another Message Nana!", session);
		session.close();
		conn.close(); 
	}
	
}
