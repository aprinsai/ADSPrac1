/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package adsprac1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Dictionary;
import java.util.Hashtable;
import java.util.LinkedList;

/**
 *
 * @author Anouk
 */
public class Graph {
    private Hashtable<Box,LinkedList<Box>> adj;
    
    public Graph(Hashtable<Box,LinkedList<Box>> adj) {
        Collections.sort(adj, new BoxListComparator());
        this.adj = adj;
        
        Dictionary<Box, LinkedList<Box>> dic = new Hashtable<Box, LinkedList<Box>>();
    }
}
