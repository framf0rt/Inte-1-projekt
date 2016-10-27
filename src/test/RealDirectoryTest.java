package test;

import static org.junit.Assert.*;

import org.junit.Test;

import fileSystemObjects.*;

public class RealDirectoryTest {
	
	private final String testPath = new GetFile().getTestPath();

	@Test(expected = IllegalFilePathException.class)
	public void nullFileReference() {
		new RealDirectory(null);
	}
	
	@Test(expected = IllegalFilePathException.class)
	public void illegalPathTest(){
		new RealDirectory("hejhopp");
	}
	
	@Test(expected = IllegalFilePathException.class)
	public void notDirectoryTest(){
		new RealDirectory((testPath + "/Testfile.txt"));
	}
	
	
	@Test
	public void isDirectoryTest(){
		assertTrue(new RealDirectory(testPath).isDirectory());
	}
	
	@Test
	public void getContentTest(){
		RealDirectory rl = new RealDirectory(testPath);
		FSO[] FSOContents = rl.getContent();
		java.io.File[] contents = new java.io.File(testPath).listFiles();
		assertEquals(FSOContents.length, contents.length);
		for(int i = 0; i < FSOContents.length; i++){
			assertEquals(FSOContents[i].getName(), contents[i].getName());
		}
	}
	
	@Test
	public void directorySizeTest(){
		RealDirectory rd = new RealDirectory(getClass().getClassLoader().getResource("").getPath()); 
		java.io.File javadirectory = new java.io.File(getClass().getClassLoader().getResource("").getPath());
		assertEquals(rd.getSize(), javadirectory.length());
	}
	


}
