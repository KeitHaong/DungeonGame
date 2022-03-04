package unsw.loopmania.AllBuildings;

import java.util.List;

import javafx.beans.property.SimpleIntegerProperty;
import org.javatuples.Pair;
import unsw.loopmania.Enemies.BasicEnemy;
import unsw.loopmania.Character;

public class Campfire extends Buildings {
    private int campfireRadius = 2; 

    /**
     * Campfire
     * @param x
     * @param y
     */
    public Campfire(SimpleIntegerProperty x, SimpleIntegerProperty y) {
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
     * Doubles attack
     */
    @Override
    public Object NeutralState(Character character) {
        character.setAttack(character.getAttack() * 2);
        return null;
    }

    /**
     * Get radius
     * @return
     */
    public int campfireRadius() {
        return campfireRadius;
    }
    
    /**
     * Returns valid radius
     * @param character
     * @param building
     * @return
     */
    public boolean checkInCampRadius(Character character, Buildings building) {
        boolean inradius = false;
        if (Math.pow((character.getX() - building.getX()), 2) + Math.pow((character.getY() - building.getY()), 2) < Math
                .pow(campfireRadius, 2)) {
            inradius = true;
        }
        return inradius;
    }
    
}
