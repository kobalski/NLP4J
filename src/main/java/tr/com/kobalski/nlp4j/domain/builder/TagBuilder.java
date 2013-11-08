package tr.com.kobalski.nlp4j.domain.builder;

import tr.com.kobalski.nlp4j.domain.model.Tag;

public class TagBuilder implements Builder<Tag> {

	public long	  id;
	public String tagName;
	public String tagDescription;
	
	public TagBuilder tagName(String tagName){
		this.tagName = tagName;
		return this;
	}
	
	public TagBuilder tagDescription(String tagDescription){
		
		this.tagDescription = tagDescription;
		return this;
	}
	
	public TagBuilder id(long id){
		
		this.id = id;
		return this;
	}
	
	@Override
	public Tag build() {
		Tag newInstance = new Tag();
		newInstance.setId(id);
		newInstance.setTagName(tagName);
		newInstance.setTagDescription(tagDescription);
		return newInstance;
	}

}
