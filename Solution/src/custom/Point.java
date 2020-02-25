package custom;

public class Point {
	public final int x;
	public final int y;

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

		// slope in 1st quadrant = 0 - inf => 0 - pi/2

		double ret = 0.0;

		if (x > 0 && y > 0)
			ret = slope;

		// second quadrant = -inf - 0 => +pi => dpi/2 => pi

		if (x < 0)
			ret = Math.PI + slope;

		// fourth quadrant - inf - 0 => +2pi => 3pi/2 to 2pi

		if (x > 0 && y < 0)
			ret = slope + Math.PI * 2;

		return ret;
	}
}
