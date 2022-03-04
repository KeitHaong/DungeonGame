package unsw.loopmania.Goals;

import java.util.ArrayList;

import unsw.loopmania.LoopManiaWorld;
import unsw.loopmania.Character;

/**
 * Goals to achieve. If all goals achieved then game is won.
 */
public abstract class Goal {
    private LoopManiaWorld world;
    private int quantity;
    private boolean satisfied;

    public Goal(LoopManiaWorld world) {
        this.quantity = quantity;
        this.world = world;
        this.satisfied = false;
    }

    public LoopManiaWorld getWorld() {
        return world;
    }
    
    public abstract boolean isSatisfied(Character character, LoopManiaWorld world);

    public abstract void setSatisfied(boolean bool);

    public abstract boolean getSatisfied();

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getQuantity() {
        return quantity;
    }

    public abstract boolean hasSubGoals();

    public void addSubGoal(Goal g) { }

    public ArrayList<Goal> getSubGoals() { 
        return null;
    }

    public abstract void update(Character character, LoopManiaWorld world);

}