package Proj.Management.SaaS.Exception;

@SuppressWarnings("serial")
public class EmptyInputException  extends RuntimeException{
	public EmptyInputException(String message) {
		super(message);
	}
}
