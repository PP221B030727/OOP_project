package FirstProject;

import java.io.FileInputStream;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Map.Entry;
import java.util.Vector;

public class Teacher extends Employee implements Serializable{
	
	private static final long serialVersionUID = 1L;
   
	public HashMap <String,String> messages = new HashMap <String,String>();
	public Vector <Course> courses = new Vector <Course>();
	@Override
	void sendMesege(String id , String message) {
		Database db = readBase();
		if(db.teachers!=null) {
			for(Teacher x : db.teachers) {
				if(id.equals(x.getId())) {
					x.messages.put(id, message);
				}
			}
		}
		if(db.admins!=null) {
			for(Admin x : db.admins) {
				if(id.equals(x.getId())) {
					x.messages.put(id, message);
				}
			}
		}
		if(db.managers!=null) {
			for(Manager x : db.managers) {
				if(id.equals(x.getId())) {
					x.messages.put(id, message);
				}
			}
		}
		
		writeBase(db);

		
	}
	

	public Vector<Course> getCourses() {
		return courses;
	}


	@Override
	void sendRequests(String id , String message) {
		// TODO Auto-generated method stub
		
	}
	public void writeBase(Database db) {
		try {
			FileOutputStream fos = new FileOutputStream("Base.txt");
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			oos.writeObject(db);
			fos.close();
		}
		catch(IOException e){
			e.printStackTrace();
		}
	}
	public Database readBase() {
		try {
			FileInputStream fis = new FileInputStream("Base.txt");
			ObjectInputStream ois = new ObjectInputStream(fis);
			Database db = (Database) ois.readObject();
			ois.close();
			return db;
		}	
		catch(IOException e){
			e.printStackTrace();
		}
		catch(ClassNotFoundException e) {
			e.printStackTrace();
		}
		return new Database();
	}

	public void getMessages() {
		int i = 1;
		for (Entry<String, String> x : messages.entrySet()) {
			System.out.println(i+".User "+x.getKey()+" Send "+x.getValue());
			i++;
		}
	}
	public Teacher logining(String login,String password) {
		Database db = new Database();
		db = readBase();
		if(db.teachers==null) {
			System.out.println("Not have teachers");
			return null;
		}
		for(Teacher x : db.teachers) {
			if(x.login.equals(login) && x.password.equals(password)) {
				return x;
			}
		}
		return null;
	}

	public void infoCourse() {
		updateCourses();
		if(this.courses==null) {
			System.out.println("Teacher not have Courses!");
			return ;
		}
		int i=1;
		for(Course x : courses) {
			System.out.println(i+"."+x.getName());
			i++;
		}
	}
	

	public void setCourses(Vector<Course> courses) {
		this.courses = courses;
	}

	public void setMessages(HashMap<String, String> messages) {
		this.messages = messages;
	}
	public void infoAboStudents() {
		
		Database db = new Database();
		db = readBase();
		int i=1;
		if(db.students==null) {
			System.out.println("Not have Students !");
			return ;
		}
		for(Student x:db.students) {
			System.out.println(i+"."+x.getSoname()+" "+x.getName());
			i++;
		}
	}
	public void putMarks(Mark m , String idofStudent , String code) {
		Database db = new Database();
		db = readBase();
		if(db.students==null) {
			System.out.println("Not Have Students!");
			return;
		}
		Course c = new Course();
		for(Course crs : db.courses) {
			if(crs.code.equals(code)) {
				c = crs;
				break;
			}
		}
		for(Student x:db.students) {
			if(x.getId().equals(idofStudent)) {
				if(x.registeredCourses!=null) {
					for(Course z : x.registeredCourses) {
						if(z.equals(c)) {
							x.marks.put(c, m);
							System.out.println("Marked");
							writeBase(db);
							return;
						}
					}
				}
				else {
					System.out.println("The student don t have registered courses!");
					return ;
				}
				
				
			}
		}
		
	}
	public void updateCourses() {
		Database db = new Database();
		db = readBase();
		if(db.courses==null) {
			System.out.println("Not Have Courses!");
			return;
		}
		for(Course x:db.courses) {
			if(x.getTeacher().equals(this)) {
				this.courses.add(x);
				return;
			}
		}
		writeBase(db);
	}
	
	
	
	
	
	
		
}
