package custom;

public class Point {
	int x;
	int y;

	public Point(int x, int y) {
		this.x = x;
		this.y = y;
	}

	public double getSlope() {
		if (x == 0) {
			if (y > 0)
				return Math.PI / 2;
			else if (y < 0)
				return 3 * Math.PI / 2;
			else
				return 0;
		}

		Double slope = Math.atan((double) y / x);

		return x < 0 ? Math.PI + slope : slope;

	}
}
