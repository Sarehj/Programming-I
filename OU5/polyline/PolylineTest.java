package polyline;


public class PolylineTest {
	
	public  static  void  main (String [] args)
	{
		
		// create points
        
		Point a = new Point("a", 1, 2);
        Point b = new Point("b", 3, 4);
        Point c = new Point("c", 5, 6);
        Point d = new Point("d", 7, 8);
        Point e = new Point("e", 9, 2);
        System.out.println(a + "\n" + b + "\n" + c + "\n" + d + "\n" + e);
        System.out.println();
	

	
	  // create an array of points
    
	Point[] points = {a, b, c, d, e};
    
	Polyline Polyline = new Polyline(points);
	
	// test getVertices method
    // for each point get and print the vertices
   
	  for (Point  p : Polyline.getVertices()) {
        System.out.println(p);
	
	  }
	  
	// test getColour method
	  
      System.out.println("Colour: " + Polyline.getColour());
      
      // test getWidth method
      
      System.out.println("Width: " + Polyline.getWidth());

      
      
      // test setColour method
     
      Polyline.setColour("blue");
      System.out.println("Colour: " + Polyline.getColour());

      
     // test setWidth method
      
      Polyline.setWidth (6);
      System.out.println("Width: " + Polyline.getWidth());
      
      
      // test length method
      System.out.println(Polyline.length() + "\n");

     
      
      // test addLast method 
      // make new point
      
      Point Lastpoint = new Point("f", 3, 8);
      
      // add point to polyline array
      
      Polyline.addLast(Lastpoint);
      System.out.println(Polyline + "\n");
      
      
      
     // test addBefore method
     
      Point pBefore = new Point("x", 5, 8);
      
      // specify where to place point within polyline array
     
      Polyline.addBefore(pBefore, "e");
      System.out.println(Polyline + "\n");

      
      //test remove method
      // specify which point to remove
      // call object and method
      Polyline.remove("f");
      
      System.out.println(Polyline + "\n");

      
      // test Polyline-iterator
      // creating iterator inside of testPoly
     
      Polyline.PolylineIterator iter = Polyline.new PolylineIterator();
      // use hasVertex method
    
      while (iter.hasVertex()){
          System.out.println(iter.vertex());
          iter.advance();
      
	  
	  
	
}}}
