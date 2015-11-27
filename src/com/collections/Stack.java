package com.collections;

import java.util.HashMap;
import java.util.Iterator;

import com.collections.FixedCapacityStack.ReversibleIterator;

public class Stack<Item> implements Iterable<Item>{

	private Node first;
	private int n;
	
		private class Node{
			private Item item;
			private Node next;
		}
		
		public boolean isEmpty(){
			return first==null;
			// or n==o;
		}
		
		public int size(){
			return n;
		}
		
		public void push(Item item){
			Node oldfirst = first;
			first = new Node();
			first.item = item;
			first.next = oldfirst;
			n++;
		}
		
		public Item pop(){
			Item item = first.item;
			first = first.next;
			n--;
			return item;
		}
		
		public Item peek(){
			return first.item;
		}
		
		@Override
		public String toString() {
			StringBuilder str = new StringBuilder();
			for (Item item : this) {
				str.insert(0, item.toString());
			}
			return str.toString();
		}
		
		public Node reverse(Node firstNode){
			Node temp = firstNode.next;
			Node newFirst = temp;
			firstNode.next = null;
			while(temp.next  != null){
				newFirst = temp;
				temp = temp.next;
				newFirst.next = firstNode;
				firstNode = newFirst;
			}
			temp.next = firstNode;
			first =temp;
			return firstNode;
		}
		
		public boolean find(Item item){
			for (Item items : this) {
				if(items.equals(item)){
					return true;
				}
			}
			return false;
		}
		public void deletekthNode(int i){
			Node currentNode = first;
			if(n>=i){
				for (int j = 0; j < i-2; j++) {
					currentNode = currentNode.next;
				}
				currentNode.next = currentNode.next.next;
				n--;
			}
		}
		
		public void deleteLastNode(){
			Node current = first;
			if(n==0){
				
			}else if(n<2){
				first = null;
				n--;
			}else{
			while(current.next.next != null){
				current = first.next;
			}
			current.next = null;
			n--;
			}
		}
		
		public static void main(String[] args) {
//			String inp = "to be or not to - be - - that - - - is";
//			inp="it was - the best - of times - - - it was - the - -";
//			Stack<String> s = new Stack<>();
//			for (String string : inp.split(" ")) {
//				if(!string.equals("-")){
//					s.push(string);
//				}
//				else System.out.println(s.pop()+" ");
//			}
//			System.out.println("(" + s.size() + " left on stack)");
			
			System.out.println("*****Reversing a stack*****");
			Stack<Integer> sint = new Stack<>();
			for (int i = 0; i < 10; i++) {
				sint.push(i);
			}
			System.out.println("before reverse " + sint);
			sint.reverse(sint.first);
			System.out.println("Reverse "+ sint);
		}

		@Override
		public Iterator<Item> iterator() {
			return new stackIterator();
		}
		
		public class stackIterator implements Iterator<Item>{
			
			private Node current = first;
			@Override
			public boolean hasNext() {
				return current != null;
			}

			@Override
			public Item next() {
				Item item = current.item;
				current = current.next;
				return item;
			}

			@Override
			public void remove() {
			}
			
		}
}
