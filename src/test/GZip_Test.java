package test;

import org.junit.*;
import inte.*;

import static org.junit.Assert.*;

import java.io.File;
import java.io.IOException;

public class GZip_Test {
	
	
	@Test
	public void gZip_MakeGzFileWithSameName_Test(){
	GZip gz = new GZip();
	
	File file = new File("NO" + ".txt");
	
	try {
		file.createNewFile();
		File gzFile = gz.gZipFile(file);
		assertTrue(file.exists());
		assertTrue(gzFile.exists());
		
		file.delete(); // Delete av filer för att undvika problem med andra tester
		gzFile.delete();
		assertFalse(file.exists());
		assertFalse(gzFile.exists());
		
	} catch (IOException e) {
		e.printStackTrace();
	}


	}

}
