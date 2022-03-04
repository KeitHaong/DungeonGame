package unsw.loopmania.Cards;

import javafx.beans.property.SimpleIntegerProperty;
import unsw.loopmania.Card;
import unsw.loopmania.AllBuildings.Buildings;
import unsw.loopmania.AllBuildings.Tower;

public class TowerCard extends Card{
    private Tower tower;

    /**
     * Constructor for tower
     * @param x
     * @param y
     */
    public TowerCard(SimpleIntegerProperty x, SimpleIntegerProperty y) {
        super(x, y);
        this.tower = new Tower(x, y);
    }

    /**
     * Returns tower card
     */
    @Override
    public Buildings getBuilding() {
        return tower;
    }
    
}
