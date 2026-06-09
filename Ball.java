import java.awt.Graphics2D;

public abstract class Ball {
    public int x, y;
    public int dx = 3, dy = -3;
    public int size = 15; // Increased size for visibility

    public Ball(int x, int y){
        this.x = x;
        this.y = y;
    }

    public Ball(int x, int y, int dx, int dy){
        this.x = x;
        this.y = y;
        this.dx = dx;
        this.dy = dy;
    }

    public void move(){
        x += dx;
        y += dy;
    }

    public abstract void draw(Graphics2D g);
}