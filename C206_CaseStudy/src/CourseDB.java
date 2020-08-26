import java.util.ArrayList;

public class CourseDB {
	
	public static ArrayList<CourseMain> courseList = new ArrayList<>();
	
	public static void addCourse(CourseMain add) {
		
		courseList.add(add);
		System.out.println("Course Added Successfully!");
	}
	
	public static String viewAllCourse() {
		
		String output = "";
		
		if(courseList.size() > 0) {
			
			output = String.format("%-15s %-25s %-25s %-25s %-25s %-25s\n", "COURSE CODE", "COURSE TITLE", "CATEGORY NAME", "COURSE DESCRIPTION", "COURSE DURATION", "PRE-REQUISITE COURSE");
			for(int i = 0; i < courseList.size(); i++) {
				
				output += String.format("%-15s %-25s %-25s %-25s %-25d %-25s\n", courseList.get(i).getCourseCode(), courseList.get(i).getCourseTitle(), courseList.get(i).getCategoryName(), courseList.get(i).getCourseDescription(), courseList.get(i).getCourseDuration(), courseList.get(i).getPrerequisiteCourse());
			}
		}
		else {
			output = "Course Not Found";
		}
		
		return output;
	}
	
	public static void delCourse(String courseCode) {
		
		boolean isTrue = false;
		
		for(int i = 0; i < courseList.size(); i++) {
			if(courseList.get(i).getCourseCode().contentEquals(courseCode)) {
				courseList.remove(i);
				isTrue = true;
			}
		}
		
		if(isTrue == false) {
			System.out.println("Invalid Course Code!");
		}
		else {
			System.out.println("Course Deleted!");
		}
	}
	
	public static void updateCourse(String courseCode) {
		
		int option = 0;
		
		boolean isTrue = false;
		
		for(int i = 0; i < courseList.size(); i++) {
			if(courseList.get(i).getCourseCode().equalsIgnoreCase(courseCode)) {
				
				Helper.line(30, "-");
				System.out.println("1. Change Course Title");
				System.out.println("2. Change Category Name");
				System.out.println("3. Change Course Description");
				System.out.println("4. Change Course Duration");
				System.out.println("5. Change Pre-Requisite Course");
				System.out.println("6. Quit");
				Helper.line(30, "-");
				
				option = Helper.readInt("Enter an option > ");
				
				if(option == 1) {
					String title = Helper.readString("Enter a new course title > ");
					courseList.get(i).setCourseTitle(title);
				}
				else if(option == 2) {
					String category = Helper.readString("Enter a new category name > ");
					courseList.get(i).setCategoryName(category);
				}
				else if(option == 3) {
					String description = Helper.readString("Enter a new course description > ");
					courseList.get(i).setCourseDescription(description);
				}
				else if(option == 4) {
					int duration = Helper.readInt("Enter a new course duration > ");
					courseList.get(i).setCourseDuration(duration);
				}
				else if(option == 5) {
					String preRequisite = Helper.readString("Enter a new pre-requisite course > ");
					courseList.get(i).setPrerequisiteCourse(preRequisite);
				}
				else if(option == 6) {
					System.out.println("Goodbye!");
				}
				else {
					System.out.println("Invalid option!");
				}
				
				isTrue = true;
			}
		}
		
		if(isTrue == false) {
			System.out.println("Invalid Course Code!");
		}
	}
	
	public static void showCourseMenu() {
		System.out.println("COURSE MENU");
		Helper.line(30, "-");
		System.out.println("1. View Course");
		System.out.println("2. Add Course");
		System.out.println("3. Delete Course");
		System.out.println("4. Update Course");
	}

}
