package edu.wmich.cs1120.StanRitsema.LA7;

public class PriorityQueue<T extends Comparable<T>> {
	
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
	
	public void enqueque(Request next) {
		
		Node pending = new Node(next);
		
		if( this.front == null ) {
			
			this.front = pending;
			
		}else if( this.front.getNext() == null ){
			
			int comp = front.getData().compareTo(pending.getData());
			
			if( comp < 0 ) {
				
				pending.setNext(front);
				
				rear = front;
				
				front = pending;
				
			}else {
				
				front.setNext(pending);
				
				rear = pending;
				
			}
			
		}else {
			
			Node pointer = front;
			
			while( pointer.getNext().getNext() != null ) {
				
				int comp = pointer.getNext().getData().
						compareTo(pending.getData());
				
				if( comp < 0 ) {
					
					pending.setNext(pointer.getNext());
					pointer.setNext(pending);
					
				}else {
					
					pointer = pointer.getNext();
					
				}
				
			}
			
		}
		
	}

}
