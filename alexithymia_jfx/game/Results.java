/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package alexithymia_jfx.game;

import static alexithymia_jfx.Constants.*;
/**
 *
 * @author Cezary Polak
 * Results of the game
 */
public class Results {
    
    private double correct=0;
    private double incorrect=0;
    private double drawn=0;
    private double accuracy=0;

    /**
     * Gets the player's accuracy
     * @return player's accuracy
     */
    public double getAccuracy() {
        return accuracy;
    }
    
    /**
     * Creates player's results
     */
    public Results(){
        gameObjectList.forEach(object ->{
            if(object.getIsDrawn()==true){
                drawn++;
                if(object.getIsDestroyed()==true)
                    correct++;
            }
            if(object.getIsDestroyed()==true && object.getIsDrawn()==false)
                incorrect++;
            accuracy=100*correct/(drawn+incorrect);
        });
        
    }
    
    /**
     *  Gets the accuracy in %
     * @return player's accuracy in %
     */
    public String getResults(){
        
        return (int)getAccuracy()+ " %";
    }
}
