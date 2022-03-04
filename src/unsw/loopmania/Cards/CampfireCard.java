package unsw.loopmania.Cards;

import javafx.beans.property.SimpleIntegerProperty;
import unsw.loopmania.Card;
import unsw.loopmania.AllBuildings.Buildings;
import unsw.loopmania.AllBuildings.Campfire;

public class CampfireCard extends Card {
    private Campfire campfire;

    /**
     * Constructor for campfire
     * @param x
     * @param y
     */
    public CampfireCard(SimpleIntegerProperty x, SimpleIntegerProperty y) {
        super(x, y);
        Campfire campfire = new Campfire(y, y);
        this.campfire = campfire;
    }   

    /**
     * Returns campfire
     */
    @Override
    public Buildings getBuilding() {
        return campfire;
    }
    
}
