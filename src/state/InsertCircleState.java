package state;

import graphics.Point;
import graphics.shape.Circle;

public class InsertCircleState extends State {

	public InsertCircleState(StateClient client) {
		super(client);
	}

	@Override
	public void handlePointerDown(Point point) {}

	@Override
	public void handlePointerMoved(Point point, boolean pointerDown) {}

	@Override
	public void handlePointerUp(Point point) {
		client.addShape(new Circle(point, Math.random() * 50.0));
	}

}
