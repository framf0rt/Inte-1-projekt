package TestaInte;
import static org.junit.Assert.*;

import org.junit.Test;

public class LsTest {

	@Test
	public void test() {
		Ls sut = new Ls(new SmallDirectory("asdsa"));
		sut.execute();
	}

}
