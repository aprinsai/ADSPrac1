/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package adsprac1;

import java.util.ArrayList;
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
    private LinkedHashMap<Box,LinkedList<Box>> adj;
    
    public Graph(HashMap<Box,LinkedList<Box>> adj) {
        this.adj = new LinkedHashMap<Box,LinkedList<Box>>();
        sortAdjacencyList(adj);
        
    }
    
    private void sortAdjacencyList(HashMap<Box,LinkedList<Box>> adj){
        List<Entry<Box,LinkedList<Box>>> list = new LinkedList<Entry<Box,LinkedList<Box>>>(adj.entrySet());
        Collections.sort(list, new BoxListComparator());
        for(Entry<Box,LinkedList<Box>> entry : list){
            this.adj.put(entry.getKey(), entry.getValue());
        }
    }
    
    public void printAdjacencyList(){
        for(Map.Entry<Box,LinkedList<Box>> entry : adj.entrySet()){
            System.out.println("Box " + entry.getKey().getId());
            System.out.println("Fits into:");
            for(Box box : entry.getValue()){
                System.out.println("Box " + box.getId());
            }
            System.out.println("");
        }
    }
}
