
public class CourseSchedule {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public void start() {
		// TODO Auto-generated method stub
		
		/**
 * @author 19025237
 *
 */
        public class C206_CaseStudy {

        public void addcourseschedule() {
	    int scheduleID = Helper.readInt("Enter Course Schedule id");
	    double price = Helper.readInt("Enter Course price");
	    String startdatetime = Helper.readString("Enter start date and time (DD/MM/YYYY 00:00)");
	    String enddatetime = Helper.readString("Enter start date and time (DD/MM/YYYY 00:00)");
	    String location = Helper.readString("Enter course location");
	
	    for (courseschedule schedule:schedulelist) {
		if (scheduleID == schedule.getID()) {
		    System.out.println("This course schedule already exists.");
		    run.addcourseschedule();
	        }    
	    }
	
	    courseschedule newschedule = new courseschedule (scheduleID, price, startdatetime, enddatetime, location);
	    schedulelist.add(newschedule);
	    System.out.println("This course schedule has been added!");
    }

    public void viewcourseschedule() {
	    String output = String.format("%s %5s %10s %5s, "Schedule ID", "Price", "Start Date Time", "End Date Time", "Location");"
	
	    for(courseschedule schedule:schedulelist) {
		    output += String.format("\n %d %5f %10s %s", schedule.getID(), schedulegetPrice(), schedule.getstartdatetime(), schedule.getenddatetime, schedule.getlocation());
	    }
	    System.out.println(output);
	
    }
    public void deletecourseschedule() {
    	viewcourseschedule();
	int deleteschedule = Helper.readInt("ID of course schedule to delete");
	
	for (courseschedule schedule:schedulelist) {
		if(deleteschedule == schedule.getID());
		    schedulelist.remove(schedule);
		    System.out.println("This course schedule has been deleted.");
	    }else {
	    	System.out.println("This course schedule ID  doesn't exist.");
	    }	
	}
	    
}

		
	}

}
