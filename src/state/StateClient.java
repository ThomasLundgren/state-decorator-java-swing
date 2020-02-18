package state;

import java.util.Optional;

import graphics.Point;
import graphics.shape.Shape;

public interface StateClient {

	void addShape(Shape shape);

	Optional<Shape> select(Point point);

	Optional<Shape> getSelected();

	void moveShape(Shape shape, Point point);

	void removeShape(Shape shape);

	void resizeShape(Shape shape, Point point);

}
