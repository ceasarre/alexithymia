/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package alexithymia_jfx.menu;

import static alexithymia_jfx.Constants.*;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import javafx.scene.control.Button;
import javafx.scene.effect.DropShadow;
import javafx.scene.input.MouseButton;
import javafx.scene.text.Font;

/**
 *
 * @author Cezary Polak
 * Buttons to the Menu
 */
public class GameButton extends Button {

    /**
     * Creates button used in the menu
     * @param text text to the button
     */
    public GameButton(String text) {
        setText(text);
        setButtonFont();
        setPrefWidth(190);
        setPrefHeight(49);
        setStyle(BUTTON_REALESD_STYLE);
        initButtonLiseners();
        setLayoutX(10);
        setLayoutY(10);
        
    }

    /**
     * Sets button font
     */
    private void setButtonFont() {
        try {
            setFont(Font.loadFont(new FileInputStream(FONT_PATH), 23));
        } catch (FileNotFoundException ex) {
            setFont(Font.font("Times New Roman", 23));
        }
    }

    /**
     * Sets the style when the button is pressed
     */
    private void setButtonPressedStyle() {
        setStyle(BUTTON_PRESSED_STYLE);
        setPrefHeight(41);
        setLayoutY(getLayoutY() + 4);

    }

    /**
     * Sets the style when the button is realsed
     */
    private void setButtonRealesedStyle() {
        setStyle(BUTTON_REALESD_STYLE);
        setPrefHeight(49);
        setLayoutY(getLayoutY() - 4);
    }

    /**
     * Initialize button listeners
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
