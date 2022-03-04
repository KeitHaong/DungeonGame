package unsw.loopmania.Cards;

import javafx.beans.property.SimpleIntegerProperty;
import unsw.loopmania.Card;
import unsw.loopmania.AllBuildings.Buildings;
import unsw.loopmania.AllBuildings.Village;

public class VillageCard extends Card{
    private Village village;

    /**
     * Constructor for village
     * @param x
     * @param y
     */
    public VillageCard(SimpleIntegerProperty x, SimpleIntegerProperty y) {
        super(x, y);
        this.village = new Village(x, y);
    }

    /**
     * Returns card of village
     */
    @Override
    public Buildings getBuilding() {
        return village;
    }
    
}
