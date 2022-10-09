public class ThueMorse {
	public static void main(String[] args) {
		int n = Integer.parseInt(args[0]);

		int[] sequence = new int[n];

		// generate TM sequence 
		for (int i = 0; i < sequence.length; i++) {
			if (i == 0) { 
				sequence[i] = 0;
			}
			else if (i % 2 == 0) { 
				sequence[i] = sequence[i/2];
			}
			else { 
				sequence[i] = 1 - sequence[i - 1];
			}
		}


		// output
		for (int i = 0; i < sequence.length; i++) {
			for (int j = 0; j < sequence.length; j++) {
				if (i == j || sequence[i] == sequence[j]) {
					System.out.print("+  ");
				}
				else {
					System.out.print("-  ");	
				}

			}	
			System.out.println("");
		}

	}
}