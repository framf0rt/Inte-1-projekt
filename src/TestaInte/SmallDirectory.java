package TestaInte;

public class SmallDirectory extends Directory {
	private static final FSO[] content = new FSO[3];
	public SmallDirectory(String name) {
		super(name);
		content[0] = new EmptyDirectory("Directory1");
		content[1] = new FakeFile("File1",50);
		content[2] = new FakeFile("File2", 100);
		
	}

//	private static final FSO[] content = {new EmptyDirectory("Directory1"), new FakeFile("File1",50), new FakeFile("File2", 100)};
	
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
		long totalSize = 0;
		for(int i = 0; i < content.length; i++){
			if(content[i].isDirectory()){
				for(FSO fso : ((Directory)content[i]).getContent()){
					totalSize+=fso.getSize();
				}
				
			}else{
				totalSize += content[i].getSize();
			}
		}
		return totalSize;
	}

}
