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
		File file = new File("test.txt");


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

	@Test(expected = FileDoesntExistsException.class)
	public void gZip_FileDoesntExist_Test() {
		File file = new File("test.txt");
		GZip gz = new GZip();
		file.delete();
		gz.gZipFile(file);
		

	}

	@Test
	public void gZip_MakeGzFileSameNameNewPath_Test() {
		GZip gz = new GZip();
		File currentDirectory = new File(getClass().getClassLoader().getResource("").getPath());
		File file = new File(currentDirectory, "NO" + ".txt");

		try {
			file.createNewFile();
			File parentFile = file.getParentFile();
			File gzFile = gz.gZipFileToPath(file, parentFile.getAbsolutePath()); 													// PATH!!!
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

	@Test(expected = FileDoesntExistsException.class)
	public void gZipNewPath_FileDoesntExist_Test() {
		File file = new File("test.txt");
		GZip gz = new GZip();
		File currentDirectory = new File(getClass().getClassLoader().getResource("").getPath());
		file.delete();
		gz.gZipFileToPath(file, currentDirectory.getAbsolutePath());

	}

	@Test(expected = FileDoesntExistsException.class)
	public void gZipNewPath_PathDoesntExist_Test() {
		File file = new File("test.txt");
		GZip gz = new GZip();
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
	
	@Test
	public void gZip_MakeGzFileNewPathNewName_Test(){
		GZip gz = new GZip();
		File currentDirectory = new File(getClass().getClassLoader().getResource("").getPath());
		File file = new File(currentDirectory, "NO" + ".txt");
		String targetFileName = "YES";
		
		try {
			file.createNewFile();
			File parentFile = file.getParentFile();
			assertTrue(file.exists());
			File gzFile = gz.gZipFileToPathNewName(file, parentFile.getAbsolutePath(), targetFileName);
			assertEquals(gzFile.getName(), targetFileName + ".gz"); // See that the file has right name
			File gzParentFile = gzFile.getParentFile();
			assertEquals(gzParentFile.getAbsolutePath(), parentFile.getAbsolutePath()); // See that the file has right path
			assertTrue(gzFile.exists()); // See that the file exist
			gzFile.delete();
			file.delete();
			assertFalse(gzFile.exists()); // See that the file is removed after test
			assertFalse(file.exists());
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
	}
	
	@Test (expected = FileDoesntExistsException.class)
	public void gZip_NewPathNewName_PathDoesntExist_Test(){
		File file = new File("test.txt");
		GZip gz = new GZip();
		try {
			file.createNewFile();
			assertTrue(file.exists());
			gz.gZipFileToPathNewName(file, "C:/tassdffasd/", "YES");
			file.delete();
			assertFalse(file.exists());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		
	}
	
	@Test (expected = FileDoesntExistsException.class)
	public void gZip_NewPathNewName_FileDoesntExist_Test(){
		File file = new File("test.txt");
		GZip gz = new GZip();
		File currentDirectory = new File(getClass().getClassLoader().getResource("").getPath());
		file.delete();
		gz.gZipFileToPath(file, currentDirectory.getAbsolutePath());

	}
	
	@Test (expected = FileNameInvalidException.class)
	public void gZip_NewPathNewName_NameInvalid_Test(){
		File file = new File("test.txt");
		GZip gz = new GZip();
		File currentDirectory = new File(getClass().getClassLoader().getResource("").getPath());
		try {
			file.createNewFile();
			assertTrue(file.exists());
			gz.gZipFileToPathNewName(file, currentDirectory.getAbsolutePath(), ".");
			file.delete();
			assertFalse(file.exists());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
