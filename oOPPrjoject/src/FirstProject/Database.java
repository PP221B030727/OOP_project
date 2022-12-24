package FirstProject;

import java.io.Serializable;

import java.util.Vector;
import java.util.HashMap;

public class Database implements Serializable {
    private static final long serialVersionUID = 1L;
    public Vector <Student> students = new Vector<Student>();
    public Vector <Admin> admins = new Vector<Admin>();
    public Vector <Teacher> teachers = new Vector <Teacher>();
    public Vector <Manager> managers = new Vector <Manager>();
    public Vector <Course> courses = new Vector <Course>();
    public void addCourse(Course x) {
		courses.add(x);
	}
 
	public Vector <Admin> getAdmins() {
		return admins;
	}
	public void setAdmins(Vector <Admin> admins) {
		this.admins = admins;
	}
	public Vector<Student> getStudents() {
		return students;
	}
	public void setStudents(Vector <Student> students) {
		this.students = students;
	}
	public void addStudents(Student x) {
		students.add(x);
	}
    public void addAdmin(Admin x) {
    	admins.add(x);
    }
    public void addTeacher(Teacher x) {
    	teachers.add(x);
    }
    public void addMeneger(Manager x) {
    	managers.add(x);
    }
	public Vector<Teacher> getTeachers() {
		return teachers;
	}
	public void setTeachers(Vector<Teacher> teachers) {
		this.teachers = teachers;
	}
	public Vector<Manager> getManagers() {
		return managers;
	}
	public void setManagers(Vector<Manager> managers) {
		this.managers = managers;
	}
	
	
    
}
