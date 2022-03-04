package test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.javatuples.Pair;
import org.junit.Test;

import unsw.loopmania.Item;
import unsw.loopmania.LoopManiaWorld;
import unsw.loopmania.RandomDrop;
import unsw.loopmania.Allitems.TreeStump;
import unsw.loopmania.DifficultyStates.Confusing;
import unsw.loopmania.DifficultyStates.Difficulty;
import unsw.loopmania.DifficultyStates.DifficultyStates;

public class RandomDropsTest {
    @Test
    public void rareItemsTest() {
        List<String> rare = new ArrayList<>();

        rare.add("TreeStump");
       
        int seed = 20;
        RandomDrop randomdrop = new RandomDrop(seed);
        Random random = new Random(seed);
        randomdrop.rareItems(rare);
        int j = random.nextInt();
        System.out.print(j + " ");
        Item item = randomdrop.getPossibleItem();
        if ((j % 5) == 0) {
            assertTrue(item instanceof TreeStump);
        }

        j = random.nextInt();
        System.out.print(j + " ");
        item = randomdrop.getPossibleItem();
        if ((j % 5) == 0) {
            assertTrue(item instanceof TreeStump);
        }
    }

    @Test
    public void confusingModeTest() {
        RandomDrop randomdrop = new RandomDrop(20);
        Random random = new Random(20);
        Difficulty diff = new Difficulty();
        DifficultyStates state = new Confusing();
        diff.setNewDifficulty(state);
        randomdrop.setDifficulty(diff);
        for (int i = 0; i < 10; i++) {
            if (random.nextInt() % 5 == 0) {
                assertNotEquals(null, randomdrop.getPossibleItem());
            }
            assertNotEquals(null, randomdrop.getPossibleItem());
        }
    }

    @Test
    public void getPossibleCard() {
        RandomDrop randomdrop = new RandomDrop(20);
        Random random = new Random(20);
        for (int i = 0; i < 10; i++) {
            if (random.nextInt() % 5 == 0) {
                assertNotEquals(null, randomdrop.getPossibleCard());
            }
            assertNotEquals(null, randomdrop.getPossibleCard());
        }
    }
}
