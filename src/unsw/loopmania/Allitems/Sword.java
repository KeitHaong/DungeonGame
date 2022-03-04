package unsw.loopmania.Allitems;

import javafx.beans.property.SimpleIntegerProperty;
import unsw.loopmania.Character;
import unsw.loopmania.Item;

/**
 * represents an equipped or unequipped sword in the backend world
 */
public class Sword extends Item {
    
    /**
     * contructor for sword
     * 
     * @param x
     * @param y
     */
    public Sword(SimpleIntegerProperty x, SimpleIntegerProperty y) {
        super(x, y);
    }

    /**
     * Use item in battle
     */
    @Override
    public void useItem(Character character) {
        int attack = character.getAttack();
        character.setAttack(attack + 3);
    }

    /**
     * get cost of sword
     * 
     * @return 85
     */
    @Override
    public int getCost() {
        return 85;
    }   
     
}
