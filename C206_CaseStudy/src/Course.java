
public class Course {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Course c = new Course();
		c.start();

	}

	public void start() {
		// TODO Auto-generated method stub
		
		int option = 0;
		
		while (option != 6) {
			
			CourseDB.showCourseMenu();
			System.out.println("");
			option = Helper.readInt("Enter an option > ");
			
			if (option == 1) {
				System.out.println(CourseDB.viewAllCourse());
			} else if (option == 2) {
				addCourse();
			} else if (option == 3) {
				delCourse();
			} else if (option == 4) {
				System.out.println("Goodbye!");
			} else {
				System.out.println("Invalid Option");
			}
			
			System.out.println("");
		}
		
	}
	
	public void addCourse() {
		
		
	}

}
