package unsw.loopmania.Allitems;

import javafx.beans.property.SimpleIntegerProperty;
import unsw.loopmania.Character;
import unsw.loopmania.Item;

/**
 * represents gold in the backend world
 */
public class Gold extends Item {
    /**
     * Contructor for gold
     * 
     * @param x
     * @param y
     */
    public Gold(SimpleIntegerProperty x, SimpleIntegerProperty y) {
        super(x, y);
    }

    /**
     * Use item
     * 
     * @return
     */
    @Override
    public void useItem(Character character) {
        return;
    }   

    /**
     * Get cost of item
     * 
     * @return 0
     */
    @Override
    public int getCost() {
        return 0;
    }
 
}
