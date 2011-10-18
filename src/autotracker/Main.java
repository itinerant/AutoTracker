/*
 * Main.java
 *
 * Created on July 9, 2007, 7:57 AM
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package autotracker;

/**
 *
 * @author jdoud
 */
public class Main {
    
    /** Creates a new instance of Main */
    public Main() {
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
	// create gui
        MainWindow mw = new MainWindow();
        mw.setVisible(true);
    }
    
}
