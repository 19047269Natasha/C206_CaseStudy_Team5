import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class CourseTest {

	private CourseMain course1;
	private CourseMain course2;

	@Before
	public void setUp() throws Exception {
		course1 = new CourseMain("C206", "Software Development", "Infocomm", "To develop a software", 6, "Database");
		course2 = new CourseMain("C209", "Java Programming", "Programming", "To create a program based on coding", 6,
				"Object Oriented Programming");

	}

	@After
	public void tearDown() throws Exception {
		course1 = null;
		course2 = null;
		CourseDB.courseList.clear();
	}

	@Test
	public void addCourseTest() {

		assertNotNull("Test that courseList is not null", CourseDB.courseList);

		CourseDB.courseList.add(course1);
		assertEquals("Test that the size of courseList is 1 after adding 1", 1, CourseDB.courseList.size());

		CourseDB.courseList.add(course1);
		assertEquals("Test that the first item in category arraylist is the same as the item was added.", course1,
				CourseDB.courseList.get(0));

	}

	@Test
	public void ViewCourseTest() {

		assertNotNull("Test that courseList is not null to be able to retrieve something to view", CourseDB.courseList);

		String expectedOutput = "Course Not Found";
		String viewCourse = CourseDB.viewAllCourse();
		assertEquals("Test that viewAllStudent() method returns a String that equals expectedOutput", expectedOutput,
				viewCourse);

		CourseDB.addCourse(course1);
		CourseDB.addCourse(course2);

		String expectedOutput2 = String.format("%-15s %-25s %-25s %-25s %-25s %-25s\n", "COURSE CODE", "COURSE TITLE",
				"CATEGORY NAME", "COURSE DESCRIPTION", "COURSE DURATION", "PRE-REQUISITE COURSE");

		for (int i = 0; i < CourseDB.courseList.size(); i++) {

			expectedOutput2 += String.format("%-15s %-25s %-25s %-25s %-25d %-25s\n",
					CourseDB.courseList.get(i).getCourseCode(), CourseDB.courseList.get(i).getCourseTitle(),
					CourseDB.courseList.get(i).getCategoryName(), CourseDB.courseList.get(i).getCourseDescription(),
					CourseDB.courseList.get(i).getCourseDuration(), CourseDB.courseList.get(i).getPrerequisiteCourse());
		}

		String viewCourse2 = CourseDB.viewAllCourse();
		assertEquals("Test that viewAllStudents() method return a String that equals expectedOutput2", expectedOutput2,
				viewCourse2);

	}

	@Test
	public void delCourseTest() {

		assertNotNull("Test that CourseList is not null", CourseDB.courseList);

		CourseDB.addCourse(course1);
		assertEquals("Test that the size of courseList is 1 before deleting 1 course: ", 1, CourseDB.courseList.size());

		CourseDB.delCourse(course1.getCourseCode());
		assertEquals("Test that the size of courseList is 0 before deleting 1 course: ", 0, CourseDB.courseList.size());

	}
	
	@Test
	public void updCourseTest() {
		String newTitle = "Software";
		String newName = "Infocomm";
		String newDescription = "To develop a software";
		int newDuration = 6;
		String newPreRequisite = "Database";
		
		course1.setCourseTitle(newTitle);
		assertEquals("Test that course1 title is update to new title", newTitle, course1.getCourseTitle());
		
		course1.setCategoryName(newName);
		assertEquals("Test that course1 name is updated to new name", newName, course1.getCategoryName());
		
		course1.setCourseDescription(newDescription);
		assertEquals("Test that course1 description is updated to new description", newDescription, course1.getCourseDescription());
		
		course1.setCourseDuration(newDuration);
		assertEquals("Test that course1 duration is updated to new duration", newDuration, course1.getCourseDuration());
		
		course1.setPrerequisiteCourse(newPreRequisite);
		assertEquals("Test that course1 pre-requisite is updated to new pre-requisite", newPreRequisite, course1.getPrerequisiteCourse());
	}
	
}


