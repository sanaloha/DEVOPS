package com.san.linklist;

/***
* Create a link list with the head node, can add the nodes, delete the nodes
***/

//TODO: Code Reuse using At functions as, instead of addFirst it should be insertAt
//TODO: For each Calls the provided function with every node of the chain and the index of the
//node.
//TODO: for ...of loop, Generators

public class LinkListEx {
	
	protected Node head;
	private Node [] elements;
	
	LinkListEx(){
		head = null;
	}

	public Node getHead(){
		
		return this.head;
	}
	
	public void setHead(Node head){
		
		this.head = head;
	}
	
	public void addFirst(String data){
		/*Node node = new Node(data, null);
		node.next = this.head;
		this.head = node;*/
		
		this.head = new Node(data, this.head);
	}
	
	public int size(){
		
		int counter = 0;
		Node node = this.head;
		while(node != null){
			counter++;
			node = node.next;
		}
		
		return counter;
	}
	
	public void addLast(String data){
		
		Node node = this.head;
		while(node.next != null){
			node = node.next;
		}
		node.next = new Node(data,null);
	}
	public boolean removeLast(){
		Node previous = this.head;
		Node current = this.head.next;
		
		//check if there no node
		if(this.head == null)
			return false;
		//check if there is only one node
		if(this.head.next == null){
			this.head = null;
			return false;
		}

			
			
		while(current.next != null){
			previous = current;
			current = current.next;
		}
		previous.next = null;
		return true;
	}
	public void removeFirst(){
		
		this.head = this.head.next;
	}
	public void showList(){
		Node node = this.head;
		while(node != null){
			System.out.println(node.data);
			node = node.next;
		}
	}
	//TODO: insertLast
	//TODO: removeAt
	
	public boolean removeAt(int index){
		
		if(this.head == null)
			return false;
		
		if(index == 0){
			this.head = this.head.next;
			return true;
		}
		Node previous = getAt(index -1);
		//avoid index out of bound
		if(previous == null || previous.next == null)
			return false;
		previous.next = previous.next.next;
		 
		 return true;
		
	}
	
	public Node getAt(int index){
		
		int counter = 0;
		if(this.head == null)
			return null;
		
		Node node = this.head;
		while(node != null){
			if(index == counter)
				return node;
			
			node = node.next;
			counter++;
			
		}
		return null;
	}
	/***
	 * Insert a new node at provided index
	 * If index is out of bounds add the node
	 * to the end of the list
	 * 
	 * ****/
	public boolean insertAt(String data, int index){
		
		if(this.head == null){
			this.head = new Node(data, null);
			return true;
		}
		
		if(index == 0){
			/*Node node = new Node(data,null);
			node.next = this.head;
			this.head = node;*/
			this.head = new Node(data, this.head);
			return true;
		}
		
		Node previous = getAt(index -1);
		/*if(previous ==null)
			previous = getLast();*/
		Node node = new Node(data,null);
		node.next = previous.next;
		previous.next = node;
		
		//out of bounds
		
		return true;
		
	}
	
	/** Midpoint of the link list: Return the middle node of the link list, if the list has a even numbers of elements,
	 *return the node at the end of the first half of the list. Do not use the counter variable, do not use the size and iterate 
	 *through one element at a time. EX: list.insert('a), list.insert(b), list.insert('c'), midpoint(l) // returns {data:b}
	 * * * @param linkList
	 * @return
	 * 
	 * Algo: Define two temp variables slow and fast
	 * Point both slow and fast  to the head node
	 * increment slow by one and fast by 2 places
	 * check the fast node next if it is null or next->next is null
	 */
	
	public Node midPoint(LinkListEx linkList){
		
		Node slow = linkList.head;
		Node fast = linkList.head;	
		while(fast.next != null && fast.next.next !=null){
			slow = slow.next;
			fast = fast.next.next;
		}
		
		return slow;
		
	}
	
	/***
	 * Given a linked list return true if list is a circular
	 * false if it is not:
	 * Examples
	 * LinkList list = new List();
	 * a = new Node('a'), b= new Node('b'), c = new Node('c')
	 * l.head = a;
	 * a.next = b;
	 * b.next = c;
	 * c.next = b;
	 * circular(l)// true
	 * 
	 * ***/
	
	public boolean isCircular(LinkListEx linkList){
		Node slow = linkList.head;
		Node fast = linkList.head;
		
		while(fast.next != null && fast.next.next !=null){
			slow = slow.next;
			fast = fast.next.next;
			if(slow == fast)
				return true;
			
		}
		
		return false;
	}
	
	/**
	 * Given the link list and integer n, return the element n spaces
	 * from the last node in the list. Do not call the size method of the 
	 * link list. Assume that n will always be less than the length of the
	 * list Example: list.insert('a');
	 * list.insert('b');
	 * list.insert('c');
	 * list.insert('d');
	 * fromLast(list, 2).data // returns 'b'; 
	 * 	 * **/
	
	public Node fromLast(LinkListEx linkList, int n){
		
		Node slow = linkList.head;
		Node fast = linkList.head;
		//Increase fast toposition n, assume that n would always be less than the length
		while(n > 0){
			fast = fast.next;
			n--;
		}
		//
		while(fast.next != null){
			//increment by one position
			slow = slow.next;
			fast = fast.next;
		}
		return slow;
		
	}
}
