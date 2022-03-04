package unsw.loopmania;

/**
 * represents the main character in the backend of the game world
 */
public class Character extends MovingEntity {
    private int health = 350;
    private int cycle;
    private int cycle_shop = 1;
    private int experience = 0;
    private int gold = 0;
    private int doggieCoin = 0;
    private int doggiePrice = 1000;
    private int inventory = 0;
    private int card = 0;
    private int attack = 10;
    private int default_attack = 10;
    private int battleRadius = 1;
    private int maxHealth = 350;
    private int bossDamage = attack*3;
    private int bossDefence = maxHealth*2;

    /**
     * Constructor. Set cycle to 1
     * @param position
     */
    public Character(PathPosition position) {
        super(position);
        this.cycle = 1;
    }
    
    /**
     * Resets the attack
     */
    public void reset() {
        this.attack = default_attack;
    }

    /**
     * Increases the cycle by 1
     */
    public void setCycle() {
        this.cycle += 1;
    }

    /**
     * If at a valid cycle returns true to launch the shop
     * @return
     */
    public Boolean ifMenu() {
        if (cycle == cycle_shop) {
            this.cycle_shop = cycle + cycle_shop + 1;
            setCycle();
            return true;
        }
        setCycle();
        return false;
    }
    
    /**
     * Set health
     * @param health
     */
    public void setHealth(int health) {
        this.health = health;
    } 

    /**
     * Set Experience
     * @param experience
     */
    public void setExperience(int experience) {
        this.experience = experience;
    }
    
    /**
     * Set Gold
     * @param gold
     */
    public void setGold(int gold) {
        this.gold = gold;
    }
    
    /**
     * Sets doggie
     * @param doggieCoin
     */
    public void setDoggieCoin(int doggieCoin) {
        this.doggieCoin = doggieCoin;
    }
    
    /**
     * Get doggie price
     * @param inventory
     */

    public int getDoggiePrice() {
        return doggiePrice;
    }
    
    public void setDoggiePrice(int doggiePrice) {
        this.doggiePrice = doggiePrice;
    }

    /**
     * Set inventory (equipped items)
     * @param inventory
     */
    public void setInventorySlot(int inventory) {
        this.inventory = inventory;
    }
    

    /**
     * Set number of cards
     * @param card
     */
    public void setNumberOfCards(int card) {
        this.card = card;
    }
    
    /**
     * Set attack
     * @param attack
     */
    public void setAttack(int attack) {
        this.attack = attack;
    }
    
    /**
     * Set attack
     * 
     * @param maxHealth
     */
    public void setMaxHealth(int maxHealth) {
        this.maxHealth = maxHealth;
    }

    /**
     * Set battle radius
     * @param battleRadius
     */
    public void setBattleRadius(int battleRadius) {
        this.battleRadius = battleRadius;
    }

    /**
     * return cycle
     * @return
     */
    public int getCycle() {
        return cycle;
    }

    /**
     * return health
     * @return
     */
    public int getHealth() {
        return health;
    }
    
    /**
     * return experience
     * @return
     */
    public int getExperience() {
        return experience;
    }
    
    /**
     * return gold
     * @return
     */
    public int getGold() {
        return gold;
    }
    
    /**
     * return doggieCoin
     * @return
     */
    public int getDoggieCoin() {
        return doggieCoin;
    }
    
    /**
     * Return inventory
     * @return
     */
    public int getInventorySlot() {
        return inventory;
    }
    
    /**
     * return number of cards
     * @return
     */
    public int getNumberOfCards() {
        return card;
    }

    /**
     * return attack
     * @return
     */
    public int getAttack() {
        return attack;
    }
     
    /**
     * return battle radius
     * @return
     */
    public int getBattleRadius() {
        return battleRadius;
    }
    
    /**
     * Return max health possible
     * @return
     */
    public int getMaxHealth() {
        return maxHealth;
    }
    
    /**
     * return boss attack damage 
     * @return
     */
    public int getBossDamage() {
        return bossDamage;
    }
    
    /**
     * return boss defemce
     * @return
     */
    public int getBossDefence() {
        return bossDefence;
    }
}
