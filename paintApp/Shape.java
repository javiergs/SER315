import java.awt.*;

public abstract class Shape {

	public int x1, y1, x2, y2;
	public String id;
	public Color color;
	
	public Shape(int x1,int y1,int x2,int y2,String c) {
		this.x1=x1;
		this.y1=y1;
		this.x2=x2;
		this.y2=y2;
		switch(c) {
			case("Black"):
				color=Color.BLACK;
				break;
			case("Red"):
				color=Color.RED;
				break;
			case("Blue"):
				color=Color.BLUE;
				break;
			case("Green"):
				color=Color.GREEN;
				break;
			case("Yellow"):
				color=Color.YELLOW;
				break;
			case("Orange"):
				color=Color.ORANGE;
				break;
			case("Pink"):
				color=Color.PINK;
				break;
			default:
				color=Color.WHITE;
		}
		id="";
	}
}
