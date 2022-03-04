package unsw.loopmania.DifficultyStates;

import unsw.loopmania.Item;

public class Difficulty {
    private DifficultyStates difficulty;

    /**
     * Set difficulties. 
     * @param difficulty
     */
    public Difficulty(DifficultyStates difficulty) {
        this.difficulty = difficulty;
    }

    /**
     * Standard mode is the default
     */
    public Difficulty() {
        this(new Standard());
    }

    //If the item can be purchased via the difficulty
    public Boolean purchase_allowed(Item entity) {
        return difficulty.purchasable(entity);
    }

    //Reset purchases
    public void resetPurchases() {
        difficulty.resetpurchases();
    }

    //set new difficulty
    public void setNewDifficulty(DifficultyStates difficulty) {
        this.difficulty = difficulty;
    }

    //get diffculty
    public DifficultyStates getDifficulty() {
        return difficulty;
    }

    
}
