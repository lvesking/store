package cn.tedu.store.service.exception;

public class UserNotFoundException extends RuntimeException{

	
	private static final long serialVersionUID = -730346692952511910L;
	public UserNotFoundException(){
		
	}
	public UserNotFoundException(String msg){
		super(msg);
	}
}
