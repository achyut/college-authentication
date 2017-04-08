package test;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.util.Vector;

/**
 *
 * @author APELY
 */
public class CurrentLabLogin extends javax.swing.JFrame {
    String action;
    final Vector columnNames = new Vector();
    final Vector data = new Vector();

    /**
     * Creates new form CurrentCheckin
     */
    public CurrentLabLogin(String tempAction) {
        getdata();
        initComponents();
        setLocationRelativeTo(null);
        action = tempAction;
        if(action.equalsIgnoreCase("logoutall")){
            printButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/32/logout.png")));
            printButton.setText("Log Out");
        }
    }

    private void getdata() {
        int k = 0;
        Vector row = null;
        String compid = "N/A";
        String labno = "N/A";
        String query = "select cin.lablogincurrentid as id,concat(ifnull(g.name,''),ifnull(f.name,''),ifnull(s.name,''))as name,cin.logintime as logintime, cin.computerid as comp,labno,operator from lablogincurrent cin left join guest g on g.guestid=cin.lablogincurrentid left join  faculty f on f.facultyid=cin.lablogincurrentid left join student s on s.studentid=cin.lablogincurrentid left join checkincurrent lab on cin.sessionid = lab.sessionid left join computerlist as comp on cin.computerid = comp.computerid";

        try {
            ResultSet rs = AbstractPerson.ab.getRecordFromQuery(query);
        
            columnNames.addElement("SNO");
            columnNames.addElement("ID");
            columnNames.addElement("Name");
            columnNames.addElement("LAB LOGIN TIME");
            columnNames.addElement("SYSTEM");
            columnNames.addElement("LAB NO");
            columnNames.addElement("OPERATOR");
            if (rs != null) {
            ResultSetMetaData md = rs.getMetaData();
            int columns = md.getColumnCount();
                do {
                        row = new Vector();
                        row.addElement(new Integer(++k));
                    
                        /*
                         * for (int i = 1; i <= columns; i++) {
                         * row.addElement(rs.getObject(i)); }
                         */    
                        row.addElement(rs.getString("id"));
                        row.addElement(rs.getString("name"));
                        row.addElement(rs.getString("logintime"));
                        row.addElement(rs.getString("comp"));
                        row.addElement(rs.getString("labno"));
                        row.addElement(rs.getString("operator"));
                        data.addElement(row);
                        
                } while (rs.next());
            }/* else {
                for (int i = 1; i <= 7; i++) {
                    row.addElement(null);
                }
            }*/

        } catch (Exception e) {
            System.out.println(e.getMessage());
            Log.log.writeErrorLog(e.getMessage(), "CurrentTableInfo", "getData");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        titleText = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        printButton = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        jSeparator2 = new javax.swing.JSeparator();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle(": : Current Check In Report : :");
        setResizable(false);

        jPanel1.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 2, true));

        titleText.setFont(new java.awt.Font("Stencil", 0, 25)); // NOI18N
        titleText.setForeground(new java.awt.Color(0, 0, 51));
        titleText.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        titleText.setText("center of computing and Networking");

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel1.setText("Current Lab Login Report");

        jPanel2.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        printButton.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        printButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/32/print.png"))); // NOI18N
        printButton.setText("Print");
        printButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                printButtonActionPerformed(evt);
            }
        });

        jButton2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/32/button_cancel.png"))); // NOI18N
        jButton2.setText("Cancel");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(printButton, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(printButton, javax.swing.GroupLayout.DEFAULT_SIZE, 43, Short.MAX_VALUE)
                    .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        jTable2.setModel(new javax.swing.table.DefaultTableModel(data,columnNames)
        );
        jScrollPane2.setViewportView(jTable2);

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/nitLogo.png"))); // NOI18N

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jLabel2)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(titleText))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(152, 152, 152)
                                .addComponent(jLabel1)))
                        .addGap(35, 35, 35)))
                .addContainerGap())
            .addComponent(jSeparator2)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2)
                .addGap(13, 13, 13))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(44, 44, 44)
                        .addComponent(titleText)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel1))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel2)))
                .addGap(18, 18, 18)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 203, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 20, Short.MAX_VALUE)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void printButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_printButtonActionPerformed

        if(action.equalsIgnoreCase("print")){
        
        }
       else if(action.equalsIgnoreCase("logoutall")){
            if(DialogBox.dialog.confirmDialog("Do you want to logout all lab users currently inside ???") == 0){
                if(AbstractPerson.ab.computerLogoutAll()==1)
                DialogBox.dialog.successDialog("All Users Successfully logged Out");
                else if(AbstractPerson.ab.computerLogoutAll()==0)
                    DialogBox.dialog.errorDialog("An Error occured while logging out");
                else if(AbstractPerson.ab.computerLogoutAll()==2)
                    DialogBox.dialog.errorDialog("Currently no one is logged in");
            }
            else{
            this.dispose();
            }
        }
        // TODO add your handling code here:
    }//GEN-LAST:event_printButtonActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed

        this.dispose();// TODO add your handling code here:
    }//GEN-LAST:event_jButton2ActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JTable jTable2;
    private javax.swing.JButton printButton;
    private javax.swing.JLabel titleText;
    // End of variables declaration//GEN-END:variables
}
