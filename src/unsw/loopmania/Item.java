package unsw.loopmania;

import javafx.beans.property.SimpleIntegerProperty;

public abstract class Item extends StaticEntity {

    public Item(SimpleIntegerProperty x, SimpleIntegerProperty y) { 
        super(x, y);
    }
    
    abstract public void useItem(Character character);
    abstract public int getCost();
}