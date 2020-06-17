/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package alexithymia_jfx.game;

import static alexithymia_jfx.Constants.*;
import java.util.Random;
import javafx.geometry.Bounds;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;

/**
 *
 * @author Cezary Polak
 * Class <code> ImageViewGameObj </code> is a class which represents entities of the application
 */
public class ImageViewGameObj {

    /*VARIABLES*/
    /**
     * temporary int object used in object's path
     */
    public int tempIndex;
    /**
     * speed of entity
     */
    public double dy = 0.75;

    private boolean isEnded = false;
    private boolean isDrawn = false;
    private boolean isDestroyed = false;
    private Image image;
    private ImageView imageView;
    private String name;

    /* GETTERS*/
    
    /**
     * Checks if the entity achieved the bottom of the application
     * @return boolean
     */
    public boolean getIsEnded() {
        return isEnded;
    }
    
    /**
     * Checks if the name of object was drawn
     * @return if the object hited the bottom 
     */
    public boolean getIsDrawn() {
        return isDrawn;
    }

    /**
     * Checks if object was clicked
     * @return if the object is drawn
     */
    public boolean getIsDestroyed() {
        return isDestroyed;
    }

    /**
     * Returns the view of the Entity
     * @return ImageView of the object
     */
    public ImageView getImageView() {
        return imageView;
    }

    /**
     * Returns the name of the emotion
     * @return the name of object
     */
    public String getName() {
        return name;
    }

    /**
     *  Gets the X posiotion of the object
     * @return x position
     */
    public double getX() {
        return imageView.getX();
    }

    /**
     * Gets the Y position of the object
     * @return the y posiotion
     */
    public double getY() {
        return imageView.getY();
    }

    /**
     * Gets the hight of the object
     * @return hight of the object
     */
    public double getHeight() {
        return imageView.getImage().getHeight();
    }

    /**
     * Gets the width of the object
     * @return width of the object
     */
    public double getWidth() {
        return imageView.getImage().getWidth();
    }

     

    /*SETTERS*/
    
    /**
     * Sets isEnded paramater
     * @param isEnded is boolean
     */
    public void setIsEnded(boolean isEnded) {
        this.isEnded = isEnded;
    }
    
    /**
     * sets the X position of the entity
     * @param x is a x posiotion
     */
    public void setX(double x) {
        imageView.setX(x);
    }

    /**
     * Sets the Y posioton of the entity
     * @param y is a y posiotion of the entity 
     */
    public void setY(double y) {
        imageView.setY(y);
    }

    /**
     * Sets the view of the entity
     * @param imageView given to the method
     */
    public void setImageView(ImageView imageView) {
        this.imageView = imageView;
    }

    /**
     * Sets the boolean parameter when it is drawn
     * @param isDrawn 
     */
    public void setIsDrawn(boolean isDrawn) {
        this.isDrawn = isDrawn;
    }

    /**
     * Sets the boolean when the entity is clicked
     * @param isDestroyed 
     */
    public void setIsDestroyed(boolean isDestroyed) {
        this.isDestroyed = isDestroyed;
    }


    /*RAND LOGIC */
    /**
     * Rands the index of the photo to the path
     * @return index to the path
     */
    private int randPicIndex() {
        int var = 1;
        Random rand = new Random();
        var = rand.nextInt(5) + 1;
        return var;
    }

    /**
     * Rands the index of the emotion
     * @return index to the getEmotion method
     */
    private int randEmotion() {
        int var = 0;
        Random rand = new Random();
        var = rand.nextInt(6);
        return var;
    }

    /**
     * Returns the emotion's name
     * @param index index of the emotion
     * @return String
     */
    private String getEmotion(int index) {
        switch (index) {
            case 0:
                return "anger";

            case 1:
                return "disgust";

            case 2:
                return "fear";

            case 3:
                return "happiness";

            case 4:
                return "sadness";

            default:
                return "suprised";

        }
    }

    /*INFORMATION ABOUT BLOCK*/
    /**
     * Information about object
     * @return name and the position of the object
     */
    @Override
    public String toString() {
        return "GameObj: (" + " " + this.getName() + " " + this.getX() + " , " + this.getY() + ")]";
    }

    /*BOUNDS*/
    
    /**
     * 
     * @return bounds
     */
    public Bounds getBounds() {
        return imageView.getBoundsInParent();
    }

    /*CONSTRUCTOR*/
    
    /**
     * Creates the entity
     * @param root pane to which the entity is added
     * @param x x position
     * @param y  y posiotion
     */
    public ImageViewGameObj(Pane root, double x, double y) {

        tempIndex = randEmotion();
        this.name = getEmotion(tempIndex);
        tempIndex = randPicIndex();
        image = new Image("res/textures/" + name + tempIndex + ".png");
        imageView = new ImageView(image);

        imageView.setX(x);
        imageView.setY(y);

        imageView.setCache(true);


        /*  CHECK IF IS THE EMOTION DRAWN   */
        if (name.equals(GameLayout.object.getName())) {
            isDrawn = true;
        }
        
        imageView.setOnMouseClicked((MouseEvent e) -> {
            if (isDrawn) {
                System.out.println("BRAWO");

            } else {
                System.out.println("Clicked " + name);

            }
            imageView.setImage(null);
            isDestroyed = true;
            
        });
        
        imageView.setOnMouseEntered(e -> {
            
                imageView.setEffect(new DropShadow());
            
        });
        
        imageView.setOnMouseExited(e -> {
            
                imageView.setEffect(null);
            
        });
        
        root.getChildren().add(imageView);
    }

    /**
     * Default constuctor
     */
    public ImageViewGameObj() {

        tempIndex = randEmotion();
        this.name = getEmotion(tempIndex);
        tempIndex = randPicIndex();
        image = new Image("res/textures/" + name + tempIndex + ".png");
        imageView = new ImageView(image);

        imageView.setCache(true);

    }

    /**
     * Creates the bottom of the game
     * @param root pane to which the entity is added
     */
    public ImageViewGameObj(Pane root) {
        imageView = new ImageView(new Image("res/textures/sadness1.png",
                GAMEWIDTH, 1, false, true));
        imageView.setCache(true);
        imageView.setX(0);
        imageView.setY(GAMEHEIGHT + PICHEIGHT);
        root.getChildren().add(imageView);
    }
}
