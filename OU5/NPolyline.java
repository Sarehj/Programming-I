import java.util.Iterator;

public class NPolyline implements  Polyline {


	private  static  class  Node
	{
		public  Point  vertex;
		public  Node   nextNode;
		public  Node (Point  vertex)
		{
			this.vertex = vertex;
			nextNode = null;
		}
	}
	private  Node    vertices;
	private  String  colour = "black";
	private  int     width = 1; 

	private int size;


	public  NPolyline  ()
	{
		this.vertices = null;
		//empty polyline, size is 0
		size = 0;
	}
	public  NPolyline (Point  []  vertices)
	{
		//if vertices.length == 0, size is set to 0
		//if vertices.length > 0, size will be the length of vertices
		
		size = 0;
		if (vertices.length  > 0)
		{
			Node  node = new  Node (new  Point (vertices [0]));

			//stores the number of points in an instance variable
			size = vertices.length;

			//sets vertices to the first node
			this.vertices = node;

			//starts at pos/index 1
			int  pos = 1;
			while (pos < vertices.length)
			{
				node.nextNode = new  Node (new  Point (vertices[pos++]));
				node = node.nextNode;
			}
		}
	}
		

	public String toString()
	{
		
		Node firstNode = this.vertices;

		String result = "{[";

		if(this.vertices != null)
		{
			result += this.vertices.vertex.toString();

			while(this.vertices.nextNode != null)
			{
				result += ", ";
				this.vertices = this.vertices.nextNode;
				result += this.vertices.vertex.toString();

			}
		}
		result += "], " + colour + ", " + width + "}";

		//sets vertices to contain the first node in the sequence again
		this.vertices = firstNode;

		return result;
	}
	
	

public String getColor() { 
	return colour; }

public int getWidth() { 
	return width; }

public void setColor(String color) { 
	this.colour = color; }


public void setColour(String colour) {
	this.colour = colour;
}

public void setWidth(int width) {
	this.width = width;
}



public double length() {
	int points = 0;
	Node n = vertices;

	while(n != null) {
		points++;
		n = n.nextNode;
	}
	return points;
}


public void add(Point vertex) {

	//adds 1 to the size of the polyline (number of points/nodes)
		size++;

		//if the polyline is empty
		//sets the first node to a new node based on the passed point
		
		if(this.vertices == null){
			this.vertices = new Node( new Point(vertex) );
		}
		else
		{//start of else

			//references the first node in the sequence
			Node node = this.vertices;

			//won't continue if the current node is null
			//will always continue until the break statement is reached
			while(node != null)
			{
				//skips through all the nodes until the last one is reached
				//then sets its 'nextNode' to a new node containing a new point,
				//which is a copy of the passed point 'vertex'
				if(node.nextNode == null)
				{
					node.nextNode = new Node( new Point(vertex) );
					//stops the loop from continuing after 'vertex' has been added
					break;
				}
				//the "iteration"
				node = node.nextNode;
			}

		}//end of else
	}

//Node n = vertices;
//while(n.nextNode != null) {
//	n = n.nextNode;
//}
//
//n.nextNode = new Node(vertices);




public void remove(String vertexName) {

	Node node = this.vertices;

	if(node == null);
	//do nothing
	else{

		//if the first node matches the passed String,
		//the method is already done
		if(node.vertex.getName().equals(vertexName) )
		{	
			//sets the first node in the object to the second node
			//(effectively removes the first node)
			this.vertices = node.nextNode;
			//decrements the variable storing the
			//number of nodes/points in the object
			size--;
		}//if the first node does not match the passed string
		else
		{
			while(node.nextNode != null )
			{
				//if the next node matches the passed string
				if( node.nextNode.vertex.getName().equals(vertexName) )
				{
					//sets the next node to the node that comes after the previous next node
					//ex: node -> node2 -> node3
					//node.nextNode = node.nextNode.nextNode
					//		(node2)                  (node3)
					//node2 is effectively removed:
					//ex: node -> node3
					node.nextNode = node.nextNode.nextNode;

					//decrements the variable storing the
					//number of nodes/points in the object
					size--;
					//method is done, stop looping
					break;
				}
				//moves to the next node
				node = node.nextNode;


			}
		}

	}}
//	Node n = vertices;
//	while(n != null) {
//
//		if (n.nextNode.vertex.getName() == vertexName) {
//
//			n.nextNode = n.nextNode.nextNode;
//
//			return;
//		}
//
//		n = n.nextNode;
//	}
//}
	public void insertBefore(Point vertex, String vertexName) {

	    //adds 1 to the size of the polyline (number of points/nodes)
	    size++;
	    //creates a node based on the passed point
	    Node newNode = new Node( new Point(vertex) );
	    //keeps track of whether the point/node has been inserted or not
	    boolean added = false;

	    //if the polyline is empty,
	    //sets the first node to the new node
	    if(this.vertices == null)
	      this.vertices = newNode;
	    //if the first vertex matches the string
	    else if ( this.vertices.vertex.getName().equals(vertexName) )
	    {
	      newNode.nextNode = this.vertices;
	      this.vertices = newNode;
	    }
	    else
	    {//start of else

	      //stores the first node in the sequence
	      Node node = this.vertices;

	      //while the next node exists
	      while(node.nextNode != null)
	      {
	        if( node.nextNode.vertex.getName().equals(vertexName) )
	        {

	          newNode.nextNode = node.nextNode;
	          node.nextNode = newNode;

	          added = true;
	          //stops the loop from continuing after 'vertex' has been added
	          break;
	        }

	        node = node.nextNode;
	      }

	      //if the point wasn't added after the loop, it is added at the end
	      //of the sequence - to stay consistent with VPolyline's implementation
	      if(!added)
	        node.nextNode = newNode;
	    }//end of else
}
	@Override
	public Point[] getVertices() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public String getColour() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public Iterator<Point> iterator() {
		// TODO Auto-generated method stub
		return null;
	}}
