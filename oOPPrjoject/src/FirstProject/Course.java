package FirstProject;
import java.util.Vector;
import java.io.Serializable;
import java.util.HashMap;
public class Course implements Serializable {
	private static final long serialVersionUID = 1L;
	public String name;
	public String code;
	public Faculty faculty;
	public int credits;
	public Teacher teacher;
	public Vector <Student> students = new Vector<Student>();
	public HashMap <Student , Mark> mark = new HashMap <Student,Mark>();
	public Vector <String> courseFiles = new Vector<String>();
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public Faculty getFaculty() {
		return faculty;
	}
	public void setFaculty(Faculty faculty) {
		this.faculty = faculty;
	}
	public int getCredits() {
		return credits;
	}
	public void setCredits(int credits) {
		this.credits = credits;
	}
	public Teacher getTeacher() {
		return teacher;
	}
	public void setTeacher(Teacher teacher) {
		this.teacher = teacher;
	}
	public Vector<Student> getStudents() {
		return students;
	}
	public void setStudents(Vector<Student> students) {
		this.students = students;
	}
	public HashMap<Student, Mark> getMark() {
		return mark;
	}
	public void setMark(HashMap<Student, Mark> mark) {
		this.mark = mark;
	}
	public Vector<String> getCourseFiles() {
		return courseFiles;
	}
	public void setCourseFiles(Vector<String> courseFiles) {
		this.courseFiles = courseFiles;
	}
	
	public void addCourseFiles(String x) {
		courseFiles.add(x);
	}
	@Override
	public String toString() {
		return "Course [name=" + name + ", code=" + code + ", faculty=" + faculty + ", credits=" + credits
				+ ", teacher=" + teacher + ", students=" + students + ", mark=" + mark + ", courseFiles=" + courseFiles
				+ "]";
	}
}
