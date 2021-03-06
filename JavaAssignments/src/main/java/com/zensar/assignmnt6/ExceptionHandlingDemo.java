package com.zensar.assignmnt6;

public class ExceptionHandlingDemo {

	
	
	static void convertStringToInt(String num) {
		
		try {
		int number = Integer.parseInt(num);
	}catch(ArithmeticException e) {
		System.out.println("Inside Arithmatic format exception");
		e.printStackTrace();
	}catch(NumberFormatException e) {
		System.out.println("Inside numer format exception");
		e.printStackTrace();
	}
		finally {
			System.out.println("See you!");
		}
		
	}
	
	
	static void nestedTryCatch() {
		
		
		try {
			  
            int a[] = { 1, 2, 3, 4, 5 };
  

           // System.out.println(a[5]);
  
            // try-block2 inside another try block
            try {
  
                // performing division by zero
                int x = a[2] / 0;
            }
            catch (NumberFormatException e2) {
             //   System.out.println("division by zero is not possible");
            }
        }
        catch (ArrayIndexOutOfBoundsException e1) {
            System.out.println("ArrayIndexOutOfBoundsException");
            System.out.println("Element at such index does not exists");
        }
		 catch (ArithmeticException e2) {
             System.out.println("division by zero is not possible");
         }
		
        
	}
	
	
	public static void main(String[]ar) {
		
		convertStringToInt("20");
		nestedTryCatch();
	
		
	}
}
