package edu.wmich.cs1120.StanRitsema.LA7;

import java.io.*;
import java.util.ArrayList;
import java.util.ListIterator;
import java.util.function.Consumer;

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
				
				String line = file2.readLine();
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
		
		if( requests.isEmpty() ) {
			System.err.println("No requests to process!");
			return;
		}
		
		while( !requests.isEmpty() ) {
			
			Request pending = requests.dequeque();
			
			System.out.println("Request" + pending + " processed.");
			
			String sName = pending.getName();
			String cDept = pending.getCourseDept();
			int cNum = pending.getCourseNumber();
			
			Course course = getCourse(cDept, cNum);
			
			if( course.isFull() ) {
				System.out.println(sName + " cannot register for "
						+ cDept + " " + cNum);
			}else {
				course.addStudent(sName);
			}
			
		}
		
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
	
	Consumer<Course> action = x -> {
		
		x.printClassList();
		
	};

	@Override
	public void printClassList() {
		
		ListIterator<Course> registrations = courses.listIterator();
		
		registrations.forEachRemaining(action);
		
	}

}
