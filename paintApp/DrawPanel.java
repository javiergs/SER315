import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.Stack;
import javax.swing.JPanel;

public class DrawPanel extends JPanel implements MouseListener, MouseMotionListener {
	
	private String shape;
	private String color;
	private boolean inPanel;
	private boolean drawing;
	private int x1,y1,x2,y2;
	public Stack<Shape> shapes;
	
	public DrawPanel() {
		setBackground(Color.cyan);
		inPanel=false;
		drawing=false;
		this.addMouseListener(this);
		this.addMouseMotionListener(this);
		shapes = new Stack<Shape>();
	}
	
	public void undo() {
		if(!shapes.isEmpty()) {shapes.pop();}
		repaint();
	}
	
	public void erase() {
		if(!shapes.isEmpty()) {shapes.clear();}
		repaint();
	}
	
	public void paintComponent (Graphics g) {
		if(shapes!=null) {
			for(int i=0;i<shapes.size();i++) {
				paintComponent(g,shapes.get(i));
			}
		}
	}
	
	public void paintComponent(Graphics g, Shape shape) {
		g.setColor(shape.color);
		if(shape.id.equals("Rectangle")) {
			g.fillRect(shape.x1, shape.y1, shape.x2-shape.x1, shape.y2-shape.y1);
			g.setColor(Color.BLACK);
			if(shape.x2>=shape.x1 && shape.y2>=shape.y1) {g.drawRect(shape.x1, shape.y1, shape.x2-shape.x1, shape.y2-shape.y1);}
			if(shape.x1>=shape.x2 && shape.y2>=shape.y1) {g.drawRect(shape.x2, shape.y1, shape.x1-shape.x2, shape.y2-shape.y1);}
			if(shape.x2>=shape.x1 && shape.y1>=shape.y2) {g.drawRect(shape.x1, shape.y2, shape.x2-shape.x1, shape.y1-shape.y2);}
			if(shape.x1>=shape.x2 && shape.y1>=shape.y2) {g.drawRect(shape.x2, shape.y2, shape.x1-shape.x2, shape.y1-shape.y2);}
		} else if(shape.id.equals("Circle")) {
			if(shape.x2>=shape.x1) {
				if(shape.y2>=shape.y1) {
					g.fillOval(shape.x1, shape.y1, Math.abs(shape.y2-shape.y1), Math.abs(shape.y2-shape.y1));
					g.setColor(Color.BLACK);
					g.drawOval(shape.x1, shape.y1, Math.abs(shape.y2-shape.y1), Math.abs(shape.y2-shape.y1));
				} else {
					g.fillOval(shape.x1, shape.y2, Math.abs(shape.y1-shape.y2), Math.abs(shape.y1-shape.y2));
					g.setColor(Color.BLACK);
					g.drawOval(shape.x1, shape.y2, Math.abs(shape.y1-shape.y2), Math.abs(shape.y1-shape.y2));
				}
			} else {
				if(shape.y2>=shape.y1) {
					g.fillOval(shape.x2, shape.y1, Math.abs(shape.y2-shape.y1), Math.abs(shape.y2-shape.y1));
					g.setColor(Color.BLACK);
					g.drawOval(shape.x2, shape.y1, Math.abs(shape.y2-shape.y1), Math.abs(shape.y2-shape.y1));
				} else {
					g.fillOval(shape.x2, shape.y2, Math.abs(shape.y1-shape.y2), Math.abs(shape.y1-shape.y2));
					g.setColor(Color.BLACK);
					g.drawOval(shape.x2, shape.y2, Math.abs(shape.y1-shape.y2), Math.abs(shape.y1-shape.y2));
				}
			}
		} else {
			double dx=shape.x1-shape.x2;
			double dy = shape.y2-shape.y1;
			double anglelnRadians = Math.atan2(-dy, dx);  
			double length = Math.toDegrees(anglelnRadians);
			double radiusX = Math.sqrt( (Math.pow( (shape.x2-shape.x1), 2)+Math.pow( (shape.y2-shape.y1), 2)) );
			double radiusY = radiusX/2;
			g.fillArc((int) (shape.x1), (int) (shape.y1), (int) radiusX, (int) radiusY, 0, (int) length);
			g.setColor(Color.BLACK);
			g.drawArc((int) (shape.x1), (int) (shape.y1), (int) radiusX, (int) radiusY, 0, (int) length);
		}
	}
	
	@Override
	public void mouseClicked(MouseEvent e) {
		repaint();
	}

	@Override
	public void mousePressed(MouseEvent e) {
		drawing=true;
		if(inPanel) {
			x1=e.getX();
			y1=e.getY();
		}
	}
	
	@Override
	public void mouseReleased(MouseEvent e) {
		drawing=false;
		if(inPanel) {
			x2=e.getX();
			y2=e.getY();
			if(shape.equals("Rectangle")) {shapes.push(new Rectangle(x1,y1,x2,y2,color)); }
			if(shape.equals("Circle")) {shapes.push(new Circle(x1,y1,x2,y2,color)); }
			if(shape.equals("Arc")) {shapes.push(new Arc(x1,y1,x2,y2,color)); }
			repaint();
		}
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		inPanel=true;
	}

	@Override
	public void mouseExited(MouseEvent e) {
		inPanel=false;
	}
	
	@Override
	public void mouseDragged(MouseEvent e) {
		if(drawing&&inPanel) {
			repaint();
			x2=e.getX();
			y2=e.getY();
			if(shape.equals("Rectangle")) {paintComponent(getGraphics(), new Rectangle(x1,y1,x2,y2,"P")); }
			if(shape.equals("Circle")) {paintComponent(getGraphics(), new Circle(x1,y1,x2,y2,"P")); }
			if(shape.equals("Arc")) {paintComponent(getGraphics(), new Arc(x1,y1,x2,y2,"P")); }
		}
		
	}

	@Override
	public void mouseMoved(MouseEvent e) {}
	
	public void setShape(String t) {
		shape = t;
	}
	
	public void setColor(String c) {
		color = c;
	}
}