package inte;
import java.util.ArrayList;

import TestaInte.*;
public class Diff {
	private ArrayList<ArrayList<String>> files = new ArrayList<>();
	private ArrayList<String> fileNames = new ArrayList<>();
	
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
	
	public void identicalLines(){
		displayLine("Identical lines in both files");
		for(String line : files.get(0)){
			if(files.get(1).contains(line)){
				displayLine(line);
			}
		}
		
		
	}
	
	public void displayLine(String line){
		System.out.println(line);
	}
}
