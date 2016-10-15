package inte;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.zip.GZIPOutputStream;

public class GZip {
	
	
	private File currentDirectory = new File(getClass().getClassLoader().getResource("").getPath());
	
	public File gZipFile(File file){
		
		try {
		FileInputStream fis = new FileInputStream(file);
		FileOutputStream fus = new FileOutputStream(file);
		GZIPOutputStream gzis = new GZIPOutputStream(fus);
		BufferedOutputStream bs = new BufferedOutputStream(gzis);
		
		String fileName = file.getName();
		
		
		
		
		
		
			
		} catch(IOException e) {
			e.printStackTrace();
		}
		return file;
	}

}
