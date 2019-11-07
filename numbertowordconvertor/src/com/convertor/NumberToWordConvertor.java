package com.convertor;

import java.util.Scanner;

public class NumberToWordConvertor {

	 private static final String[] specialNames = {
		        "",
		        " thousand",
		        " million",
		    };
		    
		    private static final String[] tensNames = {
		        "",
		        " ten",
		        " twenty",
		        " thirty",
		        " forty",
		        " fifty",
		        " sixty",
		        " seventy",
		        " eighty",
		        " ninety"
		    };
		    
		    private static final String[] numNames = {
		        "",
		        " one",
		        " two",
		        " three",
		        " four",
		        " five",
		        " six",
		        " seven",
		        " eight",
		        " nine",
		        " ten",
		        " eleven",
		        " twelve",
		        " thirteen",
		        " fourteen",
		        " fifteen",
		        " sixteen",
		        " seventeen",
		        " eighteen",
		        " nineteen"
		    };
		    
		    private String convertLessThanOneThousand(int number) {
		        String current;
		        
		        if (number % 100 < 20){
		            current = numNames[number % 100];
		            number /= 100;
		        }
		        else {
		            current = numNames[number % 10];
		            number /= 10;
		            
		            current = tensNames[number % 10] + current;
		            number /= 10;
		        }
		        if (number == 0) return current;
		        return numNames[number] + " hundred" + current;
		    }
		    
		    public String convert(int number) {

		        if (number == 0) { return "zero"; }
		        
		        String prefix = "";
		        
		        if (number < 0) {
		            number = -number;
		            prefix = "negative";
		        }
		        
		        String current = "";
		        int place = 0;
		        
		        do {
		            int n = number % 1000;
		            if (n != 0){
		                String s = convertLessThanOneThousand(n);
		                current = s + specialNames[place] + current;
		            }
		            place++;
		            number /= 1000;
		        } while (number > 0);
		        
		        return (prefix + current).trim();
		    }
		    
		    public static void main(String[] args) {
		    	 String conti="Y";
		    	do {
		    	Scanner myObj = new Scanner(System.in);
		    	System.out.println("Please enter any number upto 999999999");
		    	 
		    	 if(myObj.hasNextInt()) {
		    		 int number = myObj.nextInt();
		    		 NumberToWordConvertor obj = new NumberToWordConvertor();
				        System.out.println( obj.convert(number));
		    	 }else {
		    		 System.out.println("Please enter any Integer values upto 999999999");
		    	 }
		    	 String dummy = myObj.nextLine();
		    	 System.out.println("Do you want to continue press Y for \"Yes\" and N for \"NO\" ");
			        conti = myObj.nextLine();
		        
		    	}while(conti.equalsIgnoreCase("Y"));
		    	
		    	System.out.println("Exiting.....");
		    }
}
