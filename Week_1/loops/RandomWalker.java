public class RandomWalker {
	public static void main(String[] args) { 
		int r = Integer.parseInt(args[0]);

		int steps = 0;

		int md = 0;

		int x = 0;
		int y = 0;

		System.out.println("(" + x + ", " + y + ")");

		/* 
		Simulate walk as long as the Manhattan distance from any point to the start is not r
		
		*/
		while (md != r) {
			double step = Math.random(); // take a step 

			// North
			if (step < 0.25) {
				y += 1;
				steps += 1;
				if ((Math.abs(x) + Math.abs(y)) == r) {
					md = Math.abs(x) + Math.abs(y);
				}

				System.out.println("(" + x + ", " + y + ")");
			}

			// South
			else if (step >= 0.25 && step < 0.5) {
				y -= 1;
				steps += 1;
				if ((Math.abs(x) + Math.abs(y)) == r) {
					md = Math.abs(x) + Math.abs(y);
				}				
				System.out.println("(" + x + ", " + y + ")");
			}

			// East 
			else if (step >= 0.5 && step < 0.75) {
				x += 1;
				steps += 1;
				if ((Math.abs(x) + Math.abs(y)) == r) {
					md = Math.abs(x) + Math.abs(y);
				}
				System.out.println("(" + x + ", " + y + ")");
			}

			// West
			else {
				x -= 1;
				steps += 1;
				if ((Math.abs(x) + Math.abs(y)) == r) {
					md = Math.abs(x) + Math.abs(y);
				}				
				System.out.println("(" + x + ", " + y + ")");
			}
		}
		System.out.println(steps);
	}
}

