package unsw.loopmania;

import java.io.IOException;
import javafx.fxml.FXML;
import unsw.loopmania.DifficultyStates.Berserker;
import unsw.loopmania.DifficultyStates.Confusing;
import unsw.loopmania.DifficultyStates.DifficultyStates;
import unsw.loopmania.DifficultyStates.Standard;
import unsw.loopmania.DifficultyStates.Survival;

/**
 * controller for the main menu.
 * TODO = you could extend this, for example with a settings menu, or a menu to load particular maps.
 */
public class MainMenuController {
    /**
     * facilitates switching to main game
     */
    private MenuSwitcher gameSwitcher;
    private LoopManiaWorld world;
    private int map;

    public void setGameSwitcher(MenuSwitcher gameSwitcher){
        this.gameSwitcher = gameSwitcher;
    }


    public void setWorld(LoopManiaWorld world) {
        this.world = world;
    }

    public void setmap(int map) {
        this.map = map;
    }


    /**
     * facilitates switching to main game upon button click
     * @throws IOException
     */
    @FXML
    private void switchToGame() throws IOException {
        DifficultyStates standard = new Standard();
        world.setDifficulty(standard);
        world.setMap(map);
        gameSwitcher.switchMenu();
    }

    /**
     * facilitates switching to main game upon button click
     * @throws IOException
     */
    @FXML
    private void StartGameBerserker() throws IOException {
        DifficultyStates berserk = new Berserker();
        world.setMap(map);
        world.setDifficulty(berserk);
        System.out.println(world.getMap());
        gameSwitcher.switchMenu();
    }

    /**
     * facilitates switching to main game upon button click
     * @throws IOException
     */
    @FXML
    private void StartGameSurvival() throws IOException {
        DifficultyStates survive = new Survival();
        world.setDifficulty(survive);
        world.setMap(map);
        System.out.println("WEWEWE");
        System.out.println("map " + map);
        gameSwitcher.switchMenu();
    }

    /**
     * Initiatiates confusing mode on the game 
     * @throws IOException
     */
    @FXML
    private void StateGameConfusing() throws IOException {
        DifficultyStates confusing = new Confusing();
        world.setDifficulty(confusing);
        world.setMap(map);
        gameSwitcher.switchMenu();
    }

}
