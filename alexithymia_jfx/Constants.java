/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package alexithymia_jfx;

import alexithymia_jfx.game.ImageViewGameObj;
import alexithymia_jfx.menu.GameButton;
import java.util.ArrayList;

/**
 *
 * @author Cezary Polak
 *
 * interface <code> Coonstants </code> used to declare constant variables in
 * application
 *
 */
public interface Constants {

    /**
     * Width of the entity in application
     */
    public static final int PICWIDTH = 125;
    /**
     * Height of the entity in application
     */
    public static final int PICHEIGHT = 180;
    /**
     * Width of the application's window
     */
    public static final int GAMEWIDTH = 625;
    /**
     * Height of the application's window
     */
    public static final int GAMEHEIGHT = 600;

    /**
     * Path to font
     */
    public final static String FONT_PATH = "src/res/fonts/FFF_Tusj.ttf";
    /**
     * Path to button image when it is pressed
     */
    public final static String BUTTON_PRESSED_STYLE = "-fx-background-color: transparent; -fx-background-image: url('res/button/blue_button05.png')";
    /**
     * Path to the button image when it is realesed
     */
    public final static String BUTTON_REALESD_STYLE = "-fx-background-color: transparent; -fx-background-image: url('res/button/blue_button04.png')";

    /**
     * Path to the image of the panel
     */
    public final static String BACKGROUND_PANEL = "res/panel/yellow_panel.png";

    /**
     * List of buttons used in a game
     */
    public ArrayList<GameButton> menuButtons = new ArrayList<>();

    /**
     * List of entities used in a game
     */
    public ArrayList<ImageViewGameObj> gameObjectList = new ArrayList<>();

}
