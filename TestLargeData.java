/*Charles Bryant
 * 1-21-2014 
 * ITCS 2214 
 * HW1
 * 
 * Reads a list of 500,000 nine digit numbers form a file 
 * and sorts them in an array. 
 * Then it compares the sorted array to
 * the file that has the correct ordered list to check if 
 * the values where sorted correctly. 
 * Once completed the accuracy and the time that it 
 * took to sort the list is printed in the IDE console*/

//import java.util.Random;
import java.util.Scanner;
import java.io.*;

public class TestLargeData {
    public static void main(String[]args) throws IOException {
	
	Scanner ssn = new Scanner(new File("simulate_search.txt"));
	Scanner answer = new Scanner(new File("simulate_correct_answers.txt"));
	
	LargeData obj = new LargeData();
	obj.load_DB("ssn-db.txt");
	obj.restructure();
	
	int student_count = 0;
	int total = 0;
	
	StopWatch sw = new StopWatch();
	sw.start();
	
	while(ssn.hasNext()) {
	    total++;

	    //tests if student's answer matches correct answer
	    if(obj.isSSN_in_DB(ssn.nextInt()) == (answer.nextInt() == 1))		
		student_count++;
	}
	ssn.close();
	answer.close();
	
	sw.stop();
	System.out.println("Time (sec): "+(sw.getElapsedTime()*.001)
			   +"\nCorrect: "+((float)student_count/(float)total*100.0)+"% ("+student_count+"/"+total+")");
	
    }
}