package unsw.loopmania.Goals;

import unsw.loopmania.LoopManiaWorld;

import unsw.loopmania.Character;

public class ExperienceGoal extends Goal {
    private int quantity;
    private boolean satisfied;

    /**
     * Constructor
     * @param world
     */
    public ExperienceGoal(LoopManiaWorld world) {
        super(world);
    }

    /**
     * Update gold goals
     */
    @Override
    public void update(Character character, LoopManiaWorld world) {
        int requiredExperience = getQuantity();
        int experience = character.getExperience();
        if (experience >= requiredExperience) {
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