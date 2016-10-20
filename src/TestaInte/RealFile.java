package TestaInte;

public class RealFile extends File {
	
	private java.io.File file;
	public RealFile(String name, String absolutePath){
		super(name);
		if(absolutePath == null){
			throw new IllegalFilePathException("Path can't be null");
		}
		file = new java.io.File(absolutePath);
		if(!file.isFile()){
			throw new IllegalFilePathException("it's not a file");
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
	
	

}
