package tr.com.kobalski.nlp4j.domain.model;


public abstract class BaseNLPEntity implements NLPEntity {


	protected long id;
	
	public BaseNLPEntity() {
		
	}
	
	public BaseNLPEntity(long id) {
		this.id = id;
	}
	
	@Override
	public long getId() {
		return id;
	}
	
	public void setId(long id) {
		this.id = id;
	}
}
