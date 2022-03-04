package unsw.loopmania;

import javafx.fxml.FXML;

public class MapsController {
    private MapStart mapstart;
    private int map;

    /**
     * 
     * @param map
     */
    public void setSwitcher(MapStart map) {
        this.mapstart = map;
    }

    /**
     * Get map
     * @return
     */
    public int getmap() {
        return map;
    }

    @FXML
    public void Stone() {
        this.map = 1;
    }

    @FXML
    public void Grass() {
        this.map = 2;
    }


    @FXML
    public void Wood() {
        this.map = 3;
    }

    @FXML
    public void Menu() {
        mapstart.start();
    }

}
