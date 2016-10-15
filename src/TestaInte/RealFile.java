package TestaInte;

public class RealFile extends File {
	
	private java.io.File dir;
	public RealFile(String name, String absolutePath){
		super(name);
		dir = new java.io.File(absolutePath);
		if(!dir.isFile()){
			dir.getName();
		}
		
	}
	@Override
	public int getSize() {
		// TODO Auto-generated method stub
		return (int)dir.length();
	}
	
	

}
