/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package adsprac1;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Anouk
 */
public class ADSPrac1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        System.out.println(initialize());
    }
    
    public static Box[] initialize() {
        File file = new File("C:\\Users\\Anouk\\Documents\\Third year AI\\Algoritmen en Datastructuren\\ADSPrac1\\src\\sample-A.1.in"); 
        // Anouk's pad: "C:\\Users\\Anouk\\Documents\\Third year AI\\Algoritmen en Datastructuren\\ADSPrac1\\src\\sample-A.1.in"
        // Marjolein's pad: 
        Scanner scan = null;
        try {
            scan = new Scanner(file);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(ADSPrac1.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        Box[] boxesList = new List()<Box>;
        
        int listSize = scan.nextInt(); // nodig?
        
        while (scan.hasNextLine()) {
            float length = scan.nextFloat();
            float width = scan.nextFloat();
            float height = scan.nextFloat();
            Box box = new Box(length, width, height);
            boxesList.add(box);
        }
        scan.close();
        
        return boxesList;
    }
    
    
}
