package autotracker;
import java.util.Date;
/*
 * TestPriority.java
 *
 * Created on July 9, 2007, 9:29 AM
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

/**
 *
 * @author jdoud
 */
public class TestPriority {
    
    /** Creates a new instance of TestPriority */
    public TestPriority() {
    }

    public String getId() {
	    return id;
    }

    public void setId(String id) {
	    this.id = id;
    }

    public String getPriority() {
	    return priority;
    }

    public void setPriority(String priority) {
	    this.priority = priority;
    }

    public Date getDate() {
	    return date;
    }

    public void setDate(Date date) {
	    this.date = date;
    }
	
    // variables
    private String id;
    private String priority;
    private Date date;
}
