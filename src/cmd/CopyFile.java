package cmd;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class CopyFile {
	
	int i = 0;
	public File copyFile(File file, String dir){
		
		if(file == null || file.exists() != true)
		{
			throw new FileDoesntExistException("file doesnt exist"); 
		}
		else if(dir == null || dir == "")
		{
			dir = file.getParentFile().getAbsolutePath();
		}
		
		String[] fileTypeSplit = file.getName().split("[.]");
		String[] strings = file.getName().split("_Copy_");
		
		
		String name = strings[0];
		String s = file.getName(); 
		File f = new File(file,s);
	
		NameFileFilter filter = new NameFileFilter(fileTypeSplit[0]);
		File dirFile = new File(dir);
		
		if(!dirFile.isDirectory())
		{
			throw new FolderDoesntExistException("Folder doesnt exist");
		}
		
		filter.accept(dirFile,fileTypeSplit[0]);
		for(int j =0;j< dirFile.listFiles(filter).length;j++)
		{
			i++;
	
		}
		
		try {
			if(i>0)
			f = new File(dirFile + "/",fileTypeSplit[0] +"_Copy_" + i + "."+fileTypeSplit[1]);
			else
				f = new File(dirFile + "/",fileTypeSplit[0] + "." + fileTypeSplit[1]);

			FileInputStream fis = new FileInputStream(file);
			byte[] buffer = new byte[1024];
			FileOutputStream fos = new FileOutputStream(f);
			
			int len;
			while ((len = fis.read(buffer)) > 0) {
				fos.write(buffer, 0, len);
				
			}
			
			fis.close();
			
			fos.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return f;
	}
	
	public boolean moveFile(File file, String path)
	{
		File moveFile = copyFile(file.getAbsoluteFile(),path);
		file.delete();
		if(!file.exists())
			return true;
		else
			return false;
	}

}
