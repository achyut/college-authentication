/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import java.awt.event.KeyEvent;


public class EnterComputer extends javax.swing.JFrame {

    String formType = "";

    /**
     * Creates new form EnterComputer
     */
    public EnterComputer(String formType) {
        this.formType = formType;
        initComponents();
        setLocationRelativeTo(null);
        if (formType.equalsIgnoreCase("compDetails")) {
            compIdlbl.setText("CompID:");
        } else if (formType.equalsIgnoreCase("labDetails")) {
            compIdlbl.setText("LabNo:");
            
        }
        else if(formType.equalsIgnoreCase("edit/delete") || formType.equalsIgnoreCase("view")){
        genPanel.hide();
        }
           this.from.setText(TimeDate.time.timestampToFullDate(System.currentTimeMillis()-(7*24*60*60*1000)));
            this.to.setText(TimeDate.time.timestampToFullDate(System.currentTimeMillis()));
        generateall.setSelected(false);
        /*this.from.disable();
        this.to.disable();
        this.lblfrom.disable();
        this.lblto.disable();
        this.formType = formType;
        */
    }
    
    private void submit() {
        //if(Validation.val)   
         if(formType.equalsIgnoreCase("print")){
           if(this.generateall.isSelected() == true){
               AllComputerDetails acd = new AllComputerDetails();
               acd.setVisible(true);
               }else{
                    if(this.compID.getText().isEmpty()){
                     DialogBox.dialog.errorDialog("Id field cannot be empty");
                    }
                     else if (Computer.comp.ifComputerExists(this.compID.getText()) == true) {
               ComputerDetails cmp=new ComputerDetails(this.compID.getText(),"print");
               cmp.setVisible(true);
           }
           else{
           DialogBox.dialog.errorDialog("Computer with given id cannot be found!!!");
           }
       }
         }
         else if(this.compID.getText().isEmpty()){
        DialogBox.dialog.errorDialog("ID field cannot be empty!!!");
        }
        else if (formType.equalsIgnoreCase("compDetails")) {
        if (Computer.comp.ifComputerExists(this.compID.getText()) == true) {
     
                if (this.generateall.isSelected() == true) {
                    ComputerUsageDetailsReport cd = new ComputerUsageDetailsReport(this.compID.getText(), this.from.getText(), this.to.getText(), true);
                    cd.setVisible(true);
                } else {
                    ComputerUsageDetailsReport cd = new ComputerUsageDetailsReport(this.compID.getText(), this.from.getText(), this.to.getText(), false);
                    cd.setVisible(true);
                }
                
            } else {
            DialogBox.dialog.errorDialog("Computer with given id cannot be found!!!");
        }
       }   
       else if(formType.equalsIgnoreCase("view")){
           if (Computer.comp.ifComputerExists(this.compID.getText()) == true) {
               ComputerDetails cmp=new ComputerDetails(this.compID.getText(),"view");
               cmp.setVisible(true);
           }
           else{
           DialogBox.dialog.errorDialog("Computer with given id cannot be found!!!");
           }
       }
       else if(formType.equalsIgnoreCase("edit/delete")){
           if (Computer.comp.ifComputerExists(this.compID.getText()) == true) {
               ComputerDetails cmp=new ComputerDetails(this.compID.getText(),"edit/delete");
               cmp.setVisible(true);
           }
           else{
           DialogBox.dialog.errorDialog("Computer with given id cannot be found!!!");
           }
       }
       
            else if (formType.equalsIgnoreCase("labDetails")) {
        if (Computer.comp.ifLabExists(this.compID.getText()) == true) {                
                if (this.generateall.isSelected() == true) {
                    LabDetailsReport ld = new LabDetailsReport(this.compID.getText(), this.from.getText(), this.to.getText(), true);
                    ld.setVisible(true);
                } else {
                    LabDetailsReport ld = new LabDetailsReport(this.compID.getText(), this.from.getText(), this.to.getText(), false);
                    ld.setVisible(true);
                }
                } else {
            DialogBox.dialog.errorDialog("Lab with given id cannot be found!!!");
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
        compID = new javax.swing.JTextField();
        compIdlbl = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        submitButton = new javax.swing.JButton();
        genPanel = new javax.swing.JPanel();
        generateall = new javax.swing.JCheckBox();
        lblfrom = new javax.swing.JLabel();
        from = new javax.swing.JTextField();
        lblto = new javax.swing.JLabel();
        to = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle(": : Enter Computer : :");
        setResizable(false);

        jPanel1.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 2, true));

        compID.setBackground(java.awt.SystemColor.info);
        compID.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        compID.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        compID.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                compIDActionPerformed(evt);
            }
        });
        compID.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                compIDkeySubmit(evt);
            }
        });

        compIdlbl.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        compIdlbl.setText("Computer ID:");

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

        generateall.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        generateall.setText("Generate all");
        generateall.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                generateallgenerateAll(evt);
            }
        });
        generateall.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                generateallKeyPressed(evt);
            }
        });

        lblfrom.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        lblfrom.setText("From:");

        from.setBackground(java.awt.SystemColor.info);
        from.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        from.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                fromKeyPressed(evt);
            }
        });

        lblto.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        lblto.setText("To:");

        to.setBackground(java.awt.SystemColor.info);
        to.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        to.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                toActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout genPanelLayout = new javax.swing.GroupLayout(genPanel);
        genPanel.setLayout(genPanelLayout);
        genPanelLayout.setHorizontalGroup(
            genPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(genPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(generateall)
                .addGap(18, 18, 18)
                .addComponent(lblfrom)
                .addGap(18, 18, 18)
                .addComponent(from, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(lblto)
                .addGap(18, 18, 18)
                .addComponent(to, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        genPanelLayout.setVerticalGroup(
            genPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(genPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(genPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(generateall)
                    .addComponent(lblfrom)
                    .addComponent(from, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblto)
                    .addComponent(to, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jSeparator1)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(compIdlbl)
                                .addGap(18, 18, 18)
                                .addComponent(compID, javax.swing.GroupLayout.PREFERRED_SIZE, 309, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(124, 124, 124)
                                .addComponent(submitButton, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(genPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(compIdlbl)
                    .addComponent(compID, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(genPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(submitButton, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
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

    private void compIDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_compIDActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_compIDActionPerformed

    private void compIDkeySubmit(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_compIDkeySubmit
        int key = evt.getKeyCode();
        if (key == KeyEvent.VK_ENTER) {
            submit();
        }        // TODO add your handling code here: // TODO add your handling code here:
    }//GEN-LAST:event_compIDkeySubmit

    private void generateallgenerateAll(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_generateallgenerateAll
        if (generateall.isSelected() == true&&formType.equalsIgnoreCase("print")) {
            this.from.disable();
            this.to.disable();
            this.lblfrom.disable();
            this.lblto.disable();
            this.compID.disable();
        }
        else if (generateall.isSelected() == true) {
            this.from.disable();
            this.to.disable();
            this.lblfrom.disable();
            this.lblto.disable();
        }
        else if (generateall.isSelected() == false) {
            this.compID.enable();
            this.from.enable();
            this.to.enable();
            this.lblfrom.enable();
            this.lblto.enable();
            this.from.setText(TimeDate.time.timestampToFullDate(System.currentTimeMillis()-(7*24*60*60*1000)));
            this.to.setText(TimeDate.time.timestampToFullDate(System.currentTimeMillis()));
        }
    }//GEN-LAST:event_generateallgenerateAll

    private void toActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_toActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_toActionPerformed

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

    private void fromKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_fromKeyPressed
                int key = evt.getKeyCode();
        if (key == KeyEvent.VK_ENTER) {
            to.requestFocus();
        }
        // TODO add your handling code here:
    }//GEN-LAST:event_fromKeyPressed

    private void generateallKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_generateallKeyPressed

                int key = evt.getKeyCode();
        if (key == KeyEvent.VK_ENTER) {
            from.requestFocus();
        }// TODO add your handling code here:
    }//GEN-LAST:event_generateallKeyPressed
    /**
     * @param args the command line arguments
     */
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField compID;
    private javax.swing.JLabel compIdlbl;
    private javax.swing.JTextField from;
    private javax.swing.JPanel genPanel;
    private javax.swing.JCheckBox generateall;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JLabel lblfrom;
    private javax.swing.JLabel lblto;
    private javax.swing.JButton submitButton;
    private javax.swing.JTextField to;
    // End of variables declaration//GEN-END:variables
}
