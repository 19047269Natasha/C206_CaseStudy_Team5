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
			output = "No Course To Be Shown";
		}

		return output;
	}

	public static void delCourse(String courseCode) {

		boolean isTrue = false;
		boolean isFound = false;
		for (int i = 0; i < courseList.size(); i++) {
			if (courseList.get(i).getCourseCode().equalsIgnoreCase(courseCode)) {
				isTrue = true;

				if (CourseScheduleDB.scheduleList.size() == 0) {
					courseList.remove(i);
					isFound = true;
				} else {
					for (int j = 0; j < CourseScheduleDB.scheduleList.size(); j++) {
						if (!CourseScheduleDB.scheduleList.get(j).getCourseScheduleID().equalsIgnoreCase(courseCode)) {
							courseList.remove(i);
							isFound = true;

						}

					}
				}

			}
		}

		if (isFound == false) {
			Helper.line(30, "-");

			System.out.println("You can't delete a course that have schedule!");
		}
		if (isFound == true) {
			Helper.line(30, "-");
			System.out.println("Course Deleted!");
		}

		if (isTrue == false) {
			Helper.line(30, "-");
			System.out.println("Invalid Course Code!");
		}
	}

	public static String updateCourse(String courseCode, int option, String change) {

		String output = "";

		boolean isTrue = false;

		for (int i = 0; i < courseList.size(); i++) {
			if (courseList.get(i).getCourseCode().equalsIgnoreCase(courseCode)) {

				isTrue = true;
				if (option == 1) {

					courseList.get(i).setCourseTitle(change);
					Helper.line(30, "-");
					output += "Course Title Updated!";

				} else if (option == 2) {
					courseList.get(i).setCategoryName(change);
					Helper.line(30, "-");
					output += "Category Name Updated!";
				} else if (option == 3) {
					courseList.get(i).setCourseDescription(change);
					Helper.line(30, "-");
					output += "Course Description Updated!";
				} else if (option == 4) {
					int change_int = Integer.parseInt(change);
					courseList.get(i).setCourseDuration(change_int);
					Helper.line(30, "-");
					output += "Course Duration Updated!";
				} else if (option == 5) {
					courseList.get(i).setPrerequisiteCourse(change);
					Helper.line(30, "-");
					output += "Course Pre-Requisite Updated!";
				} else if (option == 6) {
					output += ("Goodbye!");
				} else {
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

	public static void listCS(String courseid) {
		boolean isTrue = false;
		boolean isFound = false;

		for (int i = 0; i < courseList.size(); i++) {
			if (courseList.get(i).getCourseCode().equalsIgnoreCase(courseid)) {
				isTrue = true;
				for (int j = 0; j < CourseScheduleDB.scheduleList.size(); j++) {
					if (courseList.get(i).getCourseCode()
							.equalsIgnoreCase(CourseScheduleDB.scheduleList.get(j).getCourseScheduleID())) {
						System.out.println(CourseScheduleDB.viewAllCourseSchedule());
						isFound = true;
						break;
					}
				}
			}
		}
		if (isTrue == false) {
			Helper.line(30, "-");
			System.out.println("Course Does Not Exist!");
		}
		if (isFound == false) {
			Helper.line(30, "-");
			System.out.println("Course Does Not Have Schedule!");
		}
	}

	public static void showCourseMenu() {
		System.out.println("COURSE MENU");
		Helper.line(30, "-");
		System.out.println("1. Add Course");
		System.out.println("2. View Course");
		System.out.println("3. Delete Course");
		System.out.println("4. Update Course");
		System.out.println("5. Search Course");
		System.out.println("6. List All Course Schedules For A Course");
		System.out.println("7. Quit");
	}

}
