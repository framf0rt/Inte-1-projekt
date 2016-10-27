package cmd;

import java.util.Arrays;

import fileSystemObjects.*;

public class Ls {

	private String currentDirectory;

	public Ls() {
		currentDirectory = getClass().getClassLoader().getResource("").getPath();
	}

	protected void showDirectory(FSO dir, boolean showSize) {
		if (showSize) {
			System.out.println("Directory: " + dir.getName() + " Size: " + formattedSize(dir.getSize()));
		} else {
			System.out.println("Directory: " + dir.getName());
		}
	}

	protected void showFile(FSO file, boolean showSize) {
		if (showSize) {
			System.out.println("File: " + file.getName() + " Size: " + formattedSize(file.getSize()));
		} else {
			System.out.println("File: " + file.getName());
		}
	}

	public String getCurrentDirectory() {
		return currentDirectory;
	}

	public String formattedSize(long size) {
		double sizeDouble = size;
		int i = 0;

		while (sizeDouble > 1024) {
			i++;
			sizeDouble /= 1024;

		}
		String prefix = "";
		switch (i) {
		case 0:
			prefix = "Byte";
			break;
		case 1:
			prefix = "kB";
			break;
		case 2:
			prefix = "MB";
			break;
		case 3:
			prefix = "GB";
			break;
		
		default:
			prefix = "TB";
			break;
		}
		return String.format("%.2f %s", sizeDouble, prefix);
	}

	public final void showContent(Directory dir, boolean showSize, boolean sortSize) {
		if (dir.getContent().length == 0) {
			showEmptyDirectory();
		}
		for (FSO fso : ((sortSize) ? sortContent(dir) : dir.getContent())) {
			if (fso.isDirectory()) {
				showDirectory(fso, showSize);

			} else {
				showFile(fso, showSize);
			}
		}
	}

	public FSO[] sortContent(Directory dir) {
		FSO[] temp = dir.getContent();
		Arrays.sort(temp);
		return temp;
	}

	public void showContentSize(Directory dir) {
		showContent(dir, true, false);
	}

	public void showContentWithoutSize(Directory dir) {
		showContent(dir, false, false);
	}

	protected void showEmptyDirectory() {
		System.out.println("Directory is empty");
	}

	public void showContentSortedSize(Directory dir) {
		showContent(dir, true, true);
	}
}
