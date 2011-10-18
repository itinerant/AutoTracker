/*
 * TestMethod.java
 *
 * Created on July 9, 2007, 9:33 AM
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package autotracker;

/**
 *
 * @author jdoud
 */
public class TestMethod {
    
    /** Creates a new instance of TestMethod */
    public TestMethod() {
    }

    public String getId() {
	    return id;
    }

    public void setId(String id) {
	    this.id = id;
    }

    public String getMethod() {
	    return method;
    }

    public void setMethod(String method) {
	    this.method = method;
    }
    
    // variables
    private String id;
    private String method;
}
