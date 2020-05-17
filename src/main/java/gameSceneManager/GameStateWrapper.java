package gameSceneManager;


import javafx.scene.paint.Color;

/**
 * Class for fetching the game state from UI scenes
 * Created for establishing a protocol between logic and UI
 * Turn this class into an instance, test the class
 * Place the logic items  UI use
 * @author Zeynep Cankara
 * @version 17.05.2020
 */

public class GameStateWrapper {
    // [Logic related]
    // Map state (default: 1), (random: 0)
    static Integer mapType = GameSetupController.gameState.get("isDefaultMap");
    // Player's faction
    static String factionName = GameSetupController.factionNames[GameSetupController.gameState.get("factionId")];
    // Action chosen by the Player
    static Integer actionTaken = LocalGameController.gameStateLocal.get("action");
    // The terrain tile (hexagon) id selected by the Player
    static  Integer terrainSelected = LocalGameController.gameStateLocal.get("terrainSelected");
    // The player selects dwelling build action (yes: 1), (no: 0)
    static  Integer buildDwellingSelected = LocalGameController.gameStateLocal.get("isBuildDwelling");
    // The cult board selected  by the Player 0 (fire), 1 (water),  2 (earth), 3 (air), -1 (not init)
    static  Integer cultSelected = LocalGameController.gameStateLocal.get("cultId");
    /*
     0: Not enough priest.
     1: You need key to proceed
     2: Move 3 steps, occupy top left slot 
     3: Move 2 steps, occupy top right slot 
     4: Move 2 steps, occupy bottom left slot 
     5: Move 2 steps, occupy bottom right slot 
     6: All slots are occupied 
     */
    static Integer placePriestPosition = LocalGameController.gameStateLocal.get("priestInitPos");


    // [UI related]
    // Terrain Color id of the faction
    Integer terrainColorId;
    Color terrainColor;

    // Getters
    public static String getFaction(){
           return factionName;
    }
    public static Integer getActionTaken(){
        return actionTaken;
    }
    public static Integer getTerrainSelected(){
        return terrainSelected;
    }
    public static Integer getBuildDwellingSelected(){
        return buildDwellingSelected;
    }
    public static Integer getMapType(){
        return mapType;
    }
    public static Integer getCultSelected(){
        return cultSelected;
    }
    public static Integer getPlacePriestPosition(){
        return placePriestPosition;
    }

    // Updaters
    public static void updateFaction(){
        factionName = GameSetupController.factionNames[GameSetupController.gameState.get("factionId")];
    }
    public static void updateActionTaken(){
        actionTaken =  LocalGameController.gameStateLocal.get("action");
    }
    public static void updateTerrainSelected(){
        terrainSelected = LocalGameController.gameStateLocal.get("terrainSelected");
    }
    public static void updateMapType(){
        mapType = GameSetupController.gameState.get("isDefaultMap");
    }
    public static void updateCultSelected(){
        cultSelected = LocalGameController.gameStateLocal.get("cultId");
    }
    public static void updateBuildDwellingSelected(){
        buildDwellingSelected = LocalGameController.gameStateLocal.get("isBuildDwelling");
    }
    public static void updatePlacePriestPosition(){
        placePriestPosition = LocalGameController.gameStateLocal.get("priestInitPos");
    }

    //TODO: Functions needed for UI interactions

    /**
     * Lookup to see whether user exists in the database
     * @param username username entered  by the user
     * @param password password entered by the user
     */
    public static boolean validateUsername(String username, String password){
        //TODO: Establish server communication
        return true;
    }


}
