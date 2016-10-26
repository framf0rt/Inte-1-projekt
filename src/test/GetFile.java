package test;

import java.io.File;

import cmd.FolderDoesntExistException;

public class GetFile {

	public String getTestPath() {
		File path = new java.io.File(getClass().getClassLoader().getResource("").getPath());

		while (!path.getName().equals("Inte-1-projekt") && path.getParent() != null) {
			path = path.getParentFile();
		}
		if (path.getParent() == null) {
			throw new FolderDoesntExistException("Parent folder is null");
		}

		return path.getAbsolutePath();
	}

	public File getTestFile() {
		File path = new File(getClass().getClassLoader().getResource("").getPath());

		while (!path.getName().equals("Inte-1-projekt") && path.getParent() != null) {
			path = path.getParentFile();
		}
		if (path.getParent() == null) {
			throw new FolderDoesntExistException("Parent folder is null");
		}
		File file = new File(path.getAbsolutePath() + "/Testfile.txt");
		return file;
	}

}
