package tr.com.kobalski.nlp4j.search;


import java.util.List;


public class FIFONodeStore implements NodeStore {

	FIFOQueue queue;

	public FIFONodeStore() {
		queue = new FIFOQueue();
	}

	public void add(Node anItem) {
		queue.add(anItem);

	}

	public Node remove() {
		return (Node) queue.remove();
	}

	public void add(List nodes) {
		queue.add(nodes);

	}

	public boolean isEmpty() {
		return queue.isEmpty();
	}

	public int size() {
		return queue.size();

	}

}