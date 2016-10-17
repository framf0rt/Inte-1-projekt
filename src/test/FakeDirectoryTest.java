package test;

import static org.junit.Assert.*;

import org.junit.Test;


import TestaInte.SmallDirectory;

public class FakeDirectoryTest {

	@Test
	public void getFakeSizeTest(){
		SmallDirectory sd = new SmallDirectory("small");
		assertEquals(150, sd.getSize());
	}

}
