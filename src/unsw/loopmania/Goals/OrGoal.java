
package unsw.loopmania.Goals;

import unsw.loopmania.LoopManiaWorld;

import java.util.ArrayList;

import unsw.loopmania.Character;

public class OrGoal extends Goal {
    private boolean satisfied;
    private ArrayList<Goal> subGoals = new ArrayList<Goal>();

    /**
     * 
     * @param world
     */
    public OrGoal(LoopManiaWorld world) {
        super(world);
    }
    
    /**
     * Update 
     */
    @Override
    public void update(Character character, LoopManiaWorld world) {
        setSatisfied(false);
        for(Goal s : subGoals) {
            s.update(character, world);
            if (s.getSatisfied()) {
                setSatisfied(true);
            }
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
     * Subgoals exist
     */
    @Override
    public boolean hasSubGoals() {
        return true;
    }

    /**
     * Add subgoals
     */
    @Override
    public void addSubGoal(Goal g) {
        subGoals.add(g);
    }

    /**
     * Get subgoals
     */
    @Override
    public ArrayList<Goal> getSubGoals() {
        return subGoals;
    }
}