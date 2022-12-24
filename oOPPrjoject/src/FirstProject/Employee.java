package FirstProject;
import java.util.Vector;

public abstract class Employee extends User{
	private static final long serialVersionUID = 1L;
	abstract void sendMesege(String id,String message);
	abstract void sendRequests(String id,String message);
}
