package unsw.loopmania.AllBuildings;

import java.util.List;

import javafx.beans.property.SimpleIntegerProperty;
import unsw.loopmania.Enemies.BasicEnemy;
import unsw.loopmania.Character;
import org.javatuples.Pair;

public class Trap extends Buildings {
    private int damage = 40;

    /**
     * Constructor
     * @param x
     * @param y
     */
    public Trap(SimpleIntegerProperty x, SimpleIntegerProperty y) {
        super(x, y);
    }

    /**
     * Destroys enemy
     */
    @Override
    public Object BattleState(Character character, BasicEnemy enemies) {
        enemies.setHealth(enemies.getHealth() - damage);
        return null;
    }

    /**
     * No attributes
     */
    @Override
    public BasicEnemy InitialState(Character character, List<Pair<Integer, Integer>> orderedPath) {
        return null;
    }

    /**
     * No attribute
     */
    @Override
    public Object NeutralState(Character character) {
        return null;
    }
    
}
