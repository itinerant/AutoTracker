/*
 * TestStatus.java
 *
 * Created on July 9, 2007, 9:35 AM
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
public class TestStatus {
    
    /** Creates a new instance of TestStatus */
    public TestStatus() {
    }
    
    public String getId() {
	    return id;
    }

    public void setId(String id) {
	    this.id = id;
    }

    public String getStatus() {
	    return status;
    }

    public void setStatus(String status) {
	    this.status = status;
    }

    public Date getDate() {
	    return date;
    }

    public void setDate(Date date) {
	    this.date = date;
    }
	
    // variables
    private String id;
    private String status;
    private Date date;
}
