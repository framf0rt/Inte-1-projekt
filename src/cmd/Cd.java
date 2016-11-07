package cmd;

import java.io.File;
import java.util.ArrayList;

public class Cd {

	private File currentDirectory = new File(getClass().getClassLoader().getResource("").getPath());
	private String currentDirectoryString = "";

	public String commandHandler(ArrayList<String> commandList, String path) {
		
		if(commandList.contains("help")){
			System.out.println("Commands available for cd: \"cd ..\" take one step up. \"cd path\" and \"cd folder to go to\" ");
			return "";
		}

		if (commandList.contains("..")) {
			return cdDirectoryUpwards(path);

		}
		if (!commandList.contains("..") && commandList.get(1) != null) {
			File targetPath = new File(commandList.get(1));
			if (targetPath.getPath().contains("/") || targetPath.getPath().contains("\\")) { // MÅSTE HANTERA EXCEPTION!
				return cdDirectoryChangePath(targetPath.getPath());

			} else { // MÅSTE HANTERA EXCEPTION
				return cdDirectoryShortChangePath(path, targetPath.getPath());

			}

		}
		System.out.println("Wrong command for cd, for help write \"cd help\"");
		return "";
	}

	public String cdDirectoryUpwards(String path) {
		File newDir = new File(path);
		if (newDir.isDirectory()) {
			return newDir.getParentFile().getPath();
		}
		throw new FolderDoesntExistException("Wrong path");

	}

	public String cdDirectoryChangePath(String path) { // Bör även ge feedback
														// // til användaren
		File target = new File(path);
		if (target.isDirectory() == true) {
			currentDirectory = target;
			currentDirectoryString = currentDirectory.getAbsolutePath();
			return currentDirectoryString;
		}
		throw new FolderDoesntExistException("Wrong path"); // Kastas om
															// directory in
															// existerar
		// return currentDirectory.toString();
	}

	public String cdDirectoryShortChangePath(String currentPath, String newPath) { 
		File target = new File(currentPath + "/" + newPath);
		if (target.isDirectory() == true) {
			currentDirectory = target;
			currentDirectoryString = currentDirectory.getAbsolutePath();
			return currentDirectoryString;
		}
		throw new FolderDoesntExistException("Wrong path"); // Kastas om
															// directory in
															// existerar
		// return currentDirectory.toString();
	}

}
