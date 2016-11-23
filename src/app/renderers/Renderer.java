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
public interface Renderer {

    BufferedImage render(BufferedImage image, Material material);
    
    int getLightX();
    int getLightY();
    int getLightZ();
    
    void setLightX(int x);
    void setLightY(int y);
    void setLightZ(int z);
}
