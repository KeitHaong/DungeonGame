package test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.javatuples.Pair;
import org.junit.Test;

import unsw.loopmania.Item;
import unsw.loopmania.LoopManiaWorld;
import unsw.loopmania.PathPosition;
import unsw.loopmania.Character;
import unsw.loopmania.Allitems.Armour;
import unsw.loopmania.Allitems.HealthPotion;
import unsw.loopmania.Allitems.Helmet;
import unsw.loopmania.DifficultyStates.Berserker;
import unsw.loopmania.DifficultyStates.Difficulty;
import unsw.loopmania.DifficultyStates.DifficultyStates;

public class DifficultiesTest {
    @Test
    public void Standard() {
        Difficulty diff = new Difficulty();
        Item item = new HealthPotion(null, null);
        Item item2 = new HealthPotion(null, null);
        assertTrue(diff.purchase_allowed(item));
        assertTrue(diff.purchase_allowed(item2));
    }

    @Test
    public void Berserker() {
        Difficulty diff = new Difficulty();
        DifficultyStates berserk = new Berserker();
        diff.setNewDifficulty(berserk);
        Item item = new HealthPotion(null, null);
        Item item2 = new HealthPotion(null, null);
        Item item3 = new Armour(null, null);
        Item item4 = new Helmet(null, null);
        assertTrue(diff.purchase_allowed(item));
        assertTrue(diff.purchase_allowed(item2));
        assertTrue(diff.purchase_allowed(item3));
        assertFalse(diff.purchase_allowed(item4));
        diff.resetPurchases();
        assertTrue(diff.purchase_allowed(item));
        assertTrue(diff.purchase_allowed(item2));
        assertTrue(diff.purchase_allowed(item3));
        assertFalse(diff.purchase_allowed(item4));
    }


    @Test
    public void Survival() {
        Difficulty diff = new Difficulty();
        DifficultyStates survive = new unsw.loopmania.DifficultyStates.Survival();
        diff.setNewDifficulty(survive);
        Item item = new HealthPotion(null, null);
        Item item2 = new HealthPotion(null, null);
        Item item3 = new Armour(null, null);
        Item item4 = new Helmet(null, null);
        assertTrue(diff.purchase_allowed(item));
        assertFalse(diff.purchase_allowed(item2));
        assertTrue(diff.purchase_allowed(item3));
        assertTrue(diff.purchase_allowed(item4));
        diff.resetPurchases();
        assertTrue(diff.purchase_allowed(item));
        assertFalse(diff.purchase_allowed(item2));
        assertTrue(diff.purchase_allowed(item3));
        assertTrue(diff.purchase_allowed(item4));
    }


    @Test
    public void Confusing() {
        Difficulty diff = new Difficulty();
        DifficultyStates confusing = new unsw.loopmania.DifficultyStates.Confusing();
        diff.setNewDifficulty(confusing);
        Item item = new HealthPotion(null, null);
        Item item2 = new HealthPotion(null, null);
        Item item3 = new Armour(null, null);
        Item item4 = new Helmet(null, null);
        assertTrue(diff.purchase_allowed(item));
        assertTrue(diff.purchase_allowed(item2));
        assertTrue(diff.purchase_allowed(item3));
        assertTrue(diff.purchase_allowed(item4));
        diff.resetPurchases();
        assertTrue(diff.purchase_allowed(item));
        assertTrue(diff.purchase_allowed(item2));
        assertTrue(diff.purchase_allowed(item3));
        assertTrue(diff.purchase_allowed(item4));

    }

    @Test
    public void ifDifficultyisChanged() {
        List<Pair<Integer, Integer>> stub = new ArrayList<Pair<Integer, Integer>>();
        for (int i = 0; i < 10; i++) {
            for (int y = 0; y < 10; y++) {
                stub.add(new Pair<Integer, Integer>(i, y));
            }
        }
        PathPosition pos = new PathPosition(0, stub);
        Character character = new Character(pos);


        LoopManiaWorld world = new LoopManiaWorld(10, 10, stub);
        Difficulty diff = new Difficulty();
        DifficultyStates confusing = new unsw.loopmania.DifficultyStates.Confusing();
        diff.setNewDifficulty(confusing);
        world.setDifficulty(confusing);
       

    }
}
