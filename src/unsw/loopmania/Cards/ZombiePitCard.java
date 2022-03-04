package unsw.loopmania.Cards;

import javafx.beans.property.SimpleIntegerProperty;
import unsw.loopmania.Card;
import unsw.loopmania.AllBuildings.Buildings;
import unsw.loopmania.AllBuildings.ZombiePit;

public class ZombiePitCard extends Card {
    private ZombiePit zombiepit;

    /**
     * Constructor for zombiepit
     * @param x
     * @param y
     */
    public ZombiePitCard(SimpleIntegerProperty x, SimpleIntegerProperty y) {
        super(x, y);
        this.zombiepit = new ZombiePit(x, y);
    }

    /**
     * Returns zombiepitcard
     */
    @Override
    public Buildings getBuilding() {
        return zombiepit;
    }

    
}
