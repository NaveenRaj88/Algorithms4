package com.collections;

import java.util.LinkedList;

public class LinkedListIteration {
	
	private Node firstNode;
	private Node lastNode;
	private int size;
	class Node{
		private Node next;
		private String value;
	}
	
	public LinkedListIteration() {
		// TODO Auto-generated constructor stub
	}
	
	public int getSize(){
		return size;
	}
	
	public void add(String value){
		Node n = new Node();
		n.value = value;
		if(size == 0){
			firstNode = n;
			lastNode = firstNode;
		}
		else{
			lastNode.next=n;
			lastNode = n;
			
		}
		size++;
	}
	
	public Node getFirstNode(){
		return firstNode;
	}
	
	public void print(){
		Node currentNode = firstNode;
		while(currentNode!= null){
			System.out.println("current Node " +currentNode.value);
			currentNode = currentNode.next;
		}
	}
	
	public void printRecursive(Node currentNode){
		if(currentNode!= null){
			System.out.println("current Node " +currentNode.value);
			currentNode = currentNode.next;
			printRecursive(currentNode);
		}
	}
	
	public static void main(String[] args) {
		LinkedListIteration l = new LinkedListIteration();
		l.add("hello");
		l.add("world");
		l.print();
		l.printRecursive(l.getFirstNode());
	}
}
