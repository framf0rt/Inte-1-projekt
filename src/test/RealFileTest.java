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
	
	@Test
	public void isFileTest(){
		assertTrue(new RealFile(testPath + "/Testfile.txt").isFile());
	}
	
	@Test
	public void isDirectoryTest(){
		assertFalse(new RealFile(testPath + "/Testfile.txt").isDirectory());
	}
	
	@Test
	public void getFileTest(){
		assertEquals(new java.io.File(testPath + "/Testfile.txt"), new RealFile(testPath + "/Testfile.txt").getFile());
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
