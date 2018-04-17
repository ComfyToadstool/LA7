package edu.wmich.cs1120.StanRitsema.LA7;

public class Node<E extends Comparable> implements INode<E>{
	
	E data;
	Node<E> next;
	
	public Node(){
		data = null;
		next = null;
	}
	
	public Node( E input ) {
		this.data = input;
		next = null;
	}
	
	public Node( E input, Node<E> succ ){
		this.data = input;
		this.next = succ;
	}

	@Override
	public E getData() {
		// TODO Auto-generated method stub
		return this.data;
	}

	@Override
	public Node<E> getNext() {
		// TODO Auto-generated method stub
		return this.next;
	}

	@Override
	public void setNext(Node<E> next) {
		
		this.next = next;
		
	}

}
