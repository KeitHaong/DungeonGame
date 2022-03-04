package unsw.loopmania.AllBuildings;

import java.util.List;

import javafx.beans.property.SimpleIntegerProperty;
import org.javatuples.Pair;
import unsw.loopmania.Enemies.BasicEnemy;
import unsw.loopmania.Character;

public class Village extends Buildings{
    /**
     * Village constructor
     * @param x
     * @param y
     */
    public Village(SimpleIntegerProperty x, SimpleIntegerProperty y) {
        super(x, y);
    }

    /**
     * Does nothing in battle
     */
    @Override
    public Object BattleState(Character character, BasicEnemy enemies) {
        return null;
    }

    /**
     * Nothing in initial 
     */
    @Override
    public BasicEnemy InitialState(Character character, List<Pair<Integer, Integer>> orderedPath) {
        return null;
    }

    /**
     * Increases health
     */
    @Override
    public Object NeutralState(Character character) {
        character.setHealth(character.getHealth() + 10);
        return null;
    }
    
}
