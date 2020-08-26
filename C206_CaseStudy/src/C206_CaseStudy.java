
public class C206_CaseStudy {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int option = 0;
		
		while(option != 6) {
			System.out.println("MAIN MENU");
			Helper.line(30, "-");
			System.out.println("1. Member Account");
			System.out.println("2. Course Category");
			System.out.println("3. Course");
			System.out.println("4. Course Schedule");
			System.out.println("5. Registration");
			System.out.println("6. Quit");
			Helper.line(30, "-");
			
			option = Helper.readInt("Enter an option > ");
			Helper.line(30, "-");
			
			if(option == 1) {
				Member m = new Member();
				m.start();
			}
			else if(option == 2) {
				CourseCategory cc = new CourseCategory();
				cc.start();
			}
			else if(option == 3) {
				Course c = new Course();
				c.start();
				
			}
			else if(option == 4) {
				CourseSchedule cs = new CourseSchedule();
				cs.start();
			}
			else if(option == 5) {
				Registration r = new Registration();
				r.start();
			} 
			
			else if(option == 6) {
				System.out.println("Good Bye!");
				
			}
			else {
				
				System.out.println("Invalid option");
			}
		}
	}
}
