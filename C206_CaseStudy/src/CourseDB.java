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
	
	public static void showCourseMenu() {
		System.out.println("1. View Course");
		System.out.println("2. Add Course");
		System.out.println("3. Delete Course");
	}

}
