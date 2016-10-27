package test;

import static org.junit.Assert.*;



import org.junit.Test;

import cmd.Wc;
import fileSystemObjects.FakeFile;


public class WcTest {
	private static final Wc wc = new Wc(new FakeFile(""));
	

	@Test
	public void getNumberOfLinesTest(){
		assertEquals(6, wc.getNumberOfLines());
	}
	
	@Test
	public void getNumberOfCharactersTest(){
		assertEquals(45, wc.getNumberOfCharacters());
	}
	
	@Test
	public void getAmountOfWordsTest(){
		assertEquals(7, wc.getNumberOfWords());
	}
}
