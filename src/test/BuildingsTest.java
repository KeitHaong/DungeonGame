package test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import org.junit.jupiter.api.Test;

import javafx.beans.property.SimpleIntegerProperty;
import unsw.loopmania.AllBuildings.*;
import unsw.loopmania.Enemies.BasicEnemy;
import unsw.loopmania.Enemies.Slug;
import unsw.loopmania.Enemies.Zombie;
import unsw.loopmania.Ally;
import unsw.loopmania.Character;
import unsw.loopmania.PathPosition;
import unsw.loopmania.Spawn;

import java.util.ArrayList;
import java.util.List;
import org.javatuples.Pair;

public class BuildingsTest {
    SimpleIntegerProperty x = new SimpleIntegerProperty(1);
    SimpleIntegerProperty y = new SimpleIntegerProperty(1);
    @Test
    public void VampireTest() {
        List<Pair<Integer, Integer>> sample = new ArrayList<Pair<Integer,Integer>>();
        Pair<Integer, Integer> origin = new Pair<Integer, Integer>(0,0);
        sample.add(origin);
        Buildings vampire_castle = new VampireCastle(x, y);
        Character character  = new Character(null);
        //Set to 5 cycles
        character.setCycle();
        character.setCycle();
        character.setCycle();
        character.setCycle();
        character.setCycle();
        BasicEnemy obj = vampire_castle.InitialState(character, sample);
        assertNotEquals(null, obj);
        assertEquals(0, obj.getY());
        assertEquals(0, obj.getX());
    }

    @Test
    public void VampireTestNoCycles() {
        List<Pair<Integer, Integer>> sample = new ArrayList<Pair<Integer,Integer>>();
        Pair<Integer, Integer> origin = new Pair<Integer, Integer>(0,0);
        sample.add(origin);
        Buildings vampire_castle = new VampireCastle(x, y);
        Character character  = new Character(null);
        BasicEnemy obj = vampire_castle.InitialState(character, sample);
        assertEquals(null, obj);
        assertEquals(null, vampire_castle.NeutralState(character));
        assertEquals(null, vampire_castle.BattleState(character, null));
    }

    @Test
    public void ExtensiveSpawnTest() {
        List<Pair<Integer, Integer>> pairs = new ArrayList<Pair<Integer,Integer>>();
        for (int i = 1; i < 20; i++) {
            Pair<Integer, Integer> add = new Pair<Integer,Integer>(i,i);
            pairs.add(add);
        }

        Buildings zombie = new ZombiePit(new SimpleIntegerProperty(5), new SimpleIntegerProperty(5));
        Character character = new Character(new PathPosition(1, pairs));
        character.setCycle();
        character.setCycle();
        character.setCycle();

        Spawn spawn = new Spawn();
        int i = spawn.NearBuilding(pairs, 5, 4);
        Pair<Integer, Integer> val = pairs.get(i);
        assertEquals(new Pair<Integer, Integer>(5,5), val);

        BasicEnemy enemy = zombie.InitialState(character, pairs);
        assertNotEquals(null, enemy);
        assertEquals(5, enemy.getX());
        assertEquals(5, enemy.getY());
    }

    @Test
    public void ZombieTest() {
        List<Pair<Integer, Integer>> sample = new ArrayList<Pair<Integer,Integer>>();
        Pair<Integer, Integer> origin = new Pair<Integer, Integer>(0,0);
        sample.add(origin);
        Buildings zombie = new ZombiePit(x, y);
        Character character  = new Character(null);
        character.setCycle();
        character.setCycle();
        character.setCycle();
        BasicEnemy obj = zombie.InitialState(character, sample);
        assertNotEquals(null, obj);
        assertEquals(null, zombie.BattleState(character, null));
        assertEquals(null, zombie.NeutralState(character));
        assertEquals(0, obj.getY());
        assertEquals(0, obj.getX());
    }


    @Test
    public void CampfireTest() {
        List<Pair<Integer, Integer>> sample = new ArrayList<Pair<Integer,Integer>>();
        Pair<Integer, Integer> origin = new Pair<Integer, Integer>(0,0);
        sample.add(origin);
        Campfire campfire = new Campfire(x, y);
        Character character  = new Character(null);
        BasicEnemy obj = campfire.InitialState(character, sample);
        assertEquals(null, obj);
        Object obj2 = campfire.NeutralState(character);
        assertEquals(null, obj2);
        assertEquals(2, campfire.campfireRadius());
        Slug slug = new Slug(null);
        assertEquals(null, campfire.BattleState(character, slug));

    }

    @Test
    public void BarracksTest() {
        List<Pair<Integer, Integer>> sample = new ArrayList<Pair<Integer,Integer>>();
        Pair<Integer, Integer> origin = new Pair<Integer, Integer>(0,0);
        sample.add(origin);
        Buildings barracks = new Barracks(x, y);
        Character character  = new Character(null);
        BasicEnemy obj = barracks.InitialState(character, sample);
        assertEquals(null, obj);
        assertEquals(null, barracks.BattleState(character, null));
        assertTrue(barracks.NeutralState(character) instanceof Ally);
    }

    @Test
    public void TowerTest() {
        List<Pair<Integer, Integer>> sample = new ArrayList<Pair<Integer,Integer>>();
        Pair<Integer, Integer> origin = new Pair<Integer, Integer>(0,0);
        sample.add(origin);
        Tower tower = new Tower(x, y);
        Character character  = new Character(null);
        BasicEnemy obj = tower.InitialState(character, sample);
        assertEquals(null, obj);
        Object obj2 = tower.NeutralState(character);
        assertEquals(null, obj2);
        assertEquals(3, tower.campfireRadius());
        Slug slug = new Slug(null);
        assertEquals(null, tower.BattleState(character, slug));
    }

    @Test
    public void TrapTest() {
        List<Pair<Integer, Integer>> sample = new ArrayList<Pair<Integer,Integer>>();
        Pair<Integer, Integer> origin = new Pair<Integer, Integer>(0,0);
        sample.add(origin);
        Buildings trap = new Trap(x, y);
        Character character  = new Character(null);
        BasicEnemy zombie = new Zombie(null);
        BasicEnemy obj = trap.InitialState(character, sample);
        assertEquals(null, obj);
        Object obj2 = trap.NeutralState(character);
        assertEquals(null, obj2);
        assertEquals(null, trap.BattleState(character, zombie));
    }

    @Test
    public void HeroCaste() {
        //Checking simple states
        Buildings castle = new HeroCastle(null, null);
        assertEquals(null, castle.BattleState(null, null));
        assertEquals(null, castle.InitialState(null, null));
        assertEquals(null, castle.NeutralState(null));
    }


    @Test
    public void Village() {
        //Checking simple states
        Buildings castle = new Village(null, null);
        Character character = new Character(null);
        assertEquals(null, castle.BattleState(null, null));
        assertEquals(null, castle.InitialState(null, null));
        assertEquals(null, castle.NeutralState(character));
    }
} 
