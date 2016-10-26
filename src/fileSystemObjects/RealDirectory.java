package fileSystemObjects;

public class RealDirectory extends Directory {

	private java.io.File dir;
	private FSO[] contents;

	public RealDirectory(String path, String name) {
		super(name);
		if (path == null) {
			throw new IllegalFilePathException("Path can't be null");
		}
		dir = new java.io.File(path);
		if (!dir.exists()) {
			throw new IllegalFilePathException("Directory doesn't exist");
		}
		if (!dir.isDirectory()) {
			throw new IllegalFilePathException("It's not a directory");

		}
		setName(dir.getName());
	}

	public RealDirectory(String path) {
		this(path, "");
	}

	@Override
	public FSO[] getContent() {
		java.io.File[] javafile = dir.listFiles();
		contents = new FSO[javafile.length];

		for (int i = 0; i < contents.length; i++) {
			if (javafile[i].isDirectory()) {
				contents[i] = new RealDirectory(javafile[i].getAbsolutePath(), javafile[i].getName());
			} else {
				contents[i] = new RealFile(javafile[i].getName(), javafile[i].getAbsolutePath());
			}

		}

		return contents;
	}

	@Override
	public boolean isDirectory() {
		return dir.isDirectory();
	}

	@Override
	public long getSize() {
		return dir.length();
	}

}
