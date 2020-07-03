package exception;

public class ListaMazosException extends Exception{
	
	private String msg;
	
	public ListaMazosException(String msg)
	{
		super(msg);	
		this.msg = msg;
	}
	
	
	
	public void setMsg(String msg) {
		this.msg = msg;
	}
	
	public String getMsg() {
		return msg;
	}
	
	@Override
	public String getMessage() {
		
		return getMsg();
	}
}
