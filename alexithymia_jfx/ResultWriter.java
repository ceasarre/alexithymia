/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package alexithymia_jfx;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 *
 * @author Cezary Polak
 * Class <code> ResultWriter </code> allows to write a text at the begging of the file
 */
public class ResultWriter {

    /**
     * Path to the file
     */
    private String fileName= "src/res/files/results.txt";
    
    /**
     * Constructor which take the String object to save at the beggining of file 
     * @param toSave is a text to save
     * @throws IOException if the path to file is wrong or the file is opened
     */
    public ResultWriter(String toSave) throws IOException {
        
        File mFile = new File(fileName);
        FileInputStream finputstream = new FileInputStream(mFile);

        BufferedReader br = new BufferedReader(new FileReader(mFile));

        String result = "";
        String line = "";
        while ((line = br.readLine()) != null) {
            result = result + line+ "\n";
        }

        result = toSave + "\n"+ result;

        mFile.delete();
        FileOutputStream fos = new FileOutputStream(mFile);
        fos.write(result.getBytes());
        fos.flush();
    }

}
