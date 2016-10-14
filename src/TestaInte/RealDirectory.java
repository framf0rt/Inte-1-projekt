package TestaInte;

public class RealDirectory extends Directory {

	private java.io.File dir;
	FSO[] contents;
	
	public RealDirectory(String name) {
		super(name);
		dir=new java.io.File(name);
		if(!dir.isDirectory()){
			
		}
	}

	@Override
	public FSO[] listContent() {
		java.io.File[] javafile = dir.listFiles();
		contents = new FSO[javafile.length];
		
		for(int i = 0; i < contents.length; i++){
			if(javafile[i].isDirectory()){
				contents[i] = new RealDirectory(javafile[i].getAbsolutePath());
			}else{
				contents[i] = new RealFile(javafile[i].getName(),javafile[i].getAbsolutePath());
			}
				
		}
		
		return contents;
	}

}
