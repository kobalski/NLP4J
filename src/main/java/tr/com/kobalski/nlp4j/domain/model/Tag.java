package tr.com.kobalski.nlp4j.domain.model;

public class Tag extends BaseNLPEntity {
	
	public String tagName;
	public String tagDescription;
	
	public String getTagName() {
		return tagName;
	}
	public void setTagName(String tagName) {
		this.tagName = tagName;
	}
	public String getTagDescription() {
		return tagDescription;
	}
	public void setTagDescription(String tagDescription) {
		this.tagDescription = tagDescription;
	}
	

}
