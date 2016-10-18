package TestaInte;

public class FakeFile extends File {

	private long size;
	
	public FakeFile(String name) {
		this(name, 100);
	}

	public FakeFile(String name, long size) {
		super(name);
		this.size=size;
	}

	@Override
	public long getSize() {		// TODO Auto-generated method stub
		return size;
	}

	@Override
	public boolean isDirectory() {
		return false;
	}

}
