/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * userDetailForm.java
 *
 * Created on Jan 18, 2012, 1:02:20 AM
 */
package test;
import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import javax.swing.ImageIcon;


/**
 *
 * @author Administrator
 */
public class UserDetailsForm extends javax.swing.JFrame {
    String action = "";
    int tempID;
    /** Creates new form userDetailForm */
    public UserDetailsForm() {
        initComponents();
        setLocationRelativeTo(null);
        tempID = User.usr.generateUserID();
        userId.setText("USR-"+tempID);
        userName.requestFocus();
    }
    
    public UserDetailsForm(String type){
    action = type;
    initComponents();
    setLocationRelativeTo(null);
    tempID = User.usr.generateUserID();
    userId.setText("USR-"+tempID);
    userName.requestFocus();
    
    }
    private void refreshID(){
    tempID = tempID + 1;
    userId.setText("USR-"+tempID);
    }
    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        statusGroup = new javax.swing.ButtonGroup();
        jLabel1 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        userId = new javax.swing.JTextField();
        userName = new javax.swing.JTextField();
        Address = new javax.swing.JTextField();
        phoneNo = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        reset = new javax.swing.JButton();
        cancel = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();
        userType = new javax.swing.JComboBox();
        jSeparator1 = new javax.swing.JSeparator();
        submit = new javax.swing.JButton();
        password = new javax.swing.JPasswordField();
        jLabel11 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle(": : User Registration : :");
        setResizable(false);

        jLabel1.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 102));
        jLabel1.setText("User Registration Form");

        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/48/User.png"))); // NOI18N

        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        userId.setBackground(new java.awt.Color(255, 255, 225));
        userId.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        userId.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        userId.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                userIdKeyPressed(evt);
            }
        });

        userName.setBackground(new java.awt.Color(255, 255, 225));
        userName.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        userName.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        userName.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                userNameKeyPressed(evt);
            }
        });

        Address.setBackground(new java.awt.Color(255, 255, 225));
        Address.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        Address.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        Address.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                AddressKeyPressed(evt);
            }
        });

        phoneNo.setBackground(new java.awt.Color(255, 255, 225));
        phoneNo.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        phoneNo.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        phoneNo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                phoneNoActionPerformed(evt);
            }
        });
        phoneNo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                phoneNoKeyPressed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 0, 255));
        jLabel2.setText("User ID :");

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 51, 255));
        jLabel3.setText("Name :");

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(0, 0, 255));
        jLabel4.setText("Password :");

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(0, 0, 255));
        jLabel6.setText("Address :");

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(0, 0, 255));
        jLabel5.setText("Phone no :");

        reset.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        reset.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/32/refresh.png"))); // NOI18N
        reset.setText("Reset");
        reset.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                resetActionPerformed(evt);
            }
        });
        reset.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                resetKeyPressed(evt);
            }
        });

        cancel.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        cancel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/32/button_cancel.png"))); // NOI18N
        cancel.setText("cancel");
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

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(0, 0, 255));
        jLabel9.setText("user type:");

        userType.setBackground(new java.awt.Color(255, 255, 225));
        userType.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Clerk", "Incharge" }));
        userType.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                userTypeKeyPressed(evt);
            }
        });

        submit.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        submit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/32/checkin.png"))); // NOI18N
        submit.setText("submit");
        submit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                submitActionPerformed(evt);
            }
        });
        submit.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                submitKeyPressed(evt);
            }
        });

        password.setBackground(new java.awt.Color(255, 255, 225));
        password.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        password.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                passwordActionPerformed(evt);
            }
        });
        password.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                passwordKeyPressed(evt);
            }
        });

        jLabel11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/24/refresh.png"))); // NOI18N
        jLabel11.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel11.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel11MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jSeparator1)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel3)
                                        .addComponent(jLabel2)
                                        .addComponent(jLabel4))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel9)
                                        .addGap(5, 5, 5)))
                                .addGap(35, 35, 35)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(userName, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(userType, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(password)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(userId, javax.swing.GroupLayout.PREFERRED_SIZE, 238, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jLabel11))))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel6)
                                    .addComponent(jLabel5))
                                .addGap(35, 35, 35)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(Address)
                                    .addComponent(phoneNo)))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(submit)
                                .addGap(18, 18, 18)
                                .addComponent(reset, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(cancel)))
                        .addContainerGap())))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(userId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel11))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(userName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(password, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(userType, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Address, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(phoneNo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(submit, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(reset, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cancel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel8)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel1)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel8)
                    .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING))
                .addGap(18, 18, 18)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void phoneNoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_phoneNoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_phoneNoActionPerformed

    private void resetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_resetActionPerformed

        resetItems();
        // TODO add your handling code here:
    }//GEN-LAST:event_resetActionPerformed

    private void cancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelActionPerformed

        this.dispose();// TODO add your handling code here:
    }//GEN-LAST:event_cancelActionPerformed

    private void submitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_submitActionPerformed

        submit();// TODO add your handling code here:
    }//GEN-LAST:event_submitActionPerformed

    private void passwordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_passwordActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_passwordActionPerformed

    private void jLabel11MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel11MouseClicked

        refreshID();// TODO add your handling code here:
    }//GEN-LAST:event_jLabel11MouseClicked

    private void userIdKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_userIdKeyPressed

        int key = evt.getKeyCode();
        if (key == KeyEvent.VK_ENTER) {   
        userName.requestFocus();// TODO add your handling code here:
        }else{
        keyAction(evt,"submit");
        }
    }//GEN-LAST:event_userIdKeyPressed

    private void userNameKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_userNameKeyPressed

        int key = evt.getKeyCode();
        if (key == KeyEvent.VK_ENTER) {   
        password.requestFocus();// TODO add your handling code here:
        }else{
        keyAction(evt,"submit");
        }
    }//GEN-LAST:event_userNameKeyPressed

    private void passwordKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_passwordKeyPressed
        int key = evt.getKeyCode();
        if (key == KeyEvent.VK_ENTER) {   
        userType.requestFocus();
        }else{
        keyAction(evt,"submit");
        }
        // TODO add your handling code here:
    }//GEN-LAST:event_passwordKeyPressed

    private void userTypeKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_userTypeKeyPressed
            int key = evt.getKeyCode();
        if (key == KeyEvent.VK_ENTER) {   
        Address.requestFocus();
        }else{
        keyAction(evt,"submit");
        }
        // TODO add your handling code here:
    }//GEN-LAST:event_userTypeKeyPressed

    private void AddressKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_AddressKeyPressed
    int key = evt.getKeyCode();
        if (key == KeyEvent.VK_ENTER) {   
        phoneNo.requestFocus();
        }else{
        keyAction(evt,"submit");
        }
        // TODO add your handling code here:
    }//GEN-LAST:event_AddressKeyPressed

    private void phoneNoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_phoneNoKeyPressed
        int key = evt.getKeyCode();
        if (key == KeyEvent.VK_ENTER) {   
        
        submit.requestFocus();
        }else{
        keyAction(evt,"submit");
        }
        // TODO add your handling code here:
    }//GEN-LAST:event_phoneNoKeyPressed

    private void submitKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_submitKeyPressed

        keyAction(evt,"submit");
        // TODO add your handling code here:
    }//GEN-LAST:event_submitKeyPressed

    private void resetKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_resetKeyPressed

        keyAction(evt,"reset");// TODO add your handling code here:
    }//GEN-LAST:event_resetKeyPressed

    private void cancelKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_cancelKeyPressed
    keyAction(evt,"cancel");// TODO add your handling code here    
    }//GEN-LAST:event_cancelKeyPressed
    
    void getPrevious(){
    this.userId.setText(User.usr.id);
    this.userName.setText(User.usr.name);
    this.password.setText(User.usr.password);
        this.userType.setSelectedItem(User.usr.usrType);
        this.Address.setText(User.usr.address);
        this.phoneNo.setText(User.usr.phone);
        
    }
    
    boolean putUserInfo(){
    if(Validation.val.validateUserInfo(this.userId.getText(),this.userName.getText(),this.password.getText(),this.userType.getSelectedItem().toString(),this.Address.getText(),this.phoneNo.getText()) == true){            
        //if(Validation.val.validateStudentInfo(this.rollNo.getText(),this.fullName.getText(),this.Branch.getSelectedItem().toString(),this.year1.getSelectedItem().toString(),this.phonNo.getText(),this.addrss.getText(),this.macAdd1.getText(),this.macAdd2.getText()) == true){            
        User.usr.id = this.userId.getText();
        User.usr.name = this.userName.getText();
        User.usr.password = this.password.getText();
        User.usr.usrType = this.userType.getSelectedItem().toString();
        User.usr.phone = this.phoneNo.getText();
        User.usr.address = this.Address.getText();
        //User.usr.status = this.statusGroup.getSelection().isSelected();
        return true;
        }
    else 
        return false;
    }
    void resetItems(){
        //enableItems();        
        this.userId.setText("");
        this.userName.setText("");
        this.userType.setSelectedIndex(0);
        this.password.setText("");
        this.Address.setText("");
        this.phoneNo.setText("");
    }
  
    private void submit(){
        if(putUserInfo()){
          if(action.equalsIgnoreCase("edit")){
              UserDetails usrConfirm = new UserDetails("edit");
             usrConfirm.setVisible(true);
          }
          if(action.equalsIgnoreCase("delete")){
              UserDetails usrConfirm = new UserDetails("delete");
              usrConfirm.setVisible(true);
          }
          else if(action.equalsIgnoreCase("")){
        UserDetails usrConfirm = new UserDetails(1);
        usrConfirm.setVisible(true);
      }
               this.dispose();
    }
        
    }
    void keyAction(java.awt.event.KeyEvent evt, String Button) {
        int key = evt.getKeyCode();
        if (key == KeyEvent.VK_ENTER) {
            if (Button.equalsIgnoreCase("cancel")) {
                int i=DialogBox.dialog.confirmDialog("All the details will get lost.. Do you want to cancel ??");
             if(i==0)
             {
                 this.dispose();
             }
             else if(i==1){}
             else if(i==2){}
            } 
            else if (Button.equalsIgnoreCase("submit")) {
                submit();
            }
            else if (Button.equalsIgnoreCase("reset")) {
                resetItems();
            }
            else{
            submit();
            }
        }
        if (key == KeyEvent.VK_ESCAPE) {    
             int i=DialogBox.dialog.confirmDialog("All the details will get lost.. Do you want to cancel ??");
             if(i==0)
             {
                 this.dispose();
             }
             else if(i==1){}
             else if(i==2){}
            }
    }
    /**
     * @param args the command line arguments
     */
  
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField Address;
    private javax.swing.JButton cancel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JPasswordField password;
    private javax.swing.JTextField phoneNo;
    private javax.swing.JButton reset;
    private javax.swing.ButtonGroup statusGroup;
    private javax.swing.JButton submit;
    private javax.swing.JTextField userId;
    private javax.swing.JTextField userName;
    private javax.swing.JComboBox userType;
    // End of variables declaration//GEN-END:variables
}
