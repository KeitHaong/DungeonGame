package unsw.loopmania.Allitems;


import javafx.beans.property.SimpleIntegerProperty;
import unsw.loopmania.Character;
import unsw.loopmania.Item;
import unsw.loopmania.Enemies.BasicEnemy;
import unsw.loopmania.Enemies.Vampire;

/**
 * represents an equipped or unequipped shield in the backend world
 */
public class Shield extends Item {
    
    /**
     * Contructor for shield
     * 
     * @param x
     * @param y
     */
    public Shield(SimpleIntegerProperty x, SimpleIntegerProperty y) {
        super(x, y);
    }

    /**
     * Use item
     */
    @Override
    public void useItem(Character character) {
    }

    /**
     * Use effect of shield against enemy
     * 
     * @param enemy
     */
    public void useShieldEffect(BasicEnemy enemy) {
        if (enemy instanceof Vampire) {
            int chance = (int) Math.round(enemy.getStrikeChance() * 0.6);
            enemy.setDebuffChance(chance);
        } else {
            enemy.setDebuffChance(enemy.getStrikeChance());
        }
    }

    /**
     * get cost of item
     * 
     * @return 85
     */
    @Override
    public int getCost() {
        return 85;
    }    
}

