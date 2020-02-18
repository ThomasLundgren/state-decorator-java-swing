package state;

import graphics.Point;
import graphics.shape.Rectangle;

public class InsertRectangleState extends State {

	public InsertRectangleState(StateClient client) {
		super(client);
	}

	@Override
	public void handlePointerDown(Point point) {}

	@Override
	public void handlePointerUp(Point point) {
		client.addShape(new Rectangle(point.getX(), point.getY(), Math.random() * 50.0, Math.random() * 50.0));
	}

	@Override
	public void handlePointerMoved(Point point, boolean pointerDown) {}

	@Override
	protected void init() {}

}
