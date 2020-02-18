package state;

import graphics.Point;
import graphics.shape.shapedecorator.CrosshairDecorator;

public class CrosshairState extends State {

	public CrosshairState(StateClient client) {
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
