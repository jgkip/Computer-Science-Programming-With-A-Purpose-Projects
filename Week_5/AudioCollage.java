public class AudioCollage {

	/*
	Sound representation is an array with values ranging from -1 to +1
	44,100 samples/second
	*/

	public static double[] amplify(double[] a, double alpha) {
		double volume = alpha;
		double[] amplified = new double[a.length];

		// decrease volume if alpha is between 0 and 1
		if (alpha > 0 && alpha < 1) {
			volume *= 1;
		}
		
		for (int i = 0; i < a.length; i++) {
			amplified[i] = a[i];
		}

		for (int i = 0; i < amplified.length; i++) {
			amplified[i] *= volume;
		}
		return amplified;

	}

	public static double[] reverse(double[] a) {
		double[] reversed = new double[a.length];

		int index = a.length-1;
		for (int i = 0; i < a.length; i++) {
			reversed[i] = a[index];
			index -= 1;
		} 
		return reversed;
	}

	public static double[] merge(double[] a, double[] b) {
		double[] merged = new double[a.length + b.length];
		for (int i = 0; i < a.length; i++) {
			merged[i] = a[i];
		}

		for (int j = a.length; j < merged.length; j++) {
			merged[j] = b[j-a.length];
		}
		return merged;
	}

	public static double[] mix(double[] a, double[] b) {
		double[] a_prime = null;
		double[] b_prime = null;
		double[] mixed = null;

		if (a.length < b.length) {
			mixed = new double[b.length];
			a_prime = new double[a.length + (b.length-a.length)];
			b_prime = new double[b.length];

			for (int i = 0; i < b.length; i++) {
				b_prime[i] = b[i];
			}

			for (int i = 0; i < a.length; i++) {
				a_prime[i] = a[i];
			}

			for (int i = a.length; i < a_prime.length; i++) {
				a_prime[i] = 0;
			}
		}
		if (a.length > b.length) { 
			mixed = new double[a.length];
			b_prime = new double[b.length + (a.length-b.length)];
			a_prime = new double[a.length];

			
			for (int i = 0; i < a.length; i++) {
				a_prime[i] = a[i];
			}

			for (int i = 0; i < b.length; i++) {
				b_prime[i] = b[i];
			}

			for (int i = b.length; i < b_prime.length; i++) {
				b_prime[i] = 0;
			}
		}
		
		if (a_prime.length == b_prime.length) {
			for (int i = 0; i < mixed.length; i++) {
				mixed[i] = a_prime[i] + b_prime[i];
			}
		}
		else {
			StdOut.print("Did not pad correctly");
		}
		
		return mixed;
	}

	public static double[] changeSpeed(double[] a, double alpha) { 
		// n is the length of the sound array (I believe)

		int numberOfSamples = (int) Math.floor(a.length/alpha);
		double[] newSound = new double[numberOfSamples];

		for (int i = 0; i < numberOfSamples; i++) {
			newSound[i] = a[(int)Math.floor(i*alpha)];
		}
		return newSound;
	}

	public static void main(String[] args) {

		String[] fileNames = {"singer.wav", "piano.wav", "harp.wav", "chimes.wav", "beatbox.wav"};
		
		double[] song1 = StdAudio.read(fileNames[0]);
		double[] song2 = StdAudio.read(fileNames[1]);
		double[] song3 = StdAudio.read(fileNames[2]);
		double[] song4 = StdAudio.read(fileNames[3]);
		double[] song5 = StdAudio.read(fileNames[4]);

		song2 = amplify(song2, 2);
		song2 = changeSpeed(song2, 0.75);
		song1 = mix(song1, song2);
		song1 = merge(song1, song3);
		song4 = reverse(song4);
		song1 = merge(song1, song4);
		song1 = merge(song1, song5);

		StdAudio.play(song1);

	}
}
