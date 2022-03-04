package unsw.loopmania.Allitems;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import unsw.loopmania.Character;
import unsw.loopmania.Item;
import unsw.loopmania.Enemies.BasicEnemy;
import unsw.loopmania.Enemies.Doggie;
import unsw.loopmania.Enemies.ElanMuske;

/**
 * represents a TreeStump in the backend world
 */
public class TreeStump extends Item {
    /**
     * Constructor for TreeStump
     * @param x
     * @param y
     */
    public TreeStump(SimpleIntegerProperty x, SimpleIntegerProperty y) {
        super(x, y);
    }

    /**
     * Does nothing
     */
    @Override
    public void useItem(Character character) {
        return;
    }

    /**
     * Use armour effect against enemy 
     * 
     * @param enemy
     */
    public void useTreeEffect (BasicEnemy enemy) {
        if (enemy instanceof ElanMuske) {
            int damage = enemy.getDamage();
            enemy.setDamage(damage - 10);
        }
        if (enemy instanceof Doggie) {
            int damage = enemy.getDamage();
            enemy.setDamage(damage - 5);
        }
    }
        
    /**
     * Returns cost
     */
    @Override
    public int getCost() {
        return 0; 
    }    
}
