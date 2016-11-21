/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package app.model;

/**
 *
 * @author Piotr Pyśk
 */
public class Vector {

    private double x;
    private double y;
    private double z;

    public Vector(double x, double y, double z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }

    public double getZ() {
        return z;
    }

    public void setZ(double z) {
        this.z = z;
    }

    public void normalize() {
        double len = Math.sqrt(x * x + y * y + z * z);
        x = x / len;
        y = y / len;
        z = z / len;
    }

    public double multiply(Vector v) {
        return v.getX() * this.getX() + v.getY() * this.getY() + v.getZ() * this.getZ();
    }

    public Vector multiply(double a) {
        return new Vector(this.x * a, this.y * a, this.z * a);
    }

    public void podejmij(Vector v) {
        this.x = this.x - v.getX();
        this.y = this.y - v.getY();
        this.z = this.z - v.getZ();
    }
}
