package unsw.loopmania.Allitems;

import javafx.beans.property.SimpleIntegerProperty;
import unsw.loopmania.Character;

public class OneRingAndAnduril extends RareItemDecorator {
    private TheOneRing ring;
    private Anduril anduril;
    
    /**
     * Constructor. Contains one ring and anduril
     * @param x
     * @param y
     */
    public OneRingAndAnduril(SimpleIntegerProperty x, SimpleIntegerProperty y) {
        super(x, y);
        ring = new TheOneRing(null, null);
        anduril = new Anduril(null, null);
    }

    /**
     * Character effected by both items. Ring used first
     */
    @Override
    public void useItem(Character character) {
        ring.useItem(character);
        anduril.useItem(character);
    }

    /**
     * Returns cost
     */
    @Override
    public int getCost() {
        return ring.getCost() + anduril.getCost();
    }
    
}
