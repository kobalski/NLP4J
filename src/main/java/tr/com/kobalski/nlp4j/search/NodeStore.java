package tr.com.kobalski.nlp4j.search;

import java.util.List;



public interface NodeStore {
	public void add(Node anItem);

	public Node remove();

	public void add(List<Node> nodes);

	public boolean isEmpty();

	public int size();
}