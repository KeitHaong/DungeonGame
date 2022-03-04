package unsw.loopmania.Allitems;
import javafx.beans.property.SimpleIntegerProperty;
import unsw.loopmania.Character;
import unsw.loopmania.Enemies.BasicEnemy;

public class TreeStumpAndOneRing extends RareItemDecorator {
    private TheOneRing ring;
    private TreeStump tree;

    /**
     * Contain tree stump and One ring
     * @param x
     * @param y
     */
    public TreeStumpAndOneRing(SimpleIntegerProperty x, SimpleIntegerProperty y) {
        super(x, y);
        ring = new TheOneRing(null, null);
        tree = new TreeStump(null, null);
    }

    @Override
    public void useItem(Character character) {
    }

    /**
     * If ring is activated then item should be removed
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
