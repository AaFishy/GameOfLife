/**
 *
 */
package unsw.automata;

import javafx.scene.control.CheckBox;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.RowConstraints;
import javafx.beans.property.BooleanProperty;

/**
 * Conway's Game of Life on a 10x10 grid.
 *
 * @author Robert Clifton-Everest
 *
 */
public class GameOfLife {
    //private GridPane grid = new GridPane();
    private boolean[][] matrix = new boolean[10][10];
    public GameOfLife() {
        // TODO At the start all cells are dead
        for (int x = 0; x < 10; x++) {
            for (int y = 0; y < 10; y++) {
                matrix[x][y] = false;
            }
        }
        /*for (int x = 0; x < 10; x++) {
            for (int y = 0; y < 10; y++) {
                CheckBox newCheck = new CheckBox();
                newCheck.setIndeterminate(false);
                newCheck.setSelected(false);
                grid.add(newCheck, x, y);
            }
        }*/
    }

    public void ensureAlive(int x, int y) {
        // TODO Set the cell at (x,y) as alive
        matrix[x][y] = true;
    }

    public void ensureDead(int x, int y) {
        // TODO Set the cell at (x,y) as dead
        matrix[x][y] = false;
    }

    public boolean isAlive(int x, int y) {
        // TODO Return true if the cell is alive
        if (matrix[x][y]) return true;
        else return false;
    }

    private int countNeighbours(int x, int y) {
        int numNeighbours = 0;

        int leftX = (x == 0) ? (9) : (x - 1);
        int rightX = (x == 9) ? (0) : (x + 1);
        int upY = (y == 0) ? (9) : (y - 1);
        int downY = (y == 9) ? (0) : (y + 1);

        if (matrix[leftX][y]) numNeighbours++;
        if (matrix[leftX][upY]) numNeighbours++;
        if (matrix[leftX][downY]) numNeighbours++;
        if (matrix[rightX][y]) numNeighbours++;
        if (matrix[rightX][upY]) numNeighbours++;
        if (matrix[rightX][downY]) numNeighbours++;
        if (matrix[x][upY]) numNeighbours++;
        if (matrix[x][downY]) numNeighbours++;

        return numNeighbours;
    }

    public void tick() {
        // TODO Transition the game to the next generation.
        boolean[][] tempMatrix = new boolean[10][10];
        for (int x = 0; x < 10; x++) {
            for (int y = 0; y < 10; y++) {
                int numNeighbours = countNeighbours(x,y);
                System.out.println("X = " + x + ", Y = " + y + ", numNeighbours = " + numNeighbours + ", state: " + matrix[x][y]);
                if (matrix[x][y]) {
                    switch (numNeighbours) {
                        case 0:
                        case 1:
                            tempMatrix[x][y] = false;
                            break;
                        case 2:
                        case 3:
                            tempMatrix[x][y] = true;
                            break;
                        default:
                            tempMatrix[x][y] = false;
                    }
                } else {
                    if (numNeighbours == 3) tempMatrix[x][y] = true;
                }
            }
        }
        matrix = tempMatrix;
    }

}
