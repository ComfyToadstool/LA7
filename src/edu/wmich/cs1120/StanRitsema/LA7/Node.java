package edu.wmich.cs1120.StanRitsema.LA7;

public class Node<E> implements INode<E>{
	
	E data;
	Node<E> next;
	
	/**
	 * No argument constructor for Node.
	 */
	public Node(){
		data = null;
		next = null;
	}
	
	/**
	 * Creates a node with input as data, but next unspecified.
	 * 
	 * @param input
	 */
	public Node( E input ) {
		this.data = input;
		next = null;
	}
	
	/**
	 * Creates a node with input as data and succ as its next reference.
	 * 
	 * @param input
	 * @param succ
	 */
	public Node( E input, Node<E> succ ){
		this.data = input;
		this.next = succ;
	}

	/**
	 * Returns the data contained in this node.
	 * 
	 * @return data
	 */
	@Override
	public E getData() {
		
		return this.data;
	}

	/**
	 * Returns the next reference of this node.
	 * 
	 * @return next
	 */
	@Override
	public Node<E> getNext() {
		
		return this.next;
	}

	/**
	 * Sets the next reference of this node to point to the provided next.
	 * 
	 * @param next
	 */
	@Override
	public void setNext(Node<E> next) {
		
		this.next = next;
		
	}

}
