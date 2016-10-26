package fileSystemObjects;

import java.util.ArrayList;

public abstract class File extends FSO {

	public File(String name) {
		super(name);
	}

	//public abstract long getSize();
	public abstract ArrayList<String> getFileText();
}
