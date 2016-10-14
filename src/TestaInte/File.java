package TestaInte;

public abstract class File extends FSO {

	public File(String name) {
		super(name);
	}

	public abstract int getSize();
	
}
