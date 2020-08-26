
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
			} 
			else if (option == 2) {
				addCourse();
			} 
			else if (option == 3) {
				delCourse();
			} 
			else if (option == 4) {
				updCourse();
			}
			else if (option == 5) {
				srhCourse();
			} 
			else {
				System.out.println("Invalid Option");
			}


			System.out.println("");
		}

	}

	public void addCourse() {
		
		String courseCode = Helper.readString("Enter course code > ");
		String courseTitle = Helper.readString("Enter course title > ");
		String categoryName = Helper.readString("Enter category name > ");
		String courseDescription = Helper.readString("Enter course description > ");
		int courseDuration = Helper.readInt("Enter course duration > ");
		String prerequisiteCourse = Helper.readString("Enter pre-requisite course > ");
		
		CourseMain newCourse = new CourseMain(courseCode, courseTitle, categoryName, courseDescription, courseDuration, prerequisiteCourse);
		CourseDB.courseList.add(newCourse);
		Helper.line(30, "-");
		System.out.println("Course Added Successfully!");
		
	}

	public void delCourse() {

		String courseCode = Helper.readString("Enter course code > ");
		CourseDB.delCourse(courseCode);
	}
	
	public void updCourse() {
		
		Helper.line(30, "-");
		System.out.println("1. Change Course Title");
		System.out.println("2. Change Category Name");
		System.out.println("3. Change Course Description");
		System.out.println("4. Change Course Duration");
		System.out.println("5. Change Pre-Requisite Course");
		System.out.println("6. Quit");
		Helper.line(30, "-");
		
		int choice = Helper.readInt("Enter an option > ");
		
		if(choice == 1) {
			
			String code = Helper.readString("Enter course code > ");
			String title = Helper.readString("Enter new title > ");
			System.out.println(CourseDB.updateCourse(code, choice, title));
		}
		else if (choice == 2) {
			
			String code = Helper.readString("Enter course code > ");
			String category = Helper.readString("Enter new category name > ");
			System.out.println(CourseDB.updateCourse(code, choice, category));
			
		}
		else if (choice == 3) {
			
			String code = Helper.readString("Enter course code > ");
			String description = Helper.readString("Enter new course description > ");
			System.out.println(CourseDB.updateCourse(code, choice, description));
			
		}
		else if (choice == 4) {
			
			String code = Helper.readString("Enter course code > ");
			String duration = Helper.readString("Enter new course duration > ");
			System.out.println(CourseDB.updateCourse(code, choice, duration));
			
		}
		else if (choice == 5) {
			
			String code = Helper.readString("Enter course code > ");
			String preRequisite = Helper.readString("Enter new pre-requisite course > ");
			System.out.println(CourseDB.updateCourse(code, choice, preRequisite));
			
		}
		else if (choice == 6) {
			
			System.out.println("Goodbye!");
			
		}
		else {
			
			System.out.println("Invalid Option!");
		}
		
	}
	
	public void srhCourse() {
		
		String categoryName = Helper.readString("Enter category name > ");
		CourseDB.searchCourse(categoryName);
		
	}

}
