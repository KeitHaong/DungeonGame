package test;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Random;

import org.junit.Test;

import javafx.beans.property.SimpleIntegerProperty;
import unsw.loopmania.Ally;
import unsw.loopmania.Character;
import unsw.loopmania.Allitems.*;
import unsw.loopmania.Enemies.BasicEnemy;
import unsw.loopmania.Enemies.Doggie;
import unsw.loopmania.Enemies.ElanMuske;
import unsw.loopmania.Enemies.Vampire;
import unsw.loopmania.Enemies.Zombie;

public class ItemsTest {
    @Test
    public void Armour() {
        Armour armour = new Armour(new SimpleIntegerProperty(1), new SimpleIntegerProperty(2));
        Zombie zombie = new Zombie(null);
        assertEquals(armour.getCost(), 85);
        int original = zombie.getDamage();
        armour.useArmourEffect(zombie);
        assertEquals(zombie.getDamage(), original / 2);
        armour.useItem(null);

    }

    @Test
    public void Gold() {
        Gold gold = new Gold(null, null);
        assertEquals(gold.getCost(), 0);
        gold.useItem(null);
    }

    @Test
    public void HealthPotion() {
        HealthPotion potion = new HealthPotion(null, null);
        Character character = new Character(null);
        character.setHealth(10);
        potion.useItem(character);
        assertEquals(potion.getCost(), 70);
        assertEquals(character.getMaxHealth(), character.getHealth());
    }

    @Test
    public void Helmet() {
        Helmet helmet = new Helmet(null, null);
        Zombie zombie = new Zombie(null);
        Character character = new Character(null);
        assertEquals(helmet.getCost(), 85);
        int original = zombie.getDamage();
        helmet.useHelmetEffect(zombie);
        assertEquals(zombie.getDamage(), (original * 3) / 4);
        int att = character.getAttack();
        helmet.useItem(character);
        assertEquals(character.getAttack(), att - 3);
        
    }
    @Test
    public void Shield() {
        Shield shield = new Shield(null,null);
        assertEquals(shield.getCost(), 85);
        //Does nothing so no errors should return
        shield.useItem(null);
        Vampire vam = new Vampire(null);
        Zombie zom = new Zombie(null);
        shield.useShieldEffect(vam);
        int vam_chance = (int) Math.round(vam.getStrikeChance() * 0.6);
        int zom_chance = zom.getStrikeChance();

        shield.useShieldEffect(zom);
        assertEquals(vam.getDebuffChance(), vam_chance);
        assertEquals(zom.getDebuffChance(), zom_chance);

    }

    @Test
    public void Staff() {
        Staff staff = new Staff(null,null);
        staff.setRandom(10);
        Random rand = new Random(10);
        Character character = new Character(null);
        int att = character.getAttack();
        staff.useItem(character);
        assertEquals(character.getAttack(), att - 6);
        assertEquals(staff.getCost(), 100);
        for (int i = 0; i < 30; i++) {
            if (rand.nextInt(10) <= 3) {
                assertTrue(staff.useStaffEffect() instanceof Ally);
            } else {
                assertEquals(null, staff.useStaffEffect());
            }
        }
    }

    @Test
    public void StakeWithVampire() {
        Stake stake = new Stake(null,null);
        Character character = new Character(null);
        int attack = character.getAttack();
        stake.useItem(character);
        assertEquals(character.getAttack(), attack - 3);
        Vampire vampire = new Vampire(null);
        attack = character.getAttack();
        stake.useStakeEffect(character, vampire);
        assertEquals(character.getAttack(), attack + 8);
        assertEquals(stake.getCost(), 150);
    }

    @Test
    public void StakeWithoutVampire() {
        Stake stake = new Stake(null,null);
        Character character = new Character(null);
        int attack = character.getAttack();
        stake.useItem(character);
        assertEquals(character.getAttack(), attack - 3);
        //Zombie instead of vampire
        Zombie zombie = new Zombie(null);
        attack = character.getAttack();
        stake.useStakeEffect(character, zombie);
        assertEquals(character.getAttack(), attack - 3);
    }

    @Test
    public void TheOneRing() {
        TheOneRing oneRing = new TheOneRing(null, null);
        Character character = new Character(null);
        character.setHealth(20);
        oneRing.useItem(character);
        assertEquals(character.getMaxHealth(), character.getHealth());
        assertEquals(oneRing.getCost(), 0);
    }

    @Test
    public void Anduril() {
        TreeStumpAndAnduril anduril = new TreeStumpAndAnduril(null, null);
        Character character = new Character(null);
        anduril.useItem(character);
        anduril.useItem(character);
        assertEquals(character.getAttack(), character.getBossDamage());
        assertEquals(anduril.getCost(), 0);
    }

    @Test
    public void TreeStump() {
        TreeStump tree = new TreeStump(null, null);
        BasicEnemy doggie = new Doggie(null);
        int doggieDamage = doggie.getDamage();
        BasicEnemy elan = new ElanMuske(null);
        int elanDamage = elan.getDamage();
        tree.useTreeEffect(doggie);
        tree.useTreeEffect(elan);
        assertEquals(doggie.getDamage(), doggieDamage - 5);
        assertEquals(elan.getDamage(), elanDamage - 10);
        assertEquals(tree.getCost(), 0);
    }

    @Test
    //Test the use items part (no effect on character)
    public void TreeStumpAbility() {
        TreeStump tree = new TreeStump(null, null);
        Character character = new Character(null);
        int health = character.getHealth();
        tree.useItem(character);
        assertEquals(health, character.getHealth());
    }

    @Test
    public void Sword() {
        Sword sword = new Sword(null, null);
        Character character = new Character(null);
        int attack = character.getAttack();
        sword.useItem(character);
        assertEquals(character.getAttack(), attack + 3);
        assertEquals(sword.getCost(), 85);
    }

    @Test
    public void TreeStumpAndOneRing() {
        TreeStumpAndOneRing treeRing = new TreeStumpAndOneRing(null, null);
        Character character = new Character(null);
        BasicEnemy doggie = new Doggie(null);
        int doggieDamage = doggie.getDamage();
        BasicEnemy elan = new ElanMuske(null);
        int elanDamage = elan.getDamage();
        treeRing.useItem(character);
        treeRing.useSpecialItem(character, doggie);
        treeRing.useSpecialItem(character, elan);
        assertEquals(doggie.getDamage(), doggieDamage - 5);
        assertEquals(elan.getDamage(), elanDamage - 10);
        assertEquals(character.getHealth(), character.getMaxHealth());
        assertEquals(treeRing.getCost(), 0);
    }

    @Test
    public void OneRingAndTreeStump() {
        OneRingAndTreeStump ringTree = new OneRingAndTreeStump(null, null);
        Character character = new Character(null);
        BasicEnemy doggie = new Doggie(null);
        int doggieDamage = doggie.getDamage();
        BasicEnemy elan = new ElanMuske(null);
        int elanDamage = elan.getDamage();
        ringTree.useItem(character);
        ringTree.useSpecialItem(character, doggie);
        ringTree.useSpecialItem(character, elan);
        assertEquals(doggie.getDamage(), doggieDamage - 5);
        assertEquals(elan.getDamage(), elanDamage - 10);
        assertEquals(character.getHealth(), character.getMaxHealth());
        assertEquals(ringTree.getCost(), 0);
    }

    @Test
    public void TreeStumpAndAnduril() {
        TreeStumpAndAnduril treeAnduril = new TreeStumpAndAnduril(null, null);
        Character character = new Character(null);
        BasicEnemy doggie = new Doggie(null);
        int doggieDamage = doggie.getDamage();
        BasicEnemy elan = new ElanMuske(null);
        int elanDamage = elan.getDamage();
        treeAnduril.useSpecialItem(character, doggie);
        treeAnduril.useSpecialItem(character, elan);
        assertEquals(doggie.getDamage(), doggieDamage - 5);
        assertEquals(elan.getDamage(), elanDamage - 10);
        assertEquals(character.getAttack(), character.getBossDamage());
        assertEquals(treeAnduril.getCost(), 0);
    }

    @Test
    public void AndruilAndTreeStump() {
        AndurilandTreeStump treeAnduril = new AndurilandTreeStump(null, null);
        Character character = new Character(null);
        BasicEnemy doggie = new Doggie(null);
        int doggieDamage = doggie.getDamage();
        BasicEnemy elan = new ElanMuske(null);
        int elanDamage = elan.getDamage();
        treeAnduril.useItem(character);
        treeAnduril.useSpecialItem(character, doggie);
        treeAnduril.useSpecialItem(character, elan);
        assertEquals(doggie.getDamage(), doggieDamage - 5);
        assertEquals(elan.getDamage(), elanDamage - 10);
        assertEquals(character.getAttack(), character.getBossDamage());
        assertEquals(treeAnduril.getCost(), 0);
    }

    @Test
    public void AndruilAndOneRing() {
        AndurilAndOneRing andurilOneRing = new AndurilAndOneRing(null, null);
        Character character = new Character(null);;
        andurilOneRing.useItem(character);
        assertEquals(character.getHealth(), character.getMaxHealth());
        assertEquals(character.getAttack(), character.getBossDamage());
        assertEquals(andurilOneRing .getCost(), 0);
    }

    @Test
    public void OneRingAndAnduril() {
        OneRingAndAnduril andurilOneRing = new OneRingAndAnduril(null, null);
        Character character = new Character(null);;
        andurilOneRing.useItem(character);
        assertEquals(character.getHealth(), character.getMaxHealth());
        assertEquals(character.getAttack(), character.getBossDamage());
        assertEquals(andurilOneRing .getCost(), 0);
    }

    @Test
    public void DoggieCoinTest() {
        DoggieCoin coin = new DoggieCoin(null, null);
        coin.useItem(null);
        coin.setRandom(10);
        Random rand = new Random(10);
        int cost = coin.getCost();
        coin.setCost(10);
        

    }
}