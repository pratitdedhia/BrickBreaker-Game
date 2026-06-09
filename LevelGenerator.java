import java.util.Random;

public class LevelGenerator {
    public int map[][];
    private final int cols = 8;
    
    public LevelGenerator(int level, boolean isEndless){
        if (isEndless) {
            int rows = 6;
            map = new int[rows][cols];
            Random r = new Random();
            generateEndless(r);
        } else {
            generateLevel(level);
        }
    }

    public void generateEndless(Random r){
        for(int i = 0; i < map.length; i++){
            for(int j = 0; j < map[0].length; j++){
                map[i][j] = r.nextInt(2); // Random 0 or 1
            }
        }
        // Ensure at least some bricks exist
        boolean hasBricks = false;
        for(int i = 0; i < map.length; i++){
            for(int j = 0; j < map[0].length; j++){
                if(map[i][j] > 0) hasBricks = true;
            }
        }
        if(!hasBricks) map[0][0] = 1;
    }

    private void generateLevel(int level) {
        int rows = 3;
        switch(level) {
            case 1: rows = 3; break;
            case 2: rows = 4; break;
            case 3: rows = 4; break;
            case 4: rows = 4; break;
            case 5: rows = 5; break;
            case 6: rows = 6; break;
            case 7: rows = 5; break;
            case 8: rows = 5; break;
            case 9: rows = 6; break;
            case 10: rows = 6; break;
            case 11: rows = 7; break;
            case 12: rows = 7; break;
            case 13: rows = 8; break;
            case 14: rows = 6; break;
            case 15: rows = 7; break;
            case 16: rows = 8; break;
            case 17: rows = 7; break;
            case 18: rows = 9; break;
            case 19: rows = 8; break;
            case 20: rows = 9; break;
            default: rows = 5; break;
        }
        map = new int[rows][cols];
        
        switch(level) {
            case 1:
                // Level 1: Simple 3 rows of breakables (all 1-HP)
                for(int i = 0; i < rows; i++) {
                    for(int j = 0; j < cols; j++) {
                        map[i][j] = 1;
                    }
                }
                break;
            case 2:
                // Level 2: 4 rows of 1-HP bricks
                for(int i = 0; i < rows; i++) {
                    for(int j = 0; j < cols; j++) {
                        map[i][j] = 1;
                    }
                }
                break;
            case 3:
                // Level 3: Checkered 4 rows
                for(int i = 0; i < rows; i++) {
                    for(int j = 0; j < cols; j++) {
                        map[i][j] = ((i + j) % 2 == 0) ? 1 : 0;
                    }
                }
                break;
            case 4:
                // Level 4: Introduces 2-HP bricks (middle two rows)
                for(int i = 0; i < rows; i++) {
                    for(int j = 0; j < cols; j++) {
                        if (i == 1 || i == 2) {
                            map[i][j] = 2; // 2-HP
                        } else {
                            map[i][j] = 1; // 1-HP
                        }
                    }
                }
                break;
            case 5:
                // Level 5: Pyramid layout
                for(int i = 0; i < rows; i++) {
                    for(int j = 0; j < cols; j++) {
                        if (j >= i && j < cols - i) {
                            map[i][j] = (i % 2 == 0) ? 2 : 1;
                        } else {
                            map[i][j] = 0;
                        }
                    }
                }
                break;
            case 6:
                // Level 6: Alternating Columns (some space in between)
                for(int i = 0; i < rows; i++) {
                    for(int j = 0; j < cols; j++) {
                        if (j % 2 == 0) {
                            map[i][j] = (i % 2 == 0) ? 2 : 1;
                        } else {
                            map[i][j] = 0;
                        }
                    }
                }
                break;
            case 7:
                // Level 7: Center shield made of indestructible bricks
                for(int i = 0; i < rows; i++) {
                    for(int j = 0; j < cols; j++) {
                        if (i == 2 && (j == 2 || j == 3 || j == 4 || j == 5)) {
                            map[i][j] = -1; // Indestructible
                        } else {
                            map[i][j] = 1;
                        }
                    }
                }
                break;
            case 8:
                // Level 8: Alternating horizontal stripes of 1-HP and 2-HP bricks
                for(int i = 0; i < rows; i++) {
                    for(int j = 0; j < cols; j++) {
                        map[i][j] = (i % 2 == 0) ? 2 : 1;
                    }
                }
                break;
            case 9:
                // Level 9: Fortress (3-HP bricks at bottom row, 2-HP middle, 1-HP top)
                for(int i = 0; i < rows; i++) {
                    for(int j = 0; j < cols; j++) {
                        if (i >= 4) map[i][j] = 3;
                        else if (i >= 2) map[i][j] = 2;
                        else map[i][j] = 1;
                    }
                }
                break;
            case 10:
                // Level 10: "X" obstacle structure using indestructible blocks
                for(int i = 0; i < rows; i++) {
                    for(int j = 0; j < cols; j++) {
                        if (i == j || i == (cols - 1 - j) || (i + 1) == j || (i + 1) == (cols - 1 - j)) {
                            if (i == 2 || i == 3) {
                                map[i][j] = -1; // Indestructible center
                            } else {
                                map[i][j] = 2;
                            }
                        } else {
                            map[i][j] = 1;
                        }
                    }
                }
                break;
            case 11:
                // Level 11: Inner chamber of 3-HP guarded by 2-HP outer bricks
                for(int i = 0; i < rows; i++) {
                    for(int j = 0; j < cols; j++) {
                        if (i == 0 || i == rows - 1 || j == 0 || j == cols - 1) {
                            map[i][j] = 2;
                        } else {
                            map[i][j] = 3;
                        }
                    }
                }
                break;
            case 12:
                // Level 12: Checkerboard Hard with 2-HP and 3-HP bricks
                for(int i = 0; i < rows; i++) {
                    for(int j = 0; j < cols; j++) {
                        map[i][j] = ((i + j) % 2 == 0) ? 3 : 2;
                    }
                }
                break;
            case 13:
                // Level 13: Columns of Iron (vertical lines of indestructible bricks)
                for(int i = 0; i < rows; i++) {
                    for(int j = 0; j < cols; j++) {
                        if (j == 2 || j == 5) {
                            map[i][j] = -1;
                        } else {
                            map[i][j] = (i % 2 == 0) ? 3 : 1;
                        }
                    }
                }
                break;
            case 14:
                // Level 14: Iron Cage - row of indestructible blocks with small entry gaps
                for(int i = 0; i < rows; i++) {
                    for(int j = 0; j < cols; j++) {
                        if (i == 3) {
                            if (j == 3 || j == 4) {
                                map[i][j] = 0;
                            } else {
                                map[i][j] = -1;
                            }
                        } else {
                            map[i][j] = 2;
                        }
                    }
                }
                break;
            case 15:
                // Level 15: The Maze
                for(int i = 0; i < rows; i++) {
                    for(int j = 0; j < cols; j++) {
                        if ((i == 2 && j < 6) || (i == 4 && j > 1)) {
                            map[i][j] = -1;
                        } else {
                            map[i][j] = ((i + j) % 2 == 0) ? 2 : 3;
                        }
                    }
                }
                break;
            case 16:
                // Level 16: Hourglass shape
                for(int i = 0; i < rows; i++) {
                    for(int j = 0; j < cols; j++) {
                        int dist = Math.abs(j - cols/2);
                        if (i < rows/2) {
                            map[i][j] = (dist >= i) ? 3 : 0;
                        } else {
                            map[i][j] = (dist >= (rows - 1 - i)) ? 3 : 0;
                        }
                    }
                }
                break;
            case 17:
                // Level 17: Diamond of 3-HP bricks surrounded by indestructible blocks
                for(int i = 0; i < rows; i++) {
                    for(int j = 0; j < cols; j++) {
                        int centerRow = rows / 2;
                        int centerCol = cols / 2;
                        int dist = Math.abs(i - centerRow) + Math.abs(j - centerCol);
                        if (dist == 0) {
                            map[i][j] = -1; // Center obstacle
                        } else if (dist <= 3) {
                            map[i][j] = 3;
                        } else {
                            map[i][j] = 2;
                        }
                    }
                }
                break;
            case 18:
                // Level 18: Twin Castles (tall pillars)
                for(int i = 0; i < rows; i++) {
                    for(int j = 0; j < cols; j++) {
                        if (j == 0 || j == 1 || j == 6 || j == 7) {
                            map[i][j] = 3;
                        } else if (i == 4 && (j == 3 || j == 4)) {
                            map[i][j] = -1;
                        } else {
                            map[i][j] = 1;
                        }
                    }
                }
                break;
            case 19:
                // Level 19: Scatter - chaotic mix of 2-HP, 3-HP, and indestructible blocks
                for(int i = 0; i < rows; i++) {
                    for(int j = 0; j < cols; j++) {
                        if ((i + j) % 3 == 0) {
                            map[i][j] = -1;
                        } else if ((i + j) % 3 == 1) {
                            map[i][j] = 3;
                        } else {
                            map[i][j] = 2;
                        }
                    }
                }
                break;
            case 20:
                // Level 20: The Ultimate Challenge
                for(int i = 0; i < rows; i++) {
                    for(int j = 0; j < cols; j++) {
                        if (i == 0 || i == rows - 1) {
                            map[i][j] = -1; // Top and bottom lines are indestructible blocks!
                        } else {
                            map[i][j] = 3; // Everything in between is 3-HP!
                        }
                    }
                }
                // Open some gaps in the indestructible borders so balls can enter/escape
                map[0][3] = 3;
                map[0][4] = 3;
                map[rows-1][2] = 3;
                map[rows-1][5] = 3;
                break;
        }
    }

    public void shiftDown(){
        // Create a new map with one extra row
        int newRows = map.length + 1;
        int[][] newMap = new int[newRows][cols];

        // Shift all existing rows down by 1
        for(int i = 0; i < map.length; i++){
            for(int j = 0; j < cols; j++){
                newMap[i + 1][j] = map[i][j];
            }
        }
        
        // Generate new top row
        Random r = new Random();
        for(int j = 0; j < cols; j++){
            newMap[0][j] = r.nextInt(2);
        }
        
        map = newMap;
    }
}