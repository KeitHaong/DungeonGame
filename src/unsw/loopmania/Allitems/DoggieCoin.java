package unsw.loopmania.Allitems;

import java.util.Random;
import java.lang.Math;
import javafx.beans.property.SimpleIntegerProperty;
import unsw.loopmania.Character;
import unsw.loopmania.Item;

/**
 * represents DoggieCoin in the backend world
 */
public class DoggieCoin extends Item {
    private int cost = 1500;
    private Random rand;

    /**
     * Contructor for Doggie coin
     * 
     * @param x
     * @param y
     */
    public DoggieCoin(SimpleIntegerProperty x, SimpleIntegerProperty y) {
        super(x, y);
        this.rand = new Random();
    }

    /**
     * Set random seed
     * @param seed
     */
    public void setRandom(long seed) {
        rand = new Random(seed);
    }

    /**
     * Use item in battle
     * 
     * @return
     */
    @Override
    public void useItem(Character character) {
        return;
    }   

    /**
     * Sets cost of item
     * 
     */
    public void setCost(int cost) {
        this.cost = cost;
    }

    /**
     * Gets randomly generated cost of doggie coin
     * 
     * @return cost
     */
    @Override
    public int getCost() {
        return cost;
    }
    public int getCost1() {
        int cost = 4 + (rand).nextInt(150);
        this.cost = cost;
        return cost;
    }

    /** 
     * Plummets cost of doggie coin
    */
    public void Plummet(Character character) {
        int cost = getCost1();
        cost = (int) Math.round(cost * 0.4);
        character.setDoggiePrice(cost);
    }
    
    /**
     * Increases cost of doggie coin
     */
    public void Increase(Character character) {
        int cost = getCost1();
        cost = cost * 50;
        character.setDoggiePrice(cost);
    }

    public void Flucuate(Character character) {
        character.setDoggiePrice(getCost1());
    }
}
