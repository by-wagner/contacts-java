import java.io.*;

/**
 * Represents an inclusive integer range.
 */
class Range implements Serializable {

	@Serial
	private static final long serialVersionUID = 1L;

	/** @serial */
	private final int from;
	/** @serial */
	private final int to;

	/**
	 * Creates Range.
	 *
	 * @param from start
	 * @param to end
	 * @throws IllegalArgumentException if start is greater than end.
	 */
	public Range(int from, int to) {
		if (from > to) {
			throw new IllegalArgumentException("Start is greater than end");
		}
		this.from = from;
		this.to = to;
	}

	public int getFrom() {
		return from;
	}

	public int getTo() {
		return to;
	}

	@Serial
	private void writeObject(ObjectOutputStream out) throws IOException {
		out.defaultWriteObject();
	}

	@Serial
	private void readObject(ObjectInputStream in) throws IOException, ClassNotFoundException {
		in.defaultReadObject();
		// Validate the invariant
		if (from > to) {
			throw new IllegalArgumentException("Start is greater than end");
		}
	}
}