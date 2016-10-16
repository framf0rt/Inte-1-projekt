package test;

import static org.junit.Assert.*;

import org.junit.Test;
import TestaInte.*;
;public class RealFileTest {

	@Test(expected = IllegalFilePathException.class)
	public void NotFileTest() {
		RealFile rf = new RealFile(getClass().getClassLoader().getResource("").getPath());
	}
	
	@Test(expected = IllegalFilePathException.class)
	public void illegalPathTest(){
		RealFile rf = new RealFile("illegalpath");
	}
	
	@Test(expected = IllegalFilePathException.class)
	public void nullFileReference(){
		RealFile rf = new RealFile(null);
	}
	
	@Test
	public void fileSizeTest(){
		long realFileSize = new RealFile("c:/setup.log").getSize();
		long javaFileSize = new java.io.File("c:/setup.log").length();
		assertEquals(realFileSize, javaFileSize);
	
	}
}
