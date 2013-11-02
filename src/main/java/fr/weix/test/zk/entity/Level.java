/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.weix.test.zk.entity;

/**
 *
 * @author caskdor
 */
public class Level {

    private String name;
    private int weight;

    public Level() {}
    
    public Level(String name, int weight) {
        this.name = name;
        this.weight = weight;
    }
    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }
    
    @Override
    public String toString() {
        return "Name[" + name + "] - Weight[" + weight + "]";
    }
}
