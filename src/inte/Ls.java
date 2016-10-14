package inte;

import java.io.File;
import java.util.ArrayList;

public class Ls {
	
	private String currentDirectory;
	
	public Ls(){
		currentDirectory = getClass().getClassLoader().getResource("").getPath();
		
	}
	
	public void printFilenames(){
		
	}
	
	public String getCurrentDirectory(){
		return currentDirectory;
	}
	
	public void showFiles(File[] files){
		for (File file : files) { 
			if (file.isDirectory()) { 
				System.out.println("Directory: " + file.getName()); 

			}else{ 
				System.out.println("File: " + file.getName());
			} 
		}
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
//	private File[] files;
//	public ArrayList<String> testarray = new ArrayList<String>();
//	
//	public Ls(){
//		files = new File(getClass().getClassLoader().getResource("").getPath()).listFiles();
//		showFiles(files);
//		
//		
//	}
	 
	 
		//new Ls();
	

	
//	public void showFiles(File[] files) { 
//		
//		for (File file : files) { 
//			if (file.isDirectory()) { 
//				testarray.add("Directory: " + file.getName()); 
//
//
////	   showFiles(file.listFiles()); // Calls same method again. 
//
//			}else{ 
//				testarray.add("File: " + file.getName());
//			} 
//		} 	 
//	} 
	
}
