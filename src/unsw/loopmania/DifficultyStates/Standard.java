package unsw.loopmania.DifficultyStates;

import unsw.loopmania.Item;

public class Standard implements DifficultyStates {

    /**
     * No item limit
     */
    @Override
    public Boolean purchasable(Item item) {
        return true;
    }

    /**
     * Do nothing
     */
    @Override
    public void resetpurchases() {
       return;  
    }
    
}
