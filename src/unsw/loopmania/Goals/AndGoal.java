package unsw.loopmania.Goals;

import unsw.loopmania.LoopManiaWorld;

import java.util.ArrayList;

import unsw.loopmania.Character;


public class AndGoal extends Goal {
    private boolean satisfied;
    private ArrayList<Goal> subGoals = new ArrayList<Goal>();

    /**
     * 
     * @param world
     */
    public AndGoal(LoopManiaWorld world) {
        super(world);
    }
    
    /**
     * update
     */
    @Override
    public void update(Character character, LoopManiaWorld world) {
       setSatisfied(true);
        for(Goal s : subGoals) {
            s.update(character, world);
            if (! s.getSatisfied()) {
                setSatisfied(false);
            }
        }        
    }

    /**
     * getter
     */
    @Override
    public boolean isSatisfied(Character character, LoopManiaWorld world) {
        update(character, world);
        return satisfied;
    }

    /**
     * if completed
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
     * Subgoal
     */
    @Override
    public void addSubGoal(Goal g) {
        subGoals.add(g);
    }

    /**
     * If subgoals exist
     */
    @Override
    public boolean hasSubGoals() {
        return true;
    }


}