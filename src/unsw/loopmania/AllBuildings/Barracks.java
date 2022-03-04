package unsw.loopmania.AllBuildings;

import java.util.List;

import javafx.beans.property.SimpleIntegerProperty;
import org.javatuples.Pair;
import unsw.loopmania.Ally;
import unsw.loopmania.Enemies.BasicEnemy;

import unsw.loopmania.Character;

public class Barracks extends Buildings {
    /**
     * Barracks
     * @param x
     * @param y
     */
    public Barracks(SimpleIntegerProperty x, SimpleIntegerProperty y) {
        super(x, y);
    }

    /**
     * No method
     */
    @Override
    public Object BattleState(Character character, BasicEnemy enemies) {
        return null;
    }

    /**
     * No method
     */
    @Override
    public BasicEnemy InitialState(Character character, List<Pair<Integer, Integer>> orderedPath) {
        return null;
    }

    /**
     * Returns new ally
     */
    @Override
    public Object NeutralState(Character character) {
        Ally ally = new Ally();
        return ally;
    }

    
}
