package unsw.loopmania.AllBuildings;

import java.util.List;

import javafx.beans.property.SimpleIntegerProperty;
import org.javatuples.Pair;
import unsw.loopmania.Enemies.BasicEnemy;
import unsw.loopmania.Character;

public class HeroCastle extends Buildings{

    /**
     * 
     * @param x
     * @param y
     */
    public HeroCastle(SimpleIntegerProperty x, SimpleIntegerProperty y) {
        super(x, y);
    }

    /**
     * No method
     */
    @Override
    public BasicEnemy InitialState(Character character, List<Pair<Integer, Integer>> orderedPath) {
        return null;
    }

    /**
     * No method
     */
    @Override
    public Object NeutralState(Character character) {
        return null;
    }

    /**
     * No method
     */
    @Override
    public Object BattleState(Character character, BasicEnemy enemies) {
        return null;
    }
    
    
}