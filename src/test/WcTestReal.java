package test;

import static org.junit.Assert.*;

import java.util.ArrayList;

import cmd.*;
import fileSystemObjects.*;

import org.junit.Test;

public class WcTestReal {
	private WcForTest wc;
	private final String testPath = new GetFile().getTestPath();
	
	
	
	
	@Test
	public void getString() {
		wc = new WcForTest(new RealFile(testPath +"/TestfileWc.txt"));
		ArrayList<String> temp = new ArrayList<>();
		temp.add("Hej ");
		temp.add("hej hopp");
		temp.add("tjollahopp");
		assertEquals(temp, wc.getTxt());
	}
	
	@Test(expected = FileNameInvalidException.class)
	public void noneTxtFileTest(){
		new WcForTest(new RealFile(testPath +"/scifi.jpg"));	
	}
	@Test
	public void getNumberOfLinesTest(){
		wc = new WcForTest(new RealFile(testPath +"/TestfileWc.txt"));
		assertEquals(3, wc.getNumberOfLines());
	}
	@Test
	public void getNumberOfCharactersTest(){
		wc = new WcForTest(new RealFile(testPath +"/TestfileWc.txt"));
		assertEquals(22, wc.getNumberOfCharacters());
	}

}
