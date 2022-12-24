package FirstProject;

import java.io.FileInputStream;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Map.Entry;

public class Manager extends Employee implements Serializable{
	private static final long serialVersionUID = 1L;
	public HashMap <String,String> messages = new HashMap <String,String>();
	public  boolean openOrClose = false;
	public void createCourse(String name, String code, Faculty faculty, int credits, Teacher teacher) {
		Database db = new Database();
		Course cours = new Course();
//		cours.name = name;
//		cours.code = code;
//		cours.faculty = faculty;
//		cours.credits = credits;
//		cours.teacher = teacher;
		cours.setName(name);
		cours.setCode(code);
		cours.setFaculty(faculty);
		cours.setTeacher(teacher);
		cours.setCredits(credits);
		
//		System.out.println(cours.toString());
		db = readBase();
		db.addCourse(cours);
		writeBase(db);
	}
	
	
	
	public boolean isOpenOrClose() {
		return openOrClose;
	}
	
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

	@Override
	void sendRequests(String id, String message) {
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
	public Manager logining(String login,String password) {
		Database db = new Database();
		db = readBase();
		if(db.managers==null) {
			System.out.println("Not Have Students");
			return null;
		}

		for(Manager x : db.managers) {
			if(x.login.equals(login) && x.password.equals(password)) {
				return x;
			}
		}
		return null;
	}
	public Teacher findTeacher(String id) {
		Database db = new Database();
		db = readBase();
		if(db.teachers==null) {
			System.out.println("Not Have Teachers");
			return null;
		}
		
		for(Teacher x:db.teachers) {
			if(x.getId().equals(id)) {
				return x;
			}
		}
		return null;
	}
	public void infoAboTeachers() {
		Database db = new Database();
		db = readBase();
		if(db.teachers==null) {
			System.out.println("Not Have Students");
			return;
		}

		int i=1;
		for(Teacher x:db.teachers) {
			System.out.println(i+"."+x.getSoname()+" "+x.getName());
			i++;
		}
	}
	public void infoAboStudents() {
		Database db = new Database();
		db = readBase();
		if(db.students==null) {
			System.out.println("Not Have Students");
			return;
		}

		int i=1;
		for(Student x:db.students) {
			System.out.println(i+"."+x.getSoname()+" "+x.getName());
		}
	}
	public void statisticInfoAbSt() {
		Database db = new Database();
		db = readBase();
		if(db.students==null) {
			System.out.println("Not Have Students");
			return;
		}
		int i=1;
		for(Student x:db.students) {
			System.out.println(i+"."+x.getSoname()+" "+x.getName()+" GPA :"+x.getGPA());
		}
	}
	public void getMessages() {
		int i = 1;
		for (Entry<String, String> x : messages.entrySet()) {
			System.out.println(i+".User"+x.getKey()+" Send "+x.getValue());
		}
	}
	public void setOpenOrClose(boolean openOrClose) {
		Database db = new Database();
		db = readBase();
		for(Manager x : db.managers) {
			if(this.equals(x)) {
				x.openOrClose = true;
			}
		}
		writeBase(db);
	}



//	@Override
//	public String toString() {
//		return "Manager [messages=" + messages + ", openOrClose=" + openOrClose + "]";
//	}
	
}
