/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import java.awt.event.KeyEvent;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.util.Vector;

/**
 *
 * @author Achyut
 */
public class LabDetailsReport extends javax.swing.JFrame {
    private String id,from,to;
    private boolean generateAll;
    final Vector data = new Vector();
    final Vector columnNames = new Vector();
    /**
     * Creates new form ComputerDetailsReport
     */
    public LabDetailsReport(String id, String from, String to, boolean generateAll) {
        getData(id,from,to,generateAll);
        initComponents();
        setData(id,from,to,generateAll);
        setLocationRelativeTo(null);
    }
 private void setData(String id, String from, String to, boolean generateAll) {
        this.Jid.setText(id);
        if (generateAll == true) {
            this.fromTitle.setText("Showing all records of Lab");
            this.Jfrom.hide();
            this.Jto.hide();
            this.jLabel7.hide();
        } else {
            this.Jfrom.setText(from);
            this.Jto.setText(to);
        }
        this.id = id;
        this.from = from;
        this.to = to;
        this.generateAll = generateAll;
    }
    private void getData(String id, String from, String to, boolean generateAll) {
         int k = 0;
        String query;
        Vector row = null;
        if (generateAll == false) {
                query = "select labcur.lablogincurrentid as id,labcur.computerid,concat(ifnull(g.name,''),ifnull(f.name,''),ifnull(s.name,''))as name,labcur.computerid,labcur.logintime as logintime, 'N/A' as logouttime,"
                        + "TIMESTAMPDIFF(DAY,labcur.logintime,NOW()) AS day,"
                        + "(TIMESTAMPDIFF(HOUR,labcur.logintime,NOW())-TIMESTAMPDIFF(DAY,labcur.logintime,NOW())*24) AS hour,"
                        + "(TIMESTAMPDIFF(MINUTE,labcur.logintime,NOW())-TIMESTAMPDIFF(HOUR,labcur.logintime,NOW())*60) AS min,"
                        + "(TIMESTAMPDIFF(SECOND,labcur.logintime,NOW())-TIMESTAMPDIFF(MINUTE,labcur.logintime,NOW())*60) AS sec"
                        + " from lablogincurrent as labcur"
                        + " left join student as s on labcur.lablogincurrentid = s.studentid"
                        + " left join guest as g on labcur.lablogincurrentid = g.guestid"
                        + " left join faculty as f on labcur.lablogincurrentid = f.facultyid"
                        + " left join computerlist as comp on comp.computerid = labcur.computerid"
                        + " where labno ='"+id+"' and labcur.logintime >='"+from+"'"
                        + " union "
                        + "select labmain.labloginmainid as id,labmain.computerid,concat(ifnull(g.name,''),ifnull(f.name,''),ifnull(s.name,''))as name,labmain.computerid,labmain.logintime as logintime, labmain.logouttime as logouttime,"
                        + "TIMESTAMPDIFF(DAY,labmain.logintime,labmain.logouttime) AS day,"
                        + "(TIMESTAMPDIFF(HOUR,labmain.logintime,labmain.logouttime)-TIMESTAMPDIFF(DAY,labmain.logintime,labmain.logouttime)*24) AS hour,"
                        + "(TIMESTAMPDIFF(MINUTE,labmain.logintime,labmain.logouttime)-TIMESTAMPDIFF(HOUR,labmain.logintime,labmain.logouttime)*60) AS min,"
                        + "(TIMESTAMPDIFF(SECOND,labmain.logintime,labmain.logouttime)-TIMESTAMPDIFF(MINUTE,labmain.logintime,labmain.logouttime)*60) AS sec"
                        + " from labloginmain as labmain"
                        + " left join student as s on labmain.labloginmainid = s.studentid"
                        + " left join guest as g on labmain.labloginmainid = g.guestid"
                        + " left join faculty as f on labmain.labloginmainid = f.facultyid"
                        + " left join computerlist as comp on comp.computerid = labmain.computerid"
                        + " where labno ='"+id+"' and labmain.logintime='"+from+"' and labmain.logouttime <='"+to+"'"
                        + "order by logintime desc";

        } else {
               query = "select labcur.lablogincurrentid as id,labcur.computerid,concat(ifnull(g.name,''),ifnull(f.name,''),ifnull(s.name,''))as name,"
                       + "labcur.logintime as logintime, 'N/A' as logouttime,"
                       + "TIMESTAMPDIFF(DAY,labcur.logintime,NOW()) AS day,"
                       + "(TIMESTAMPDIFF(HOUR,labcur.logintime,NOW())-TIMESTAMPDIFF(DAY,labcur.logintime,NOW())*24) AS hour,"
                       + "(TIMESTAMPDIFF(MINUTE,labcur.logintime,NOW())-TIMESTAMPDIFF(HOUR,labcur.logintime,NOW())*60) AS min,"
                       + "(TIMESTAMPDIFF(SECOND,labcur.logintime,NOW())-TIMESTAMPDIFF(MINUTE,labcur.logintime,NOW())*60) AS sec"
                       + " from lablogincurrent as labcur"
                       + " left join student as s"
                       + " on labcur.lablogincurrentid = s.studentid "
                       + " left join guest as g"
                       + " on labcur.lablogincurrentid = g.guestid"
                       + " left join faculty as f"
                       + " on labcur.lablogincurrentid = f.facultyid"
                       + " left join computerlist as comp"
                       + " on comp.computerid = labcur.computerid"
                       + " where labno ='"+id+"'"
                       + " union"
                       + " select labmain.labloginmainid as id,labmain.computerid,concat(ifnull(g.name,''),ifnull(f.name,''),ifnull(s.name,''))as name,"
                       + "labmain.logintime as logintime, labmain.logouttime as logouttime,"
                       + "TIMESTAMPDIFF(DAY,labmain.logintime,labmain.logouttime) AS day,"
                       + "(TIMESTAMPDIFF(HOUR,labmain.logintime,labmain.logouttime)-TIMESTAMPDIFF(DAY,labmain.logintime,labmain.logouttime)*24) AS hour,"
                       + "(TIMESTAMPDIFF(MINUTE,labmain.logintime,labmain.logouttime)-TIMESTAMPDIFF(HOUR,labmain.logintime,labmain.logouttime)*60) AS min,"
                       + "(TIMESTAMPDIFF(SECOND,labmain.logintime,labmain.logouttime)-TIMESTAMPDIFF(MINUTE,labmain.logintime,labmain.logouttime)*60) AS sec"
                       + " from labloginmain as labmain"
                       + " left join student as s"
                       + " on labmain.labloginmainid = s.studentid"
                       + " left join guest as g"
                       + " on labmain.labloginmainid = g.guestid"
                       + " left join faculty as f"
                       + " on labmain.labloginmainid = f.facultyid"
                       + " left join computerlist as comp"
                       + " on comp.computerid = labmain.computerid"
                       + " where labno ='"+id+"'"
                       + " order by logintime desc";
        }
        try {
            columnNames.addElement("S.NO");
            columnNames.addElement("ID");
            columnNames.addElement("NAME");
            columnNames.addElement("COMPUTER ID");
            columnNames.addElement("LOGIN TIME");
            columnNames.addElement("LOGOUT TIME");
            columnNames.addElement("DURATION");
            ResultSet rs = AbstractPerson.ab.getRecordFromQuery(query);
            if (rs != null) {
            ResultSetMetaData md = rs.getMetaData();
            int columns = md.getColumnCount();
     
            
                do {
                    //   System.out.print(rs.getString("checkincurrentid"));
                    //ResultSet rs1=AbstractPerson.ab.getRecordFromQuery("SELECT * FROM student,guest,faculty WHERE (guest.guestid='" + rs.getString("blacklistcurrentid") + "') OR (student.studentid = '" + rs.getString("blacklistcurrentid")+ "')  OR (faculty.facultyid = '" + rs.getString("blacklistcurrentid") + "')");
                    row = new Vector();
                    row.addElement(new Integer(++k));
                    /*
                     * for (int i = 1; i <= columns; i++) {
                     * row.addElement(rs.getObject(i)); }
                     *
                     */
                    row.addElement(rs.getString("id"));
                    row.addElement(rs.getString("name"));
                    row.addElement(rs.getString("computerid"));
                    row.addElement(rs.getString("logintime"));
                    row.addElement(rs.getString("logouttime"));
                    String duration = rs.getString("day") + "Day " + rs.getString("hour") + " Hours" + rs.getString("min") + " Minute " +rs.getString("sec")+" Sec";
                    row.addElement(duration);
                    data.addElement(row);
                } while (rs.next());
                
            } 

        } catch (Exception e) {
            Log.log.writeErrorLog(e.getMessage(), "BlackListMainReport", "getData");
        }
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel3 = new javax.swing.JLabel();
        titleText = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        Jid = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        fromTitle = new javax.swing.JLabel();
        Jfrom = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        Jto = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle(": : Lab Usage Report : :");
        setResizable(false);

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/nitLogo.png"))); // NOI18N

        titleText.setFont(new java.awt.Font("Stencil", 0, 25)); // NOI18N
        titleText.setForeground(new java.awt.Color(0, 0, 51));
        titleText.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        titleText.setText("center of computing and Networking");

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel1.setText("Lab Usage Details Report");

        Jid.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        Jid.setText("jLabel3");

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel4.setText("Lab ID");

        fromTitle.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        fromTitle.setText("From:");

        Jfrom.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        Jfrom.setText("jLabel3");

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel7.setText("To:");

        Jto.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        Jto.setText("jLabel3");

        jTable1.setModel(new javax.swing.table.DefaultTableModel(data,columnNames
        ));
        jScrollPane1.setViewportView(jTable1);

        jPanel2.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jButton1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/32/print.png"))); // NOI18N
        jButton1.setText("Print");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jButton1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jButton1KeyPressed(evt);
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
        jButton2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jButton2KeyPressed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 623, Short.MAX_VALUE)
                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, 43, Short.MAX_VALUE)
                    .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jSeparator1)
                            .addComponent(jScrollPane1)
                            .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addComponent(jLabel3)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(118, 118, 118)
                                .addComponent(jLabel1))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(30, 30, 30)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(titleText)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(39, 39, 39)
                                        .addComponent(jLabel4)
                                        .addGap(18, 18, 18)
                                        .addComponent(Jid)
                                        .addGap(53, 53, 53)
                                        .addComponent(fromTitle)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(Jfrom)
                                        .addGap(57, 57, 57)
                                        .addComponent(jLabel7)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(Jto)))))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(28, 28, 28)
                        .addComponent(titleText)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel1)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(Jid)
                            .addComponent(fromTitle)
                            .addComponent(Jfrom)
                            .addComponent(jLabel7)
                            .addComponent(Jto))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(jLabel3))
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed

        Report r = new Report();
        r.LabUsage(id, from, to, generateAll);
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed

        this.dispose();// TODO add your handling code here:
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton1KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jButton1KeyPressed

         int key = evt.getKeyCode();
        if (key == KeyEvent.VK_ENTER) {   
        Report r = new Report();
        r.LabUsage(id, from, to, generateAll);
        }// TODO add your handling code here:
    }//GEN-LAST:event_jButton1KeyPressed

    private void jButton2KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jButton2KeyPressed
int key = evt.getKeyCode();
        if (key == KeyEvent.VK_ENTER) {   
        this.dispose();
        }
    }//GEN-LAST:event_jButton2KeyPressed

    /**
     * @param args the command line arguments
     */
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Jfrom;
    private javax.swing.JLabel Jid;
    private javax.swing.JLabel Jto;
    private javax.swing.JLabel fromTitle;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTable jTable1;
    private javax.swing.JLabel titleText;
    // End of variables declaration//GEN-END:variables
}
