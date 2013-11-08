package tr.com.kobalski.nlp4j.search;


import java.util.List;



public interface Queue {
	void add(Object anItem);

	void add(List items);

	Object remove();

	Object get();
}