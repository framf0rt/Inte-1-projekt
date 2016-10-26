package test;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

public class CmdTestSuite {

	
	

	@RunWith(Suite.class)

	@Suite.SuiteClasses({
	   CdTest.class,
	   CopyFile_Test.class,
	   DiffBeslutstabellTest.class,
	   DiffTest.class,
	   EkvivalensklassTest.class,
	   FakeDirectoryTest.class,
	   GZipTest.class,
	   LsTest.class,
	   RealDirectoryTest.class,
	   RealFileTest.class,
	   WcTest.class,
	   WcTestReal.class
	})

	public class JunitTestSuite {   
	}  	
}
