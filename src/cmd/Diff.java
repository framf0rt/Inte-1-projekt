package cmd;

import java.util.ArrayList;

import fileSystemObjects.*;

public class Diff {
	private final int FILE1 = 0;
	private final int FILE2 = 1;
	private ArrayList<ArrayList<String>> filesText = new ArrayList<>();
	private ArrayList<String> fileNames = new ArrayList<>();
	private ArrayList<String> identicalLines = new ArrayList<>();

	public Diff(File file1, File file2) {
		this.filesText.add(file1.getFileText());
		this.filesText.add(file2.getFileText());
		this.fileNames.add(file1.getName());
		this.fileNames.add(file2.getName());

	}

	public void allUniqueLines() {
		uniqueLines(FILE1, FILE2);
		uniqueLines(FILE2, FILE1);
	}

	private void uniqueLines(int file1, int file2) {
		displayLine("Unique lines for " + fileNames.get(file1));
		for (String line : filesText.get(file1)) {
			if (!filesText.get(file2).contains(line)) {
				displayLine(line);
			}
		}

	}

	public void identicalLines(boolean display) {
		for (String line : filesText.get(FILE1)) {
			if (filesText.get(FILE2).contains(line)) {
				if (display) {
					displayLine(line);
				} else {
					identicalLines.add(line);
				}
			}
		}
	}

	public void displayIdenticalLines() {
		displayLine("Identical lines in both files");
		identicalLines(true);

	}

	public boolean identicalFiles() {
		if (filesText.get(FILE1).size() != filesText.get(FILE2).size()) {
			return false;
		}

		if (identicalLines.size() != filesText.get(FILE1).size()) {
			return false;
		}
		return true;
	}

	public void displayLine(String line) {
		System.out.println(line);
	}
}
