/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * Authenticate1.java
 *
 * Created on Jan 16, 2012, 4:33:51 PM
 */
package test;

import java.awt.event.KeyEvent;

/**
 *
 * @author Achyut
 */
    public class Authenticate1 extends javax.swing.JFrame {
    private String UserName;
    private String PassWord;
    private String UserType;
    int attempt = 3;
    /** Creates new form Authenticate1 */
    public Authenticate1() {
        initComponents();
        setLocationRelativeTo(null);
        attempts.setVisible(false);
    }

    int LoginValidation() {

        /*
        if (UserType.equalsIgnoreCase("Student")) {
        return true;
        } else
         */
        if (!((userName.getText()).equalsIgnoreCase("")) && !((passKey.getText()).equalsIgnoreCase("")) && (!((String) usrType.getSelectedItem()).equalsIgnoreCase(""))) {
            UserName = userName.getText();
            PassWord = passKey.getText();
            UserType = (String) usrType.getSelectedItem();
            return 1;
        } else if (((userName.getText()).equalsIgnoreCase("")) && ((passKey.getText()).equalsIgnoreCase("")) && (((String) usrType.getSelectedItem()).equalsIgnoreCase(""))) {
            return 2;
        } else if (((userName.getText()).equalsIgnoreCase("")) && !((passKey.getText()).equalsIgnoreCase("")) && (!((String) usrType.getSelectedItem()).equalsIgnoreCase(""))) {
            return 3;
        } else if (!((userName.getText()).equalsIgnoreCase("")) && ((passKey.getText()).equalsIgnoreCase("")) && !(((String) usrType.getSelectedItem()).equalsIgnoreCase(""))) {
            return 4;
        } else if (!((userName.getText()).equalsIgnoreCase("")) && !((passKey.getText()).equalsIgnoreCase("")) && (((String) usrType.getSelectedItem()).equalsIgnoreCase(""))) {
            return 5;
        } else if (((userName.getText()).equalsIgnoreCase("")) && ((passKey.getText()).equalsIgnoreCase("")) && !(((String) usrType.getSelectedItem()).equalsIgnoreCase(""))) {
            return 6;
        } else if (!((userName.getText()).equalsIgnoreCase("")) && ((passKey.getText()).equalsIgnoreCase("")) && (((String) usrType.getSelectedItem()).equalsIgnoreCase(""))) {
            return 7;
        } else if (((userName.getText()).equalsIgnoreCase("")) && !((passKey.getText()).equalsIgnoreCase("")) && (((String) usrType.getSelectedItem()).equalsIgnoreCase(""))) {
            return 8;
        } else {
            return 9;
        }
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        usrType = new javax.swing.JComboBox();
        userName = new javax.swing.JTextField();
        passKey = new javax.swing.JPasswordField();
        jSeparator1 = new javax.swing.JSeparator();
        cancel = new javax.swing.JButton();
        login = new javax.swing.JButton();
        attempts = new javax.swing.JLabel();
        useSSL = new javax.swing.JCheckBox();
        jLabel6 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Login...");
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                ae(evt);
            }
        });
        addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                formKeyPressed(evt);
            }
        });

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/64/lock.png"))); // NOI18N

        jLabel2.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        jLabel2.setText("Center of Computing and Networking");

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Login", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 14))); // NOI18N

        jLabel3.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        jLabel3.setText("Username");

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel4.setText("Password");

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel5.setText("UserType");

        usrType.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Incharge", "Student", "Clerk" }));
        usrType.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                usrTypeActionPerformed(evt);
            }
        });
        usrType.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                usrTypeKeyPressed(evt);
            }
        });

        userName.setBackground(new java.awt.Color(255, 255, 204));
        userName.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        userName.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        userName.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                userNameKeyPressed(evt);
            }
        });

        passKey.setBackground(new java.awt.Color(255, 255, 204));
        passKey.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        passKey.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        passKey.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                passKeyKeyPressed(evt);
            }
        });

        cancel.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        cancel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/32/button_cancel.png"))); // NOI18N
        cancel.setText("Cancel");
        cancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelActionPerformed(evt);
            }
        });
        cancel.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                cancelKeyPressed(evt);
            }
        });

        login.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        login.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/32/apply.png"))); // NOI18N
        login.setText("Login");
        login.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                loginActionPerformed(evt);
            }
        });
        login.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                loginKeyPressed(evt);
            }
        });

        attempts.setForeground(new java.awt.Color(255, 0, 0));
        attempts.setText("Attemps Remaining!!!!");

        useSSL.setText("Use Secured Connection");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.LEADING))
                        .addGap(37, 37, 37)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(usrType, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(userName)
                            .addComponent(passKey)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(useSSL)
                                .addGap(0, 84, Short.MAX_VALUE))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jSeparator1))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(login, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(cancel, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(84, 84, 84)
                        .addComponent(attempts, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(userName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel4)
                    .addComponent(passKey, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(usrType, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(useSSL)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(attempts)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(login)
                    .addComponent(cancel))
                .addContainerGap())
        );

        jLabel6.setText("National Institute of Technology,Kurukshetra");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(14, 14, 14)
                        .addComponent(jLabel1)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel2))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(36, 36, 36)
                                .addComponent(jLabel6))))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGap(33, 33, 33)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel6))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel1)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void loginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_loginActionPerformed
        login();
    }//GEN-LAST:event_loginActionPerformed
   
    private void login(){
        try{
        if (LoginValidation() == 1) {
            
            if ((Session.s1.AuthenticateLogin(UserName, PassWord, UserType) == true) && UserType.equalsIgnoreCase("student")) {
         
                   this.dispose();
                   StudentFormMain std = new StudentFormMain();
                   std.setVisible(true);
                   AbstractPerson.ab.checkBlacklist();
                   AbstractPerson.ab.checkStatus();
       
            } else if ((Session.s1.AuthenticateLogin(UserName, PassWord, UserType) == true) && UserType.equalsIgnoreCase("clerk")) {
               
                if(User.usr.checkMessage()!=null){
                   Message msg=new Message();
                   msg.setVisible(true);
               }
                ClerkFormMain clk = new ClerkFormMain();
                clk.setVisible(true);
                AbstractPerson.ab.checkBlacklist();
                   AbstractPerson.ab.checkStatus();
                this.dispose();
            } else if ((Session.s1.AuthenticateLogin(UserName, PassWord, UserType) == true) && UserType.equalsIgnoreCase("incharge")) {
               if(User.usr.checkMessage()!=null){
                   Message msg=new Message();
                   msg.setVisible(true);
               }
                InchargeFormMain inc = new InchargeFormMain();
                inc.setVisible(true);
                AbstractPerson.ab.checkBlacklist();
                AbstractPerson.ab.checkStatus();
                this.dispose();
            } else {
                
                
                DialogBox d1 = new DialogBox("invalid login details", "Error", 101);
                attempts.setText(attempt + " Attempts Remaining!!!");
                attempts.setVisible(true);
                attempt = attempt - 1;
                User.usr.setSessionID(UserName, UserType);
                User.usr.checkAttempt(Session.s1.userID);
                
                                    
                if(attempt < 0 ){
                Session.s1.closeSession();
                DatabaseMain.db.database_close();
                System.exit(0);
                }
                //  d1.showLoginErrorDialog();
            }
        } else if (LoginValidation() == 2) {
            DialogBox d1 = new DialogBox("Please fill UserName,Password and Usertype", "Error", 102);
        } else if (LoginValidation() == 3) {
            DialogBox d1 = new DialogBox("Please fill userName", "Error", 103);
        } else if (LoginValidation() == 4) {
            DialogBox d1 = new DialogBox("Please fill Password", "Error", 104);
        } else if (LoginValidation() == 5) {
            DialogBox d1 = new DialogBox("Please fill usertype", "Error", 105);
        } else if (LoginValidation() == 6) {
            DialogBox d1 = new DialogBox("Please fill UserName and Password", "Error", 106);
        } else if (LoginValidation() == 7) {
            DialogBox d1 = new DialogBox("Please fill Password and usertype", "Error", 107);
        } else if (LoginValidation() == 8) {
            DialogBox d1 = new DialogBox("Please fill username and usertype", "Error", 108);
        } else {
            DialogBox d1 = new DialogBox("Unknown Error!!! ", "Error", 109);
        }
        }
                catch(Exception ae){
                DialogBox.dialog.warningDialog(ae.getMessage());
                }    
    }
    private void cancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelActionPerformed
        // TODO add your handling code here:
        Session.s1.closeSession();
        DatabaseMain.db.database_close();
        System.exit(0);
    }//GEN-LAST:event_cancelActionPerformed

    private void ae(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_ae
        
        Session.s1.closeSession();
        DatabaseMain.db.database_close();
        System.exit(0);
        // TODO add your handling code here:
    }//GEN-LAST:event_ae

    private void passKeyKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_passKeyKeyPressed

        keyAction(evt);
    }//GEN-LAST:event_passKeyKeyPressed

        private void usrTypeKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_usrTypeKeyPressed

            keyAction(evt);
            // TODO add your handling code here:
        }//GEN-LAST:event_usrTypeKeyPressed

        private void loginKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_loginKeyPressed

        keyAction(evt);
// TODO add your handling code here:
        }//GEN-LAST:event_loginKeyPressed

        private void cancelKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_cancelKeyPressed

                    keyAction(evt);
// TODO add your handling code here:
        }//GEN-LAST:event_cancelKeyPressed

        void keyAction(java.awt.event.KeyEvent evt){
        int key = evt.getKeyCode();
        if(key == KeyEvent.VK_ENTER){
            login();
        }
        if(key == KeyEvent.VK_ESCAPE){
            System.exit(0);
          }
        }
        private void formKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_formKeyPressed

        keyAction(evt);
        
        
// TODO add your handling code here:
        }//GEN-LAST:event_formKeyPressed

        private void usrTypeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_usrTypeActionPerformed
            // TODO add your handling code here:
        }//GEN-LAST:event_usrTypeActionPerformed

        private void userNameKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_userNameKeyPressed

            keyAction(evt);
            // TODO add your handling code here:
        }//GEN-LAST:event_userNameKeyPressed
    /**
     * @param args the command line arguments
     */
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel attempts;
    private javax.swing.JButton cancel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JButton login;
    private javax.swing.JPasswordField passKey;
    private javax.swing.JCheckBox useSSL;
    private javax.swing.JTextField userName;
    private javax.swing.JComboBox usrType;
    // End of variables declaration//GEN-END:variables
}
