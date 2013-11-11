package tr.com.kobalski.nlp4j.domain.model;

import java.util.HashMap;
import java.util.Map;

public class TagSequence extends BaseNLPEntity{
	
	private String 					sequenceName;
	private Map<String,Tag>		listOfTags;
	
	public String getSequenceName() {
		return sequenceName;
	}
	public void setSequenceName(String sequenceName) {
		this.sequenceName = sequenceName;
	}
	public Map<String,Tag> getListOfTags() {
		if(listOfTags == null){
			listOfTags = new HashMap<String,Tag>();
		}
		return listOfTags;
	}
	public void setListOfTags( Map<String,Tag> listOfTags) {
		this.listOfTags = listOfTags;
	}
	
	
	
	
}
