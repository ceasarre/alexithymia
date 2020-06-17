/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package alexithymia_jfx.menu;
import static alexithymia_jfx.Constants.FONT_PATH;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.text.Font;
/**
 *
 * @author Cezar Polak
 * Labels used in the game, which extends <code> Label </code> class
 */
public class InfoLabel extends Label{
    
    /**
     * Creates the label
     * @param text text to label
     */
    public InfoLabel(String text){
        
        setPrefHeight(250);
        setPrefWidth(300);
        setPadding(new Insets(20,20,20,20));
        setText(text);
        setWrapText(true);
        setLabelFont();
    }
    
    /**
     * Sets font of the label
     */
    private void setLabelFont(){
        try {
            setFont(Font.loadFont(new FileInputStream(FONT_PATH), 23));
        } catch (FileNotFoundException ex) {
            setFont(Font.font("Times New Roman", 23));
        }
    }
}
