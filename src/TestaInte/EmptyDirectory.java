package TestaInte;



public class EmptyDirectory extends Directory {

	public EmptyDirectory(String name) {
		super(name);
		
	}

	@Override
	public FSO[] getContent() {
		return new FSO[0];
	}

	@Override
	public boolean isDirectory() {
		return true;
	}

	@Override
	public long getSize() {
		// TODO Auto-generated method stub
		return 1;
	}

}
