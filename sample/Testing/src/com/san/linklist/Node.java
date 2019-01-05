package com.san.linklist;

public class Node {
	
	protected String data;
	protected Node next;
	
	public Node(){
		data = null;
		next = null;
		
	}
	
	public Node(String data, Node next){
		this.data = data;
		this.next = next;
	}
	
}
