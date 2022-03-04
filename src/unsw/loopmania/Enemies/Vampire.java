package unsw.loopmania.Enemies;

import java.util.Random;
import unsw.loopmania.PathPosition;


/**
 * a basic form of enemy in the world
 */
public class Vampire extends BasicEnemy {
    private int health = 80;
    private int damage = 18;
    private int battleRadius = 2;
    private int supportRadius = 3;
    private int criticalDamage = 25;
    private int Maxhealth = 80;
    
    public Vampire(PathPosition position) {
        super(position);
    }

    /**
     * move the enemy
     */
    @Override
    public void move(){

        int directionChoice = (new Random()).nextInt(2);
        if (directionChoice == 0){
            moveUpPath();
        }
        else if (directionChoice == 1){
            moveDownPath();
        }
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
    public int getCriticalDamage() {
        return criticalDamage;
    }
    
    @Override
    public int getMaxHealth() {
        return Maxhealth;
    }
}
