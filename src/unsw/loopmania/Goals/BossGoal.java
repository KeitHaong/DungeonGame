package unsw.loopmania.Goals;

import unsw.loopmania.LoopManiaWorld;

import java.util.List;

import unsw.loopmania.Character;

import unsw.loopmania.Enemies.BasicEnemy;
import unsw.loopmania.Enemies.ElanMuske;
import unsw.loopmania.Enemies.Doggie;

public class BossGoal extends Goal {
    private boolean satisfied;

    /**
     * Constructor
     * @param world
     */
    public BossGoal(LoopManiaWorld world) {
        super(world);
    }

    /**
     * Updates Boss goals
     */
    @Override
    public void update(Character character, LoopManiaWorld world) {
        boolean ElanMuskeDefeated = false;
        boolean DoggieDefeated = false;
        List<BasicEnemy> EnemiesDefeated = world.allEnemiesDeafeated;
        for (BasicEnemy e : EnemiesDefeated) {
            if (e instanceof ElanMuske) {
                ElanMuskeDefeated = true;
            }
            if (e instanceof Doggie) {
               DoggieDefeated = true;
            }
        }
        if (ElanMuskeDefeated && DoggieDefeated) {
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
     * If subgoals fulfilled
     */
    @Override
    public boolean hasSubGoals() {
        return false;
    }

}
