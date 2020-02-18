package graphics.shape;

import java.awt.Color;
import java.awt.Graphics;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

import javax.swing.JPanel;

import event.MouseHandler;
import event.Pointable;
import graphics.Point;
import graphics.shape.shapedecorator.BlackFillDecorator;
import graphics.shape.shapedecorator.CrosshairDecorator;
import state.State;
import state.StateClient;
import strategy.ClickStrategy;

public class ShapeContainer extends JPanel implements StateClient, Pointable {

	private static final long serialVersionUID = 1L;
	private final List<Shape> shapes = new LinkedList<Shape>();
	private Optional<Shape> selected = Optional.empty();
	private ClickStrategy clickStrategy;

	public ShapeContainer() {
		super();
		MouseHandler mouseHandler = new MouseHandler(this);
		this.addMouseListener(mouseHandler);
		this.addMouseMotionListener(mouseHandler);
		this.setBackground(Color.white);
	}

	@Override
	public void addShape(Shape shape) {
		shapes.add(shape);
		repaint();
	}

	@Override
	public Optional<Shape> select(Point point) {
		if (point == null) {
			selected = Optional.empty();
			System.out.println(selected);
			return selected;
		}
		shapes.stream().filter(shape -> shape.intersects(point)).findFirst().ifPresent(s -> selected = Optional.of(s));
		System.out.println(selected);
		return selected;
	}

	@Override
	public Optional<Shape> getSelected() { return selected; }

	@Override
	public void moveShape(Shape shape, Point point) {
		shape.moveTo(point);
		repaint();
	}

	@Override
	public void deleteShape(Shape shape) {
		shapes.remove(shape);
		repaint();
	}

	@Override
	public void markShape(Shape shape) {
		Shape markedShape = new BlackFillDecorator(shape);
		shapes.remove(shape);
		shapes.add(markedShape);
		repaint();
	}

	@Override
	public void unmarkShape(Shape shape) {
		Shape unmarkedShape = shape.peel();
		shapes.remove(shape);
		shapes.add(unmarkedShape);
		repaint();
	}

	@Override
	public void resizeShape(Shape shape, Point newPoint) {
		shape.resizeTo(newPoint);
		repaint();
	}

	@Override
	public void drawCrosshair(Shape shape) {
		shapes.add(new CrosshairDecorator(shape));
		shapes.remove(shape);
		repaint();
	}

	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		shapes.forEach(shape -> shape.draw(g));
	}

	@Override
	public void pointerDown(Point point) {
		if (clickStrategy != null) {
			clickStrategy.handlePointerDown(point);
		} else {
			State.getState().handlePointerDown(point);
		}
	}

	@Override
	public void pointerUp(Point point) {
		State.getState().handlePointerUp(point);
	}

	@Override
	public void pointerMoved(Point point, boolean pointerDown) {
		State.getState().handlePointerMoved(point, pointerDown);
	}

	public void setClickStrategy(ClickStrategy clickStrategy) {

	}

}
