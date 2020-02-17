package state;

import graphics.Point;

public class MarkState extends State {

	public MarkState(StateClient client) {
		super(client);
	}

	@Override
	public void handlePointerDown(Point point) {
		client.select(point).ifPresent(client::markShape);
	}

	@Override
	public void handlePointerUp(Point point) {}

	@Override
	public void handlePointerMoved(Point point, boolean pointerDown) {}

	@Override
	protected void init() {}

}
