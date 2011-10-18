/*
 * Test.java
 *
 * Created on June 12, 2007, 1:04 PM
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package autotracker;

import java.lang.String;
import java.text.DateFormat;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.JOptionPane;

/**
 *
 * @author jdoud
 */
public class Test {
    
    /**
     * Creates a new instance of Test
     */
    public Test() {
    }

    
    // instance variables
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getProject() {
        return project;
    }

    public void setProject(String project) {
        this.project = project;
    }
    
    public String getComponent() {
        return component;
    }

    public void setComponent(String component) {
        this.component = component;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }
    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }
    
    // database view variables
    public String getLastAssignment() {
	    return lastAssignment;
    }

    public void setLastAssignment(String lastAssignment) {
	    this.lastAssignment = lastAssignment;
    }

    public String getLastAssignmentDate() {
	    return lastAssignmentDate;
    }

    public void setLastAssignmentDate(String lastAssignmentDate) {
	    this.lastAssignmentDate = lastAssignmentDate;
    }

    public String getLastPriority() {
	    return lastPriority;
    }

    public void setLastPriority(String lastPriority) {
	    this.lastPriority = lastPriority;
    }

    public String getLastPriorityDate() {
	    return lastPriorityDate;
    }

    public void setLastPriorityDate(String lastPriorityDate) {
	    this.lastPriorityDate = lastPriorityDate;
    }

    public String getLastResult() {
	    return lastResult;
    }

    public void setLastResult(String lastResult) {
	    this.lastResult = lastResult;
    }

    public String getLastResultDate() {
	    return lastResultDate;
    }
    
    public void setLastManualResult(String lastManualResult) {
	    this.lastManualResult = lastManualResult;
    }

    public String getLastManualResultDate() {
	    return lastManualResultDate;
    }
    
    public void setLastAutoResult(String lastAutoResult) {
	    this.lastAutoResult = lastAutoResult;
    }

    public String getLastAutoResultDate() {
	    return lastAutoResultDate;
    }

    public void setLastResultDate(String lastResultDate) {
	    this.lastResultDate = lastResultDate;
    }
    
    public void setLastResultType(String lastResultType) {
	    this.lastResultType = lastResultType;
    }
    
    public String getLastResultType() {
	    return lastResultType;
    }
    
    public void setLastManualResultDate(String lastManualResultDate) {
	 // date is later than last auto result, update last date data
	if(lastResultDate.equals("")){
	    setLastResult(lastManualResult);
	    setLastResultDate(lastManualResultDate);
	    setLastResultBuild(lastManualResultBuild);
	    setLastResultSuite(lastManualResultSuite);
	    if(lastManualResult.equals("")) {
		setLastResultType("");
	    } else {
		setLastResultType("Manual");
	    }
	} else {
	    if(lastManualResultDate.compareTo(lastResultDate) == 1) {
		setLastResult(lastManualResult);
		setLastResultDate(lastManualResultDate);
		setLastResultBuild(lastManualResultBuild);
		setLastResultSuite(lastManualResultSuite);
		setLastResultType("Manual");
	    }
	}
    }
    
    public void setLastAutoResultDate(String lastAutoResultDate) {
	 // date is later than last manual result, update last date data
	if(lastResultDate.equals("")){
	    setLastResult(lastAutoResult);
	    setLastResultDate(lastAutoResultDate);
	    setLastResultBuild(lastAutoResultBuild);
	    setLastResultSuite(lastAutoResultSuite);
	    if(lastAutoResult.equals("")) {
		setLastResultType("");
	    } else {
		setLastResultType("Automated");
	    }
	} else {
	    if(lastAutoResultDate.compareTo(lastResultDate) == 1) {
		setLastResult(lastAutoResult);
		setLastResultDate(lastAutoResultDate);
		setLastResultBuild(lastAutoResultBuild);
		setLastResultSuite(lastAutoResultSuite);
		setLastResultType("Automated");
	    }
	}
    }

    public String getLastResultBuild() {
	    return lastResultBuild;
    }

    public void setLastResultBuild(String lastResultBuild) {
	    this.lastResultBuild = lastResultBuild;
    }

    public String getLastResultSuite() {
	    return lastResultSuite;
    }

    public void setLastResultSuite(String lastResultSuite) {
	    this.lastResultSuite = lastResultSuite;
    }
    
    public String getLastAutoResultBuild() {
	    return lastAutoResultBuild;
    }

    public void setLastAutoResultBuild(String lastAutoResultBuild) {
	    this.lastAutoResultBuild = lastAutoResultBuild;
    }

    public String getLastAutoResultSuite() {
	    return lastAutoResultSuite;
    }

    public void setLastAutoResultSuite(String lastAutoResultSuite) {
	    this.lastAutoResultSuite = lastAutoResultSuite;
    }
	    
    public String getLastManualResultBuild() {
	    return lastManualResultBuild;
    }

    public void setLastManualResultBuild(String lastManualResultBuild) {
	    this.lastManualResultBuild = lastManualResultBuild;
    }

    public String getLastManualResultSuite() {
	    return lastManualResultSuite;
    }

    public void setLastManualResultSuite(String lastManualResultSuite) {
	    this.lastManualResultSuite = lastManualResultSuite;
    }

    public String getLastStatus() {
	    return lastStatus;
    }

    public void setLastStatus(String lastStatus) {
	    this.lastStatus = lastStatus;
    }

    public String getLastStatusDate() {
	    return lastStatusDate;
    }

    public void setLastStatusDate(String lastStatusDate) {
	    this.lastStatusDate = lastStatusDate;
    }

    public String getMethodString() {
	    return methodString;
    }

    public void setMethodString(String methodString) {
	    this.methodString = methodString;
    }
    
    public void dumpTestData() {
	JOptionPane.showMessageDialog(null, 
		id + "\n" + project + "\n" + name + "\n" + notes + "\n\n\n"
		+ lastResult + "\n" + lastResultDate + "\n" + lastResultBuild + "\n" + lastResultSuite + "\n", 
		"AutoTracker", JOptionPane.INFORMATION_MESSAGE);
    }
    	
    // variables
    private String id;
    private String project;
    private String component;
    private String category;
    private String name;
    private String notes;
    
    private String lastAssignment;
    private String lastAssignmentDate;
    private String lastPriority;
    private String lastPriorityDate;
    private String lastResult;
    private String lastResultDate = "";
    private String lastResultBuild;
    private String lastResultSuite;
    private String lastResultType = "";
    private String lastAutoResult;
    private String lastAutoResultDate;
    private String lastAutoResultBuild;
    private String lastAutoResultSuite;
    private String lastManualResult;
    private String lastManualResultDate;
    private String lastManualResultBuild;
    private String lastManualResultSuite;
    private String lastStatus;
    private String lastStatusDate;
    private String methodString;	
}
