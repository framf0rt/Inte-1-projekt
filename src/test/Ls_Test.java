package test;

import org.junit.*;

import inte.*;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;

public class Ls_Test {
	
	
	@Test
	public void mock_Pass_Test(){ // Lyckas alltid 
		assertEquals(1,1);
	}
	
	@Test
	public void return1_Test(){
		Ls ls = new Ls();
		
	
	}
	
	@Test
	public void ls_Test(){
		ArrayList<String> test = new ArrayList<>();
		Ls testLs = new Ls();
		test.add("Directory: hej");
		test.add("Directory: test");
		assertEquals(test, testLs.testarray);
	}


}
