package unsw.loopmania.AllBuildings;

import java.util.List;

import javafx.beans.property.SimpleIntegerProperty;
import org.javatuples.Pair;
import unsw.loopmania.Enemies.BasicEnemy;
import unsw.loopmania.Character;
import unsw.loopmania.StaticEntity;

public abstract class Buildings extends StaticEntity {
    public Buildings(SimpleIntegerProperty x, SimpleIntegerProperty y) {
        super(x, y);
    }

    /**
     * Battle state returns methods if in battle
     * @param character
     * @param enemies
     * @return
     */
    abstract public Object BattleState(Character character, BasicEnemy enemies);
    /**
     * If initially building has a method. Initial is at spawn (hero castle)
     * @param character
     * @param orderedPath
     * @return
     */
    abstract public BasicEnemy InitialState(Character character, List<Pair<Integer, Integer>> orderedPath);
    /**
     * Neutral state. Method if chararacter walks pass building.
     * @param character
     * @return
     */
    abstract public Object NeutralState(Character character);

}
