package TestaInte;

public abstract class FSO {

	private String name;

	public FSO(String name){
		
		this.name=name;
	}
	
	public String getName(){
		return name;
	}
	
	public void setName(String name){
		this.name = name;
	}
	
	public abstract boolean isDirectory();
	
	public abstract long getSize();
}
