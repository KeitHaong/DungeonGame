package unsw.loopmania.Allitems;

import javafx.beans.property.SimpleIntegerProperty;
import unsw.loopmania.Character;
import unsw.loopmania.Item;

/**
 * represents a HealthPotion in the backend world
 */
public class HealthPotion extends Item {

    /**
     * Contructor for health potion
     * 
     * @param x
     * @param y
     */
    public HealthPotion(SimpleIntegerProperty x, SimpleIntegerProperty y) {
        super(x, y);
    }

    /**
     * Use item in battle
     */
    @Override
    public void useItem(Character character) {
        character.setHealth(character.getMaxHealth());
    }

    /**
     * Get cost of item
     * 
     * @return 0
     */
    @Override
    public int getCost() {
        return 70;
    }    

}
