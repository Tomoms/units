import java.util.Scanner;
import java.util.ArrayList;
import java.util.Arrays;

/*
Created 15/3/18

16/3 : Comments
*/

class OrdineAlfabetico {

  public static void main (String[] args){
	  
      String[] input = inputData();
	  
	  //TESTING: view "myArray"
	  System.out.println("INPUT: "+ Arrays.toString(input));
	  
	  
	  
  }

  
   private static String[] inputData(){
	   
      ArrayList<String> input = new ArrayList<String>(); //create an ArrayList
      Scanner sc = new Scanner(System.in); // create a Scanner
	  
      int count = -1;

        do {
          System.out.println("Enter a alphanumeric word:");
          String data = sc.nextLine();
		  
		  data = clean(data); //clean data
		  
          input.add(data); //add data to ArrayList
		  
          count++;
      } while (!input.get(count).equals(""));

      String[] myArray = input.toArray(new String[0]); //copy the ArrayList in to a new Array "myArray"
	  
      myArray = Arrays.copyOf(myArray, myArray.length - 1); //remove the last cell from "myArray"
	  
      return myArray;
	}
	

	private static String clean (String toClean) {
		
		toClean = toClean.trim();
        toClean = toClean.toLowerCase();
		
		return toClean;
	}
	
	
/*
    private static String order2String(String data1, String data2) {
		
	}
*/


}
