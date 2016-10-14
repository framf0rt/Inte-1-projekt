package TestaInte;

public class FakeFile extends File {

	private int size;
	
	public FakeFile(String name) {
		this(name, 100);
	}

	public FakeFile(String name, int size) {
		super(name);
		this.size=size;
	}

	@Override
	public int getSize() {		// TODO Auto-generated method stub
		return size;
	}

}
