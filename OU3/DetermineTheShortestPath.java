package ou3;

import java.util.Locale;
import java.util.Scanner;

public class DetermineTheShortestPath {
	public static void main(String[] args) {

		TheShortestPath path1 = new TheShortestPath();
		Scanner in = new Scanner ( System.in );
		in.useLocale ( Locale.US );

		System.out.println ("How many stations in Zone 2 (m), and Zone 3 (n) \n");
		//assign values to "number of stations" in TheShortestPath
		TheShortestPath.m = in.nextInt();
		TheShortestPath.n = in.nextInt();

		double [] a = new double [TheShortestPath.m + 1];
		double [][] b = new double [TheShortestPath.m + 1][TheShortestPath.n + 1];
		double [] c = new double [TheShortestPath.n + 1];
		//distances between station X and Uj
		System.out.println ("Distances from the station X to Ui ("+ TheShortestPath.m +"):");

		for (int i = 0; i < TheShortestPath.m ; i ++) {

			a[ i ] = in.nextDouble ();
		}
		System.out.println ();

		//distances between stations Uj and Vi
		for (int j = 0; j <  TheShortestPath.m ; j ++) {
			System.out.println ("Distances from the station U" + (j+1) + " ("+ TheShortestPath.n +"):");
			for (int i = 0; i < TheShortestPath.n ; i ++)
				b[ j ][ i ] = in.nextDouble ();
		}
		System.out.println ();

		//distances between station Vi and Y
		System.out.println ("Distances from the stations Vj to Y  (" + TheShortestPath.m + "):");
		for (int j = 0; j < TheShortestPath.n ; j ++) {
			c[ j ] = in.nextDouble ();

		}
		int [] route = TheShortestPath.intermediateStations(a, b, c);
		System.out.println ("The shortest length is: " + TheShortestPath.length(a, b, c));
		System.out.println ("The shortest route is: X, U" + route[0] + ", V" + route[0] + ", Y");

	}

}
