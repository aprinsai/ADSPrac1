/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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
    private Color color;
    private Box parent;
    private LinkedList<Box> children;
    private boolean isParent;
    
    public Box (float length, float width, float height, int id) {
        this.length = length;
        this.width = width;
        this.height = height;
        this.id = id; 
        this.color = Color.WHITE;
        this.parent = null;
        this.isParent = false;
    }
    
    public String toString(){
        String box = length + " " + width + " " + height;
        return box;
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
    
    public Color getColor(){
        return color;
    }
    
    public Box getParent(){
        return parent;
    }
    
    public LinkedList<Box> getChildren(){
        return children;
    }
    
    public boolean getIsParent(){
        return isParent;
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
    
    public void setColor(Color c){
        color = c;
    }
    
    public void setParent(Box p){
        parent = p;
    }
    
    public void setChildren(LinkedList<Box> c){
        children = c;
    }
}
