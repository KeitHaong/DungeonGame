package unsw.loopmania.AllBuildings;

import java.util.List;

import javafx.beans.property.SimpleIntegerProperty;
import unsw.loopmania.Enemies.BasicEnemy;
import unsw.loopmania.Enemies.Zombie;
import unsw.loopmania.Character;
import unsw.loopmania.PathPosition;
import unsw.loopmania.Spawn;

import org.javatuples.Pair;

public class ZombiePit extends Buildings {
    /**
     * Constructor for Zombie
     * @param x
     * @param y
     */
    public ZombiePit(SimpleIntegerProperty x, SimpleIntegerProperty y) {
        super(x, y);
    }

    /**
     * No attributes in neutral state
     */
    @Override
    public Object NeutralState(Character character) {
        return null;
    }

    /**
     * No attributes in battle
     */
    @Override
    public Object BattleState(Character character, BasicEnemy enemies) {
        return null;
    }

    /**
     * Spawns a zombie in the initial state
     */
    @Override
    public BasicEnemy InitialState(Character character, List<Pair<Integer, Integer>> orderedPath) {
        Spawn spawn = new Spawn();
        int index = spawn.NearBuilding(orderedPath, getX(), getY());

        BasicEnemy enemy = new Zombie(new PathPosition(index, orderedPath));
        return enemy;
    }

}
