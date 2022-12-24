package FirstProject;

public class Message {
	String idIn;
	String idOn;
	String message;
	Message(String idIn,String idOn,String message){
		this.idIn = idIn;
		this.idOn = idOn;
		this.message = message;
	}
	@Override
	public String toString() {
		return "Message [idIn=" + idIn + ", idOn=" + idOn + ", message=" + message + "]";
	}
	
}
