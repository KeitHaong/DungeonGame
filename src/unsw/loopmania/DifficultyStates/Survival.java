package unsw.loopmania.DifficultyStates;

import unsw.loopmania.Item;
import unsw.loopmania.Allitems.HealthPotion;

public class Survival implements DifficultyStates {
    private int potioncap;
    private int potions_purchased;

    /**
     * Potion cap. 1 potion only
     */
    public Survival() {
        this.potioncap = 1;
        this.potions_purchased = 0;
    }

    /**
     * Checks if item is purchaseable. 
     */
    public Boolean purchasable(Item item) {
        if (item instanceof HealthPotion) {
            if (potions_purchased < potioncap) {
                this.potions_purchased =+ 1;
                return true;
            } else {
                return false;
            }
        }
        return true;
    }

    /**
     * Resets the item ceiling
     */
    @Override
    public void resetpurchases() {
        this.potions_purchased = 0;   
    }
}
