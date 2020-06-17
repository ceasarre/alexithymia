/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package alexithymia_jfx.game;

import static alexithymia_jfx.Constants.*;
import alexithymia_jfx.ResultWriter;

import alexithymia_jfx.menu.InfoLabel;
import alexithymia_jfx.menu.MenuViewManager;
import alexithymia_jfx.menu.Menu_Subscene;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.animation.AnimationTimer;

import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;

import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;

import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

/**
 *
 * @author Cezary Polak Class <code> Game Layout </code> is used to make the
 * View of the game
 */
public class GameLayout {

    private AnimationTimer gameLoopAnim;
    private ResultWriter resultWriter;

    private Results results;
    private int loopCounter = 0;
    private Boolean endLevel = false;
    private Pane gamePane;
    private ImageViewGameObj gameObject, bottom;
    private TextField textField;

    private MenuViewManager menu;
    private Stage menuStage;
    private LayoutButton button1, confirm_button, continue_button, exit_button, save_button;
    private AnchorPane pane;
    private Group root;
    private Scene scene;
    
    /**
     * Object which is an representation of the game's entity
     */
    public static ImageViewGameObj object;

    private Menu_Subscene endSubScene, exitSubScene, saveSubScene;

    /**
     * Creates a view of the game
     *
     * @param stage stage of the application
     */
    public GameLayout(Stage stage) {

        theGame(stage);

    }

    /**
     *Getsa Entity used in the game 
     * @return the game object
     */
    public ImageViewGameObj getObject() {
        return object;
    }

    /**
     *returns the scene of the game
     * @return Scene to the game
     */
    public Scene getScene() {
        return scene;
    }
    
    /**
     * Creates a game body
     * @param stage is a stage of the application
     */
    private void theGame(Stage stage) {

        pane = new AnchorPane();

        menuStage = stage;

        createButtons();
        createRandedEmotion();

        initGameEntieties();
        createBackground();

        addComponents();

        gameLoop();

        scene = new Scene(pane, GAMEWIDTH, GAMEHEIGHT);

        /*STAGE*/
        stage.setScene(scene);
    }

    /**
     * Creates button which allows to go to the menu
     */
    public void createButtons() {
        button1 = new LayoutButton("MENU");

        button1.setOnAction(e -> {
            gameLoopAnim.stop();
            exitSubScene.moveSubScene();
//            gameObjectList.clear();
//            menu = new MenuViewManager(menuStage);

        });

        button1.setLayoutX(400);
        button1.setLayoutY(GAMEHEIGHT - 55);

    }

    /**
     * Creates a button which call the Subscene to save results
     */
    public void createMenuButtons() {

        exit_button = new LayoutButton("SAVE & EXIT");

        exit_button.setOnAction(e -> {
            endSubScene.moveSubScene();

            System.out.println("SAVE SUBSCENE");
            saveSubScene.moveSubScene();

        });
        exit_button.setLayoutX(10);
        exit_button.setLayoutY(130);
        endSubScene.getPane().getChildren().add(exit_button);

    }

    /**
     * Creates button which confirms going to menu, and switches the scene
     */
    public void createConfirmButton() {
        confirm_button = new LayoutButton("EXIT");

        confirm_button.setOnAction(e -> {

            System.out.println("Confirmed");
            gameObjectList.clear();
            menu = new MenuViewManager(menuStage);

        });
        confirm_button.setLayoutX(10);
        confirm_button.setLayoutY(190);

    }
    
    /**
     * Creates button which allows player to continue the game
     */

    public void createContinueButton() {
        continue_button = new LayoutButton("CONTINUE");

        continue_button.setOnAction(e -> {

            System.out.println("Continued");
            exitSubScene.moveSubScene();
            gameLoopAnim.start();

        });
        continue_button.setLayoutX(10);
        continue_button.setLayoutY(130);
        exitSubScene.getPane().getChildren().add(continue_button);

    }

    /**
     * Creates button which allows player to save the results
     */
    public void createSaveButton() {
        save_button = new LayoutButton("SAVE");

        save_button.setOnAction(e -> {

            try {
                resultWriter = new ResultWriter(textField.getText() + " SCORE: " + results.getResults());
            } catch (IOException ex) {
                Logger.getLogger(GameLayout.class.getName()).log(Level.SEVERE, null, ex);
            }

            menu = new MenuViewManager(menuStage);
        });
        save_button.setLayoutX(50);
        save_button.setLayoutY(130);

    }

    /**
     * Create randed emotion name
     */
    private void createRandedEmotion() {

        root = new Group();
        Canvas canvas = new Canvas(GAMEWIDTH - 250, 100);
        root.getChildren().add(canvas);

        GraphicsContext gc = canvas.getGraphicsContext2D();

        gc.setFill(Color.CHARTREUSE);
        gc.setStroke(Color.BLACK);
        gc.setLineWidth(2);
        Font theFont = Font.font("Times New Roman", FontWeight.BOLD, 65);
        gc.setFont(theFont);

        /*OBJECT */
        object = new ImageViewGameObj();

        gc.fillText(object.getName().toUpperCase(), 10, 70);
        gc.strokeText(object.getName().toUpperCase(), 10, 70);

    }

    /**
     * Creates Background of the GameLayout
     */
    private void createBackground() {
        String path = "res/background/blue-snow.png";
        Image background = new Image(path, 400, 400, false, true);
        BackgroundImage backgroundImage = new BackgroundImage(background, BackgroundRepeat.REPEAT,
                BackgroundRepeat.REPEAT, BackgroundPosition.DEFAULT, null);
        pane.setBackground(new Background(backgroundImage));

    }

    /**
     * Adding coponents to the pane
     */
    public void addComponents() {

        pane.getChildren().add(gamePane);
        pane.getChildren().add(button1);
        pane.getChildren().add(root);
        createToMenuSubScene();
        createSaveSubscene();

    }

    /**
     * Initialize Game Entities
     */
    private void initGameEntieties() {
        gamePane = new Pane();
        /*OBJECTS OF EMOTION*/
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 5; j++) {
                gameObject = new ImageViewGameObj(gamePane, j * PICWIDTH,
                        -i * PICHEIGHT - PICHEIGHT);
//                System.out.println(gameObject.toString());
                if (gameObject.getIsDrawn()) {
                    System.out.println(gameObject.getName() + " OK");


                }
                /*
                ADDING TO LIST OF OBJECTS
                 */
                gameObjectList.add(gameObject);

            }
        }


        /*BOTTOM*/
        bottom = new ImageViewGameObj(gamePane);

    }

    /**
     * Game Loop
     */
    private void gameLoop() {

        gameLoopAnim = new AnimationTimer() {
            @Override
            public void handle(long now) {

                gameObjectList.forEach(object -> {
                    object.setY(object.getY() + object.dy);
                    if (bottom.getBounds().intersects(object.getBounds())) {

                        object.setIsEnded(true);

                    }
                });

                checkEnded();
                if (endLevel) {
                    System.out.println("END of LEVEL");

                    stop();
                    createEndSubScene();
                    endSubScene.moveSubScene();
                    /*CLEAR OBJECT LIST*/
                    gameObjectList.clear();

                }

            }

        };
        gameLoopAnim.start();
    }

    /**
     * Checks if the levele is ended
     */
    private void checkEnded() {
        /*
                        IS LEVEL ENDED?
         */
        endLevel = true;
        while (loopCounter < gameObjectList.size()) {

            if (!gameObjectList.get(loopCounter).getIsEnded()) {
                endLevel = false;
                break;
            }
            loopCounter++;
        }
    }

    /**
     * Creates subscene which is shown at the end of the level
     */
    private void createEndSubScene() {
        endSubScene = new Menu_Subscene();
        pane.getChildren().add(endSubScene);

        results = new Results();
        System.out.println(results.getResults());
//        
        InfoLabel infoLabel = new InfoLabel("YOUR ACCURACY: " + results.getResults());
        infoLabel.setLayoutX(10);
        infoLabel.setLayoutY(-20);
        endSubScene.getPane().getChildren().add(infoLabel);

        createMenuButtons();

        createConfirmButton();

        endSubScene.getPane().getChildren().add(confirm_button);

    }

    /**
     * Creates Subscene which is shown after clicking the "Menu" button
     */
    private void createToMenuSubScene() {
        exitSubScene = new Menu_Subscene();
        pane.getChildren().add(exitSubScene);

        InfoLabel infoLabel = new InfoLabel("R U SURE U WANT TO EXIT?");
        infoLabel.setLayoutX(10);
        infoLabel.setLayoutY(-40);
        exitSubScene.getPane().getChildren().add(infoLabel);

        createConfirmButton();

        createContinueButton();
        exitSubScene.getPane().getChildren().add(confirm_button);
    }
    
    /**
     * Creates subscene where you can save your results
     */
    private void createSaveSubscene() {
        saveSubScene = new Menu_Subscene();
        pane.getChildren().add(saveSubScene);

        createSaveButton();
        Label label1 = new Label("Name:");
        textField = new TextField();
        textField.setPromptText("Enter your first name.");
        textField.setPrefColumnCount(10);
        textField.getText();

        label1.setLayoutX(40);
        label1.setLayoutY(100);

        textField.setLayoutX(120);
        textField.setLayoutY(100);

        createSaveButton();

        saveSubScene.getPane().getChildren().addAll(label1, textField, save_button);
    }
}
