package com.trees;

import java.util.Arrays;

import com.util.ArrayGenerator;

public class BinarySearchTree {
	
	public  static Vertex root;
	
	public void constructBST(int[] i){
		System.out.println(Arrays.toString(i));
		root = new Vertex(i[0]);
		Vertex temp=root;
		Vertex current = temp;
		for (int j = 1; j < i.length; j++) {
				while(temp != null)
				{
				 	 current = temp;
					 temp = getVertex(temp, i[j]);
				}
				setVertex(current, i[j]);
				temp = root;
			}
	}
	
	public Vertex getVertex(Vertex v, int i){
		if(v.getItem() > i){
			return v.getLeftVertex();
		}else{
			return v.getRightVertex();
		}
	}
	
	public void setVertex(Vertex v, int value){
		if(v.getItem() > value){
			v.setLeftVertex(new Vertex(value));
		}else{
			v.setRightVertex(new Vertex(value));
		}
	}
	
	public void printTree(Vertex root){
		
	}
	
	public static void main(String[] args) {
		BinarySearchTree bst = new BinarySearchTree();
		bst.constructBST(ArrayGenerator.generateIntArrayNoDuplicates(10));
		BTreePrinter.printNode(root);
	}
}
