package inte;

import java.io.File;

public class Cd {
	
	private File currentDirectory = new File(getClass().getClassLoader().getResource("").getPath());
	private String currentDirectoryString = "";
	
	public Cd(){
		
		
	}
	
	public String cdDirectoryUpwards(){
		File newPath = currentDirectory.getParentFile();
		currentDirectory = newPath;
		currentDirectoryString = newPath.getAbsolutePath();
		return currentDirectoryString;
		
	}
	
	public String cdDirectoryChangePath(String path){ // Bör även ge feedback til användaren 
	
		File target = new File(path);
		if(target.isDirectory() == true){
			currentDirectory = target;
			System.out.println(currentDirectory.isDirectory());
			System.out.println(currentDirectory.isFile());
			currentDirectoryString = currentDirectory.getAbsolutePath();
			System.out.println(currentDirectory.toString());
			return currentDirectoryString;
		}
		
		throw new FolderDoesntExistsException("Wrong path");
		//return currentDirectory.toString();
	}

}
