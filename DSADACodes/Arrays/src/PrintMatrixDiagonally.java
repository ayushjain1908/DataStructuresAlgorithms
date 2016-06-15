
public class PrintMatrixDiagonally {

	public static void printDiagonally(int[][] matrix){
		int rowCount = matrix.length;
	    int colCount = matrix[0].length;
	    // Printing the diagonals of first column
		for(int k = 0 ; k <= rowCount - 1; k++){
			int col = 0;
			int row = k;
			while(row >= 0 && col <= colCount - 1){
				System.out.print(matrix[row][col] + " ");
				row--;
				col++;
			}
			System.out.println();
		}
		// Printing the diagonals of last row
		for(int k = 1; k <= colCount -1; k++){
			int row = rowCount - 1;
			int col = k;
			while(row >= 0 && col <= colCount - 1){
				System.out.print(matrix[row][col] + " ");
				row--;
				col++;
			}
			System.out.println();
		}
	}
	public static void main(String[] args) {
		int[][] mat1 = {{1,  2, 3, 4, 5},
				        {6,  7, 8, 9, 10},
				        {11, 12,13,14, 15},
				        {16, 17,18,19, 20}};
		printDiagonally(mat1);
	}
}
