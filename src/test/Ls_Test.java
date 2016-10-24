package test;

import org.junit.*;

import cmd.*;
import fileSystemObjects.*;

import static org.junit.Assert.assertEquals;

import java.io.File;
import java.util.ArrayList;

public class Ls_Test {
	private LsOutputTemp outputTest;
	
	@Before
	public void beforeTest(){
		outputTest = new LsOutputTemp();
	}
	
	

	
	
	@Test
	public void getDirectoryTest(){
		
		assertEquals(getClass().getClassLoader().getResource("").getPath(), outputTest.getCurrentDirectory());
	}
	
	
	@Test
	public void showFilesTest(){
		ArrayList<String> test = new ArrayList<>();
		outputTest = new LsOutputTemp();
		test.add("Directory: Directory1");
		test.add("File: File1");
		test.add("File: File2");
		outputTest.showContentWithoutSize(new SmallDirectory("TestName"));
		assertEquals(test, outputTest.showFilesOutput);
	}
	
	@Test
	public void showEmpty(){
		ArrayList<String> test = new ArrayList<>();
		test.add("Directory is empty");
		outputTest.showContentWithoutSize(new EmptyDirectory("TestName"));
		assertEquals(test, outputTest.showFilesOutput);
	}
	@Test
	public void showFilesSizeTest(){
		ArrayList<String> test = new ArrayList<>();
		test.add("Directory: Directory1 Size: 0");
		test.add("File: File1 Size: 50");
		test.add("File: File2 Size: 100");
		
		outputTest.showContentSize(new SmallDirectory("TestName"));
		assertEquals(test, outputTest.showFilesOutput);
	}
	
	@Test
	public void showFilesSortedTest(){
		ArrayList<String> test = new ArrayList<>();
		test.add("Directory: Directory1 Size: 0");
		test.add("File: File2 Size: 100");
		test.add("File: File1 Size: 50");
		outputTest.showContentSortedSize(new SmallDirectory("TestName"));
		assertEquals(test, outputTest.showFilesOutput);
	}


}
