package test;

import org.junit.*;
import inte.*;
import static org.junit.Assert.assertEquals;
import java.io.File;
import java.io.IOException;

public class GZip_Test {
	
	
	
	
	@Test
	public void gZipFile_Test(){
	GZip gz = new GZip();
	
	File currentDirectory = new File(getClass().getClassLoader().getResource("").getPath());
	File file = new File(currentDirectory, "NO" + ".txt");
	try {
		file.createNewFile();
		File gZFile = gz.gZipFile(file);
		System.out.println(gZFile.getAbsolutePath());
		file.delete();
		System.out.println(file.exists());
		
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
//	File[] files = currentDirectory.listFiles();
//	for(File f : files){
//		System.out.println(f.getAbsolutePath());
//	}
//	System.out.println(currentDirectory);

	}

}
