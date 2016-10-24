package test;

import java.util.ArrayList;

import cmd.Wc;
import fileSystemObjects.*;
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
