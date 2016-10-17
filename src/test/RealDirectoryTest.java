package test;

import static org.junit.Assert.*;
import TestaInte.*;

import org.junit.Test;

public class RealDirectoryTest {

	@Test(expected = IllegalFilePathException.class)
	public void nullFileReference() {
		RealDirectory rl = new RealDirectory(null);
	}
	
	@Test(expected = IllegalFilePathException.class)
	public void illegalPathTest(){
		RealDirectory rl = new RealDirectory("hejhopp");
	}
	
	@Test(expected = IllegalFilePathException.class)
	public void notDirectoryTest(){
		RealDirectory rl = new RealDirectory((getClass().getClassLoader().getResource("").getPath() + "RealDirectoryTest.java"));
	}
	
	@Test
	public void getContentTest(){
		RealDirectory rl = new RealDirectory(getClass().getClassLoader().getResource("").getPath());
		FSO[] FSOContents = rl.getContent();
		java.io.File[] contents = new java.io.File(getClass().getClassLoader().getResource("").getPath()).listFiles();
		if(FSOContents.length == contents.length){
			for(int i = 0; i < FSOContents.length; i++){
				assertEquals(FSOContents[i].getName(), contents[i].getName());
			}
			
		}else{
			fail("Content arrays don't have the same length");
		}
		
	}
	
	@Test
	public void directorySizeTest(){
		RealDirectory rd = new RealDirectory(getClass().getClassLoader().getResource("").getPath()); 
		java.io.File javadirectory = new java.io.File(getClass().getClassLoader().getResource("").getPath());
		assertEquals(rd.getSize(), javadirectory.length());
	}

}
