import java.util.Arrays;
import java.util.Scanner;

class Sum {
	
	public static void main (String[] args) {
		
		//INPUT
		//int[] arr = {-4, 5, 8, 10, 9};
		int[] arr = leggi();
		
		//Integer myVal = 4;
		Integer myVal = readVal();
		System.out.println();
		
		
		//PROCESSING
		int[][] bin = Contatore(arr);
		int[] risu = sums(bin, arr);
		
		
		//OUTPUT
		System.out.println("Il numero" + (check(risu, myVal, bin, arr)? "":" non")+ " si puo comporre");
		
		
	}
	
	
	public static int[] leggi( ){
  
		return leggiDato( 0 ); // lettura del primo dato e di tutti i successivi
	}
  
	private static int[] leggiDato(int i){
		
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter a number:");
		String risp = "";
		
		do {
			risp = sc.nextLine();
      
			if (risp.equals(""))
				return new int[ i ];
			
		} while(!control(risp));
		
		int dato = Integer.parseInt(risp); // il dato da inserire nella posizione 'i'
		int[] dati = leggiDato( i+1 );

		dati[ i ] = dato;
              
		return dati;

	}
	
	private static boolean control(String dato) {
		String allNum = "0123456789";
		for(int i=0 ; i<dato.length() ; i++) {
			if(allNum.indexOf(dato.charAt(i)) == -1) return false;
		}
		
		return true;
	}

	
	private static Integer readVal() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter a value:");
		String risp = "";
		
		do {
			risp = sc.nextLine();
			
		}while(!control(risp));
		
		
		return Integer.parseInt(risp);
		
		
	}
	
	
	public static int[][] Contatore(int[] list) {
		
		int lines = (int) Math.pow(2, list.length);

		int[][] bin = new int[lines][list.length]; // create an array with other array which represent the combinations

		for( int i = 1 ; i < lines ; i++ ){
			
			for(int j=0 ; j<list.length ; j++) {
				bin[i][j] = inBinario( i, list.length).charAt(j) - '0'; // fill array
			}
		   
		   
		   
		}
	   
		//TESTING:
		//for(int[] i : bin) {
		//	System.out.println(Arrays.toString(i));
		//}
		
		
		return bin;
		
	}
	

	//Convert n in binary notation using nBit space
	public static String inBinario( int n, int nBit ){
    
		String accum = "" ;
           
		for( int m = n ; m != 0 ; m = m / 2 ) {
			accum = m % 2 + accum ;
		}
			
		int diff = nBit - accum.length();
		if(diff >0) {
			for (int i=0 ; i<diff ; i++) {
				accum = "0"+accum;
			}
		} 

		return n == 0 ? "0" : accum ;    
    }
	
	
	private static int[] sums (int[][] bin, int[]arr) {

		int lines = (int)Math.pow(2, arr.length);
		
		int[] sums = new int[lines];
		
		for (int i=0 ; i<lines ; i++) {
			sums[i] = sum2Arrays(bin[i],arr);
		}
		
		
		return sums;
	}
	
	
	private static int sum2Arrays (int[] combination, int[] arr) {
		int ris = 0;
		for(int i=0 ; i<arr.length ; i++) {
			ris = ris + combination[i]*arr[i];
		}
		return ris;
	}
	
	
	private static boolean check (int[] toCheck, Integer val, int[][] bin, int[] arr){
		
		String ris="";
		
		for(int i=0 ; i<toCheck.length ; i++) {

			if(val != null && toCheck[i] == val) {
				
				for(int j=0 ; j<arr.length ; j++) {
					// bin[i][] //cordinate
					if(arr[j]*bin[i][j] != 0 ) {
						ris = ris + arr[j]*bin[i][j] +" + " ;
					}
				}
				ris = ris.substring(0, ris.length()-2) + " = " + val;
				
				System.out.println(ris);
				
				return true;
			}
		}
		
		return false;
	}
	
	
}