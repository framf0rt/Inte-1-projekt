package test;

import java.util.ArrayList;

import cmd.Diff;
import fileSystemObjects.*;
public class DiffForTest extends Diff {
	
	private ArrayList<String> output = new ArrayList<>();
	
	public DiffForTest(File file1, File file2){
		super(file1, file2);
		
	}
	@Override
	public void displayLine(String line){
		output.add(line);
	}
	public ArrayList<String> getOutput() {
		return output;
	}
	
	
}
