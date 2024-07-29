import java.util.*;
public class Temperature1 {

	public static void main(String[] args) {
		System.out.println ("TEMPERATURES\n");
		Scanner in = new Scanner (System.in);
		in.useLocale (Locale.US);


		System.out.print ("number of weeks: ");
		int nofWeeks = in.nextInt ();

		System.out.print ("number of measurements per week: ");
		int nofMeasurementsPerWeek = in.nextInt ();


		double[][] t = new double[nofWeeks + 1][nofMeasurementsPerWeek + 1];


		for (int week = 1; week <= nofWeeks; week++) {
			System.out.println ("temperatures - week " + week + ":");
			for (int reading = 1; reading <= nofMeasurementsPerWeek; reading++)
			t[week][reading] = in.nextDouble ();
		}

		System.out.println ();
		System.out.println ("the temperatures:");

		for (int week = 1; week <= nofWeeks; week++) {
			for (int reading = 1; reading <= nofMeasurementsPerWeek; reading++)
				System.out.print (t[week][reading] + " ");
				System.out.println();
		}

		System.out.println ();


		double[] minT= new double[nofWeeks + 1];
		double[] maxT= new double[nofWeeks + 1];
		double[] sumT= new double[nofWeeks + 1];


	     for (int i = 1; i <= nofWeeks ; i++) {
	           minT[i] = t[i][1];
	           maxT[i] = t[i][1];
	           sumT[i] = t[i][1];
	           for( int z=2; z <= nofMeasurementsPerWeek; z++) {
	        	 if(  t[i][z] < minT[i])
	        		 minT[i]= t[i][z];
	           if(  t[i][z] > maxT[i])
	        		 maxT[i] = t[i][z];
	           sumT[i]+=t[i][z];

	          }

	           System.out.print("week" + i +" " + "Minimum is " + minT[i]);
	           System.out.println();
	           System.out.print("week" + i +" "+ "maximum is " + maxT[i]);
	           System.out.println();
	           System.out.print("week" + i +" "+ "sum is " + sumT[i]);
	           System.out.println();
	           System.out.print("week" + i +" "+ "average  is " + sumT[i]/ nofMeasurementsPerWeek);
	           System.out.println();

	     }

	    // the least , greatest  and  average  temperature  - whole  period
	     double minTemp= minT[1];
	     double maxTemp = maxT[1];
	     double sumTemp= sumT[1];


	     for (int i = 2 ; i <= nofWeeks ; i++) {
	    	 if (minTemp > minT[i])
	    		 minTemp= minT[i];
	    	 if (maxTemp < maxT[i])
	    		maxTemp= maxT[i];
	    	 sumTemp +=sumT[i];
	     }

	 System.out.print("Minimum is " + minTemp);
         System.out.println();
         System.out.print("maximum is " + maxTemp);
         System.out.println();
         System.out.print("sum is " + sumTemp);
         System.out.println();
         System.out.print("average  is " + sumTemp/(nofWeeks*nofMeasurementsPerWeek));
         System.out.println();


	  }

	}
 
