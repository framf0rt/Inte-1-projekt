package inte;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.zip.GZIPOutputStream;

public class GZip {

	private static final byte[] buffer = new byte[1024];

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

	public void checkFileValid(File file) {
		if (file.exists() == true) {
			return;
		} else {
			throw new FileDoesntExistException("File is invalid");
		}

	}

	public void checkPathValid(String path) {
		File file = new File(path);
		if (file.isDirectory() == true) {
			return;
		} else {
			throw new FileDoesntExistException("Path is invalid");
		}
	}

	public void checkNameValid(String name) {
		if (name != null && name != "" && name != "." && !name.contains("/") && !name.contains("\\")) {
			return;
		} else {
			throw new FileNameInvalidException("Name is invalid");
		}
	}

	public File gZipFile(File file) {
		checkFileValid(file);
		String pathFile = file.getParent();
		String fileName = file.getName();
		String[] strings = fileName.split("[.]");
		String fileNameWithoutFiletype = strings[0];
		File fileGZ = new File(pathFile, fileNameWithoutFiletype + "1.gz");
		gZip(fileGZ);
		return fileGZ;

	}

	public File gZipFileToPath(File file, String path) {
		checkFileValid(file);
		checkPathValid(path);
		File pathChecked = new File(path);
		String fileName = file.getName();
		String[] strings = fileName.split("[.]");
		String fileNameWithoutFiletype = strings[0];
		File fileGZ = new File(pathChecked, fileNameWithoutFiletype + "2.gz");
		gZip(fileGZ);
		return fileGZ;

	}

	public File gZipFileToPathNewName(File file, String path, String name) {
		checkFileValid(file);
		checkPathValid(path);
		checkNameValid(name);
		File pathChecked = new File(path);
		File fileGZ = new File(pathChecked, name + "3.gz");
		gZip(fileGZ);
		return fileGZ;

	}

}
