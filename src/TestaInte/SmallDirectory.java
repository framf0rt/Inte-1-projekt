package TestaInte;

public class SmallDirectory extends Directory {

	public SmallDirectory(String name) {
		super(name);
		// TODO Auto-generated constructor stub
	}

	private static final FSO[] content = {new FakeFile("File1"), new FakeFile("File2")};
	
	@Override
	public FSO[] listContent() {		// TODO Auto-generated method stub
		return content;
	}

}
