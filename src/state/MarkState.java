package state;

import graphics.Point;
import graphics.shape.Shape;
import graphics.shape.shapedecorator.BlackFillDecorator;

public class MarkState extends State {

	public MarkState(StateClient client) {
		super(client);
	}

	@Override
	public void handlePointerDown(Point point) {
		client.select(point).ifPresent(shape -> {
			Shape markedShape = new BlackFillDecorator(shape);
			client.removeShape(shape);
			client.addShape(markedShape);
		});
	}

	@Override
	public void handlePointerUp(Point point) {}

	@Override
	public void handlePointerMoved(Point point, boolean pointerDown) {}

	@Override
	protected void init() {}

}
