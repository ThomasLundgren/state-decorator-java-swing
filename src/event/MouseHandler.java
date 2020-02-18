package event;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import graphics.Point;

public class MouseHandler implements MouseListener, MouseMotionListener {

	private final Pointable pointable;

	public MouseHandler(Pointable pointable) {
		this.pointable = pointable;
	}

	@Override
	public void mouseDragged(MouseEvent e) {
		pointable.pointerMoved(new Point(e.getX(), e.getY()), true);
	}

	@Override
	public void mouseMoved(MouseEvent e) {
		pointable.pointerMoved(new Point(e.getX(), e.getY()), false);
	}

	@Override
	public void mouseClicked(MouseEvent e) {}

	@Override
	public void mousePressed(MouseEvent e) {
		pointable.pointerDown(new Point(e.getX(), e.getY()));
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		pointable.pointerUp(new Point(e.getX(), e.getY()));
	}

	@Override
	public void mouseEntered(MouseEvent e) {}

	@Override
	public void mouseExited(MouseEvent e) {}
}
