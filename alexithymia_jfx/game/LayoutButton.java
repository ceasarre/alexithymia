/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package alexithymia_jfx.game;


import static alexithymia_jfx.Constants.BUTTON_PRESSED_STYLE;
import static alexithymia_jfx.Constants.BUTTON_REALESD_STYLE;
import static alexithymia_jfx.Constants.FONT_PATH;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import javafx.scene.control.Button;
import javafx.scene.effect.DropShadow;
import javafx.scene.input.MouseButton;
import javafx.scene.text.Font;

/**
 *
 * @author Cezary Polak
 * Buttons to the game which extends <code> Button </code>
 */
public class LayoutButton extends Button{
    
    /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
    
/**
 *
 * @author Czarek
 */

    /**
     * Creates the button
     * @param text text to the button
     */
    public LayoutButton(String text) {
        setText(text);
        setButtonFont();
        setPrefWidth(190);
        setPrefHeight(49);
        setStyle(BUTTON_REALESD_STYLE);
        initButtonLiseners();

        
    }

    /**
     * Sets Font used in the button
     */
    private void setButtonFont() {
        try {
            setFont(Font.loadFont(new FileInputStream(FONT_PATH), 23));
        } catch (FileNotFoundException ex) {
            setFont(Font.font("Times New Roman", 23));
        }
    }

    /**
     * Sets the style when the button is presed
     */
    private void setButtonPressedStyle() {
        setStyle(BUTTON_PRESSED_STYLE);
        setPrefHeight(41);
        setLayoutY(getLayoutY() + 4);

    }

    /**
     * Sets the style when the button is ealsed
     */
    private void setButtonRealesedStyle() {
        setStyle(BUTTON_REALESD_STYLE);
        setPrefHeight(49);
        setLayoutY(getLayoutY() - 4);
    }

    /**
     * Initialize the button listeners
     */
    private void initButtonLiseners() {
        setOnMousePressed(e -> {
            if (e.getButton().equals(MouseButton.PRIMARY)) {
                setButtonPressedStyle();
            }
        });

        setOnMouseReleased(e -> {
            if (e.getButton().equals(MouseButton.PRIMARY)) {
                setButtonRealesedStyle();
            }
        });
        
        setOnMouseEntered(e -> {
            
                setEffect(new DropShadow());
            
        });
        
        setOnMouseExited(e -> {
            
                setEffect(null);
            
        });
        
    }
       

}
