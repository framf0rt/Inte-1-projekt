package inte;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.zip.GZIPOutputStream;

public class GZip {

	public File gZipFile(File file) {
		byte[] buffer = new byte[1024];
		String filePath = file.getPath();

		if (file.exists() == true) {
			String pathFile = file.getParent();
			String fileName = file.getName();
			String[] strings = fileName.split("[.]");
			String fileNameWithoutFiletype = strings[0];
			File fileGZ = new File(pathFile, fileNameWithoutFiletype + ".gz");

			try {

				GZIPOutputStream gzos = new GZIPOutputStream(new FileOutputStream(fileGZ));
				FileInputStream in = new FileInputStream(filePath);

				int len;
				while ((len = in.read(buffer)) > 0) {
					gzos.write(buffer, 0, len);
				}

				in.close();
				gzos.finish();
				gzos.close();

				System.out.println("Done");

			} catch (IOException ex) {
				ex.printStackTrace();
			}
			
			return fileGZ;

		} else {
			throw new FileDoesntExistsException("File doesn't exist"); // Kastas
																		// om
																		// filen
																		// inte
																		// existerar
		}
		
	}

	public File gZipFileToPath(File file, String path) {
		File pathCheck = new File(path);

		if (file.exists() == true && pathCheck.isDirectory() == true) {
			String fileName = file.getName();
			String[] strings = fileName.split("[.]");
			String fileNameWithoutFiletype = strings[0];
			File newFilePath = new File(path);
			File fileGZ = new File(newFilePath, fileNameWithoutFiletype + ".gz");
			try {
				fileGZ.createNewFile();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return fileGZ;

		} else {
			throw new FileDoesntExistsException("File or Path doesn't exist"); // Kastas
																				// om
																				// filen
																				// inte
																				// existerar
		}

	}

	public File gZipFileToPathNewName(File file, String path, String name) {
		File pathCheck = new File(path);
		if (name != null && name != "" && name != "." && !name.contains("/") && !name.contains("\\")) {
			if (file.exists() == true && pathCheck.isDirectory() == true) {
				File newFilePath = new File(path);
				File fileGZ = new File(newFilePath, name + ".gz");
				try {
					fileGZ.createNewFile();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				return fileGZ;

			} else {
				throw new FileDoesntExistsException("File or Path doesn't exist"); // Kastas
																					// om
																					// filen
																					// inte
																					// existerar
			}
		} else {
			throw new FileNameInvalidException("File name is invalid"); // Kastas
																		// om
																		// filnamnet
																		// är
																		// felaktigt
		}

	}

}
