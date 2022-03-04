package unsw.loopmania.Allitems;

import javafx.beans.property.SimpleIntegerProperty;
import unsw.loopmania.Character;
import unsw.loopmania.Enemies.BasicEnemy;

public class TreeStumpAndAnduril extends RareItemDecorator {
    private Anduril anduril;
    private TreeStump tree;
    
    /**
     * Constructor. Holds Tree stump and anduril
     * @param x
     * @param y
     */
    public TreeStumpAndAnduril(SimpleIntegerProperty x, SimpleIntegerProperty y) {
        super(x, y);
        anduril = new Anduril(null, null);
        tree = new TreeStump(null, null);
    }

    /**
     * Return nothing
     */
    @Override
    public void useItem(Character character) {   
    }

    /**
     * Uses both effects of items
     * @param character
     * @param enemy
     */
    public void useSpecialItem(Character character, BasicEnemy enemy) {
        anduril.useItem(character);
        tree.useTreeEffect(enemy);
    }

    /**
     * Returns cost
     */
    @Override
    public int getCost() {
        return anduril.getCost() + tree.getCost();
    }
    
}
