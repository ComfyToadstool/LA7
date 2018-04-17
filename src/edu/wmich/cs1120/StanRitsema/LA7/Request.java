package edu.wmich.cs1120.StanRitsema.LA7;

public class Request implements Comparable<Request>{
	
	private String studentName;
	private String studentDept;
	private String studentLevel;
	private String courseDept;
	private int courseNumber;
	
	/**
	 * Returns the name of the student making the request.
	 * 
	 * @return studentName
	 */
	public String getName() {
		return this.studentName;
	}
	
	/**
	 * Returns the course department to which the requested class belongs.
	 * 
	 * @return courseDept
	 */
	public String getCourseDept() {
		return this.courseDept;
	}
	
	/**
	 * Returns the number of the requested class.
	 * 
	 * @return
	 */
	public int getCourseNumber() {
		return this.courseNumber;
	}

	/**
	 * Override of the compareTo method.  Checks this request against another for priority.
	 * Returns a positive value if this request has higher priority, negative value if it 
	 * has lower, and 0 if the priorities are equal.
	 * 
	 * @param other
	 * @return priority
	 */
	@Override
	public int compareTo(Request other) {
		
		if( other == null ) {
			return 1;
		}
		
		int priority = 0;
		
		// check major
		if( this.deptMatch() ){
			priority++;
		}	
		if( other.deptMatch() ) {
			priority--;
		}
		if( priority != 0 ) {
			return priority;
		}
		
		int yearsA = yearsFromGraduation(this.studentLevel);
		int yearsB = yearsFromGraduation(other.studentLevel);
		
		// check graduation time
		if( yearsA < yearsB ) {
			priority++;
		}else if( yearsA > yearsB ) {
			priority--;
		}
		
		return priority;
	}
	
	/**
	 * Constructor for a Request object.  Takes 5 parameters.
	 * 
	 * @param studentName
	 * @param studentDept
	 * @param studentLevel
	 * @param courseDept
	 * @param courseNumber
	 */
	public Request( String studentName, String studentDept,
			String studentLevel, String courseDept, int courseNumber) {
		
		this.studentName = studentName;
		this.studentDept = studentDept;
		this.studentLevel = studentLevel;
		this.courseDept = courseDept;
		this.courseNumber = courseNumber;
		
	}
	
	/**
	 * Takes a String, a student level, and returns the floor of how many years 
	 * remaining until graduation (i.e. junior means at least 1 years remaining).
	 * 
	 * @param level
	 * @return years
	 */
	public int yearsFromGraduation( String level ) {
		
		int years = -1;
		
		if( level.equalsIgnoreCase("senior") ) {
			years = 0;
		}else if( level.equalsIgnoreCase("junior") ) {
			years = 1;
		}else if( level.equalsIgnoreCase("sophomore") ) {
			years = 2;
		}else if( level.equalsIgnoreCase("freshman") ) {
			years = 3;
		}
		
		return years;
		
	}
	
	/**
	 * Check function for whether the requesting student's major is within the same 
	 * department as the requested class.  True if so, false otherwise.
	 * 
	 * @return boolean
	 */
	public boolean deptMatch() {
		
		return ( this.studentDept.equalsIgnoreCase(this.courseDept) );
		
	}
	
	/**
	 * Incomplete toString override.  Displays the student name, course's dept., and course's number.
	 * 
	 * @return string
	 */
	public String toString() {
		
		return (this.studentName + " is requesting "
				+ this.courseDept + " " + this.courseNumber);
		
	}
	
}
