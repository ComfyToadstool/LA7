package edu.wmich.cs1120.StanRitsema.LA7;

public class PriorityQueue<T extends Comparable<T>> {
	
	private static boolean DEBUG = false;
	
	Node<T> front;
	
	/**
	 * Basic no-argument Constructor.
	 */
	public PriorityQueue() {
		front = null;
	}

	/**
	 * Checks whether the queue is empty.  True if so, false otherwise.
	 * 
	 * @return boolean
	 */
	public boolean isEmpty() {
		
		return ( front == null );
		
	}
	
	/**
	 * Pops the front element off the queue and returns it.
	 * 
	 * @return data
	 */
	public T dequeue() {
		
		T data;
		
		data = (T) front.getData();
		
		front = front.getNext();
		
		return data;
		
	}
	
	/**
	 * Enqueues 'next', comparing it to the current queue values 
	 * on the way in.
	 * 
	 * @param next
	 */
	public void enqueue(T next) {
		
		Node<T> pending = new Node<T>(next);
		
		if( this.front == null ) {
			
			this.front = pending;
			
		}else {
			
			int comp = front.getData().compareTo(pending.getData());
			
			if( DEBUG ) {
				System.err.println("Initial comp value is " + comp);
			}
			
			if( comp < 0 ) {
				
				pending.setNext(front);
				
				front = pending;
				
				return;
				
			}else {
				
				Node<T> pointer = front;
				
				while( (pointer.getNext() != null)
						&& ( pointer.getNext().getData().
								compareTo(pending.getData()) >= 0 ) ) {
					
					pointer = pointer.getNext();
					
				}
				
				pending.setNext(pointer.getNext());
				
				pointer.setNext(pending);
				
			}
			
		}
		
		if( DEBUG ) {
			System.err.println("The current queue is: ");
			Node<T> travel = front;
			while( travel != null ) {
				System.err.println(travel.getData().toString());
				travel = travel.getNext();
			}
		}
		
	}

}
