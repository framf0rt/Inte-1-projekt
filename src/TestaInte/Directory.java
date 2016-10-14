package TestaInte;

public abstract class Directory extends FSO{

	public Directory(String name) {
		super(name);
	}

	public abstract FSO[] listContent();
	
}
