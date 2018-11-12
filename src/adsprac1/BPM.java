package adsprac1;

/**
 * BiPartite Matching
 * @author Anouk
 */
public class BPM {
    
    public int maxBPM(boolean bpGraph[][]) 
    { 
        int N = bpGraph.length;
        int M = bpGraph[0].length;
        
        // Keep track of which box is in which box. inside[5]=2 means that box 2 is inside box 6
        int[] inside = new int[N]; 
  
        // inside[i] = -1 means that box i contains no boxes
        for(int i = 0; i < N; ++i) 
            inside[i] = -1; 
  
        // Count number of invisible boxes 
        int invisible = 0;  
        for (int box = 0; box < M; box++) 
        { 
            // For each box b, keep track of the boxes that have been considered to put b into
            boolean[] considered =new boolean[N] ; 
  
            // Find if there is a box that our box fits into
            if (bpm(bpGraph, box, considered, inside)) 
                invisible++; 
        } 
        return invisible; 
    
    }

    private boolean bpm(boolean[][] bpGraph, int box1, boolean[] considered, int[] inside) {
        for (int box2 = 0; box2 < bpGraph.length; box2++) 
        { 
            // If box1 fits into box2 and box2 was not considered already
            if (bpGraph[box1][box2] && !considered[box2]) 
            { 
                  
                // Mark box2 as considered 
                considered[box2] = true;  
  
                //If there is nothing inside box2 yet, or if the box that is in box2 can be put in another box, put box1 inside box2
                if (inside[box2] < 0 || bpm(bpGraph, inside[box2], considered, inside)) 
                { 
                    inside[box2] = box1; 
                    return true; 
                } 
            } 
        } 
        return false; 
    }
}
