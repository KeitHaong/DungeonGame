package unsw.loopmania;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.hamcrest.core.IsInstanceOf;
import org.javatuples.Pair;

import javafx.beans.property.SimpleIntegerProperty;
import unsw.loopmania.AllBuildings.*;
import unsw.loopmania.Allitems.*;
import unsw.loopmania.Cards.*;
import unsw.loopmania.DifficultyStates.Confusing;
import unsw.loopmania.DifficultyStates.Difficulty;
import unsw.loopmania.DifficultyStates.DifficultyStates;
import unsw.loopmania.Enemies.BasicEnemy;
import unsw.loopmania.Enemies.*;
import unsw.loopmania.Goals.*;
import unsw.loopmania.AllSkillTree.*;

/**
 * A backend world.
 *
 * A world can contain many entities, each occupy a square. More than one
 * entity can occupy the same square.
 */
public class LoopManiaWorld {

    public static final int unequippedInventoryWidth = 4;
    public static final int unequippedInventoryHeight = 4;
    public static final int equippedInventoryWidth = 4;
    public static final int equippedInventoryHeight = 0;

    /**
     * width of the world in GridPane cells
     */
    private int width;

    /**
     * height of the world in GridPane cells
     */
    private int height;

    /**
     * generic entitites - i.e. those which don't have dedicated fields
     */
    private List<Entity> nonSpecifiedEntities;

    private Character character;

    private Goal goal;

    private List<Item> equippedInventoryItems;

    private List<BasicEnemy> enemies;
    public List<BasicEnemy> allEnemiesDeafeated;

    private List<Card> cardEntities;

    private List<Item> unequippedInventoryItems;
    private List<Item> doggiesCoins;

    /**
     * List of possible entities
     */
    private List<Ally> allies;

    private List<Buildings> buildingEntities;
    private int slugcount;
    private Difficulty difficulty;
    private boolean attackDouble = false;
    private boolean characterStun = false; 
    private RandomDrop randomdrops = new RandomDrop();  
    private int map;

    /**
     * list of x,y coordinate pairs in the order by which moving entities traverse them
     */
    private List<Pair<Integer, Integer>> orderedPath;


    /**
     * Spawn methods for enemies
     */
    private Spawn spawn;

    /**
     * 
     *Skill tree
     */
    private SkillTreeBuilder skilltree;

    /**
     * create the world (constructor)
     * 
     * @param width width of world in number of cells
     * @param height height of world in number of cells
     * @param orderedPath ordered list of x, y coordinate pairs representing position of path cells in world
     */
    public LoopManiaWorld(int width, int height, List<Pair<Integer, Integer>> orderedPath) {
        this.width = width;
        this.height = height;
        nonSpecifiedEntities = new ArrayList<>();
        character = null;
        goal = null;
        enemies = new ArrayList<>();
        cardEntities = new ArrayList<>();
        allies = new ArrayList<>();
        unequippedInventoryItems = new ArrayList<>();
        equippedInventoryItems = new ArrayList<>();
        this.orderedPath = orderedPath;
        buildingEntities = new ArrayList<>();
        this.spawn = new Spawn();
        spawn.setSpawn(orderedPath);
        this.difficulty = new Difficulty();
        allEnemiesDeafeated = new ArrayList<>();
        doggiesCoins = new ArrayList<>();
        SkillTreeBuilder skilltree = new OldSkillTreeBuilder();
        this.skilltree = skilltree;
    }

    /**
     * 
     * @return
     */
    public int getWidth() {
        return width;
    }

    /**
     * 
     * @return
     */
    public void setMap(int map) {
        this.map = map;
    }

    /**
     * 
     * @return
     */
    public int getMap() {
        return map;
    }


    /**
     * 
     * @return
     */
    public int getHeight() {
        return height;
    }

    /**
     * 
     * @return
     */
    public List<Pair<Integer,Integer>> getPaths() {
        return orderedPath;
    }

    
    /**
     * 
     * @return
     */
    public Difficulty getDifficulty() {
        return difficulty;
    }

    /**
     * 
     * @param diff
     */
    public void setDifficulty(DifficultyStates diff) {
        difficulty.setNewDifficulty(diff);
    }

    /**
     * set the character. This is necessary because it is loaded as a special entity out of the file
     * @param character the character
     */
    public void setCharacter(Character character) {
        this.character = character;
    }

    /**
     * @return character 
     */

    public Character getCharacter() {
        return character;
    }

    /**
     * @param goal
     */
    public void setGoal(Goal goal) {
        this.goal = goal;
    }

    /**
     * @return
     */
    public Goal getGoal() {
        return goal;
    }

    /**
     * @param item
     */
    public void addEquippedItem(Item item) {
        equippedInventoryItems.add(item);
    }

    public SkillTreeBuilder getSkillTree() {
        return skilltree;
    }


    /**
     * add a generic entity (without it's own dedicated method for adding to the world)
     * @param entity
     */
    public void addEntity(Entity entity) {
        // for adding non-specific entities (ones without another dedicated list)
        nonSpecifiedEntities.add(entity);
    }

    /**
     * spawns enemies if the conditions warrant it, adds to world
     * @return list of the enemies to be displayed on screen
     */
    public List<BasicEnemy> SpawnSlugsEnemies(){
        Pair<Integer, Integer> pos = spawn.GetBasicEnemySpawnPosition(slugcount, character);
        List<BasicEnemy> spawningEnemies = new ArrayList<>();
        if (pos != null){
            int indexInPath = orderedPath.indexOf(pos);
            BasicEnemy enemy = new Slug(new PathPosition(indexInPath, orderedPath));
            enemies.add(enemy);
            spawningEnemies.add(enemy);
            this.slugcount += 1; 
        }
        return spawningEnemies;
    }

    /**
     * Spawn Doggie
     * @return
     */
    public BasicEnemy SpawnDoggieEnemies() {
        Pair<Integer, Integer> pos = spawn.getDoggie(character);
        List<BasicEnemy> spawningEnemies = new ArrayList<>();
        if (pos != null && (character.getCycle() >= 20)) {
            int indexInPath = orderedPath.indexOf(pos);
            BasicEnemy enemy = new Doggie(new PathPosition(indexInPath, orderedPath));
            enemies.add(enemy);
            spawningEnemies.add(enemy);
            return enemy;
        }
        return null;
    }

    /**
     * Spawn Elan Muske
     * @return
     */
    public BasicEnemy SpawnElanEnemies() {
        if (character.getCycle() >= 40 && character.getExperience() >= 10000) {
            Pair<Integer, Integer> pos = spawn.getElan(character);
            List<BasicEnemy> spawningEnemies = new ArrayList<>();
            if (pos != null) {
                int indexInPath = orderedPath.indexOf(pos);
                BasicEnemy enemy = new ElanMuske(new PathPosition(indexInPath, orderedPath));
                enemies.add(enemy);
                spawningEnemies.add(enemy);
                Item doggieCoin = new DoggieCoin(null, null);
                ((DoggieCoin) doggieCoin).Increase(character);
                return enemy;
            }
        }
        return null;
    }

    /**
     * Spawn Enemies that are from buildings (i.e zombiepits etc)
     * @return
     */
    public List<BasicEnemy> SpawnEnemiesBuildings() {
        List<BasicEnemy> spawningEnemies = new ArrayList<>();
        for (Buildings building: buildingEntities) {
            if (building.InitialState(character, orderedPath) != null) {
                int index = spawn.NearBuilding(orderedPath, building.getX(), building.getY());
                BasicEnemy enemy = building.InitialState(character, orderedPath);
                enemy.setPosition(new PathPosition(index, orderedPath));
                spawningEnemies.add(enemy);
                enemies.add(enemy);
            }
        }
        return spawningEnemies;
    }

    /**
     * Reset enemies. Kill all enemies
     */
    public void resetEnemies() {
        List<BasicEnemy> kills = new ArrayList<BasicEnemy>();
        for (BasicEnemy enemy: enemies) {
            kills.add(enemy);
        }

        for (BasicEnemy enemy: kills) {
            killEnemy(enemy);
        }
        slugcount = 0;
        enemies.clear();
    }

    /**
     * kill an enemy
     * @param enemy enemy to be killed
     */
    private void killEnemy(BasicEnemy enemy){
        enemy.destroy();
        enemies.remove(enemy);
    }

    /**
     * Get the inventory for unequippedInventoryItems
     * @return
     */
    public List<Item> getInventory() {
        return unequippedInventoryItems;
    }


    /**
     * Battle
     */
    public void buildingInteractions() {
        boolean inCampFire = false;
        for (Buildings b: buildingEntities) {
            if (b instanceof Campfire) {
                if (((Campfire) b).checkInCampRadius(character, b) && attackDouble == false) {
                    inCampFire = true;
                    this.attackDouble = true;
                    b.NeutralState(character);
                } else if (attackDouble  && ((Campfire) b).checkInCampRadius(character, b) == false && inCampFire == false) {
                    inCampFire = false;
                    this.attackDouble = false;
                    character.setAttack(character.getAttack() / 2);
                }
            } else if (b instanceof Trap) {
                for (BasicEnemy e: enemies) {
                    if(e.getX() == b.getX() && e.getY() == b.getY()) {
                        b.BattleState(character, e);
                        if (e.getHealth() <= 0) {
                            e.destroy();
                            enemies.remove(e);
                        }
                        b.destroy();
                        buildingEntities.remove(b);
                        break;
                    }
                }
            } else {
                if (character.getX() == b.getX() && character.getY() == b.getY()) {
                    b.NeutralState(character);
                }
            }
        }
    }



    /**
     * run the expected battles in the world, based on current world state
     * @return list of enemies which have been killed
     */
    public boolean checkInBattleRadius(BasicEnemy e) {
        boolean inRadius = false; 
            if (Math.pow((character.getX()-e.getX()), 2) +  Math.pow((character.getY()-e.getY()), 2) < Math
                    .pow((character.getBattleRadius() + e.getBattleRadius()),2)){
                inRadius = true; 
            }
        return inRadius;
    }

    /**
     * 
     * @param battleEnemy
     * @param EnemiesInFight
     * @return
     */
    public List<BasicEnemy> addSuportEnemies(BasicEnemy battleEnemy, List<BasicEnemy> EnemiesInFight) {
        List<BasicEnemy> supportEnemies = new ArrayList<BasicEnemy>();
        for (BasicEnemy e : enemies) {
            if (Math.pow((e.getX() - battleEnemy.getX()), 2) + Math.pow((e.getY() - battleEnemy.getY()), 2) < Math
                    .pow(e.getSupportRadius(), 2)) {
                if (EnemiesInFight.contains(e) == false && supportEnemies.contains(e) == false) {
                    System.out.println("in radius" + e);
                    supportEnemies.add(e);
                    EnemiesInFight.add(e);
                }
            }
        }
        return supportEnemies;
    }

    /**
     * 
     * @param equippedItems
     * @param e
     */
    public void addItemEffect(List<Item> equippedItems, BasicEnemy e) {
        System.out.println("in items");
        for (Item i : equippedItems) {
            if (i instanceof Staff) {
                System.out.println("in items staff");
                Ally ally = ((Staff) i).useStaffEffect();
                if (ally != null) {
                    allies.add(ally);
                }
                System.out.println(allies);
            }
            if (i instanceof Shield) {
                ((Shield) i).useShieldEffect(e);
            }
            if (i instanceof Helmet) {
                ((Helmet) i).useHelmetEffect(e);
            }
            if (i instanceof Stake) {
                ((Stake) i).useStakeEffect(character, e);
            }
        }
    }

    /**
     * 
     * @param character
     * @param buildings
     * @param e
     */
    public void buildingBattles(Character character, List<Buildings> buildings, BasicEnemy e) {
        for (Buildings b : buildings) {
            if (b instanceof Tower && ((Tower) b).checkInBattleRadius(character, b, e)) {
                b.BattleState(character, e);
                System.out.println(e.getHealth());
            }
        }
    }

    /**
     * 
     * @param e
     * @param defeatedEnemies
     * @param allies
     * @return
     */
    public boolean alliesBattle(BasicEnemy e, List<BasicEnemy> defeatedEnemies, List<Ally> allies) {
        boolean enemyDead = false;
        for (Ally a : allies) {
            if (e.getHealth() <= 0) {
                enemyDead = true;
                defeatedEnemies.add(e);
                break;
            }
            if (a.getHealth() <= 0) {
                allies.remove(a);
                break;
            }
            e.setHealth(e.getHealth() - a.getAttack());
            a.setHealth(a.getHealth() - e.getDamage());
        }
        return enemyDead;
    }
    public void healAllEnemies(List<BasicEnemy> enemy) {
        for (BasicEnemy e: enemy) {
            e.setHealth(e.getMaxHealth());
        }
    }
    /**
     * 
     * @return
     */
    public List<BasicEnemy> runBattles() {
        List<BasicEnemy> defeatedEnemies = new ArrayList<BasicEnemy>();
        List<BasicEnemy> EnemiesInFight = new ArrayList<BasicEnemy>();
        boolean loseGame = false;
        
        for (BasicEnemy e: enemies){
            if (checkInBattleRadius(e)){
                EnemiesInFight.add(e);
                addSuportEnemies(e, EnemiesInFight);
            }
        }
        
        for (BasicEnemy e: EnemiesInFight) {
            if (loseGame) {
                break;
            }
            // Make a battle invent buff for this
            if (equippedInventoryItems != null) {
                addItemEffect(equippedInventoryItems, e);
            }

            // check for buildings
            if (buildingEntities != null) {
                buildingBattles(character, buildingEntities, e);
            }

            // Allies fight before character does.
            boolean enemyDead = false;
            if (allies != null) {
                enemyDead = alliesBattle(e,  defeatedEnemies, allies);
            }

            // Check if enemey is dead from the allies.
            if (enemyDead) {
                break;
            }

            while (character.getHealth() >= 0) {
                System.out.println("attt" + character.getAttack());

                // end the game if the character loses the game
                if (character.getHealth() <= 0) {
                    for (Item i : unequippedInventoryItems) {
                        if (i instanceof TheOneRing || i instanceof OneRingAndAnduril 
                            || i instanceof OneRingAndTreeStump) {
                            i.useItem(character);
                            unequippedInventoryItems.remove(i);
                            break;
                        }
                    }
                    loseGame = true;
                    break;
                }

                // End the battle is all the enemies are defeated 
                if (EnemiesInFight.size() == defeatedEnemies.size()){
                    break;
                }

                // Use a health potion if player hp islower than 50
                if (character.getHealth() <= 50) {
                    for (Item i : unequippedInventoryItems) {
                        if (i instanceof HealthPotion) {
                            i.useItem(character);
                            unequippedInventoryItems.remove(i);
                            break;
                        }
                    }
                }
                System.out.println(characterStun);
                System.out.println(e);

                // Character attacks enemy 
                if (characterStun == false) {
                    e.setHealth(e.getHealth() - character.getAttack());
                    // End the battle if enemy is defeated
                    if (e.getHealth() <= 0) {
                        if (e instanceof Doggie) {
                            Item doggieCoin = new DoggieCoin(null, null);
                            System.out.println("in doggie coin");
                            doggiesCoins.add(doggieCoin);
                            ((DoggieCoin)doggieCoin).Flucuate(character);
                            character.setDoggieCoin(character.getDoggieCoin() + 1);
                            addNewItemUnequipped(doggieCoin);
                        }
                        if (e instanceof ElanMuske) {
                            Item doggieCoin = new DoggieCoin(null, null);
                            ((DoggieCoin) doggieCoin).Plummet(character);
                            System.out.println(doggieCoin);
                        }
                        defeatedEnemies.add(e);
                        allEnemiesDeafeated.add(e);
                        break;
                    }
                }
                characterStun = false;
                int newHealth =  character.getHealth();
                // Enemy attacks cahracter
                if (e.deBuff(e.getDebuffChance())) {
                    System.out.println("in");
                    if (e instanceof Doggie) {
                        characterStun = true;
                    } else if (e instanceof ElanMuske) {
                        healAllEnemies(EnemiesInFight);
                    } else {
                        newHealth = character.getHealth() - e.getCriticalDamage();
                    }
                } else {
                    newHealth =  character.getHealth() - e.getDamage();
                }
                if (newHealth <= 0) {
                    newHealth = 0;
                }
                character.setHealth(newHealth);
            }
        }

        for (BasicEnemy e: defeatedEnemies){
            // IMPORTANT = we kill enemies here, because killEnemy removes the enemy from the enemies list
            // if we killEnemy in prior loop, we get java.util.ConcurrentModificationException
            // due to mutating list we're iterating over
            if (e instanceof Slug) {
                this.slugcount = slugcount - 1;
            }
            killEnemy(e);
        }
        
        return defeatedEnemies;
    }
    /**
     * spawn a card in the world and return the card entity
     * @return a card to be spawned in the controller as a JavaFX node
     */
    public Card loadCard(){
        // if adding more cards than have, remove the first card...
        if (cardEntities.size() >= getWidth()){
            int gold = character.getGold();
            character.setGold(gold + 100);
            removeCard(0);
        }

        Card randomCard = randomdrops.getPossibleCard();
        randomCard.setCoordinates(new SimpleIntegerProperty(cardEntities.size()), new SimpleIntegerProperty(0));
        cardEntities.add(randomCard);
        return randomCard;
    }

    /**
     * remove card at a particular index of cards (position in gridpane of unplayed cards)
     * @param index the index of the card, from 0 to length-1
     */
    private void removeCard(int index){
        Card c = cardEntities.get(index);
        int x = c.getX();
        c.destroy();
        cardEntities.remove(index);
        shiftCardsDownFromXCoordinate(x);
    }

    /**
     * 
     * @param building
     */
    public void addBuildingEntity(Buildings building) {
        buildingEntities.add(building);
    }


    /**
     * spawn a sword in the world and return the sword entity
     * @return a sword to be spawned in the controller as a JavaFX node
     */
    public Item addRandomItem(){
        Pair<Integer, Integer> firstAvailableSlot = getFirstAvailableSlotForItem();
        if (firstAvailableSlot == null){
            // eject the oldest unequipped item and replace it... oldest item is that at beginning of items
            int gold = character.getGold();
            character.setGold(gold + 100);
            int experience = character.getExperience();
            character.setExperience(experience + 50);
            removeItemByPositionInUnequippedInventoryItems(0);

            firstAvailableSlot = getFirstAvailableSlotForItem();
        }

        Item randomItem = randomdrops.getPossibleItem();
        randomItem.setCoordinates(new SimpleIntegerProperty(firstAvailableSlot.getValue0()), new SimpleIntegerProperty(firstAvailableSlot.getValue1()));
        unequippedInventoryItems.add(randomItem);
        return randomItem;
    }

    /**
     * remove an item by x,y coordinates
     * @param x x coordinate from 0 to width-1
     * @param y y coordinate from 0 to height-1
     */
    public void removeUnequippedInventoryItemByCoordinates(int x, int y){
        Item item = getUnequippedInventoryItemEntityByCoordinates(x, y);
        removeUnequippedInventoryItem(item);
    }

    /**
     * 
     * @param item
     */
    public void addNewItemUnequipped(Item item) {
        Pair<Integer, Integer> firstAvailableSlot = getFirstAvailableSlotForItem();
        if (firstAvailableSlot == null){
            // eject the oldest unequipped item and replace it... oldest item is that at beginning of items
            int gold = character.getGold();
            character.setGold(gold + 100);
            int experience = character.getExperience();
            character.setExperience(experience + 50);
            removeItemByPositionInUnequippedInventoryItems(0);
            firstAvailableSlot = getFirstAvailableSlotForItem();
        }
        item.setCoordinates(new SimpleIntegerProperty(firstAvailableSlot.getValue0()), new SimpleIntegerProperty(firstAvailableSlot.getValue1()));
        unequippedInventoryItems.add(item);
    }

    /**
     * run moves which occur with every tick without needing to spawn anything immediately
     */
    public void runTickMoves(){
        character.moveDownPath();
        moveBasicEnemies();
    }

    /**
     * remove an item from the unequipped inventory
     * @param item item to be removed
     */
    public void removeUnequippedInventoryItem(Item item){
        unequippedInventoryItems.remove(item);
    }

    /**
     * Destroys item from unequipped inventory
     * @param item
     */
    public void destroyItem(Item item) {
        item.destroy();
        removeUnequippedInventoryItem(item);
    }


    /**
     * return an unequipped inventory item by x and y coordinates
     * assumes that no 2 unequipped inventory items share x and y coordinates
     * @param x x index from 0 to width-1
     * @param y y index from 0 to height-1
     * @return unequipped inventory item at the input position
     */
    public Item getUnequippedInventoryItemEntityByCoordinates(int x, int y){
        for (Item i: unequippedInventoryItems){
            if ((i.getX() == x) && (i.getY() == y)){
                return i;
            }
        }
        return null;
    }


    /**
     * remove item at a particular index in the unequipped inventory items list (this is ordered based on age in the starter code)
     * @param index index from 0 to length-1
     */
    private void removeItemByPositionInUnequippedInventoryItems(int index){
        Item item = unequippedInventoryItems.get(index);
        item.destroy();
        unequippedInventoryItems.remove(index);
    }

    /**
     * get the first pair of x,y coordinates which don't have any items in it in the unequipped inventory
     * @return x,y coordinate pair
     */
    private Pair<Integer, Integer> getFirstAvailableSlotForItem(){
        // first available slot for an item...
        // IMPORTANT - have to check by y then x, since trying to find first available slot defined by looking row by row
        for (int y=0; y<unequippedInventoryHeight; y++){
            for (int x=0; x<unequippedInventoryWidth; x++){
                if (getUnequippedInventoryItemEntityByCoordinates(x, y) == null){
                    return new Pair<Integer, Integer>(x, y);
                }
            }
        }
        return null;
    }

    /**
     * shift card coordinates down starting from x coordinate
     * @param x x coordinate which can range from 0 to width-1
     */
    private void shiftCardsDownFromXCoordinate(int x){
        for (Card c: cardEntities){
            if (c.getX() >= x){
                c.x().set(c.getX()-1);
            }
        }
    }

    /**
     * move all enemies
     */
    private void moveBasicEnemies() {
        for (BasicEnemy e: enemies){
            e.move();
        }
    }


    /**
     * remove a card by its x, y coordinates
     * @param cardNodeX x index from 0 to width-1 of card to be removed
     * @param cardNodeY y index from 0 to height-1 of card to be removed
     * @param buildingNodeX x index from 0 to width-1 of building to be added
     * @param buildingNodeY y index from 0 to height-1 of building to be added
     */
    public Buildings convertCardToBuildingByCoordinates(int cardNodeX, int cardNodeY, int buildingNodeX, int buildingNodeY) {
        // start by getting card
        Card card = null;
        for (Card c: cardEntities){
            if ((c.getX() == cardNodeX) && (c.getY() == cardNodeY)){
                card = c;
                break;
            }
        }
        
        // now spawn building
        Buildings newBuilding = card.getBuilding();
        newBuilding.setCoordinates(new SimpleIntegerProperty(buildingNodeX), new SimpleIntegerProperty(buildingNodeY));
        buildingEntities.add(newBuilding);

        // destroy the card
        card.destroy();
        cardEntities.remove(card);
        shiftCardsDownFromXCoordinate(cardNodeX);

        return newBuilding;
    }

    /**
     * Get building from cards by coordinates. Coordinates is in the building
     * entity.
     * @param cardNodeX
     * @param cardNodeY
     * @return
     */
    public Buildings getBuildingfromCardsbyCoordinates(int cardNodeX, int cardNodeY) {
        for (Card c: cardEntities){
            if ((c.getX() == cardNodeX) && (c.getY() == cardNodeY)){
                return c.getBuilding();
            }
        }

        return null;
    }


    /**
     * Boolean on goals
     * @param character
     * @return
     */
    public boolean checkGoalsAchieved(Character character, LoopManiaWorld world) {
        if (goal.isSatisfied(character, world)) {
            return true;
        }
        return false;
    }

    /**
     * Add special items
     */
	public void rareItems(List<String> rareitems) {
        if (difficulty.getDifficulty() instanceof Confusing) {
            randomdrops.confusingItems();
            randomdrops.setDifficulty(difficulty);
        } else {
            randomdrops.rareItems(rareitems);
            randomdrops.setDifficulty(difficulty);
        }
	}

    /**
     * 
     * @return
     */
    public RandomDrop getRandomDrops() {
        return randomdrops;
    }

    /**
     * 
     * @param item
     */
    public void unequipItem(Item item) {
        unequippedInventoryItems.remove(item);
        item.destroy();
    }
}
