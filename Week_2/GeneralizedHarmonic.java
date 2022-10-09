public class GeneralizedHarmonic { 
	public static void main(String[] args) {
		int n = Integer.parseInt(args[0]);
		int r = Integer.parseInt(args[1]);
		
		// computes the sum from 1/1^r + ... + 1/n^r
		double sum = 0.0;
		for (int i = 1; i <= n; i++) {
			sum += 1 / Math.pow(i, r);
		}
		System.out.println(sum);
	}
}

