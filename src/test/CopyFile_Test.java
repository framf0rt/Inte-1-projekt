package test;

import java.io.File;
import java.io.IOException;

import org.junit.*;

import inte.*;
import static org.junit.Assert.*;

public class CopyFile_Test {
	
	@Test
	public void copyFile_Test(){
		CopyFile cf = new CopyFile();
		File current = new File(getClass().getClassLoader().getResource("").getPath());
		File file = new File(current + "test.txt");
		try
		{
			file.createNewFile();
		}
		
		catch (IOException e) {
			e.printStackTrace();
		}
		File test = cf.copyFile(file,file.getParentFile().getAbsolutePath());
		assertTrue(test.exists());
		test.delete();
		file.delete();
		
	}
	
	@Test
	public void copyFileNewPath_Test(){
		CopyFile cf = new CopyFile();
		File current = new File(getClass().getClassLoader().getResource("").getPath());
		File file = new File(current + "test.txt");
		//cf.copyFile(file,"C:\\Users\\Miguel\\Documents\\test2\\");
		
		try
		{
			file.createNewFile();
		}
		
		catch (IOException e) {
			e.printStackTrace();
		}
		File test = cf.copyFile(file,file.getParentFile().getParentFile().getAbsolutePath());
		assertTrue(test.exists());
		test.delete();
		file.delete();
	}
	
	@Test
	public void moveFile_Test(){
		CopyFile cf = new CopyFile();
		File current = new File(getClass().getClassLoader().getResource("").getPath());
		File file = new File(current + "test.txt");
		try
		{
			file.createNewFile();
		}
		
		catch (IOException e) {
			e.printStackTrace();
		}
		File test = cf.copyFile(file,file.getParentFile().getParentFile().getAbsolutePath());
		assertTrue(test.exists());
		test.delete();
		file.delete();
	}

}
