import java.util.Arrays;
import java.util.Scanner;

class Arcipelago {
	
	private static int COLUMNS = 7;
	private static int ROWS = 8;
	private static int PARTS = 100;
	
	public static void main(String[] args) {
		
		//INPUT
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter your percentual ratio (%) of Island/Sea: ");
		double ratio = sc.nextDouble();
		
		//PROCESSING
		int[][] arcipelago = new int[ROWS][COLUMNS];
		
		fillGrid(arcipelago, ratio);
		
		int[][] copyArci = new int[ROWS][COLUMNS];
		
		copyArray(arcipelago, copyArci);
		
		// Output arcipelago
		System.out.print("    ");
		for (int i=0 ; i<COLUMNS ; i++) {
			System.out.print(i+"  ");
		}
		System.out.println();
		int r = 0;
		for(int[] i : arcipelago) {
			System.out.println(r + ": " + Arrays.toString(i));
			r++;
		}
		System.out.println();
		
		System.out.println("Pieces of Islands: " +piecesOfEarth(ratio));
		System.out.println("Islands Surface: " +2*piecesOfEarth(ratio) +" Kmq");
		
		int numIsland = 0 ;
		for(int i=0 ; i<ROWS ; i++){
			for(int j=0 ; j<COLUMNS ; j++) {
				if(copyArci[i][j] ==1 ){
					numIsland++;
					sink(copyArci, i, j); //start recursion here
				}
			}
		}
		
		System.out.println("Number of islands: "+ numIsland);
		
	}
	
	private static int piecesOfEarth (double ratio) {
		return COLUMNS * ROWS * (int) ratio / PARTS;
	}
	
	private static void fillGrid (int[][] arcipelago, double ratio) {
		int toFill = piecesOfEarth(ratio);
		
		if (toFill > 0) {
			
			int XRan;
			int YRan;
			
			while(toFill > 0) {
				XRan = (int)(Math.random() * (ROWS));
				YRan = (int)(Math.random() * (COLUMNS));
				
				if(arcipelago[XRan][YRan] == 0){
					arcipelago[XRan][YRan] = 1;
					--toFill;
				}
			}
			
		}
		
	}
	
	private static void copyArray(int[][] toCopy, int[][] newArray) {
		
		for(int i=0 ; i<ROWS ; i++){
			for(int j=0 ; j<COLUMNS ; j++)
				newArray[i][j] = toCopy[i][j];
		}
		
	}
	
	private static void sink(int[][] copyArci, int i, int j){
		
		copyArci[i][j] = 0;
		
		try {
			if(copyArci[i+1][j] == 1)
				sink(copyArci, i+1, j);
		} catch (Exception e) {
			
		}
		
		try {
			if(copyArci[i][j+1] == 1)
				sink(copyArci, i, j+1);		
		} catch (Exception e) {
			
		}

		try {
			if(copyArci[i-1][j] == 1)
				sink(copyArci, i-1, j);	
		} catch (Exception e) {
			
		}


		try {
			if(copyArci[i][j-1] == 1)
				sink(copyArci, i, j-1);
		}catch (Exception e) {
			
		}

		
	}
	
	

}