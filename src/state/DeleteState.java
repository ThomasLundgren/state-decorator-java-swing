package state;

import graphics.Point;

public class DeleteState extends State {

	public DeleteState(StateClient client) {
		super(client);
	}

	@Override
	public void handlePointerDown(Point point) {
		// @formatter:off
		client.select(point)
			.ifPresent(client::removeShape);
		// @formatter:on
	}

	@Override
	public void handlePointerUp(Point point) {}

	@Override
	public void handlePointerMoved(Point point, boolean pointerDown) {}

	@Override
	protected void init() {}

}
