package test;

import org.junit.*;

import inte.*;

import static org.junit.Assert.assertEquals;

import java.io.File;
import java.util.ArrayList;

public class Ls_Test {
	private Ls testObject;
	
	@Before
	public void beforeTest(){
		testObject = new Ls();
	}
	
	
	@Test
	public void mock_Pass_Test(){ // Lyckas alltid 
		assertEquals(1,1);
	}
	
	
	@Test
	public void getDirectoryTest(){
		
		assertEquals(getClass().getClassLoader().getResource("").getPath(), testObject.getCurrentDirectory());
	}
	
	
	@Test
	public void showFilesTest(){
		ArrayList<String> test = new ArrayList<>();
		test.add("Directory: TestaInte");
		test.add("Directory: inte");
		test.add("Directory: test");
		
		LsOutputTemp outputTest = new LsOutputTemp();
		
		outputTest.showFiles(new File(testObject.getCurrentDirectory()).listFiles());
		assertEquals(test, outputTest.showFilesOutput);
	}


}
