package unsw.loopmania.DifficultyStates;

import unsw.loopmania.Item;
import unsw.loopmania.Allitems.Armour;
import unsw.loopmania.Allitems.Helmet;
import unsw.loopmania.Allitems.Shield;

public class Berserker implements DifficultyStates {
    private int item_ceiling;
    private int item_purchased;

    /**
     * 1 purchases only for restricted items
     */
    public Berserker() {
        this.item_ceiling = 1;
    }

    /**
     * Armour, helmet, shield's are restricted items.
     */
    @Override
    public Boolean purchasable(Item item) {
        if (item instanceof Armour || item instanceof Helmet || item instanceof Shield) {
            if (item_purchased < item_ceiling) { 
                this.item_purchased = 1;
                return true;
            } else {
                return false;
            }
        } 
        return true;
    }

    /**
     * Reset the item ceiling
     */
    @Override
    public void resetpurchases() {
        this.item_purchased = 0;
    }
    
}
