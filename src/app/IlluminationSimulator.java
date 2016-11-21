/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package app;

import app.view.ApplicationFrame;
import java.awt.EventQueue;

/**
 *
 * @author Piotr Pyśk
 */
public class IlluminationSimulator {

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new ApplicationFrame().setVisible(true);
            }
        });
    }
}
