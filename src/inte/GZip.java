package inte;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.zip.GZIPOutputStream;

public class GZip {

	public void gZip(File fileGZ) {
		String filePath = fileGZ.getAbsolutePath();
		try {
			FileOutputStream fos = new FileOutputStream(fileGZ);
			GZIPOutputStream gzos = new GZIPOutputStream(fos);
			FileInputStream in = new FileInputStream(filePath);

			int len;
			while ((len = in.read(buffer)) > 0) {
				gzos.write(buffer, 0, len);
			}

			in.close();
			gzos.finish();
			gzos.close();

		} catch (IOException ex) {
			ex.printStackTrace();
		}

	}

	private byte[] buffer = new byte[1024];

	public File gZipFile(File file) {

		if (file.exists() == true) {
			String pathFile = file.getParent();
			String fileName = file.getName();
			String[] strings = fileName.split("[.]");
			String fileNameWithoutFiletype = strings[0];
			File fileGZ = new File(pathFile, fileNameWithoutFiletype + "1.gz");

			gZip(fileGZ);
			return fileGZ;

		} else {
			throw new FileDoesntExistsException("File doesn't exist");
		}

	}

	public File gZipFileToPath(File file, String path) {
		File pathCheck = new File(path);

		if ((file.exists() == true) && pathCheck.isDirectory() == true) {
			String fileName = file.getName();
			String[] strings = fileName.split("[.]");
			String fileNameWithoutFiletype = strings[0];
			File fileGZ = new File(pathCheck, fileNameWithoutFiletype + "2.gz");

			gZip(fileGZ);
			return fileGZ;

		} else {
			throw new FileDoesntExistsException("File or Path doesn't exist");
		}

	}

	public File gZipFileToPathNewName(File file, String path, String name) {

		File pathCheck = new File(path);
		if (name != null && name != "" && name != "." && !name.contains("/") && !name.contains("\\")) {
			if (file.exists() == true && pathCheck.isDirectory() == true) {
				File fileGZ = new File(pathCheck, name + "3.gz");

				gZip(fileGZ);
				return fileGZ;

			} else {
				throw new FileDoesntExistsException("File or Path doesn't exist");
			}
		} else {
			throw new FileNameInvalidException("File name is invalid");
		}

	}

}
