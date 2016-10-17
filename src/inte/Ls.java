package inte;

import java.io.File;
import TestaInte.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class Ls {
	
	private String currentDirectory;
	
	public Ls(){
		currentDirectory = getClass().getClassLoader().getResource("").getPath();
		
	}
	
//	public void printFilenames(){
//		
//	}
	
	protected void showDirectory(FSO dir, boolean showSize){
		if(showSize){
			System.out.println("Directory: " + dir.getName() + "Size: " + dir.getSize());
		}else{
			System.out.println("Directory: " + dir.getName());
		}
		
		
	}
	protected void showFile(FSO file, boolean showSize){
		if(showSize){
			System.out.println("File: " + file.getName() + "Size: " + file.getSize());
		}else{
			System.out.println("File: " + file.getName());
		}
	}
	public String getCurrentDirectory(){
		return currentDirectory;
	}
	
	public final void showContent(Directory dir, boolean showSize, boolean sortSize){
		if(dir.getContent().length == 0){
			showEmptyDirectory();
		}
		for (FSO fso : ((sortSize)?sortContent(dir):dir.getContent())) { 
			if (fso.isDirectory()) { 
				 showDirectory(fso, showSize);

			}else{ 
				showFile(fso, showSize);
			} 
		}
		
	}
	public FSO[] sortContent(Directory dir){
		FSO[] temp = dir.getContent();
		Arrays.sort(temp);
//		for(FSO tmp: temp){
//			System.out.println(tmp.getSize());
//		}
		return temp;
	}
	public void showContentSize(Directory dir){
		showContent(dir, true, false);
		
	}
	public void showContentWithoutSize(Directory dir){
		showContent(dir, false, false);
	}

	protected void showEmptyDirectory() {
		System.out.println("Directory is empty");
		
	}
	public void showContentSortedSize(Directory dir){
		showContent(dir, true, true);
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
