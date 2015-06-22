package relop;

/**
 * The projection operator extracts columns from a relation; unlike in
 * relational algebra, this operator does NOT eliminate duplicate tuples.
 */
public class Projection extends Iterator {
	private Iterator iter;
	private Integer[] fields;

	/**
	 * Constructs a projection, given the underlying iterator and field numbers.
	 */
	public Projection(Iterator iter, Integer... fields) {
		this.iter = iter;
		this.fields = fields;

		// new schema for projection
		Schema new_schema = new Schema(fields.length);
		for (int i = 0; i < fields.length; i++) {
			// new_schema.initField(i, iter.getSchema(), fields[i]);
			System.out.println("Field Type of i = " + i + " is "
					+ iter.getSchema().fieldType(fields[i]));
			new_schema.initField(i, iter.getSchema().fieldType(fields[i]), iter
					.getSchema().fieldLength(fields[i]), iter.getSchema()
					.fieldName(fields[i]));
		}
		setSchema(new_schema);

		// throw new UnsupportedOperationException("Not implemented");
	}

	/**
	 * Gives a one-line explanation of the iterator, repeats the call on any
	 * child iterators, and increases the indent depth along the way.
	 */
	public void explain(int depth) {
		// TODO: Done
		this.indent(depth++);
		System.out.println("Projection depth: " + depth);
		// throw new UnsupportedOperationException("Not implemented");
	}

	/**
	 * Restarts the iterator, i.e. as if it were just constructed.
	 */
	public void restart() {
		// TODO: Done
		this.iter.restart();
		// throw new UnsupportedOperationException("Not implemented");
	}

	/**
	 * Returns true if the iterator is open; false otherwise.
	 */
	public boolean isOpen() {
		// TODO: Done
		if (this.iter.isOpen())
			return true;
		return false;

		// throw new UnsupportedOperationException("Not implemented");
	}

	/**
	 * Closes the iterator, releasing any resources (i.e. pinned pages).
	 */
	public void close() {
		// TODO: Done
		this.iter.close();
		// throw new UnsupportedOperationException("Not implemented");
	}

	/**
	 * Returns true if there are more tuples, false otherwise.
	 */
	public boolean hasNext() {
		// TODO: projection has next
		if (this.iter.hasNext())
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
		// TODO: projection get next tuple
		Tuple parent = iter.getNext();
		Tuple t = new Tuple(this.getSchema());
		for (int i = 0; i < fields.length; i++) {
			t.setField(i, parent.getField(fields[i]));
		}
		return t;

		// throw new IllegalStateException("No more tuple!");

		// throw new UnsupportedOperationException("Not implemented");
	}

} // public class Projection extends Iterator
