package adsprac1;

import java.util.Arrays;
import java.util.Scanner;

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
        Scanner scan = new Scanner(System.in);
        
        int listSize = scan.nextInt();
        Box[] boxesList;
        boxesList = new Box[listSize];
        
        for (int pos = 0; pos<listSize; pos++) {
            float length = Float.parseFloat(scan.next());
            float width = Float.parseFloat(scan.next());
            float height = Float.parseFloat(scan.next());
            Box box = new Box(length, width, height, pos);
            boxesList[pos] = box;
            
        }
        scan.close();
        return boxesList;
    }
    
    /**
     * For every pair of boxes, check whether the box1 fits into box2 with fits()
     * If true, add box2 to LinkedList of box1
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
