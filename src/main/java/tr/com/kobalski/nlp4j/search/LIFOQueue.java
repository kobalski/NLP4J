package tr.com.kobalski.nlp4j.search;

import java.util.ArrayList;
import java.util.List;


public class LIFOQueue extends AbstractQueue {

	@Override
	public void add(Object anItem) {
		super.addToFront(anItem);
	}

	@Override
	public void add(List items) {
		List<Object> reversed = new ArrayList<Object>();
		for (int i = items.size() - 1; i > -1; i--) {
			reversed.add(items.get(i));
		}
		super.addToFront(reversed);
	}

	@Override
	public Object remove() {
		return super.removeFirst();
	}

	@Override
	public Object get() {
		return super.getFirst();
	}
}