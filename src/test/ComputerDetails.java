/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import java.awt.event.KeyEvent;
import java.sql.ResultSet;

/**
 *
 * @author APELY
 */
public class ComputerDetails extends javax.swing.JFrame {

    private String ActionType = "";
            
    public ComputerDetails() {
        initComponents();
        setLocationRelativeTo(null);
    }

    public ComputerDetails(String type){
    initComponents();
    setLocationRelativeTo(null);
        displayComputerInfo();
        ActionType = type;
        if(type.equalsIgnoreCase("Edit")){
        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Are You sure You want to edit this Information?", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 12), new java.awt.Color(255, 0, 0)));
        }
    }
   
    public ComputerDetails(int i)
   {
        initComponents();
        setLocationRelativeTo(null);
        displayComputerInfo();//System.out.print("add");
        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Is the above information correct?", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 12), new java.awt.Color(255, 0, 0)));
        
   }
    private void displayComputerInfo(){
        this.compid.setText(Computer.comp.compid);
        this.macadd.setText(Computer.comp.macadd);
        this.processor.setText(Computer.comp.processor);
        this.labno.setText(Computer.comp.labno);
        this.computertype.setText(Computer.comp.computertype);
        this.harddisk.setText(Computer.comp.harddisk);
        this.ram.setText(Computer.comp.ram);
        this.cd.setText(Computer.comp.cd);
        this.brand.setText(Computer.comp.brand);
    }
    
    public ComputerDetails(String id,String type){
    
        if(Computer.comp.setComputerInfo(id) == true)
        {
        initComponents();
        setLocationRelativeTo(null);
        displayComputerInfo();
        ActionType = type;
            if(type.equalsIgnoreCase("submit")){
            jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Are the above information correct?", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 12), new java.awt.Color(255, 0, 0)));
            }

            if(type.equalsIgnoreCase("edit/delete")){
               this.save.setText("edit");
               this.back.setText("delete");}
            if (type.equalsIgnoreCase("view")) {
                save.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/32/ok.png")));
                this.save.setText("Ok");
                this.back.hide();
            }
            if (type.equalsIgnoreCase("print")) {
                save.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/32/print.png")));
                this.save.setText("Print");
                this.back.hide();
            }
       else{
            this.dispose();
        }
    }
  }
    
    void submit()
    {
        ResultSet temp=null;

              if(this.ActionType.equalsIgnoreCase("")){
                     try{
                  if(Computer.comp.ifComputerExists(Computer.comp.compid))
                  {
                      DialogBox.dialog.successDialog("Computer with id "+Computer.comp.compid+" already exists");
                      ComputerDetailsForm compreg=new ComputerDetailsForm();
                        compreg.getPrevious();
                        compreg.setVisible(true);
                  }         
                else  if(Computer.comp.addComputer()==true){
               DialogBox.dialog.successDialog("Computer Record Sucessfully added");
               ComputerDetailsForm compreg=new ComputerDetailsForm();
               compreg.resetItems();
               compreg.setVisible(true);
                   }
           }
            catch(Exception e){DialogBox.dialog.errorDialog(e.getMessage());  }
              }
     
          else if(this.ActionType.equalsIgnoreCase("edit")){
                 if(Computer.comp.editComputer() == true){
                    DialogBox.dialog.successDialog("Computer record SucessFully Edited!!!");// TODO add your handling code here:
                    EnterComputer er=new EnterComputer("edit/delete");
                    er.setVisible(true);
                  } 
          }
       
              if(save.getText().equalsIgnoreCase("edit")){
         ComputerDetailsForm std = new ComputerDetailsForm("edit");
        std.getPrevious();
        std.setVisible(true);
       
        }

       if(save.getText().equalsIgnoreCase("print")){
         Report rep = new Report();
         rep.ComputerDetails(Computer.comp.compid,false);
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
         
             int i=DialogBox.dialog.confirmDialog("Are you sure you want to delete info of "+ Computer.comp.compid +" ?");
             if(i==0)
             {if(Computer.comp.deleteComputer() == true){
                 DialogBox.dialog.successDialog("Computer record SucessFully Deleted!!!");// TODO add your handling code here:
             }
             else {
                    DialogBox.dialog.errorDialog("Error in Deleting computer's information");
                }
             }
                 EnterComputer er=new EnterComputer("edit/delete");
                 er.setVisible(true);
             
           
       }
        /*else if(back.getText().equalsIgnoreCase("print"))
        {
            Report report=new Report();
           
            try{
                report.makeStudentReport(User.usr.id, User.usr.name);
            }
            catch(Exception e){
                Log.log.writeErrorLog(e.getMessage(), "UserDetails", "back");
            }
        }*/
         else{
          if(ActionType.equalsIgnoreCase("")){
        ComputerDetailsForm compreg=new ComputerDetailsForm();
        compreg.getPrevious();
        compreg.setVisible(true);
          }
          else{
        ComputerDetailsForm reg=new ComputerDetailsForm("edit");
        reg.getPrevious();
        reg.setVisible(true);// TODO add your handling code here:
        }
      }
           this.dispose();
             
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
    void cancel()
    {this.dispose();
    }    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        compid = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        macadd = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        processor = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        labno = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        harddisk = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        ram = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        cd = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        brand = new javax.swing.JLabel();
        computertype = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        save = new javax.swing.JButton();
        back = new javax.swing.JButton();
        cancel = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle(": : Computer Details : :");
        setResizable(false);

        jPanel2.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 2, true));

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel1.setText("Computer id:");

        compid.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        compid.setForeground(new java.awt.Color(0, 0, 204));
        compid.setText("comp1");

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel3.setText("Mac Address:");

        macadd.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        macadd.setForeground(new java.awt.Color(0, 0, 204));
        macadd.setText("ak-22-sa-as-sd-22-ad");

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel5.setText("Processor:");

        processor.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        processor.setForeground(new java.awt.Color(0, 0, 204));
        processor.setText("i-5");

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel7.setText("Lab no:");

        labno.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        labno.setForeground(new java.awt.Color(0, 0, 204));
        labno.setText("1");

        jLabel9.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel9.setText("Hard Disk:");

        harddisk.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        harddisk.setForeground(new java.awt.Color(0, 0, 204));
        harddisk.setText("computer");

        jLabel11.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel11.setText("RAM:");

        ram.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        ram.setForeground(new java.awt.Color(0, 0, 204));
        ram.setText("Bharatpur-14");

        jLabel17.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel17.setText("CD:");

        cd.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        cd.setForeground(new java.awt.Color(0, 0, 204));
        cd.setText("2013");

        jLabel18.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel18.setText("Brand:");

        brand.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        brand.setForeground(new java.awt.Color(0, 0, 204));
        brand.setText("2013");

        computertype.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        computertype.setForeground(new java.awt.Color(0, 0, 204));
        computertype.setText("1");

        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel8.setText("Computer Type:");

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
                    .addComponent(jLabel17)
                    .addComponent(jLabel18)
                    .addComponent(jLabel8))
                .addGap(24, 24, 24)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(ram, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(brand)
                                    .addComponent(macadd)
                                    .addComponent(harddisk)
                                    .addComponent(processor)
                                    .addComponent(labno)
                                    .addComponent(compid)
                                    .addComponent(cd))
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addGap(92, 92, 92))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(computertype, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel9)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel11))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(compid)
                        .addGap(11, 11, 11)
                        .addComponent(macadd)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(labno)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(processor)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(harddisk)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(ram)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel17)
                    .addComponent(cd))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel18)
                    .addComponent(brand))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(computertype)
                    .addComponent(jLabel8))
                .addGap(27, 27, 27))
        );

        jPanel4.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 2, true));

        save.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/32/add.PNG"))); // NOI18N
        save.setText("Save");
        save.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveActionPerformed(evt);
            }
        });
        save.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                savekeySave(evt);
            }
        });

        back.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/32/back.png"))); // NOI18N
        back.setText("Back");
        back.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backActionPerformed(evt);
            }
        });
        back.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                backkeyBack(evt);
            }
        });

        cancel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/32/button_cancel.png"))); // NOI18N
        cancel.setText("Cancel");
        cancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelActionPerformed(evt);
            }
        });
        cancel.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                cancelkeyCancel(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(save, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(42, 42, 42)
                .addComponent(back, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(cancel)
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(save, javax.swing.GroupLayout.DEFAULT_SIZE, 47, Short.MAX_VALUE)
                    .addComponent(cancel, javax.swing.GroupLayout.DEFAULT_SIZE, 47, Short.MAX_VALUE)
                    .addComponent(back, javax.swing.GroupLayout.DEFAULT_SIZE, 47, Short.MAX_VALUE))
                .addContainerGap())
        );

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/48/lab.png"))); // NOI18N
        jLabel2.setText("Computer Information Details");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel2)
                .addGap(60, 60, 60))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addGap(18, 18, 18)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, 281, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void saveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveActionPerformed
        submit();

    }//GEN-LAST:event_saveActionPerformed

    private void savekeySave(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_savekeySave
    keyAction(evt, "submit");
    }//GEN-LAST:event_savekeySave

    private void backActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backActionPerformed
        back();
    }//GEN-LAST:event_backActionPerformed

    private void backkeyBack(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_backkeyBack
       keyAction(evt, "back");
    }//GEN-LAST:event_backkeyBack

    private void cancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelActionPerformed

        cancel();
    }//GEN-LAST:event_cancelActionPerformed

    private void cancelkeyCancel(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_cancelkeyCancel
        keyAction(evt, "cancel");
    }//GEN-LAST:event_cancelkeyCancel

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton back;
    private javax.swing.JLabel brand;
    private javax.swing.JButton cancel;
    private javax.swing.JLabel cd;
    private javax.swing.JLabel compid;
    private javax.swing.JLabel computertype;
    private javax.swing.JLabel harddisk;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JLabel labno;
    private javax.swing.JLabel macadd;
    private javax.swing.JLabel processor;
    private javax.swing.JLabel ram;
    private javax.swing.JButton save;
    // End of variables declaration//GEN-END:variables
}
