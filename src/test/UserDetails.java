/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import java.awt.event.KeyEvent;
import java.sql.ResultSet;

/**
 *
 * @author Achyut
 */
public class UserDetails extends javax.swing.JFrame {

    private String ActionType = "";

    /**
     * Creates new form UserConfimForm
     */
    public UserDetails() {
        initComponents();
        setLocationRelativeTo(null);
    }

    public UserDetails(String type) {
        initComponents();
        setLocationRelativeTo(null);
        displayUserInfo();
        ActionType = type;
        if (type.equalsIgnoreCase("Edit")) {
            jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Are You sure You want to edit this student?", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 12), new java.awt.Color(255, 0, 0)));
        }
    }

    public UserDetails(int i) {
        initComponents();
        setLocationRelativeTo(null);
        displayUserInfo();//System.out.print("add");
        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Is the above information correct?", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 12), new java.awt.Color(255, 0, 0)));

    }

    private void displayUserInfo() {
        this.usrId.setText(User.usr.id);
        this.userName.setText(User.usr.name);
        this.password.setText(User.usr.password);
        this.userType.setText(User.usr.usrType);
        this.Address.setText(User.usr.address);
        this.phone.setText(User.usr.phone);
        this.status.setText("Status: " + User.usr.status);
    }

    public UserDetails(String id, String name, String type) {
        if (User.usr.setUserInfo(id, name) == true) {
            initComponents();
            setLocationRelativeTo(null);
            displayUserInfo();
            ActionType = type;
            if (type.equalsIgnoreCase("submit")) {
                jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Are the above information correct?", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 12), new java.awt.Color(255, 0, 0)));
            }

            if (type.equalsIgnoreCase("edit/delete")) {
                save.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/32/edit.png")));
                back.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/32/delete.png")));
                this.save.setText("edit");
                this.back.setText("delete");
            }
            if (type.equalsIgnoreCase("view")) {
                save.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/32/Ok.png")));
                this.save.setText("Ok");
                this.back.hide();
            }
            if (type.equalsIgnoreCase("print")) {
                save.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/32/print.png")));
                this.save.setText("Print");
                this.back.hide();
            }
                        
            if (type.equalsIgnoreCase("resetpass")) {
                save.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/32/change_pass.png")));
                this.save.setText("Reset");
                this.back.hide();
            }

            else {
                this.dispose();
            }
    }
  }
    
    void submit()
    {
        ResultSet temp=null;

              if(this.ActionType.equalsIgnoreCase("")){
                     try{
                  if(User.usr.ifUserExists(User.usr.id, ""))
                  { DialogBox.dialog.successDialog("User with "+User.usr.id+" already exists");
                  UserDetailsForm streg=new UserDetailsForm();
               streg.getPrevious();
               streg.setVisible(true);
                  }   
                
                  
                else  if((temp=AbstractPerson.ab.getRecordFromQuery("SELECT * FROM login WHERE name='"+User.usr.name+"' AND password='"+Utilities.util.md5(User.usr.password)+"'"))!=null){
                  DialogBox.dialog.errorDialog("A User with same username  and password already exists!!");
                  UserDetailsForm streg=new UserDetailsForm();
                    streg.getPrevious();
                    streg.setVisible(true);
            
                }              
                else  if(User.usr.addUser()==true){
                  DialogBox.dialog.successDialog("User Record Sucessfully added");
               UserDetailsForm streg=new UserDetailsForm();
               streg.resetItems();
               streg.setVisible(true);
                   }
           }
            catch(Exception e){DialogBox.dialog.errorDialog(e.getMessage());  }
              }
     
          else if(this.ActionType.equalsIgnoreCase("edit")){
                 if(User.usr.editUser() == true){
                    DialogBox.dialog.successDialog("User record SucessFully Edited!!!");// TODO add your handling code here:
                    EnterRoll er=new EnterRoll("edit/delete","user");
                    er.setVisible(true);
                  } 
          }
            else if (this.ActionType.equalsIgnoreCase("resetpass")) {
            PasswordResetBox pr = new PasswordResetBox(User.usr.id,"user");
            pr.setVisible(true);
        }

       
        if(save.getText().equalsIgnoreCase("edit")){
        UserDetailsForm std = new UserDetailsForm("edit");
        std.getPrevious();
        std.setVisible(true);
        }
        if(save.getText().equalsIgnoreCase("print")){
        Report rep = new Report();
        rep.printUserInfo(User.usr.id);
        }
        /*else if(save.getText().equalsIgnoreCase("ok"))
            {
               
                EnterRoll er=new EnterRoll("view","user");
                 er.setVisible(true);
           }
        */
        this.dispose();
    }
    
    
    void back()
    {
        if(back.getText().equalsIgnoreCase("delete")){
         
             int i=DialogBox.dialog.confirmDialog("Are you sure you want to delete info of "+ User.usr.id +" ?");
             if(i==0)
             {if(User.usr.deleteUser() == true){
                 DialogBox.dialog.successDialog("User SucessFully Deleted!!!");// TODO add your handling code here:
             }
             else {
                    DialogBox.dialog.errorDialog("Error in Deleting user information");
                }
             }
                 EnterRoll er=new EnterRoll("edit/delete","user");
                 er.setVisible(true);
             
           
       }
        else if(back.getText().equalsIgnoreCase("print"))
        {
            Report report=new Report();
            report.printUserInfo(User.usr.id);
        }
         else{
          if(ActionType.equalsIgnoreCase("")){
        UserDetailsForm reg=new UserDetailsForm();
        reg.getPrevious();
        reg.setVisible(true);
          }
          else{
        UserDetailsForm reg=new UserDetailsForm("edit");
        reg.getPrevious();
        reg.setVisible(true);// TODO add your handling code here:
        }
      }
           this.dispose();
             
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
        jLabel1 = new javax.swing.JLabel();
        usrId = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        userName = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        password = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        userType = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        Address = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        phone = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        status = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        cancel = new javax.swing.JButton();
        save = new javax.swing.JButton();
        back = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle(": : User Details : :");
        setResizable(false);

        jPanel1.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 2, true));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setText("User ID:");

        usrId.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        usrId.setForeground(new java.awt.Color(51, 51, 255));
        usrId.setText("ID");

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel2.setText("Username:");

        userName.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        userName.setForeground(new java.awt.Color(51, 51, 255));
        userName.setText("Username");

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel3.setText("Password:");

        password.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        password.setForeground(new java.awt.Color(51, 51, 255));
        password.setText("password");

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel4.setText("User Type:");

        userType.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        userType.setForeground(new java.awt.Color(51, 51, 255));
        userType.setText("User type");

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel5.setText("Address:");

        Address.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        Address.setForeground(new java.awt.Color(51, 51, 255));
        Address.setText("Address");

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel6.setText("Phone No:");

        phone.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        phone.setForeground(new java.awt.Color(51, 51, 255));
        phone.setText("Phone");

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Current Status", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 0, 14))); // NOI18N

        status.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        status.setText("Status");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(status, javax.swing.GroupLayout.DEFAULT_SIZE, 70, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(status)
                .addContainerGap(17, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addGap(18, 18, 18)
                        .addComponent(phone, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addGap(18, 18, 18)
                        .addComponent(password, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(usrId, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(userName, javax.swing.GroupLayout.DEFAULT_SIZE, 241, Short.MAX_VALUE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(userType, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(Address, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addGap(243, 243, 243)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(44, 44, 44))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(usrId, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(userName, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(password, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(userType, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(Address, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(phone, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(0, 0, 102));
        jLabel7.setText("User Membership Information");

        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/64/user.png"))); // NOI18N

        jPanel3.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 2, true));

        cancel.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        cancel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/32/button_cancel.png"))); // NOI18N
        cancel.setText("Cancel");
        cancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelActionPerformed(evt);
            }
        });
        cancel.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                keyCancel(evt);
            }
        });

        save.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        save.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/32/add.PNG"))); // NOI18N
        save.setText("Save");
        save.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveActionPerformed(evt);
            }
        });
        save.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                keySubmit(evt);
            }
        });

        back.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        back.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/32/back.png"))); // NOI18N
        back.setText("Back");
        back.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backActionPerformed(evt);
            }
        });
        back.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                keyBack(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(save, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(62, 62, 62)
                .addComponent(back, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(cancel, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(save)
                    .addComponent(back)
                    .addComponent(cancel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel8)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel7))
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel8, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel7)
                        .addGap(12, 12, 12)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void backActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backActionPerformed

        back();
        // TODO add your handling code here:
    }//GEN-LAST:event_backActionPerformed

    private void saveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveActionPerformed

        submit();
        // TODO add your handling code here:
    }//GEN-LAST:event_saveActionPerformed

    private void cancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelActionPerformed

        this.dispose();
        // TODO add your handling code here:
    }//GEN-LAST:event_cancelActionPerformed

    private void keySubmit(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_keySubmit
       keyAction(evt,"submit");
    }//GEN-LAST:event_keySubmit

    private void keyBack(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_keyBack
     keyAction(evt,"back");
    }//GEN-LAST:event_keyBack
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
            else if (Button.equalsIgnoreCase("back")) {
                back();
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
    private void keyCancel(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_keyCancel
        keyAction(evt,"cancel");
    }//GEN-LAST:event_keyCancel

    /**
     * @param args the command line arguments
     */
   
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Address;
    private javax.swing.JButton back;
    private javax.swing.JButton cancel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JLabel password;
    private javax.swing.JLabel phone;
    private javax.swing.JButton save;
    private javax.swing.JLabel status;
    private javax.swing.JLabel userName;
    private javax.swing.JLabel userType;
    private javax.swing.JLabel usrId;
    // End of variables declaration//GEN-END:variables
}
