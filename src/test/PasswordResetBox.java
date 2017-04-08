/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import java.awt.event.KeyEvent;

/**
 *
 * @author Achyut
 */
public class PasswordResetBox extends javax.swing.JFrame {
    String tempId = "",tempType = "";
    /**
     * Creates new form PasswordResetBox
     */
    public PasswordResetBox(String id,String type) {
        initComponents();
        tempId = id;
        tempType = type;
        this.id.setText(id);
        this.pass1.setText(id);
        this.pass2.setText(id);
        
    }
    public PasswordResetBox() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel7 = new javax.swing.JPanel();
        lblid = new javax.swing.JLabel();
        lblname = new javax.swing.JLabel();
        jSeparator4 = new javax.swing.JSeparator();
        submitButton = new javax.swing.JButton();
        pass2 = new javax.swing.JPasswordField();
        pass1 = new javax.swing.JPasswordField();
        lblid1 = new javax.swing.JLabel();
        id = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setTitle(": : Reset Password : :");
        setAlwaysOnTop(true);
        setResizable(false);

        jPanel7.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 2, true), "Reset Password", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 14), new java.awt.Color(102, 0, 0))); // NOI18N

        lblid.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        lblid.setText("New Password:");

        lblname.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        lblname.setText("Confirm Password:");

        submitButton.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        submitButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/32/checkin.png"))); // NOI18N
        submitButton.setText("Submit");
        submitButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                submitButtonActionPerformed(evt);
            }
        });
        submitButton.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                submitButtonkeySubmit(evt);
            }
        });

        pass2.setBackground(new java.awt.Color(255, 255, 225));
        pass2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        pass2.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        pass2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pass2ActionPerformed(evt);
            }
        });

        pass1.setBackground(new java.awt.Color(255, 255, 225));
        pass1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        pass1.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        pass1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                pass1KeyPressed(evt);
            }
        });

        lblid1.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        lblid1.setText("ID:");

        id.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        id.setText("ID");

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                        .addComponent(jSeparator4)
                        .addContainerGap())
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblname)
                            .addComponent(lblid))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel7Layout.createSequentialGroup()
                                .addComponent(id)
                                .addContainerGap())
                            .addGroup(jPanel7Layout.createSequentialGroup()
                                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(pass1, javax.swing.GroupLayout.DEFAULT_SIZE, 193, Short.MAX_VALUE)
                                    .addComponent(pass2))
                                .addGap(19, 19, 19))))))
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addGap(102, 102, 102)
                        .addComponent(submitButton, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(lblid1, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblid1)
                    .addComponent(id))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblid)
                    .addComponent(pass1, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblname)
                    .addComponent(pass2, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator4, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(4, 4, 4)
                .addComponent(submitButton, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void submitButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_submitButtonActionPerformed
        submit();
        
        // TODO add your handling code here:
    }//GEN-LAST:event_submitButtonActionPerformed

    private void submitButtonkeySubmit(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_submitButtonkeySubmit
        int key = evt.getKeyCode();
        if (key == KeyEvent.VK_ENTER) {
            submit();            
        }        // TODO add your handling code here: // TODO add your handling code here:
    }//GEN-LAST:event_submitButtonkeySubmit

    private void pass2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pass2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_pass2ActionPerformed

    private void pass1KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_pass1KeyPressed
         int key = evt.getKeyCode();
        if (key == KeyEvent.VK_ENTER) {   
        pass2.requestFocus();
        }
        // TODO add your handling code here:
    }//GEN-LAST:event_pass1KeyPressed
    void submit() {
        if ((Validation.val.validatePassword(this.pass1.getText(), "password") && Validation.val.validatePassword(this.pass2.getText(), "Confim password")) == true) {
            
            if (this.pass1.getText().equals(this.pass2.getText())) {
                
            if(tempId!=null){
                 if(tempType.equalsIgnoreCase("student")){
                    if(DatabaseMain.db.executeQuery("UPDATE student SET password='"+Utilities.util.md5(this.pass1.getText())+ "' WHERE studentid='" + tempId + "'") == true){
                    DialogBox.dialog.successDialog("New password sucessfully created!!!");
                    this.dispose();
                    }
                    else{
                    DialogBox.dialog.errorDialog("OOPS!!! Cannot change password");
                    }
                 }
                 else if(tempType.equalsIgnoreCase("faculty")){
                     if(DatabaseMain.db.executeQuery("UPDATE faculty SET password='"+Utilities.util.md5(this.pass1.getText())+ "' WHERE facultyid='" + tempId + "'") == true){
                    DialogBox.dialog.successDialog("New password sucessfully created!!!");
                    this.dispose();
                    }
                    else{
                    DialogBox.dialog.errorDialog("OOPS!!! Cannot chagne password");
                    }
                 }
                 else if(tempType.equalsIgnoreCase("guest")){
                     if(DatabaseMain.db.executeQuery("UPDATE guest SET password='"+Utilities.util.md5(this.pass1.getText())+ "' WHERE guestid='" + tempId + "'") == true){
                    DialogBox.dialog.successDialog("New password sucessfully created!!!");
                    this.dispose();
                    }
                    else{
                    DialogBox.dialog.errorDialog("OOPS!!! Cannot chagne password");
                    }
                 }
                 else if(tempType.equalsIgnoreCase("user")){
                     if(DatabaseMain.db.executeQuery("UPDATE login SET password='"+Utilities.util.md5(this.pass1.getText())+ "' WHERE loginid='" + tempId + "'") == true){
                    DialogBox.dialog.successDialog("New password sucessfully created!!!");
                    this.dispose();
                    }
                    else{
                    DialogBox.dialog.errorDialog("OOPS!!! Cannot chagne password");
                    }
                 }
            }
            else{
                DatabaseMain.db.executeQuery("UPDATE login SET password='"+Utilities.util.md5(this.pass1.getText())+ "',noofattempt='0' WHERE loginid='" + Session.s1.userID + "'");
                DialogBox.dialog.successDialog("New password sucessfully created!!!");
                this.dispose();
            }   
            
            } else {
                DialogBox.dialog.errorDialog("Password didnot match!!!");
            }
        } else {
            DialogBox.dialog.errorDialog("Invalid password entered!!!");
        }
    }
    /**
     * @param args the command line arguments
     */
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel id;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JLabel lblid;
    private javax.swing.JLabel lblid1;
    private javax.swing.JLabel lblname;
    private javax.swing.JPasswordField pass1;
    private javax.swing.JPasswordField pass2;
    private javax.swing.JButton submitButton;
    // End of variables declaration//GEN-END:variables
}