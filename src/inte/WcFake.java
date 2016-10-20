package inte;

import java.util.ArrayList;

public class WcFake extends Wc {
	
	private ArrayList<String> text = new ArrayList<>();
	
	public WcFake(String filename){
		super(filename);
		text.add("hej	");
		text.add("	hopp ");
		text.add("lille  skutt");
		text.add("skalman ");
		text.add(" bamse");
		text.add("Husmusen ");
	}
	public WcFake(){
		this("testfile.txt");
	}
	@Override
	public ArrayList<String> getFileText(){
		return text;
	}
}
