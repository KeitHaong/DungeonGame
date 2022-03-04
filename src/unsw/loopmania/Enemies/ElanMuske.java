package unsw.loopmania.Enemies;

import java.util.Random;
import unsw.loopmania.PathPosition;

/**
 * a Boss
 */
public class ElanMuske extends BasicEnemy {
    private int health = 600;
    private int damage = 40;
    private int battleRadius = 1;
    private int supportRadius = 1;


    public ElanMuske(PathPosition position) {
        super(position);
    }

    /**
     * move the enemy
     */
    @Override
    public void move() {
        // moveUpPath();
        int directionChoice = (new Random()).nextInt(2);
        if (directionChoice == 0) {
            moveUpPath();
        } else if (directionChoice == 1) {
            moveDownPath();
        }
    }

    @Override
    public int getCriticalDamage() {
        return damage;
    }

    @Override
    public void setHealth(int health) {
        this.health = health;
    }

    @Override
    public void setDamage(int damage) {
        this.damage = damage;
    }

    @Override
    public void setBattleRadius(int battleRadius) {
        this.battleRadius = battleRadius;
    }

    @Override
    public void setSupportRadius(int supportRadius) {
        this.supportRadius = supportRadius;
    }

    @Override
    public int getHealth() {
        return health;
    }

    @Override
    public int getDamage() {
        return damage;
    }

    @Override
    public int getBattleRadius() {
        return battleRadius;
    }

    @Override
    public int getSupportRadius() {
        return supportRadius;
    }
    
    @Override
    public int getMaxHealth() {
        return health;
    }
}
