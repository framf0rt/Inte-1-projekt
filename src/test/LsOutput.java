package test;

import java.io.File;
import java.util.ArrayList;

import cmd.Ls;
import fileSystemObjects.Directory;
import fileSystemObjects.FSO;

public class LsOutput extends Ls{
	
	public ArrayList<String> showFilesOutput = new ArrayList<>();
	

	@Override
	protected void showDirectory(FSO dir, boolean showSize){
		if(showSize){
			showFilesOutput.add("Directory: " + dir.getName() + " Size: " + formattedSize(dir.getSize()));
		}else{
			showFilesOutput.add("Directory: " + dir.getName());
		}
	}
	@Override
	protected void showFile(FSO file, boolean showSize){
		if(showSize){
			showFilesOutput.add("File: " + file.getName() + " Size: " + formattedSize(file.getSize()));
		}else{
			showFilesOutput.add("File: " + file.getName());
		}
	}

	
	@Override
	protected void showEmptyDirectory(){
		showFilesOutput.add("Directory is empty");
	}
}
