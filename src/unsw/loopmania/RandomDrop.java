package unsw.loopmania;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import unsw.loopmania.Allitems.*;
import unsw.loopmania.Cards.*;
import unsw.loopmania.DifficultyStates.Confusing;
import unsw.loopmania.DifficultyStates.Difficulty;

/**
 * Returns an array of random item drops. Random item spawns are handled in LoopManiaWorld
 * Takes into account difficulty as well.
 */
public class RandomDrop {
    private List<Item> Rareitems = new ArrayList<>();
    private Random rand;
    private List<Card> possibleCards = new ArrayList<>();
    private List<Item> possibleItem = new ArrayList<>();
    private List<String> rareitemstring;
    private Difficulty difficulty;
    
    /**
     * Constructor for Randomdrop
     * @param seed
     */
    public RandomDrop(long seed) {
        this.rand = new Random(seed);
        addPossibleCards();
        addPossibleItems();
    }

    public RandomDrop() {
        this(System.currentTimeMillis());
    }

    /**
     * Possible building cards
     */
    public void addPossibleCards() {
        List<Card> possibleCards = new ArrayList<Card>();
        possibleCards.add(new BarrackCard(null,null));
        possibleCards.add(new CampfireCard(null,null));
        possibleCards.add(new TowerCard(null, null));
        possibleCards.add(new TrapCard(null,null));
        possibleCards.add(new VampireCastleCard(null,null));
        possibleCards.add(new VillageCard(null,null));
        possibleCards.add(new ZombiePitCard(null, null));
        this.possibleCards = possibleCards;
    }

    /**
     * Return a card
     * @return
     */
    public Card getPossibleCard() {
        Card it = possibleCards.get(Math.abs(rand.nextInt(possibleCards.size())));
        possibleCards.clear();
        addPossibleCards();
        return it;
    }

    /**
     * Return an item. Takes into account rare items
     * @return
     */
    public Item getPossibleItem() {
        int i = rand.nextInt();
        if ((i % 5) == 0 && !Rareitems.isEmpty()) {
            Item it = Rareitems.get(Math.abs(rand.nextInt(Rareitems.size())));
            if (difficulty != null && difficulty.getDifficulty() instanceof Confusing) {
                confusingItems();
            } else {
                rareItems(rareitemstring);
            }
            return it;
        } else {
            Item it = possibleItem.get(Math.abs(rand.nextInt(possibleItem.size())));
            possibleItem.clear();
            addPossibleItems();
            return it;
        }
    }

    /**
     * Return all possible items
     * @return
     */
    public List<Item> getAllPossibleItems() {
        return possibleItem;
    }

    /**
     * Possible items
     */
    public void addPossibleItems() {
        List<Item> possibleItems = new ArrayList<Item>();
        possibleItems.add(new HealthPotion(null,null));
        possibleItems.add(new Helmet(null, null));
        possibleItems.add(new Shield(null,null));
        possibleItems.add(new Staff(null,null));
        possibleItems.add(new Sword(null,null));
        possibleItems.add(new Stake(null,null));
        possibleItems.add(new Armour(null, null));
        this.possibleItem = possibleItems;
    }

    /**
     * Rare items to add
     * @param rareitems
     */
    public void rareItems(List<String> rareitems) {
        this.rareitemstring = rareitems;
        Rareitems.clear();
        for (String i: rareitemstring) {
            switch(i) {
                case "TheOneRing":
                    Rareitems.add(new TheOneRing(null, null));
                    break;
                case "AndurilFlameoftheWest":
                    Rareitems.add(new Anduril(null, null));
                    break;
                case "TreeStump":
                    Rareitems.add(new TreeStump(null, null));
                    break;
            }
        }
    }

    /**
     * New items in confusing mode
     */
    public void confusingItems() {
        Rareitems.clear();
        Rareitems.add(new OneRingAndAnduril(null, null));
        Rareitems.add(new AndurilandTreeStump(null, null));
        Rareitems.add(new OneRingAndTreeStump(null, null));
        Rareitems.add(new TreeStumpAndOneRing(null, null));
        Rareitems.add(new AndurilAndOneRing(null, null));
        Rareitems.add(new TreeStumpAndAnduril(null, null));
    }

    /**
     * Set difficulty. Confusing mode is the only major difference
     * @param difficulty
     */
    public void setDifficulty(Difficulty difficulty) {
        this.difficulty = difficulty;
    }

}
