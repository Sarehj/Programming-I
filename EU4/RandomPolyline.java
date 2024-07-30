
import java.util.Random;

public class RandomPolyline {

	public static final Random rand = new Random();
	public static final int NOF_POLYLINES = 10;

	public static Point randomPoint() {
		String n = "" + (char) (65 + rand.nextInt(26));
		int x = rand.nextInt(11);
		int y = rand.nextInt(11);

		return new Point(n, x, y);

	}

	public static Polyline randomVPolyline() {

		Polyline polyline = new VPolyline();
		int nofVertices = 2 + rand.nextInt(7);

		int nofSelectedVertices = 0;
		boolean[] selectedNames = new boolean[26];

		// Two vertices can not have the same name
		Point chosenPoint = null;
		char chosenChar = 0;
		while (nofSelectedVertices < nofVertices) {
			chosenPoint = randomPoint();

			int choosenValue = chosenPoint.name.charAt(0) - 65;

			if (!selectedNames[choosenValue]) {
				selectedNames[choosenValue] = true;

				// add chosenPoint to end of polyline
				polyline.add(chosenPoint);
				nofSelectedVertices++;
			}

		}

		// Assign a colour

		polyline.setColour(randomColour());
		return polyline;

	}

	public static String randomColour() {

		int randCol = rand.nextInt(3);

		String randColour = "";

		if (randCol == 0) {
			randColour = "yellow";
		}

		if (randCol == 1) {
			randColour = "red";
		}

		if (randCol == 2) {
			randColour = "blue";
		}
		return randColour;
	}

	public static Polyline randomNPolyline() {

		Polyline polyline = new NPolyline();
		int nofVertices = 2 + rand.nextInt(7);

		int nofSelectedVertices = 0;
		boolean[] selectedNames = new boolean[26];

		// Two vertices can not have the same name
		Point chosenPoint = null;
		char chosenChar = 0;
		while (nofSelectedVertices < nofVertices) {
			chosenPoint = randomPoint();

			int choosenValue = chosenPoint.name.charAt(0) - 65;

			if (!selectedNames[choosenValue]) {
				selectedNames[choosenValue] = true;

				// add chosenPoint to end of polyline
				polyline.add(chosenPoint);
				nofSelectedVertices++;
			}

		}

		// Assign a colour

		polyline.setColour(randomColour());
		return polyline;

	}

	public static String randomColour1() {

		int randCol = rand.nextInt(3);

		String randColour = "";

		if (randCol == 0) {
			randColour = "yellow";
		}

		if (randCol == 1) {
			randColour = "red";
		}

		if (randCol == 2) {
			randColour = "blue";
		}
		return randColour;
	}

}
