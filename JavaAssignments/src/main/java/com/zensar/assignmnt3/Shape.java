package com.zensar.assignmnt3;

public abstract class Shape {
 
	public abstract void draw();
	
	
	
	public static void main(String[]args) {
		
		
		Shape cube = new Cube();
		cube.draw();
		
		Shape rect = new Rectangle();
		rect.draw();
		
		Shape line = new Line();
		line.draw();
		
	
		
	}
	
}
