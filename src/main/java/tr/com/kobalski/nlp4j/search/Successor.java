package tr.com.kobalski.nlp4j.search;




public class Successor {

	private String action;

	private Object state;

	public Successor(String action, Object state) {
		this.action = action;
		this.state = state;
	}

	public String getAction() {
		return action;
	}

	public Object getState() {
		return state;
	}
}