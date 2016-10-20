package TestaInte;

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
//			System.out.println("Båda är mappar");
			return 0;
		}
		if(this.isDirectory() && !arg0.isDirectory()){
//			System.out.println("en fil en mapp");
			return -1;
		}
		if(!this.isDirectory() && arg0.isDirectory()){
//			System.out.println("En mapp en fil");
			return 1;
		}
		if(this.getSize()< arg0.getSize()){
			System.out.println(-1);
			return 1;
		}
		if(this.getSize()> arg0.getSize()){
			System.out.println(1);
			return -1;
		}
		System.out.println(0);
		return 0;
	}
}
