/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package adsprac1;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Anouk & Mayo
 */
public class ADSPrac1 {

    public static void main(String[] args) {
        Box[] list = initializeBoxes();
        HashMap<Box,LinkedList<Box>> adj = toAdjacencyList(list);
        Graph graph = new Graph(adj);
        graph.printAdjacencyList();
        graph.DFS();
        System.out.println("Number of trees in the Depth First Forest: " + graph.getNrTrees());
        graph.printParents();
    }
    
    /**
     * Reads the info in the file and
     * translates that to a list of type Box
     * @return boxesList
     */
    private static Box[] initializeBoxes() {
        File file = new File("C:\\Users\\mlmla\\Documents\\Y3\\Algorithms & Data Structures\\ADSPrac1\\src\\sample-A.2.in"); 
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
        System.out.println("");
        scan.close();
        
        return boxesList;
    }
    
    /**
     * voor ieder paar boxes kijken of de een in de ander past met functie fits()
     * als een box1 in box2 past, voeg box2 toe aan LinkedList van box1
     * @param boxes
     * @return adjacencyList
     */
    public static HashMap<Box,LinkedList<Box>> toAdjacencyList(Box[] boxes){
        HashMap<Box,LinkedList<Box>> adjacencyList = new HashMap<Box,LinkedList<Box>>();
        for(int i=0; i<boxes.length; i++){
            LinkedList<Box> list = new LinkedList<Box>();
            Box box1 = boxes[i];
            for(Box box2 : boxes){
                if(fits(box1, box2)){
                    list.add(box2);
                }
            }
            adjacencyList.put(box1, list);
        }
        return adjacencyList;
    }
    
    /*
    Returns true if box1 fits into box2
    Ik vind de code een beetje lelijk, 
    misschien kunnen we dit later mooier maken
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
    
}
