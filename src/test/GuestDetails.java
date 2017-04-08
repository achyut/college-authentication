/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import java.awt.event.KeyEvent;
import javax.swing.ImageIcon;

/**
 *
 * @author APELY
 */
public class GuestDetails extends javax.swing.JFrame {

    private String ActionType = "";

    /**
     * Creates new form GuestDtails
     */
    public GuestDetails(String type) {
        initComponents();
        setLocationRelativeTo(null);
        displayGuestInfo();
        ActionType = type;


        if (type.equalsIgnoreCase("Edit")) {
            jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Are You sure You want to edit this guest?", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 12), new java.awt.Color(255, 0, 0)));
        }
    }

    public GuestDetails(int i) {
        initComponents();
        setLocationRelativeTo(null);
        displayGuestInfo();
//       jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Is the above information correct?", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 12), new java.awt.Color(255, 0, 0)))   }
    }
    private void displayGuestInfo() {
        this.name.setText(Guest.gst.name);
        this.id.setText(Guest.gst.id);
        this.phoneno.setText(Guest.gst.phone);
        this.address.setText(Guest.gst.address);
        this.refernce.setText(Guest.gst.reference);
        this.occupation.setText(Guest.gst.occupation);
        this.validUpto.setText(((Integer) Guest.gst.validUpto).toString());
        this.Registeredat.setText(Guest.gst.addtimestamp);
        if (Guest.gst.image != null) {
            ImageIcon thumbnailIcon = new ImageIcon(Utilities.util.rescaleImage(Guest.gst.image,this.photoPanel.getWidth(), this.photoPanel.getHeight()));
            this.photo.setIcon(thumbnailIcon);
        }

    }

    public GuestDetails(String rollNo, String name, String type) {
            ActionType = type;
        if (Guest.gst.setGuestInfo(rollNo, name) == true) {
                initComponents();
                setLocationRelativeTo(null);
                displayGuestInfo();
                if (type.equalsIgnoreCase("submit")) {
                    jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Are the above information correct?", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 12), new java.awt.Color(255, 0, 0)));
                }

                if (type.equalsIgnoreCase("edit/delete")) {
                    save.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/32/edit.png")));
                    this.save.setText("Edit");
                    back.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/32/delete.png")));
                    this.back.setText("Delete");                    
                }
                if (type.equalsIgnoreCase("view")) {
                    //this.save.hide();
                    save.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/32/ok.png")));
                    this.save.setText("Ok");
                    this.back.hide();
                }
                if (type.equalsIgnoreCase("print")) {
                save.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/32/print.png")));
                this.save.setText("Print");
                this.back.hide();
                //this.back.setText("print");Wr
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

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        id = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        name = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        phoneno = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        address = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        occupation = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        refernce = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        validUpto = new javax.swing.JLabel();
        photoPanel = new javax.swing.JPanel();
        photo = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        Registeredat = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        save = new javax.swing.JButton();
        back = new javax.swing.JButton();
        cancel = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle(": : Guest Details : :");
        setResizable(false);

        jPanel2.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 2, true));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setText("Id");

        id.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        id.setForeground(new java.awt.Color(0, 0, 204));
        id.setText("ID");

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel3.setText("Name");

        name.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        name.setForeground(new java.awt.Color(0, 0, 204));
        name.setText("Name");

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel5.setText("Phone no");

        phoneno.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        phoneno.setForeground(new java.awt.Color(0, 0, 204));
        phoneno.setText("Phone");

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel7.setText("Address");

        address.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        address.setForeground(new java.awt.Color(0, 0, 204));
        address.setText("Address");

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel9.setText("Occupation");

        occupation.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        occupation.setForeground(new java.awt.Color(0, 0, 204));
        occupation.setText("Occupation");

        jLabel11.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel11.setText("Reference");

        refernce.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        refernce.setForeground(new java.awt.Color(0, 0, 204));
        refernce.setText("Reference");

        jLabel17.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel17.setText("Valid Upto :");

        validUpto.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        validUpto.setForeground(new java.awt.Color(0, 0, 204));
        validUpto.setText("Valid upto");

        photoPanel.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        javax.swing.GroupLayout photoPanelLayout = new javax.swing.GroupLayout(photoPanel);
        photoPanel.setLayout(photoPanelLayout);
        photoPanelLayout.setHorizontalGroup(
            photoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(photo, javax.swing.GroupLayout.DEFAULT_SIZE, 142, Short.MAX_VALUE)
        );
        photoPanelLayout.setVerticalGroup(
            photoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(photo, javax.swing.GroupLayout.DEFAULT_SIZE, 102, Short.MAX_VALUE)
        );

        jPanel3.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        Registeredat.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        Registeredat.setForeground(new java.awt.Color(0, 0, 204));
        Registeredat.setText("time");
        Registeredat.setAutoscrolls(true);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(Registeredat, javax.swing.GroupLayout.DEFAULT_SIZE, 132, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Registeredat, javax.swing.GroupLayout.DEFAULT_SIZE, 51, Short.MAX_VALUE)
        );

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel4.setText("Registered At:");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addComponent(jLabel1)
                    .addComponent(jLabel7)
                    .addComponent(jLabel5)
                    .addComponent(jLabel9)
                    .addComponent(jLabel11)
                    .addComponent(jLabel17))
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(validUpto, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(refernce, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(occupation, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(0, 4, Short.MAX_VALUE)
                                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(9, 9, 9))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(phoneno, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(address, javax.swing.GroupLayout.DEFAULT_SIZE, 152, Short.MAX_VALUE)
                                    .addComponent(name, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(id, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(photoPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel4)))))))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(id))
                        .addGap(11, 11, 11)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(name))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel7)
                            .addComponent(address))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel9)
                            .addComponent(occupation))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel11)
                            .addComponent(refernce)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(photoPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(4, 4, 4)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(phoneno))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel17)
                    .addComponent(validUpto))
                .addGap(81, 81, 81))
        );

        jPanel4.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 2, true));
        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

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
                keySave(evt);
            }
        });
        jPanel4.add(save, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 13, 117, 47));

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
        jPanel4.add(back, new org.netbeans.lib.awtextra.AbsoluteConstraints(172, 13, 117, 47));

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
        jPanel4.add(cancel, new org.netbeans.lib.awtextra.AbsoluteConstraints(322, 13, 117, 47));

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 0, 102));
        jLabel2.setText("Guest Membership Information");

        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/64/guest.png"))); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                            .addGap(19, 19, 19)
                            .addComponent(jLabel6)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jLabel2))
                        .addGroup(layout.createSequentialGroup()
                            .addContainerGap()
                            .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel6))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(28, 28, 28)
                        .addComponent(jLabel2)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 258, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void saveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveActionPerformed
        submit();

    }//GEN-LAST:event_saveActionPerformed

    private void backActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backActionPerformed
        back();
    }//GEN-LAST:event_backActionPerformed

    private void cancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelActionPerformed

        cancel();
    }//GEN-LAST:event_cancelActionPerformed
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
    private void keySave(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_keySave
     keyAction(evt, "submit");
    }//GEN-LAST:event_keySave

    private void keyBack(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_keyBack
     keyAction(evt, "back");
    }//GEN-LAST:event_keyBack

    private void keyCancel(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_keyCancel
        keyAction(evt, "cancel");
    }//GEN-LAST:event_keyCancel
    void submit() {
        if (this.ActionType.equalsIgnoreCase("")) {

            if (Guest.gst.ifGuestExists(Guest.gst.id, "")) {
                DialogBox.dialog.successDialog("Guest with " + Guest.gst.id + " already exists");
                GuestDetailsForm gstreg = new GuestDetailsForm("back");
                gstreg.getPrevious();
                gstreg.setVisible(true);
            } else if (Guest.gst.addGuest() == true) {

                DialogBox.dialog.successDialog("Guest Record Sucessfully added");
                int choice = DialogBox.dialog.confirmDialog("Do you want to add another guest??");
                if (choice == 0) {
                    GuestDetailsForm gstreg = new GuestDetailsForm();
                    gstreg.setVisible(true);
                } else {
                    this.dispose();
                }
            }

        } else if (this.ActionType.equalsIgnoreCase("edit")) {
            if (Guest.gst.editGuest() == true) {
                DialogBox.dialog.successDialog("Guest record SucessFully Edited!!!");// TODO add your handling code here:
                EnterRoll er = new EnterRoll("edit/delete", "guest");
                er.setVisible(true);
            }
        }
            else if (this.ActionType.equalsIgnoreCase("resetpass")) {
            PasswordResetBox pr = new PasswordResetBox(Guest.gst.id,"guest");
            pr.setVisible(true);
        }

        
        if (save.getText().equalsIgnoreCase("edit")) {
            GuestDetailsForm gstreg = new GuestDetailsForm("edit");
            gstreg.getPrevious();
            gstreg.setVisible(true);
        }
        if (save.getText().equalsIgnoreCase("print")) {
            Report rep = new Report();
            rep.printGuestInfo(Guest.gst.id);
        }
        
        /*
         * if(save.getText().equalsIgnoreCase("ok")) { EnterRoll er=new
         * EnterRoll("view","guest"); er.setVisible(true); }
         */
        this.dispose();

    }

    void back() {
        if (back.getText().equalsIgnoreCase("delete")) {

            int i = DialogBox.dialog.confirmDialog("Are you sure you want to delete info of" + Guest.gst.id + "?");
            if (i == 0) {
                if (Guest.gst.deleteGuest() == true) {
                    DialogBox.dialog.successDialog("guest record SucessFully Deleted!!!");// TODO add your handling code here:
                }//  StudentRegistration.streg.resetItems();
                else {
                    DialogBox.dialog.errorDialog("Error in Deleting guest's information");
                }
            }
            EnterRoll er = new EnterRoll("edit/delete", "guest");
            er.setVisible(true);
        } else if (back.getText().equalsIgnoreCase("print")) {
            Report report = new Report();
            report.printGuestInfo(Guest.gst.id);
        } else {
            if (ActionType.equalsIgnoreCase("")) {
                GuestDetailsForm gstreg = new GuestDetailsForm("back");
                gstreg.getPrevious();
                gstreg.setVisible(true);// TODO add your handling code here:
            } else {
                GuestDetailsForm gstreg = new GuestDetailsForm("edit");
                gstreg.getPrevious();
                gstreg.setVisible(true);// TODO add your handling code here:
            }
        }
        this.dispose();
    }

    void cancel() {
        this.dispose();
    }
    /**
     * @param args the command line arguments
     */
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Registeredat;
    private javax.swing.JLabel address;
    private javax.swing.JButton back;
    private javax.swing.JButton cancel;
    private javax.swing.JLabel id;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JLabel name;
    private javax.swing.JLabel occupation;
    private javax.swing.JLabel phoneno;
    private javax.swing.JLabel photo;
    private javax.swing.JPanel photoPanel;
    private javax.swing.JLabel refernce;
    private javax.swing.JButton save;
    private javax.swing.JLabel validUpto;
    // End of variables declaration//GEN-END:variables
}
