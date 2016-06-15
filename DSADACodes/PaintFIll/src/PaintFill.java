
public class PaintFill {

	public static void fillPaint(int[][] pixels , int x, int y, int originalColor, int fillColor){
		if(x < 0 || x >= pixels[0].length || y < 0 || y >= pixels.length){
			return;
		}
		if(pixels[y][x] != originalColor){
			return;
		}
		pixels[y][x] = fillColor;
		//Paint top neighbor
		fillPaint(pixels, x, y - 1, originalColor, fillColor);
		//Paint right neighbor
		fillPaint(pixels, x + 1, y, originalColor, fillColor);
		//Paint bottom neighbor
		fillPaint(pixels, x, y + 1, originalColor, fillColor);
		//Paint left neighbor
		fillPaint(pixels, x - 1, y, originalColor, fillColor);
		
	}
	private static void printPixels(int[][] pixels){
		for(int i = 0 ; i < pixels.length; i++){
			for(int j = 0; j < pixels[0].length; j++){
				System.out.print(pixels[i][j] + " ");
			}
			System.out.println();
		}
	}
	public static void main(String[] args){
		int[][] pixels = {{2, 4, 1, 3},
				{1,2,2,4},
				{0,2,2,2},
				{2,1,4,3}
	           };
		printPixels(pixels);
		fillPaint(pixels, 1, 1, 2, 5);
		System.out.println("After Paint Filling at (1,1) with color 5");
		printPixels(pixels);
    }
}
