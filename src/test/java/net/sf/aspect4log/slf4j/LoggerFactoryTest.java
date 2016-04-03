package net.sf.aspect4log.slf4j;

import org.junit.Test;
import org.slf4j.Logger;

public class LoggerFactoryTest {

	@Test
	public void test(){
		LoggerFactory loggerFactory = new LoggerFactory();
		Logger logger1= LoggerFactory.getLogger("test");
		logger1.trace("trace");
		logger1.debug("debug");
		logger1.info("info");
		logger1.warn("warn");
		Logger logger2= LoggerFactory.getLogger(LoggerFactoryTest.class);
		logger2.error("error");
		
	}
}
