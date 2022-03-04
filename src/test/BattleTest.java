package test;

import java.util.ArrayList;
import java.util.List;

import org.javatuples.Pair;
import org.junit.Test;

import javafx.beans.property.SimpleIntegerProperty;
import unsw.loopmania.Character;
import unsw.loopmania.Item;
import unsw.loopmania.LoopManiaWorld;
import unsw.loopmania.PathPosition;
import unsw.loopmania.AllBuildings.Barracks;
import unsw.loopmania.AllBuildings.Buildings;
import unsw.loopmania.AllBuildings.Campfire;
import unsw.loopmania.AllBuildings.Tower;
import unsw.loopmania.AllBuildings.Trap;
import unsw.loopmania.AllBuildings.ZombiePit;
import unsw.loopmania.Allitems.Armour;
import unsw.loopmania.Allitems.HealthPotion;
import unsw.loopmania.Allitems.Helmet;
import unsw.loopmania.Allitems.OneRingAndAnduril;
import unsw.loopmania.Allitems.Shield;
import unsw.loopmania.Allitems.Staff;
import unsw.loopmania.Allitems.Stake;
import unsw.loopmania.Allitems.Sword;
import unsw.loopmania.Allitems.TheOneRing;
import unsw.loopmania.Cards.BarrackCard;
import unsw.loopmania.DifficultyStates.Confusing;
import unsw.loopmania.Enemies.BasicEnemy;
import unsw.loopmania.Enemies.Slug;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
public class BattleTest {
    @Test
    public void slugTest() {
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

        List<BasicEnemy> enemies = world.runBattles();

        for (BasicEnemy enemy: enemies) {
            assertEquals(enemy.getClass(), new Slug(null));
        }
    }

    @Test
    //Testing if slug enemies are returned correctly
    public void battlewithAlliesTest() {
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
        Buildings barrack = new Barracks(new SimpleIntegerProperty(3), new SimpleIntegerProperty(3));
        world.addBuildingEntity(barrack);
        world.addRandomItem();
        for (int i = 0; i < 10; i++) {
            world.SpawnSlugsEnemies();
        }
        world.SpawnSlugsEnemies();
        List<BasicEnemy> deadenemies = world.runBattles();
        for (BasicEnemy e: deadenemies) {
            assertTrue(e instanceof Slug);
        }

    }


    @Test
    //Test if the method is performing as expected. Campfire not included
    public void battlewithItemsandBuildingsNoCampfireTest() {
        List<Pair<Integer, Integer>> stub = new ArrayList<Pair<Integer, Integer>>();
        for (int i = 0; i < 10; i++) {
            for (int y = 0; y < 10; y++) {
                stub.add(new Pair<Integer, Integer>(i, y));
            }
        }
        PathPosition pos = new PathPosition(3, stub);
        Character character = new Character(pos);


        LoopManiaWorld world = new LoopManiaWorld(10, 10, stub);
        world.setCharacter(character);

        //Add buildings
        Buildings barrack = new Barracks(new SimpleIntegerProperty(3), new SimpleIntegerProperty(3));
        Buildings cf = new Campfire(new SimpleIntegerProperty(3), new SimpleIntegerProperty(3));
        Buildings zp = new ZombiePit(new SimpleIntegerProperty(3), new SimpleIntegerProperty(3));
        Buildings tower = new Tower(new SimpleIntegerProperty(3), new SimpleIntegerProperty(3));
        
        world.addBuildingEntity(barrack);
        world.addBuildingEntity(cf);
        world.addBuildingEntity(zp);
        world.addBuildingEntity(tower);

        //In range
        character.moveUpPath();
        character.moveUpPath();

        //Equip all available items
        Item sword = new Sword(null, null);
        Item staff = new Staff(null,null);
        Item armour = new Armour(null, null);
        Item helmet = new Helmet(null, null);
        Item shield = new Shield(null, null);
        world.addEquippedItem(shield);
        world.addEquippedItem(staff);
        world.addEquippedItem(armour);
        world.addEquippedItem(helmet);
        world.addEquippedItem(sword);
        world.addRandomItem();


        for (int i = 0; i < 10; i++) {
            world.SpawnSlugsEnemies();
            world.SpawnEnemiesBuildings();
        }
        world.SpawnSlugsEnemies();
        List<BasicEnemy> deadenemies = world.runBattles();
        for (BasicEnemy e: deadenemies) {
            assertTrue(e instanceof BasicEnemy);
        }

    }

    @Test
    //Test if the method is performing as expected. Campfire included
    public void battlewithItemsandBuildingsWithCampfireTest() {
        List<Pair<Integer, Integer>> stub = new ArrayList<Pair<Integer, Integer>>();
        for (int i = 0; i < 10; i++) {
            for (int y = 0; y < 10; y++) {
                stub.add(new Pair<Integer, Integer>(i, y));
            }
        }
        PathPosition pos = new PathPosition(3, stub);
        Character character = new Character(pos);


        LoopManiaWorld world = new LoopManiaWorld(10, 10, stub);
        world.setCharacter(character);

        //Add buildings
        Buildings barrack = new Barracks(new SimpleIntegerProperty(3), new SimpleIntegerProperty(3));
        Buildings cf = new Campfire(new SimpleIntegerProperty(3), new SimpleIntegerProperty(3));
        Buildings zp = new ZombiePit(new SimpleIntegerProperty(3), new SimpleIntegerProperty(3));
        Buildings tower = new Tower(new SimpleIntegerProperty(3), new SimpleIntegerProperty(3));
        Buildings camp = new Campfire(new SimpleIntegerProperty(3), new SimpleIntegerProperty(3));
        
        world.addBuildingEntity(barrack);
        world.addBuildingEntity(cf);
        world.addBuildingEntity(zp);
        world.addBuildingEntity(tower);
        world.addBuildingEntity(camp);

        //In range
        character.moveDownPath();
        character.moveUpPath();
        character.moveDownPath();
        character.moveDownPath();
        world.setDifficulty(new Confusing());
        world.rareItems(null);
        //Equip all available items
        Item sword = new Sword(null, null);
        Item staff = new Staff(null,null);
        Item armour = new Armour(null, null);
        Item helmet = new Helmet(null, null);
        Item shield = new Shield(null, null);
        Item potion = new HealthPotion(null, null);
        Item ring1 = new OneRingAndAnduril(null, null);
        Item ring = new TheOneRing(null, null);
        world.addEquippedItem(ring);
        world.addEquippedItem(ring1);
        world.addEquippedItem(shield);
        world.addEquippedItem(staff);
        world.addEquippedItem(armour);
        world.addEquippedItem(helmet);
        world.addEquippedItem(sword);
        world.addEquippedItem(potion);
        world.addNewItemUnequipped(potion);
        world.addRandomItem();


        for (int i = 0; i < 10; i++) {
            world.SpawnSlugsEnemies();
            world.SpawnEnemiesBuildings();
        }
        world.SpawnSlugsEnemies();
        List<BasicEnemy> deadenemies = world.runBattles();

        //Move character down and run battles again
        world.runTickMoves();
        
        for (int i = 0; i < 10; i++) {
            world.SpawnSlugsEnemies();
            world.SpawnEnemiesBuildings();
        }
        deadenemies = world.runBattles();
        for (BasicEnemy e: deadenemies) {
            assertTrue(e instanceof BasicEnemy);
        }

    }

    @Test
    //Test if method runs despite character dying
    public void losesBattleTest() {
        List<Pair<Integer, Integer>> stub = new ArrayList<Pair<Integer, Integer>>();
        for (int i = 0; i < 10; i++) {
            for (int y = 0; y < 10; y++) {
                stub.add(new Pair<Integer, Integer>(i, y));
            }
        }
        PathPosition pos = new PathPosition(3, stub);
        Character character = new Character(pos);


        LoopManiaWorld world = new LoopManiaWorld(10, 10, stub);
        world.setCharacter(character);
        character.setHealth(1);

        //Add buildings
        Buildings barrack = new Barracks(new SimpleIntegerProperty(3), new SimpleIntegerProperty(3));
        Buildings cf = new Campfire(new SimpleIntegerProperty(3), new SimpleIntegerProperty(3));
        Buildings zp = new ZombiePit(new SimpleIntegerProperty(3), new SimpleIntegerProperty(3));
        Buildings tower = new Tower(new SimpleIntegerProperty(3), new SimpleIntegerProperty(3));
        
        world.addBuildingEntity(barrack);
        world.addBuildingEntity(cf);
        world.addBuildingEntity(zp);
        world.addBuildingEntity(tower);

        //In range
        character.moveUpPath();
        character.moveUpPath();

        //Equip all available items
        Item sword = new Sword(null, null);
        Item staff = new Staff(null,null);
        Item armour = new Armour(null, null);
        Item helmet = new Helmet(null, null);
        Item shield = new Shield(null, null);
        Item stake = new Stake(null, null);
        world.addEquippedItem(stake);
        world.addEquippedItem(shield);
        world.addEquippedItem(staff);
        world.addEquippedItem(armour);
        world.addEquippedItem(helmet);
        world.addEquippedItem(sword);
        world.addRandomItem();


        for (int i = 0; i < 10; i++) {
            world.SpawnSlugsEnemies();
            world.SpawnEnemiesBuildings();
        }
        world.SpawnSlugsEnemies();
        List<BasicEnemy> deadenemies = world.runBattles();
        //No enemies defeated since character died
        assertTrue(deadenemies.isEmpty());

    }


    @Test
    //Test if method runs despite character dying
    public void BattleinterationcTest() {
        List<Pair<Integer, Integer>> stub = new ArrayList<Pair<Integer, Integer>>();
        for (int i = 0; i < 10; i++) {
            for (int y = 0; y < 10; y++) {
                stub.add(new Pair<Integer, Integer>(i, y));
            }
        }
        PathPosition pos = new PathPosition(3, stub);
        Character character = new Character(pos);


        LoopManiaWorld world = new LoopManiaWorld(10, 10, stub);
        world.setCharacter(character);
        character.setHealth(1);

        //Add buildings
        Buildings barrack = new Barracks(new SimpleIntegerProperty(3), new SimpleIntegerProperty(3));
        Buildings cf = new Campfire(new SimpleIntegerProperty(3), new SimpleIntegerProperty(3));
        Buildings trap = new Trap(new SimpleIntegerProperty(3), new SimpleIntegerProperty(3));
        Buildings tower = new Tower(new SimpleIntegerProperty(3), new SimpleIntegerProperty(3));
        
        
        world.addBuildingEntity(barrack);
        world.addBuildingEntity(cf);
        world.addBuildingEntity(trap);
        world.addBuildingEntity(tower);

        //In range
        character.moveDownPath();
        character.moveDownPath();
        character.moveDownPath();


        for (int i = 0; i < 10; i++) {
            world.SpawnSlugsEnemies();
            world.SpawnEnemiesBuildings();
        }
        world.SpawnSlugsEnemies();
        world.buildingInteractions();
        List<BasicEnemy> deadenemies = world.runBattles();
        //No enemies defeated since character died
        assertTrue(deadenemies.isEmpty());

    }
}
