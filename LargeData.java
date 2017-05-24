/*Charles Bryant
1-21-2014
ITCS 2214
HW1*/

import java.util.Scanner;
import java.io.*;

public class LargeData {
	int[] ssnArray;
   int[] [] ssnArrayArray;
	
	public LargeData() {
		ssnArray = new int[500000];
      ssnArrayArray = new int [10] [50369];
	}
	
	public boolean load_DB(String filename) throws IOException {
		Scanner input = new Scanner(new File(filename));
		int i=0;
		
		try {
			while(input.hasNext()) {
				ssnArray[i] = input.nextInt();
				i++;
			}
		} catch (IndexOutOfBoundsException e) {
			input.close();
			return false;
		}
		input.close();
		return true;
	}
	
	public void restructure() 
	{
      int zero = 0;
      int one = 0; 
      int two = 0;
      int three = 0;
      int four = 0;
      int five = 0;
      int six = 0;
      int seven = 0;
      int eight = 0;
      int nine = 0;
		int number, endDigit;
		int slot = 0;
				
      for (slot = 0; slot < 500000; slot++)
		{
			number = ssnArray[slot];
			endDigit = number % 10;	
         
         if (endDigit == 0)
			{
				ssnArrayArray[endDigit] [zero] = number;
				zero ++;
			}
			if (endDigit ==1)
			{
				ssnArrayArray[endDigit] [one] = number;
				one ++;
			}
			if (endDigit ==2)
			{
				ssnArrayArray[endDigit] [two] = number;
				two ++;
			}
			if (endDigit ==3)
			{
				ssnArrayArray[endDigit] [three] = number;
				three ++;
			}
			if (endDigit ==4)
			{
				ssnArrayArray[endDigit] [four] = number;
				four ++;
			}
			if (endDigit ==5)
			{
				ssnArrayArray[endDigit] [five] = number;
				five ++;
			}
			if (endDigit ==6)
			{
				ssnArrayArray[endDigit] [six] = number;
				six ++;
			}
			if (endDigit ==7)
			{
				ssnArrayArray[endDigit] [seven] = number;
				seven ++;
			}
			if (endDigit ==8)
			{
				ssnArrayArray[endDigit] [eight] = number;
				eight ++;
			}
			if (endDigit ==9)
			{
				ssnArrayArray[endDigit] [nine] = number;
				nine ++;
			}
		
		}
		
	}
	
	public boolean isSSN_in_DB(int find_ssn) 
	{
		int lastDigit = find_ssn%10;;
		int count = 0;
		boolean found = false;
     
		   while (count < 50369)
		   {
		   	if (ssnArrayArray [lastDigit] [count] == find_ssn)
		   	{
               found = true;
               count = 50369;
			   }
            count ++;
		   }
		
      return found;
	}
}