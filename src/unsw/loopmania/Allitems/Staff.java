package unsw.loopmania.Allitems;

import java.util.Random;
import javafx.beans.property.SimpleIntegerProperty;
import unsw.loopmania.Character;
import unsw.loopmania.Item;
import unsw.loopmania.Ally;


/**
 * represents an equipped or unequipped staff in the backend world
 */
public class Staff extends Item {
    private Random rand; 
    /**
     * Contructor of staff
     * 
     * @param x
     * @param y
     */
    public Staff(SimpleIntegerProperty x, SimpleIntegerProperty y) {
        super(x, y);
        this.rand  = new Random();
    }

    /**
     * Set a seed for random
     * @param seed
     */
    public void setRandom(long seed) {
        this.rand = new Random(seed);
    }

    /** 
     * use item in battle
     */
    @Override
    public void useItem(Character character) {
        int attack = character.getAttack();
        character.setAttack(attack - 6);
    }
    
    /**
     * Generates ally as effect
     * 
     * @return
     */
    public Ally useStaffEffect() {
        int r = rand.nextInt(10);
        if (r <= 3) {
            Ally newally = new Ally();
            return newally;
        }
        return null;
    }

    /**
     * Gets cost of item
     * 
     * @return 100
     */
    @Override
    public int getCost() {
        return 100;
    }      
}
