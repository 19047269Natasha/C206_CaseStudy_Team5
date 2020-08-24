public class CourseCategory {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		CourseCategory cat = new CourseCategory();
		cat.start();

	}

	public void start() {
		// TODO Auto-generated method stub
		int option = 0;

		while (option != 6) {

			CourseDB.showCourseMenu();
			System.out.println("");
			option = Helper.readInt("Enter option > ");

			if (option == 1) {
				System.out.println(CourseCatDB.viewAllCourseCategory());
			} else if (option == 2) {
				addCourseCategory();
			} else if (option == 3) {
				updateCourseCategory();
			} else if (option == 4) {
				System.out.println("Goodbye!");
			} else {
				System.out.println("Invalid Option");
			}

			System.out.println("");
		}
		
	}
	public void addCourseCategory() {
		String CourseCategoryName = Helper.readString("Enter Course Category Name > ");
		String CourseCatetoryDescription = Helper.readString("Enter Course Category Description > ");
	}

}
