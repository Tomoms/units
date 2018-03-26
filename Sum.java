import java.util.Arrays;

class Sum {
	
	public static void main (String[] args) {
		
		int[] arr = {-4, 5, 8, 10, 9};
		int myVal = 4;
		
		Contatore(arr);
		
		
		
		
	}
/*
	private static boolean combo(int[] list, int val) {
		
		int[] tmp = new int[list.length];
		
		for(int i=0 ; i<list.length ; i++) {
			if(list[i]== val) return true;
		}
		
		tmp[0] = list[0];
		
		for (int i=1 ; i<list.length ; i++) {
			tmp[i] = list[i];
			
			System.out.println("Testing: "+sumArray(tmp));
			if(sumArray(tmp) == val) return true;
			tmp[i] =0;
			
			
		}
		
		
		
		
		return false;
	}
*/

/*	
	private static int sumArray (int[] list) {
		int ris = list[0];
		for(int i=1 ; i<list.length ; i++) {
			ris = ris + list[i];
		}
		return ris;
	}
*/	

	
	    public static String inBinario( int n, int nBit ){
    
           String accum = "" ;
           
           for( int m = n ; m != 0 ; m = m / 2 )

               accum = m % 2 + accum ;
			
			int diff = nBit - accum.length();
			if(diff >0) {
				for (int i=0 ; i<diff ; i++) {
					accum = "0"+accum;
				}
			} 

           return n == 0 ? "0" : accum ;    
    }
    
// Il metodo che segue detrmina la nb-esima potenza del 2

    public static int pot2( int nb ){
    
        int p ; // assumera` come valori le potenze del 2, cioe`: 1, 2, 4, 8,...
                // fermandosi dopo 'nb' iterazioni
    
        for( p=1 ; nb > 0 ; nb = nb - 1 )
        
            p = 2 * p;
            
        return p;
    
    }

	
	
	public static void Contatore(int[] list) {
		
		double righe = Math.pow(2, list.length);
		int righec = (int)righe;
		
		
		int[][] bin = new int[righec][list.length];
		
		

       for( int i = 1 ; i < righec ; i = i + 1 ){
       
           System.out.println( inBinario( i, list.length) +" "+ i );
		   
		   for(int j=0 ; j<list.length ; j++) {
			   bin[i][j] = inBinario( i, list.length).charAt(j)-'0';
		   }
		   
		   
		   
       }
	   
	   for(int[] i : bin) {
			System.out.println(Arrays.toString(i));
		}
		
		System.out.println();
		
	}
	
	
	
}