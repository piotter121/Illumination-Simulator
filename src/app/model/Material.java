/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package app.model;

/**
 * @author Piotr Pyśk
 */
public class Material {

    private double ks;
    private double kd;
    private double n;

    public Material(double ks, double kd, double n) {
        this.ks = ks;
        this.kd = kd;
        this.n = n;
    }

    public double getKd() {
        return kd;
    }

    public void setKd(double kd) {
        this.kd = kd;
    }

    public double getKs() {
        return ks;
    }

    public void setKs(double ks) {
        this.ks = ks;
    }

    public double getN() {
        return n;
    }

    public void setN(double n) {
        this.n = n;
    }
}
