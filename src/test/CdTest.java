package test;

import static org.junit.Assert.assertEquals;

import java.io.File;

import org.junit.*;

import cmd.*;

public class CdTest {

	private Cd cd = new Cd();

	@Before
	public void cdSet() {
		cd = new Cd();
	}

	@Test
	public void cdDirectoryUpwardsTest() {
		File currentDirectory = new File(getClass().getClassLoader().getResource("").getPath());
		String currentDirectoryString = cd.cdDirectoryUpwards();
		String fileParent = currentDirectory.getParentFile().getAbsolutePath();
		assertEquals(fileParent, currentDirectoryString);
	}

	@Test
	public void cdGoToDirectoryShortTest() {
		File currentDirectory = new File(getClass().getClassLoader().getResource("").getPath());
		String currentDirectoryString = currentDirectory.getAbsolutePath();
		cd.cdDirectoryUpwards(); // Måste ta ett steg upp för att säkerställa
									// att Travis har en mapp under
		String target = currentDirectory.getName();
		String current = cd.cdDirectoryShortChangePath(target);
		assertEquals(currentDirectoryString, current);
	}

	@Test(expected = FolderDoesntExistException.class)
	public void cdGoToDirectoryShortFailTest() {
		File currentDirectory = new File(getClass().getClassLoader().getResource("").getPath());
		String currentDirectoryString = currentDirectory.getAbsolutePath();
		cd.cdDirectoryUpwards();
		String target = "FAIL";
		String current = cd.cdDirectoryShortChangePath(target);
	}

	@Test
	public void cdDirectoryChangePathDirectoryTrueTest() {
		File currentDirectory = new File(getClass().getClassLoader().getResource("").getPath());
		String target = currentDirectory.getParentFile().getAbsolutePath();
		String current = cd.cdDirectoryChangePath(target);
		assertEquals(target, current);

	}

	@Test(expected = FolderDoesntExistException.class)
	public void cdDirectoryChangePathDirectoryFalseTest() {
		String target = "D:\\Inte_Pro";
		cd.cdDirectoryChangePath(target);
	}

	@Test(expected = FolderDoesntExistException.class)
	public void cdDirectoryChangePathIsFileTest() {
		String target = "D:\\Inte_Projekt\\README.md";
		cd.cdDirectoryChangePath(target);

	}

}
