package com.san.linklist;

public class LinkTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		 testMid();
		 testCircular();
	
	}
	
	public static void testMid(){
		LinkListEx linkList = new LinkListEx();
		linkList.addFirst("san");
		linkList.addLast("santosh");
		linkList.addLast("santosh mid");
		linkList.addLast("santoshh");
		linkList.addLast("santoshhh");
		
		Node node = linkList.midPoint(linkList);
		
		System.out.println("Mid Node " + node.data);
		linkList.addLast("santoshhhh");
		System.out.println("Mid Node " + node.data);
		System.out.println("from last " + linkList.fromLast(linkList, 2).data);
		
		
	}
	
	public static void testCircular(){
		
		LinkListEx linkList = new LinkListEx();
		//Create node a,b and c
		
		Node a = new Node("san", null);
		Node b = new Node("santosh", null);
		Node c = new Node("singh", null);
		
		linkList.head = a;
		a.next = b;
		b.next = c;
		c.next = b;
		
		System.out.println("Is Circular " + linkList.isCircular(linkList));
		
		
		
	}
	public static void test1(){
		LinkListEx linkList = new LinkListEx();
		//linkList.head = new Node("ABC",null);
		
		Node node = new Node("santosh", null);
		linkList.setHead(node);
		System.out.println(linkList.getHead().data);
		System.out.println(linkList.getHead().next);
		linkList.addFirst("san");
		linkList.addFirst("santy");
		
		System.out.println(linkList.getHead().data);
		System.out.println(linkList.getHead().next);
		System.out.println("size " + linkList.size());
		linkList.addLast("santosha");
		System.out.println("New size " + linkList.size());
		
		linkList.showList();
		linkList.removeFirst();
		System.out.println("New size " + linkList.size());
		linkList.showList();
		System.out.println("Remove last");
		linkList.removeLast();
		System.out.println("New size " + linkList.size());
		linkList.showList();
		
		System.out.println("get At===============");
		System.out.println(linkList.getAt(1).data);
		System.out.println("add============");
		linkList.addLast("santosha");
		linkList.addLast("santossssss");
		System.out.println("Remove at ============");
		linkList.removeAt(3);
		linkList.showList();
	}

}
