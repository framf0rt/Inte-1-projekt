package test;

import org.junit.*;
import inte.*;

import static org.junit.Assert.*;

import java.io.File;

public class GZip_Test {

	public File getTestFile() {
		File path = new File(getClass().getClassLoader().getResource("").getPath());

		while (!path.getName().equals("Inte-1-projekt") && path.getParent() != null) {
			path = path.getParentFile();
		}
		assertFalse(path.getParent() == null);
		File file = new File(path.getAbsolutePath() + "/FileforGZip.txt");
		return file;
	}

	@Test
	public void gZip_MakeGzFileWithSameName_Test() {
		GZip gz = new GZip();
		File file = getTestFile();
		File gzFile = gz.gZipFile(new File(file.getAbsolutePath()));
		assertTrue(gzFile.exists());
		gzFile.delete();

	}

	@Test(expected = FileDoesntExistsException.class)
	public void gZip_FileDoesntExist_Test() {
		File file = new File("1.txt");
		GZip gz = new GZip();
		file.delete();
		gz.gZipFile(file);

	}

	@Test
	public void gZip_MakeGzFileSameNameNewPath_Test() {
		File currentDirectory = new File(getClass().getClassLoader().getResource("").getPath());
		File parent = currentDirectory.getParentFile();
		String s = parent.getAbsolutePath();
		GZip gz = new GZip();
		File file = getTestFile();
		File gzFile = gz.gZipFileToPath(file, s);
		assertTrue(gzFile.exists());
		gzFile.delete();
		assertFalse(gzFile.exists());

	}

	@Test(expected = FileDoesntExistsException.class)
	public void gZipNewPath_FileDoesntExist_Test() {
		File file = new File("2.txt");
		GZip gz = new GZip();
		File currentDirectory = new File(getClass().getClassLoader().getResource("").getPath());
		file.delete();
		gz.gZipFileToPath(file, currentDirectory.getAbsolutePath());

	}

	@Test(expected = FileDoesntExistsException.class)
	public void gZipNewPath_PathDoesntExist_Test() {
		File file = new File("3.txt");
		GZip gz = new GZip();
		gz.gZipFileToPath(file, "C:/tassdffasd/");
		file.delete();
		assertFalse(file.exists());

	}

	@Test
	public void gZip_MakeGzFileNewPathNewName_Test() {
		File currentDirectory = new File(getClass().getClassLoader().getResource("").getPath());
		File parent = currentDirectory.getParentFile();
		String s = parent.getAbsolutePath();
		GZip gz = new GZip();
		File file = getTestFile();
		File gzFile = gz.gZipFileToPathNewName(file, s, "YES");
		assertTrue(gzFile.exists());
		gzFile.delete();
		assertFalse(gzFile.exists());
	}

	@Test(expected = FileDoesntExistsException.class)
	public void gZip_NewPathNewName_PathDoesntExist_Test() {
		File file = new File("4.txt");
		GZip gz = new GZip();
		gz.gZipFileToPathNewName(file, "C:/tassdffasd/", "YES");
		file.delete();
		assertFalse(file.exists());

	}

	@Test(expected = FileDoesntExistsException.class)
	public void gZip_NewPathNewName_FileDoesntExist_Test() {
		File file = new File("5.txt");
		GZip gz = new GZip();
		File currentDirectory = new File(getClass().getClassLoader().getResource("").getPath());
		file.delete();
		gz.gZipFileToPath(file, currentDirectory.getAbsolutePath());

	}

	@Test(expected = FileNameInvalidException.class)
	public void gZip_NewPathNewName_NameInvalid_Test() {
		GZip gz = new GZip();
		File file = getTestFile();
		gz.gZipFileToPathNewName(file, file.getParentFile().getAbsolutePath(), ".");
		file.delete();
		assertFalse(file.exists());
	}
}
