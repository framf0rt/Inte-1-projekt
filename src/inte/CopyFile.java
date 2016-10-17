package inte;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class CopyFile {
	
	
	
	public void copyFile(File file){
		File parentFile = file.getParentFile();
		String parentPath = parentFile.getPath();
		System.out.println(parentPath);
		String[] fileTypeSplit = file.getName().split("[.]");
		String[] strings = file.getName().split("_Copy_");
		
		
		String name = strings[0];
		String s = file.getName(); //+ "_Copy_1";
		File f = new File(file,s);
		if(strings.length == 1){
			try {
				f = new File(parentPath + "/",name +"_Copy_1" + "."+fileTypeSplit[1]);
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
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		else if(strings[1]!=null)
		{
			int i = Integer.parseInt(strings[1]);
			i++;
			System.out.println(i);
			f = new File(parentPath + "/",name +"_Copy_" + i);
			try {
				f.createNewFile();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	
		System.out.println(f.getName());
		
	}
	
	public void copyFileNewPath(File file, String path){
		
	}
	
	
	public void moveFile(File file, String path){
		
	}

}
