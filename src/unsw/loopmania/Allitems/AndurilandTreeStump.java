package unsw.loopmania.Allitems;

import javafx.beans.property.SimpleIntegerProperty;
import unsw.loopmania.Character;
import unsw.loopmania.Enemies.BasicEnemy;

public class AndurilandTreeStump extends RareItemDecorator {
    private Anduril anduril;
    private TreeStump tree;

    /**
     * Contains anduril and tree stump
     * @param x
     * @param y
     */
    public AndurilandTreeStump(SimpleIntegerProperty x, SimpleIntegerProperty y) {
        super(x, y);
        anduril = new Anduril(null, null);
        tree = new TreeStump(null, null);
    }

    /**
     * Do nothing
     */
    @Override
    public void useItem(Character character) {
    }

    /**
     * Use special items
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
