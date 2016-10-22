package test;

import static org.junit.Assert.assertFalse;

import java.io.File;

public class GetFile {
	
	
	public String getTestPath() {
		File path = new java.io.File(getClass().getClassLoader().getResource("").getPath());

		while (!path.getName().equals("Inte-1-projekt") && path.getParent() != null) {
			path = path.getParentFile();
		}
		assertFalse(path.getParent() == null);
		
		return path.getAbsolutePath();
	}
	
	
	public File getTestFile() {
		File path = new File(getClass().getClassLoader().getResource("").getPath());

		while (!path.getName().equals("Inte-1-projekt") && path.getParent() != null) {
			path = path.getParentFile();
		}
		assertFalse(path.getParent() == null);
		File file = new File(path.getAbsolutePath() + "/Testfile.txt");
		return file;
	}
	
}
