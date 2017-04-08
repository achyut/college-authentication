/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.util.Vector;

/**
 *
 * @author Achyut
 */
public class CheckincheckOutReport extends javax.swing.JFrame {
    private String id,from,to;
    private boolean generateAll;
    final Vector data = new Vector();
    final Vector columnNames = new Vector();
    /**
     * Creates new form CheckincheckOutReport
     */
    public CheckincheckOutReport(String id, String from, String to, boolean generateAll) { 
        getData(id,from,to,generateAll);
        initComponents();
        setData(id,from,to,generateAll);
        setLocationRelativeTo(null);
    }

    private void setData(String id, String from, String to, boolean generateAll) {
        this.Jid.setText(id);
        if (generateAll == true) {
            this.fromTitle.setText("Showing all checkin checkout records");
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
        String query = null;
        Vector row = null;
        if (generateAll == false) {
                query = "SELECT cin.checkincurrentid as id, cin.checkintimestamp as inTime,"
                        + "'N/A' as outTime,TIMESTAMPDIFF(DAY,cin.checkintimestamp,NOW()) AS labday,"
                        + "(TIMESTAMPDIFF(HOUR,cin.checkintimestamp,NOW())-TIMESTAMPDIFF(DAY,cin.checkintimestamp,NOW())*24) AS labHour,"
                        + "(TIMESTAMPDIFF(MINUTE,cin.checkintimestamp,NOW())-TIMESTAMPDIFF(HOUR,cin.checkintimestamp,NOW())*60) AS labMinute,"
                        + "(TIMESTAMPDIFF(SECOND,cin.checkintimestamp,NOW())-TIMESTAMPDIFF(MINUTE,cin.checkintimestamp,NOW())*60) AS labSecond,"
                        + "ifnull(comp.computerid,'N/A') as computerid, ifnull(labno,'N/A') as labno, cin.operator as operator from checkincurrent as cin "
                        + "left join lablogincurrent as labcur "
                        + "on labcur.sessionid = cin.sessionid "
                        + "left join labloginmain as labmain "
                        + "on labmain.sessionid = cin.sessionid "
                        + "left join computerlist as comp "
                        + "on comp.computerid = labcur.computerid or comp.computerid = labmain.computerid "
                        + "where cin.checkincurrentid = '"+id+"' and cin.checkintimestamp >= '"+from+"'"
                        + " union "
                        + "select cmain.checkinmainid as id, cmain.checkintimestamp as inTime, cmain.checkouttimestamp as outTime,"
                        + "TIMESTAMPDIFF(DAY,cmain.checkintimestamp,cmain.checkouttimestamp) AS labday,"
                        + "(TIMESTAMPDIFF(HOUR,cmain.checkintimestamp,cmain.checkouttimestamp)-TIMESTAMPDIFF(DAY,cmain.checkintimestamp,cmain.checkouttimestamp)*24) AS labHour,"
                        + "(TIMESTAMPDIFF(MINUTE,cmain.checkintimestamp,cmain.checkouttimestamp)-TIMESTAMPDIFF(HOUR,cmain.checkintimestamp,cmain.checkouttimestamp)*60) AS labMinute,"
                        + "(TIMESTAMPDIFF(SECOND,cmain.checkintimestamp,cmain.checkouttimestamp)-TIMESTAMPDIFF(MINUTE,cmain.checkintimestamp,cmain.checkouttimestamp)*60) AS labSecond,"
                        + "ifnull(comp.computerid,'N/A') as computerid, ifnull(labno,'N/A') as labno, cmain.operator as operator from checkinmain as cmain "
                        + " left join lablogincurrent as labcur "
                        + "on labcur.sessionid = cmain.sessionid "
                        + "left join labloginmain as labmain "
                        + "on labmain.sessionid = cmain.sessionid "
                        + "left join computerlist as comp "
                        + "on comp.computerid = labcur.computerid or comp.computerid = labmain.computerid "
                        + "where cmain.checkinmainid = '"+id+"' and cmain.checkintimestamp >=  '"+from+"' and cmain.checkouttimestamp <= '"+to+"'"
                        + " order by inTime";
            } else {
                query = "SELECT cin.checkincurrentid as id, cin.checkintimestamp as inTime,"
                        + "'N/A' as outTime,TIMESTAMPDIFF(DAY,cin.checkintimestamp,NOW()) AS labday,"
                        + "(TIMESTAMPDIFF(HOUR,cin.checkintimestamp,NOW())-TIMESTAMPDIFF(DAY,cin.checkintimestamp,NOW())*24) AS labHour,"
                        + "(TIMESTAMPDIFF(MINUTE,cin.checkintimestamp,NOW())-TIMESTAMPDIFF(HOUR,cin.checkintimestamp,NOW())*60) AS labMinute,"
                        + "(TIMESTAMPDIFF(SECOND,cin.checkintimestamp,NOW())-TIMESTAMPDIFF(MINUTE,cin.checkintimestamp,NOW())*60) AS labSecond,"
                        + "ifnull(comp.computerid,'N/A') as computerid, ifnull(labno,'N/A') as labno, cin.operator as operator from checkincurrent as cin "
                        + "left join lablogincurrent as labcur "
                        + "on labcur.sessionid = cin.sessionid "
                        + "left join labloginmain as labmain "
                        + "on labmain.sessionid = cin.sessionid "
                        + "left join computerlist as comp "
                        + "on comp.computerid = labcur.computerid or comp.computerid = labmain.computerid "
                        + "where cin.checkincurrentid = '"+id+"'"
                        + " union "
                        + "select cmain.checkinmainid as id, cmain.checkintimestamp as inTime, cmain.checkouttimestamp as outTime,"
                        + "TIMESTAMPDIFF(DAY,cmain.checkintimestamp,cmain.checkouttimestamp) AS labday,"
                        + "(TIMESTAMPDIFF(HOUR,cmain.checkintimestamp,cmain.checkouttimestamp)-TIMESTAMPDIFF(DAY,cmain.checkintimestamp,cmain.checkouttimestamp)*24) AS labHour,"
                        + "(TIMESTAMPDIFF(MINUTE,cmain.checkintimestamp,cmain.checkouttimestamp)-TIMESTAMPDIFF(HOUR,cmain.checkintimestamp,cmain.checkouttimestamp)*60) AS labMinute,"
                        + "(TIMESTAMPDIFF(SECOND,cmain.checkintimestamp,cmain.checkouttimestamp)-TIMESTAMPDIFF(MINUTE,cmain.checkintimestamp,cmain.checkouttimestamp)*60) AS labSecond,"
                        + "ifnull(comp.computerid,'N/A') as computerid, ifnull(labno,'N/A') as labno, cmain.operator as operator from checkinmain as cmain "
                        + " left join lablogincurrent as labcur "
                        + "on labcur.sessionid = cmain.sessionid "
                        + "left join labloginmain as labmain "
                        + "on labmain.sessionid = cmain.sessionid "
                        + "left join computerlist as comp "
                        + "on comp.computerid = labcur.computerid or comp.computerid = labmain.computerid "
                        + "where cmain.checkinmainid = '"+id+"'"
                        + " order by inTime";
            }
        try {
            ResultSet rs = AbstractPerson.ab.getRecordFromQuery(query);
          
            columnNames.addElement("S.NO");
            columnNames.addElement("CHECK IN DATE/TIME");
            columnNames.addElement("CHECK OUT DATE/TIME");
            columnNames.addElement("DURATION INSIDE LAB");
            columnNames.addElement("COMPUTER ID");
            columnNames.addElement("LAB NO");
            columnNames.addElement("OPERATOR");
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
                    row.addElement(rs.getString("inTime"));
                    row.addElement(rs.getString("outTime"));
                    String duration = rs.getString("labDay") + "Day " + rs.getString("labHour") + " Hours" + rs.getString("labMinute") + " Minute " +rs.getString("labSecond")+" Sec";
                    row.addElement(duration);
                    row.addElement(rs.getString("computerid"));
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
            Log.log.writeErrorLog(e.getMessage(), "Checkincheckoutreport", "getData");
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

        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        titleText = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jSeparator2 = new javax.swing.JSeparator();
        jLabel3 = new javax.swing.JLabel();
        fromTitle = new javax.swing.JLabel();
        Jid = new javax.swing.JLabel();
        Jfrom = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        Jto = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle(": : CCN Usage Report : :");
        setResizable(false);

        jPanel1.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 2, true));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/nitLogo.png"))); // NOI18N

        titleText.setFont(new java.awt.Font("Stencil", 0, 25)); // NOI18N
        titleText.setForeground(new java.awt.Color(0, 0, 51));
        titleText.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        titleText.setText("center of computing and Networking");

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel1.setText("CCN Usage Report");

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel3.setText("ID");

        fromTitle.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        fromTitle.setText("From:");

        Jid.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        Jid.setText("jLabel3");

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
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(titleText))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(176, 176, 176)
                                .addComponent(jLabel1))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(40, 40, 40)
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(Jid)
                                .addGap(70, 70, 70)
                                .addComponent(fromTitle)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(Jfrom)
                                .addGap(53, 53, 53)
                                .addComponent(jLabel7)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(Jto)))
                        .addGap(45, 45, 45))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 766, Short.MAX_VALUE)
                            .addComponent(jSeparator2))
                        .addContainerGap())))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(33, 33, 33)
                        .addComponent(titleText)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(fromTitle)
                            .addComponent(Jid)
                            .addComponent(Jfrom)
                            .addComponent(jLabel7)
                            .addComponent(Jto)))
                    .addComponent(jLabel2))
                .addGap(18, 18, 18)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed

        Report r = new Report();
        r.checkInCheckOutRecord(id,from,to,generateAll);        
        
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed

        this.dispose();// TODO add your handling code here:
    }//GEN-LAST:event_jButton2ActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Jfrom;
    private javax.swing.JLabel Jid;
    private javax.swing.JLabel Jto;
    private javax.swing.JLabel fromTitle;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JTable jTable1;
    private javax.swing.JLabel titleText;
    // End of variables declaration//GEN-END:variables
}
