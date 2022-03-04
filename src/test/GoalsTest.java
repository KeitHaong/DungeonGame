package test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import org.junit.jupiter.api.Test;

import unsw.loopmania.LoopManiaWorld;
import unsw.loopmania.Enemies.BasicEnemy;
import unsw.loopmania.Enemies.Doggie;
import unsw.loopmania.Enemies.ElanMuske;
import unsw.loopmania.Character;
import unsw.loopmania.Goals.*;

public class GoalsTest {
    @Test
    public void SimpleCyclesTest() {
    LoopManiaWorld world = new LoopManiaWorld(0, 0, null);
    Character character  = new Character(null);
    Goal goal = new CycleGoal(world);
    // required cycles = 4
    goal.setQuantity(4);
    // set cycles to 5
    character.setCycle();
    character.setCycle();
    character.setCycle();
    character.setCycle();
    assertEquals(true, goal.isSatisfied(character, world));
    // required cycles = 6
    goal.setQuantity(6);
    assertEquals(false, goal.isSatisfied(character, world));
    assertEquals(false, goal.hasSubGoals());
    }

    @Test
    public void SimpleGoldTest() {
        LoopManiaWorld world = new LoopManiaWorld(0, 0, null);
        Character character  = new Character(null);
        Goal goal = new GoldGoal(world);
        // required gold = 1000
        goal.setQuantity(1000);
        // set gold to 1001
        character.setGold(1001);
        assertEquals(true, goal.isSatisfied(character, world));
        // required gold = 2000
        goal.setQuantity(2000);
        assertEquals(false, goal.isSatisfied(character, world));
        assertEquals(false, goal.hasSubGoals());
    }

    @Test
    public void SimpleExperienceTest() {

        LoopManiaWorld world = new LoopManiaWorld(0, 0, null);
        Character character  = new Character(null);
        Goal goal = new ExperienceGoal(world);
        // required experience = 500
        goal.setQuantity(500);
        // set experience to 501
        character.setExperience(501);
        assertEquals(true, goal.isSatisfied(character, world));
        // required experience = 800
        goal.setQuantity(800);
        assertEquals(false, goal.isSatisfied(character, world));
        assertEquals(false, goal.hasSubGoals());
    }

    @Test
    public void SimpleBossTest() {

        LoopManiaWorld world = new LoopManiaWorld(0, 0, null);
        Character character  = new Character(null);
        // goal is to kill all bosses
        Goal goal = new BossGoal(world);
        BasicEnemy ElanMuske = new ElanMuske(null);
        BasicEnemy Doggie = new Doggie(null);
        world.allEnemiesDeafeated.add(ElanMuske);
        world.allEnemiesDeafeated.add(Doggie);
        assertEquals(true, goal.isSatisfied(character, world));
        assertEquals(false, goal.hasSubGoals());
    }

    @Test
    public void SimpleAndTest() {
        LoopManiaWorld world = new LoopManiaWorld(0, 0, null);
        Character character  = new Character(null);
        Goal expGoal = new ExperienceGoal(world);
        expGoal.setQuantity(500);
        Goal goldGoal = new GoldGoal(world);
        goldGoal.setQuantity(500);
        Goal AndGoal = new AndGoal(world);
        // Goal = 500 XP AND 500 gold
        AndGoal.addSubGoal(expGoal);
        AndGoal.addSubGoal(goldGoal);
        // set exp & gold to 500
        character.setExperience(500);
        character.setGold(500);
        assertEquals(true, AndGoal.isSatisfied(character, world));
        // set exp to 400;
        character.setExperience(400);
        assertEquals(false, AndGoal.isSatisfied(character, world));
        assertEquals(true, AndGoal.hasSubGoals());
    }

    @Test
    public void SimpleOrTest() {

        LoopManiaWorld world = new LoopManiaWorld(0, 0, null);
        Character character  = new Character(null);

        Goal expGoal = new ExperienceGoal(world);
        expGoal.setQuantity(500);
        Goal goldGoal = new GoldGoal(world);
        goldGoal.setQuantity(500);
        Goal OrGoal = new OrGoal(world);

        // Goal = 500 XP AND 500 gold
        OrGoal.addSubGoal(expGoal);
        OrGoal.addSubGoal(goldGoal);

        // set exp & gold to 500
        character.setExperience(400);
        character.setGold(500);
        assertEquals(true, OrGoal.isSatisfied(character, world));
        // set exp to 400;
        character.setGold(400);
        assertEquals(false, OrGoal.isSatisfied(character, world));
        assertEquals(true, OrGoal.hasSubGoals());
    }

    @Test
    public void ComplexAndOrTest() {

        LoopManiaWorld world = new LoopManiaWorld(0, 0, null);
        Character character  = new Character(null);

        Goal expGoal = new ExperienceGoal(world);
        expGoal.setQuantity(500);
        Goal goldGoal = new GoldGoal(world);
        goldGoal.setQuantity(500);
        Goal cycleGoal = new CycleGoal(world);
        cycleGoal.setQuantity(10);

        Goal andGoal = new AndGoal(world);
        Goal orGoal = new OrGoal(world);

        // Goal = 500 XP AND 500 gold OR 10 cycles
        orGoal.addSubGoal(goldGoal);
        orGoal.addSubGoal(cycleGoal);
        andGoal.addSubGoal(expGoal);
        andGoal.addSubGoal(orGoal);

        // set exp & gold to 500 & cycles to 2 - should pass
        character.setExperience(500);
        character.setGold(500);
        character.setCycle();
        assertEquals(true, andGoal.isSatisfied(character, world));

        // set gold to 400 - should fail
        character.setGold(400);
        assertEquals(false, andGoal.isSatisfied(character, world));
        
    }

    @Test
    public void ComplexOrAndTest() {

        LoopManiaWorld world = new LoopManiaWorld(0, 0, null);
        Character character  = new Character(null);

        Goal expGoal = new ExperienceGoal(world);
        expGoal.setQuantity(500);
        Goal goldGoal = new GoldGoal(world);
        goldGoal.setQuantity(500);
        Goal cycleGoal = new CycleGoal(world);
        cycleGoal.setQuantity(3);

        Goal andGoal = new AndGoal(world);
        Goal orGoal = new OrGoal(world);

        // Goal = 500 XP OR 500 gold AND 3 cycles
        andGoal.addSubGoal(goldGoal);
        andGoal.addSubGoal(cycleGoal);
        orGoal.addSubGoal(expGoal);
        orGoal.addSubGoal(andGoal);

        // set exp - 400, gold - 500 & cycles - 3 - should pass
        character.setExperience(400);
        character.setGold(500);
        character.setCycle();
        character.setCycle();
        assertEquals(true, orGoal.isSatisfied(character, world));

        // set gold to 400 - should fail
        character.setGold(400);
        assertEquals(false, orGoal.isSatisfied(character, world));
        
    }
    
}
