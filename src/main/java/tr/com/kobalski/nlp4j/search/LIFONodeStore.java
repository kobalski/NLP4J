package tr.com.kobalski.nlp4j.search;



import java.util.List;


public class LIFONodeStore implements NodeStore {
	LIFOQueue queue;

	public LIFONodeStore() {
		queue = new LIFOQueue();
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