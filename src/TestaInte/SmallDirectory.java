package TestaInte;

public class SmallDirectory extends Directory {

	public SmallDirectory(String name) {
		super(name);
		
	}

	private static final FSO[] content = {new SmallDirectory("Directory1"), new FakeFile("File1"), new FakeFile("File2")};
	
	@Override
	public FSO[] getContent() {
		return content;
	}

	@Override
	public boolean isDirectory() {
		return true;
	}

	@Override
	public long getSize() {
		return 201;
	}

}
