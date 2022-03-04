package unsw.loopmania.Allitems;

import javafx.beans.property.SimpleIntegerProperty;
import unsw.loopmania.Character;
import unsw.loopmania.Item;

/**
 * represents Anduril in the backend world
 */
public class Anduril extends Item {
    
    /**
     * Anduril constructor
     * 
     * @param x
     * @param y
     */
    public Anduril(SimpleIntegerProperty x, SimpleIntegerProperty y) {
        super(x, y);
    }

    /**
     * Use item in battle
     * 
     * @param character
     */
    @Override
    public void useItem(Character character) {
        character.setAttack(character.getBossDamage());
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
