package edu.wmich.cs1120.StanRitsema.LA7;

public class PriorityQueue<T extends Comparable<?>> {
	
	Node front;
	Node rear;
	
	public PriorityQueue() {
		front = rear = null;
	}

	public boolean isEmpty() {
		
		return ( front == rear );
		
	}
	
	public T dequeque() {
		
		T data;
		
		data = (T) front.getData();
		
		front = front.getNext();
		
		return data;
		
	}
	
	public void enqueque() {
		
		
		
	}

}
