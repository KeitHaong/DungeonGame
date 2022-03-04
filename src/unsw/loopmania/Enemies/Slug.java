package unsw.loopmania.Enemies;

import java.util.Random;
import unsw.loopmania.PathPosition;


/**
 * a basic form of enemy in the world
 */
public class Slug extends BasicEnemy {
    private int health = 40;
    private int damage = 8;
    private int battleRadius = 1; 
    private int supportRadius = 1;
    private int Maxhealth = 40;


    public Slug(PathPosition position) {
        super(position);
    }

    /**
     * move the enemy
     */
    @Override
    public void move(){
        //moveUpPath();
        int directionChoice = (new Random()).nextInt(2);
        if (directionChoice == 0){
            moveUpPath();
        }
        else if (directionChoice == 1){
            moveDownPath();
        }
    }
    
    @Override
    public boolean deBuff(int debuffChance) {
        return false;
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
        return Maxhealth;
    }
}
