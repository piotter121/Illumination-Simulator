/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package app.renderers;

import app.model.Material;
import app.model.Point3D;
import app.model.Vector;
import java.awt.Color;
import java.awt.image.BufferedImage;

/**
 *
 * @author Piotr Pyśk
 */
public class PhongRenderer implements Renderer {

    private static final double IA = 100.0;
    private static final double IP = 60000.0;
    private static final double KA = 0.4;
    public static final int IMAGE_SIZE = 400;

    private Point3D lightSource = new Point3D(0, 0, 200);

    @Override
    public BufferedImage render(BufferedImage image, Material material) {
        BufferedImage newImage = new BufferedImage(IMAGE_SIZE, IMAGE_SIZE, BufferedImage.TYPE_INT_RGB);

        for (int i = 0; i < IMAGE_SIZE; i++) {
            int[] pixels = new int[IMAGE_SIZE];
            image.getRGB(0, i, IMAGE_SIZE, 1, pixels, 0, IMAGE_SIZE);

            for (int j = 0; j < IMAGE_SIZE; j++) {
                int pixel = pixels[j];

                if (pixel != -16777216) {
                    Point3D point = computeZ(i - 250, j - 250);

                    Vector sour = computeVector(point, lightSource);
                    Vector vector = point.toVector();
                    Vector sour2 = computeVector(lightSource, point);

                    vector.normalize();
                    sour.normalize();

                    double scalar = scalar(sour, vector);
                    double cosAlpha = computeCosAlpha(sour2, vector);
                    double I = compute(material, scalar, cosAlpha, point);

                    Color c = new Color(pixel);

                    int red = check(c.getRed() + I);
                    int green = check(c.getGreen() + I);
                    int blue = check(c.getBlue() + I);

                    pixels[j] = new Color(red, green, blue, c.getAlpha()).getRGB();
                }
            }
            newImage.setRGB(0, i, IMAGE_SIZE, 1, pixels, 0, IMAGE_SIZE);
        }
        return newImage;
    }

    private int check(double i) {
        if (i < 0) {
            return 0;
        } else if (i > 255) {
            return 255;
        } else {
            return (int) i;
        }
    }

    private double compute(Material material, double scalar, double cosAlpha, Point3D point) {
        return IA * KA
                + fatt(point) * IP * material.getKd() * scalar
                + fatt(point) * IP * material.getKs() * Math.pow(cosAlpha, material.getN());
    }

    private Point3D computeZ(int x, int y) {
        return new Point3D(x, y, (int) Math.sqrt(150 * 150 - x * x - y * y));
    }

    private Vector computeVector(Point3D start, Point3D end) {
        return new Vector(end.getX() - start.getX(),
                end.getY() - start.getY(),
                end.getZ() - start.getZ());
    }

    private double scalar(Vector v, Vector b) {
        return v.getX() * b.getX()
                + v.getY() * b.getY()
                + v.getZ() * b.getZ();
    }

    private double computeCosAlpha(Vector v, Vector b) {
        double len = Math.sqrt(v.getX() * v.getX()
                + v.getY() * v.getY()
                + v.getZ() * v.getZ())
                * Math.sqrt(b.getX() * b.getX()
                        + b.getY() * b.getY()
                        + b.getZ() * b.getZ());
        if (scalar(v, b) > 0) {
            return 0;
        }
        return scalar(v, b) / len;
    }

    private double fatt(Point3D p) {
        return 1.0 / Math.sqrt(Math.pow(p.getX() + lightSource.getX(), 2)
                + Math.pow(p.getY() + lightSource.getY(), 2)
                + Math.pow(p.getZ() + lightSource.getZ(), 2));
    }

    @Override
    public int getLightX() {
        return (int) lightSource.getX();
    }

    @Override
    public int getLightY() {
        return (int) lightSource.getY();
    }

    @Override
    public int getLightZ() {
        return (int) lightSource.getZ();
    }

    @Override
    public void setLightX(int x) {
        lightSource.setX(x);
    }

    @Override
    public void setLightY(int y) {
        lightSource.setY(y);
    }

    @Override
    public void setLightZ(int z) {
        lightSource.setZ(z);
    }

}
