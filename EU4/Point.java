
public class Point {

	String name;
	int x;
	int y;

	public Point(String name, int x, int y) {
		this.name = name;
		this.x = x;
		this.y = y;
	}

	// a copying constructor
	public Point(Point p) {
		name = p.name;
		x = p.x;
		y = p.y;
	}

	public String toString() {

		return "(" + name + "," + x + "," + y + ")";

	}

	public String getName() {

		return name;
	}

	public int getY() {

		return y;
	}

	public int getX() {

		return x;
	}

	public double distance(Point p) {

		double d = Math.sqrt(Math.pow((x - p.x), 2) + Math.pow((y - p.y), 2));
		return d;
	}

	public boolean equals(Point p) {
		if (name.equals(p.name) && x == p.x && y == p.y) {
			return true;
		} else
			return false;
	}

	public void setX(int x) {
		this.x = x;

	}

	public void setY(int y) {
		this.y = y;

	}
}
