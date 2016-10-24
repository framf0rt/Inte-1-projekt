package test;

import static org.junit.Assert.*;



import org.junit.Test;

import fileSystemObjects.FakeFile;


public class WcTest {
	private static final WcForTest wc = new WcForTest(new FakeFile(""));
	

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
		assertEquals(7, wc.getAmountOfWords());
	}
}
