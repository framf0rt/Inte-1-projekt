package test;

import org.junit.*;
import TestaInte.*;

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
		test.add("Directory: Directory1");
		test.add("File: File1");
		test.add("File: File2");
		
		LsOutputTemp outputTest = new LsOutputTemp();
		
		outputTest.showContent(new SmallDirectory("TestName"));
		assertEquals(test, outputTest.showFilesOutput);
	}
	
	@Test
	public void showEmpty(){
		ArrayList<String> test = new ArrayList<>();
		test.add("Directory is empty");
		LsOutputTemp outputTest = new LsOutputTemp();
		outputTest.showContent(new EmptyDirectory("TestName"));
		assertEquals(test, outputTest.showFilesOutput);
	}


}
