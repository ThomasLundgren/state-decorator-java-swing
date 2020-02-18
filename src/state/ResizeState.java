package state;

import graphics.Point;

public class ResizeState extends State {

	public ResizeState(StateClient client) {
		super(client);
	}

	@Override
	public void handlePointerDown(Point point) {
		client.select(point);
	}

	@Override
	public void handlePointerUp(Point point) {}

	@Override
	public void handlePointerMoved(Point point, boolean pointerDown) {
		if (pointerDown) {
			client.getSelected()
					.ifPresent(shape -> client.resizeShape(shape, point));
		}
	}

}
