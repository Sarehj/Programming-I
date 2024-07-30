
public class Minn {
	public static int min(int[] elements) throws IllegalArgumentException {

		if (elements.length == 0)
			throw new IllegalArgumentException("empty  collection");
		// Is used in trace printing 2:
		// int nofIters = 1;
		int[] sequence = elements;
		int nofPairs = sequence.length / 2;
		int nofUnpairedElements = sequence.length % 2;
		int nofPossibleElements = nofPairs + nofUnpairedElements;
		int[] partialSeq = new int[nofPossibleElements];
		int i;
		int j;
		// new code - loop for pairs rather than
		while (nofPossibleElements > 1) {

			// extract a partial sequence of possible elements
			i = 0;
			j = 0;
			// picking the smallest number fo all the pairs
			//
			while (j < nofPairs) {

				partialSeq[j++] = (sequence[i] < sequence[i + 1]) ? sequence[i] : sequence[i + 1];
				i += 2;
			}
			if (nofUnpairedElements == 1)
				partialSeq[j] = sequence[sequence.length - 1];

			// now turn to the partial sequence
			sequence = partialSeq;
			nofPairs = nofPossibleElements / 2;
			nofUnpairedElements = nofPossibleElements % 2;
			nofPossibleElements = nofPairs + nofUnpairedElements;

			// Trace printing 1 - to follow the sequence
			// System.out.println (java.util.Arrays.toString (sequence ));
			// Trace printing 2 - to terminate the loop preemptively
			// (to be able to see what happens initially)
			// if (nofIters ++ == 10)// System.exit (0);
		}

		// sequence [0] is the only remaining possible element
		// - it is the least element
		return sequence[0];
	}

	public static int min2(int[] elements) throws IllegalArgumentException {
		if (elements.length == 0)
			throw new IllegalArgumentException("empty collection");

		// update strategy
		int min = elements[0];
		for (int i = 0; i < elements.length; i++) {
			if (elements[i] < min) {
				min = elements[i];
			}
		}
		return min;
	}
}
