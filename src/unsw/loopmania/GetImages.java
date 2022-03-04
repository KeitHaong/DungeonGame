package unsw.loopmania;

import java.io.File;
import java.util.Random;

import javafx.scene.image.Image;
import unsw.loopmania.AllBuildings.*;
import unsw.loopmania.Allitems.*;
import unsw.loopmania.Cards.*;
import unsw.loopmania.Enemies.*;

/**
 * ------------------------------------------------------------------------
 * Returns images. Initially a hashmap but ran into issues with overridding
 * equals to; causing a failure in the code. 
 * ------------------------------------------------------------------------
 */
public class GetImages {
    public Image getImages(Entity entity) {
        if (entity instanceof VampireCastleCard) {
            return new Image(new File("src/images/vampire_castle_card.png").toURI().toString());
        } else if (entity instanceof ZombiePitCard) {
            return new Image((new File("src/images/zombie_pit_card.png")).toURI().toString());
        } else if (entity instanceof BarrackCard) {
            return new Image((new File("src/images/barracks_card.png")).toURI().toString());
        } else if (entity instanceof BarrackCard) {
            return new Image((new File("src/images/barracks_card.png")).toURI().toString());
        } else if (entity instanceof CampfireCard) {
            return new Image((new File("src/images/campfire_card.png")).toURI().toString());
        }  else if (entity instanceof TowerCard) {
            return new Image((new File("src/images/tower_card.png")).toURI().toString());
        } else if (entity instanceof VillageCard) {
            return new Image((new File("src/images/village_card.png")).toURI().toString());
        } else if (entity instanceof TrapCard) {
            return new Image((new File("src/images/trap_card.png")).toURI().toString());
        } else if (entity instanceof Armour) {
            return new Image((new File("src/images/armour.png")).toURI().toString());
        } else if (entity instanceof Helmet) {
            return new Image((new File("src/images/helmet.png")).toURI().toString());
        } else if (entity instanceof Shield) {
            return new Image((new File("src/images/shield.png")).toURI().toString());
        } else if (entity instanceof Staff) {
            return new Image((new File("src/images/staff.png")).toURI().toString());
        } else if (entity instanceof Stake) {
            return new Image((new File("src/images/stake.png")).toURI().toString());
        } else if (entity instanceof HealthPotion) {
            return new Image((new File("src/images/brilliant_blue_new.png")).toURI().toString());
        } else if (entity instanceof Barracks) {
            return new Image((new File("src/images/barracks.png")).toURI().toString());
        } else if (entity instanceof Sword) {
            return new Image((new File("src/images/basic_sword.png")).toURI().toString());
        } else if (entity instanceof Campfire) {
            return new Image((new File("src/images/campfire.png")).toURI().toString());
        } else if (entity instanceof Tower) {
            return new Image((new File("src/images/tower.png")).toURI().toString());
        } else if (entity instanceof Trap) { 
            return new Image((new File("src/images/trap.png")).toURI().toString());
        } else if (entity instanceof Village) {
            return new Image((new File("src/images/village.png")).toURI().toString());
        } else if (entity instanceof VampireCastle) {
            return new Image((new File("src/images/vampire_castle_building_purple_background.png")).toURI().toString());
        } else if (entity instanceof ZombiePit) {
            return new Image((new File("src/images/zombie_pit.png")).toURI().toString());
        } else if (entity instanceof Zombie) {
            return new Image((new File("src/images/zombie.png")).toURI().toString());
        } else if (entity instanceof Slug) {
            return new Image((new File("src/images/slug.png")).toURI().toString());
        } else if (entity instanceof Vampire) {
            return new Image((new File("src/images/vampire.png")).toURI().toString());
        } else if (entity instanceof Gold) {
            return new Image((new File("src/images/gold_pile.png")).toURI().toString());
        } else if (entity instanceof TheOneRing) {
            return new Image((new File("src/images/the_one_ring.png")).toURI().toString());
        } else if (entity instanceof TreeStump) {
            return new Image((new File("src/images/tree_stump.png")).toURI().toString());
        } else if (entity instanceof Anduril) {
            return new Image((new File("src/images/anduril_flame_of_the_west.png")).toURI().toString());
        } else if (entity instanceof DoggieCoin) {
            return new Image((new File("src/images/doggiecoin.png")).toURI().toString());
        } else if (entity instanceof Doggie) {
            return new Image((new File("src/images/doggie.png")).toURI().toString());
        } else if (entity instanceof ElanMuske) {
            return new Image((new File("src/images/ElanMuske.png")).toURI().toString());
        } else if (entity instanceof OneRingAndAnduril) {
            return new Image((new File("src/images/the_one_ring.png")).toURI().toString());
        } else if (entity instanceof OneRingAndTreeStump) {
            return new Image((new File("src/images/the_one_ring.png")).toURI().toString());
        } else if (entity instanceof AndurilandTreeStump) {
            return new Image((new File("src/images/anduril_flame_of_the_west.png")).toURI().toString());
        } else if (entity instanceof AndurilAndOneRing) {
            return new Image((new File("src/images/anduril_flame_of_the_west.png")).toURI().toString());
        } else if (entity instanceof TreeStumpAndOneRing) {
            return new Image((new File("src/images/tree_stump.png")).toURI().toString());
        } else if (entity instanceof TreeStumpAndAnduril) {
            return new Image((new File("src/images/tree_stump.png")).toURI().toString());
        }
        return null;
    }


}
