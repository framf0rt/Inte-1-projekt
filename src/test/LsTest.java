package test;

import org.junit.*;

import cmd.*;
import fileSystemObjects.*;

import static org.junit.Assert.assertEquals;

import java.io.File;
import java.util.ArrayList;

public class LsTest {
	private LsOutput outputTest;
	
	@Before
	public void beforeTest(){
		outputTest = new LsOutput();
	}
	
	@Test
	public void getDirectoryTest(){
		
		assertEquals(getClass().getClassLoader().getResource("").getPath(), outputTest.getCurrentDirectory());
	}
	
	
	@Test
	public void showFilesTest(){
		ArrayList<String> test = new ArrayList<>();
		outputTest = new LsOutput();
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
		test.add(String.format("Directory: Directory1 Size: %.2f Byte", 0.0));
		test.add(String.format("File: File1 Size: %.2f Byte", 50.0));
		test.add(String.format("File: File2 Size: %.2f Byte", 100.0));
		
		outputTest.showContentSize(new SmallDirectory("TestName"));
		assertEquals(test, outputTest.showFilesOutput);
	}
	
	@Test
	public void showFilesSortedTest(){
		ArrayList<String> test = new ArrayList<>();
		test.add(String.format("Directory: Directory1 Size: %.2f Byte", 0.0));
		test.add(String.format("File: File2 Size: %.2f Byte", 100.0));
		test.add(String.format("File: File1 Size: %.2f Byte", 50.0));
		outputTest.showContentSortedSize(new SmallDirectory("TestName"));
		assertEquals(test, outputTest.showFilesOutput);
	}


}
