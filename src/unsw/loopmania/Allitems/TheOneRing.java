package unsw.loopmania.Allitems;

import javafx.beans.property.SimpleIntegerProperty;
import unsw.loopmania.Character;
import unsw.loopmania.Item;

/**
 * represents the one ring in the backend world
 */
public class TheOneRing extends Item {
    /**
     * contructor for theonering
     * @param x
     * @param y
     */
    public TheOneRing(SimpleIntegerProperty x, SimpleIntegerProperty y) {
        super(x, y);
    }

    /**
     * Use item
     */
    @Override
    public void useItem(Character character) {
        character.setHealth(character.getMaxHealth());
    }

    /** 
     * get cost of item
     * 
     * @return 0
     */
    @Override
    public int getCost() {
        return 0; 
    }    
}
