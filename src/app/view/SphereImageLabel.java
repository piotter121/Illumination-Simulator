/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app.view;

import app.model.Material;
import app.renderers.PhongRenderer;
import app.renderers.Renderer;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Shape;
import java.awt.geom.Ellipse2D;
import java.awt.image.BufferedImage;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

/**
 *
 * @author piotr
 */
public class SphereImageLabel extends JLabel {

    public static final int DIMENSION = 400;
    public static final double RADIUS = 150;

    private Renderer rederer;
    private BufferedImage imageCopy;
    private Material material;

    public SphereImageLabel(Material material, Renderer renderer) {
        this.material = material;
        this.rederer = renderer;
        this.imageCopy = new BufferedImage(DIMENSION, DIMENSION, BufferedImage.TYPE_INT_RGB);
        Graphics2D graphics = this.imageCopy.createGraphics();
        Shape oval = new Ellipse2D.Double(
                DIMENSION / 2 - RADIUS, DIMENSION / 2 - RADIUS,
                RADIUS * 2, RADIUS * 2
        );
        graphics.fill(oval);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        setIcon(new ImageIcon(rederer.render(imageCopy, material)));
    }

}
