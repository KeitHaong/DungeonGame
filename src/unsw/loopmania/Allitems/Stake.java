package unsw.loopmania.Allitems;

import javafx.beans.property.SimpleIntegerProperty;
import unsw.loopmania.Character;
import unsw.loopmania.Item;
import unsw.loopmania.Enemies.BasicEnemy;
import unsw.loopmania.Enemies.Vampire;

/**
 * represents an equipped or unequipped stake in the backend world
 */
public class Stake extends Item {
    
    /**
     * Contructor for stake
     * 
     * @param x
     * @param y
     */
    public Stake(SimpleIntegerProperty x, SimpleIntegerProperty y) {
        super(x, y);
    }

    /**
     * Use item in battle
     */
    @Override
    public void useItem(Character character) {
        int attack = character.getAttack();
        character.setAttack(attack - 3);
        attack = character.getAttack();
    }

    /**
     * use effect of stake
     * 
     * @param character
     * @param enemy
     */
    public void useStakeEffect(Character character, BasicEnemy enemy) {
        int attack = character.getAttack();
        if (enemy instanceof Vampire) {
            character.setAttack(attack + 8);
        } else {
            character.setAttack(attack - 3);
        }
    }

    /**
     * Get cost of item
     * 
     * @return 150
     */
    @Override
    public int getCost() {
        return 150;
    }    
    
}
