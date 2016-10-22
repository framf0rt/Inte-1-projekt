package test;

import static org.junit.Assert.*;

import java.util.ArrayList;
import TestaInte.*;
import org.junit.Test;
import inte.*;

public class WcTestReal {
	private WcForTest wc;
	private final String testPath = "hej";
	
	
	
	
	@Test
	public void getString() {
		wc = new WcForTest(new RealFile(getClass().getClassLoader().getResource("").getPath() +"testfile.txt"));
		ArrayList<String> temp = new ArrayList<>();
		temp.add("Hej ");
		temp.add("hej hopp");
		temp.add("tjollahopp");
		assertEquals(temp, wc.getTxt());
	}
	
	@Test(expected = FileNameInvalidException.class)
	public void noneTxtFileTest(){
		new WcForTest(new RealFile(getClass().getClassLoader().getResource("").getPath() +"scifi.jpg"));	
	}
	@Test
	public void getNumberOfLinesTest(){
		wc = new WcForTest(new RealFile(getClass().getClassLoader().getResource("").getPath() +"testfile.txt"));
		assertEquals(3, wc.getNumberOfLines());
	}
	@Test
	public void getNumberOfCharactersTest(){
		wc = new WcForTest(new RealFile(getClass().getClassLoader().getResource("").getPath() +"testfile.txt"));
		assertEquals(22, wc.getNumberOfCharacters());
	}

}
