/*
 * DialogList.java
 *
 * Created on August 10, 2007, 12:40 PM
 */

package autotracker;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.RowSorter;
import javax.swing.SortOrder;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

/**
 *
 * @author  jdoud
 */
public class DialogList extends javax.swing.JDialog {
    
    /** Creates new form DialogList */
    public DialogList(java.awt.Frame parent, boolean modal) {
	super(parent, modal);
	initComponents();
	table.setAutoCreateRowSorter(true);
	keys.add(new RowSorter.SortKey(0, SortOrder.ASCENDING));
    }
    
    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc=" Generated Code ">//GEN-BEGIN:initComponents
    private void initComponents() {
        header = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        table = new javax.swing.JTable();
        ok = new javax.swing.JButton();
        total = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        header.setText("jLabel1");

        table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(table);

        ok.setText("Close");
        ok.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                okActionPerformed(evt);
            }
        });

        total.setText("jLabel1");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 669, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(total)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 549, Short.MAX_VALUE)
                        .addComponent(ok))
                    .addComponent(header, javax.swing.GroupLayout.Alignment.LEADING))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(header)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 426, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ok)
                    .addComponent(total))
                .addContainerGap())
        );
        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void okActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_okActionPerformed
	this.setVisible(false);
    }//GEN-LAST:event_okActionPerformed
    
    public void setDataModel(String m, String project) {
	model = null;
	getData(m, project);
		
	if(m.equals("Unmapped")) {
	    model = new AbstractTableModel() {
	      public int getColumnCount() { return 1; }
	      public int getRowCount() { return methods.size();}
	      public String getColumnName(int col) {
		  switch(col) {
		      case 0: return "Method";
		      default: return "Error";
		  }
	      }
	      public Object getValueAt(int row, int col) { 
		  switch(col) {
		      case 0: return methods.get(row);
		      default: return "Error";
		  }
	      }
	    };
	} else if(m.equals("Unexecuted")) {
	    model = new AbstractTableModel() {
	      public int getColumnCount() { return 2; }
	      public int getRowCount() { return methods.size();}
	      public String getColumnName(int col) {
		  switch(col) {
		      case 0: return "Test ID";
		      case 1: return "Method";
		      default: return "Error";
		  }
	      }
	      public Object getValueAt(int row, int col) { 
		  switch(col) {
		      case 0: return ids.get(row);
		      case 1: return methods.get(row);
		      default: return "Error";
		  }
	      }
	    };
	} 
	
	TableRowSorter sorter = new TableRowSorter(model);
	sorter.setSortsOnUpdates(true);
	sorter.setSortKeys(keys);
	table.setModel(model);
	sorter.sort();
	table.setRowSorter(sorter);
	
	// set column widths
	// set label text
	if(m.equals("Unmapped")) {
	    table.getColumnModel().getColumn(0).setPreferredWidth(400);
	    header.setText("Automation methods in the Results table that are not mapped to a Test Case.");
	    total.setText("Records Displayed: " + methods.size());
	} else if (m.equals("Unexecuted")) {
	    table.getColumnModel().getColumn(0).setPreferredWidth(35);
	    table.getColumnModel().getColumn(1).setPreferredWidth(400);
	    header.setText("Test Cases that have automation mapped without any automated results in the database.");
	    total.setText("Records Displayed: " + methods.size());
	}
    }
    
    private void getData(String m, String project) {
	methods.clear();
	ids.clear();
	
	// database values
        try {
		Class.forName("com.mysql.jdbc.Driver");
	} catch (ClassNotFoundException e) {
		System.out.println("Class Not Found: " + e);
	}
        try {
	    Connection con = DriverManager.getConnection(dbConnection, dbUsername, dbPassword);
	    Statement stmt = con.createStatement();
	    
	    if(m.equals("Unmapped")) {
		String query = "select method from unmapped_automation_vw where project='" + project + "'";
		ResultSet rs = stmt.executeQuery(query);
		while(rs.next()) {
		    methods.add(rs.getString("method"));
		}
		rs.close();
		
	    }else if (m.equals("Unexecuted")) {
		String query = "select test_id, method from unexecuted_automation_vw where project='" + project + "'";
		ResultSet rs = stmt.executeQuery(query);
		while(rs.next()) {
		    ids.add(rs.getString("test_id"));
		    methods.add(rs.getString("method"));
		}
		rs.close();
	    }

	    // close database connection
	    stmt.close();
	    con.close();		
	} catch (SQLException e) {
		System.out.println("SQLException: " + e);
		JOptionPane.showMessageDialog(this, "SQLException: " + e, "Info", JOptionPane.INFORMATION_MESSAGE);
	}
	
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
	java.awt.EventQueue.invokeLater(new Runnable() {
	    public void run() {
		new DialogList(new javax.swing.JFrame(), true).setVisible(true);
	    }
	});
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel header;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton ok;
    private javax.swing.JTable table;
    private javax.swing.JLabel total;
    // End of variables declaration//GEN-END:variables
    
    private TableModel model;
    private ArrayList methods = new ArrayList();
    private ArrayList ids = new ArrayList();
    private ArrayList keys = new ArrayList();
    
    // database connection variables
    //private String dbConnection = "jdbc:mysql://localhost:3306/imos";
    //private String dbUsername = "imos";
    //private String dbPassword = "im0s";
    private String dbConnection = "jdbc:mysql://10.51.94.3/imos";
    private String dbUsername = "imos";
    private String dbPassword = "Testit66";
}
