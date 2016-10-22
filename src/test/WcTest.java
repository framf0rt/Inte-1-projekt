package test;

import static org.junit.Assert.*;

import org.junit.Test;

import inte.WcFake;

public class WcTest {

	@Test
	public void getNumberOfLinesTest(){
		WcFake wc = new WcFake();
		assertEquals(6, wc.getNumberOfLines());
	}
	
	@Test
	public void getNumberOfCharactersTest(){
		WcFake wc = new WcFake();
		assertEquals(45, wc.getNumberOfCharacters());
	}
	
	@Test
	public void getAmountOfWordsTest(){
		WcFake wc = new WcFake();
		assertEquals(7, wc.getAmountOfWords());
	}
}
