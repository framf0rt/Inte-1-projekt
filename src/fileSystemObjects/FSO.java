package fileSystemObjects;

public abstract class FSO implements Comparable<FSO>{

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
	
	@Override
	public int compareTo(FSO arg0) {
		if(this.isDirectory() && arg0.isDirectory()){
			if(this.getSize()< arg0.getSize()){
				return 1;
			}
			if(this.getSize()> arg0.getSize()){
				return -1;
			}
			return 0;
		}
		if(this.isDirectory() && !arg0.isDirectory()){
			return -1;
		}
		if(!this.isDirectory() && arg0.isDirectory()){
			return 1;
		}
		if(this.getSize()< arg0.getSize()){
			return 1;
		}
		if(this.getSize()> arg0.getSize()){
			return -1;
		}
		
		return 0;
	}
}
