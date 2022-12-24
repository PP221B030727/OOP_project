package FirstProject;

import java.util.Scanner;
public class MainProject {
	public static void main(String[] args) {
		Admin admin = new Admin();
		admin.name = "Nurs";
		admin.soname = "Tu";
		admin.phoneNumber="879123";
//		admin.writeBase(new Database());
//		admin.addUsers("Nurultan", "Turugeldiev", typeOfUser.Admin,"87088320419");
//		admin.addUsers("Atushi", "Soname1", typeOfUser.Student,"87082318321");
//		admin.addUsers("Pakita", "Soname2", typeOfUser.Student,"87471234710");
//		admin.addUsers("Hiroharu","Soname3",typeOfUser.Teacher,"81278931");
//		admin.addUsers("TestManager","Soname4",typeOfUser.Manager,"8712312312");
		
		Database db = admin.readBase();
		System.out.println("Teachers: ");
		
		
		System.out.println(db.teachers.toString());
		System.out.println(db.teachers.toString());
		System.out.println(db.teachers.get(0).password);
		
		System.out.println();
		System.out.println("Admins: ");
		System.out.println(db.admins.toString());
		System.out.println(db.admins.toString());
		System.out.println(db.admins.get(0).password);
		
		
		
		System.out.println("Students: ");
		System.out.println(db.students.toString());
		System.out.println(db.students.toString());
		System.out.println(db.students.get(0).login);

		System.out.println(db.students.get(0).password);
		

		System.out.println("Managers: ");
		System.out.println(db.managers.toString());
		System.out.println(db.managers.toString());
		System.out.println(db.managers.get(0).password);
		
		System.out.println(db.courses.toString());
		
		
		
		
		
		Scanner sc = new Scanner(System.in);
		System.out.println("Login: ");
		String login = sc.nextLine();
		System.out.println("Password: ");
		String password = sc.nextLine();
//		String login = "N_Turugeldiev";
//		String password = "162492";
		User n = new User();
		n = n.logining(login,password);
		if(n!=null) {
			if(n.getId().charAt(2)=='T') {
				Teacher t = new Teacher();
				t = t.logining(login,password);
				System.out.println("You are a Teacher !");
				System.out.println("1.Put Marks");
				System.out.println("2.View Courses ");
				System.out.println("3.Manage Course Files");
				System.out.println("4.View Student Info ");
				System.out.println("5.Send Message ");
				System.out.println("6.Read Message ");
				System.out.println("7.Quite");
				while(true) {
					String command = sc.nextLine();
					if(command.equals("1")) {
						System.out.println("Write code of Course");
						String cd = sc.nextLine();
						System.out.println("Write id of Student");
						String id = sc.nextLine();
						System.out.println("Create Mark");
						System.out.println("Write first attestation:");
						double f = sc.nextDouble();
						System.out.println("Write second attestation:");
						double s = sc.nextDouble();
						System.out.println("Write finalExam attestation:");
						double th = sc.nextDouble();
						Mark mark = new Mark(f,s,th);
						t.putMarks(mark, id,cd);
					}
					else if(command.equals("2")) {
						System.out.println("This is all courses Teacher:");
						t.infoCourse();
					}
					else if(command.equals("3")) {
						System.out.println("Write new Course file");
						String cf = sc.nextLine();
						System.out.println("Write Course code");
						String code = sc.nextLine();
						if(t.courses!=null) {
							for(Course x:t.courses) {
								if(x.getCode().equals(code)) {
									x.addCourseFiles(cf);
								}
							}
						}
						else {
							System.out.println("Not have courses");
						}
						
						
					}
					else if(command.equals("4")) {
						System.out.println("Info about Students: ");
						t.infoAboStudents();
					}
					else if(command.equals("5")) {
						System.out.println("Write the id to send the message :");
						String id = sc.nextLine();
						System.out.println("Write the message :");
						String message = sc.nextLine();
						t.sendMesege(id, message);
						System.out.println("Messages sent");
					}
					else if(command.equals("6")) {
						System.out.println("You are Messages: ");
						t.getMessages();
					}
					else if(command.equals("7")) {
						System.out.println("Good bye!");
						break;
					}
				}
			}
			else if(n.getId().charAt(2)=='A') {
				Admin a = new Admin();
				a = a.logining(login,password);
				System.out.println("You are a Admin !");
				System.out.println("Chose a command:");
				System.out.println("1.Send Message");
				System.out.println("2.Add of Users");
				System.out.println("3.Remove Users");
				System.out.println("4.Update Users Password");
				System.out.println("5.Update Users Number");
				System.out.println("6.Read Message");
				System.out.println("7.Quite");
				
				while(true) {
					String command = sc.nextLine();
					if(command.equals("1")) {
						System.out.println("Write the id to send the message :");
						String id = sc.nextLine();
						System.out.println("Write the message :");
						String message = sc.nextLine();
						a.sendMesege(id, message);
						System.out.println("Messages sent");
					}
					else if(command.equals("2")) {
						System.out.println("Adding User !");
						System.out.println("Write Name of User: ");
						String name = sc.nextLine();
						System.out.println("Write Soname of User: ");
						String soname = sc.nextLine();
						System.out.println("Choose new type of User: ");
						System.out.println("1.Student");
						System.out.println("2.Manager");
						System.out.println("3.Admin");
						System.out.println("4.Teacher");
						typeOfUser type = null ;
						String subCom = sc.nextLine();
						if(subCom.equals("1")) {
							type = typeOfUser.Student;
						}
						else if(subCom.equals("2")) {
							type = typeOfUser.Manager;
						}
						else if(subCom.equals("3")) {
							type = typeOfUser.Admin;
						}
						else if(subCom.equals("4")) {
							type = typeOfUser.Teacher;
						}
						System.out.println("Write phone number: ");
						String phone = sc.nextLine();
						a.addUsers(name, soname, type, phone);
						
					}
					else if(command.equals("3")) {
						System.out.println("For Removing write id of User :");
						String id = sc.nextLine();
						a.removeUsers(id);
					}
					else if(command.equals("4")) {
						System.out.println("Write id Of User:");
						String id = sc.nextLine();
						a.updateUsersPassword(id);
					}
					else if(command.equals("5")) {
						System.out.println("Write id Of User:");
						String id = sc.nextLine();
						a.updateUsersNumber(id);
					}
					else if(command.equals("6")) {
						System.out.println("You are Messages: ");
						a.getMessages();
					}
					else if(command.equals("7")) {
						System.out.println("Good bye!");
						break;
					}
				}
			}
			else if(n.getId().charAt(2)=='R') {
				Manager m = new Manager();
				m = m.logining(login,password);
				System.out.println("You are a Manager !");
				System.out.println("Chose a command:");
				System.out.println("1.Send Message");
				System.out.println("2.Create Course");
				System.out.println("3.View info about Teachers");
				System.out.println("4.View info about Students");
				System.out.println("5.Statistic info about Students");
				System.out.println("6.Read Messages");
				System.out.println("7.Open Registration");
				System.out.println("8.Quite");

				while(true) {
					String command = sc.nextLine();
					if(command.equals("1")) {
						System.out.println("Write the id to send the message :");
						String id = sc.nextLine();
						System.out.println("Write the message :");
						String message = sc.nextLine();
						m.sendMesege(id, message);
						System.out.println("Messages sent");
					}
					else if(command.equals("2")) {
						System.out.println("Creating Course");
						System.out.println("Write name of Course");
						String name = sc.nextLine();
						System.out.println("Write code of Course");
						String code = sc.nextLine();
						System.out.println("Choose faculty :");
						System.out.println("1.FIT");
						System.out.println("2.BSA");
						System.out.println("3.MCM");
						Faculty faculty = null;
						String subCom = sc.nextLine();
						if(subCom.equals("1")) {
							faculty = Faculty.FIT;
						}	
						else if(subCom.equals("2")) {
							faculty = Faculty.BS;
						}
						else if(subCom.equals("3")) {
							faculty = Faculty.MCM;
						}
						System.out.println("Write Sum of credits:");
						int sum = sc.nextInt();
						System.out.println("Write the id of the teacher who will conduct the course: ");
						Scanner sc2 = new Scanner(System.in);
						String idOfTeacher = sc2.nextLine();
						Teacher t = m.findTeacher(idOfTeacher);
						
//						System.out.println(t.toString());
						m.createCourse(name, code, faculty, sum, t);
						System.out.println("Course is created");
					}
					else if(command.equals("3")) {
						System.out.println("Info about Teachers: ");
						m.infoAboTeachers();
					}
					else if(command.equals("4")) {
						System.out.println("Info about Students: ");
						m.infoAboStudents();
					}
					else if(command.equals("5")) {
						System.out.println("Statistic info about Students: ");
						m.statisticInfoAbSt();
					}
					else if(command.equals("6")) {
						System.out.println("You are Messages: ");
						m.getMessages();
					}
					else if(command.equals("7")) {
						m.setOpenOrClose(true);
						System.out.println("Registration is open");
					}
					else if(command.equals("8")) {
						System.out.println("Good Bye!");
						break;
					}
				}
				
			}
			else if(n.getId().charAt(2)=='S') {
				Student s = new Student();
				s = s.logining(login, password);
				
				System.out.println("You are a Student !");
				System.out.println("Chose a command: ");
				System.out.println("1.View Transcript");
				System.out.println("2.View Courses");
				System.out.println("3.Get Sum of Credits");
				System.out.println("4.Set Type of Student");
				System.out.println("5.Get Type of Student");
				System.out.println("6.Get Completed Сourses");
				System.out.println("7.Get Registered Courses");
				System.out.println("8.View info about Student Organizations");
				System.out.println("9.JOIN OSIT");
				System.out.println("10.Registration of course!");
				System.out.println("11.Quite !");
				while(true) {
					String command = sc.nextLine();
					if(command.equals("1")) {
						s.viewTranscript();
					}
					else if(command.equals("2")) {
						System.out.println("This is all Courses of Student:");
						s.viewCourses();
					}
					else if(command.equals("3")) {
						System.out.println("Sum of Credits is "+s.getSumOf());
					}
					else if(command.equals("4")) {
						System.out.println("Choose new type of Student: ");
						System.out.println("1.Bachelor");
						System.out.println("2.Doctoral student");
						System.out.println("3.Graduate student");
						String subCommand = sc.nextLine();
						if(subCommand.equals("1")) {
							s.setType(typeOfStudent.Bachelor);
							System.out.println("Type of Student changed !");
						}
						else if(subCommand.equals("2")) {
							s.setType(typeOfStudent.PHD);
							System.out.println("Type of Student changed !");
						}
						else if(subCommand.equals("3")) {
							s.setType(typeOfStudent.Magistr);
							System.out.println("Type of Student changed !");
						}
					}
					else if(command.equals("5")) {
						System.out.print("Your type of Student is ");
						if(s.getType()==typeOfStudent.Bachelor) {
							System.out.println("Bachelor");
						}
						else if(s.getType()==typeOfStudent.Magistr) {
							System.out.println("Graduate student");
						}
						else if(s.getType()==typeOfStudent.PHD) {
							System.out.println("Doctoral student");
						}
					}
					else if(command.equals("6")) {
						System.out.println("Student "+s.name+"is finished this courses: ");
						s.getCompletedСourses();
					}
					else if(command.equals("7")) {
						System.out.println("Student "+s.name+" enrolled these courses: ");
						s.getRegisteredCourses();
					}
					
					else if(command.equals("8")) {
						s.viewInfoStudentOr();
					}
					else if(command.equals("9")) {
						s.joinOSIT();
						System.out.println("Student "+s.getName()+"joined OSIT");
					}
					else if(command.equals("10")) {
						System.out.println("Write Code of Course ");
						String code = sc.nextLine();
						s.courseReg(code);
					}
					else if(command.equals("11")) {
						System.out.println("Good bye !");
						return;
					}
					
				}
			}
		}
		else {
			System.out.println("The password is not correct !");
		}
		sc.close();
//		
//		Database db = admin.readBase();
//		Vector <Teacher> teachers = db.getTeachers();
//		Teacher t1 = teachers.elementAt(0);
//		System.out.println(t1.id);
//		System.out.println(t1.messages);
		///22T7328
		
		
		
		
		
		
		
//		System.out.println(n.getId());
		
		
//		Teacher n = new Teacher();
//		n.logining(null, null)
//		Database db = n.readBase();
//		n = (Teacher) n.logining("K_Mory","92452");
//		if(n instanceof Techer) {
//			
//		}
//		System.out.println(n.getMessages());
		
		
//		K_Mory
		
//		92452

	}
}
