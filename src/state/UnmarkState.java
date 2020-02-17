package state;

import graphics.Point;

public class UnmarkState extends State {

	public UnmarkState(StateClient client) {
		super(client);
	}

	@Override
	public void handlePointerDown(Point point) {
		client.select(point).ifPresent(client::unmarkShape);
	}

	@Override
	public void handlePointerUp(Point point) {}

	@Override
	public void handlePointerMoved(Point point, boolean pointerDown) {}

	@Override
	protected void init() {}

}
