public class Checkerboard {
	public static void main(String[] args) {
		
		int n = Integer.parseInt(args[0]);
		
		StdDraw.setScale(0, n);
		
		double sideLength = 0.1;
		double s = 0.25; // default center point
	
		double x = s;
		double y = s;

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++ ) {
				x = s + sideLength * j * 2;
				if (i % 2 == 0) {
					if (j % 2 == 0) {
						StdDraw.setPenColor(StdDraw.BLUE);
						StdDraw.filledSquare(x, y, sideLength);
					}
					else {
						StdDraw.setPenColor(StdDraw.LIGHT_GRAY);
						StdDraw.filledSquare(x, y, sideLength);
					}
				}
				else {
					if (j % 2 != 0) {
						StdDraw.setPenColor(StdDraw.BLUE);
						StdDraw.filledSquare(x, y, sideLength);
					}
					else {
						StdDraw.setPenColor(StdDraw.LIGHT_GRAY);
						StdDraw.filledSquare(x, y, sideLength);
					}
				}
			
			}
			y = s + sideLength * (i+1) * 2;
		}

	}
}