import java.util.ArrayList;

public class CourseDB {

	public static ArrayList<CourseMain> courseList = new ArrayList<>();

	public static void addCourse(CourseMain add) {

		courseList.add(add);
		System.out.println("Course Added!");

	}

	public static String viewAllCourse() {

		String output = "";

		if (courseList.size() > 0) {

			output = String.format("%-15s %-25s %-25s %-25s %-25s %-25s\n", "COURSE CODE", "COURSE TITLE",
					"CATEGORY NAME", "COURSE DESCRIPTION", "COURSE DURATION", "PRE-REQUISITE COURSE");
			Helper.line(30, "-");
			for (int i = 0; i < courseList.size(); i++) {

				output += String.format("%-15s %-25s %-25s %-25s %-25d %-25s\n", courseList.get(i).getCourseCode(),
						courseList.get(i).getCourseTitle(), courseList.get(i).getCategoryName(),
						courseList.get(i).getCourseDescription(), courseList.get(i).getCourseDuration(),
						courseList.get(i).getPrerequisiteCourse());
			}
		} else {
			Helper.line(30, "-");
			output = "Course Not Found";
		}

		return output;
	}

	public static void delCourse(String courseCode) {

		boolean isTrue = false;

		for (int i = 0; i < courseList.size(); i++) {
			if (courseList.get(i).getCourseCode().contentEquals(courseCode)) {
				courseList.remove(i);
				isTrue = true;
			}
		}

		if (isTrue == false) {
			Helper.line(30, "-");
			System.out.println("Invalid Course Code!");
		} else {
			Helper.line(30, "-");
			System.out.println("Course Deleted!");
		}
	}

	public static String updateCourse(String courseCode, int option, String change) {

		String output = "";

		boolean isTrue = false;

		for (int i = 0; i < courseList.size(); i++) {
			if (courseList.get(i).getCourseCode().equalsIgnoreCase(courseCode)) {
				
				isTrue = true;
				if(option == 1) {
					
					courseList.get(i).setCourseTitle(change);
					Helper.line(30, "-");
					output += "Course Title Updated!";
					
				}
				else if(option == 2) {
					courseList.get(i).setCategoryName(change);
					Helper.line(30, "-");
					output += "Category Name Updated!";
				}
				else if(option == 3) {
					courseList.get(i).setCourseDescription(change);
					Helper.line(30, "-");
					output += "Course Description Updated!";
				}
				else if(option == 4) {
					int change_int = Integer.parseInt(change);
					courseList.get(i).setCourseDuration(change_int);
					Helper.line(30, "-");
					output += "Course Duration Updated!";
				}
				else if(option == 5) {
					courseList.get(i).setPrerequisiteCourse(change);
					Helper.line(30, "-");
					output += "Course Pre-Requisite Updated!";
				}
				else if (option == 6) {
					output += ("Goodbye!");
				} 
				else {
					output += ("Invalid option!");
				}

			}
		}

		if (isTrue == false) {
			output += "Invalid Course Code!";
		}
		
		return output;
	}

	public static void searchCourse(String categoryName) {

		boolean isTrue = false;

		for (int i = 0; i < courseList.size(); i++) {
			if (courseList.get(i).getCategoryName().equalsIgnoreCase(categoryName)) {

				Helper.line(30, "-");
				System.out.println(String.format("%-15s %-25s %-25s %-25s %-25s %-25s", "COURSE CODE", "COURSE TITLE",
						"CATEGORY NAME", "COURSE DESCRIPTION", "COURSE DURATION", "PRE-REQUISITE COURSE"));
				
				System.out.println(String.format("%-15s %-25s %-25s %-25s %-25d %-25s\n",
						courseList.get(i).getCourseCode(), courseList.get(i).getCourseTitle(), categoryName,
						courseList.get(i).getCourseDescription(), courseList.get(i).getCourseDuration(),
						courseList.get(i).getPrerequisiteCourse()));
				
				isTrue = true;

			}
		}

		if (isTrue == false) {
			Helper.line(30, "-");
			System.out.println("Invalid Category Name!");
		}
	}

	public static void showCourseMenu() {
		System.out.println("COURSE MENU");
		Helper.line(30, "-");
		System.out.println("1. View Course");
		System.out.println("2. Add Course");
		System.out.println("3. Delete Course");
		System.out.println("4. Update Course");
		System.out.println("5. Search Course");
	}

}
}
