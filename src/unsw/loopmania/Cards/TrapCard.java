package unsw.loopmania.Cards;

import javafx.beans.property.SimpleIntegerProperty;
import unsw.loopmania.Card;
import unsw.loopmania.AllBuildings.Buildings;
import unsw.loopmania.AllBuildings.Trap;

public class TrapCard extends Card{
    private Trap trap;

    /**
     * Constructor for trapcard
     * @param x
     * @param y
     */
    public TrapCard(SimpleIntegerProperty x, SimpleIntegerProperty y) {
        super(x, y);
        this.trap = new Trap(x,y);
    }

    /**
     * Returns building
     */
    @Override
    public Buildings getBuilding() {
        return trap;
    }

    
}
