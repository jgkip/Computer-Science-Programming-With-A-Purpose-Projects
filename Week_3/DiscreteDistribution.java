public class DiscreteDistribution {
	public static void main(String[] args) {
		int m = Integer.parseInt(args[0]);

		int[] dist = new int[args.length-1];
		int[] cumulSum = new int[dist.length];

		// get the distribution
		for (int i = 0; i < args.length-1; i++) {
			dist[i] = Integer.parseInt(args[i+1]);
		}

		// calculate the cumulative sums
		for (int i = 0; i < cumulSum.length; i++) {
			for (int j = 0; j <= i; j++) {
				cumulSum[i] += dist[j];
			}
		}

		// get random indices 
		for (int j = 0; j < m; j++) {

			int r = (int) (Math.random() * cumulSum[cumulSum.length-1]);

			int index = -1;

			// determine index based on where r falls within the distribution
			for (int i = 1; i < cumulSum.length; i++) {
				if (r < cumulSum[0]) {
					index = 1;
				}
				else if (cumulSum[i-1] <= r && r < cumulSum[i]) {
					index = i+1;
				}
			}
			System.out.print(index + " ");
		}
		
	}
}