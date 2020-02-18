package strategy;

import graphics.Point;
import graphics.shape.shapedecorator.CrosshairDecorator;
import state.StateClient;

public class CrosshairStrategy extends AbstractClickStrategy {

	public CrosshairStrategy(StateClient client) {
		super(client);
	}

	@Override
	public void handlePointerDown(Point point) {
		client.select(point).ifPresent(shape -> {
			client.addShape(new CrosshairDecorator(shape));
			client.removeShape(shape);
		});
	}

	@Override
	public void handlePointerUp(Point point) {}

	@Override
	public void handlePointerMoved(Point point, boolean pointerDown) {}

}
