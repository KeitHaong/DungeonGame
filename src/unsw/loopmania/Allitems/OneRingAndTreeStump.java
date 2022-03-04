package unsw.loopmania.Allitems;

import javafx.beans.property.SimpleIntegerProperty;
import unsw.loopmania.Character;
import unsw.loopmania.Enemies.BasicEnemy;

public class OneRingAndTreeStump extends RareItemDecorator {
    private TheOneRing ring;
    private TreeStump tree;

    /**
     * Constructor. Contains one ring and treestump
     * @param x
     * @param y
     */
    public OneRingAndTreeStump(SimpleIntegerProperty x, SimpleIntegerProperty y) {
        super(x, y);
        ring = new TheOneRing(null, null);
        tree = new TreeStump(null, null);
    }

    /**
     * Does nothing
     */
    @Override
    public void useItem(Character character) {
    }

    /**
     * Use ring effect first
     * @param character
     * @param enemy
     */
    public void useSpecialItem(Character character, BasicEnemy enemy) {
        ring.useItem(character);
        tree.useTreeEffect(enemy);
    }

    /**
     * Returns cost
     */
    @Override
    public int getCost() {
        return ring.getCost() + tree.getCost();
    }

}
