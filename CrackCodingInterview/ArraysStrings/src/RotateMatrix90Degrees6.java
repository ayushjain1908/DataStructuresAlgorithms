
public class RotateMatrix90Degrees6 {
	
	private static void printMatrix(int[][] matrix){
		for(int i = 0 ; i < matrix.length; i++){
			for(int j = 0 ; j < matrix[0].length; j++){
				System.out.print(matrix[i][j] + " ");
			}
			System.out.println();
		}
	}
	
	// Using aux space
	public static int[][] rotateClockwise(int[][] matrix){
		int m = matrix.length;
		int n = matrix[0].length;
		int[][] rmatrix = new int[n][m];
		for(int i = 0 ; i < m; i++){
			for(int j = 0 ; j < n; j++){
				rmatrix[j][m - 1 - i] = matrix[i][j];
			}
		}
		return rmatrix;
	}
	
	// In Place Rotation, Only valid for Square Matrices,Layer by layer rotation
	public static void inplaceRotateClockwise(int[][] matrix){
		int N = matrix.length;
		for(int layer = 0 ; layer < N/2; layer++){
			int first = layer;
			int last = N - 1 - layer;
			for(int i = first ; i < last ; i++){
				int offset = i - first;
				// Save top
				int top = matrix[first][i];
				// Left ==> Top
				matrix[first][i] = matrix[last - offset][first];
				// Bottom ==> Left
				matrix[last - offset][first] = matrix[last][last - offset];
				// Right == > Bottom
				matrix[last][last - offset] = matrix[i][last];
				// Top ==> Right
				matrix[i][last] = top;
			}
		}
	}
	
	public static void main(String[] args) {
		int[][] matrix = {{1,2,3,4},
				          {5,6,7,8},
				          {9,10,11,12}};
	 	
		int[][] sqmatrix = {{1,2,3,4},
		                    {5,6,7,8},
		                    {9,10,11,12},
		                    {13,14,15,16}};
        printMatrix(matrix);
        int[][] rmatrix = rotateClockwise(matrix);
        System.out.println();
        printMatrix(rmatrix);
        System.out.println();
        printMatrix(sqmatrix);
        inplaceRotateClockwise(sqmatrix);
        System.out.println();
        printMatrix(sqmatrix);
    }
}