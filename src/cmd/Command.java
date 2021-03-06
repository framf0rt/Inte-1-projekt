package cmd;

import java.io.File;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

import fileSystemObjects.RealDirectory;
import test.*;

public class Command {

	private Scanner scanner;
	private File fileLocation;

	public Command() {
		scanner = new Scanner(System.in);
		URL url = Command.class.getProtectionDomain().getCodeSource().getLocation();
		try {
			fileLocation = new File(url.toURI());
		} catch (URISyntaxException e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {

		Command cmd = new Command();
		cmd.run();
	}

	public void run() {
		helpText();
		do {
			System.out.print(fileLocation.getPath() + ">");
			String s = readCommand();
			System.out.println();
			s = normalize(s);
			ArrayList<String> command = splitCommand(s);
			commandInterpret(command);
		} while (true);
	}

	public ArrayList<String> splitCommand(String s) {
		String[] strings = s.split("\\s+");
		return new ArrayList<String>(Arrays.asList(strings));
	}

	public String normalize(String s) {
		if (s == null) {
			return "";
		}
		return s.toLowerCase().trim();
	}

	public String readCommand() {
		return scanner.nextLine();
	}

	public void helpText() {
		System.out.println("For available commands type \"help\"");
	}

	public void availableCommands() {
		System.out.println("Each command has specific help, type command followed by help");
		System.out.println("LS");
		System.out.println("CD");
		System.out.println("Help");
		System.out.println("Quit");
	}

	public void commandInterpret(ArrayList<String> command) {

		switch (command.get(0)) {
		case "ls":
			RealDirectory dir = new RealDirectory(fileLocation.getPath());
			new Ls().commandHandler(command, dir);
			break;
		case "cd":
			File cdChange = new File(new Cd().commandHandler(command, fileLocation.getPath()));
			if (cdChange.getPath().equals("")) {
				return;
			}
			fileLocation = cdChange;
			break;
		case "quit":
			quit();
			break;
		case "help":
			System.out.println("Command doesn't exist!");
			helpText();
			break;
		}
	}

	public void quit() {
		System.exit(0);
	}
}
