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
    private int outEdges;
    
    public Box (float length, float width, float height) {
        this.height = height;
        this.width = width;
        this.height = height;
        this.outEdges = 0;
    }
    
    public void setOutEdges (int out) {
        this.outEdges = out; 
    }
}
