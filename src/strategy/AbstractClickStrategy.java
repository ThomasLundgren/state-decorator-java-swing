package strategy;

import state.StateClient;

public abstract class AbstractClickStrategy implements ClickStrategy {

	protected final StateClient client;

	public AbstractClickStrategy(StateClient client) {
		this.client = client;
	}

}
