package strategy;

import graphics.Point;

public interface ClickStrategy {

	void handlePointerDown(Point point);

	void handlePointerUp(Point point);

	void handlePointerMoved(Point point, boolean pointerDown);

}
