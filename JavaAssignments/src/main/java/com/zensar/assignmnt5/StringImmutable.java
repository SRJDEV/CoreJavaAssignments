package com.zensar.assignmnt5;

public class StringImmutable {
	
	
	public static void referenceCheck(Object x, Object y) {  
        if (x == y) {  
            System.out.println("Both pointing to the same reference");  
   
        } else {  
            System.out.println("Both are pointing to different reference");  
        }  
    }  
	
	
	
	
	 public static void concatSting(String s1) {
	        s1 = s1 + "8";
	    }
	 
	    // Method 2
	    // Concatenates to StringBuilder
	    public static void concatStringBuilder(StringBuilder s2)
	    {
	        s2.append("8");
	    }
	 
	    // Method 3
	    // Concatenates to StringBuffer
	    public static void concatStringBuffer(StringBuffer s3)
	    {
	        s3.append("8");
	    }
	
	
	public static void main(String[] args) {  
        String st1 = "Java";  
        String st2 = "Java";  
        System.out.println("Before Modification in st1");  
        referenceCheck(st1, st2);  
        st1 += "new";  
        System.out.println("After Modification");  
        referenceCheck(st1, st2);  
        
        
        
        
     // Custom input string
        // String 1
        String s1 = "Java";
 
        // Calling above defined method
        concatSting(s1);
 
        // s1 is not changed
        System.out.println("String: " + s1);
 
        // String 1
        StringBuilder s2 = new StringBuilder("Java");
 
        // Calling above defined method
        concatStringBuilder(s2);
 
        // s2 is changed
        System.out.println("StringBuilder: " + s2);
 
        // String 3
        StringBuffer s3 = new StringBuffer("Java");
 
        // Calling above defined method
        concatStringBuffer(s3);
 
        // s3 is changed
        System.out.println("StringBuffer: " + s3);
    }  

}
