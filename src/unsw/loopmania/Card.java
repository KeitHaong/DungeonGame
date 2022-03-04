package unsw.loopmania;

import javafx.beans.property.SimpleIntegerProperty;
import unsw.loopmania.AllBuildings.Buildings;

/**
 * a Card in the world
 * which doesn't move
 */
abstract public class Card extends StaticEntity {
    public Card(SimpleIntegerProperty x, SimpleIntegerProperty y) {
        super(x, y);
    }

    abstract public Buildings getBuilding();
    //abstract public Item getItem();
}
