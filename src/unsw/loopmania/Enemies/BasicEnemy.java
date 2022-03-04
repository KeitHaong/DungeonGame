package unsw.loopmania.Enemies;

import java.util.Random;
import javafx.beans.property.SimpleIntegerProperty;
import unsw.loopmania.MovingEntity;
import unsw.loopmania.PathPosition;


/**
 * a basic form of enemy in the world
 */
public abstract class BasicEnemy extends MovingEntity {
    private static int strikeChance = 3;
    private int debuffChance = 3;
    public BasicEnemy(PathPosition position) {
        super(position);
    }

    /**
     * move the enemy
     */
    public void move(){
        // this basic enemy moves in a random direction... 25% chance up or down, 50% chance not at all...
        int directionChoice = (new Random()).nextInt(2);
        if (directionChoice == 0){
            moveUpPath();
        }
        else if (directionChoice == 1){
            moveDownPath();
        }
    }

    /**
     * Debuff enemy
     * @param debuffChance
     * @return
     */
    public boolean deBuff(int debuffChance) {
        Random r = new Random();
        int low = 1;
        int high = debuffChance;
        int result = r.nextInt(high - low) + low;
        if (result == 1) {
            return true;
        }
        return false;
    }

    /**
     * 
     * @return
     */
    public int getStrikeChance() {
        return strikeChance;
    }

    /**
     * 
     * @return
     */
    public int getDebuffChance() {
        return debuffChance;
    }
    
    /**
     * 
     * @param debuffChance
     */
    public void setDebuffChance(int debuffChance) {
        this.debuffChance = debuffChance;
    }


    /**
     * Getters and setters
     * @return
     */
    abstract public int getHealth();
    abstract public int getDamage();
    abstract public int getBattleRadius();
    abstract public int getSupportRadius();
    abstract public int getCriticalDamage();
    abstract public void setHealth(int health);
    abstract public void setDamage(int damage);
    abstract public void setBattleRadius(int battleRadius);  
    abstract public void setSupportRadius(int battleRadius);
    abstract public int getMaxHealth();
    
 
}
