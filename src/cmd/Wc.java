package cmd;

import java.util.ArrayList;

import fileSystemObjects.*;

public class Wc {
	private ArrayList<String> fileText;
	
	public Wc(File filename){
		fileText = filename.getFileText();
	}
		
		
	
	public long getNumberOfLines(){
		return fileText.size();
	}
	
	public long getNumberOfCharacters(){
		long numberOfCharacters = 0;
		for(String line: fileText){
			numberOfCharacters+= line.length();
		}
		return numberOfCharacters;
		
	}
	
	public long getNumberOfWords(){
		long numberOfWords = 0;
		for(String line: fileText){
			numberOfWords += line.trim().split("\\s+").length;
		}
		return numberOfWords;
	}
	public ArrayList<String> getFileText(){
		return fileText;
	}

}
