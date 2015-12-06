package com.util;

import com.chap01.Node;

public class LinkedListUtils {

	public static <T> void deleteKthElem(Node<T> firstNode, int k){
		Node<T> node = firstNode;
		for (int i = 0; i < k; i++) {
			node= node.nextNode;
		}
		node.nextNode = node.nextNode.nextNode;
	}
	
	public static <T> boolean find(Node<T> firstNode, T key){
		Node<T> node = firstNode;
		while(node!= null){
			if(node.value == key){
				return true;
			}
			node = node.nextNode;
		}
		return false;
	}
	
	public static int findHighestInteger(Node<Integer> firstNode){
		Node<Integer> node = firstNode;
		int highest = node.value;
		while(node != null){
			if(node.value > highest){
				highest = node.value;
			}
		}
		return highest;
	}
	
	
}
