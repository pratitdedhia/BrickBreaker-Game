import java.awt.Color;
import java.awt.Graphics2D;

public class SquareBall extends Ball {
    public SquareBall(int x, int y) {
        super(x, y);
    }

    public SquareBall(int x, int y, int dx, int dy) {
        super(x, y, dx, dy);
    }

    @Override
    public void draw(Graphics2D g) {
        g.setColor(new Color(255, 100, 100)); // Make it a different color for visibility
        g.fillRect(x, y, size, size);
    }
}
