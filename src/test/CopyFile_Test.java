package test;

import java.io.File;
import java.io.IOException;

import org.junit.*;

import inte.*;
import static org.junit.Assert.*;

public class CopyFile_Test {
	
	public File CreateFile()
	{
		File path = new File(getClass().getClassLoader().getResource("").getPath());

		while (!path.getName().equals("Inte-1-projekt") && path.getParent() != null) {
			path = path.getParentFile();
		}
		assertFalse(path.getParent() == null);

		File file = new File(path.getAbsolutePath() + "/FileforGZip.txt");
		return file;
	}
	
	@Test
	public void copyFile_Test(){
		CopyFile cf = new CopyFile();
		File file = CreateFile();
		try
		{
			file.createNewFile();
		}
		
		catch (IOException e) {
			e.printStackTrace();
		}
		File test = cf.copyFile(file,null);
		assertTrue(test.exists());
		assertTrue(test.length()>0);
		test.delete();
	}
	
	@Test
	public void copyFileNewPath_Test(){
		CopyFile cf = new CopyFile();
		File file = CreateFile();
		
		try
		{
			file.createNewFile();
		}
		
		catch (IOException e) {
			e.printStackTrace();
		}
		File test = cf.copyFile(file,file.getParentFile().getParentFile().getAbsolutePath());
		assertTrue(test.exists());
		assertTrue(test.length()>0);
		test.delete();
	}
	
	@Test
	public void moveFile_Test(){
		CopyFile cf = new CopyFile();
		File file = new File(CreateFile().getParentFile(),"moveTest.txt");
		try
		{
			file.createNewFile();
		}
		
		catch (IOException e) {
			e.printStackTrace();
		}
		boolean test = cf.moveFile(file,file.getParentFile().getParentFile().getAbsolutePath());
		assertTrue(test);
	}

}
