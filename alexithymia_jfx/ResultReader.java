/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package alexithymia_jfx;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 * @author Cezary Polak
 * 
 * Class <code> ResultReader </code> allows to read results form the file
 * 
 */
public class ResultReader {
    
    private String fileName= "src/res/files/results.txt";
    private String line="";
    private BufferedReader br;
    private String readedText="";

    /**
     * Gets text from file
     * @return returns readed text
     */
    public String getReadedText() {
        return readedText;
    }
    
    /**
     * Default constructor
     * 
     */
    public ResultReader() {
        
        try{
            
            br= new BufferedReader(new FileReader(fileName));
            

        for(int i=0; i<4; i++){
            line=br.readLine();
            readedText+=line+"\n";
            System.out.println(line);
        }
        
        }
        catch(IOException e){
            e.printStackTrace();
        }
        
     finally{
            try{
                br.close();
            }
            catch(IOException e){
                e.printStackTrace();
            }
        }
    }
    
    
}
