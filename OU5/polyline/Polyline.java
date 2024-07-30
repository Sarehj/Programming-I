package polyline;


public class Polyline {
 private Point []     vertices;
 private  String      colour = "black";
 private  int          width = 1;

 public  Polyline  (){
	 this.vertices = new  Point [0];
	 }
 
 
 public  Polyline (Point []  vertices)
 {
	 this.vertices = new  Point[vertices.length ];
	 for (int i = 0; i < vertices.length; i++)
		 this.vertices[i] = new  Point (vertices[i]);
	 }

 public  String  toString  () {
	 
	 String info = "";
     for (Point p : vertices){
            info = info + p + " ";
     }
     return "Info: " + info + "Colour: " + colour + " Width: " + width;
 }
 
 public  Point []  getVertices  () {
	 
	 return this.vertices;
 }
 
 public  String  getColour  () {
	 return colour;
 }
 
 public  int  getWidth  () {
	 
	 return width;
 }
 
 public  void  setColour (String  colour) {
	
 this.colour= colour;
 }
 public  void  setWidth (int  width) {
	 
	 this.width =width;
 }
 
 public  double  length  () {
	 
	 double length = 0;
     for (int i = 0; i < this.vertices.length - 1; i++)
        
    	 length += this.vertices[i].distance(this.vertices[i + 1]);
     
     return length;
 }
 
 
 public  void  addLast (Point  vertex)
 {
	 Point[]     h = new  Point[this.vertices.length + 1];
	 int     i = 0;
	 for (i = 0; i < this.vertices.length; i++)
		 h[i] = this.vertices[i];
	 
	 h[i] = new  Point (vertex );
	 this.vertices = h;
	 }

  
 
 public  void  addBefore (Point  vertex , String  vertexName) 
   {
	   
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
 
 
  
   
   public  void  remove (String  vertexName) {
	   
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
   
	



   public class PolylineIterator {

    private int current = -1;
    
   public PolylineIterator(){
    if (Polyline.this.vertices.length > 0)
        current = 0;
}

    public boolean hasVertex (){
    return current != -1;
}

    public Point vertex () throws java.util.NoSuchElementException{
    if (!this.hasVertex())
        throw new java.util.NoSuchElementException("end of iteration");

    Point vertex = Polyline.this.vertices[current];

    return vertex;
}

  public void advance () {
    if (current >= 0 && current < Polyline.this.vertices.length - 1)
        current++;
    else
        current = -1;
}
}}

