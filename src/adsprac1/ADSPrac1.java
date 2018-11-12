/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package adsprac1;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Anouk & Mayo
 */
public class ADSPrac1 {

    public static void main(String[] args) {
        Box[] boxes = initializeBoxes();
        boolean[][] adj = createAdjacencyMatrix(boxes);
        BPM bpm = new BPM();
        System.out.println(boxes.length - bpm.maxBPM(adj));
    }
    
    /**
     * Scans the information
     * translates that to a list of type Box
     * @return boxesList
     */
    private static Box[] initializeBoxes() {
        File file = new File("C:\\Users\\mlmla\\Documents\\Y3\\Algorithms & Data Structures\\ADSPrac1\\src\\sample-A.1.in"); 
        // Anouk's pad: "C:\\Users\\Anouk\\Documents\\Third year AI\\Algoritmen en Datastructuren\\ADSPrac1\\src\\sample-A.1.in"
        // Marjolein's pad: "C:\Users\mlmla\Documents\Y3\Algorithms & Data Structures\ADSPrac1\src\sample-A.1.in"
        
        Scanner scan = null;
        try {
            scan = new Scanner(file);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(ADSPrac1.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        //Scanner scan = new Scanner(System.in);
        
        int listSize = scan.nextInt();
        Box[] boxesList;
        boxesList = new Box[listSize];
        
        for (int pos = 0; pos<listSize; pos++) {
            float length = Float.parseFloat(scan.next());
            float width = Float.parseFloat(scan.next());
            float height = Float.parseFloat(scan.next());
            Box box = new Box(length, width, height, pos);
            //System.out.println(box.toString());
            boxesList[pos] = box;
            
        }
        //System.out.println("");
        scan.close();
        
        return boxesList;
    }
    
    /**
     * voor ieder paar boxes kijken of de een in de ander past met functie fits()
     * als een box1 in box2 past, voeg box2 toe aan LinkedList van box1
     * @param boxes
     */
    private static boolean[][] createAdjacencyMatrix(Box[] boxes){
        int nrBoxes = boxes.length;
        boolean[][] adj = new boolean[nrBoxes][nrBoxes];
        for(int i=0; i<boxes.length; i++){
            Box box1 = boxes[i];
            for(int j=0; j<boxes.length; j++){
                Box box2 = boxes[j];
                if(fits(box1, box2)){
                    adj[i][j] = true;
                }
            }
        }
        return adj;
    }
    
    private static void printAdjacencyMatrix(boolean[][] adj){
        for(int i=0; i<adj.length; i++){
            for(int j=0; j<adj[i].length; j++){
                System.out.print(adj[i][j] + "  ");
            }
            System.out.println("");
        }
    }
    
    /**
     * Returns true if box1 fits into box2
     * @param box1
     * @param box2
     * @return boolean
     */
    public static boolean fits(Box box1, Box box2){
        float[] dimensions1 = {box1.getLength(), box1.getWidth(), box1.getHeight()};
        Arrays.sort(dimensions1);
        float[] dimensions2 = {box2.getLength(), box2.getWidth(), box2.getHeight()};
        Arrays.sort(dimensions2);
        
        if(dimensions1[0] < dimensions2[0] && dimensions1[1] <dimensions2[1] && dimensions1[2] < dimensions2[2]){
            return true;
        }
        else{
            return false;
        }
    }
    
}
