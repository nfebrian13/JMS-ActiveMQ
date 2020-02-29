package com.activemq.demo;

import com.activemq.demo.test.TestClass;

public class Application {

	public static void main(String[] args) throws Exception {
		
		TestClass testObjClass = new TestClass();
//		testObjClass.testSendingQueueMessage();
//		testObjClass.testSendingQueueMessage2();
//		testObjClass.testSendingTopicMessage();
//		testObjClass.testSendingTopicMessage2();
		
//		testObjClass.testConsumingQueueMessage();
		testObjClass.testConsumingTopicMessage();
	}
}
