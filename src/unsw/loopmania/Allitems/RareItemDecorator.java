package unsw.loopmania.Allitems;

import javafx.beans.property.SimpleIntegerProperty;
import unsw.loopmania.Item;

public abstract class RareItemDecorator extends Item {

    public RareItemDecorator(SimpleIntegerProperty x, SimpleIntegerProperty y) {
        super(x, y);
    }
    
}
