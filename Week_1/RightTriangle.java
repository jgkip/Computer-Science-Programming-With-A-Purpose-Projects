public class RightTriangle {
	public static void main(String[] args) {
		int a = Integer.parseInt(args[0]);
		int b = Integer.parseInt(args[1]);
		int c = Integer.parseInt(args[2]);

		boolean positive = a > 0 && b > 0 && c > 0;

		int hypotenuse = Math.max(a, Math.max(b, c));

		int shortestSide = Math.min(a, Math.max(b, c));

		int mid = (a + b + c) - hypotenuse - shortestSide;

		boolean sumSquares = ((shortestSide * shortestSide) + (mid * mid)) == (hypotenuse * hypotenuse);

		boolean result = positive && sumSquares;

		System.out.println(result);

	}
}


