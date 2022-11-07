import java.awt.*;

/**
 * @author Van Park
 * @author Cole Park
 * @author Jacob Shapero
 * Assignment #2
 */
public class Circle {
    int x, y;
    Color color;
    Circle Neighbor;
    Boolean visited = false;

    public Circle(int x, int y, Color color){
        this.x = x;
        this.y = y;
        this.color = color;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public Circle getNeighbor() {
        return Neighbor;
    }

    public void setNeighbor(Circle neighbor) {
        Neighbor = neighbor;
    }

    public Boolean getVisited() {
        return visited;
    }

    public void setVisited(Boolean visited) {
        this.visited = visited;
    }
}
