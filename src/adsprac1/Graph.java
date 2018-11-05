/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package adsprac1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Dictionary;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

/**
 *
 * @author Anouk
 */
public class Graph {
    private LinkedList<Box> adj;
    private int nrTrees;
    
    public Graph(Box[] boxes) {
        nrTrees = 0;
        this.adj = new LinkedList<Box>();
        toSortedAdjacencyList(boxes);
    }
    
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
    
    public void DFS(){
        /*for(Entry<Box,LinkedList<Box>> entry : adj.entrySet()){
            if(entry.getKey().getColor() == Color.WHITE){
                nrTrees++;
                DFSVisit(entry.getKey());
            }
        }*/
        
        for(Box box : adj){
            if(box.getColor() == Color.WHITE){
                nrTrees++;
                DFSVisit(box);
            }
        }
    }
    
    private void DFSVisit(Box parent) {
        /*parent.setColor(Color.GREY);
        for(Box child : adj.get(parent)){ 
            if(child.getColor() == Color.WHITE){
                child.setParent(parent);
                DFSVisit(child);
            }
        }
        parent.setColor(Color.BLACK);*/
        
        parent.setColor(Color.GREY);
        for(Box child : parent.getChildren()){
            if(child.getColor() == Color.WHITE){
                child.setParent(parent);
                DFSVisit(child);
            }
        }
        parent.setColor(Color.BLACK);
    }
    
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

    public int getNrTrees(){
        return nrTrees;
    }
    
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
}
