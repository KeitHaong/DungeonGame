package unsw.loopmania.DifficultyStates;

import unsw.loopmania.Item;

public interface DifficultyStates {
    /**
     * Depending on difficulties items will vary
     * @param item
     * @return
     */
    public Boolean purchasable(Item item);
    /**
     * resets purchases
     */
    public void resetpurchases();
}
