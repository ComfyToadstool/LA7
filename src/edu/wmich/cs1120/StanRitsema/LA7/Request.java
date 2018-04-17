package edu.wmich.cs1120.StanRitsema.LA7;

public class Request implements Comparable<Request>{
	
	private String studentName;
	private String studentDept;
	private String studentLevel;
	private String courseDept;
	private int courseNumber;

	@Override
	public int compareTo(Request other) {
		
		int priority = 0;
		
		// check major
		if( deptMatch() ){
			priority++;
		}	
		if( other.deptMatch() ) {
			priority--;
		}
		if( priority != 0 ) {
			return priority;
		}
		
		// check graduation time
		if( yearsFromGraduation(this.studentLevel) <
				other.yearsFromGraduation(other.studentLevel) ) {
			priority++;
		}else if( yearsFromGraduation(this.studentLevel) >
				other.yearsFromGraduation(other.studentLevel) ) {
			priority--;
		}
		
		return priority;
	}
	
	public Request( String studentName, String studentDept,
			String studentLevel, String courseDept, int courseNumber) {
		
		this.studentName = studentName;
		this.studentDept = studentDept;
		this.studentLevel = studentLevel;
		this.courseDept = courseDept;
		this.courseNumber = courseNumber;
		
	}
	
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
	
	public boolean deptMatch() {
		
		return ( this.studentDept.equalsIgnoreCase(this.courseDept) );
		
	}
	
}
