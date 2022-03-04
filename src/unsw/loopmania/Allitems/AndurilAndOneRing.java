package unsw.loopmania.Allitems;
import unsw.loopmania.Character;

import javafx.beans.property.SimpleIntegerProperty;

public class AndurilAndOneRing extends RareItemDecorator {
    private TheOneRing ring;
    private Anduril anduril;
    
    /**
     * Contains anduril and one ring
     * @param x
     * @param y
     */
    public AndurilAndOneRing(SimpleIntegerProperty x, SimpleIntegerProperty y) {
        super(x, y);
        ring = new TheOneRing(null, null);
        anduril = new Anduril(null, null);
    }
    
    /**
     * Use items. One ring first.
     */
    @Override
    public void useItem(Character character) {
        ring.useItem(character);
        anduril.useItem(character);
    }

    /**
     * Return cost
     */
    @Override
    public int getCost() {
        return ring.getCost() + anduril.getCost();
    }

}
