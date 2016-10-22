package test;

import java.io.File;
import java.util.ArrayList;

import TestaInte.Directory;
import TestaInte.FSO;
import inte.Ls;

public class LsOutputTemp extends Ls{
	
	public ArrayList<String> showFilesOutput = new ArrayList<>();
	
//	@Override
//	public void showFiles(File[] files){
//		for (File file : files) { 
//			if (file.isDirectory()) { 
//				showFilesOutput.add("Directory: " + file.getName()); 
//
//			}else{ 
//				showFilesOutput.add("File: " + file.getName());
//			} 
//		}
//		
//	}
	@Override
	protected void showDirectory(FSO dir, boolean showSize){
		if(showSize){
			showFilesOutput.add("Directory: " + dir.getName() + " Size: " + dir.getSize());
		}else{
			showFilesOutput.add("Directory: " + dir.getName());
		}
	}
	@Override
	protected void showFile(FSO file, boolean showSize){
		if(showSize){
			showFilesOutput.add("File: " + file.getName() + " Size: " + file.getSize());
		}else{
			showFilesOutput.add("File: " + file.getName());
		}
	}

	
	@Override
	protected void showEmptyDirectory(){
		showFilesOutput.add("Directory is empty");
	}
}
