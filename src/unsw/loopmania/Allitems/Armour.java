package unsw.loopmania.Allitems;
import javafx.beans.property.SimpleIntegerProperty;
import unsw.loopmania.Character;
import unsw.loopmania.Item;
import unsw.loopmania.Enemies.BasicEnemy;

/**
 * represents an equipped or unequipped armour in the backend world
 */
public class Armour extends Item {
    
    /**
     * Contructor for armour 
     * 
     * @param x
     * @param y
     */
    public Armour(SimpleIntegerProperty x, SimpleIntegerProperty y) {
        super(x, y);
    }

    /**
     * Use item in battle
     * 
     * @param character
     */
    @Override
    public void useItem(Character character) {
    }

    /**
     * Use armour effect against enemy 
     * 
     * @param enemy
     */
    public void useArmourEffect (BasicEnemy enemy) {
        int damage = enemy.getDamage();
        enemy.setDamage(damage / 2);
    }

    /**
     * Get cost of item
     * 
     * @return 85
     */
    @Override
    public int getCost() {
        return 85;
    } 
       
}
