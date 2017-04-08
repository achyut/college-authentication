/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

/**
 *
 * @author Achyut
 */
public class Init2 extends javax.swing.JFrame {

    /**
     * Creates new form Init2
     */
    public Init2() {
        initComponents();
        setLocationRelativeTo(null);

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel2 = new javax.swing.JLabel();
        jSeparator2 = new javax.swing.JSeparator();
        jPanel2 = new javax.swing.JPanel();
        localSelect = new javax.swing.JCheckBox();
        jPanel4 = new javax.swing.JPanel();
        localDbPrio = new javax.swing.JRadioButton();
        masterDbPrio = new javax.swing.JRadioButton();
        masterDbPanel = new javax.swing.JPanel();
        masterDbType = new javax.swing.JComboBox();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        masterIp = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        masterPort = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        masterUsername = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        masterPassword = new javax.swing.JPasswordField();
        jLabel8 = new javax.swing.JLabel();
        masterDbName = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        masterConn = new javax.swing.JTextField();
        masterUseSSL = new javax.swing.JCheckBox();
        masterDbPanel1 = new javax.swing.JPanel();
        localDbType = new javax.swing.JComboBox();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        localIp = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        localPort = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        localUsername = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        localPassword = new javax.swing.JPasswordField();
        jLabel15 = new javax.swing.JLabel();
        localDbName = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        localConn = new javax.swing.JTextField();
        localUseSSL = new javax.swing.JCheckBox();
        jPanel3 = new javax.swing.JPanel();
        jButton2 = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle(": : Initialize : :");
        setResizable(false);

        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/apely_logo.png"))); // NOI18N

        jLabel2.setFont(new java.awt.Font("College", 0, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(102, 0, 0));
        jLabel2.setText("APELEY DISTRIBUTED AUTHENTICATION SYSTEMS");

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Select the database to use", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 1, 12))); // NOI18N

        localSelect.setSelected(true);
        localSelect.setText("Use Local Database");
        localSelect.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                localSelectActionPerformed(evt);
            }
        });

        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder("Database Priority"));

        buttonGroup1.add(localDbPrio);
        localDbPrio.setSelected(true);
        localDbPrio.setText("Local Database");

        buttonGroup1.add(masterDbPrio);
        masterDbPrio.setText("Master Database");
        masterDbPrio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                masterDbPrioActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addComponent(masterDbPrio)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 69, Short.MAX_VALUE)
                .addComponent(localDbPrio)
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(localDbPrio)
                .addComponent(masterDbPrio))
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(53, 53, 53)
                .addComponent(localSelect)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(localSelect)
                .addContainerGap())
        );

        masterDbPanel.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Master Database Configuration", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 1, 12))); // NOI18N

        masterDbType.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Mysql", "Oracle", "Mssql" }));
        masterDbType.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                masterDbTypeItemStateChanged(evt);
            }
        });
        masterDbType.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                masterDbTypeActionPerformed(evt);
            }
        });

        jLabel3.setText("Database Type:");

        jLabel4.setText("Ip Address:");

        jLabel5.setText("Port No:");

        jLabel6.setText("Username:");

        jLabel7.setText("Password:");

        jLabel8.setText("Conn String:");

        masterDbName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                masterDbNameActionPerformed(evt);
            }
        });

        jLabel9.setText("Database Name: ");

        masterUseSSL.setText("use SSL");

        javax.swing.GroupLayout masterDbPanelLayout = new javax.swing.GroupLayout(masterDbPanel);
        masterDbPanel.setLayout(masterDbPanelLayout);
        masterDbPanelLayout.setHorizontalGroup(
            masterDbPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(masterDbPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(masterDbPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel6)
                    .addGroup(masterDbPanelLayout.createSequentialGroup()
                        .addComponent(jLabel9)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(masterDbPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(masterUsername, javax.swing.GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE)
                            .addComponent(masterDbName)))
                    .addComponent(jLabel4)
                    .addGroup(masterDbPanelLayout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(masterDbPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(masterIp, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(masterDbType, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addGap(12, 12, 12)
                .addGroup(masterDbPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel8)
                    .addComponent(jLabel7)
                    .addComponent(jLabel5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(masterDbPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(masterPassword)
                    .addComponent(masterConn)
                    .addGroup(masterDbPanelLayout.createSequentialGroup()
                        .addGroup(masterDbPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(masterUseSSL)
                            .addComponent(masterPort, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        masterDbPanelLayout.setVerticalGroup(
            masterDbPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(masterDbPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(masterDbPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(masterDbType, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3)
                    .addComponent(masterUseSSL))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(masterDbPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(masterIp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5)
                    .addComponent(masterPort, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(masterDbPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(masterDbName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8)
                    .addComponent(masterConn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(masterDbPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(masterUsername, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7)
                    .addComponent(masterPassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(52, 52, 52))
        );

        masterDbPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Local Database Configuration", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 1, 12))); // NOI18N

        localDbType.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Mysql", "Oracle", "Mssql" }));
        localDbType.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                localDbTypeItemStateChanged(evt);
            }
        });

        jLabel10.setText("Database Type:");

        jLabel11.setText("Ip Address:");

        jLabel12.setText("Port No:");

        jLabel13.setText("Username:");

        jLabel14.setText("Password:");

        jLabel15.setText("Conn String:");

        localDbName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                localDbNameActionPerformed(evt);
            }
        });

        jLabel16.setText("Database Name: ");

        localUseSSL.setText("use SSL");

        javax.swing.GroupLayout masterDbPanel1Layout = new javax.swing.GroupLayout(masterDbPanel1);
        masterDbPanel1.setLayout(masterDbPanel1Layout);
        masterDbPanel1Layout.setHorizontalGroup(
            masterDbPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(masterDbPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(masterDbPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel13)
                    .addGroup(masterDbPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel16)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(masterDbPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(localUsername, javax.swing.GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE)
                            .addComponent(localDbName)))
                    .addComponent(jLabel11)
                    .addGroup(masterDbPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel10)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(masterDbPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(localIp, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(localDbType, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addGap(12, 12, 12)
                .addGroup(masterDbPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel15)
                    .addComponent(jLabel14)
                    .addComponent(jLabel12))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(masterDbPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(localPassword)
                    .addComponent(localConn)
                    .addGroup(masterDbPanel1Layout.createSequentialGroup()
                        .addGroup(masterDbPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(localUseSSL)
                            .addComponent(localPort, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        masterDbPanel1Layout.setVerticalGroup(
            masterDbPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(masterDbPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(masterDbPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(localDbType, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10)
                    .addComponent(localUseSSL))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(masterDbPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(localIp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel12)
                    .addComponent(localPort, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(masterDbPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel16)
                    .addComponent(localDbName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel15)
                    .addComponent(localConn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(masterDbPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel13)
                    .addComponent(localUsername, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel14)
                    .addComponent(localPassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(52, 52, 52))
        );

        jPanel3.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jButton2.setText("Back");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton1.setText("Next");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton3.setText("Cancel");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(130, 130, 130)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton1)
                    .addComponent(jButton3))
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jSeparator1)
                                    .addComponent(jSeparator2)))
                            .addComponent(masterDbPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(masterDbPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(13, 13, 13)
                        .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(1, 1, 1)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(masterDbPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(masterDbPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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

    private void localSelectActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_localSelectActionPerformed

        if (localSelect.isSelected() == true) {
            localDbType.enable();
            localIp.enable();
            localUsername.enable();
            localPassword.enable();
            localDbName.enable();
            localConn.enable();
            localPort.enable();
            localDbPrio.enable();
            masterDbPrio.enable();
            localDbPrio.setSelected(true);
        } else if (localSelect.isSelected() == false) {
            localDbType.disable();
            localIp.disable();
            localUsername.disable();
            localPassword.disable();
            localDbName.disable();
            localConn.disable();
            localPort.disable();
            masterDbPrio.setSelected(true);
            localDbPrio.setSelected(false);
            localDbPrio.disable();
            
        }// TODO add your handling code here:
    }//GEN-LAST:event_localSelectActionPerformed

    private void masterDbNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_masterDbNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_masterDbNameActionPerformed

    private void localDbNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_localDbNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_localDbNameActionPerformed

    private void masterDbTypeItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_masterDbTypeItemStateChanged

        if (masterDbType.getSelectedItem().toString().equalsIgnoreCase("mysql")) {
            masterPort.setText("3306");
        } else if (masterDbType.getSelectedItem().toString().equalsIgnoreCase("oracle")) {
            masterPort.setText("4404");
        }
         else if (masterDbType.getSelectedItem().toString().equalsIgnoreCase("mssql")) {
            masterPort.setText("1433");
    }//GEN-LAST:event_masterDbTypeItemStateChanged
    }
    private void localDbTypeItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_localDbTypeItemStateChanged

        if (localDbType.getSelectedItem().toString().equalsIgnoreCase("mysql")) {
            localPort.setText("3306");
        } else if (localDbType.getSelectedItem().toString().equalsIgnoreCase("oracle")) {
            localPort.setText("4404");
        }
        else if (masterDbType.getSelectedItem().toString().equalsIgnoreCase("mssql")) {
            masterPort.setText("1433");
            }
        // TODO add your handling code here:
    }//GEN-LAST:event_localDbTypeItemStateChanged

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        Init1 n = new Init1();
        n.setVisible(true);
        this.dispose();// TODO add your handling code here:
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        setValues();
        Init3 in3 = new Init3();
        this.dispose();
        in3.setVisible(true);// TODO add your handling code here:
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        this.dispose();// TODO add your handling code here:
    }//GEN-LAST:event_jButton3ActionPerformed

    private void masterDbPrioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_masterDbPrioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_masterDbPrioActionPerformed

    private void masterDbTypeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_masterDbTypeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_masterDbTypeActionPerformed

    void setValues() {
        String dbPriority = "localDb";
        String lDbSel = "false";
        
        if (this.localSelect.isSelected() == true) {
            if (this.masterDbPrio.isSelected() == true) {
                dbPriority = "masterDb";
            } else if (this.localDbPrio.isSelected() == true) {
                dbPriority = "localDb";
            }
            lDbSel = "true";
        } else if (this.localSelect.isSelected() == false) {
            dbPriority = "masterDb";
            lDbSel = "false";
        }

        ReadConfigFile.conf.dbPriority = dbPriority;
        ReadConfigFile.conf.useLocalDb = lDbSel;
        ReadConfigFile.conf.useMasterSSL = this.masterUseSSL.isSelected();
        ReadConfigFile.conf.useLocalSSL = this.localUseSSL.isSelected();

        ReadConfigFile.conf.masterDbType = this.masterDbType.getSelectedItem().toString();
        ReadConfigFile.conf.masterDbIp = this.masterIp.getText();
        ReadConfigFile.conf.masterDbPort = this.masterPort.getText();
        ReadConfigFile.conf.masterConnStr = this.masterConn.getText();
        ReadConfigFile.conf.masterDbName = this.masterDbName.getText();
        ReadConfigFile.conf.masterUsername = this.masterUsername.getText();
        ReadConfigFile.conf.masterPassword = this.masterPassword.getText();

        ReadConfigFile.conf.localDbType = this.localDbType.getSelectedItem().toString();
        ReadConfigFile.conf.localDbIp = this.localIp.getText();
        ReadConfigFile.conf.localDbPort = this.localPort.getText();
        ReadConfigFile.conf.localDbName = this.localDbName.getText();
        ReadConfigFile.conf.localConnStr = this.localConn.getText();
        ReadConfigFile.conf.localUsername = this.localUsername.getText();
        ReadConfigFile.conf.localPassword = this.localPassword.getText();

    }

    void getPrevious() {
        this.masterDbType.setSelectedItem(ReadConfigFile.conf.masterDbType);
        this.masterIp.setText(ReadConfigFile.conf.masterDbIp);
        this.masterPort.setText(ReadConfigFile.conf.masterDbPort);
        this.masterDbName.setText(ReadConfigFile.conf.masterDbName);
        this.masterConn.setText(ReadConfigFile.conf.masterConnStr);
        this.masterUsername.setText(ReadConfigFile.conf.masterUsername);
        this.masterPassword.setText(ReadConfigFile.conf.masterPassword);

        this.localDbType.setSelectedItem(ReadConfigFile.conf.localDbType);
        this.localIp.setText(ReadConfigFile.conf.localDbIp);
        this.localPort.setText(ReadConfigFile.conf.localDbPort);
        this.localDbName.setText(ReadConfigFile.conf.localDbName);
        this.localConn.setText(ReadConfigFile.conf.localConnStr);
        this.localUsername.setText(ReadConfigFile.conf.localUsername);
        this.localPassword.setText(ReadConfigFile.conf.localPassword);
        this.masterUseSSL.setSelected(ReadConfigFile.conf.useMasterSSL);
        this.localUseSSL.setSelected(ReadConfigFile.conf.useLocalSSL);
        if (ReadConfigFile.conf.useLocalDb.equalsIgnoreCase("true")) {
            this.localSelect.setSelected(true);
            if (ReadConfigFile.conf.dbPriority.equalsIgnoreCase("masterDb")) {
                this.masterDbPrio.setSelected(true);
            } else if (ReadConfigFile.conf.dbPriority.equalsIgnoreCase("localDb")) {
                this.localDbPrio.setSelected(true);
            }
        } else if (ReadConfigFile.conf.useLocalDb.equalsIgnoreCase("false")) {
            if (ReadConfigFile.conf.dbPriority.equalsIgnoreCase("masterDb")) {
                this.masterDbPrio.setSelected(true);
            } else if (ReadConfigFile.conf.dbPriority.equalsIgnoreCase("localDb")) {
                this.localDbPrio.setSelected(true);
            }
            this.localSelect.setSelected(false);
            localDbType.disable();
            localIp.disable();
            localUsername.disable();
            localPassword.disable();
            localDbName.disable();
            localConn.disable();
            localPort.disable();
            localDbPrio.disable();
            masterDbPrio.disable();
            
        }
    }
    /**
     * @param args the command line arguments
     */
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JTextField localConn;
    private javax.swing.JTextField localDbName;
    private javax.swing.JRadioButton localDbPrio;
    private javax.swing.JComboBox localDbType;
    private javax.swing.JTextField localIp;
    private javax.swing.JPasswordField localPassword;
    private javax.swing.JTextField localPort;
    private javax.swing.JCheckBox localSelect;
    private javax.swing.JCheckBox localUseSSL;
    private javax.swing.JTextField localUsername;
    private javax.swing.JTextField masterConn;
    private javax.swing.JTextField masterDbName;
    private javax.swing.JPanel masterDbPanel;
    private javax.swing.JPanel masterDbPanel1;
    private javax.swing.JRadioButton masterDbPrio;
    private javax.swing.JComboBox masterDbType;
    private javax.swing.JTextField masterIp;
    private javax.swing.JPasswordField masterPassword;
    private javax.swing.JTextField masterPort;
    private javax.swing.JCheckBox masterUseSSL;
    private javax.swing.JTextField masterUsername;
    // End of variables declaration//GEN-END:variables
}