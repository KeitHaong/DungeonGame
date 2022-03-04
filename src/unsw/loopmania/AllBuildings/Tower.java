package unsw.loopmania.AllBuildings;

import java.util.List;

import javafx.beans.property.SimpleIntegerProperty;
import org.javatuples.Pair;
import unsw.loopmania.Enemies.BasicEnemy;
import unsw.loopmania.Character;

public class Tower extends Buildings {
    private int battleRadius = 3;
    private int towerDamage = 20;

    /**
     * Constructor for Tower
     * @param x
     * @param y
     */
    public Tower(SimpleIntegerProperty x, SimpleIntegerProperty y) {
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
     * Damages enemies
     */
    @Override
    public Object BattleState(Character character, BasicEnemy enemies) {
        enemies.setHealth(enemies.getHealth() - towerDamage);
        return null;
    }
    

    /**
     * Get radius
     * @return
     */
    public int campfireRadius() {
        return battleRadius;
    }

    /**
     * Checks valid radius
     * @param character
     * @param building
     * @param enemy
     * @return
     */
    public boolean checkInBattleRadius(Character character, Buildings building, BasicEnemy enemy) {
        boolean inradius = false;
        if (Math.pow((character.getX() - building.getX()), 2) + Math.pow((character.getY() - building.getY()), 2) < Math
                .pow(battleRadius, 2)) {
            if (Math.pow((enemy.getX() - building.getX()), 2) + Math.pow((enemy.getY() - building.getY()), 2) < Math
                .pow(battleRadius, 2)) {
                inradius = true;
            }
        }
        return inradius;
    }
}
