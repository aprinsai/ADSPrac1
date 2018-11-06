/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package adsprac1;

/**
 * 
 * 
 * 
 * 
 * 
 * 
 * Add Ford Fulkerson
 * 
 * 
 * 
 * 
 * 
 * 
 * BiPartite Matching
 * @author Anouk
 */
public class BPM {
    
    public int maxBPM(boolean bpGraph[][]) 
    { 
        int N = bpGraph.length;
        int M = bpGraph[0].length;
        
        // array to keep track of the boxes
        int matched[] = new int[N]; 
  
        for(int i = 0; i < N; ++i) 
            matched[i] = -1; 
  
        // Count matches made 
        int result = 0;  
        for (int box = 0; box < M; box++) 
        { 
            // Nothing visited yet
            boolean visited[] =new boolean[N] ; 
            for(int i = 0; i < N; ++i) 
                visited[i] = false; 
  
            // Find if there is a box that fits into another box
            if (bpm(bpGraph, box, visited, matched)) 
                result++; 
        } 
        return result; 
    
}

    private boolean bpm(boolean[][] bpGraph, int u, boolean[] visited, int[] matched) {
        for (int v = 0; v < bpGraph.length; v++) 
        { 
            // If a box u fits into box v and v is not visited 
            if (bpGraph[u][v] && !visited[v]) 
            { 
                  
                // Mark v as visited 
                visited[v] = true;  
  
                //?
                if (matched[v] < 0 || bpm(bpGraph, matched[v], visited, matched)) 
                { 
                    matched[v] = u; 
                    return true; 
                } 
            } 
        } 
        return false; 
    }
}
