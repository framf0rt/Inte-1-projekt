package inte;

import java.io.File;
import java.io.IOException;


public class GZip {
	
	

	public File gZipFile(File file){
		
		String pathFile = file.getParent();
		File fileGZ = new File(pathFile, "Gz" + ".gz");
		try {
			fileGZ.createNewFile();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return fileGZ;
	}

}
