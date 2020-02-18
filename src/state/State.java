package state;

import graphics.Point;

public abstract class State {

	private static State currentState;
	protected StateClient client;

	protected State(StateClient client) {
		this.client = client;
	}

	public static void reset(StateClient client) {
		setState(new InsertCircleState(client));
	}

	protected static void setState(State newState) { currentState = newState; }

	public static State getState() { return currentState; }

	public abstract void handlePointerDown(Point point);

	public abstract void handlePointerUp(Point point);

	public abstract void handlePointerMoved(Point point, boolean pointerDown);

	public void insertCircleMode() {
		setState(new InsertCircleState(client));
	}

	public void insertRectangleMode() {
		setState(new InsertRectangleState(client));
	}

	public void moveMode() {
		setState(new MoveState(client));
	}

	public void deleteMode() {
		setState(new DeleteState(client));
	}

	public void markMode() {
		setState(new MarkState(client));
	}

	public void unmarkMode() {
		setState(new UnmarkState(client));
	}

	public void resizeMode() {
		setState(new ResizeState(client));
	}

	public void crosshairMode() {
		setState(new CrosshairState(client));
	}

}
