/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package adsprac1;

import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;

/**
 *
 * @author Anouk & Mayo
 */
public class Graph {
    private LinkedList<Box> adj;
    
    /**
     * Volgens mij is het lelijk om zo die adj te initializeren
     * @param boxes 
     */
    public Graph(Box[] boxes) {
        this.adj = new LinkedList<Box>();
        toSortedAdjacencyList(boxes);
    }
    
    /**
     * Part of the constructor
     * sorts adj according to BoxComparator
     * sorts the children of the boxes according to BoxComparator
     * @param boxes 
     */
    private void toSortedAdjacencyList(Box[] boxes){
        LinkedList<Box> adj = new LinkedList(Arrays.asList(boxes));
        Collections.sort(adj, new BoxComparator());
        //now for each box, sort its children
        for(Box box : adj){
            LinkedList<Box> children = box.getChildren();
            Collections.sort(children, new BoxComparator());
            box.setChildren(children);
        }
        this.adj = adj;
    }
    
    /**
     * Does DFS for all boxes with the color WHITE
     */
    public void DFS(){
        for(Box box : adj){
            if(box.getColor() == Color.WHITE){
                DFSVisit(box);
            }
        }
    }
    
    /**
     * The color of the box is set to GREY
     * We loop through the children of that node and if
     * the child is not yet explored, we set the current node to its parent
     * Then recursive call of the function
     * @param parent 
     */
    private void DFSVisit(Box parent) {
        parent.setColor(Color.GREY);
        for(Box child : parent.getChildren()){
            if(child.getColor() == Color.WHITE){
                child.setParent(parent);
                DFSVisit(child);
            }
            {
                break; // Does this work?
            }
        }
        parent.setColor(Color.BLACK);
    }
    
    /**
     * Readable format of the adjacency list
     */
    public void printAdjacencyList(){
        for(Box box: adj){
            System.out.print("Box " + box.getId());
            System.out.println(" can contain:");
            for(Box child : box.getChildren()){
                System.out.println("Box " + child.getId());
            }
            System.out.println("");
        }
    }
    
    /**
     * Print all parents of all boxes
     */
    public void printParents(){
        for(Box box: adj){
            if(box.getParent() != null){
                System.out.println("Box " + box.getId() + "has parent " + box.getParent().getId());
            }
            else{
                System.out.println("Box " + box.getId() + "has no parent");
            }
            
        }
    }
    
    /**
     * returns the number of boxes that are visable
     * @return 
     */
    public int nrVisibleBoxes(){
        int nrVisibleBoxes = 0;
        for(Box box : adj){
            if(box.getParent() == null){
                nrVisibleBoxes++;
            }
        }
        return nrVisibleBoxes;
    }
}
