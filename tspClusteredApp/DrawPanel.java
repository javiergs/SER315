import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Stack;

/**
 * @author Van Park
 * @author Cole Park
 * @author Jacob Shapero
 * Assignment #2
 */
public class DrawPanel extends JPanel implements MouseListener{
    int x;
    int y;
    Stack<Circle> stack;

    public DrawPanel(){
        addMouseListener(this);
        stack = new Stack<>();
    }

    /**
     * This is the method in charge of creating the circles when the screen is clicked as well as drawing the lines between all of the circles when the line checkbox is filled.
     * @param g graphics object that is provided by the superclass that allows for drawing on the screen.
     */
    public void paintComponent(Graphics g){
        super.paintComponent(g);

        if (!stack.isEmpty()){
            for (Circle circle : stack){
                g.setColor(circle.getColor());
                g.fillOval(circle.getX(), circle.getY(), 10 ,10);
                if(circle.getNeighbor() != null)
                {
                    g.setColor(Color.ORANGE);
                    g.drawLine(circle.getX()+5,circle.getY()+5,circle.getNeighbor().getX()+5,circle.getNeighbor().getY()+5);
                }
            }
        }
    }

    /**
     * This method is called when the mouse is clicked and is responsible for creating the small circles appearing on the screen.
     * @param e This is used to get the X and Y positions of the mouse.
     */
    @Override
    public void mouseClicked(MouseEvent e) {
        x = e.getX();
        y = e.getY();
        stack.push(new Circle(x, y, Color.BLACK));
        repaint();
    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }

    public Stack<Circle> getStack() {
        return stack;
    }

    public void setStack(Stack<Circle> stack) {
        this.stack = stack;
    }
}
