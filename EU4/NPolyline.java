import java.util.Iterator;

public class NPolyline implements Polyline {

	private static class Node {
		public Point vertex;
		public Node nextNode;

		public Node(Point vertex) {
			this.vertex = vertex;
			nextNode = null;
		}
	}

	private Node vertices;
	private String colour = "black";
	private int width = 1;

	private int size;

	public NPolyline() {
		this.vertices = null;

		// empty polyline, size is 0
		size = 0;
	}

	public NPolyline(Point[] vertices) {
		// if vertices.length == 0, size is set to 0
		// if vertices.length > 0, size will be the length of vertices

		size = 0;
		if (vertices.length > 0) {
			Node node = new Node(new Point(vertices[0]));

			// stores the number of points in an instance variable
			size = vertices.length;

			// sets vertices to the first node
			this.vertices = node;

			// starts at pos/index 1
			int pos = 1;
			while (pos < vertices.length) {
				node.nextNode = new Node(new Point(vertices[pos++]));
				node = node.nextNode;
			}
		}
	}

	public String toString() {

		Node firstNode = this.vertices;

		String result = "{[";

		if (this.vertices != null) {
			result += this.vertices.vertex.toString();

			while (this.vertices.nextNode != null) {
				result += ", ";
				this.vertices = this.vertices.nextNode;
				result += this.vertices.vertex.toString();

			}
		}
		result += "], " + colour + ", " + width + "}";

		// sets vertices to contain the first node in the sequence again
		this.vertices = firstNode;

		return result;

	}

	@Override
	public Point[] getVertices() {

		// if there are no nodes/points in the object, return null
		if (this.vertices == null)
			return null;

		// creates a new array based on the instance variable
		// storing the number of nodes/points
		Point[] h = new Point[size];

		// temporary variable to keep track of current and next node
		Node node = this.vertices;
		int i = 0;

		while (i < size) {
			// adds the point from current node
			// and moves on to the next node

			h[i++] = new Point(node.vertex);
			node = node.nextNode;
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
	public void setColour(String colour) {
		this.colour = colour;
	}

	@Override
	public void setWidth(int width) {
		this.width = width;
	}

	@Override
	public double length() {

		double length = 0;

		// if the polyline has 0 or 1 elements, the length will be 0

		if (this.vertices == null || this.vertices.nextNode == null)
			;
		// do nothing

		else {
			Node node = this.vertices;

			Point nextPoint = null; // starts at null since it is set at the start of the loop

			while (node.nextNode != null) {
				// preparation for the current iteration
				nextPoint = node.nextNode.vertex;

				// adds the length between the current node's point
				// and then next node's point

				length += node.vertex.distance(nextPoint);

				// prepares the next iteration
				node = node.nextNode;

			}
		}
		return length;
	}

	@Override
	public void add(Point vertex) {

		if (this.vertices == null) {
			this.vertices = new Node(new Point(vertex));
		}

		else {
			{

				// references the first node in the sequence
				Node node = this.vertices;

				// won't continue if the current node is null
				// will always continue until the break statement is reached

				while (node != null) {
					// skips through all the nodes until the last one is reached
					// then sets its 'nextNode' to a new node containing a new point,
					// which is a copy of the passed point 'vertex'

					if (node.nextNode == null) {
						node.nextNode = new Node(new Point(vertex));
						// stops the loop from continuing after 'vertex' has been added
						break;
					}
					// the "iteration"
					node = node.nextNode;
				}

			}
		}

	}

	@Override
	public void insertBefore(Point vertex, String vertexName) {
		size++;
		Node newNode = new Node(new Point(vertex));
		if (this.vertices == null) {
			this.vertices = newNode;

		} else {
			if (this.vertices.vertex.getName().equals(vertexName)) {

				newNode.nextNode = this.vertices;
				this.vertices = newNode;
			}

			else {
				Node node = this.vertices;
				while (node.nextNode != null) {
					if (node.nextNode.vertex.getName().equals(vertexName)) {
						newNode.nextNode = node.nextNode;
						node.nextNode = newNode;

						break;
					}

					node = node.nextNode;

				}
			}
		}
	}

	@Override
	public void remove(String vertexName) {

		Node node = this.vertices;

		if (node == null)
			;
		// do nothing

		else {

			if (node.vertex.getName().equals(vertexName)) {

				this.vertices = node.nextNode;

				size--;
			}

			else {
				while (node.nextNode != null) {
					// if the next node matches the passed string
					if (node.nextNode.vertex.getName().equals(vertexName)) {

						node.nextNode = node.nextNode.nextNode;

						size--;

						break;
					}
					// moves to the next node
					node = node.nextNode;

				}
			}

		}
	}

	@Override
	public Iterator<Point> iterator() {

		return new NPolylineIterator();
	}

	public class NPolylineIterator implements Iterator<Point> {
		private Node current = NPolyline.this.vertices;

		@Override
		public boolean hasNext() {
			return current != null;
		}

		@Override
		public Point next() {
			Point n = current.vertex;
			current = current.nextNode;
			return n;

		}

	}
}
