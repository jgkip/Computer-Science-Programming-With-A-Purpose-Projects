public class GreatCircle {
	public static void main(String[] args) {

		double r = 6371.0;

		
		double x1 = Math.toRadians(Double.parseDouble(args[0]));
		double y1 = Math.toRadians(Double.parseDouble(args[1]));
		double x2 = Math.toRadians(Double.parseDouble(args[2]));
		double y2 = Math.toRadians(Double.parseDouble(args[3]));
		
		double cos1 = Math.cos(x1);
		double cos2 = Math.cos(x2); 

		double x = (x2-x1)/2;
		double y = (y2-y1)/2;

		double sin1 = Math.sin(x) * Math.sin(x);
		double sin2 = Math.sin(y) * Math.sin(y);
		
		double discriminant = sin1 + (cos1 * cos2 * sin2);

		double root = Math.sqrt(discriminant);
		
		double arcsin = Math.asin(root);
		
		double distance = 2 * r * arcsin;

		System.out.println(distance + " kilometers");
	}
}



