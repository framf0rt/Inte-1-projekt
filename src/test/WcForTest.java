package test;

import inte.Wc;

import java.util.ArrayList;

import TestaInte.*;
public class WcForTest extends Wc {
	
	private ArrayList<String> fileText;
	public WcForTest(File filename){
		super(filename);
		fileText = filename.getFileText();
		
	}
	
	public ArrayList<String> getTxt(){
		return fileText;
	}
}
