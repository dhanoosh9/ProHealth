package com.Tests;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.Test;


public class Example {
	public static Logger log = LogManager.getLogger();

	@Test
	public void test() {
        log.debug("Sample DEBUG message");
        log.error("Sample ERROR message");
        log.info("Sample INFO message");
        log.warn("Sample WARN message");
	}

}
