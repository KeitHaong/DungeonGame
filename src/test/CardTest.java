package test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import java.util.ArrayList;
import java.util.List;

import org.javatuples.Pair;
import org.junit.Test;

import unsw.loopmania.Cards.*;
import unsw.loopmania.LoopManiaWorld;
import unsw.loopmania.PathPosition;
import unsw.loopmania.AllBuildings.*;
import unsw.loopmania.Card;
import unsw.loopmania.Character;

public class CardTest {
    @Test
    public void BarrackCard() {
        BarrackCard card = new BarrackCard(null, null);
        assertSame(new Barracks(null, null).getClass(), card.getBuilding().getClass());
        
    }

    @Test
    public void CampfireCard() {
        CampfireCard card = new CampfireCard(null, null);
        assertEquals(new Campfire(null, null).getClass(), card.getBuilding().getClass());
    }

    @Test
    public void TowerCard() {
        TowerCard card = new TowerCard(null, null);
        assertEquals(new Tower(null, null).getClass(), card.getBuilding().getClass());
    }

    @Test
    public void TrapCard() {
        TrapCard card = new TrapCard(null,null);
        assertEquals(new Trap(null, null).getClass(), card.getBuilding().getClass());
    }

    @Test
    public void VampireCastleCard() {
        VampireCastleCard card = new VampireCastleCard(null, null);
        assertEquals(new VampireCastle(null, null).getClass(), card.getBuilding().getClass());
    }

    @Test
    public void VillageCard() {
        VillageCard card = new VillageCard(null, null);
        assertEquals(new Village(null, null).getClass(), card.getBuilding().getClass());
    }

    @Test
    public void ZombiePitCard() {
        ZombiePitCard card = new ZombiePitCard(null, null);
        assertEquals(new ZombiePit(null, null).getClass(), card.getBuilding().getClass());
    }

    @Test
    public void worldLoadCard() {
        List<Pair<Integer, Integer>> stub = new ArrayList<Pair<Integer, Integer>>();
        for (int i = 0; i < 10; i++) {
            for (int y = 0; y < 10; y++) {
                stub.add(new Pair<Integer, Integer>(i, y));
            }
        }
        PathPosition pos = new PathPosition(0, stub);
        Character character = new Character(pos);
        


        LoopManiaWorld world = new LoopManiaWorld(10, 10, stub);
        world.setCharacter(character);
        assertEquals(character, world.getCharacter());
        for (int i = 0; i < 50; i++) {
            assertTrue(world.loadCard() instanceof Card);
        }

        assertNotEquals(0, character.getGold());
    }
}
