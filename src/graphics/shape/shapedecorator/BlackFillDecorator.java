package graphics.shape.shapedecorator;

import java.awt.Graphics;

import graphics.Point;
import graphics.shape.Shape;

public class BlackFillDecorator extends ShapeDecorator implements Shape {

	public BlackFillDecorator(Shape decoratee) {
		super(decoratee);
	}

	@Override
	protected void decorate(Graphics g) {
		Point position = decoratee.getPosition();
		int x = (int) (position.getX() - decoratee.getWidth() / 2.0 + 0.5);
		int y = (int) (position.getY() - decoratee.getHeight() / 2.0 + 0.5);
		g.fillOval(x, y, (int) (decoratee.getWidth() + 0.5), (int) (decoratee.getHeight() + 0.5));
	}

}
