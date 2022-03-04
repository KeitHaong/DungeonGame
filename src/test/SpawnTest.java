package test;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.junit.Test;

import javafx.beans.property.SimpleIntegerProperty;

import org.javatuples.Pair;

import unsw.loopmania.PathPosition;
import unsw.loopmania.Spawn;
import unsw.loopmania.AllBuildings.VampireCastle;
import unsw.loopmania.AllBuildings.Village;
import unsw.loopmania.Enemies.Doggie;
import unsw.loopmania.Enemies.ElanMuske;
import unsw.loopmania.Character;
import unsw.loopmania.LoopManiaWorld;

public class SpawnTest {
    @Test
    public void NearBuildingSpawnTest() {
        List<Pair<Integer, Integer>> stub = new ArrayList<Pair<Integer, Integer>>();
        for (int i = 0; i < 10; i++) {
            for (int y = 0; y < 10; y++) {
                stub.add(new Pair<Integer, Integer>(i, y));
            }
        }

        Spawn spawn = new Spawn();
        spawn.setSpawn(stub);
        Pair<Integer, Integer> pair = stub.get(spawn.NearBuilding(stub, 5, 5));
        assertEquals(pair.getValue0(), 5);
        assertEquals(pair.getValue1(), 5);

    }

    @Test
    public void ifSpawnableSpawnTest() {
        List<Pair<Integer, Integer>> stub = new ArrayList<Pair<Integer, Integer>>();
        for (int i = 0; i < 5; i++) {
            for (int y = 0; y < 5; y++) {
                stub.add(new Pair<Integer, Integer>(i, y));
            }
        }
        
        Spawn spawn = new Spawn();
        spawn.setSpawn(stub);
        VampireCastle vc = new VampireCastle(new SimpleIntegerProperty(5), new SimpleIntegerProperty(4));
        assertEquals(spawn.ifSpawnable(vc, 6, 4), true);
        assertEquals(spawn.ifSpawnable(vc, 4, 4), false);
        
        Village village = new Village(new SimpleIntegerProperty(5), new SimpleIntegerProperty(4));
        assertEquals(spawn.ifSpawnable(village, 6, 4), false);
        assertEquals(spawn.ifSpawnable(village, 4, 4), true);
    }

    @Test
    public void slugTest() {
        List<Pair<Integer, Integer>> stub = new ArrayList<Pair<Integer, Integer>>();
        for (int i = 0; i < 5; i++) {
            for (int y = 0; y < 5; y++) {
                stub.add(new Pair<Integer, Integer>(i, y));
            }
        }
        Spawn spawn = new Spawn();
        spawn.setSpawn(stub, 10);
        Random random = new Random(10);
        PathPosition pathPosition = new PathPosition(0, stub);
        Character character = new Character(pathPosition);

        for (int i = 0; i < 6; i++) {
            if (random.nextInt(3) == 0) {
                assertTrue(spawn.GetBasicEnemySpawnPosition(i, character) instanceof Pair<?, ?>);
                break;
            }
            assertTrue((spawn.GetBasicEnemySpawnPosition(i, character)).equals(null));
        }
    }

    @Test
    public void DoggieTest() {
        List<Pair<Integer, Integer>> stub = new ArrayList<Pair<Integer, Integer>>();
        for (int i = 0; i < 10; i++) {
            for (int y = 0; y < 10; y++) {
                stub.add(new Pair<Integer, Integer>(i, y));
            }
        }

        LoopManiaWorld world = new LoopManiaWorld(4, 4, stub);
        world.SpawnSlugsEnemies();
        PathPosition path = new PathPosition(0, stub);
        Character character = new Character(path);
        world.setCharacter(character);
        assertTrue(world.SpawnDoggieEnemies() instanceof Doggie);
        assertEquals(null, world.SpawnDoggieEnemies());
    }


    @Test
    public void ElanTest() {
        List<Pair<Integer, Integer>> stub = new ArrayList<Pair<Integer, Integer>>();
        for (int i = 0; i < 10; i++) {
            for (int y = 0; y < 10; y++) {
                stub.add(new Pair<Integer, Integer>(i, y));
            }
        }

        LoopManiaWorld world = new LoopManiaWorld(4, 4, stub);
        PathPosition path = new PathPosition(0, stub);
        Character character = new Character(path);
        world.setCharacter(character);
        assertEquals(null, world.SpawnElanEnemies());

        for (int i = 0; i < 50; i++) {
            character.setCycle();
        }
        character.setExperience(1100000000);
        assertTrue(world.SpawnElanEnemies() instanceof ElanMuske);
    }
}
