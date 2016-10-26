package test;

import static org.junit.Assert.*;

import org.junit.Test;

import cmd.*;
import fileSystemObjects.*;
public class RealFileTest {
	
	private final String testPath = new GetFile().getTestPath();

	@Test(expected = FileDoesntExistException.class)
	public void NotFileTest() {
		new RealFile(getClass().getClassLoader().getResource("").getPath());
	}
	
	@Test(expected = FileDoesntExistException.class)
	public void illegalPathTest(){
		new RealFile("illegalpath");
	}
	
	@Test(expected = IllegalFilePathException.class)
	public void nullFileReference(){
		new RealFile(null);
	}
	
	@Test
	public void fileSizeTest(){
		
		
		long realFileSize = new RealFile(testPath +"/TestFileWc.txt").getSize();
		long javaFileSize = new java.io.File(testPath +"/TestFileWc.txt").length();
		assertEquals(realFileSize, javaFileSize);
	
	}
}
