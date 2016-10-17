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
		File file = new File("C:\\Users\\Anders\\Documents\\GitHub\\Inte-1-projekt\\README.md");
		cf.copyFile(file);
		//assertTrue(file.exists());
		
	}
	
	@Test
	public void copyFileNewPath_Test(){
		
	}
	
	@Test
	public void moveFile_Test(){
		
	}

}
