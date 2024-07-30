
public class min {

	// The min method returns the least element in a sequential
	// collection . If the collection is empty an
	// IllegalArgumentException is thrown .

	public static int min(int[] elements) throws IllegalArgumentException {
		if (elements.length == 0)
			throw new IllegalArgumentException(" empty collection ");
		// Is used in trace printing 2:
		// int nofIters = 1;

		int[] sequence = elements;
		int nofPairs = sequence.length / 2;
		int nofUnpairedElements = sequence.length % 2;
		int nofPossibleElements = nofPairs + nofUnpairedElements;
		// int [] partialSeq = new int [ nofPossibleElements ];
		int i = 0;
		int j = 0;

		// System . out. println (" .. sequence.length"+ sequence.length);
		int[] partialSeq = new int[nofPossibleElements];

		while (nofPossibleElements > 1) {
			// the line int [] partialSeq = new int [ nofPossibleElements ]; needed to be
			// moved from
			// before the while loop - the partialSeq needs to be recreated with a new
			// length,
			// otherwise the while loop can never end

			System.out.println("Sequence: " + java.util.Arrays.toString(sequence));
			// extract a partial sequence of possible elements
			i = 0;
			j = 0;
			// System . out. println ("sequence.length"+ sequence.length);
			// System . out. println ("nofPairs"+ nofPairs);

			while (j < nofPairs) {

				partialSeq[j++] = (sequence[i] < sequence[i + 1]) ? sequence[i] : sequence[i + 1];
				i += 2;

			}

			if (nofUnpairedElements == 1) {

				partialSeq[j] = sequence[nofPairs * 2];
			}

			// now turn to the partial sequence
			sequence = partialSeq;

			// System . out. println (" partial sequence.length"+ java . util . Arrays .
			// toString ( partialSeq ));
			// System . out. println (" sequence.length"+ sequence.length);

			nofPairs = nofPossibleElements / 2;
			nofUnpairedElements = nofPossibleElements % 2;
			nofPossibleElements = nofPairs + nofUnpairedElements;
			// Trace printing 1 - to follow the sequence
			System.out.println("sequence" + java.util.Arrays.toString(sequence));

			// Trace printing 2 - to terminate the loop preemptively
			// (to be able to see what happens initially )
			// if ( nofIters ++ == 10)
			// System . exit (0);
		}

		// sequence [0] is the only remaining possible element
		// - it is the least element
		if (sequence[1] < sequence[0])
			sequence[0] = sequence[1];
		return sequence[0];
	}

	public static void main(String[] args) {
		System.out.println("Least integer");

		int[] y = { 4, 1, 5, 6, 2, 10, 7, 8, 9, 11, 0, 12, 13, 14, 15, 16 };
		int[] z = { 4, 5, 6, 7, 9, 1, 2, 3, 4, 5, 11, 12, 14, 16, 15, 16, 0, 1, 2 };
		int[] zz = { 4, 1, 5, 6, 0 };
		int x = min(z);
		System.out.println("Least integer: " + x);
	}

}