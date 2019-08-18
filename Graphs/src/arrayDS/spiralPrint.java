package arrayDS;

public class spiralPrint {
	
	static void spiralPrints(int endingRowIndex, int endingColumnIndex, int a[][]) 
    { 
        int i, startRowIndex = 0, startColumnIndex = 0; 
        /*  k - starting row index 
        m - ending row index 
        l - starting column index 
        n - ending column index 
        i - iterator 
        */
           
        while (startRowIndex < endingRowIndex && startColumnIndex < endingColumnIndex) 
        { 
            // Print the first row from the remaining rows 
            for (i = startColumnIndex; i < endingColumnIndex; ++i) 
            { 
                System.out.print(a[startRowIndex][i]+" "); 
            } 
            System.out.println("increasing startRowIndex : "+startRowIndex);
            startRowIndex++; 
   
            // Print the last column from the remaining columns  
            for (i = startRowIndex; i < endingRowIndex; ++i) 
            { 
                System.out.print(a[i][endingColumnIndex-1]+" "); 
            } 
            System.out.println("decreasing endingColumnIndex : "+endingColumnIndex);
            endingColumnIndex--; 
   
            // Print the last row from the remaining rows */ 
            if ( startRowIndex < endingRowIndex) 
            { 
                for (i = endingColumnIndex-1; i >= startColumnIndex; --i) 
                { 
                    System.out.print(a[endingRowIndex-1][i]+" "); 
                } 
                System.out.println("decreasing startRowIndex : "+endingRowIndex);
                endingRowIndex--; 
            } 
   
            // Print the first column from the remaining columns */ 
            if (startColumnIndex < endingColumnIndex) 
            { 
                for (i = endingRowIndex-1; i >= startRowIndex; --i) 
                { 
                    System.out.print(a[i][startColumnIndex]+" "); 
                } 
                System.out.println("increasing startColumnIndex : "+startColumnIndex);
                startColumnIndex++;     
            }         
        } 
    } 
      
    // driver program 
    public static void main (String[] args)  
    { 
        int R = 3; 
        int C = 6; 
        int a[][] = { {1,  2,  3,  4,  5,  6}, 
                      {7,  8,  9,  10, 11, 12}, 
                      {13, 14, 15, 16, 17, 18} 
                    }; 
        spiralPrints(R,C,a); 
    } 

}
