package FirstProject;
import java.util.Vector;
import java.util.HashMap;
import java.util.Map.Entry;
/**
* @generated
*/
public class Student extends User {   
    private static final long serialVersionUID = 1L;
    public Faculty faculty;
    public typeOfStudent type;
	public int sumOf;
	public static int yearOfStudy = 1;
	public double GPA;
	Vector <Course> completedСourses = new Vector <Course>(); 
	Vector <Course> registeredCourses = new Vector<Course>();
	HashMap <Course , Mark > marks = new HashMap<Course,Mark>();
	public void setId() {
		if(type == typeOfStudent.Bachelor) {
			this.id = this.id.replace('S', 'B');
		}
		else if(type == typeOfStudent.Magistr) {
			this.id = this.id.replace('S', 'M');
		}
		else {
			this.id = this.id.replace('S', 'P');
		}
	}
	public void  viewTranscript() {
		System.out.println(this.name+" Marks :");
		int i=1;
		for (Entry<Course, Mark> set : marks.entrySet()) {
           System.out.println(i+"."+set.getKey().getName() + " : " + set.getValue().toString());
       }
	}
	public void viewCourses() {
		int i = 1;
		for (Course x : registeredCourses ) {
			System.out.println(i+"."+x.getName());
			i++;
		}
	}
	public typeOfStudent getType() {
		return type;
	}
	public void setType(typeOfStudent type) {
		this.type = type;
	}
	public int getSumOf() {
		return sumOf;
	}
	public void setSumOf(int sumOf) {
		this.sumOf = sumOf;
	}
	public static int getYearOfStudy() {
		return yearOfStudy;
	}
	public static void setYearOfStudy(int yearOfStudy) {
		Student.yearOfStudy = yearOfStudy;
	}
	public double getGPA() {
		return GPA;
	}
	public void setGPA(double gPA) {
		GPA = gPA;
	}
	public void getCompletedСourses() {
		int i = 1;
		for(Course x : completedСourses) {
			System.out.println(i+"."+x.getName());
		}
	}
	public void setCompletedСourses(Vector<Course> completedСourses) {
		this.completedСourses = completedСourses;
	}
	public void getRegisteredCourses() {
		int i = 1;
		for(Course x : registeredCourses) {
			System.out.println(i+"."+x.getName());
		}
	}
	public void setRegisteredCourses(Vector<Course> registeredCourses) {
		this.registeredCourses = registeredCourses;
	}
	public HashMap<Course, Mark> getMarks() {
		return marks;
	}
	public void setMarks(HashMap<Course, Mark> marks) {
		this.marks = marks;
	}
	@Override
	public String toString() {
		System.out.println(super.toString());
		return "Student [type=" + type + ", sumOf=" + sumOf + ", GPA=" + GPA + ", completedСourses=" + completedСourses
				+ ", registeredCourses=" + registeredCourses + ", marks=" + marks + "]";
	}
	public Student logining(String login,String password) {
		Database db = new Database();
		db = readBase();
		if(db.students==null) {
			System.out.println("Not have Students");
			return null;
		}
		for(Student x : db.students) {
			if(x.login.equals(login) && x.password.equals(password)) {
				return x;
			}
		}
		return null;
	}

	public void courseReg(String code) {
		Database db = new Database();
		db = readBase();
		boolean chek = false;
		for(Manager x : db.managers) {
			if(x.isOpenOrClose()==true) {
				chek = true;
			}
		}
		Course c = new Course();
		for(Course cor:db.courses) {
			if(cor.code.equals(code)) {
				c = cor;
			}
		}
		
		if(chek) {
			for(Course x1 : completedСourses) {
				if(x1.equals(c)) {
					return;
				}
			}
			Vector <Student> students = db.students;
			for(Student x : students) {
				if(this.id.equals(x.id)) {
					x.registeredCourses.add(c);
				}
			}
			writeBase(db);
		}
		else {
			System.out.println("Registration is closed !");
		}		
		writeBase(db);
	}
	public void joinOSIT() {
		StudentOrganization.getStudentOrganization().addMembers(this);
	}
	public void viewInfoStudentOr() {
		if(StudentOrganization.getStudentOrganization().isMember(this)==true) {
			System.out.println("Student "+this.name+" is member OSIT");
		}
		else {
			System.out.println("Not Memver");
		}
	}
	
	    
}
