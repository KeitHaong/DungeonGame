package unsw.loopmania;

import java.io.IOException;
import java.util.Iterator;
import java.util.List;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import unsw.loopmania.Allitems.DoggieCoin;
import unsw.loopmania.DifficultyStates.Difficulty;

public class ShopController {
    /**
     * facilitates switching to main game
     */
    private ShopSwitcher shopSwitcher;
    private LoopManiaWorld world;
    private LoopManiaWorldController controller;
    private Difficulty diff;
    private Boolean buy = true;
    private Boolean sold = false;
    private ImageView selected_image;

    @FXML
    private GridPane Inventory;

    @FXML
    private GridPane Store;

    @FXML
    private Label Gold;

    @FXML
    private Label Cost;

    @FXML 
    private ImageView ShowItem;

    @FXML
    private Button Buy;

    @FXML
    private VBox Bought;

    private Item item_selected;

    public void setGameSwitcher(ShopSwitcher gameSwitcher){
        this.shopSwitcher = gameSwitcher;
    }

    public void setWorld(LoopManiaWorld world) {
        this.diff = world.getDifficulty();
        this.world = world;
    }

    public void setGold() {
        Gold.setText(String.valueOf(world.getCharacter().getGold()));
    }

    public void resetShop() {
        diff.resetPurchases();
        Bought.getChildren().clear();
    }

    
    public void spawnItems() {
        // add the empty slot images for the unequipped inventory
        List<Item> unequipped = world.getInventory();
        Iterator<Item> iterator = unequipped.iterator();

        GetImages images = new GetImages();

        for (int x=0; x<LoopManiaWorld.unequippedInventoryWidth; x++){
            for (int y=0; y<LoopManiaWorld.unequippedInventoryHeight + 1; y++){
                if (!iterator.hasNext()) {
                    break;
                }
                Item item = iterator.next();
                ImageView emptySlotView = new ImageView(images.getImages(item));
                emptySlotView.setOnMouseClicked((MouseEvent e) -> {
                    int cost = item.getCost();
                    ShowItem.setImage(images.getImages(item));
                    Cost.setText(String.valueOf(cost));
                    Buy.setText("Sell");
                    buy = false;
                    item_selected = item;
                    sold = true;
                    selected_image = emptySlotView;
                });

                Inventory.add(emptySlotView, x, y);
            }
        }


        List<Item> possibleitems = world.getRandomDrops().getAllPossibleItems();
        Iterator<Item> iterator2 = possibleitems.listIterator();

        //Items that can be bought
        for (int x=0; x<4; x++){
            for (int y=0; y<4; y++){
                if (!iterator2.hasNext()) {
                    break;
                }
                Item item = iterator2.next();
                ImageView emptySlotView = new ImageView(images.getImages(item));
                emptySlotView.setOnMouseClicked((MouseEvent e) -> {
                    lookprice(item);
                });
                Store.add(emptySlotView, x, y);
            }
        }

    }

    public void lookprice(Item item) {
        Buy.setText("Buy");
        buy = true;
        GetImages images = new GetImages();
        int cost = item.getCost();
        this.item_selected = item;
        ShowItem.setImage(images.getImages(item));
        Cost.setText(String.valueOf(cost));
    }


    public void setManiaController(LoopManiaWorldController controller) {
        this.controller = controller;
    }

    @FXML
    private void BuyItem() {
        Character character = world.getCharacter();
        int cost = item_selected.getCost();
        if (buy && character.getGold() > cost && diff.purchase_allowed(item_selected)) {
            GetImages images = new GetImages();
            ImageView currImg= new ImageView(images.getImages(item_selected));
            Bought.getChildren().addAll(currImg);
            world.addNewItemUnequipped(item_selected);
            controller.LoadItemFromShop(item_selected);
            character.setGold(character.getGold() - cost);
        } else if (!buy && sold) {
            if (item_selected instanceof DoggieCoin) {
                character.setDoggieCoin(character.getDoggieCoin() - 1);
            }
            character.setGold(character.getGold() + item_selected.getCost());
            world.unequipItem(item_selected);
            sold = false;
            Inventory.getChildren().remove(selected_image);
        }
        setGold();
    }

    /**
     * facilitates switching to game upon button click
     * @throws IOException
     */
    @FXML
    private void HandleExit() throws IOException {
        shopSwitcher.switchShop();
    }
}
