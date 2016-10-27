package test;

import java.io.File;
import java.io.IOException;

import org.junit.*;

import cmd.*;

import static org.junit.Assert.*;

public class CopyFileTest {
	
	public File CreateFile()
	{
		File path = new File(getClass().getClassLoader().getResource("").getPath());

		while (!path.getName().equals("Inte-1-projekt") && path.getParent() != null) {
			path = path.getParentFile();
		}
		assertFalse(path.getParent() == null);

		File file = new File(path.getAbsolutePath() + "/Testfile.txt");
		return file;
	}
	
	@Test
	public void copyFileTest(){
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
	public void copyFileNewPathTest(){
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
	public void moveFileTest(){
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
