/**
 *
 */
package unsw.automata;

import javafx.scene.control.CheckBox;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.RowConstraints;
import javafx.beans.property.BooleanProperty;
import javafx.beans.property.SimpleBooleanProperty;

/**
 * Conway's Game of Life on a 10x10 grid.
 *
 * @author Robert Clifton-Everest
 *
 */
public class GameOfLife {
    //private GridPane grid = new GridPane();
    private BooleanProperty[][] matrix = new SimpleBooleanProperty[10][10];
    public GameOfLife() {
        // TODO At the start all cells are dead
        for (int x = 0; x < 10; x++) {
            for (int y = 0; y < 10; y++) {
                matrix[x][y] = new SimpleBooleanProperty(false);
                System.out.println("x = " + x + "y = " + y + "matrix val = " + matrix[x][y].getValue()); 
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
        matrix[x][y].setValue(true);
        System.out.println("X = " + x + ", Y = " + y + ", state: " + matrix[x][y]);
    }

    public void ensureDead(int x, int y) {
        // TODO Set the cell at (x,y) as dead
        matrix[x][y].setValue(false);
    }

    public boolean isAlive(int x, int y) {
        // TODO Return true if the cell is alive
        if (matrix[x][y].getValue()) return true;
        else return false;
    }

    private int countNeighbours(int x, int y, BooleanProperty[][] matrix) {
        int numNeighbours = 0;

        int leftX = (x == 0) ? (9) : (x - 1);
        int rightX = (x == 9) ? (0) : (x + 1);
        int upY = (y == 0) ? (9) : (y - 1);
        int downY = (y == 9) ? (0) : (y + 1);
        
        System.out.println("Left = " + leftX);
        if (matrix[leftX][y].getValue()) numNeighbours++;
        if (matrix[leftX][upY].getValue()) numNeighbours++;
        if (matrix[leftX][downY].getValue()) numNeighbours++;
        if (matrix[rightX][y].getValue()) numNeighbours++;
        if (matrix[rightX][upY].getValue()) numNeighbours++;
        if (matrix[rightX][downY].getValue()) numNeighbours++;
        if (matrix[x][upY].getValue()) numNeighbours++;
        if (matrix[x][downY].getValue()) numNeighbours++;

        return numNeighbours;
    }

    public void tick() {
        // TODO Transition the game to the next generation.
        BooleanProperty[][] tempMatrix = matrix;
        for (int x = 0; x < 10; x++) {
            for (int y = 0; y < 10; y++) {
                int numNeighbours = countNeighbours(x,y,tempMatrix);
                System.out.println("X = " + x + ", Y = " + y + ", numNeighbours = " + numNeighbours + ", state: " + matrix[x][y]);
                if (tempMatrix[x][y].getValue()) {
                    switch (numNeighbours) {
                        case 0:
                        case 1:
                            matrix[x][y] = new SimpleBooleanProperty(false);
                            break;
                        case 2:
                        case 3:
                            matrix[x][y] = new SimpleBooleanProperty(true);
                            break;
                        default:
                            matrix[x][y] = new SimpleBooleanProperty(false);
                    }
                } else {
                    if (numNeighbours == 3) matrix[x][y] = new SimpleBooleanProperty(true);
                    else matrix[x][y] = new SimpleBooleanProperty(false);
                }
            }
        }
    }

    public BooleanProperty cellProperty(int x, int y) {
        return matrix[x][y];
    }
}