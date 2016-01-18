package lottoNumbers;

public class MyException extends Exception{

	 @Override
	 public String getMessage(){
		 return "WARNING : NUMBER OUT OF RANGE ";
	 }
	}