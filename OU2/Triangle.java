
public class Triangle {
	
		public  double  radiusOfCircumcircle(double b, double c, double a) 
		{
			double u = (a + b + c) * (b + c - a) * (c + a - b) * (a + b - c);
			double rc = (b * c * a) / Math.sqrt(u);
			return rc;
		}
		public static double  radiusOfIncircle(double b, double c, double a) 
		{
			double s = (a + b + c) / 2;
			double f = s * (s - a) * (s - b) * (s - c);
			return Math.sqrt(f) / s;
		}
		public static double alpha(double b, double c, double a)
		{
			double t =((b * b) + (c * c) - (a * a)) / (2 * b * c);
			double alpha = Math.acos(t) * 180/Math.PI;
			return alpha;
		}
		public static double bisector(double b, double c, double alpha)
		{ 
			double p = 2 * b * c * Math.cos (alpha / 2); 
			double bis = p / (b + c);
			return bis;
		}
		public static double area(double b, double c, double alpha)
		{
			double q = b * c * Math.sin(alpha);
			double area = q / 2;
			return area;
		}
		
		public static double cicumference(double b, double c, double a)
		{
			double cir = a + b + c;
			return cir;
		}
		public static double median(double b, double c, double a)
		{
			double e = (2 * b * b)+(2 * c * c)-(a * a);
			double md = Math.sqrt(e) / 2;
			return md;
	}
		
			public static double getA(double b, double c, double alpha)
			{
				double r = ((b * b) + (c * c) - (2 * b * c * Math.cos(alpha)));
				double a = Math.sqrt(r);
				return a;
			}
}
		
	




