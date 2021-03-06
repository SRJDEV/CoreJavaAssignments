package com.zensar;

public class StackedArray {

	int ary[];
	int top =-1;
	int size;
	
	
	
	public StackedArray(int size) {
		super();
		this.size = size;
		
		this.ary = new int[size];
		
	}
	
	void push(int x) {
		
		if(top+1 == size) {
			//array is full
			
			System.out.println("Stack Overflow");
		}else {
			
			ary[++top] = x;
			System.out.println(x + " pushed into stack");
		}
	}
	
	 int pop() {
		
		if(top<0) {
			System.out.println("Stack Underflow");
			return 0;
		}else {
			int x =ary[top--];
			System.out.println(x + " popped out of stack");
			return x;
			
		}
		
	}
	 
	    void print(){
	  	  
	    for(int i = top;i>-1;i--){
	    	
		System.out.println(" "+ ary[i]);

	    }
	
	 }
	    
		
		public static void main(String[]args) {
		
	    	
		StackedArray stack = new StackedArray(3);
		stack.push(10);
		stack.push(20);
		stack.push(30);
		stack.push(40);
		stack.pop();
		stack.print();
	}
	
}
