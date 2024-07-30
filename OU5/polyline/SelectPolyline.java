package polyline;

import java.util.Random;

public class SelectPolyline {

	
		
		public static final  Random     rand = new  Random  ();
	public  static  final  int         NOF_POLYLINES = 10;
	
	
	public  static  void main (String [] args){
		
		
		//  Create a random  number  of  polylines
		
		Polyline []     polylines = new  Polyline[NOF_POLYLINES ];
		
		for (int i = 0; i < NOF_POLYLINES; i++)
			polylines[i] = randomPolyline  ();
		
		
		// Show  the  polylines
		
		 for (Polyline pt : polylines){
	            System.out.println(pt);
	        }
		
		//  Determine  the  shortest  yellow  polyline
		 
	        double shortest = Double.MAX_VALUE;
	        
	        Polyline sYEllow = new Polyline();
	        
	        for (Polyline pt : polylines) {
	           
	        	if (pt.getColour() == "yellow" && (pt.length() < shortest)){
	                
	            	sYEllow = pt;
	                shortest = pt.length();
	            }
	        }
		 
		 
		 // Show the selected polyline
		    System.out.println("The shortest polyline: " + sYEllow);

		    }
		
		
	    // The  randomPoint  method  returns a new  Point  with a name
		//  randomly  chosen  from  the  single  letters A--Z. Coordinates
		// are  random
		
	    public  static  Point  randomPoint  (){
			String     n = "" + (char) (65 + rand.nextInt  (26));
			int     x = rand.nextInt  (11);
			int     y = rand.nextInt  (11);
			
			return  new  Point (n, x, y);
			
	    }
		
	    // The  method  randomPolyline  returns a random  polyline ,
		// with a colour  either  blue , red , or  yellow. The  names
		// of the  vertices  are  single  letters  from  the  set A--Z.
		// Two  vertices  can  not  have  the  same  name.
		
	    public  static  Polyline  randomPolyline  ()
	    {
			
	    	//  Create  an empty  polyline  and  add  vertices
			
	    	Polyline     polyline = new  Polyline  ();
		    int     nofVertices = 2 + rand.nextInt  (7);
		    
		    int     nofSelectedVertices = 0;
		    boolean []     selectedNames = new  boolean [26];
		   
		    
		    // Two  vertices  can  not  have  the  same  name
		    Point     chosenPoint = null;
		    char      chosenChar = 0;
		    while (nofSelectedVertices  < nofVertices)
		    {
		    	 chosenPoint = randomPoint();
		            
		    	 // check whether or not the name of the point
		            // has been used or not
		            
		    	 int choosenValue = chosenPoint.name.charAt(0) - 65;
		           
		    	 // if the index of the letter of the boolean array
		            
		    	 if (!selectedNames[choosenValue]){
		                selectedNames[choosenValue] = true;
		               
		                // add chosenPoint to end of polyline
		                polyline.addLast(chosenPoint);
		                nofSelectedVertices++;
		            }
		    	
		    }
		   
		    //  Assign a colour
		   
		    polyline.setColour(randomColour());
	        return polyline;

		    }
	   
	    public static String randomColour(){
	        
	    	int randCol = rand.nextInt(3);
	       
	    	String randColour = "";
	       
	    	if (randCol == 0){
	            randColour = "yellow";
	        }
	       
	    	if (randCol == 1){
	            randColour = "red";
	        }
	       
	    	if (randCol == 2){
	            randColour = "blue";
	        }
	        return randColour;
	    }
	}


