/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * BlacklistDetailsForm.java
 *
 * Created on Jan 23, 2012, 8:39:58 PM
 */
package test;

import java.awt.event.KeyEvent;
import javax.swing.ImageIcon;

/**
 *
 * @author Administrator
 */
public class BlacklistDetails extends javax.swing.JFrame {

    /**
     * Creates new form BlacklistDetailsForm
     */
    private String ActionType = "";

    /**
     * Creates new form FacultyDetailsForm
     */
    public BlacklistDetails(String type) {
        initComponents();
        setLocationRelativeTo(null);
        displayBlacklistInfo();
        ActionType = type;

        if (type.equalsIgnoreCase("Edit")) {
            jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Are You sure You want to edit/delete this Blacklisted person?", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 12), new java.awt.Color(255, 0, 0)));
        }
    }

    public BlacklistDetails(int i) {
        initComponents();
        setLocationRelativeTo(null);
        displayBlacklistInfo();
        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Is the above information correct?", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 12), new java.awt.Color(255, 0, 0)));

    }

    private void displayBlacklistInfo() {

        long tempduration = 0;
        if (Blacklist.blk.durationtype.equalsIgnoreCase("days")) {
            tempduration = Blacklist.blk.duration / (24 * 60 * 60 * 1000);
        } else if (Blacklist.blk.durationtype.equalsIgnoreCase("hours")) {
            tempduration = Blacklist.blk.duration / (60 * 60 * 1000);
        } else if (Blacklist.blk.durationtype.equalsIgnoreCase("month")) {
            tempduration = Blacklist.blk.duration / (60 * 60 * 1000);
        } else if (Blacklist.blk.durationtype.equalsIgnoreCase("week")) {
            tempduration = Blacklist.blk.duration / (7 * 24 * 60 * 60 * 1000);
        }

        this.id.setText(Blacklist.blk.id);
        this.duration.setText(((Long) tempduration).toString());
        this.addedBy.setText(Blacklist.blk.addedby);
        this.blackReason.setText(Blacklist.blk.reason);
        this.blackListedTime.setText(Blacklist.blk.blktimestamp);
        this.durationType.setText(Blacklist.blk.durationtype);
        if (Blacklist.blk.image != null) {
            ImageIcon thumbnailIcon = new ImageIcon(Utilities.util.rescaleImage(Blacklist.blk.image, this.photoPanel.getWidth(), this.photoPanel.getHeight()));
            this.pic.setIcon(thumbnailIcon);
        }
    }

    public BlacklistDetails(String rollNo, String name, String type) {

        if (Blacklist.blk.setBlacklistInfo(rollNo, name) == true) {
            initComponents();
            setLocationRelativeTo(null);
            displayBlacklistInfo();
            ActionType = type;
            if (type.equalsIgnoreCase("submit")) {
                jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Is the above information correct?", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 12), new java.awt.Color(255, 0, 0)));
            }

            if (type.equalsIgnoreCase("edit/delete")) {
                jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Are You sure You want to edit/delete this Blacklisted person?", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 12), new java.awt.Color(255, 0, 0)));
                save.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/32/edit.png")));
                back.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/32/delete.png")));
                this.save.setText("Edit");
                this.back.setText("Delete");
            }
            if (type.equalsIgnoreCase("view")) {
                jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 12), new java.awt.Color(255, 0, 0)));
                this.save.setText("Ok");
                save.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/32/ok.png")));
                back.hide();
                //back.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/32/print.png")));
                //this.back.setText("Print");
            } 
            else {
                this.dispose();
            }
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

        jComboBox1 = new javax.swing.JComboBox();
        jPanel1 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        blackReason = new javax.swing.JTextArea();
        id = new javax.swing.JLabel();
        duration = new javax.swing.JLabel();
        durationType = new javax.swing.JLabel();
        addedBy = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        save = new javax.swing.JButton();
        cancel = new javax.swing.JButton();
        back = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel1 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        blackListedTime = new javax.swing.JLabel();
        photoPanel = new javax.swing.JPanel();
        pic = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle(": : Blacklisting Details : :");
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                windowClosed(evt);
            }
        });

        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(0, 0, 255));
        jLabel4.setText("Added by:");

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(0, 0, 255));
        jLabel5.setText("Reason:");

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 0, 255));
        jLabel2.setText("ID:");

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 0, 255));
        jLabel3.setText("Duration:");

        blackReason.setBackground(new java.awt.Color(244, 247, 252));
        blackReason.setColumns(20);
        blackReason.setEditable(false);
        blackReason.setRows(5);
        jScrollPane1.setViewportView(blackReason);

        id.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        id.setForeground(new java.awt.Color(0, 0, 51));
        id.setText("ID:");

        duration.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        duration.setForeground(new java.awt.Color(0, 0, 51));
        duration.setText("Duration");

        durationType.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        durationType.setForeground(new java.awt.Color(0, 0, 51));
        durationType.setText("Duration Type");

        addedBy.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        addedBy.setForeground(new java.awt.Color(0, 0, 51));
        addedBy.setText("Added By");

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Do you want to add this student in black list??", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 1, 14), new java.awt.Color(255, 0, 51))); // NOI18N
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        save.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        save.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/32/apply.png"))); // NOI18N
        save.setText("Save");
        save.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveActionPerformed(evt);
            }
        });
        save.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                keysubmit(evt);
            }
        });
        jPanel2.add(save, new org.netbeans.lib.awtextra.AbsoluteConstraints(16, 30, 103, -1));

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
                keyCancel(evt);
            }
        });
        jPanel2.add(cancel, new org.netbeans.lib.awtextra.AbsoluteConstraints(253, 30, -1, -1));

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
        jPanel2.add(back, new org.netbeans.lib.awtextra.AbsoluteConstraints(137, 30, -1, -1));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSeparator1)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addComponent(id, javax.swing.GroupLayout.DEFAULT_SIZE, 114, Short.MAX_VALUE)
                                .addGap(141, 141, 141))
                            .addComponent(addedBy, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(duration, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(durationType, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 237, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(id))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(duration)
                    .addComponent(durationType))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(addedBy))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel1.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 102));
        jLabel1.setText("Black Listing Detail");

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel6.setText("Black Listed At:");

        blackListedTime.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        blackListedTime.setText("jLabel7");

        photoPanel.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        javax.swing.GroupLayout photoPanelLayout = new javax.swing.GroupLayout(photoPanel);
        photoPanel.setLayout(photoPanelLayout);
        photoPanelLayout.setHorizontalGroup(
            photoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pic, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        photoPanelLayout.setVerticalGroup(
            photoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pic, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 160, Short.MAX_VALUE)
        );

        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/64/Blacklist.png"))); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel8)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel1)
                        .addGap(246, 246, 246))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(photoPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel6)
                            .addComponent(blackListedTime, javax.swing.GroupLayout.DEFAULT_SIZE, 146, Short.MAX_VALUE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel8)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(jLabel1)))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(photoPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(blackListedTime, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    
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
    private void saveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveActionPerformed
        submit();
        // TODO add your handling code here:
}//GEN-LAST:event_saveActionPerformed

    private void cancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelActionPerformed
        cancel();

}//GEN-LAST:event_cancelActionPerformed

    private void windowClosed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_windowClosed
        this.dispose();
        // TODO add your handling code here:
    }//GEN-LAST:event_windowClosed

    private void backActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backActionPerformed

        back();// TODO add your handling code here:
    }//GEN-LAST:event_backActionPerformed

    private void keysubmit(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_keysubmit
        keyAction(evt,"submit");
    }//GEN-LAST:event_keysubmit

    private void keyBack(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_keyBack
        keyAction(evt,"back");
    }//GEN-LAST:event_keyBack

    private void keyCancel(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_keyCancel
        keyAction(evt,"cancel");
    }//GEN-LAST:event_keyCancel

    void submit() {

        if (this.ActionType.equalsIgnoreCase("")) {
            try {
                if (Blacklist.blk.ifBlacklistExists(Blacklist.blk.id, "")) {
                    DialogBox.dialog.successDialog("person with id= " + Blacklist.blk.id + " is already blacklisted");
                    BlacklistDetailsForm blkreg = new BlacklistDetailsForm();
                    blkreg.getPrevious();
                    blkreg.setVisible(true);
                   } else if ((AbstractPerson.ab.getAllRecord(Blacklist.blk.id))!=null) {
                    if (Blacklist.blk.addBlacklist() == true) {
                        if ((AbstractPerson.ab.getCurrenttableResult(Blacklist.blk.id) != null)) {
                            if(AbstractPerson.ab.checkOut(Blacklist.blk.id) == true){
                                DialogBox.dialog.successDialog("Successfully checked out !!!");
                            }
                            else{
                                DialogBox.dialog.errorDialog("Error in checkout !!!");
                            }
                        }
                        DialogBox.dialog.successDialog("Blacklist Record Sucessfully added");
                        BlacklistDetailsForm blkreg = new BlacklistDetailsForm();
                        blkreg.setVisible(true);
                     }
                } else {
                    DialogBox.dialog.errorDialog("person with id= " + Blacklist.blk.id + " doesn't exist");
                    BlacklistDetailsForm blkreg = new BlacklistDetailsForm();
                    blkreg.getPrevious();
                    blkreg.setVisible(true);
                   }
            } catch (Exception e) {
                if (Log.log.displayDialog == true) {
                    DialogBox.dialog.warningDialog(e.getMessage());
                } else {
                    Log.log.writeErrorLog(e.getMessage(), "BlacklistDetails", "logn");
                }
            }
            }
                        
     
         else if (this.ActionType.equalsIgnoreCase("edit")) {


            if (Blacklist.blk.editBlacklist() == true) {
                DialogBox.dialog.successDialog("Blacklisted person's record SucessFully Edited!!!");// TODO add your handling code here:
                EnterRoll er = new EnterRoll("edit/delete", "blacklist");
                er.setVisible(true);
               }

        }

        if (save.getText().equalsIgnoreCase("edit")) {
            BlacklistDetailsForm blkreg = new BlacklistDetailsForm("edit");
            blkreg.getPrevious();
            blkreg.setVisible(true);
        }

        if (save.getText().equalsIgnoreCase("ok")) {
            EnterRoll er = new EnterRoll("view", "blacklist");
            er.setVisible(true);
        }

        this.dispose();
    }

    void back() {
        if (back.getText().equalsIgnoreCase("delete")) {

            int i = DialogBox.dialog.confirmDialog("Are you sure you want to remove person with " + Blacklist.blk.id + " from blacklisted people?");
            if (i == 0) {
                if (AbstractPerson.ab.blackRemoval(Blacklist.blk.id)) {
                    DialogBox.dialog.successDialog(" record SucessFully Deleted!!!");// TODO add your handling code here:
                } else {
                    DialogBox.dialog.errorDialog("Error in removing the person from blacklist");
                }

            }
            EnterRoll er = new EnterRoll("edit/delete", "blacklist");
            er.setVisible(true);
        } else if (back.getText().equalsIgnoreCase("print")) {
        } else {
            if (ActionType.equalsIgnoreCase("")) {
                BlacklistDetailsForm blkreg = new BlacklistDetailsForm();
                blkreg.getPrevious();
                blkreg.setVisible(true);// TODO add your handling code here:
            } else {
                BlacklistDetailsForm blkreg = new BlacklistDetailsForm("edit");
                blkreg.getPrevious();
                blkreg.setVisible(true);// TODO add your handling code here:
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
    private javax.swing.JLabel addedBy;
    private javax.swing.JButton back;
    private javax.swing.JLabel blackListedTime;
    private javax.swing.JTextArea blackReason;
    private javax.swing.JButton cancel;
    private javax.swing.JLabel duration;
    private javax.swing.JLabel durationType;
    private javax.swing.JLabel id;
    private javax.swing.JComboBox jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JPanel photoPanel;
    private javax.swing.JLabel pic;
    private javax.swing.JButton save;
    // End of variables declaration//GEN-END:variables
}
