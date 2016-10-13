package test;

import org.junit.*;

import inte.HelloWorld;

import static org.junit.Assert.assertEquals;

public class HelloWorld_Test {
	
	
	@Test
	public void mock_Pass_Test(){ // Lyckas alltid 
		assertEquals(1,1);
	}
	
	@Test
	public void return1_Test(){
		HelloWorld hello = new HelloWorld();
		assertEquals(hello.return1(),1);
	
	}


}
