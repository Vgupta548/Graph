import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

public class MaxConnections {


	 static int countConnections(List<List<Integer>> matrix) {
		 int connections = 0;
		 
		 if(matrix != null && matrix.size() >0) {
			 int rows = matrix.size();
			 int cols = matrix.get(0).size();
			 
			 int f=0;
		     int d=0;
		     int digf=0;
		     int digd=0;
		     int digu=0;
		     
		     for(int i =0; i<rows; i++) {
		    	   for(int j=0; j<cols; j++) {
		    		   if(matrix.get(i).get(j) == 1) {
		    			   f=j+1;
			    		   d=i+1;
			    		   digf= i+1;
			    		   digd = j+1;
			    		   digu = i-1;
			    		  
			    		   
			    		   if(f<cols && matrix.get(i).get(f) == 1) {
			    			   connections++;
			    		   }
			    		   
			    		   if(d<rows && matrix.get(d).get(j) == 1) {
			    			   connections++;
			    		   }
			    		   
			    		   if(digf< cols && digd<rows && matrix.get(digd).get(digf) ==1) {
			    			   connections++;
			    		   }
			    		   
			    		   if(digf< cols && digu>=0 && matrix.get(digu).get(digf)  ==1) {
			    			   connections++;
			    		   }
		    		   }
		    	   }
		     }
		     
		 }
		
		 return connections;
	 }

    // Complete the countConnections function below.
    static int countConnections(int[][] matrix, int rows, int cols) {
        int connections = 0;
        int f=0;
        int d=0;
        int digf=0;
        int digd=0;
        int digupu=0;
       for(int i =0; i<rows; i++) {
    	   for(int j=0; j<cols; j++) {
    		   System.out.println("i :"+i+" : j: "+j);
    		   if(matrix[i][j] == 1) {
	    		   f=j+1;
	    		   d=i+1;
	    		   digf= j+1;
	    		   digd = i+1;
	    		   digupu = i-1;
	    		   System.out.println("f :"+f);
	    		   System.out.println("d :"+d);
	    		   System.out.println("digf :"+digf);
	    		   System.out.println("digd :"+digd);
	    		   if(f<cols && matrix[i][f] == 1) {
	    			   connections++;
	    			   System.out.println("front");
	    		   }
	    		   
	    		   if(d<rows && matrix[d][j] == 1) {
	    			   connections++;
	    			   System.out.println("down");
	    		   }
	    		   
	    		   if(digf< cols && digd<rows && matrix[digd][digf] ==1) {
	    			   connections++;
	    			   System.out.println("diag");
	    		   }
	    		   
	    		   if(digf< cols && digupu>=0 && matrix[digupu][digf] ==1) {
	    			   connections++;
	    			   System.out.println("diag");
	    		   }
    		   }
    		   
    	   }
       }
       
       return connections;

    }

    

    public static void main(String[] args) throws IOException {
;        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        //BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int matrixRows = Integer.parseInt(bufferedReader.readLine().trim());
        int matrixColumns = Integer.parseInt(bufferedReader.readLine().trim());

       // List<List<Integer>> matrix = new ArrayList<>();
        int[][] matrix = new int[matrixRows][matrixColumns];

        for (int i = 0; i < matrixRows; i++) {
            String[] matrixRowTempItems = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

            //List<Integer> matrixRowItems = new ArrayList<>();

            for (int j = 0; j < matrixColumns; j++) {
                int matrixItem = Integer.parseInt(matrixRowTempItems[j]);
               // matrixRowItems.add(matrixItem);
                matrix[i][j] = matrixItem;
            }

          //  matrix.add(matrixRowItems);
        }

        int res = countConnections(matrix,matrixRows, matrixColumns );

        System.out.println(res);
       // bufferedWriter.write(String.valueOf(res));
       // bufferedWriter.newLine();

        bufferedReader.close();
       // bufferedWriter.close();
    }
}
