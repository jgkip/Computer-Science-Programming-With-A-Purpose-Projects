/*
Hypothesis: As you double the distance, the number of steps quadruples. 

*/

public class RandomWalkers {
	public static void main(String[] args) { 
		int r = Integer.parseInt(args[0]);
		int trials = Integer.parseInt(args[1]);

		double allSteps = 0;
		for (int i = 0; i < trials; i++) {
			int steps = 0;

			int md = 0;

			int x = 0;
			int y = 0;

			while (md != r) {
				double step = Math.random();
				if (step < 0.25) {
					y += 1;
					steps += 1;
					if ((Math.abs(x) + Math.abs(y)) == r) {
						md = Math.abs(x) + Math.abs(y);
					}
				}
				else if (step >= 0.25 && step < 0.5) {
					y -= 1;
					steps += 1;
					if ((Math.abs(x) + Math.abs(y)) == r) {
						md = Math.abs(x) + Math.abs(y);
					}				
				}
				else if (step >= 0.5 && step < 0.75) {
					x += 1;
					steps += 1;
					if ((Math.abs(x) + Math.abs(y)) == r) {
						md = Math.abs(x) + Math.abs(y);
					}
				}
				else {
					x -= 1;
					steps += 1;
					if ((Math.abs(x) + Math.abs(y)) == r) {
						md = Math.abs(x) + Math.abs(y);
					}				
				}
			}
			allSteps += steps;
		}
		double average = allSteps / trials;
		System.out.println("average number of steps = " + average);

		
	}
}

