public class GameOfLife {
private static void printGeneration(int[][] generation){
        int n = generation.length;
        for(int i = 0 ; i < n; i++){
            for(int j = 0 ; j  < n; j++){
                System.out.print(generation[i][j] + " ");
            }
            System.out.println();
        }
}
  private static int getCellState(int row,int col , int[][] generation){
      int lastCellIndex = generation.length - 1;
      int liveCount = 0;
      if(row > 0  && col > 0){
          liveCount += generation[row-1][col-1];
      }      
      if(row > 0){
          liveCount += generation[row-1][col];
          if(col < lastCellIndex){
              liveCount += generation[row-1][col + 1];
          }
      }
      if(col > 0){
          liveCount += generation[row][col - 1];
          if(row < lastCellIndex){
              liveCount += generation[row + 1][col - 1];
          }
      }
      if(col < lastCellIndex){
          liveCount += generation[row][col + 1];
          if(row < lastCellIndex){
              liveCount += generation[row + 1][col + 1];
          }
      }
      if(row < lastCellIndex){
          liveCount += generation[row + 1][col];
      }
      return (liveCount == 2 ? 1 : 0);
  }
  public static int[][] getNextGeneration(int[][] generation){
	  int n = generation.length;
	  int[][] nextGeneration = new int[n][n];
	  for(int i = 0 ; i < n ; i++){
		  for(int j = 0; j < n ; j++){
			  nextGeneration[i][j] = getCellState(i, j, generation);
		  }
	  }
	  return nextGeneration;
  }
  public static void main(String[] args) {
    int[][] generation = {{0,1,1,0},{0,0,1,1},{1,0,1,0},{0,1,0,1}};
    printGeneration(generation);
    System.out.println("The next generation is : ");
    printGeneration(getNextGeneration(generation));
}
}