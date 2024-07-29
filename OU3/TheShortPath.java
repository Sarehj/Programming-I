package ou3;

class TheShortestPath
{
	
		static int m;
		static int n;
		static double [] a = new double [m + 1];
		double [][] b = new double [m + 1][n + 1];
		double [] c = new double [n + 1];
		
		
	// The method length returns the length of the shortest path .
		public static double length( double [] a, double [][] b, double [] c)
		{
			/* Since there is only one starting (X), and ending (Y) station, only the Ui and Vj
			 * stations are the ones that we can select from the shortest path will be of a form:
			 * minimum of all sums such as: a[i] + b[i][j] + c[j]
			 * the following loop finds the minimum and returns its value
			 * */
			
			// Initialise the shortest path
			double shortestLength = a[0] + b[0][0] + c[0];
			for (int i = 0; i <m; i++)
			{
				for (int j = 0; j<n; j ++)
				{
					
					if ( a[i] + b[i][j] + c[j] < shortestLength )
					{
						
						shortestLength = a[i] + b[i][j] + c[j];

					}
				}
			}
			return shortestLength;
		}
		
		// The method intermediateStations returns a vector of the
		// intermediate stations that are on the shortest path .
		// The ordinal number of the first station is located in
		// index 0 of the vector , and the second station on index 1.
		
		public static int [] intermediateStations( double [] a, double [][] b, double [] c)
		{
			/* We follow the previous method, this time we store the index value of the stations
			 * that lie on the current shortest path in the intermediate [] variable
			 * the index of the station Uj is stored at intermediate [0]
			 * the index of the station Ui is stored at intermediate [1]
			 * the method returns intermediate's last value
			 * 
			 * It's a bit of a waste, would be nice to have tuples, so we could combine both
			 * methods into one, returning (double length, int [j], int [j])
			 * */
			
			double shortestLength = a[0] + b[0][0] + c[0];
			
			int [] intermediate = new int [2];
			intermediate [0] = 1;
			intermediate [1] = 1;
			for (int i = 1; i <m; i++)
			{
				for (int j = 1; j<n; j ++)
				{
					if ( a[i] + b[i][j] + c[j] < shortestLength )
					{
						shortestLength = a[i] + b[i][j] + c[j];
						intermediate [0] = i + 1;
						intermediate [1] = j + 1;
					}
				}
			}
			return intermediate;
		}
	
}

