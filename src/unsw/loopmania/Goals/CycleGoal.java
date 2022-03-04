package unsw.loopmania.Goals;

import unsw.loopmania.LoopManiaWorld;

import unsw.loopmania.Character;

public class CycleGoal extends Goal {
    private int quantity;
    private boolean satisfied;

    /**
     * 
     * @param world
     */
    public CycleGoal(LoopManiaWorld world) {
        super(world);
    }

    /**
     * Updates cycle
     */
    @Override
    public void update(Character character, LoopManiaWorld world) {
        int requiredCycles = getQuantity();
        int cycles = character.getCycle();
        if (cycles >= requiredCycles) {
            setSatisfied(true);
        } else {
            setSatisfied(false);
        }
    }

    /**
     * Gets if goals satisfied
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
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    /**
     * @return
     */
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
