package relop;

import global.SearchKey;
import heap.HeapFile;
import index.HashIndex;
import index.HashScan;

/**
 * Wrapper for hash scan, an index access method.
 */
public class KeyScan extends Iterator {

	// TODO:Done

	private HashIndex index;
	private SearchKey key;
	private HeapFile file;

	private HashScan hashscan; // Wrapper for hash scan

	/**
	 * Constructs an index scan, given the hash index and schema.
	 */
	public KeyScan(Schema schema, HashIndex index, SearchKey key, HeapFile file) {
		// Schema from Iterator class, for resulting tuples; must be set in all
		// subclass constructors
		this.setSchema(schema);
		this.index = index;
		this.key = key;
		this.file = file;

		this.hashscan = index.openScan(key); // index file with key

		// throw new UnsupportedOperationException("Not implemented");
	}

	/**
	 * Gives a one-line explaination of the iterator, repeats the call on any
	 * child iterators, and increases the indent depth along the way.
	 */
	public void explain(int depth) {
		// TODO: explain(depth)

		throw new UnsupportedOperationException("Not implemented");
	}

	/**
	 * Restarts the iterator, i.e. as if it were just constructed. close it then
	 * open again
	 */
	public void restart() {
		// TODO: Done
		if (isOpen()) {
			hashscan.close();
		}
		hashscan = index.openScan(key);

		// throw new UnsupportedOperationException("Not implemented");
	}

	/**
	 * Returns true if the iterator is open; false otherwise. open if not null
	 */
	public boolean isOpen() {
		// TODO: Done
		if (hashscan != null) {
			return true;
		}
		return false;

		// throw new UnsupportedOperationException("Not implemented");
	}

	/**
	 * Closes the iterator, releasing any resources (i.e. pinned pages).
	 */
	public void close() {
		// TODO: close
		if (isOpen()) {
			hashscan.close();
		}
		hashscan = null;
		// throw new UnsupportedOperationException("Not implemented");
	}

	/**
	 * Returns true if there are more tuples, false otherwise.
	 */
	public boolean hasNext() {
		// TODO: Done
		if (hashscan.hasNext()) {
			return true;
		} else {
			return false;
		}
		// throw new UnsupportedOperationException("Not implemented");
	}

	/**
	 * Gets the next tuple in the iteration.
	 * 
	 * @throws IllegalStateException
	 *             if no more tuples
	 */
	public Tuple getNext() {
		// TODO: get next tuple
		Tuple t = new Tuple(this.getSchema());
		return t;

		// throw new UnsupportedOperationException("Not implemented");
	}

} // public class KeyScan extends Iterator
