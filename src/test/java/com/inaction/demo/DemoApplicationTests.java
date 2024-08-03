package com.inaction.demo;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class DemoApplicationTests {


	static final String TEST = "a";

	@Test
	void contextLoads() {
		assertEquals("a", TEST);
	}

}
