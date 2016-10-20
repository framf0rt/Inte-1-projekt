package inte;
import java.io.*;
import java.util.ArrayList;

import TestaInte.*;

public class Wc {
	private String filename;
	private RealFile rf;
	
	public Wc(String filename){
		new RealDirectory(getClass().getClassLoader().getResource("").getPath());
		rf = new RealFile(getClass().getClassLoader().getResource("").getPath() +filename);
		if (!filename.contains(".txt")){
			throw new FileNameInvalidException("Only txts!");
		}
		
		
	}
	protected Wc(){
		
	}
	
	public ArrayList<String> getFileText(){
		ArrayList<String> lines = new ArrayList<>();
		String temp = null;
		try{
			FileReader fr = new FileReader(rf.getFile());
			BufferedReader br = new BufferedReader(fr);
			
			while((temp = br.readLine())!= null){
				lines.add(temp);	
			}
			fr.close();
			br.close();
			}catch(IOException e){
				e.printStackTrace();
		}
		
		return lines;
	}
	
	public long getNumberOfLines(){
		return getFileText().size();
	}
	
	public long getNumberOfCharacters(){
		ArrayList<String> temp = getFileText();
		long characters = 0;
		for(String line: temp){
			characters+= line.length();
		}
		return characters;
		
	}
	
	public long getAmountOfWords(){
		long words = 0;
		ArrayList<String> temp = getFileText();
		for(String line: temp){
			words += line.trim().split("\\s+").length;
		}
		return words;
	}

}
