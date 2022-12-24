package FirstProject;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Objects;

public  class User implements Serializable{
    
    private static final long serialVersionUID = 1L;

	public String name;
    
    public String soname;
    
    public  String id;
    
    public String login;
    
    protected String password;
    
    public String phoneNumber;
    
    public String getName() {
        return this.name;
    }
    
    public String getSoname() {
    	return this.soname;
    }
    
    public String getId() {
    	return this.id;
    }

    public String getLogin() {
    	return this.login;
    }

    public void setName(String name) {
        this.name = name;
    }
    
    public void setSoname(String soname) {
        this.soname = soname;
    }
    
    
    public void setId(String id) {
        this.id = id;
    }
    
    public void setLogin(String login) {
    	this.login = login;
    }

	@Override
	public String toString() {
		return "User [name=" + name + ", soname=" + soname + ", id=" + id + ", login=" + login + "]";
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

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		return Objects.equals(id, other.id) && Objects.equals(login, other.login) && Objects.equals(name, other.name)
				&& Objects.equals(soname, other.soname);
	}
	public void generatePassword(String name, String soname) {
		this.password = String.valueOf(toHash(name)+toHash(soname));
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
	public User logining(String login,String password) {
		Database db = readBase();
		for(Admin x : db.admins) {
			if(x.login.equals(login) && x.password.equals(password)) {
				return x;
				
			}
		}
		for(Teacher x : db.teachers) {
			if(x.login.equals(login) && x.password.equals(password)) {
				return x;	
			}
		}
		for(Manager x : db.managers) {
			if(x.login.equals(login) && x.password.equals(password)) {
				return x;
			}
		}
		for(Student x : db.students) {
			if(x.login.equals(login) && x.password.equals(password)) {
				return x;
			}
		}
		return null;
		
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	
	
}
