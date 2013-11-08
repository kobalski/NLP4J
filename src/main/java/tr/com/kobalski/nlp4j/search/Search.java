package tr.com.kobalski.nlp4j.search;


import java.util.List;


public interface Search {
	List search(Problem p) throws Exception;

	Metrics getMetrics();
}