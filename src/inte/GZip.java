package inte;



import java.io.File;
<<<<<<< HEAD

import java.io.FileInputStream;

import java.io.FileOutputStream;

=======
import java.io.FileInputStream;
import java.io.FileOutputStream;
>>>>>>> refs/remotes/origin/master
import java.io.IOException;
import java.util.zip.GZIPOutputStream;

import java.util.zip.GZIPOutputStream;



public class GZip {

<<<<<<< HEAD


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



=======
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

>>>>>>> refs/remotes/origin/master
	public File gZipFile(File file) {



		if (file.exists() == true) {

			String pathFile = file.getParent();

			String fileName = file.getName();

			String[] strings = fileName.split("[.]");

			String fileNameWithoutFiletype = strings[0];
<<<<<<< HEAD

			File fileGZ = new File(pathFile, fileNameWithoutFiletype + "1.gz");



			gZip(fileGZ);

=======
			File fileGZ = new File(pathFile, fileNameWithoutFiletype + "1.gz");

			gZip(fileGZ);
>>>>>>> refs/remotes/origin/master
			return fileGZ;



		} else {
<<<<<<< HEAD

			throw new FileDoesntExistsException("File doesn't exist");

		}



=======
			throw new FileDoesntExistsException("File doesn't exist");
		}

>>>>>>> refs/remotes/origin/master
	}



	public File gZipFileToPath(File file, String path) {

		File pathCheck = new File(path);

<<<<<<< HEAD


		if ((file.exists() == true) && pathCheck.isDirectory() == true) {

=======
		if ((file.exists() == true) && pathCheck.isDirectory() == true) {
>>>>>>> refs/remotes/origin/master
			String fileName = file.getName();

			String[] strings = fileName.split("[.]");

			String fileNameWithoutFiletype = strings[0];
<<<<<<< HEAD

			File fileGZ = new File(pathCheck, fileNameWithoutFiletype + "2.gz");



			gZip(fileGZ);

=======
			File fileGZ = new File(pathCheck, fileNameWithoutFiletype + "2.gz");

			gZip(fileGZ);
>>>>>>> refs/remotes/origin/master
			return fileGZ;



		} else {
<<<<<<< HEAD

			throw new FileDoesntExistsException("File or Path doesn't exist");

=======
			throw new FileDoesntExistsException("File or Path doesn't exist");
>>>>>>> refs/remotes/origin/master
		}



	}



	public File gZipFileToPathNewName(File file, String path, String name) {

<<<<<<< HEAD


=======
>>>>>>> refs/remotes/origin/master
		File pathCheck = new File(path);

		if (name != null && name != "" && name != "." && !name.contains("/") && !name.contains("\\")) {

			if (file.exists() == true && pathCheck.isDirectory() == true) {
<<<<<<< HEAD

				File fileGZ = new File(pathCheck, name + "3.gz");



				gZip(fileGZ);

=======
				File fileGZ = new File(pathCheck, name + "3.gz");

				gZip(fileGZ);
>>>>>>> refs/remotes/origin/master
				return fileGZ;



			} else {
<<<<<<< HEAD

				throw new FileDoesntExistsException("File or Path doesn't exist");

=======
				throw new FileDoesntExistsException("File or Path doesn't exist");
>>>>>>> refs/remotes/origin/master
			}

		} else {
<<<<<<< HEAD

			throw new FileNameInvalidException("File name is invalid");

=======
			throw new FileNameInvalidException("File name is invalid");
>>>>>>> refs/remotes/origin/master
		}



	}



}