package com.ex;

import java.util.Scanner;

public class NumberToWord {

	 private static final String[] thousandMillion = {
		        "",
		        " thousand",
		        " million",
		    };
		    
		    private static final String[] tens = {
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
		    
		    private static final String[] numbers = {
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
		    
		    private String forThousand(int number) {
		        String current;
		        
		        if (number % 100 < 20){
		            current = numbers[number % 100];
		            number /= 100;
		        }
		        else {
		            current = numbers[number % 10];
		            number /= 10;
		            
		            current = tens[number % 10] + current;
		            number /= 10;
		        }
		        if (number == 0) return current;
		        return numbers[number] + " hundred and" + current;
		    }
		    
		    public String convert(int number) {

		        if (number == 0) { return "zero"; }
		        
		        String value = "";
		        int place = 0;
		        
		        do {
		            int n = number % 1000;
		            if (n != 0){
		                String s = forThousand(n);
		                value = s + thousandMillion[place] + value;
		            }
		            place++;
		            number /= 1000;
		        } while (number > 0);
		        
		        return value;
		    }
	public static void main(String[] args) {

		  Scanner myObj = new Scanner(System.in);
		    System.out.println("Enter Value");

		    int val = myObj.nextInt();
		NumberToWord obj=new NumberToWord();
		System.out.println(obj.convert(val));
		

	}

}
