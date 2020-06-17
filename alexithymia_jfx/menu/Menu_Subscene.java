/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package alexithymia_jfx.menu;

import static alexithymia_jfx.Constants.*;
import javafx.animation.TranslateTransition;
import javafx.scene.SubScene;

import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;

import javafx.util.Duration;


/**
 *
 * @author Cezary Polak
 * Class <code> Menu_Subscene </code> allows to create subscenes used in the application
 */
public class Menu_Subscene extends SubScene{
    

    private Boolean isHiden=true;
    private AnchorPane root2;



    /**
     * Gets the pane
     * @return pane used in subscene
     */
    public AnchorPane getPane() {
        return root2;
    }
    
    /**
     * Creates the subscene 
     */
    public Menu_Subscene() {
        super(new AnchorPane(),300,250);
        prefWidth(300);
        prefHeight(250);
        BackgroundImage image= new BackgroundImage(new Image(BACKGROUND_PANEL, 300, 250, false, true), 
                BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT, null);
        
        root2=(AnchorPane)this.getRoot();
        root2.setBackground(new Background(image));
        
        isHiden=true;
        
        setLayoutX(GAMEWIDTH);
        setLayoutY(180);
        


        
    }
    
    /**
     * Allows to show and hide the subscene
     */
    public void moveSubScene(){
        TranslateTransition tt= new TranslateTransition();
        tt.setDuration(Duration.seconds(0.3));
        tt.setNode(this);
         
        if(isHiden){
        tt.setToX(-GAMEWIDTH/2);
        isHiden=false;
        }
        else{
            tt.setToX(0);
            isHiden=true;
        }
        tt.play();
         
    }
    
    
}
