import java.util.*;
public class SudokuValidator {
	
	private static boolean isValidRowsAndCols(int[][] sudokuBoard){
		List<Set<Integer>> rowList = new ArrayList<Set<Integer>>();
		List<Set<Integer>> colList = new ArrayList<Set<Integer>>();
		for(int i = 0 ; i < 9 ; i++){
			rowList.add(new HashSet<Integer>());
			colList.add(new HashSet<Integer>());
		}
		for(int row = 0 ; row < 9 ; row++){
			for(int col = 0; col < 9; col++){
			   int cellValue = sudokuBoard[row][col];
			   if(cellValue == -1){
				   continue;
			   }
			   if(cellValue < 1 || cellValue > 9 ){
				   return false;
			   }
			   if(rowList.get(row).contains(cellValue)){
				   return false;
			   }
			   if(colList.get(col).contains(cellValue)){
				   return false;
			   }
			   rowList.get(row).add(cellValue);
			   colList.get(col).add(cellValue);
			}
		}
		return true;
	}

	private static boolean isValidBlocks(int[][] sudokuBoard){
		List<Set<Integer>> blockList = new ArrayList<Set<Integer>>();
		for(int i = 0 ; i < 9 ; i++){
			blockList.add(new HashSet<Integer>());
		}
		for(int rowBlock = 0; rowBlock < 3; rowBlock++){
			for(int colBlock = 0; colBlock < 3; colBlock++){
				for(int minRow = 0; minRow < 3; minRow++){
					for(int minCol = 0; minCol < 3; minCol++){
						int row = rowBlock * 3 + minRow;
						int col = colBlock * 3 + minCol;
						int cellValue = sudokuBoard[row][col];
						int block = rowBlock * 3 + colBlock;
						if(blockList.get(block).contains(cellValue)){
							return false;
						}
						blockList.get(block).add(cellValue);
					}
				}
			}
		}
		return true;
	}
	public static boolean isValidSudoku(int[][] sudokuBoard){
		if(!isValidRowsAndCols(sudokuBoard)){
			return false;
		}
		if(!isValidBlocks(sudokuBoard)){
			return false;
		}
		return true;
	}
}
