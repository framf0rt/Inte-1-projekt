package test;

import org.junit.*;

import cmd.*;
import fileSystemObjects.RealFile;

import static org.junit.Assert.*;

import java.io.File;
import java.util.ArrayList;

public class DiffBeslutstabellTest {

	private final String testPath = new GetFile().getTestPath();

	@Test(expected = NullPointerException.class)
	public void fileIsNullTest() {
	new Diff(null, null);

	}

	@Test(expected = FileNameInvalidException.class)
	public void fileIsNotComparableTest() {
		RealFile file1 = new RealFile(testPath + "/TestFileWc.txt");
		RealFile file2 = new RealFile(testPath + "/scifi.jpg");
		new DiffOutput(file1, file2);

	}

	@Test
	public void filesIsIdenticalTest() {
		ArrayList<String> identicalList = new ArrayList<>();
		DiffOutput dOut = new DiffOutput(new RealFile(testPath + "/TestFileWc.txt"),
				new RealFile(testPath + "/compareFile.txt"));
		dOut.displayIdenticalLines();
		identicalList.add("Identical lines in both files");
		identicalList.add("Hej ");
		identicalList.add("hej hopp");
		assertEquals(identicalList, dOut.getOutput());

	}

	@Test
	public void filesIsWrongSizeTest() {
		DiffOutput dOut = new DiffOutput(new RealFile(testPath + "/Testfile.txt"),
				new RealFile(testPath + "/compareFile.txt"));
		assertFalse(dOut.identicalFiles());
	}

	@Test
	public void filesIsIdenticalUniqueLinesTest() {
		ArrayList<String> identicalList = new ArrayList<>();
		DiffOutput dOut = new DiffOutput(new RealFile(testPath + "/TestFileWc.txt"),
				new RealFile(testPath + "/TestFileWc.txt"));
		dOut.allUniqueLines();
		identicalList.add("Unique lines for TestFileWc.txt");
		identicalList.add("Unique lines for TestFileWc.txt");
		assertEquals(identicalList, dOut.getOutput());

	}

	@Test
	public void filesHasUniqueLinesTest() {
		ArrayList<String> uniqueList = new ArrayList<>();
		DiffOutput dOut = new DiffOutput(new RealFile(testPath + "/TestFileWc.txt"),
				new RealFile(testPath + "/compareFile.txt"));
		dOut.allUniqueLines();
		uniqueList.add("Unique lines for TestFileWc.txt");
		uniqueList.add("tjollahopp");
		uniqueList.add("Unique lines for compareFile.txt");
		uniqueList.add("unikrad");
		assertEquals(uniqueList, dOut.getOutput());
	}

}
