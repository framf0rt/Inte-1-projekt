package fileSystemObjects;

import java.io.IOException;
import java.util.ArrayList;

import cmd.FileDoesntExistException;
import cmd.FileNameInvalidException;



public class RealFile extends File {
	
	private java.io.File file;
	public RealFile(String name, String absolutePath){
		super(name);
		if(absolutePath == null){
			throw new IllegalFilePathException("Path can't be null");
		}
		file = new java.io.File(absolutePath);
		if(!file.isFile()){
			throw new FileDoesntExistException("it's not a file");
		}
		setName(file.getName());
		
	}
	
	public RealFile(String path){
		this("", path);
	}
	@Override
	public long getSize() {
		return file.length();
	}

	@Override
	public boolean isDirectory() {
		return file.isDirectory();
	}
	
	
	public boolean isFile(){
		return file.isFile();
	}
	
	public java.io.File getFile(){
		return file;
	}
	public ArrayList<String> getFileText(){
		if(!file.getName().contains(".txt")){
			throw new FileNameInvalidException(file.getName() + " is not a txt file");
		}
		ArrayList<String> lines = new ArrayList<>();
		String temp = null;
		try{
			java.io.FileReader fr = new java.io.FileReader(file);
			java.io.BufferedReader br = new java.io.BufferedReader(fr);
			
			while((temp = br.readLine())!= null){
				lines.add(temp);	
			}
			fr.close();
			br.close();
			}catch(IOException e){
				e.printStackTrace();
		}
		
		return lines;
	}
	

}
