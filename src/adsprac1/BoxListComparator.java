/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package adsprac1;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.Map.Entry;

/**
 *
 * @author mlmla
 */
public class BoxListComparator implements Comparator<Entry<Box,LinkedList<Box>>>{

    /*
    @Override
    public int compare(LinkedList<Box> list1, LinkedList<Box> list2) {
        if(list1.size() > list2.size()){ //if list1 is larger than list2, we want list1 before list2 in the ArrayList
            return -1;
        }
        else if(list1.size() == list2.size()){
            return 0;
        }
        else{
            return 1;
        }
    }
*/

    @Override
    public int compare(Entry<Box, LinkedList<Box>> o1, Entry<Box, LinkedList<Box>> o2) {
        LinkedList<Box> list1 = o1.getValue();
        LinkedList<Box> list2 = o2.getValue();
        if(list1.size() > list2.size()){ //if list1 is larger than list2, we want list1 before list2 in the ArrayList
            return -1;
        }
        else if(list1.size() == list2.size()){
            return 0;
        }
        else{
            return 1;
        }
    }
    
}
