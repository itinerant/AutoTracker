/*
 * DialogImport.java
 *
 * Created on July 11, 2007, 12:23 PM
 */

package autotracker;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

/**
 *
 * @author  jdoud
 */
public class DialogImport extends javax.swing.JDialog {
    
    /**
	 * Creates new form DialogImport
	 */
    public DialogImport(java.awt.Frame parent, boolean modal) {
	super(parent, modal);
	initComponents();
	clickedOK.setVisible(false);
    }
    
    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        project = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        cancel = new javax.swing.JButton();
        ok = new javax.swing.JButton();
        clickedOK = new javax.swing.JCheckBox();
        jScrollPane1 = new javax.swing.JScrollPane();
        data = new javax.swing.JTextArea();
        jLabel3 = new javax.swing.JLabel();
        component = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setText("Project:");

        jLabel2.setText("Copy the HTML list of tests from the Print Test Cases section of Testlink into the space below.");

        cancel.setText("Cancel");
        cancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelActionPerformed(evt);
            }
        });

        ok.setText("OK");
        ok.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                okActionPerformed(evt);
            }
        });

        clickedOK.setText("Clicked OK");
        clickedOK.setMargin(new java.awt.Insets(0, 0, 0, 0));

        data.setColumns(20);
        data.setRows(5);
        jScrollPane1.setViewportView(data);

        jLabel3.setText("Component:");

        component.setText("Functional");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 641, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 46, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(clickedOK)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 373, Short.MAX_VALUE)
                        .addComponent(cancel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(ok)
                        .addGap(2, 2, 2))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(project, javax.swing.GroupLayout.PREFERRED_SIZE, 188, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(38, 38, 38)
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(component, javax.swing.GroupLayout.PREFERRED_SIZE, 188, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(project, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3)
                    .addComponent(component, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 408, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(clickedOK)
                    .addComponent(cancel)
                    .addComponent(ok))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void okActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_okActionPerformed
	if(data.getText().equals("")) {
	    JOptionPane.showMessageDialog(this,
		"Enter data to import before clicking OK.",
		"AutoTracker", JOptionPane.INFORMATION_MESSAGE);
	    return;
	}
	
	importData();
	
	data.setText("");
	data.requestFocus();
	clickedOK.setSelected(true);
	
	this.setVisible(false);
    }//GEN-LAST:event_okActionPerformed

    private void cancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelActionPerformed
	data.setText("");
	data.requestFocus();
	clickedOK.setSelected(false);
	
	this.setVisible(false);
    }//GEN-LAST:event_cancelActionPerformed
    
    public void clearCheckbox() {
	clickedOK.setSelected(false);
    }
    
    public String getButton() {
	if(clickedOK.isSelected()) {
	    return "OK";
	} else {
	    return "Cancel";
	}
    }
    
    public void setProject(String p) {
	project.setText(p);
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
	java.awt.EventQueue.invokeLater(new Runnable() {
	    public void run() {
		new DialogImport(new javax.swing.JFrame(), true).setVisible(true);
	    }
	});
    }
    
     public void importData() {
	int count=0;
	// open database connection
	try {
		Class.forName("com.mysql.jdbc.Driver");
	} catch (ClassNotFoundException e) {
		System.out.println("Class Not Found: " + e);
	}
        try {
	    Connection con = DriverManager.getConnection(dbConnection, dbUsername, dbPassword);
	    Statement stmt = con.createStatement();
	    Statement stmt1 = con.createStatement();
	    String category = "";
	    
	    // iterate through all lines
	    String[] list = data.getText().split("\n");
	    for(int i=0; i<list.length; i++) {
		// if starts with 1.2. is category
	    	if(list[i].startsWith("1.2.")) {
		    category = list[i].split(" ", 2)[1];
		    category = category.replaceAll("'", "''");
		} 
		// else if starts with Test Case is test
		else if(list[i].startsWith("Test Case")) {
		    // get parameters for update/insert
		    //String temp = list[i].right(list[i].length()-10);
		    String temp = list[i].substring(10);
		    String id = temp.split(": ")[0];
		    String name = temp.split(": ")[1];
		    name = name.replaceAll("'", "''");

		    // check if test currently exists
		    
		    ResultSet rs = stmt.executeQuery("select count(0) from test_cases where test_id='" + id + "'");
		    rs.next();
		    int n = rs.getInt(1);
		    // insert if not exists
		    if(n == 0) {
			//System.out.println("insert: " + name);
			stmt1.executeUpdate("insert into test_cases (test_id, project, component, category, name, notes) values ('" 
				+ id + "', '" + project.getText() + "', '" + component.getText() + "', '"
				+ category + "', '" + name + "', '')");
		    } 
		    // update if exists
		    else {
			//System.out.println("update: " + name);
			stmt1.executeUpdate("update test_cases set project='" + project.getText() + "', category='"
				+ category + "', name='" + name + "' where test_id='" + id + "'");
		    }
		    rs.close();
		    count++;
		}
	    }
	    
	    // close database connection
	    stmt.close();
	    stmt1.close();
	    con.close();
	    
	    JOptionPane.showMessageDialog(this, 
		    String.valueOf(count) + " records updated.", 
		    "AutoTracker", JOptionPane.INFORMATION_MESSAGE);
	} catch (SQLException e) {
		System.out.println("SQLException: " + e);
		JOptionPane.showMessageDialog(this, 
		    "SQLException: " + e, 
		    "AutoTracker", JOptionPane.ERROR_MESSAGE);
	}
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton cancel;
    private javax.swing.JCheckBox clickedOK;
    private javax.swing.JTextField component;
    private javax.swing.JTextArea data;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton ok;
    private javax.swing.JTextField project;
    // End of variables declaration//GEN-END:variables
    
    
    // database connection variables
    //private String dbConnection = "jdbc:mysql://localhost:3306/imos";
    //private String dbUsername = "imos";
    //private String dbPassword = "im0s";
    private String dbConnection = "jdbc:mysql://10.51.94.3/imos";
    private String dbUsername = "imos";
    private String dbPassword = "Testit66";
}
