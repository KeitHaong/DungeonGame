package unsw.loopmania.Cards;

import javafx.beans.property.SimpleIntegerProperty;
import unsw.loopmania.Card;
import unsw.loopmania.AllBuildings.Barracks;
import unsw.loopmania.AllBuildings.Buildings;

public class BarrackCard extends Card {
    private Barracks barrack; 

    /**
     * Constructor for barracks
     * @param x
     * @param y
     */
    public BarrackCard(SimpleIntegerProperty x, SimpleIntegerProperty y) {
        super(x, y);
        Barracks barrack = new Barracks(x, y);
        this.barrack = barrack;
    }
    
    /**
     * Retunrs barracks card
     */
    @Override
    public Buildings getBuilding() {
        return barrack;
    }
    
    
}