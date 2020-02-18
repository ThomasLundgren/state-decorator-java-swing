package state;

import graphics.Point;
import graphics.shape.Shape;

public class UnmarkState extends State {

	public UnmarkState(StateClient client) {
		super(client);
	}

	@Override
	public void handlePointerDown(Point point) {
		// @formatter:off
		client.select(point)
			.ifPresent(shape -> {
				Shape unmarkedShape = shape.peel();
				client.removeShape(shape);
				client.addShape(unmarkedShape);
			});
		// @formatter:on
	}

	@Override
	public void handlePointerUp(Point point) {}

	@Override
	public void handlePointerMoved(Point point, boolean pointerDown) {}

}
