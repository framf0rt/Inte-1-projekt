package cmd;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import test.*;

public class Command {
	
	private Scanner scanner;
	private String path;

	public Command() {
		scanner = new Scanner(System.in);
		path = new GetFile().getTestPath(); // ÄNDRA
	}

	public static void main(String[] args) {

		Command cmd = new Command();
		cmd.run();
	}
	
	public void run(){
		helpText();
		do{
			System.out.print(path + ">");
			String s = readCommand();
			System.out.println();
			s = normalize(s);
			ArrayList<String> command = splitCommand(s);
			commandInterpret(command);
		}while(true);	
	}
	
	public ArrayList<String> splitCommand(String s) {
		String[] strings = s.split("\\s+");
		return new ArrayList<String>(Arrays.asList(strings));      	
	}

	public String normalize(String s){
		if(s == null){
			return "";
		}
		return s.toLowerCase().trim();
	}
	
	public String readCommand(){
		String s = scanner.nextLine();
		return s;
	}
	
	public void helpText(){
		System.out.println("For available commands type \"help\"");
	}
	
	public void availableCommands(){
		System.out.println("Each command has specific help, type command followed by help");
		System.out.println("LS");
		System.out.println("Help");
		System.out.println("Quit");
	}
	
	public void commandInterpret(ArrayList<String> command) {

		switch (command.get(0)) {
		case "quit":
			quit();
			break;
		case "help":
			availableCommands();
			break;
		default:
			System.out.println("Command doesn't exist!");
			helpText();
			break;
		}
	}
	
	public void quit(){
		System.exit(0);
	}
}
