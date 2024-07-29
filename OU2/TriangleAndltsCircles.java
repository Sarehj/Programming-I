import java.util.*;
public class TriangleAndltsCircles {

	public static void main (String[] args) 
	{
		Scanner in = new Scanner (System.in);
		in.useLocale (Locale.US);
		System.out.println("Enter triangles three sides:");
		
		double x = in.nextDouble ();
		double y = in.nextDouble ();	
		double z = in.nextDouble (); 
		Triangle a = new Triangle();
		
		double rc = a.radiusOfCircumcircle(x, y, z);
		double ri = Triangle.radiusOfIncircle(x, y, z);
		
		System.out.println("The radius of the circumcircle "+ rc);
		System.out.println("The radius of the incircle "+ ri);
		
	}
	}