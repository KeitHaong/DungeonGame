package unsw.loopmania.DifficultyStates;

import unsw.loopmania.Item;

public class Confusing implements DifficultyStates{

    /**
     * No item restrictions. Any item purchaseable.
     */
    @Override
    public Boolean purchasable(Item item) {
        return true;
    }

    /**
     * Does nothing
     */
    @Override
    public void resetpurchases() {
        return;
    }
    
}
