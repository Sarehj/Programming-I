package polyline;

import java.awt.Point;

public class Polyline1 {
	

	 private Point []     vertices;
	 private  String      colour = "black";
	 private  int          width = 1;

	 public  Polyline1  (){
		 this.vertices = new  Point [0];
		 }
	 public  Polyline1 (Point []  vertices)
	 {
		 this.vertices = new  Point[vertices.length ];
		 for (int i = 0; i < vertices.length; i++)
			 this.vertices[i] = new  Point (vertices[i]);
		 }
	 public  String  toString  () {
		 
		 String info = "";
	     for (Point pt : vertices){
	            info = info + pt + " ";
	     }
	     return "Info: " + info + "Colour: " + colour + " Width: " + width;
	 }
	 
	 public  Point []  getVertices  () {
		 
		 Point []  Vertices= new Point[vertices.length];
	        
		 for (int i = 0; i < this.vertices.length; i++){
	           
	        	Vertices[i] = new Point(vertices[i]);
	        }
		 
		 return Vertices;
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

	   public  void  addBefore (Point  vertex , String  vertexName) {}
	 
	 
	   public  void  remove (String  vertexName) {}
		}

