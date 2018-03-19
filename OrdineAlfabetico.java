import java.util.Scanner;
import java.util.ArrayList;
import java.util.Arrays;

/*
Created 15/3/18

16/3 : Comments
*/

class OrdineAlfabetico {
	
	final static String allChars = "0123456789aàbcdeèéfghiìjklmnoòpqrstuùvwxyz";

	public static void main (String[] args){
	  
		String[] input = inputData();
	  
		// TESTING: print "myArray"
		System.out.println("INPUT: "+ Arrays.toString(input));
		
		//TESTING
		System.out.println(order2Strings(input[0], input[1]));
	  
	  
	  
	}

  
	private static String[] inputData(){
	   
		ArrayList<String> input = new ArrayList<String>(); // create an ArrayList
		Scanner sc = new Scanner(System.in); // create a Scanner
	  
		int count = -1;

		do {
			System.out.println("Enter an alphanumeric string:");
			String data = sc.nextLine();
		  
			data = clean(data); // clean data
			if(checkString(data)) {
				input.add(data); // add data to ArrayList
				count++;
			} else System.out.println("\nERROR: The String contains a forbidden character, thus it will be ignored\n");
			
		} while (!input.get(count).equals(""));

		String[] myArray = input.toArray(new String[0]); // copy the ArrayList into a new Array called "myArray"
	  
		myArray = Arrays.copyOf(myArray, myArray.length - 1); // remove the last cell from "myArray"
	  
		return myArray;
		}
	

		private static String clean (String toClean) {
		
			toClean = toClean.trim();
			toClean = toClean.toLowerCase();
			
				
		
			return toClean;
		}
	
		private static boolean checkString(String arg) {
			
			for (int i=0 ; i<arg.length() ; i++) {
				if(allChars.indexOf(arg.charAt(i)) == -1) return false;
			}
			return true;
		}
		
		//TRUE: if s1=a & s2=z
		private static boolean order2Strings(String s1, String s2) {
		
			int minLength = (s1.length() <= s2.length()) ? s1.length() : s2.length();

			if(s1.equals(s2)) return true;
			
			for (int i=0 ; i<minLength ; i++) {
			
				if(allChars.indexOf(s1.charAt(i)) < allChars.indexOf(s2.charAt(i))) return true;
				else if (allChars.indexOf(s1.charAt(i)) < allChars.indexOf(s2.charAt(i))) return false;
			
			}
			
			if(s1.length() < s2.length()) return true;
			else return false;
		}
		
		



	}
