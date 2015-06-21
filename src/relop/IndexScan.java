package relop;

import global.SearchKey;
import heap.HeapFile;
import index.BucketScan;
import index.HashIndex;

/**
 * Wrapper for bucket scan, an index access method.
 */
public class IndexScan extends Iterator {

	// TODO:
	private HashIndex index;
	private HeapFile file;

	private BucketScan bucketScan; // Wrapper for bucket scan

	/**
	 * Constructs an index scan, given the hash index and schema.
	 */
	public IndexScan(Schema schema, HashIndex index, HeapFile file) {
		// TODO: Done
		this.setSchema(schema);
		this.index = index;
		this.file = file;

		this.bucketScan = index.openScan();

		// throw new UnsupportedOperationException("Not implemented");
	}

	/**
	 * Gives a one-line explaination of the iterator, repeats the call on any
	 * child iterators, and increases the indent depth along the way.
	 */
	public void explain(int depth) {
		// TODO: check indent
		this.indent(depth++);
		System.out.println("IndexScan depth => " + depth);
		// throw new UnsupportedOperationException("Not implemented");
	}

	/**
	 * Restarts the iterator, i.e. as if it were just constructed.
	 */
	public void restart() {
		// TODO: Done
		if (this.isOpen()) {
			this.close();
		}
		bucketScan = index.openScan();

		// throw new UnsupportedOperationException("Not implemented");
	}

	/**
	 * Returns true if the iterator is open; false otherwise.
	 */
	public boolean isOpen() {
		// TODO: Done
		if (bucketScan != null) {
			return true;
		} else {
			return false;
		}
		// throw new UnsupportedOperationException("Not implemented");
	}

	/**
	 * Closes the iterator, releasing any resources (i.e. pinned pages).
	 */
	public void close() {
		// TODO: Done
		if (this.isOpen()) {
			bucketScan.close();
		}
		bucketScan = null;
		// throw new UnsupportedOperationException("Not implemented");
	}

	/**
	 * Returns true if there are more tuples, false otherwise.
	 */
	public boolean hasNext() {
		// TODO: Done
		if (this.isOpen()) {
			return bucketScan.hasNext();
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
		if (this.hasNext()) {
			Tuple t = new Tuple(this.getSchema());
			return t;
		} else {
			throw new IllegalStateException("IndexScan - tuples underflow");
		}
		// throw new UnsupportedOperationException("Not implemented");
	}

	/**
	 * Gets the key of the last tuple returned.
	 */
	public SearchKey getLastKey() {
		// TODO: Done
		return bucketScan.getLastKey();

		// throw new UnsupportedOperationException("Not implemented");
	}

	/**
	 * Returns the hash value for the bucket containing the next tuple, or
	 * maximum number of buckets if none.
	 */
	public int getNextHash() {
		// TODO: Done
		return bucketScan.getNextHash();
		// throw new UnsupportedOperationException("Not implemented");
	}

} // public class IndexScan extends Iterator
