package edu.wmich.cs1120.StanRitsema.LA7;

public interface INode<E> {
	
	// Returns the data stored in this node.
	E getData();
	
	// Returns the node next to this node.
	Node<E> getNext();
	
	// Sets node received as the next node to this node.
	void setNext(Node<E> next);
		
}

