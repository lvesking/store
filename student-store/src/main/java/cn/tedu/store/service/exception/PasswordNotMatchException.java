package cn.tedu.store.service.exception;

public class PasswordNotMatchException extends RuntimeException {

	
	private static final long serialVersionUID = 7657016824003256805L;
	public PasswordNotMatchException(){
		
	}
	public PasswordNotMatchException(String msg){
		super(msg);
	}
}
