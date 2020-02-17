package state;

import graphics.Point;

public class CrosshairState extends State {

	public CrosshairState(StateClient client) {
		super(client);
	}

	@Override
	public void handlePointerDown(Point point) {
		client.select(point).ifPresent(client::drawCrosshair);
	}

	@Override
	public void handlePointerUp(Point point) {}

	@Override
	public void handlePointerMoved(Point point, boolean pointerDown) {}

	@Override
	protected void init() {}

}
