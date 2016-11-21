/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package app.model;

/**
 * @author Piotr Pyśk
 */
public class MaterialFactory {

    private static MaterialFactory instance;

    public static MaterialFactory getInstance() {
        if (instance == null) {
            instance = new MaterialFactory();
        }
        return instance;
    }

    private Material mirror;
    private Material intermediate;
    private Material wood;

    private MaterialFactory() {
        //wood = new Material(0.25, 0.75, 5);
        wood = new Material(0.4, 0.6, 10);
        //intermediate = new Material(0.5, 0.5, 10);
        intermediate = new Material(0.2, 0.9, 60);
        //mirror = new Material(0.75, 0.25, 100);
        mirror = new Material(0.6, 0.4, 100);
    }

    public Material getIntermediate() {
        return intermediate;
    }

    public Material getMirror() {
        return mirror;
    }

    public Material getWood() {
        return wood;
    }
}
