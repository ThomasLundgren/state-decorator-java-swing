package graphics.shape.shapedecorator;

import java.awt.Graphics;

import graphics.Point;
import graphics.shape.Shape;

public class CrosshairDecorator extends ShapeDecorator implements Shape {

	public CrosshairDecorator(Shape decoratee) {
		super(decoratee);
	}

	@Override
	protected void decorate(Graphics g) {
		Point point = decoratee.getPosition();
		double horizEdgeDist = decoratee.getWidth() / 2;
		double vertEdgeDist = decoratee.getHeight() / 2;

		g.drawLine((int) (point.getX() - horizEdgeDist), (int) point.getY(), (int) (point.getX() + horizEdgeDist),
				(int) point.getY());
		g.drawLine((int) point.getX(), (int) (point.getY() - vertEdgeDist), (int) point.getX(),
				(int) (point.getY() + vertEdgeDist));
	}

}
