import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class CourseTest {

	private CourseMain course1;
	private CourseMain course2;

	@Before
	public void setUp() throws Exception {
		course1 = new CourseMain("C209", "Java Programming", "Programming", "To create a program based on coding", 6,
				"Object Oriented Programming");
		course2 = new CourseMain("C206", "Software Development", "Infocomm", "To develop a software", 6, "Database");

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

		assertEquals("Test that the size of courseList is 0", 0, CourseDB.courseList.size());
		
		CourseDB.addCourse(course1);
		assertEquals("Test that the size of courseList is 1", 1, CourseDB.courseList.size());
		
		assertSame("Test that the first item in course arraylist is the same as the item was added.", course1 , CourseDB.courseList.get(0));
		
		CourseDB.addCourse(course2);
		assertEquals("Test that courseList size is 2 when 2 course objects are added", 2, CourseDB.courseList.size());
		
		assertSame("Test that the first item in course arraylist is the same as the item was added.", course2, CourseDB.courseList.get(1));

	}

	@Test
	public void ViewCourseTest() {

		assertNotNull("Test that courseList is not null", CourseDB.courseList);

		String testOutput = "Course Not Found";
		String viewCourse = CourseDB.viewAllCourse();
		assertEquals("Test if the courseList is empty", testOutput, viewCourse);

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

		assertNotNull("Test that courseList is not null", CourseDB.courseList);

		CourseDB.addCourse(course1);
		CourseDB.delCourse(course1.getCourseCode());
		assertEquals("Test if the course arraylist is still 0 after adding and deleting", 0, CourseDB.courseList.size());

		CourseDB.addCourse(course1);
		CourseDB.addCourse(course2);
		CourseDB.delCourse(course2.getCourseCode());
		assertEquals("Test if the course arraylist is still 1 after adding 2 course and deleting 1 of the course", 1, CourseDB.courseList.size());

		CourseDB.delCourse(course1.getCourseCode());
		
		CourseDB.addCourse(course1);
		CourseDB.addCourse(course2);
		CourseDB.delCourse(course1.getCourseCode());
		CourseDB.delCourse(course2.getCourseCode());
		assertEquals("Test if the arraylist is 0 after deleting 2 objects from the courseList", 0, CourseDB.courseList.size());
		
		CourseDB.addCourse(course1);
		CourseDB.addCourse(course2);
		
		CourseDB.delCourse(course1.getCourseCode());
		assertSame("Test if the arraylist.get(0) is course2 after deleting course1 from the arraylist", course2, CourseDB.courseList.get(0));
		
		CourseDB.delCourse(course2.getCourseCode());
	}
	
	@Test
	public void updCourseTest() {
		
		CourseDB.courseList.add(course1);
		CourseDB.updateCourse(course1.getCourseCode(),1,course2.getCourseTitle());
		assertEquals("Test if the course arraylist first item course has been updated course 2 title",course2.getCourseTitle(),CourseDB.courseList.get(0).getCourseTitle());
	
	
		CourseDB.courseList.add(course1);
		CourseDB.updateCourse(course1.getCourseCode(),2,course2.getCategoryName());
		assertEquals("Test if the course arraylist first item course has been updated to course 2 category name",course2.getCategoryName(),CourseDB.courseList.get(0).getCategoryName());
		
		CourseDB.courseList.add(course1);
		CourseDB.updateCourse(course1.getCourseCode(),3,course2.getCourseDescription());
		assertEquals("Test if the course arraylist first item course has been updated to course 2 course description",course2.getCourseDescription(),CourseDB.courseList.get(0).getCourseDescription());
	
		CourseDB.courseList.add(course1);
		String changeint = String.valueOf(course2.getCourseDuration());
		CourseDB.updateCourse(course1.getCourseCode(),4,changeint);
		assertEquals("Test if the course arraylist first item course has been updated to course 2 course duration",course2.getCourseDuration(),CourseDB.courseList.get(0).getCourseDuration());
		
		CourseDB.courseList.add(course1);
		CourseDB.updateCourse(course1.getCourseCode(),5,course2.getPrerequisiteCourse());
		assertEquals("Test if the course arraylist first item course has been updated to course 2 pre-requisite course",course2.getPrerequisiteCourse(),CourseDB.courseList.get(0).getPrerequisiteCourse());
		
	}
	
}



