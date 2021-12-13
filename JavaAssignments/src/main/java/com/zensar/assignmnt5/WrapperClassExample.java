package com.zensar.assignmnt5;


import java.util.Arrays;
import java.util.Scanner;

public class WrapperClassExample {

	
	
	public static void main(String []ar) {
	
		int size;
		 Scanner in = new Scanner(System.in);
		 
		 System.out.println("Enter size of array");
		 
		 size =  Integer.parseInt(in.nextLine());
		 
		 int[] array = new int[size];
//	        String s = in.nextLine();
//	        System.out.println("You entered string " + s);
		 
	
		 System.out.println("Enter mumbers");
	        
	        Scanner sc = new Scanner(System.in);
	        
	    	for(int i=0;i<size;i++)
			{
		
				int num = Integer.parseInt(sc.nextLine());
				array[i]=num;
				
			}
	         
	        Arrays.sort(array);
	        
	        
	    	for(int i=0;i<size;i++)
			{
		
				
				System.out.println(""+array[i]);
				
			}
	        
	        
	        in.close();
	 
	}
}
