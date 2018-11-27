package cn.tedu.store.service.exception;

public class UsernameAlreadyException extends RuntimeException{

	private static final long serialVersionUID = -441465004616953610L;
	public UsernameAlreadyException(){
	}
	public  UsernameAlreadyException(String msg){
		super(msg);
	}
}
