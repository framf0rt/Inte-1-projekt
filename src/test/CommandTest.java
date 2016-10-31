package test;

import static org.junit.Assert.*;

import java.util.ArrayList;

import cmd.Command;

import org.junit.Before;
import org.junit.Test;

public class CommandTest {

	private Command c;
	private String testString;

	@Before
	public void beforeTest() {
		c = new Command();
	}

	@Test
	public void normalizeNullTest() {
		testString = c.normalize(null);
		assertTrue(testString.equals(""));
	}

	@Test
	public void normalizeTest() {
		testString = c.normalize("     Hej hOpP     ");
		assertTrue(testString.equals("hej hopp"));
	}

	@Test
	public void splitCommandTest() {
		testString = c.normalize("     Hej 	  		        hOpP     ");
		ArrayList<String> command = c.splitCommand(testString);
		ArrayList<String> correctList = new ArrayList<>();
		correctList.add("hej");
		correctList.add("hopp");
		assertEquals(correctList, command);

	}
}
