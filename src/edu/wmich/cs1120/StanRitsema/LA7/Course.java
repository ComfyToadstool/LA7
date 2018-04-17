package edu.wmich.cs1120.StanRitsema.LA7;

import java.util.ArrayList;

public class Course implements ICourse{
	
	private String dept;
	private int number;
	private int capacity;
	private int enrollment;
	private ArrayList<String> students;
	
	public Course(String dept, int number, int capacity) {
		
		this.dept = dept;
		this.number = number;
		this.capacity = capacity;
		
	}

	@Override
	public boolean isFull() {
		
		return (this.enrollment == this.capacity);
	}

	@Override
	public void addStudent(String name) {
		
		this.students.add(name);
		this.enrollment++;
		
	}

	@Override
	public void printClassList() {
		// TODO Auto-generated method stub
		
	}
	
	public boolean thisCourse(String dept, int number) {
		
		boolean found = false;
		
		if( this.dept.equals(dept) && (this.number == number) ) {
			found = true;
		}
		
		return found;
		
	}

}
