package test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.Test;

import javafx.beans.property.SimpleIntegerProperty;
import unsw.loopmania.Character;
import unsw.loopmania.Enemies.*;

public class EnemiesTest {
    @Test
    public void Slug()  {
        Slug slug = new Slug(null);
        assertEquals(false, slug.deBuff(2));
        assertEquals(40, slug.getHealth());
        assertEquals(8, slug.getDamage());
        assertEquals(1, slug.getBattleRadius());
        assertEquals(1, slug.getSupportRadius());
        assertEquals(40, slug.getMaxHealth());
        slug.setBattleRadius(3);
        assertEquals(3, slug.getBattleRadius());
        slug.setSupportRadius(3);
        assertEquals(3, slug.getSupportRadius());
        assertEquals(8, slug.getCriticalDamage());
    }

    @Test
    public void Zombie()  {
        Zombie zombie = new Zombie(null);
        assertEquals(55, zombie.getHealth());
        assertEquals(12, zombie.getDamage());
        assertEquals(2, zombie.getBattleRadius());
        assertEquals(2, zombie.getSupportRadius());
        assertEquals(20, zombie.getCriticalDamage());
        assertEquals(55, zombie.getMaxHealth());
        zombie.setBattleRadius(3);
        assertEquals(3, zombie.getBattleRadius());
        zombie.setSupportRadius(3);
        assertEquals(3, zombie.getSupportRadius());
    }

    @Test
    public void Vampire()  {
        Vampire vampire = new Vampire(null);
        vampire.deBuff(10);
        vampire.deBuff(0);
        vampire.move();
        assertEquals(80, vampire.getHealth());
        assertEquals(18, vampire.getDamage());
        assertEquals(2, vampire.getBattleRadius());
        assertEquals(3, vampire.getSupportRadius());
        assertEquals(25, vampire.getCriticalDamage());
        assertEquals(80, vampire.getMaxHealth());
        vampire.setBattleRadius(3);
        assertEquals(3, vampire.getBattleRadius());
        vampire.setSupportRadius(3);
        assertEquals(3, vampire.getSupportRadius());
        vampire.setDamage(3);
        assertEquals(3, vampire.getDamage());
        vampire.setHealth(3);
        assertEquals(3, vampire.getHealth());
    }

    @Test
    public void ElanMuske()  {
        ElanMuske elanMuske = new ElanMuske(null);
        assertEquals(600, elanMuske.getHealth());
        assertEquals(40, elanMuske.getDamage());
        assertEquals(1, elanMuske.getBattleRadius());
        assertEquals(1, elanMuske.getSupportRadius());
        assertEquals(500, elanMuske.getMaxHealth());
    }

    @Test
    public void Doggie()  {
        Doggie doggie = new Doggie(null);
        assertEquals(450, doggie.getHealth());
        assertEquals(450, doggie.getMaxHealth());
        assertEquals(20, doggie.getDamage());
        assertEquals(1, doggie.getBattleRadius());
        assertEquals(1, doggie.getSupportRadius());
        assertEquals(20, doggie.getCriticalDamage());
    }
}
