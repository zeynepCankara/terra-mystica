package gameSceneManager;

import javafx.scene.Scene;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import javafx.scene.shape.Polygon;

import java.util.HashMap;

/**
 * Class for generating a terrain maps
 * @author Zeynep Cankara
 * @version 13.05.2020
 */

public class BoardGenerator {
    // Properties: Logic Related
    static HashMap<Integer, Color> terrainColorMap = new HashMap<Integer, Color>();
    // Define the terrain colors (7 Terrain type) + River
    static Color riverColor = Color.DARKBLUE;
    static Color desertColor = Color.LIGHTGOLDENRODYELLOW;
    static Color swampColor = Color.DARKGREEN;
    static Color forestColor = Color.FORESTGREEN;
    static Color mountainColor = Color.BROWN;
    static Color lakeColor = Color.BLUE;
    static Color wastelandColor = Color.SADDLEBROWN;
    static Color plainColor = Color.DARKORANGE;


    // Contains terrainIdList which will be used to initialize the terrain map to defaultMap
    public static final int[] DEFAULT_MAP = {
            0, 4, 3, 2, 6, 5, 0, 1, 5, 3, 2, 5, 1,
            6, 7, 7, 0, 1, 7, 7, 6, 1, 7, 7, 6,
            7, 7, 1, 7, 4, 7, 3, 7, 3, 7, 4, 7, 7,
            3, 2, 6, 7, 7, 5, 2, 7, 5, 7, 5, 0,
            1, 0, 5, 2, 1, 0, 4, 6, 7, 7, 3, 1, 2,
            4, 3, 7, 7, 6, 3, 7, 7, 7, 0, 4, 0,
            7, 7, 7, 4, 7, 5, 7, 3, 7, 6, 2, 2, 6,
            6, 2, 0, 7, 7, 7, 2, 1, 7, 4, 0, 4,
            5, 1, 4, 2, 5, 3, 6, 0, 4, 7, 2, 3, 5
    };

    /**
     * Maps the terrainTypes to colorId
     */
    private static void initTerrainColorMap(){
        terrainColorMap.put(0, plainColor);
        terrainColorMap.put(1,swampColor);
        terrainColorMap.put(2,lakeColor);
        terrainColorMap.put(3, forestColor);
        terrainColorMap.put(4, mountainColor);
        terrainColorMap.put(5, wastelandColor);
        terrainColorMap.put(6, desertColor);
        terrainColorMap.put(7, riverColor);
    }

    /**
     * Generates the default terrain map
     */
    public static Scene generateDefaultTerrainMap(Scene scene) {
        initTerrainColorMap();

        for (int i = 0; i < 113; i++){
            Polygon hexagon = (Polygon) scene.lookup("#" +i);
            hexagon.setFill(terrainColorMap.get(DEFAULT_MAP[i]));
        }
        return scene;
    }

    /**
     * Generates the random terrain map
     */
    public static Scene generateRandomTerrainMap(Scene scene) {
        initTerrainColorMap();


        for (int i = 0; i < 113; i++){
            Polygon hexagon = (Polygon) scene.lookup("#" +i);
            hexagon.setFill(terrainColorMap.get(DEFAULT_MAP[i]));
        }
        return scene;
    }

}
