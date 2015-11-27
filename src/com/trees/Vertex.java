package com.trees;

public class Vertex {

	private Vertex rightVertex;
	
	private Vertex leftVertex;
	
	private int item;

	public Vertex(int item) {
		this.item = item;
	}
	
	public Vertex getRightVertex() {
		return rightVertex;
	}

	public void setRightVertex(Vertex rightVertex) {
		this.rightVertex = rightVertex;
	}

	public Vertex getLeftVertex() {
		return leftVertex;
	}

	public void setLeftVertex(Vertex leftVertex) {
		this.leftVertex = leftVertex;
	}

	public int getItem() {
		return item;
	}

	public void setItem(int item) {
		this.item = item;
	}
	
	
}
