package cmd;
import java.util.ArrayList;

import fileSystemObjects.*;
public class Diff {
	private ArrayList<ArrayList<String>> files = new ArrayList<>();
	private ArrayList<String> fileNames = new ArrayList<>();
	private ArrayList<String> identicalLines = new ArrayList<>();
	
	public Diff(File file1, File file2){
		this.files.add(file1.getFileText());
		this.files.add(file2.getFileText());
		this.fileNames.add(file1.getName());
		this.fileNames.add(file2.getName());
		
	}
	
	public void allUniqueLines(){
		uniqueLines(0,1);
		uniqueLines(1,0);
	}
	
	private void uniqueLines(int file1, int file2){
		displayLine("Unique lines for " + fileNames.get(file1));
		for(String line : files.get(file1)){
			if(!files.get(file2).contains(line)){
				displayLine(line);
			}
		}
		
		
	}
	
	public void identicalLines(boolean output){
		for(String line : files.get(0)){
			if(files.get(1).contains(line)){
				if(output){
					displayLine(line);
				}
				identicalLines.add(line);
			}
		}
	}
	
	public void identicalLinesOutput(){
		displayLine("Identical lines in both files");
		identicalLines(true);
		
	}
	public boolean identicalFiles(){
		if(files.get(0).size() != files.get(1).size()){
			return false;
		}
		identicalLines(false);
		if(identicalLines.size() != files.get(0).size()){
			return false;
		}
		return true;
	}
	
	public void displayLine(String line){
		System.out.println(line);
	}
}
