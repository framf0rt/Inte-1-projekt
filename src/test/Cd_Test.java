package test;

import inte.*;

import static org.junit.Assert.assertEquals;

import java.io.File;

import org.junit.*;

public class Cd_Test {
	
	private Cd cd = new Cd();
	
	@Before
	public void cdSet(){
		cd = new Cd();
	}
	
	@Test
	public void cdDirectoryUpwards_Test(){
		File currentDirectory = new File(getClass().getClassLoader().getResource("").getPath());
		String currentDirectoryString = cd.cdDirectoryUpwards();
		String fileParent = currentDirectory.getParentFile().getAbsolutePath();
		assertEquals(fileParent, currentDirectoryString);
	}
	
	@Test
	public void cd_GoToDirectory_short_Test(){ 
		File currentDirectory = new File(getClass().getClassLoader().getResource("").getPath());
		String currentDirectoryString = currentDirectory.getAbsolutePath();
		String target = currentDirectory.getName();	
		cd.cdDirectoryUpwards(); // Måste gå upp ett steg i mappstrukturen för att säkerställa att testet fungerar i Travis
		String current = cd.cdDirectoryShortChangePath(target);
		assertEquals(currentDirectoryString,current);
	}
	
	@Test
	public void cdDirectoryChangePath_DirectoryTrue_Test(){
		File currentDirectory = new File(getClass().getClassLoader().getResource("").getPath());
		String target = currentDirectory.getParentFile().getAbsolutePath();
		String current = cd.cdDirectoryChangePath(target);
		assertEquals(target, current);
		
	}
	
	@Test (expected=FolderDoesntExistsException.class)
	public void cdDirectoryChangePath_DirectoryFalse_Test(){
		String target ="D:\\Inte_Pro";
		cd.cdDirectoryChangePath(target);
	}
	
	@Test (expected=FolderDoesntExistsException.class)
	public void cdDirectoryChangePath_IsFile_Test(){
		File currentDirectory = new File(getClass().getClassLoader().getResource("").getPath());
		String target ="D:\\Inte_Projekt\\README.md";
		cd.cdDirectoryChangePath(target);
		
	}

}
