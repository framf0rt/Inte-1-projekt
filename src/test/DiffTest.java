package test;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

import fileSystemObjects.RealFile;

public class DiffTest {
	private final String testPath = new GetFile().getTestPath();
	private DiffOutput dft;
	
	@Test
	public void uniqueLineTest(){
		dft = new DiffOutput(new RealFile(testPath +"/TestFileWc.txt"), new RealFile(testPath + "/compareFile.txt"));
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
		dft = new DiffOutput(new RealFile(testPath +"/TestFileWc.txt"), new RealFile(testPath + "/compareFile.txt"));
		dft.displayIdenticalLines();
		ArrayList<String> correctList = new ArrayList<>();
		correctList.add("Identical lines in both files");
		correctList.add("Hej ");
		correctList.add("hej hopp");
		assertEquals(correctList, dft.getOutput());	
	}
	
	@Test
	public void identicalFileTest(){
		dft = new DiffOutput(new RealFile(testPath + "/compareFile2.txt"), new RealFile(testPath + "/compareFile.txt"));
		assertTrue(dft.identicalFiles());
		
	}
	
	@Test
	public void notIdenticalFileTest(){
		dft = new DiffOutput(new RealFile(testPath +"/TestFileWc.txt"), new RealFile(testPath + "/compareFile.txt"));
		assertFalse(dft.identicalFiles());
		
	}


}
