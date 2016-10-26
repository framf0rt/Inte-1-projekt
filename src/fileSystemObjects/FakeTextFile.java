package fileSystemObjects;

import java.util.ArrayList;

public class FakeTextFile extends File {

	private long size;
	private ArrayList<String> text = new ArrayList<>();
	
	public FakeTextFile(String name) {
		this(name, 100);
		
	}

	public FakeTextFile(String name, long size) {
		super(name);
		this.size=size;
		text.add("hej	");
		text.add("	hopp ");
		text.add("lille  skutt");
		text.add("skalman ");
		text.add(" bamse");
		text.add("Husmusen ");
	}

	@Override
	public long getSize() {		
		return size;
	}

	@Override
	public boolean isDirectory() {
		return false;
	}
	public ArrayList<String> getFileText(){
		return text;
	}
}
