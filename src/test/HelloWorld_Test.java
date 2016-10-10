package test;

import org.junit.*;
import static org.junit.Assert.assertEquals;

public class HelloWorld_Test {
	
	
	@Test
	public void mock_Pass_Test(){ // Lyckas alltid 
		assertEquals(1,1);
	}
	
	@Test
	public void mock_Fail_Test(){ // Lyckas aldrig
		assertEquals(2,1);
	}
	


}
