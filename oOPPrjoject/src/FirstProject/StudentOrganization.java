package FirstProject;
import java.util.Vector;
public class StudentOrganization {
	private static StudentOrganization sO;
	private  String nameOfOrganization = "OSIT";
	private static Vector <Student> members = new Vector<Student>();
	public static synchronized StudentOrganization getStudentOrganization() {
		if(sO == null) {
			sO = new StudentOrganization();
		}
		return sO; 
	}
	private StudentOrganization() {};
	public void addMembers(Student x) {
		members.add(x);
	}
	public void showInfoMembers() {
		int i = 1 ;
		for(Student x : members) {
			System.out.println(i+"."+x.getName());
		}
	}
	public String getNameOfOrganization() {
		return nameOfOrganization;
	}
	public void setNameOfOrganization(String nameOfOrganization) {
		this.nameOfOrganization = nameOfOrganization;
	}
	public boolean isMember(Student s) {
		for(Student x : members) {
			if(x.equals(s)) {
				return true;
			}
		}
		return false;
	}
	
}
