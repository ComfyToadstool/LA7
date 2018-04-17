package edu.wmich.cs1120.StanRitsema.LA7;

import java.io.*;
import java.util.ArrayList;

public class Controller implements IController{
	
	PriorityQueue<Request> requests;
	ArrayList<Course> courses;
	BufferedReader file1;
	BufferedReader file2;
	
	public Controller(PriorityQueue<Request> requestQueue,
			ArrayList<Course> courses, BufferedReader fileIn,
			BufferedReader fileIn1) {
		
		this.requests = requestQueue;
		this.courses = courses;
		this.file1 = fileIn;
		this.file2 = fileIn1;
		
	}
	
	@Override
	public void readCourseFile() {
		
		try {
			
			while( file1.ready() ) {
				
				String line = file1.readLine();
				String[] field = line.split(",");
				
				String dept = field[0];
				int num = Integer.parseInt(field[1]);
				int capacity = Integer.parseInt(field[2]);
				
				Course nClass = new Course(dept, num, capacity);
				courses.add(nClass);
				
			}
			
		} catch (IOException e) {
			System.err.println("Error when reading course.txt");
		}
		
	}

	@Override
	public void readRequestFile() {
		
		try {
			
			while( file2.ready() ) {
				
				// read in the record
				
				String line = file1.readLine();
				String[] field = line.split(",");
				
				String sName = field[0];
				String sLevel = field[1];
				String sDept = field[2];
				String cDept = field[3];
				int cNum = Integer.parseInt(field[4]);
				
				Request nRequest = new Request(sName, sLevel,
						sDept, cDept, cNum);
				addRequest(nRequest);
				
			}
			
		} catch (IOException e) {
			System.err.println("Error when reading request.txt");
		}
		
	}

	@Override
	public void addRequest(Request req) {
		
		this.requests.enqueque(req);
		
	}

	@Override
	public void processRequests() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Course getCourse(String courseDept, int courseNumber) {
		
		Course course = null;
		int i = 0;
		
		while( (course == null) && (i < courses.size()) ) {
			
			if( courses.get(i).thisCourse(courseDept, courseNumber) ) {
				course = courses.get(i);
			}
			
			i++;
			
		}
		
		return course;
		
	}

	@Override
	public void printClassList() {
		// TODO Auto-generated method stub
		
	}

}
