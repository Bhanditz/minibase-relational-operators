package relop;

/**
 * The selection operator specifies which tuples to retain under a condition; in
 * Minibase, this condition is simply a set of independent predicates logically
 * connected by AND operators.
 */
public class Selection extends Iterator {
	// TODO:Done
	private Iterator iter;
	private Predicate[] preds;
	private Tuple t;
	private boolean found;

	/**
	 * Constructs a selection, given the underlying iterator and predicates.
	 */
	public Selection(Iterator iter, Predicate... preds) {
		// TODO: Done
		this.iter = iter;
		this.preds = preds;
		// Type mismatch: cannot convert from Predicate[] to Predicate

		this.setSchema(this.iter.getSchema());
		// throw new UnsupportedOperationException("Not implemented");
	}

	/**
	 * Gives a one-line explanation of the iterator, repeats the call on any
	 * child iterators, and increases the indent depth along the way.
	 */
	public void explain(int depth) {
		// TODO: check depth
		this.indent(depth++);
		System.out.println("Selection Depth: " + depth);
		// throw new UnsupportedOperationException("Not implemented");
	}

	/**
	 * Restarts the iterator, i.e. as if it were just constructed.
	 */
	public void restart() {
		// TODO: Done
		iter.restart();
		// throw new UnsupportedOperationException("Not implemented");
	}

	/**
	 * Returns true if the iterator is open; false otherwise.
	 */
	public boolean isOpen() {
		// TODO: Done
		if (iter.isOpen()) {
			return true;
		}
		return false;

		// throw new UnsupportedOperationException("Not implemented");
	}

	/**
	 * Closes the iterator, releasing any resources (i.e. pinned pages).
	 */
	public void close() {
		// TODO: Done
		iter.close();
		// throw new UnsupportedOperationException("Not implemented");
	}

	/**
	 * Returns true if there are more tuples, false otherwise.
	 */
	public boolean hasNext() {
		// TODO:
		this.t = null;
		while (iter.hasNext()) {
			t = iter.getNext();
			found = true;
			for (int i = 0; i < preds.length; i++) {
				if (!preds[i].evaluate(t)) {
					found = false;
					break;
				}
			}
			if (found) {
				break;
			}
			this.t = null;
		}
		if (t != null)
			return true;

		return false;
		// throw new UnsupportedOperationException("Not implemented");
	}

	/**
	 * Gets the next tuple in the iteration.
	 * 
	 * @throws IllegalStateException
	 *             if no more tuples
	 */
	public Tuple getNext() {
		Tuple next_tuple = this.t;
		if (t != null) {
			this.t = null;
		}
		return next_tuple;

		// throw new IllegalStateException("No More Tuples!");
		// throw new UnsupportedOperationException("Not implemented");
	}

} // public class Selection extends Iterator
