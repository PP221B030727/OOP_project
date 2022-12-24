package FirstProject;

import java.io.FileInputStream;
import java.util.Scanner;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Date;
import java.util.HashMap;
import java.util.Map.Entry;
import java.io.IOException;
public class Admin extends Employee implements Serializable {
	private static final long serialVersionUID = 1L;
	
	public HashMap <String,String> messages = new HashMap <String,String>();
	
	@Override
	void sendRequests(String id,String message) {
		// TODO Auto-generated method stub
		
	}
	public void addUsers(String name , String soname , typeOfUser x , String phoneNumber) {
		Database db = new Database();
		db = readBase();
		if(x==typeOfUser.Student) {
			Student newUser = new Student();
			newUser.name = name;
			newUser.soname = soname;
			newUser.login = generateLogin(name,soname);
			newUser.generatePassword(name, soname);
			newUser.id = generateId(soname,x);
			newUser.phoneNumber = phoneNumber;
			db.addStudents(newUser);
		}
		else if(x==typeOfUser.Manager) {
			Manager newUser = new Manager();

			newUser.name = name;
			newUser.soname = soname;
			newUser.login = generateLogin(name,soname);
			newUser.generatePassword(name, soname);
			newUser.id = generateId(soname,x);
			newUser.phoneNumber = phoneNumber;
			db.addMeneger(newUser);
		}
		else if(x==typeOfUser.Teacher) {
			Teacher newUser = new Teacher();
			newUser.name = name;
			newUser.soname = soname;
			newUser.login = generateLogin(name,soname);
			newUser.generatePassword(name, soname);
			newUser.id = generateId(soname,x);
			newUser.phoneNumber = phoneNumber;
			db.addTeacher(newUser);
		}	
		else if(x==typeOfUser.Admin) {
			Admin newUser = new Admin();
			newUser.name = name;
			newUser.soname = soname;
			newUser.login = generateLogin(name,soname);
			newUser.generatePassword(name, soname);
			newUser.id = generateId(soname,x);
			newUser.phoneNumber = phoneNumber;
			db.addAdmin(newUser);
		}	
		writeBase(db);
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
	
	public String generateLogin(String name , String soname) {
		return name.charAt(0)+"_"+soname;
	}
	public String generateId(String soname , typeOfUser x) {
		Date date = new Date();
		if(x == typeOfUser.Student) {
			return String.valueOf(date.getYear()%100)+"S"+String.valueOf(toHash(soname));
		}
		else if(x == typeOfUser.Manager) {
			return String.valueOf(date.getYear()%100)+"R"+String.valueOf(toHash(soname));
		}
		else if(x == typeOfUser.Admin) {
			return String.valueOf(date.getYear()%100)+"A"+String.valueOf(toHash(soname));
		}
		else{
			return String.valueOf(date.getYear()%100)+"T"+String.valueOf(toHash(soname));
		}
		
	}
	public void removeUsers(String id) {
		Database db = new Database();
		db = readBase();
		if(db.managers!=null) {
			for(Manager x : db.managers) {
				if(x.id.equals(id)) {
					db.managers.remove(x);
					System.out.println("User is Removed!");
					writeBase(db);
					return ;
				}
			}
		}
		if(db.admins!=null) {
			for(Admin x:db.admins) {
				if(x.id.equals(id)) {
					db.admins.remove(x);
					System.out.println("User is Removed!");
					writeBase(db);
					return ;
				}
			}
		}	
		if(db.students!=null) {
			for(Student x : db.students){
				if(x.id.equals(id)) {
					db.students.remove(x);
					System.out.println("User is Removed!");
					writeBase(db);
					return ;
				}
			}
		}
		if(db.teachers!=null) {
			for(Teacher x : db.teachers) {
				if(x.id.equals(id)) {
					db.teachers.remove(x);
					System.out.println("User is Removed!");
					writeBase(db);
					return ;
				}
			}
		}
		System.out.println("User is not Found !");
	}
	public void updateUsersPassword(String id) {
		Scanner sc = new Scanner(System.in);
		Database db = new Database();
		db = readBase();
		if(db.managers!=null) {
			for(Manager x : db.managers) {
				if(x.id.equals(id)) {
					System.out.println("Write New Password: ");
					String newPassword = sc.nextLine();
					x.password = newPassword;
					System.out.println("Password Updated");
					writeBase(db);
					sc.close();
					return;
				}
			}
		}
		if(db.admins!=null) {
			for(Admin x:db.admins) {
				if(x.id.equals(id)) {
					System.out.println("Write New Password: ");
					String newPassword = sc.nextLine();
					x.password = newPassword;
					System.out.println("Password Updated");
					writeBase(db);
					sc.close();
					return;
				}
			}	
		}
		if(db.students!=null) {
			for(Student x : db.students){
				if(x.id.equals(id)) {
					System.out.println("Write New Password: ");
					String newPassword = sc.nextLine();
					x.password = newPassword;
					System.out.println("Password Updated");
					writeBase(db);
					sc.close();
					return;
				}
			}
		}
		if(db.teachers!=null) {
			for(Teacher x : db.teachers) {
				if(x.id.equals(id)) {
					System.out.println("Write New Password: ");
					String newPassword = sc.nextLine();
					x.password = newPassword;
					System.out.println("Password Updated");
					writeBase(db);
					sc.close();
					return;
				}
			}
		}
		
		System.out.println("User is not Found !");
		
	}
	public void updateUsersNumber(String id) {
		Database db = new Database();
		Scanner sc = new Scanner(System.in);

		db = readBase();
		if(db.managers!=null) {
			for(Manager x : db.managers) {
				if(x.id.equals(id)) {
					System.out.println("Write New Phone Number: ");
					String newPhone = sc.nextLine();
					x.phoneNumber = newPhone;
					System.out.println("Phone Number is updated ");
					writeBase(db);
					sc.close();
					return;
				}
			}
		}
		if(db.admins!=null) {
			for(Admin x:db.admins) {
				if(x.id.equals(id)) {
					System.out.println("Write New Phone Number: ");
					String newPhone = sc.nextLine();
					x.phoneNumber = newPhone;
					System.out.println("Phone Number is updated ");
					writeBase(db);
					sc.close();
					return;
				}
			}	
		}
		
		if(db.students!=null) {
			for(Student x : db.students){
				if(x.id.equals(id)) {
					System.out.println("Write New Phone Number: ");
					String newPhone = sc.nextLine();
					x.phoneNumber = newPhone;
					System.out.println("Phone Number is updated ");
					writeBase(db);
					sc.close();
					return;
				}
			}
		}
		if(db.teachers!=null){
			for(Teacher x : db.teachers) {
				if(x.id.equals(id)) {
					System.out.println("Write New Phone Number: ");
					String newPhone = sc.nextLine();
					x.phoneNumber = newPhone;
					System.out.println("Phone Number is updated ");
					writeBase(db);
					sc.close();
					return;
				}
			}
		}
		
		System.out.println("User is not Found !");

	}

	public int toHash(String txt) {
	    char[] bukvy = txt.toCharArray();
	    int  q = 100007;
	    int hash = 0 ;
	    int l = txt.length();
	    int p[] = new int[l];
	    p[0] = 1;
	    for(int i=1;i<l;i++) {
	      p[i] = (p[i-1]*11)%q;
	    }
	    for(int i = 0;i<l;i++){
	          hash = (hash+(((int)bukvy[i]-47)*p[i])%q)%q;
	      }   
	    return hash;
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
	public Admin logining(String login,String password) {
		Database db = new Database();
		db = readBase();
		if(db.admins==null) {
			System.out.println("Not have admins");
		}
		for(Admin x : db.admins) {
			if(x.login.equals(login) && x.password.equals(password)) {
				return x;
			}
		}
		return null;
	}   
	public void getMessages() {
		int i = 1;
		for (Entry<String, String> x : messages.entrySet()) {
			System.out.println(i+".User"+x.getKey()+" Send "+x.getValue());
		}
	}
}
