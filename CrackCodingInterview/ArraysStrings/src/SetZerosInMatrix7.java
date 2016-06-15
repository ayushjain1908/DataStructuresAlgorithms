
public class SetZerosInMatrix7 {

	// Using aux space,using two arrays for rows and cols
	public static void setZeros(int[][] matrix){
		boolean[] rows = new boolean[matrix.length];
		boolean[] cols = new boolean[matrix[0].length];
		for(int i = 0 ; i < matrix.length; i++){
			for(int j = 0 ; j < matrix[0].length; j++){
				if(matrix[i][j] == 0){
					rows[i] = true;
					cols[j] = true;
				}
			}
		}
		for(int row = 0 ; row < rows.length; row++){
			if(rows[row]){
				nullifyRow(matrix, row);
			}
		}
		for(int col = 0; col < cols.length; col++){
			if(cols[col]){
				nullifyColumn(matrix,col);
			}
		}
		
	}
	
	// Without using Aux Space ,using first row and first column as aux arrays
	public static void setZerosSpaceOptimized(int[][] matrix){
		boolean firstRow = false;
		boolean firstCol = false;
		for(int i = 0 ; i < matrix[0].length; i++){
			if(matrix[0][i] == 0){
				firstRow = true;
				break;
			}
		}
		for(int i = 0 ; i < matrix.length; i++){
			if(matrix[i][0] == 0){
				firstCol = true;
				break;
			}
		}
		for(int i = 1 ; i < matrix.length; i++){
			for(int j = 1; j < matrix[0].length; j++){
				if(matrix[i][j] == 0){
					matrix[i][0] = 0;
					matrix[0][j] = 0;
				}
			}
		}
		for(int row = 1 ; row < matrix.length; row++){
			if(matrix[row][0] == 0){
				nullifyRow(matrix, row);
			}
		}
		for(int col = 1; col < matrix[0].length; col++){
			if(matrix[0][col] == 0){
				nullifyColumn(matrix,col);
			}
		}
		if(firstRow){
			nullifyRow(matrix, 0);
		}
		if(firstCol){
			nullifyColumn(matrix,0);
		}
	}
	
	private static void nullifyRow(int[][] matrix, int row){
		for(int i = 0 ; i < matrix[0].length; i++){
			matrix[row][i] = 0;
		}
	}
	private static void nullifyColumn(int[][] matrix, int col){
		for(int i = 0; i < matrix.length; i++){
		   matrix[i][col] = 0;	
		}
	}
	private static void printMatrix(int[][] matrix){
		for(int i = 0 ; i < matrix.length; i++){
			for(int j = 0 ; j < matrix[0].length; j++){
				System.out.print(matrix[i][j] + " ");
			}
			System.out.println();
		}
	}
	public static void main(String[] args) {
		int[][] matrix = {{1 , 1 , 1, 0},
				          {1 , 0 , 1, 1},
				          {1 , 1 , 1, 1}};
		printMatrix(matrix);
		System.out.println();
		setZerosSpaceOptimized(matrix);
		printMatrix(matrix);
	}
}
