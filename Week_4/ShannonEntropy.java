public class ShannonEntropy {
	public static void main(String[] args) {
		int m = Integer.parseInt(args[0]);

		int sum = 0;

		int[] freq = new int[m];

		while (!StdIn.isEmpty()) {
			int r = StdIn.readInt();
			freq[r-1] += 1;
		}

		for (int i = 0; i < freq.length; i++) {
			sum += freq[i];
		}

		double result = 0;

		for (int i = 0; i < freq.length; i++) {
			int f = freq[i];
			double p = (double) f / (double) sum;
			double log = -1;
			if (p == 0) {
				log = 0;
			}
			else {
				log = -(p*(Math.log(p)/Math.log(2)));
			}
			result += log;

			//System.out.println(i+1 + "\t" + f + "\t" + p + "\t" + log);
		}
		StdOut.printf("%.4f\n", result);
	}
}