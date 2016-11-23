/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app.view;

import app.model.Material;
import app.renderers.Renderer;
import java.awt.*;
import java.awt.geom.Ellipse2D;
import java.awt.image.BufferedImage;
import javax.swing.JComponent;

/**
 *
 * @author piotr
 */
public class SphereImage extends JComponent {

    public static final int DIMENSION = 400;
    public static final double RADIUS = 150;

    private Renderer rederer;
    private BufferedImage imageCopy;
    private Material material;

    public SphereImage(Material material, Renderer renderer) {
        this.material = material;
        this.rederer = renderer;
        this.imageCopy = new BufferedImage(DIMENSION, DIMENSION, BufferedImage.TYPE_INT_RGB);
        Graphics2D graphics = this.imageCopy.createGraphics();
        graphics.setColor(Color.DARK_GRAY);
        Shape oval = new Ellipse2D.Double(
                DIMENSION / 2 - RADIUS, DIMENSION / 2 - RADIUS,
                RADIUS * 2, RADIUS * 2
        );
        graphics.fill(oval);
        setPreferredSize(new Dimension(DIMENSION, DIMENSION));
        setBackground(new Color(240, 240, 240));
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Image image = rederer.render(imageCopy, material);
        g.drawImage(image, 0, 0, this);
    }

}
