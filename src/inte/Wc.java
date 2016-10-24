package inte;

import java.util.ArrayList;

import TestaInte.*;

public class Wc {
	private ArrayList<String> fileText;
	
	public Wc(File filename){
		fileText = filename.getFileText();
	}
		
		
	
	protected Wc(){
		
	}

	
	public long getNumberOfLines(){
		return fileText.size();
	}
	
	public long getNumberOfCharacters(){
		long characters = 0;
		for(String line: fileText){
			characters+= line.length();
		}
		return characters;
		
	}
	
	public long getAmountOfWords(){
		long words = 0;
		for(String line: fileText){
			words += line.trim().split("\\s+").length;
		}
		return words;
	}

}
