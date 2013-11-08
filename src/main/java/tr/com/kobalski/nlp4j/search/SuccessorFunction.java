package tr.com.kobalski.nlp4j.search;

import java.util.List;


public interface SuccessorFunction {

	List getSuccessors(Object state);

}