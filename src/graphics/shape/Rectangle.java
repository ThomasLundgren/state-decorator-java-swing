package graphics.shape;

import java.awt.Graphics;

import graphics.Point;

public class Rectangle implements Shape {

	private final Point center;
	private double width;
	private double height;

	public Rectangle(double x, double y, double width, double height) {
		center = new Point(x, y);
		this.width = width;
		this.height = height;
	}

	@Override
	public void draw(Graphics g) {
		double x = center.getX() - (width / 2);
		double y = center.getY() - (height / 2);
		g.drawRect((int) x, (int) y, (int) width, (int) height);
	}

	@Override
	public Point getPosition() { return new Point(center); }

	@Override
	public double getWidth() { return width; }

	@Override
	public double getHeight() { return height; }

	@Override
	public boolean intersects(Point point) {
		boolean isWithinWidth = (Math.abs(point.getX() - center.getX())) < (width / 2);
		boolean isWithinHeight = (Math.abs(point.getY() - center.getY())) < (height / 2);
		return isWithinWidth && isWithinHeight;
	}

	@Override
	public void moveTo(Point point) {
		center.moveTo(point);
	}

	@Override
	public void move(double dx, double dy) {
		center.move(dx, dy);
	}

	@Override
	public void resizeTo(Point point) {
		width = Math.abs(center.getX() - point.getX()) * 2;
		height = Math.abs(center.getY() - point.getY()) * 2;
	}

	@Override
	public Shape peel() {
		return this;
	}

}
