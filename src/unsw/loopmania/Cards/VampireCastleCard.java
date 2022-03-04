package unsw.loopmania.Cards;

import javafx.beans.property.SimpleIntegerProperty;
import unsw.loopmania.Card;
import unsw.loopmania.AllBuildings.Buildings;
import unsw.loopmania.AllBuildings.VampireCastle;

public class VampireCastleCard extends Card{
    private VampireCastle vampire;

    /**
     * Constructor for vampirecastle
     * @param x
     * @param y
     */
    public VampireCastleCard(SimpleIntegerProperty x, SimpleIntegerProperty y) {
        super(x, y);
        this.vampire = new VampireCastle(x, y);
    }

    /**
     * Returns vampire castle
     */
    @Override
    public Buildings getBuilding() {
        return vampire;
    }
    
}
