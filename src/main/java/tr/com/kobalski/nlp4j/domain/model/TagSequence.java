package tr.com.kobalski.nlp4j.domain.model;

import java.util.ArrayList;
import java.util.List;

public class TagSequence extends BaseNLPEntity{
	
	private String 				sequenceName;
	private List<String>		listOfTags;
	
	public String getSequenceName() {
		return sequenceName;
	}
	public void setSequenceName(String sequenceName) {
		this.sequenceName = sequenceName;
	}
	public List<String> getListOfTags() {
		if(listOfTags == null){
			listOfTags = new ArrayList<String>();
		}
		return listOfTags;
	}
	public void setListOfTags(List<String> listOfTags) {
		this.listOfTags = listOfTags;
	}
	
	
	
	
}
