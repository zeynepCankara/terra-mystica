package gameSceneManager;

import javafx.scene.Scene;
import javafx.scene.image.ImageView;

public class BoardGenerator {

    public Scene generateMap(Scene scene, int[] terrainIdList ){

        ImageView[] map = new ImageView[113];
        int x = 0;
        int y = 0;

        //scene.getStylesheets().clear();
        scene.getStylesheets().add(getClass().getResource("terrain.css").toExternalForm());

        for( int i = 0; i < 113; i++ ){
            switch(terrainIdList[i]){
                case 0:
                    map[i] = (ImageView) scene.lookup("#plains");
                    break;
                case 1:
                    map[i] = (ImageView) scene.lookup("#swamp");
                    break;
                case 2:
                    map[i] = (ImageView) scene.lookup("#lakes");
                    break;
                case 3:
                    map[i] = (ImageView) scene.lookup("#forest");
                    break;
                case 4:
                    map[i] = (ImageView) scene.lookup("#mountains");
                    break;
                case 5:
                    map[i] = (ImageView) scene.lookup("#wasteland");
                    break;
                case 6:
                    map[i] = (ImageView) scene.lookup("#desert");
                    break;
                case 7:
                    map[i] = (ImageView) scene.lookup("#river");
                    break;
            }
        }
        return scene;
    }
}
