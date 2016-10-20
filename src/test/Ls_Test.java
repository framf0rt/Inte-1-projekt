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
		
		outputTest.showContentWithoutSize(new SmallDirectory("TestName"));
		assertEquals(test, outputTest.showFilesOutput);
	}
	
	@Test
	public void showEmpty(){
		ArrayList<String> test = new ArrayList<>();
		test.add("Directory is empty");
		LsOutputTemp outputTest = new LsOutputTemp();
		outputTest.showContentWithoutSize(new EmptyDirectory("TestName"));
		assertEquals(test, outputTest.showFilesOutput);
	}
	@Test
	public void showFilesSizeTest(){
		ArrayList<String> test = new ArrayList<>();
		test.add("Directory: Directory1 Size: 0");
		test.add("File: File1 Size: 50");
		test.add("File: File2 Size: 100");
		
		LsOutputTemp outputTest = new LsOutputTemp();
		
		outputTest.showContentSize(new SmallDirectory("TestName"));
		assertEquals(test, outputTest.showFilesOutput);
	}
	
	@Test
	public void showFilesSortedTest(){
		ArrayList<String> test = new ArrayList<>();
		test.add("Directory: Directory1 Size: 0");
		test.add("File: File2 Size: 100");
		test.add("File: File1 Size: 50");
		LsOutputTemp outputTest = new LsOutputTemp();
		outputTest.showContentSortedSize(new SmallDirectory("TestName"));
		assertEquals(test, outputTest.showFilesOutput);
	}


}
