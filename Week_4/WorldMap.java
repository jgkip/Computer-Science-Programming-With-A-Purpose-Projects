public class WorldMap {
	public static void main(String[] args) {
		
		int width = StdIn.readInt();
		int height = StdIn.readInt();
		//System.out.println(width + ", " + height);

		StdDraw.setCanvasSize(width, height);
		StdDraw.setXscale(0, width);
		StdDraw.setYscale(0, height);
		

		while (!StdIn.isEmpty()) {
			String name = StdIn.readString();
			//System.out.println(name);
			int vertices = StdIn.readInt();
			double[] xS = new double[vertices];
			double[] yS = new double[vertices];
			
			for (int i = 0; i < vertices; i++) {
				xS[i] = StdIn.readDouble();
				yS[i] = StdIn.readDouble();
			}
			
			StdDraw.polygon(xS,yS);
		}

	}
}