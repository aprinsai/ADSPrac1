/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package adsprac1;

/**
 *
 * @author Anouk
 */
public class Box {
    private float length;
    private float width;
    private float height;
    private int id;
    private int outEdges;
    
    public Box (float length, float width, float height, int id) {
        this.length = length;
        this.width = width;
        this.height = height;
        this.id = id;   
        this.outEdges = 0;
    }
    
    public void setOutEdges (int out) {
        this.outEdges = out; 
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
    
    public void setLength(float l){
        length = l;
    }
    
    public void setWidth(float w){
        width = w;
    }
    
    public void setHeight(float h){
        length = h;
    }
}
