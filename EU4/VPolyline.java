import java.util.Iterator;

public class VPolyline implements Polyline {

	private int width = 1;
	private Point[] vertices;
	private String colour = "black";

	public VPolyline() {
		this.vertices = new Point[0];
	}

	public VPolyline(Point[] vertices) {

		this.vertices = new Point[vertices.length];

		for (int i = 0; i < vertices.length; i++)
			this.vertices[i] = new Point(vertices[i]);
	}

	@Override
	public Point[] getVertices() {
		// creates a new array, loops through all the elements
		// in the old array and adds them to the new one which is then returned

		Point[] h = new Point[vertices.length];

		for (int i = 0; i < vertices.length; i++) {
			h[i] = vertices[i];
		}
		return h;
	}

	@Override
	public String getColour() {
		return this.colour;
	}

	@Override
	public int getWidth() {
		return this.width;
	}

	@Override
	public double length() {

		double length = 0;

		Point[] h = this.vertices;

		for (int i = 0; i < h.length - 1; i++) {

			length += h[i].distance(h[i + 1]);
		}
		return length;
	}

	@Override
	public void setColour(String colour) {
		this.colour = colour;
	}

	@Override
	public void setWidth(int width) {
		this.width = width;
	}

	@Override
	public void add(Point vertex) {

		Point[] h = new Point[this.vertices.length + 1];
		int i;

		for (i = 0; i < this.vertices.length; i++) {

			h[i] = this.vertices[i];
		}

		h[i] = new Point(vertex);

		this.vertices = h;
	}

	@Override
	public void insertBefore(Point vertex, String vertexName) {
		Point[] verticesAddBefore = new Point[vertices.length + 1];

		int i, j = 0;
		for (i = 0; i < vertices.length; i++) {
			if (vertices[i].getName().equals(vertexName)) {
				verticesAddBefore[j] = vertex;
				j++;
			}
			verticesAddBefore[j] = this.vertices[i];
			j++;
		}
		this.vertices = verticesAddBefore;

	}

	@Override
	public void remove(String vertexName) {
		Point[] removedVertex = new Point[vertices.length - 1];
		int k = 0;
		for (int i = 0; i < this.vertices.length; i++) {
			if (this.vertices[i].name.equals(vertexName)) {
				k = i;
				break;
			}
		}
		for (int j = 0; j < k; j++) {
			removedVertex[j] = this.vertices[j];
		}
		for (int j = k; j < removedVertex.length; j++) {
			removedVertex[j] = this.vertices[j + 1];
		}
		this.vertices = removedVertex;

	}

	public String toString() {
		String result = "{[";

		for (int i = 0; i < vertices.length; i++) {
			result += vertices[i].toString();

			if (i < vertices.length - 1)

				result += ", ";
		}
		result += "], " + colour + ", " + width + "}";

		return result;
	}

	@Override
	public Iterator<Point> iterator() {

		return new VPolylineIterator();
	}

	public class VPolylineIterator implements Iterator<Point> {

		private int current = -1;

		public VPolylineIterator() {

			if (VPolyline.this.vertices.length > 0)
				current = 0;
		}

		@Override
		public boolean hasNext() {

			return current != -1;

		}

		@Override
		public Point next() {

			Point vertex = VPolyline.this.vertices[current];

			if (current >= 0 && current < VPolyline.this.vertices.length - 1)

				current++;

			else
				current = -1;

			return vertex;
		}
	}
}
