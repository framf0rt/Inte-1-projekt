package inte;

import java.io.File;

public class Ls {
	
	public static void main(String... args) {
	    File[] files = new File("C:/Inte/").listFiles();
	    showFiles(files);
	}

	public static void showFiles(File[] files) {
	    for (File file : files) {
//	        if (file.isDirectory()) {
//	            System.out.println("Directory: " + file.getName());
//	            showFiles(file.listFiles()); // Calls same method again.
//	        } else {
	    	System.out.println("File: " + file.getName());
//	        }
	    	//Lägger till testkommentar
	    }
	}

}
