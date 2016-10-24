package cmd;

public class FolderDoesntExistException extends RuntimeException{
	
	public FolderDoesntExistException (String message){
		super(message);
	}
	

}
