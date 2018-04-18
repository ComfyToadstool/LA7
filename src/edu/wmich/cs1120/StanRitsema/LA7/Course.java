package edu.wmich.cs1120.StanRitsema.LA7;

import java.util.ArrayList;
import java.util.ListIterator;
import java.util.function.Consumer;

public class Course implements ICourse{
	
	private String dept;
	private int number;
	private int capacity;
	private int enrollment;
	private ArrayList<String> students;
	
	/**
	 * Returns this Course's dept.
	 * 
	 * @return dept
	 */
	public String getDept() {
		return this.dept;
	}
	
	/**
	 * Returns this Course's number.
	 * 
	 * @return number
	 */
	public int getNumber() {
		return this.number;
	}
	
	/**
	 * Constructor for Course.  Takes three parameters.
	 * 
	 * @param dept
	 * @param number
	 * @param capacity
	 */
	public Course(String dept, int number, int capacity) {
		
		this.dept = dept;
		this.number = number;
		this.capacity = capacity;
		students = new ArrayList<>();
		
	}

	/**
	 * Checks whether or not this course is at capacity.  True if 
	 * so, false if not.
	 * 
	 * @return boolean
	 */
	@Override
	public boolean isFull() {
		
		return (this.enrollment == this.capacity);
	}

	/**
	 * Adds a student named 'name' to the list of students enrolled in 
	 * the course.  Then increments enrollment and prints a relevant 
	 * message.
	 * 
	 * @param name
	 */
	@Override
	public void addStudent(String name) {
		
		this.students.add(name);
		this.enrollment++;
		
		System.out.println(name + " successfully registered "
				+ this.dept + " " + this.number);
		
	}
	
	/**
	 * Basic Consumer of Strings.  Simply prints to the console.
	 */
	Consumer<String> action = x -> {
		
		System.out.println(x);
		
	};

	/**
	 * Prints this course's dept and number, then the names of all students 
	 * enrolled.
	 */
	@Override
	public void printClassList() {
		
		System.out.println("Class List for " + this.dept
				+ " " + this.number);
		
		ListIterator<String> rollCall = students.listIterator();
		
		rollCall.forEachRemaining(action);
		
	}
	
	/**
	 * Checks whether or not this course matches the dept and number 
	 * combination provided.  Returns true if so, false otherwise.
	 * 
	 * @param dept
	 * @param number
	 * @return boolean
	 */
	public boolean thisCourse(String dept, int number) {
		
		boolean found = false;
		
		if( this.dept.equalsIgnoreCase(dept) && (this.number == number) ) {
			found = true;
		}
		
		return found;
		
	}
	
	/**
	 * Incomplete toString override.  Returns a String including dept, 
	 * number, and capacity.
	 * 
	 * @return String
	 */
	public String toString() {
		
		return (this.dept + "," + this.number + "," + this.capacity);
		
	}

}
