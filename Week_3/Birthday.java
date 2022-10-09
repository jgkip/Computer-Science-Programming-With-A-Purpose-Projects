public class Birthday {
	public static void main(String[] args) {
		int n = Integer.parseInt(args[0]);
		int trials = Integer.parseInt(args[1]);

		int[] count = new int[n+1];
		int trial = 1;

		// conduct experiments
		for (int i = 0; i < trials; i++) {
			boolean[] sameBirthday = new boolean[n];
			int people = 0;
			while (true) {
				int r = (int) (Math.random() * n);
				people++;
				if (!sameBirthday[r]) {
					sameBirthday[r] = true;
				}
				else {
					break;
				}
			}
			count[people-1]++; // # trials where i people enter the room
			
		}

		// print results
		double[] cSum = new double[count.length];
		for (int i = 0; i < count.length; i++) {
			// get the cumulative sum 
			for (int j = 0; j <= i; j++) {
				cSum[i] += count[j];
			}
			// print table until cSum converges on 0.50
			cSum[i] /= trials;
			System.out.println(i+1 + "\t" + count[i] + "\t" + cSum[i]);
			if (cSum[i] >= 0.50) {
					break;
			}
		}

		
	}
}