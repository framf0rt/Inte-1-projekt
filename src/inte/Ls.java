package inte;

import java.io.File;
import TestaInte.*;

import java.util.ArrayList;

public class Ls {
	
	private String currentDirectory;
	
	public Ls(){
		currentDirectory = getClass().getClassLoader().getResource("").getPath();
		
	}
	
//	public void printFilenames(){
//		
//	}
	
	public void showDirectory(FSO dir){
		System.out.println("Directory: " + dir.getName());
		
	}
	public void showFile(FSO file){
		System.out.println("File: " + file.getName());
		
	}
	public String getCurrentDirectory(){
		return currentDirectory;
	}
	
	public final void showContent(Directory dir){
		if(dir.getContent().length == 0){
			showEmptyDirectory();
		}
		for (FSO fso : dir.getContent()) { 
			if (fso.isDirectory()) { 
				 showDirectory(fso);

			}else{ 
				showFile(fso);
			} 
		}
		
	}

	public void showEmptyDirectory() {
		System.out.println("Directory is empty");
		
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
