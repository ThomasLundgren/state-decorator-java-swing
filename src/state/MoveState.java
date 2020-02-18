package state;

import graphics.Point;

public class MoveState extends State {

	public MoveState(StateClient client) {
		super(client);
	}

	@Override
	public void handlePointerDown(Point point) {
		client.select(point);
	}

	@Override
	public void handlePointerUp(Point point) {
		client.select(null);
	}

	@Override
	public void handlePointerMoved(Point point, boolean pointerDown) {
		if (client.getSelected()
				.isPresent() && pointerDown) {
			client.moveShape(client.getSelected()
					.get(), point);
		}
	}

}
