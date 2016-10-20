package inte;

import java.util.ArrayList;

public class WcFake extends Wc {
	
	private ArrayList<String> text = new ArrayList<>();
	
	public WcFake(){
		super();
		text.add("hej	");
		text.add("	hopp ");
		text.add("lille  skutt");
		text.add("skalman ");
		text.add(" bamse");
		text.add("Husmusen ");
	}
	
	@Override
	public ArrayList<String> getFileText(){
		return text;
	}
}
