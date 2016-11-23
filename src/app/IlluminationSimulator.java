/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package app;

import app.renderers.PhongRenderer;
import app.renderers.Renderer;
import app.view.ApplicationFrame;
import java.awt.EventQueue;

/**
 *
 * @author Piotr Pyśk
 */
public class IlluminationSimulator {

    private final ApplicationFrame frame;
    private final Renderer renderer;

    public IlluminationSimulator() {
        renderer = new PhongRenderer();
        frame = new ApplicationFrame(renderer);
        initListeners();
    }

    private void initListeners() {
        frame.getRenderButton().addActionListener(e -> {
            renderAgain();
        });
    }

    private void renderAgain() {
        frame.refresh();
    }

    public void showAppFrame() {
        EventQueue.invokeLater(() -> {
            frame.setVisible(true);
        });
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        IlluminationSimulator app = new IlluminationSimulator();
        app.showAppFrame();
    }
}
