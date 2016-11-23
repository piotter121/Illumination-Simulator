/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app.renderers;

import app.model.Material;
import java.awt.image.BufferedImage;

/**
 *
 * @author piotr
 */
@FunctionalInterface
public interface Renderer {

    BufferedImage render(BufferedImage image, Material material);
}
