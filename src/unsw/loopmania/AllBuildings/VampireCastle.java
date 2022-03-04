package unsw.loopmania.AllBuildings;

import java.util.List;

import javafx.beans.property.SimpleIntegerProperty;
import org.javatuples.Pair;
import unsw.loopmania.Enemies.BasicEnemy;
import unsw.loopmania.Enemies.Vampire;
import unsw.loopmania.Character;
import unsw.loopmania.PathPosition;
import unsw.loopmania.Spawn;

public class VampireCastle extends Buildings {
    /**
     * Constructor
     * @param x
     * @param y
     */
    public VampireCastle(SimpleIntegerProperty x, SimpleIntegerProperty y) {
        super(x, y);
    }

    /**
     * Spawns a vampire at eveyr 3 cycles
     */
    @Override
    public BasicEnemy InitialState(Character character, List<Pair<Integer, Integer>> orderedPath) {
        Spawn spawn = new Spawn();
        int index = spawn.NearBuilding(orderedPath, getX(), getY());

        if (character.getCycle() >= 3 && (character.getCycle() % 3) == 0) {
            PathPosition pos = new PathPosition(index, orderedPath);
            BasicEnemy vampire = new Vampire(pos);
            return vampire;
        } else {
            return null;
        }
    }

    /**
     * No methods
     */
    @Override
    public Object NeutralState(Character character) {
        return null;
    }

    /**
     * No methods
     */
    @Override
    public Object BattleState(Character character, BasicEnemy enemies) {
        return null;
    }

    
}
