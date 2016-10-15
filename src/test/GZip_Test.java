package test;

import org.junit.*;
import inte.*;

import static org.junit.Assert.*;

import java.io.File;
import java.io.IOException;

public class GZip_Test {

	@Test
	public void gZip_MakeGzFileWithSameName_Test() {
		GZip gz = new GZip();
		File file = new File("NO" + ".txt");

		try {
			file.createNewFile();
			File gzFile = gz.gZipFile(file);
			assertTrue(file.exists());
			assertTrue(gzFile.exists());
			file.delete(); // Delete av filer för att undvika problem med andra
							// tester
			gzFile.delete();
			assertFalse(file.exists());
			assertFalse(gzFile.exists());

		} catch (IOException e) {
			e.printStackTrace();
		}

	}
	
	@Test (expected=FileDoesntExistsException.class)
	public void gZip_FileDoesntExist_Test(){
		GZip gz = new GZip();
		File file = new File("NO" + ".txt");
		gz.gZipFile(file);
		file.delete();
		
	}


	@Test
	public void gZip_MakeGzFileSameNameNewPath_Test() {
		GZip gz = new GZip();
		File currentDirectory = new File(getClass().getClassLoader().getResource("").getPath());
		File file = new File(currentDirectory, "NO" + ".txt");
		
		
		try {
			file.createNewFile();
			File parentFile = file.getParentFile();
			File gzFile = gz.gZipFileToPath(file, parentFile.getAbsolutePath()); // MUST CHANGE PATH!!!
			assertTrue(file.exists());
			assertTrue(gzFile.exists());
			file.delete();
			gzFile.delete();
			assertFalse(file.exists());
			assertFalse(gzFile.exists());

		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	@Test (expected=FileDoesntExistsException.class) 
	public void gZipNewPath_FileDoesntExist_Test(){
		GZip gz = new GZip();
		File currentDirectory = new File(getClass().getClassLoader().getResource("").getPath());
		File file = new File("NO" + ".txt");
		file.delete();
		gz.gZipFileToPath(file, currentDirectory.getAbsolutePath());
		
	}
	
	@Test (expected=FileDoesntExistsException.class) 
	public void gZipNewPath_PathDoesntExist_Test(){
		GZip gz = new GZip();
		File file = new File("NO" + ".txt");
		try {
			file.createNewFile();
			assertTrue(file.exists());
			gz.gZipFileToPath(file, "C:/tassdffasd/");
			file.delete();
			assertFalse(file.exists());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

}
