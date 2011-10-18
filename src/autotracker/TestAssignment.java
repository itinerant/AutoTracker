/*
 * TestAssignment.java
 *
 * Created on July 9, 2007, 9:32 AM
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package autotracker;

import java.util.Date;

/**
 *
 * @author jdoud
 */
public class TestAssignment {
    
    /** Creates a new instance of TestAssignment */
    public TestAssignment() {
    }
    
    public String getId() {
	    return id;
    }

    public void setId(String id) {
	    this.id = id;
    }

    public String getAssigned() {
	    return assigned;
    }

    public void setAssigned(String assigned) {
	    this.assigned = assigned;
    }

    public Date getDate() {
	    return date;
    }

    public void setDate(Date date) {
	    this.date = date;
    }
	
    // variables
    private String id;
    private String assigned;
    private Date date;
}
