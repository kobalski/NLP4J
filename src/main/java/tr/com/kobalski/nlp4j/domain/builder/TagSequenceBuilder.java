package tr.com.kobalski.nlp4j.domain.builder;

import java.util.Map;

import tr.com.kobalski.nlp4j.domain.model.Tag;
import tr.com.kobalski.nlp4j.domain.model.TagSequence;

public class TagSequenceBuilder implements Builder<TagSequence> {

	private long				id;
	private String 				sequenceName;
	private  Map<String,Tag>	listOfTags;
	
	public TagSequenceBuilder id(long id){
		this.id = id;
		return this;
	}
	
	public TagSequenceBuilder sequenceName(String sequenceName){
		this.sequenceName = sequenceName;
		return this;
	}

	public TagSequenceBuilder listOfTags( Map<String,Tag> listOfTags ){
		this.listOfTags = listOfTags;
		return this;
	}
	
	@Override
	public TagSequence build() {
		TagSequence newInstance = new TagSequence();
		newInstance.setId(id);
		newInstance.setListOfTags(listOfTags);
		newInstance.setSequenceName(sequenceName);
		return newInstance;
	}

}
