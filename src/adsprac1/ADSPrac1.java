/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package adsprac1;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.LinkedList;
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
        Box[] list = initializeBoxes();
    }
    
    private static Box[] initializeBoxes() {
        File file = new File("C:\\Users\\Anouk\\Documents\\Third year AI\\Algoritmen en Datastructuren\\ADSPrac1\\src\\sample-A.1.in"); 
        // Anouk's pad: "C:\\Users\\Anouk\\Documents\\Third year AI\\Algoritmen en Datastructuren\\ADSPrac1\\src\\sample-A.1.in"
        // Marjolein's pad: 
        Scanner scan = null;
        try {
            scan = new Scanner(file);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(ADSPrac1.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        int listSize = scan.nextInt(); // nodig?
        Box[] boxesList;
        boxesList = new Box[listSize];
        
        for (int pos = 0; pos<listSize; pos++) {
            float length = Float.parseFloat(scan.next());
            float width = Float.parseFloat(scan.next());
            float height = Float.parseFloat(scan.next());
            Box box = new Box(length, width, height);
            System.out.println(box.toString());
            boxesList[pos] = box;
            
        }
        scan.close();
        
        return boxesList;
    }
    
    public static LinkedList<Box>[] toAdjacencyList(Box[] boxes){
        //voor ieder paar boxes kijken of de een in de ander past --> functie voor schrijven
        //als een box1 in box2 past, voeg box2 toe aan LinkedList van box1
        
        
    }
    
    /*
    Returns true if box1 fits into box2
    */
    public static boolean fits(Box box1, Box box2){
        
        return ()
    }
    
    
}
