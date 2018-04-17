package edu.wmich.cs1120.StanRitsema.LA7;

import java.io.*;
import java.util.ArrayList;
import java.util.ListIterator;
import java.util.function.Consumer;

public class Controller implements IController{
	
	private static boolean DEBUG = false;
	
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
				
				if( DEBUG ) {
					System.err.println("Reading arg1 file");
				}
				
				String line = file1.readLine();
				String[] field = line.split(",");
				
				String dept = field[0];
				int num = Integer.parseInt(field[1]);
				int capacity = Integer.parseInt(field[2]);
				
				if( DEBUG ) {
					System.err.println("Adding " + dept + " " + num + " to course list");
				}
				
				Course nClass = new Course(dept, num, capacity);
				courses.add(nClass);
				
				if( DEBUG ) {
					Course latest = courses.get(courses.size()-1);
					String lDept = latest.getDept();
					int lNum = latest.getNumber();
					System.err.println("Last course added is "
							+ lDept + " " + lNum);
				}
				
			}
			
		} catch (IOException e) {
			System.err.println("Error when reading course.txt");
		}
		
	}

	@Override
	public void readRequestFile() {
		
		try {
			
			while( file2.ready() ) {
				
				if( DEBUG ) {
					System.err.println("Reading arg2 file");
				}
				
				String line = file2.readLine();
				String[] field = line.split(",");
				
				String sName = field[0];
				String sLevel = field[1];
				String sDept = field[2];
				String cDept = field[3];
				int cNum = Integer.parseInt(field[4]);
				
				if( DEBUG ) {
					System.err.println("Adding " + sName
							+ "'s request for " + cDept + " " + cNum);
				}
				
				Request nRequest = new Request(sName, sDept,
						sLevel, cDept, cNum);
				addRequest(nRequest);
				
			}
			
		} catch (IOException e) {
			System.err.println("Error when reading request.txt");
		}
		
	}

	@Override
	public void addRequest(Request req) {
		
		this.requests.enqueue(req);
		
	}

	@Override
	public void processRequests() {
		
		if( requests.isEmpty() ) {
			System.err.println("No requests to process!");
			return;
		}else if( (courses.size() == 0) ) {
			System.err.println("No courses known!");
			return;
		}
		
		System.out.println();
		
		for(int i = 0; i < courses.size(); i++) {
			System.out.println(courses.get(i).toString());
		}
		
		
		while( !requests.isEmpty() ) {
			
			Request pending = requests.dequeque();
			
			System.out.println("Request@"
					+ Integer.toHexString(System.identityHashCode(pending))
					+ " processed.");
			
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
		
		System.out.println();
		
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
		System.out.println();
		
	};

	@Override
	public void printClassList() {
		
		ListIterator<Course> registrations = courses.listIterator();
		
		registrations.forEachRemaining(action);
		
	}

}
