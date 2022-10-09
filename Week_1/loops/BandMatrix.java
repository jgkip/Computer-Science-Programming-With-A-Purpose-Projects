public class BandMatrix { 
	public static void main(String[] args) {
		int n = Integer.parseInt(args[0]);
		int width = Integer.parseInt(args[1]);

		// keep track of part of diag
		int diagX = -1;
		int diagY = -1;

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (i == j) { // diagonals
					diagX = i;
					diagY = j;
					//System.out.println(diagX + ", " + diagY);
					System.out.print("*  ");
				}
				// go rowwise
				else if (i < j) {
					diagX = i;
					diagY = diagX;

					if (j - diagY <= width) {
						System.out.print("*  ");
					}
					else {
						System.out.print("0  ");
					}
				}
				// go columnwise
				else {
					diagY = j;
					diagX = diagY;

					if (i - diagX <= width) {	
						System.out.print("*  ");
					}
					else {
						System.out.print("0  ");
					}
				}
			}	
			System.out.println("");
		}
	}
}

