package unsw.loopmania.Goals;

import unsw.loopmania.LoopManiaWorld;
import unsw.loopmania.Character;

public class GoldGoal extends Goal {
    private int quantity;
    private boolean satisfied;

    /**
     * 
     * @param world
     */
    public GoldGoal(LoopManiaWorld world) {
        super(world);
    }

    /**
     * Update gold
     */
    @Override
    public void update(Character character, LoopManiaWorld world) {
        int requiredGold = getQuantity();
        int gold = character.getGold();
        if (gold >= requiredGold) {
            setSatisfied(true);
        } else {
            setSatisfied(false);
        }
    }

    /**
     * If satisfied
     */
    @Override
    public boolean isSatisfied(Character character, LoopManiaWorld world) {
        update(character, world);
        return satisfied;
    }

    /**
     * Set satisfied
     */
    @Override
    public void setSatisfied(boolean bool) {
        this.satisfied = bool;
    }   

    /**
     * Get satisfied
     */
    @Override   
    public boolean getSatisfied() {
		return satisfied;
	}

    /**
     * Set quantity
     */
    @Override
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    /**
     * Get quantity
     */
    @Override
    public int getQuantity() {
        return quantity;
    }   

    /**
     * No subgoals
     */
    @Override
    public boolean hasSubGoals() {
        return false;
    }

}
