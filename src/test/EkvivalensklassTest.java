package test;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

import fileSystemObjects.EmptyDirectory;
import fileSystemObjects.SmallDirectory;

public class EkvivalensklassTest {
	private LsOutput outputTest;
	private ArrayList<String> test;

	@Before
	public void beforeTest() {
		outputTest = new LsOutput();
		test = new ArrayList<>();
	}

	@Test(expected = NullPointerException.class)
	public void nullTest() {
		outputTest.showContentWithoutSize(null);
	}

	@Test
	public void showFilesTest() {
		test.add("Directory: Directory1");
		test.add("File: File1");
		test.add("File: File2");
		test.add("File: File3");
		test.add("File: File4");
		outputTest.showContentWithoutSize(new SmallDirectory("TestName"));
		assertEquals(test, outputTest.showFilesOutput);
	}

	@Test
	public void showEmpty() {
		test.add("Directory is empty");
		outputTest.showContentWithoutSize(new EmptyDirectory("TestName"));
		assertEquals(test, outputTest.showFilesOutput);
	}

	@Test
	public void showFilesSizeTest() {
		
		test.add(String.format("Directory: Directory1 Size: %.2f Byte", 0.0));
		test.add(String.format("File: File1 Size: %.2f kB", 50.0));
		test.add(String.format("File: File2 Size: %.2f MB", 100.0));
		test.add(String.format("File: File3 Size: %.2f GB", 100.0));
		test.add(String.format("File: File4 Size: %.2f TB", 100.0));
		outputTest.showContentSize(new SmallDirectory("TestName"));
		assertEquals(test, outputTest.showFilesOutput);
	}

	@Test
	public void showFilesSortedTest() {
		test.add(String.format("Directory: Directory1 Size: %.2f Byte", 0.0));
		test.add(String.format("File: File4 Size: %.2f TB", 100.0));
		test.add(String.format("File: File3 Size: %.2f GB", 100.0));
		test.add(String.format("File: File2 Size: %.2f MB", 100.0));
		test.add(String.format("File: File1 Size: %.2f kB", 50.0));
		outputTest.showContentSortedSize(new SmallDirectory("TestName"));
		assertEquals(test, outputTest.showFilesOutput);
	}

	@Test
	public void showFilesSizeEmptyDirectoryTest() {
		test.add("Directory is empty");
		outputTest.showContentSize(new EmptyDirectory("TestName"));
		assertEquals(test, outputTest.showFilesOutput);
	}

	@Test
	public void showFilesSortedEmptyDirectoryTest() {
		test.add("Directory is empty");
		outputTest.showContentSortedSize(new EmptyDirectory("TestName"));
		assertEquals(test, outputTest.showFilesOutput);
	}
}
