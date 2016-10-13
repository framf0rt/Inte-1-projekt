package inte;

import java.io.File;
import java.util.ArrayList;

public class Ls {
	
	private File[] files;
	public ArrayList<String> testarray = new ArrayList<String>();
	
	public Ls(){
		files = new File(getClass().getClassLoader().getResource("").getPath()).listFiles();
		showFiles(files);
		
		
	}
	 
	public static void main(String[] args) { 
		new Ls();
	}

	
	public void showFiles(File[] files) { 
		
		for (File file : files) { 
			if (file.isDirectory()) { 
				testarray.add("Directory: " + file.getName()); 


//	   showFiles(file.listFiles()); // Calls same method again. 

			}else{ 
				testarray.add("File: " + file.getName());
			} 
		} 	 
	} 
	
}
