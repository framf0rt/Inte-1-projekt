/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import cmd.*;
import fileSystemObjects.*;
import java.io.File;

/**
 *
 * @author Anders
 */
public class ProfilerTest {

	public static void main(String[] args) {
		Ls ls = new Ls();
		RealDirectory rD = new RealDirectory("c:/Windows/");
		ls.showContentSortedSize(rD);
		ls.showContentWithoutSize(rD);
		ls.showContentSize(rD);

		DiffOutput dO = new DiffOutput(new RealFile("C:/Users/Anders/Documents/GitHub/Inte-1-projekt/Testfile.txt"),
				new RealFile("C:/Users/Anders/Documents/GitHub/Inte-1-projekt/TestfileWc.txt"));
		dO.identicalFiles();

		GZip gzip = new GZip();
		File file = new File("C:/Users/Anders/Documents/GitHub/Inte-1-projekt/Testfile.txt");
		gzip.gZipFile(file);
		

	}

}
