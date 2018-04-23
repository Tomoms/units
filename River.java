import java.util.Arrays;
import java.util.ArrayList;
import java.util.Random;

class River {
	
	static final int COLUMNS = 6;
	static final int ROWS = 7;
	static final int PARTS = 100 ;//% how to express the parts of the whole (PARTS is the whole)
	
	public static void main(String[] args) {
		
		//INPUT
		double ratio = 50; //percentage ratio of occupied cell and the number of free cell (100% all cell are filled)
		int[][] track = {{1,0}, {1,1}, {2,2}, {3,1}, {4,2}, {4,3}, {5,4}, {4,5}}; //a given path
		
		
		//PROCESS
		int[][] river = new int[ROWS][COLUMNS];
		int cell = ROWS * COLUMNS;
		
		// generate a random river state
		river = randomFillCell(river, cell, ratio);
	
		// random river state output on console
		int r = 0;
		System.out.println("\nRIVER: \n");
		System.out.println("   0  1  2  3  4  5 \n");
		for(int[] i: river ) {
			System.out.println(r +" "+ Arrays.toString(i));
			r++;
		}
		
		//check if the track is executable and inform the user
		//Output Question 1
		System.out.println("\n\nThe track is " + (chackTrack(river, track, 0, 1) ? "": "NOT ")   + "executable\n");
		
		
		//PART 2
		
		// value that will exprime if it is possible to cross the river
		boolean itIsCrossable = false;
		
		ArrayList<int[]> possibleTrak = new ArrayList<int[]>();
		
		int[] coord1 = new int[2];
		
		//for the first COLUMN
		for(int i=0 ; i<river.length ; i++) {
			if(!itIsCrossable && river[i][0] == 1){
				
				//put the first coord of the the possible track
				coord1[0] = i;
				coord1[1] = 0;
				possibleTrak.add(coord1);

				//Start ricorsion here
				itIsCrossable = crossable(river, i, 0, possibleTrak);
				
				//if I don't find the track clear ArrayList possibleTrak because that track is not possible
				if(!itIsCrossable) {
					possibleTrak.clear();
				}
			}
		}
		
		//Output Question 2
		System.out.println("\nThe river is " + (itIsCrossable ? "" :"NOT ") + "crossable\n");
		
		
		//choose one of the possible track
		//N.B. possibleTrack it has only the cell for which it would make sense to pass but it dosn't
		//	describe a sensible route
		int[][] myTrack = new int[COLUMNS][2];
		
		// if there are some right track do: ...
		if(!possibleTrak.isEmpty()) {
			
			//this is for the data structure, becouse in the first position of possibleTrak 
			//	there is always a cell of the first COLUMN so i can do that...
			myTrack[0] = possibleTrak.get(0);
			possibleTrak.remove(0);
			
			//start recursion
			selectTrack(possibleTrak, myTrack, 1, myTrack[0][0]);
			
			//output Question 3
			System.out.print("\nA possible track could be: ");
			for(int[] i : myTrack)
				System.out.print(Arrays.toString(i) +" ");
		}
		
		System.out.println("\n"); // get some space for lyout
		possibleTrak.clear(); //delite possibleTrak <ArrayList>
		
	}
	
	private static int[][] randomFillCell(int[][] river, int cell, double ratio) {
		
		int toFill = howManyCellToFill(cell, ratio);
		
		int rdX;
		int rdY;
		while(toFill>0) {
			rdX = getRandomXCoordinates();
			rdY = getRandomYCoordinates();
			
			if(river[rdY][rdX] == 0) {
				river[rdY][rdX] = 1;
				toFill--;
			}
		}
		
		return river;
	}
	
	private static int howManyCellToFill(int cell, double ratio) {
		return (cell * (int)ratio) / PARTS;
	}
	
	private static int getRandomXCoordinates() {
		Random rand = new Random();
		return rand.nextInt(COLUMNS);
	}
	
	private static int getRandomYCoordinates() {
		Random rand = new Random();
		return rand.nextInt(ROWS);
	}
	
	////////////////////
	private static Boolean chackTrack(int[][] river, int[][] track, int first, int second) {
		
		int[] c1 = track[first];
		
		//recursion end
		if(second >= track.length){ //track.length = 8 
			if(c1[1] >= COLUMNS-1)
				return true;
			else // The track is finish but you have not crossed all the river
				return false;
		}	
					
		int[] c2 = track[second];
		
		//TESTING
		//System.out.println(Arrays.toString(c1) +" "+  Arrays.toString(c2) +" : "+ adj(c1, c2) +" "+ isRock(river, c1) +" "+ isRock(river, c2));
		
		
		if(isRock(river, c1) && isRock(river, c2) && adj(c1, c2))
			return chackTrack(river, track, ++first, ++second);
		else {
			return false;
		}
		
	}
	
	
	private static boolean adj(int[] c1, int[] c2) {
		boolean xOk = false;
		boolean yOk = false;
		
		if(Math.abs(c1[0]-c2[0]) <= 1)
			xOk = true;
		
		if(Math.abs(c1[1]-c2[1]) <= 1)
			yOk = true;
		
		if(xOk && yOk) 
			return true;
		else return false;
		
	}

	private static boolean isRock(int[][] river, int[] c) {
		if(river[c[0]][c[1]] == 1)
			return true;
		else return false;
	}
	
	////////////////////
	
	private static boolean crossable(int[][] river, int xIn, int yIn, ArrayList<int[]> possibleTrak) {
		
		if(yIn >= COLUMNS-1) // end condition
			return true;
			
		boolean NE = false;
		boolean E = false;
		boolean SE = false;
	
		if(xIn-1 >= 0 && river[xIn-1][yIn+1] == 1) {
			NE = crossable(river, xIn-1, yIn+1, possibleTrak);
			if(NE) {
				int[] coordNE = new int[2];
				coordNE[0] = xIn-1;
				coordNE[1] = yIn+1;
				possibleTrak.add(coordNE);
			}
		}
		
		if(river[xIn][yIn+1] == 1) {
			E = crossable(river, xIn, yIn+1, possibleTrak);
			if(E) {
				int[] coordE = new int[2];
				coordE[0] = xIn;
				coordE[1] = yIn+1;
				possibleTrak.add(coordE);
			}
		}
		
		if(xIn+1 <= river.length-1 && river[xIn+1][yIn+1] == 1){
			SE = crossable(river, xIn+1, yIn+1, possibleTrak);
			if(SE) {
				int[] coordSE = new int[2];
				coordSE[0] = xIn+1;
				coordSE[1] = yIn+1;
				possibleTrak.add(coordSE);
			}
		}
		
		if(!NE && !E &&!SE)
			return false;
		
		
		return true;
	}
	
	private static void selectTrack(ArrayList<int[]> possibleTrak, int[][] myTrack, int YtoFind, int preX) {
		
		if(!possibleTrak.isEmpty()){
	
			for(int i=0 ; i<possibleTrak.size() ; i++){
				
				if(possibleTrak.get(i)[1] == YtoFind && Math.abs(possibleTrak.get(i)[0] - preX) <= 1 ) {
					
					//TEST
					//System.out.println("Ricorsione: "+ Arrays.toString(possibleTrak.get(i)));
					
					myTrack[YtoFind] = possibleTrak.get(i);
					possibleTrak.remove(i);
					
					for( int j=i+1 ; j<possibleTrak.size() ; j++) {
						if(possibleTrak.get(j)[1] == YtoFind) {
							possibleTrak.remove(j);
						}
					}
					
					//TEST
				/*
					for(int[] j : myTrack)
						System.out.println("MyTrack: "+ Arrays.toString(j));
					System.out.println();
				*/
				
					//continue recusion
					selectTrack(possibleTrak, myTrack, ++YtoFind, myTrack[YtoFind-1][0]);
					
				}
				
			}
			
		}
	}
	
	

}