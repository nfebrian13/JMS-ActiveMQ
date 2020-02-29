package com.activemq.demo;

import com.activemq.demo.test.TestClass;

public class Application {

	public static void main(String[] args) throws Exception {
		
		TestClass testObjClass = new TestClass();
//		testObjClass.testSendingQueueMessage();
		testObjClass.testSendingQueueMessage2();
		
		
		/* sending message to Topic 2 
		Application app = new Application();
		ConnectionFactory cf = app.createConnectionFactory();
		Connection conn = app.createConnection(cf);
		Session session = app.createSession(conn);
		app.sendTextMessageToTopic("Test Message", session);
		session.close();
		conn.close();  */
		
		/* sending message to Topic 2.1 
		Application app = new Application();
		TopicConnectionFactory cf = app.createTopicConnectionFactory();
		TopicConnection conn = app.createTopicConnection(cf);
		TopicSession session = app.createTopicSession(conn);
		app.sendTextMessageToTopic("Another Message", session);
		session.close();
		conn.close();  */
		
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
}
