package test;

import static org.junit.Assert.assertEquals;

import java.io.File;

import org.junit.*;

import cmd.*;

public class CdTest {

	private Cd cd = new Cd();
	File currentDirectory = new File("");

	@Before
	public void cdSet() {
		cd = new Cd();
		currentDirectory = new File(getClass().getClassLoader().getResource("").getPath());
	}

	@Test
	public void cdDirectoryUpwardsTest() {
		String currentDirectoryString = cd.cdDirectoryUpwards(currentDirectory.getPath());
		String fileParent = currentDirectory.getParentFile().getAbsolutePath();
		assertEquals(fileParent, currentDirectoryString);
	}

	@Test
	public void cdGoToDirectoryShortTest() {
		String currentDirectoryString = currentDirectory.getAbsolutePath();
		String currentPath = cd.cdDirectoryUpwards(currentDirectory.getPath()); // Måste ta ett steg upp för att säkerställa	
		// att Travis har en mapp under
		String target = currentDirectory.getName();
		String current = cd.cdDirectoryShortChangePath(currentPath, target);

		assertEquals(currentDirectoryString, current);
	}

	@Test(expected = FolderDoesntExistException.class)
	public void cdGoToDirectoryShortFailTest() {
		File currentDirectory = new File(getClass().getClassLoader().getResource("").getPath());
		cd.cdDirectoryUpwards(currentDirectory.getPath() + "");
		String target = "FAIL";
		cd.cdDirectoryShortChangePath(currentDirectory.getPath(), target);
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
