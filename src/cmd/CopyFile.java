package cmd;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class CopyFile {

	public File copyFile(File file, String dir) {

		if (file == null || file.exists() != true) {
			throw new FileDoesntExistException("file doesnt exist");
		}
		if (dir == null || dir.equals("")) {
			if (file.getParentFile() != null)
				dir = file.getParentFile().getAbsolutePath();
		}

		String[] fileTypeSplit = file.getName().split("[.]");

		String originalFileName = file.getName();
		File copy = new File(file, originalFileName);

		NameFileFilter filter = new NameFileFilter(fileTypeSplit[0]);
		File directory = new File(dir);

		if (!directory.isDirectory()) {
			throw new FolderDoesntExistException("Folder doesnt exist");
		}

		filter.accept(directory, fileTypeSplit[0]);
		int numberOfCopies = 0;

		for (int j = 0; j < directory.listFiles(filter).length; j++) {
			numberOfCopies++;

		}

		try {
			if (numberOfCopies > 0)
				copy = new File(directory + "/", fileTypeSplit[0] + "_Copy_" + numberOfCopies + "." + fileTypeSplit[1]);
			else
				copy = new File(directory + "/", fileTypeSplit[0] + "." + fileTypeSplit[1]);

			FileInputStream fis = new FileInputStream(file);
			byte[] buffer = new byte[1024];
			FileOutputStream fos = new FileOutputStream(copy);

			int len;
			while ((len = fis.read(buffer)) > 0) {
				fos.write(buffer, 0, len);

			}

			fis.close();

			fos.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

		return copy;
	}

	public boolean moveFile(File file, String path) {
		copyFile(file.getAbsoluteFile(), path);
		return file.delete();

	}

}
