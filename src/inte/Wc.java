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
	
//	public ArrayList<String> getFileText(){
////		ArrayList<String> lines = new ArrayList<>();
////		String temp = null;
////		try{
////			FileReader fr = new FileReader(rf.getFile());
////			BufferedReader br = new BufferedReader(fr);
////			
////			while((temp = br.readLine())!= null){
////				lines.add(temp);	
////			}
////			fr.close();
////			br.close();
////			}catch(IOException e){
////				e.printStackTrace();
////		}
////		
////		return lines;
//	}
	
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
