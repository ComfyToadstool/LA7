package edu.wmich.cs1120.StanRitsema.LA7;

public interface ICourse{
	
	// Determine if the capacity for this course has been reached.
	boolean isFull();
	
	// Add this student to the arraylist for enrolled students for this course.
	void addStudent(String name);
	
	// Print the classlist for this course.
	void printClassList();
	
	// Determines if this course object is the same as the object received as parameter.
	boolean equals(Object arg0);
}
