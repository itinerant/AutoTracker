/*
 * TestResult.java
 *
 * Created on July 9, 2007, 9:26 AM
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
public class TestResult {
    
    /**
	 * Creates a new instance of TestResult
	 */
    public TestResult() {
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

    public String getResult() {
	    return result;
    }

    public void setResult(String result) {
	    this.result = result;
    }
    
    public String getType() {
	    return type;
    }

    public void setType(String type) {
	    this.type = type;
    }

    public String getDate() {
	    return date;
    }

    public void setDate(String date) {
	    this.date = date;
    }

    public String getBuild() {
	    return build;
    }

    public void setBuild(String build) {
	    this.build = build;
    }

    public String getSuite() {
	    return suite;
    }

    public void setSuite(String suite) {
	    this.suite = suite;
    }

    // variables
    private String id;
    private String method;
    private String result;
    private String type;
    private String date;
    private String build;
    private String suite;
}
