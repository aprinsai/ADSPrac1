package adsprac1;

import java.util.LinkedList;

/**
 *
 * @author Anouk & Mayo
 */
public class Box {
    private float length;
    private float width;
    private float height;
    private final int id;
    private LinkedList<Box> children;
    
    public Box (float length, float width, float height, int id) {
        this.length = length;
        this.width = width;
        this.height = height;
        this.id = id; 
    }
    
    public float getLength(){
        return length;
    }
    
    public float getWidth(){
        return width;
    }
    
    public float getHeight(){
        return height;
    }
    
    public int getId(){
        return id;
    }
    
    public LinkedList<Box> getChildren(){
        return children;
    }
    
    public void setLength(float l){
        length = l;
    }
    
    public void setWidth(float w){
        width = w;
    }
    
    public void setHeight(float h){
        length = h;
    }
    
    public void setChildren(LinkedList<Box> c){
        children = c;
    }
}
