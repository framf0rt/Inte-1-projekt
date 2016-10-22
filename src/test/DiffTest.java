package test;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

import TestaInte.RealFile;

public class DiffTest {
	private final String testPath = new GetFile().getTestPath();
	
	
	@Test
	public void uniqueLineTest(){
		DiffForTest dft = new DiffForTest(new RealFile(testPath +"/TestFileWc.txt"), new RealFile(testPath + "/compareFile.txt"));
		dft.allUniqueLines();
		ArrayList<String> correctList = new ArrayList<>();
		correctList.add("Unique lines for TestFileWc.txt");
		correctList.add("tjollahopp");
		correctList.add("Unique lines for compareFile.txt");
		correctList.add("unikrad");
		assertEquals(correctList, dft.getOutput());
	}
	@Test
	public void identicalLineTest(){
		DiffForTest dft = new DiffForTest(new RealFile(testPath +"/TestFileWc.txt"), new RealFile(testPath + "/compareFile.txt"));
		dft.identicalLines();
		ArrayList<String> correctList = new ArrayList<>();
		correctList.add("Identical lines in both files");
		correctList.add("Hej ");
		correctList.add("hej hopp");
		assertEquals(correctList, dft.getOutput());	
	}


}
