package cmd;

public class FileNameInvalidException extends RuntimeException{
	
	public FileNameInvalidException (String message){
		super(message);
	}

}
