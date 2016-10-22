package TestaInte;

import java.util.ArrayList;

public class FakeFile extends File {

	private long size;
	private ArrayList<String> text = new ArrayList<>();
	
	public FakeFile(String name) {
		this(name, 100);
		
	}

	public FakeFile(String name, long size) {
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
	public long getSize() {		// TODO Auto-generated method stub
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
