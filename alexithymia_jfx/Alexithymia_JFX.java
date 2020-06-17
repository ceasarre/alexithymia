/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package alexithymia_jfx;


//import alexithymia_jfx.game.Game;
import alexithymia_jfx.game.GameLayout;
import alexithymia_jfx.menu.*;
import static alexithymia_jfx.Constants.*;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

/**
 *
 * @author Cezary Polak
 */
public class Alexithymia_JFX extends Application {

    private MenuViewManager viewManager;
    private GameLayout layout;
    private Scene scene;
    @Override
    public void start(Stage stage) {

/*
Game
*/
        viewManager= new MenuViewManager(stage);
//        ResultReader reader= new ResultReader();



        stage.setTitle("THE GAME");

        stage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

}
