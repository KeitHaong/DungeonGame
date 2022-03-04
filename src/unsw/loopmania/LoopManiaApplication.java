package unsw.loopmania;

import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;


/**
 * the main application
 * run main method from this class
 */
public class LoopManiaApplication extends Application {

    /**
     * the controller for the game. Stored as a field so can terminate it when click exit button
     */
    private LoopManiaWorldController mainController;

    @Override
    public void start(Stage primaryStage) throws IOException {
        // set title on top of window bar
        primaryStage.setTitle("Loop Mania");

        // prevent human player resizing game window (since otherwise would see white space)
        // alternatively, you could allow rescaling of the game (you'd have to program resizing of the JavaFX nodes)
        primaryStage.setResizable(false);



        // load the main game
        LoopManiaWorldControllerLoader loopManiaLoader = new LoopManiaWorldControllerLoader("world_with_twists_and_turns.json");
        loopManiaLoader.load();
        mainController = loopManiaLoader.loadController();
        FXMLLoader gameLoader = new FXMLLoader(getClass().getResource("LoopMainView2.fxml"));
        gameLoader.setController(mainController);
        Parent gameRoot = gameLoader.load();

        // load the main menu
        MainMenuController mainMenuController = new MainMenuController();
        FXMLLoader menuLoader = new FXMLLoader(getClass().getResource("MainMenuView.fxml"));
        menuLoader.setController(mainMenuController);
        Parent mainMenuRoot = menuLoader.load();

        // create new scene with the main menu (so we start with the main menu)
        // Scene scene = new Scene(mainMenuRoot);
        // mainMenuController.setWorld(mainController.getWorld());


        //load the map loader
        MapsController mapsController = new MapsController();
        FXMLLoader maploader = new FXMLLoader(getClass().getResource("Background.fxml"));
        maploader.setController(mapsController);
        Parent mapRoot = maploader.load();
        
        // set functions which are activated when button click to switch menu is pressed
        // e.g. from main menu to start the game, or from the game to return to main menu
        Scene scene3 = new Scene(mainMenuRoot);
        mainMenuController.setWorld(mainController.getWorld());
        mainController.setMainMenuSwitcher(() -> {
            switchToRoot(scene3, mainMenuRoot, primaryStage);
            mainMenuController.setWorld(mainController.getWorld());
        });
        mainMenuController.setGameSwitcher(() -> {
            switchToRoot(scene3, gameRoot, primaryStage);
            mainController.startTimer();
        });

        // create new scene with the map
        Scene scene = new Scene(mapRoot); 
        mapsController.setSwitcher(() -> {
            switchToRoot(scene3, mainMenuRoot, primaryStage);
            mainMenuController.setmap(mapsController.getmap());
        }
        );


        //load the shop
        ShopController shopcontroller = new ShopController();
        FXMLLoader shoploader = new FXMLLoader(getClass().getResource("Shop.fxml"));
        LoopManiaWorld world = loopManiaLoader.getWorld();
        shopcontroller.setWorld(world);
        shoploader.setController(shopcontroller);
        Parent shopRoot = shoploader.load();

        Scene scene2 = new Scene(shopRoot);
        mainController.setShopSwitcher(() -> {
            shopcontroller.setWorld(mainController.getWorld());
            mainController.pause();
            shopcontroller.setGold();
            shopcontroller.spawnItems();
            shopcontroller.setManiaController(mainController);
            shopcontroller.resetShop();
            switchToRoot(scene2, shopRoot, primaryStage);
        });
        shopcontroller.setGameSwitcher(() -> {
            switchToRoot(scene3, gameRoot, primaryStage);
            mainController.startTimer();
        });
        
        //Load skill tree
        SkillController skillcontroller = new SkillController();
        FXMLLoader skillloader = new FXMLLoader(getClass().getResource("SkillTree.fxml"));
        skillcontroller.setWorld(world);
        skillloader.setController(skillcontroller);
        Parent skillRoot = skillloader.load();
        Scene skilltree = new Scene(skillRoot);

        skillcontroller.setSkillSwitcher(() -> {
            skillcontroller.setWorld(mainController.getWorld());
            switchToRoot(scene3,gameRoot,primaryStage);
            mainController.startTimer();
        });

        mainController.setSkillSwitcher(() -> {
            skillcontroller.setWorld(mainController.getWorld());
            skillcontroller.setExperience();
            switchToRoot(skilltree, skillRoot, primaryStage);
        });


        gameRoot.requestFocus();
        scene3.getRoot().setStyle("-fx-font-family: 'serif'");
        primaryStage.setScene(scene);
        primaryStage.show();
        
    }

    @Override
    public void stop(){
        // wrap up activities when exit program
        mainController.terminate();
    }


    /**
     * switch to a different Root
     */
    private void switchToRoot(Scene scene, Parent root, Stage stage){
        scene.setRoot(root);
        root.requestFocus();
        stage.setScene(scene);
        stage.sizeToScene();
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
