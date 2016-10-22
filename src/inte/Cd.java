package inte;

import java.io.File;

public class Cd {

	private File currentDirectory = new File(getClass().getClassLoader().getResource("").getPath());
	private String currentDirectoryString = "";
	
	public Cd() {

	}

	public String cdDirectoryUpwards() {
		File newPath = currentDirectory.getParentFile();
		currentDirectory = newPath;
		currentDirectoryString = newPath.getAbsolutePath();
		return currentDirectoryString;

	}

	public String cdDirectoryChangePath(String path) { // Bör även ge feedback													// til användaren
		File target = new File(path);
		if (target.isDirectory() == true) {
			currentDirectory = target;
			currentDirectoryString = currentDirectory.getAbsolutePath();
			return currentDirectoryString;
		}
		throw new FolderDoesntExistsException("Wrong path"); // Kastas om directory in existerar
		// return currentDirectory.toString();
	}

	public String cdDirectoryShortChangePath(String path) { // Bör även ge feedback til användaren
		String currentPath = currentDirectory.getAbsolutePath();
		String filePath = currentPath + "/" + path; // Forwardslash istället för backslash för att fungerar i Travis (Linux)
		File target = new File(filePath);
		if (target.isDirectory() == true) {
			currentDirectory = target;
			currentDirectoryString = currentDirectory.getAbsolutePath();
			return currentDirectoryString;
		}
		throw new FolderDoesntExistsException("Wrong path"); // Kastas om directory in existerar
		// return currentDirectory.toString();
	}

}
