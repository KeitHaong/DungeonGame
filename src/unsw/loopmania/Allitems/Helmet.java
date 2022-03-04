package unsw.loopmania.Allitems;

import javafx.beans.property.SimpleIntegerProperty;
import unsw.loopmania.Character;
import unsw.loopmania.Item;
import unsw.loopmania.Enemies.BasicEnemy;

/**
 * represents an equipped or unequipped helmet in the backend world
 */
public class Helmet extends Item {
    
    /**
     * contructor for helmet 
     * 
     * @param x
     * @param y
     */
    public Helmet(SimpleIntegerProperty x, SimpleIntegerProperty y) {
        super(x, y);
    }

    /**
     * Use item in battle
     */
    @Override
    public void useItem(Character character) {
        int attack = character.getAttack();
        character.setAttack(attack - 3);
    }

    /**
     * Use item effect against enemy
     * 
     * @param enemy
     */
    public void useHelmetEffect(BasicEnemy enemy) {
        int damage = enemy.getDamage();
        enemy.setDamage((3 * damage) / 4);
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
