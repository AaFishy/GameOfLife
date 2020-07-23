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
    private GridPane grid = new GridPane();

    public GameOfLife() {
        // TODO At the start all cells are dead
        for (int x = 0; x < 10; x++) {
            for (int y = 0; y < 10; y++) {
                CheckBox newCheck = new CheckBox();
                newCheck.setIndeterminate(false);
                newCheck.setSelected(false);
                grid.add(newCheck, x, y);
            }
        }
    }

    public void ensureAlive(int x, int y) {
        // TODO Set the cell at (x,y) as alive
    }

    public void ensureDead(int x, int y) {
        // TODO Set the cell at (x,y) as dead
    }

    public boolean isAlive(int x, int y) {
        // TODO Return true if the cell is alive
        return false;
    }

    public void tick() {
        // TODO Transition the game to the next generation.
    }

}
