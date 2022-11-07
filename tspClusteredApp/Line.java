import java.awt.*;
import java.util.Stack;

/**
 * @author Van Park
 * @author Cole Park
 * @author Jacob Shapero
 * Assignment #2
 */
public class Line
{

    /**
     * This method takes the user created circles and finds the nearest neighbor for every circle.
     * @param s the stack of circles created by the user.
     * @return s the stack of circles with updated neighbor values
     */
    public Stack<Circle> nearestNeighbors(Stack<Circle> s)
    {

        for(Circle c : s)
        {
            c.setVisited(false);
        }
        Circle curr = s.get(0);
        while(true) {
            curr.setVisited(true);
            Circle nearest = null;
            for (Circle c : s) {
                if (!c.getVisited()) {
                    Double distN = null;
                    if (nearest != null)
                        distN = Math.sqrt((Math.pow(Math.abs(nearest.getX() - curr.getX()), 2) + Math.pow(Math.abs(nearest.getY() - curr.getY()), 2)));
                    Double distC = Math.sqrt((Math.pow(Math.abs(c.getX() - curr.getX()), 2) + Math.pow(Math.abs(c.getY() - curr.getY()), 2)));
                    if (nearest == null || distC < distN) {
                        nearest = c;
                    }
                }

            }
            curr.setNeighbor(nearest);
            if (nearest != null) {
                nearest.setVisited(true);
                curr = nearest;
            }
            else
                return s;

        }
    }
}
