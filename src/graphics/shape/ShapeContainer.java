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
import state.State;
import state.StateClient;

public class ShapeContainer extends JPanel implements StateClient, Pointable {

	private static final long serialVersionUID = 1L;
	private final List<Shape> shapes = new LinkedList<Shape>();
	private Optional<Shape> selected = Optional.empty();

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
	public void removeShape(Shape shape) {
		shapes.remove(shape);
		repaint();
	}

	@Override
	public void moveShape(Shape shape, Point point) {
		shape.moveTo(point);
		repaint();
	}

	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		shapes.forEach(shape -> shape.draw(g));
	}

	@Override
	public void pointerDown(Point point) {
		State.getState().handlePointerDown(point);
	}

	@Override
	public void pointerUp(Point point) {
		State.getState().handlePointerUp(point);
	}

	@Override
	public void pointerMoved(Point point, boolean pointerDown) {
		State.getState().handlePointerMoved(point, pointerDown);
	}

}
