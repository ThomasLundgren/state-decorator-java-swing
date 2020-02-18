package strategy;

import graphics.Point;
import state.StateClient;

public class CrosshairStrategy extends AbstractClickStrategy {

	public CrosshairStrategy(StateClient client) {
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

}
