package test;

import java.io.File;
import java.io.IOException;

import org.junit.*;

import cmd.*;

import static org.junit.Assert.*;

public class CopyFileTest {
	
	@Test
	public void copyFileTest(){
		CopyFile cf = new CopyFile();
		File file = new GetFile().getTestFile();
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
	
	@Test(expected = FileDoesntExistException.class)
	public void copyFileNullFile(){
		File file = new GetFile().getTestFile();
		String path = file.getParentFile().getAbsolutePath();
		new CopyFile().copyFile(null, path);
	}
	
	@Test(expected = FolderDoesntExistException.class)
	public void copyFilePathNotADirectory(){
		File file = new GetFile().getTestFile();
		new CopyFile().copyFile(file, file.getAbsolutePath());
	}
	
	@Test
	public void copyFileNewPathTest(){
		CopyFile cf = new CopyFile();
		File file = new GetFile().getTestFile();
		
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
		File file = new File(new GetFile().getTestFile().getParentFile(),"moveTest.txt");
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
