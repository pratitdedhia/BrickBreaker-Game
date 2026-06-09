import java.awt.*;

public class Brick {

    public int map[][];
    public int brickWidth;
    public int brickHeight;

    public Brick(int map[][]){
        this.map = map;
        this.brickWidth = 70;
        this.brickHeight = 30;
    }

    public void draw(Graphics2D g){
        for(int i = 0; i < map.length; i++){
            for(int j = 0; j < map[0].length; j++){
                int brickVal = map[i][j];
                if(brickVal != 0){
                    int bx = j * brickWidth + 80;
                    int by = i * brickHeight + 50;
                    Color brickColor;
                    
                    if (brickVal == -1) {
                        // Indestructible gold brick
                        brickColor = new Color(230, 180, 30);
                    } else if (brickVal == 3) {
                        // 3-HP Steel brick
                        brickColor = new Color(130, 140, 150);
                    } else if (brickVal == 2) {
                        // 2-HP Purple/Orange brick (transitioning)
                        brickColor = new Color(180, 80, 200);
                    } else {
                        // 1-HP Vibrant row-based gradient
                        int red = Math.min(255, 100 + i * 25);
                        int green = Math.min(255, 50 + j * 18);
                        int blue = Math.max(0, 200 - i * 15);
                        brickColor = new Color(red, green, blue);
                    }
                    
                    g.setColor(brickColor);
                    g.fillRect(bx, by, brickWidth, brickHeight);
                    
                    // Specific decorations for special bricks
                    if (brickVal == -1) {
                        // Gold rivets/inner border for indestructible bricks
                        g.setColor(new Color(255, 230, 100));
                        g.drawRect(bx + 3, by + 3, brickWidth - 6, brickHeight - 6);
                        
                        // Cross lines for metallic reinforcement look
                        g.setColor(new Color(170, 120, 10));
                        g.drawLine(bx + 4, by + 4, bx + brickWidth - 4, by + brickHeight - 4);
                        g.drawLine(bx + brickWidth - 4, by + 4, bx + 4, by + brickHeight - 4);
                    } else if (brickVal == 3) {
                        // Steel panel lines for 3-HP
                        g.setColor(new Color(180, 190, 200));
                        g.drawRect(bx + 2, by + 2, brickWidth - 4, brickHeight - 4);
                        g.setColor(new Color(80, 90, 100));
                        g.drawRect(bx + 4, by + 4, brickWidth - 8, brickHeight - 8);
                    } else if (brickVal == 2) {
                        // Crack lines for 2-HP damaged bricks
                        g.setColor(new Color(230, 150, 255));
                        g.drawLine(bx + 5, by + 5, bx + 20, by + 12);
                        g.drawLine(bx + 20, by + 12, bx + 15, by + 25);
                        g.drawLine(bx + brickWidth - 10, by + 20, bx + brickWidth - 25, by + 8);
                    }
                    
                    // Main border
                    g.setColor(Color.BLACK);
                    g.drawRect(bx, by, brickWidth, brickHeight);
                }
            }
        }
    }
}