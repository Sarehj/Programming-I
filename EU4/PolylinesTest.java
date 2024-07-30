
public class PolylinesTest {

	public static void main(String[] args) {

		Polyline polyline = null;

		polyline = new NPolyline();

		polyline.add(new Point("A", 2, 4));
		polyline.add(new Point("B", 6, 1));
		polyline.add(new Point("C", 8, 12));
		polyline.add(new Point("Z", 4, 2));
		polyline.add(new Point("E", 1, 3));

		System.out.println(polyline);

		polyline.remove("Z");
		System.out.println(polyline);

		polyline.insertBefore(new Point("D", 5, 4), "C");
		System.out.println(polyline);

	}

}
