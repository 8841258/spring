package com.yedam.app;

import static org.junit.Assert.*;

import org.junit.Test;

public class BuilderClient {

	@Test
	public void test() {
		//fail("Not yet implemented");
	}

	@Test
	public void member() {
		Member member = Member.builder().id("8841258").build();
		
		assertEquals(member.getId(), "8841258");
	}
}
