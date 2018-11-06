/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package adsprac1;

import java.util.Comparator;

/**
 *
 * @author Mayo
 */
public class BoxComparator implements Comparator<Box>{

    /**
     * When the amount of children of box1 is bigger than that of box2
     * return -1
     * If they're equal to eachother, return 0
     * else, return 1.
     * @param box1
     * @param box2
     * @return 
     */
    @Override
    public int compare(Box box1, Box box2) {
        if(box1.getChildren().size() > box2.getChildren().size()){ //if box1 has more children than box2, we want box1 before box2 in the list
            return -1;
        }
        else if (box1.getChildren().size() == box2.getChildren().size()){
            return 0;
        }
        else{
            return 1;
        }
    }

}
