/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package adsprac1;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
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
        ArrayList<LinkedList<Box>> adj = toAdjacencyList(list);
        printAdjacencyList(adj);
    }
    
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
        
        int listSize = scan.nextInt(); // nodig?
        Box[] boxesList;
        boxesList = new Box[listSize];
        
        for (int pos = 0; pos<listSize; pos++) {
            float length = Float.parseFloat(scan.next());
            float width = Float.parseFloat(scan.next());
            float height = Float.parseFloat(scan.next());
            Box box = new Box(length, width, height, pos);
            System.out.println(box.toString());
            boxesList[pos] = box;
            
        }
        scan.close();
        
        return boxesList;
    }
    
    public static ArrayList<LinkedList<Box>> toAdjacencyList(Box[] boxes){
        //voor ieder paar boxes kijken of de een in de ander past --> functie voor schrijven
        //als een box1 in box2 past, voeg box2 toe aan LinkedList van box1
        ArrayList<LinkedList<Box>> adjacencyList = new ArrayList<LinkedList<Box>>();
        for(Box box1 : boxes){
            LinkedList<Box> list = new LinkedList<Box>();
            for(Box box2 : boxes){
                if(fits(box1, box2)){
                    list.add(box2);
                }
            }
            adjacencyList.add(list);
        }
        return adjacencyList;
    }
    
    /*
    Returns true if box1 fits into box2
    */
    public static boolean fits(Box box1, Box box2){
        float l1 = box1.getLength();
        float w1 = box1.getWidth();
        float h1 = box1.getHeight();
        float l2 = box2.getLength();
        float w2 = box2.getWidth();
        float h2 = box2.getHeight();
        
        if(l1 < l2 && w1 < w2 && h1 < h2){
            return true;
        }
        else if(l1 < h2 && w1 < l2 && h1 < w2){
            return true;
        }
        else if(l1 < w2 && w1 < h2 && h1 < l2){
            return true;
        }
        else if(l1 < l2 && w1 < h2 && h1 < w2){
            return true;
        }
        else if(l1 < h2 && w1 < w2 && h1 < l2){
            return true;
        }
        else if(l1 < w2 && w1 < l2 && h1 < h2){
            return true;
        }
        
        return false;
    }
    
    public static void printAdjacencyList(ArrayList<LinkedList<Box>> adj){
        for(LinkedList<Box> list : adj){
            for(Box box : list){
                System.out.print(box.getIndex() + " ");
            }
            System.out.println("");
        }
    }
}
