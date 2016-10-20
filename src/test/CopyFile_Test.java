package test;

import java.io.File;
import org.junit.*;
import inte.*;
import static org.junit.Assert.*;

public class CopyFile_Test {
	
	@Test
	public void copyFile_Test(){
		CopyFile cf = new CopyFile();
		File current = new File(getClass().getClassLoader().getResource("").getPath());
		File file = new File("C:\\Users\\Miguel\\Documents\\test\\test.txt");
		//cf.copyFile(file,file.getParentFile().getAbsolutePath());
		cf.copyFile(file,"C:\\Users\\Miguel\\Documents\\test2\\");
		//assertTrue(file.exists());
		
	}
	
	@Test
	public void copyFileNewPath_Test(){
		
	}
	
	@Test
	public void moveFile_Test(){
		
	}

}
