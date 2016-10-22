package inte;

import java.io.File;
import java.io.FilenameFilter;

public class NameFileFilter implements FilenameFilter
{

	private String name;
	public NameFileFilter(String name)
	{
		this.name = name;
		//System.out.println(this.name + "*");
	}
	@Override
	public boolean accept(File dir, String name) {
		//System.out.println(name);
		if(name.contains(this.name))
		{
			return true;
		}
		return false;
	
	}

}
