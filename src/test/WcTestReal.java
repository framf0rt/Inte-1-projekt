package test;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;
import inte.*;

public class WcTestReal {

	@Test
	public void getString() {
		Wc wc = new Wc("testfile.txt");
		ArrayList<String> temp = new ArrayList<>();
		temp.add("Hej ");
		temp.add("hej hopp");
		temp.add("tjollahopp");
		assertEquals(temp, wc.getFileText());
	}
	
	@Test(expected = FileNameInvalidException.class)
	public void noneTxtFileTest(){
		Wc wc = new Wc("scifi.jpg");	
	}
	@Test
	public void getNumberOfLinesTest(){
		Wc wc = new Wc("testfile.txt");
		assertEquals(3, wc.getNumberOfLines());
	}
	@Test
	public void getNumberOfCharactersTest(){
		Wc wc = new Wc("testfile.txt");
		assertEquals(22, wc.getNumberOfCharacters());
	}

}
