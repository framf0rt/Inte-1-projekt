package test;

import java.io.File;
import java.util.ArrayList;

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
	public void showDirectory(FSO dir){
		showFilesOutput.add("Directory: " + dir.getName());
		
	}
	@Override
	public void showFile(FSO file){
		showFilesOutput.add("File: " + file.getName());
		
	}
	
	@Override
	public void showEmptyDirectory(){
		showFilesOutput.add("Directory is empty");
	}
}
