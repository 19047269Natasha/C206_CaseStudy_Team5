import static org.junit.Assert.*;

import java.time.LocalDate;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class CourseTest {

	private CourseMain course1;
	private CourseMain course2;
	private CourseMain course3;
	private CourseScheduleMain cs1;

	@Before
	public void setUp() throws Exception {
		course1 = new CourseMain("C209", "Java Programming", "Programming", "To create a program based on coding", 6,
				"Object Oriented Programming");
		course2 = new CourseMain("C206", "Software Development", "Infocomm", "To develop a software", 6, "Database");
		course3 = new CourseMain("C235", "IT Security", "Infocomm", "To learn about IT", 6, "Computer System");

		LocalDate startDate = LocalDate.now();
		LocalDate endDate = startDate.plusDays(30);
		cs1 = new CourseScheduleMain("C209", 10.0, startDate, "06:05", endDate, "06:05", "W66L");

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

		assertEquals("Test that the size of courseList is 0 before adding", 0, CourseDB.courseList.size());

		CourseDB.addCourse(course1);
		assertEquals("Test that the size of courseList is 1 after adding", 1, CourseDB.courseList.size());

		assertSame("Test that the first item in courseList is the same as the item was added.", course1,
				CourseDB.courseList.get(0));

		CourseDB.addCourse(course2);
		assertEquals("Test that courseList size is 2", 2, CourseDB.courseList.size());

		assertSame("Test that the item in courseList is the same as the item was added.", course2,
				CourseDB.courseList.get(1));

		boolean duplicate = false;
		CourseDB.addCourse(course1);
		CourseDB.addCourse(course3);

		if (CourseDB.courseList.get(0).getCourseCode().equals(CourseDB.courseList.get(1).getCourseCode())) {
			duplicate = true;
		} else {
			duplicate = false;
		}

		assertEquals("Test if the courseCode has duplicate in the courseList", false, duplicate);
	}

	@Test
	public void ViewCourseTest() {

		assertNotNull("Test that courseList is not null to be able to retrieve to view", CourseDB.courseList);

		String expectedOutput = "No Course To Be Shown";
		String viewCourse = CourseDB.viewAllCourse();
		assertEquals("Test that viewAllCourse() method returns a String that equals testOutput", expectedOutput,
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
		assertEquals("Test that viewAllCourse() method return a String that equals expectedOutput2", expectedOutput2,
				viewCourse2);

	}

	@Test
	public void delCourseTest() {

		CourseDB.addCourse(course1);
		CourseScheduleDB.addCourseSchedule(cs1);
		
		CourseDB.delCourse(CourseDB.courseList.get(0).getCourseCode());
		//Test if the items inside can be deleted even if there is a schedule inside courseSchedule
		assertEquals("Test if the items inside can be deleted if there is a course schedule",1,CourseDB.courseList.size());
		CourseDB.courseList.clear();
		
		
		CourseDB.addCourse(course2);
		CourseDB.delCourse("C206");
		//Test if the items can be deleted without a schedule 
		assertEquals("Test if the items inside can be deleted without a schedule",0,CourseDB.courseList.size());
		
		

	}

	@Test
	public void updCourseTest() {

		CourseDB.courseList.add(course1);
		CourseDB.updateCourse(course1.getCourseCode(), 1, course2.getCourseTitle());
		assertEquals("Test if the course arraylist first item course has been updated course 2 title",
				course2.getCourseTitle(), CourseDB.courseList.get(0).getCourseTitle());

		CourseDB.courseList.add(course1);
		CourseDB.updateCourse(course1.getCourseCode(), 2, course2.getCategoryName());
		assertEquals("Test if the course arraylist first item course has been updated to course 2 category name",
				course2.getCategoryName(), CourseDB.courseList.get(0).getCategoryName());

		CourseDB.courseList.add(course1);
		CourseDB.updateCourse(course1.getCourseCode(), 3, course2.getCourseDescription());
		assertEquals("Test if the course arraylist first item course has been updated to course 2 course description",
				course2.getCourseDescription(), CourseDB.courseList.get(0).getCourseDescription());

		CourseDB.courseList.add(course1);
		String changeint = String.valueOf(course2.getCourseDuration());
		CourseDB.updateCourse(course1.getCourseCode(), 4, changeint);
		assertEquals("Test if the course arraylist first item course has been updated to course 2 course duration",
				course2.getCourseDuration(), CourseDB.courseList.get(0).getCourseDuration());

		CourseDB.courseList.add(course1);
		CourseDB.updateCourse(course1.getCourseCode(), 5, course2.getPrerequisiteCourse());
		assertEquals("Test if the course arraylist first item course has been updated to course 2 pre-requisite course",
				course2.getPrerequisiteCourse(), CourseDB.courseList.get(0).getPrerequisiteCourse());

	}

	@Test
	public void srhCourseTest() {

		assertNotNull("Test that courseList is not null", CourseDB.courseList);
		
		CourseDB.courseList.add(course2);

		String code = "Infocomm";

		boolean isTrue = false;

		for (int i = 0; i < CourseDB.courseList.size(); i++) {
			if (CourseDB.courseList.get(i).getCategoryName().equalsIgnoreCase(code)) {

				Helper.line(30, "-");
				System.out.println(String.format("%-15s %-25s %-25s %-25s %-25s %-25s", "COURSE CODE", "COURSE TITLE",
						"CATEGORY NAME", "COURSE DESCRIPTION", "COURSE DURATION", "PRE-REQUISITE COURSE"));

				System.out.println(String.format("%-15s %-25s %-25s %-25s %-25d %-25s\n",
						CourseDB.courseList.get(i).getCourseCode(), CourseDB.courseList.get(i).getCourseTitle(), code,
						CourseDB.courseList.get(i).getCourseDescription(),
						CourseDB.courseList.get(i).getCourseDuration(),
						CourseDB.courseList.get(i).getPrerequisiteCourse()));

				isTrue = true;


				assertEquals("Test that course is shown when using searchCourse() method", CourseDB.courseList.get(0).getCategoryName(),code);
				if (isTrue == false) {
					Helper.line(30, "-");

					assertEquals("Test that course is not shown when an entered category name does not exist",
							"Invalid Category Name!");
				}

			}
		}
	}

	@Test
	public void listCourseTest() {

		CourseDB.addCourse(course1);
		CourseScheduleDB.addCourseSchedule(cs1);

		String id = "C209";

		boolean isTrue = false;
		boolean isFound = false;

		for (int i = 0; i < CourseDB.courseList.size(); i++) {
			if (CourseDB.courseList.get(i).getCourseCode().equalsIgnoreCase(id)) {
				isTrue = true;
				for (int j = 0; j < CourseScheduleDB.scheduleList.size(); j++) {
					if (CourseDB.courseList.get(i).getCourseCode()
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

			assertEquals("Test that nothing will list out when an entered course code does not exist",
					"Course Does Not Exist!");
		}

		if (isFound == false) {
			Helper.line(30, "-");

			assertEquals("Test that course have no schedule", "Course Does Not Have Schedule!");
		}
	}
}
