package test;

import org.junit.*;

import inte.*;
import static org.junit.Assert.*;

import java.util.ArrayList;

public class Diff_Beslutstabell_Test {
	
	

	@Test (expected = NullPointerException.class)
	public void file_IsNull_Test(){
	Diff diff = new Diff(null, null);
	
	}
	
	public void file_IsNotComparable_Test(){
	
	
		
	}
	
	@Test 
	public void file1File2_IsIdentical_Test(){
	ArrayList<String> correctList = new ArrayList<>();
		
	}
	
	@Test
	public void file1File2_HasUniqueLines_Test(){
		
	}

}
