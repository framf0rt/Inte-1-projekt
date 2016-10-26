package cmd;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.zip.GZIPOutputStream;

public class GZip {

	private static final byte[] buffer = new byte[1024];

	public void gZip(File fileToGZip) {
		String filePath = fileToGZip.getAbsolutePath();
		try {
			FileOutputStream fos = new FileOutputStream(fileToGZip);
			GZIPOutputStream gzipos = new GZIPOutputStream(fos);
			FileInputStream fis = new FileInputStream(filePath);

			int length;
			while ((length = fis.read(buffer)) > 0) {
				gzipos.write(buffer, 0, length);
			}

			fis.close();
			gzipos.finish();
			gzipos.close();
			fos.close();

		} catch (IOException ex) {
			ex.printStackTrace();
		}

	}

	public void checkFileExists(File file) {
		if (file.exists() == true) {
			return;
		} else {
			throw new FileDoesntExistException("File doesn't exists");
		}

	}

	public void isDirectory(String path) {
		if ((new File(path)).isDirectory()) {
			return;
		} else {
			throw new FileDoesntExistException("Path is invalid");
		}
	}

	public void checkNameValid(String name) {
		if (name != null && name.equals("") && !name.contains(".") && !name.contains("/") && !name.contains("\\")
				&& !name.contains(("\\s+"))) {
			return;
		} else {
			throw new FileNameInvalidException("File name is invalid");
		}
	}

	public File gZipFile(File file) {
		checkFileExists(file);

		// RealFile realfile = new RealFile(file.getAbsolutePath());

		String filePath = file.getParent();
		String fileName = file.getName();
		String[] strings = fileName.split("[.]");
		String fileNameWithoutFiletype = strings[0];
		File fileToGZip = new File(filePath, fileNameWithoutFiletype + ".gz");
		gZip(fileToGZip);
		return fileToGZip;

	}

	public File gZipFileToPath(File file, String path) {
		checkFileExists(file);
		isDirectory(path);
		String filename = file.getName();
		String[] strings = filename.split("[.]");
		String fileNameWithoutFiletype = strings[0];
		File fileGZ = new File(path, fileNameWithoutFiletype + ".gz");
		gZip(fileGZ);
		return fileGZ;

	}

	public File gZipFileToPathNewName(File file, String path, String name) {
		checkFileExists(file);
		isDirectory(path);
		checkNameValid(name);

		File fileGZ = new File(path, name + ".gz");
		gZip(fileGZ);
		return fileGZ;

	}

}
