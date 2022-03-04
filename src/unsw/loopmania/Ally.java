package unsw.loopmania;

public class Ally {
    private int health = 50;
    private int attack = 8;
    /**
     * 
     * @param health
     */
    public void setHealth(int health) {
        this.health = health;
    }
    
    /**
     * 
     * @param attack
     */
    public void setAttack(int attack) {
        this.attack = attack;
    }
    
    /**
     * 
     * @return
     */
    public int getHealth() {
        return health;
    }
    
    /**
     * 
     * @return
     */
    public int getAttack() {
        return attack;
    }
}
