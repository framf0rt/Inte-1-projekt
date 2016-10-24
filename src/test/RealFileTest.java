package test;

import static org.junit.Assert.*;
import inte.*;
import org.junit.Test;
import TestaInte.*;
public class RealFileTest {

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
		long realFileSize = new RealFile("c:/Recovery.txt").getSize();
		long javaFileSize = new java.io.File("c:/Recovery.txt").length();
		assertEquals(realFileSize, javaFileSize);
	
	}
}
