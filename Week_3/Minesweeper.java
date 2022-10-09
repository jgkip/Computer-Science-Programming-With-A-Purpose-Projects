public class Minesweeper {
	public static void main(String[] args) {
		int m = Integer.parseInt(args[0]);
		int n = Integer.parseInt(args[1]);
		int k = Integer.parseInt(args[2]);

		String[][] grid = new String[m+2][n+2]; // padded grid 
		boolean[][] mines = new boolean[m+2][n+2];

		// initialize grid 
		
		for (int i = 0; i < m+2; i++) {
			for (int j = 0; j < n+2; j++) {
				grid[i][j] = "0";
			}
		}
		

		// generate and store mine locations
		int[] xloc = new int[k];
		int[] yloc = new int[k];

		for (int i = 0; i < k; i++) {
			int rx = (int) (1+Math.random() * m);
			int ry = (int) (1+Math.random() * n);
			//xloc[i] = rx;
			//yloc[i] = ry;
			if (!mines[rx][ry]) { // if new loc, add to grid
				mines[rx][ry] = true;
				grid[rx][ry] = "*";
			}
			else { // otherwise, reroll 
				while (mines[rx][ry]) {
					rx = (int) (1+Math.random() * m);
					ry = (int) (1+Math.random() * n);
				}
				grid[rx][ry] = "*";
			}
			
		}

		// for each cell, look up, down, left, right, and diagonal and check for mines
		// update cell if neighbors are mines 
		// neighbor cell is at most two cells away
		
		for (int i = 1; i < m+1; i++) {
			for (int j = 1; j < n+1; j++) {
				//System.out.print(grid[i][j] + "\t");
				if (grid[i][j] != "*") {
					
					if (grid[i-1][j-1] == "*") { // top left
						int c = Integer.parseInt(grid[i][j]);
						c += 1;
						grid[i][j] = Integer.toString(c);
					}
					if (grid[i][j-1] == "*") { // directly above
						int c = Integer.parseInt(grid[i][j]);
						c += 1;
						grid[i][j] = Integer.toString(c);	
					}
					if (grid[i+1][j-1] == "*") { // top right
						int c = Integer.parseInt(grid[i][j]);
						c += 1;
						grid[i][j] = Integer.toString(c);
					}
					if (grid[i-1][j] == "*") { // left same level
						int c = Integer.parseInt(grid[i][j]);
						c += 1;
						grid[i][j] = Integer.toString(c);	
					}
					if (grid[i+1][j] == "*") { // right same level
						int c = Integer.parseInt(grid[i][j]);
						c += 1;
						grid[i][j] = Integer.toString(c);
					}
					if (grid[i-1][j+1] == "*") { // bottom left
						int c = Integer.parseInt(grid[i][j]);
						c += 1;
						grid[i][j] = Integer.toString(c);	
					}
					if (grid[i][j+1] == "*") { // directly below
						int c = Integer.parseInt(grid[i][j]);
						c += 1;
						grid[i][j] = Integer.toString(c);
					}
					if (grid[i+1][j+1] == "*") { // directly above
						int c = Integer.parseInt(grid[i][j]);
						c += 1;
						grid[i][j] = Integer.toString(c);	
					}
				}

			}

		}
		
		// print
		for (int i = 1; i < m+1; i++) {
			for (int j = 1; j < n+1; j++) {
				System.out.print(grid[i][j] + "  ");
			}
			System.out.println("");
		}

		
		
	}
}