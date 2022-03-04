package unsw.loopmania;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.javatuples.Pair;

import unsw.loopmania.AllBuildings.Barracks;
import unsw.loopmania.AllBuildings.Buildings;
import unsw.loopmania.AllBuildings.Campfire;
import unsw.loopmania.AllBuildings.Tower;
import unsw.loopmania.AllBuildings.Trap;
import unsw.loopmania.AllBuildings.VampireCastle;
import unsw.loopmania.AllBuildings.Village;
import unsw.loopmania.AllBuildings.ZombiePit;
import unsw.loopmania.Enemies.BasicEnemy;
import unsw.loopmania.Enemies.Doggie;

public class Spawn {
    private List<Pair<Integer, Integer>> orderedPath;
    private int elan = 0;
    private Random random;
    private int doggie = 0;

    public void setSpawn(List<Pair<Integer, Integer>> spawn) {
        this.orderedPath = spawn;
        this.random = new Random(System.currentTimeMillis());
    }

    public void setSpawn(List<Pair<Integer, Integer>> spawn, long seed) {
        this.orderedPath = spawn;
        this.random = new Random(seed);
    }

    /**
     * Gets nearest tile near building to spawn an enemy
     * @param orderedPath
     * @param X
     * @param Y
     * @return
     */
    public int NearBuilding(List<Pair<Integer, Integer>> orderedPath, int X, int Y) {
        int index = 0;
        Pair<Integer, Integer> value = orderedPath.get(0);
        int x = value.getValue0();
        int y = value.getValue1();
        int a = x - X;
        int b = y - Y;
        double c = Math.sqrt(Math.abs(Math.pow(a, 2) + Math.pow(b, 2)));
        double distance = c;
        for (Pair<Integer, Integer> pair : orderedPath) {
            x = pair.getValue0();
            y = pair.getValue1();
            a = X - x;
            b = Y - y;
            c = Math.sqrt(Math.abs(Math.pow(a, 2) + Math.pow(b, 2)));
            if (c <= distance) {
                distance = c;
                index = orderedPath.indexOf(pair);
            }
        }
        return index;
    }

    /**
     * Returns spawn location of slug
     * @param slugcount
     * @param character
     * @return
     */
    public Pair<Integer, Integer> GetBasicEnemySpawnPosition(int slugcount, Character character) {
        int choice = random.nextInt(3); 
        //6 slugs on the field maximum
        if ((choice == 0) && (slugcount < 6)){
            List<Pair<Integer, Integer>> orderedPathSpawnCandidates = new ArrayList<>();
            int indexPosition = orderedPath.indexOf(new Pair<Integer, Integer>(character.getX(), character.getY()));
            // inclusive start and exclusive end of range of positions not allowed
            int startNotAllowed = (indexPosition - 2 + orderedPath.size())%orderedPath.size();
            int endNotAllowed = (indexPosition + 3)%orderedPath.size();
            // note terminating condition has to be != rather than < since wrap around...
            for (int i=endNotAllowed; i!=startNotAllowed; i=(i+1)%orderedPath.size()){
                orderedPathSpawnCandidates.add(orderedPath.get(i));
            }

            // choose random choice
            Pair<Integer, Integer> spawnPosition = orderedPathSpawnCandidates.get(random.nextInt(orderedPathSpawnCandidates.size()));

            return spawnPosition;
        }
        return null;
    }

    /**
     * If building is spawnable on the path
     * @pre building is not null
     * @param building
     * @param x
     * @param y
     * @return
     */
    public Boolean ifSpawnable(Buildings building, int x, int y) {
        if (building instanceof VampireCastle || building instanceof ZombiePit || building instanceof Tower || 
            building instanceof Campfire) {
            for (Pair<Integer, Integer> pair: orderedPath) {
                int a = pair.getValue0();
                int b = pair.getValue1();
                if (a == x && b == y) {
                    return false;
                }
            }
            return true;
        }

        if (building instanceof Village || building instanceof Barracks || building instanceof Trap) {
            for (Pair<Integer, Integer> pair: orderedPath) {
                int a = pair.getValue0();
                int b = pair.getValue1();
                if (a == x && b == y) {
                    return true;
                }
            }
        } 

        return false;
    }  
    
    /**
     * Spawns Doggie in the world, ensures one doggie is in the world at a time
     */
    public Pair<Integer, Integer> getDoggie(Character character) {
        if (doggie == 0) {
            doggie += 1;
            List<Pair<Integer, Integer>> orderedPathSpawnCandidates = new ArrayList<>();
            int indexPosition = orderedPath.indexOf(new Pair<Integer, Integer>(character.getX(), character.getY()));
            // inclusive start and exclusive end of range of positions not allowed
            int startNotAllowed = (indexPosition - 2 + orderedPath.size())%orderedPath.size();
            int endNotAllowed = (indexPosition + 3)%orderedPath.size();
            // note terminating condition has to be != rather than < since wrap around...
            for (int i=endNotAllowed; i!=startNotAllowed; i=(i+1)%orderedPath.size()){
                orderedPathSpawnCandidates.add(orderedPath.get(i));
            }

            // choose random choice
            Pair<Integer, Integer> spawnPosition = orderedPathSpawnCandidates.get(random.nextInt(orderedPathSpawnCandidates.size()));
            return spawnPosition;
        }
        return null;
    }
    
    public Pair<Integer, Integer> getElan(Character character) {
        if (elan == 0) {
            elan += 1;
            List<Pair<Integer, Integer>> orderedPathSpawnCandidates = new ArrayList<>();
            int indexPosition = orderedPath.indexOf(new Pair<Integer, Integer>(character.getX(), character.getY()));
            // inclusive start and exclusive end of range of positions not allowed
            int startNotAllowed = (indexPosition - 2 + orderedPath.size()) % orderedPath.size();
            int endNotAllowed = (indexPosition + 3) % orderedPath.size();
            // note terminating condition has to be != rather than < since wrap around...
            for (int i = endNotAllowed; i != startNotAllowed; i = (i + 1) % orderedPath.size()) {
                orderedPathSpawnCandidates.add(orderedPath.get(i));
            }

            // choose random choice
            Pair<Integer, Integer> spawnPosition = orderedPathSpawnCandidates
                    .get(random.nextInt(orderedPathSpawnCandidates.size()));
            return spawnPosition;
        }
        return null;
    }
}
