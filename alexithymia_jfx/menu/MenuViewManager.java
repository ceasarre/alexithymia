/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package alexithymia_jfx.menu;

import static alexithymia_jfx.Constants.*;
import alexithymia_jfx.ResultReader;

import alexithymia_jfx.game.GameLayout;

import javafx.scene.Scene;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;

import javafx.scene.layout.*;
import javafx.stage.Stage;

/**
 *
 * @author Cezary Polak
 * Application's menu
 */
public class MenuViewManager {

    private ResultReader reader;
    
    
    private GameLayout startGame;
    private AnchorPane mainPane;
    private Scene scene;
    private Menu_Subscene helpSubScene;
    private Menu_Subscene scoreSubScene;

    private Menu_Subscene sceneToHide;

    private Stage gameStage;

    private final int MENU_BUTTONS_X_POS = 30;
    private final int MENU_BUTTONS_Y_POS = 100;

    
    
    /**
     * Returns the scene
     * @return Scene
     */
    public Scene getScene() {
        return scene;
    }

    /**
     * Creates the view of the menu
     * @param stage stage of the application
     */
    public MenuViewManager(Stage stage) {

        gameStage = stage;
        mainPane = new AnchorPane();
        scene = new Scene(mainPane, GAMEWIDTH, GAMEHEIGHT);
        createBackground();
        createButtons();
        creatLogo();


        gameStage.setScene(scene);
    }

    /**
     * shows subscene
     * @param subscene subscene of the game
     */
    private void showSubscene(Menu_Subscene subscene) {
        if (sceneToHide != null) {
            sceneToHide.moveSubScene();

        }
        subscene.moveSubScene();
        sceneToHide = subscene;
    }

    /**
     * Creates Buttons
     */
    public void createButtons() {
        createStartButton();
        createHelpButton();
        createScoreButton();
        createExitButton();
        initSubScenes();

    }

    /**
     * Creates Start Button
     */
    private void createStartButton() {
        GameButton b = new GameButton("START");
        addMenuButtons(b);
        b.setOnAction(e -> {
            startGame = new GameLayout(gameStage);
            menuButtons.clear();
        });

    }

    /**
     * Creates Help Button
     */
    private void createHelpButton() {
        GameButton b = new GameButton("HELP");
        addMenuButtons(b);

        b.setOnAction(e -> {
            showSubscene(helpSubScene);
        });

    }

    /**
     * Creates button to show the scores
     */
    private void createScoreButton() {
        GameButton b = new GameButton("LAST SCORES");
        addMenuButtons(b);
        b.setOnAction(e -> {
            showSubscene(scoreSubScene);
        });

    }

    /**
     * Creates button to exit
     */
    private void createExitButton() {
        GameButton b = new GameButton("EXIT");
        addMenuButtons(b);
        b.setOnAction(e -> {
            System.exit(1);
        });

    }

    /**
     * adding buttons to the menu
     * @param button is a button used in the menu
     */
    private void addMenuButtons(GameButton button) {
        button.setLayoutX(MENU_BUTTONS_X_POS);
        button.setLayoutY(MENU_BUTTONS_Y_POS + menuButtons.size() * 100);
        menuButtons.add(button);
        mainPane.getChildren().add(button);

    }

    /**
     * Initialize Subscenes
     */
    private void initSubScenes() {

        createHelpSubScene();
        createScoreSubScene();

    }

    /**
     * Creates Help Subscene
     */
    private void createHelpSubScene() {
        helpSubScene = new Menu_Subscene();
        mainPane.getChildren().add(helpSubScene);

        /*text in subscene*/
        InfoLabel infoLabel = new InfoLabel("SOME HELPFUL INFORMATIONS");
        infoLabel.setLayoutX(10);
        infoLabel.setLayoutY(0);
        helpSubScene.getPane().getChildren().add(infoLabel);

    }

    /**
    Creates score suscene
    */
    private void createScoreSubScene() {
        scoreSubScene = new Menu_Subscene();
        mainPane.getChildren().add(scoreSubScene);
        
        reader= new ResultReader();
        
        /*text in subscene*/
        InfoLabel infoLabel = new InfoLabel(reader.getReadedText());
        infoLabel.setLayoutX(10);
        infoLabel.setLayoutY(0);
        scoreSubScene.getPane().getChildren().add(infoLabel);

    }

    /**
     * Creates Backgorund of the menu
     */
    private void createBackground() {
        String path="res/background/blue-snow.png";
        Image background = new Image(path, 400, 400, false, true);
        BackgroundImage backgroundImage = new BackgroundImage(background, BackgroundRepeat.REPEAT,
                BackgroundRepeat.REPEAT, BackgroundPosition.DEFAULT, null);
        mainPane.setBackground(new Background(backgroundImage));

        
    }
    
    
/**
 * Creates Logo
 */
    public void creatLogo() {
        ImageView logo = new ImageView("res/logo/logo_gra.png");
        logo.setLayoutX(GAMEWIDTH / 2);
        logo.setLayoutY(MENU_BUTTONS_X_POS);

        logo.setOnMouseEntered(e -> {
            logo.setEffect(new DropShadow());
        });

        logo.setOnMouseExited(e -> {
            logo.setEffect(null);

        });
        mainPane.getChildren().add(logo);
    }

    /*
     
        .__(.)< (MEOW)
        \___)   
    
     */
}
