package app;

import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.SwingUtilities;

import graphics.shape.ShapeContainer;
import state.State;
import strategy.CrosshairStrategy;

public class ShapeApp extends JFrame implements Runnable {
	private static final long serialVersionUID = 1L;
	private final ShapeContainer shapeContainer = new ShapeContainer();

	public ShapeApp() {
		State.reset(shapeContainer);
	}

	@Override
	public void run() {
		createMenue();
		this.add(shapeContainer);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(400, 400);
		State.reset(shapeContainer);
		this.setVisible(true);
	}

	public void createMenue() {
		JMenu menu = new JMenu("Modes");
		JMenu insertMenu = new JMenu("Insert");
		menu.add(insertMenu);
		createMenuItem(insertMenu, "Circle", e -> State.getState().insertCircleMode());
		createMenuItem(insertMenu, "Rectangle", e -> State.getState().insertRectangleMode());
		createMenuItem(menu, "Move", e -> State.getState().moveMode());
		createMenuItem(menu, "Delete", e -> State.getState().deleteMode());
		createMenuItem(menu, "Mark", e -> State.getState().markMode());
		createMenuItem(menu, "Unmark", e -> State.getState().unmarkMode());
		createMenuItem(menu, "Crosshair", e -> State.getState().crosshairMode());
		createMenuItem(menu, "Resize", e -> State.getState().resizeMode());
		createMenuItem(menu, "Crosshair Strategy",
				e -> shapeContainer.setClickStrategy(new CrosshairStrategy(shapeContainer)));
		JMenuBar menuBar = new JMenuBar();
		menuBar.add(menu);
		this.setJMenuBar(menuBar);
	}

	private void createMenuItem(JMenu menu, String label, ActionListener listener) {
		JMenuItem menuItem = new JMenuItem(label);
		menuItem.addActionListener(listener);
		menu.add(menuItem);
	}

	public static void main(String args[]) {
		SwingUtilities.invokeLater(new ShapeApp());
	}
}
