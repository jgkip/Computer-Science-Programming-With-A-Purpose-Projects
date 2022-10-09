public class Divisors {

	public static int gcd(int a, int b) {
		a = Math.abs(a);
		b = Math.abs(b);

		if (a == 0 && b == 0) {
			return 0;
		}
		else if (a == 0 && b != 0) {
			return b;
		}
		else if (a != 0 && b == 0) {
			return a;
		}
		else {
			while (b != 0) {
				int tmp1 = a;
				int tmp2 = b;
				a = b;
				b = tmp1 % tmp2;
			}
			if (a == 0) {
				return b;
			}
			else {
				return a;
			}
		}
	}

	public static int lcm(int a, int b) {
		if (a == 0 || b == 0) {
			return 0;
		}
		return Math.abs(a) * (Math.abs(b) / gcd(a, b));
	}

	public static boolean areRelativelyPrime(int a, int b) {
		return gcd(a, b) == 1;
	}

	public static int totient(int n) {
		if (n <= 0) {
			return 0;
		}
		if (n == 1) {
			return 1;
		}
		int countRelativelyPrime = 0;
		for (int i = 1; i < n; i++) {
			if (areRelativelyPrime(i, n)) {
				countRelativelyPrime += 1;
			}
		}
		return countRelativelyPrime; 
	}

	public static void main(String[] args) {
		int a = Integer.parseInt(args[0]);
		int b = Integer.parseInt(args[1]);

		System.out.println("gcd(" + a + ", " + b + ") = " + gcd(a, b));
		System.out.println("lcm(" + a + ", " + b + ") = " + lcm(a, b));
		System.out.println("areRelativelyPrime(" + a + ", " + b + ") = " + areRelativelyPrime(a, b));
		System.out.println("totient(" + a + ") = " + totient(a));
		System.out.println("totient(" + b + ") = " + totient(b));
		
	}
}