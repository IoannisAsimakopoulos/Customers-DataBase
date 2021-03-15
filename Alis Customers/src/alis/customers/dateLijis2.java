
package alis.customers;


// Imports

    import static alis.customers.catalogMain.counterEdit;
    import static alis.customers.catalogMain.searchResultsFinal;
    import java.io.File;
    import java.util.Scanner;
    import javax.swing.JOptionPane;
    //import static alis.ins.customers.dateLijis.searchResultsFinal;

// Τέλος Imports


public class dateLijis2 extends javax.swing.JFrame {
    // Τοπικές Μεταβλητές
        static String [] codes = new String[10000]; // Πίνακας Κωδικών
        static String epil2="";
        /*
        static String [] eponimies;
        static String [] codes;
        static String [] titleEter;
        static String [] paketo;
        static String [] liji;
        static String [] poso;
        */
    // Τέλος Τοπικών Μεταβλητών
    
        public void init()
        {
            int xSearch=0; // Μετριτής αριθμού αποτελεσμάτων αναζήτησης
            // For για μέτρηση αποτελεσμάτω αναζήτησης
            for(int x=0; searchResultsFinal[x]!=null; x++)
            {
                xSearch++;
            }
            
            String[] eponimies = new String[xSearch]; // Πίνακας Επωνυμιών xSearch θέσεων 
            String[] titleEter = new String[xSearch]; // Πίνακας Τίτλων Εταιριών xSearch θέσεων
            String[] paketo    = new String[xSearch]; // Πίνακας Πακέτων xSearch θέσεων
            String[] liji      = new String[xSearch]; // Πίνακας Ημ/νιών Λήξεων xSearch θέσεων
            String[] poso      = new String[xSearch]; // Πίνακας Ποσών xSearch θέσεων
            
            for(int x=0; x<xSearch; x++)
            {
                liji  [x] = (searchResultsFinal[x].substring(searchResultsFinal[x].length()-10));
                codes [x] = (searchResultsFinal[x].substring(0,9).replace('-',' ').replace('/',' ').replace('_',' ').trim());
                poso  [x] = (searchResultsFinal[x].substring(searchResultsFinal[x].length()-40,searchResultsFinal[x].length()-30).replace('-',' ').replace('_',' ').replace('/',' ').trim());
                if(poso[x].equals(""))
                {
                    poso[x]="      ---  ";
                }
                paketo[x] = (searchResultsFinal[x].substring(17,40).replace('-',' ').replace('/',' ').replace('_',' ').trim());
            }
            System.out.println();
            for(int x=0; x<xSearch; x++)
            {
                try
                {
                    File myObj = new File("c:\\JohnProject\\Στοιχεία Πελατών\\Γενικά Στοιχεία\\"+codes[x]+" (Γενικά Στοιχεία).txt");
                    Scanner myReader = new Scanner(myObj);
                    int counterData=0;
                    String [] sData = new String [49];
                    for(int i=0; i<(xSearch-1); i++)
                    {
                        sData[x]="";
                    }
                    while(myReader.hasNextLine())
                    {
                        sData[counterData]=myReader.nextLine();
                        counterData++;
                    }
                    titleEter[x] = sData[1].replace('_',' ').trim();
                    eponimies[x] = sData[0].replace('_',' ').trim();
                    counterData=0;
                }
                catch(Exception e)
                {
                    System.out.println(e);
                }
            }
            jList2.setSize(0,0);    //  Επωνυμίες
            jList3.setSize(0,0);    //  Τίτλοι
            jList5.setSize(0,0);    //  Πακέτα
            jList6.setSize(0,0);    //  Ημ/νία Λήξης    
            jList7.setSize(0,0);    //  Ποσό
            
            boolean found=false;
            int counter=0;
            for(int x=0;found==false; x++)
            {
                counter++;
                if(searchResultsFinal[x]==null)
                {
                    found=true;
                }
            }
            
            jList2.setSize(1,counter);
            jList3.setSize(1,counter);
            jList5.setSize(1,counter);
            jList6.setSize(1,counter);
            jList7.setSize(1,counter);
            
            jList2.setListData(eponimies);
            jList5.setListData(titleEter);
            jList3.setListData(paketo);
            jList6.setListData(liji);
            jList7.setListData(poso);
            
            for(int x=0; searchResultsFinal[x]!=null; x++)
            {
                searchResultsFinal[x]=null;
            }
        }
    
    public dateLijis2() {
        initComponents();
        init();
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jTextField1 = new javax.swing.JTextField();
        Final_Button_Enimerosi = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        jList2 = new javax.swing.JList<>();
        jTextField2 = new javax.swing.JTextField();
        jScrollPane3 = new javax.swing.JScrollPane();
        jList3 = new javax.swing.JList<>();
        jTextField3 = new javax.swing.JTextField();
        jTextField5 = new javax.swing.JTextField();
        jScrollPane5 = new javax.swing.JScrollPane();
        jList5 = new javax.swing.JList<>();
        jTextField6 = new javax.swing.JTextField();
        jScrollPane6 = new javax.swing.JScrollPane();
        jList6 = new javax.swing.JList<>();
        jTextField7 = new javax.swing.JTextField();
        jScrollPane7 = new javax.swing.JScrollPane();
        jList7 = new javax.swing.JList<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 204));

        jPanel2.setBackground(new java.awt.Color(211, 238, 255));

        jTextField1.setFont(new java.awt.Font("Tahoma", 0, 21)); // NOI18N
        jTextField1.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField1.setText("Αποτελέσματα αναζήτησης:");
        jTextField1.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        jTextField1.setCaretColor(new java.awt.Color(255, 255, 204));
        jTextField1.setDisabledTextColor(new java.awt.Color(255, 255, 204));
        jTextField1.setFocusable(false);
        jTextField1.setRequestFocusEnabled(false);
        jTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField1ActionPerformed(evt);
            }
        });

        Final_Button_Enimerosi.setFont(new java.awt.Font("Tahoma", 1, 15)); // NOI18N
        Final_Button_Enimerosi.setText("Προβολή καρτέλας πελάτη");
        Final_Button_Enimerosi.setAutoscrolls(true);
        Final_Button_Enimerosi.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        Final_Button_Enimerosi.setFocusCycleRoot(true);
        Final_Button_Enimerosi.setFocusPainted(false);
        Final_Button_Enimerosi.setSelected(true);
        Final_Button_Enimerosi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Final_Button_EnimerosiActionPerformed(evt);
            }
        });

        jList2.setFont(new java.awt.Font("Tahoma", 3, 18)); // NOI18N
        jList2.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jList2.setFocusable(false);
        jList2.setRequestFocusEnabled(false);
        jList2.setSelectionBackground(new java.awt.Color(122, 195, 255));
        jScrollPane2.setViewportView(jList2);

        jTextField2.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jTextField2.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField2.setText("Επωνυμίες");
        jTextField2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jTextField2.setCaretColor(new java.awt.Color(255, 255, 204));
        jTextField2.setDisabledTextColor(new java.awt.Color(255, 255, 204));
        jTextField2.setFocusable(false);
        jTextField2.setRequestFocusEnabled(false);
        jTextField2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField2ActionPerformed(evt);
            }
        });

        jList3.setFont(new java.awt.Font("Tahoma", 3, 18)); // NOI18N
        jList3.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jList3.setFocusable(false);
        jList3.setRequestFocusEnabled(false);
        jList3.setSelectionBackground(new java.awt.Color(255, 255, 255));
        jScrollPane3.setViewportView(jList3);

        jTextField3.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jTextField3.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField3.setText("Πακέτο");
        jTextField3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jTextField3.setCaretColor(new java.awt.Color(255, 255, 204));
        jTextField3.setDisabledTextColor(new java.awt.Color(255, 255, 204));
        jTextField3.setFocusable(false);
        jTextField3.setRequestFocusEnabled(false);
        jTextField3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField3ActionPerformed(evt);
            }
        });

        jTextField5.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jTextField5.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField5.setText("Τίτλος Εταιρίας");
        jTextField5.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jTextField5.setCaretColor(new java.awt.Color(255, 255, 204));
        jTextField5.setDisabledTextColor(new java.awt.Color(255, 255, 204));
        jTextField5.setFocusable(false);
        jTextField5.setRequestFocusEnabled(false);
        jTextField5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField5ActionPerformed(evt);
            }
        });

        jList5.setFont(new java.awt.Font("Tahoma", 3, 18)); // NOI18N
        jList5.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jList5.setFocusable(false);
        jList5.setRequestFocusEnabled(false);
        jList5.setSelectionBackground(new java.awt.Color(255, 255, 255));
        jScrollPane5.setViewportView(jList5);

        jTextField6.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jTextField6.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField6.setText("Ημ/νία λήξης");
        jTextField6.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jTextField6.setCaretColor(new java.awt.Color(255, 255, 204));
        jTextField6.setDisabledTextColor(new java.awt.Color(255, 255, 204));
        jTextField6.setFocusable(false);
        jTextField6.setRequestFocusEnabled(false);
        jTextField6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField6ActionPerformed(evt);
            }
        });

        jList6.setFont(new java.awt.Font("Tahoma", 3, 18)); // NOI18N
        jList6.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jList6.setFocusable(false);
        jList6.setRequestFocusEnabled(false);
        jList6.setSelectionBackground(new java.awt.Color(255, 255, 255));
        jScrollPane6.setViewportView(jList6);

        jTextField7.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jTextField7.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField7.setText("Ποσό");
        jTextField7.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jTextField7.setCaretColor(new java.awt.Color(255, 255, 204));
        jTextField7.setDisabledTextColor(new java.awt.Color(255, 255, 204));
        jTextField7.setFocusable(false);
        jTextField7.setRequestFocusEnabled(false);
        jTextField7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField7ActionPerformed(evt);
            }
        });

        jList7.setFont(new java.awt.Font("Tahoma", 3, 18)); // NOI18N
        jList7.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jList7.setFocusable(false);
        jList7.setRequestFocusEnabled(false);
        jList7.setSelectionBackground(new java.awt.Color(255, 255, 255));
        jScrollPane7.setViewportView(jList7);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap(100, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTextField1)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 329, Short.MAX_VALUE)
                            .addComponent(jTextField2))
                        .addGap(0, 0, 0)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane5, javax.swing.GroupLayout.DEFAULT_SIZE, 284, Short.MAX_VALUE)
                            .addComponent(jTextField5))
                        .addGap(0, 0, 0)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                            .addComponent(jTextField3, javax.swing.GroupLayout.DEFAULT_SIZE, 192, Short.MAX_VALUE))
                        .addGap(0, 0, 0)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTextField6)
                            .addComponent(jScrollPane6, javax.swing.GroupLayout.DEFAULT_SIZE, 143, Short.MAX_VALUE))
                        .addGap(0, 0, 0)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTextField7)
                            .addComponent(jScrollPane7, javax.swing.GroupLayout.DEFAULT_SIZE, 98, Short.MAX_VALUE))))
                .addContainerGap(100, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(Final_Button_Enimerosi, javax.swing.GroupLayout.PREFERRED_SIZE, 550, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap(30, Short.MAX_VALUE)
                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jTextField7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, 0)
                        .addComponent(jScrollPane7, javax.swing.GroupLayout.DEFAULT_SIZE, 176, Short.MAX_VALUE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jTextField6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, 0)
                        .addComponent(jScrollPane6))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextField5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, 0)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane2)
                            .addComponent(jScrollPane5)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addComponent(jScrollPane3)))
                .addGap(30, 30, 30)
                .addComponent(Final_Button_Enimerosi, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(30, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(120, Short.MAX_VALUE)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap(120, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(50, Short.MAX_VALUE)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap(50, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField1ActionPerformed

    }//GEN-LAST:event_jTextField1ActionPerformed

    private void Final_Button_EnimerosiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Final_Button_EnimerosiActionPerformed

        // Μη επιλεγμένο πεδίο Ονόματος
        if(jList2.getSelectedValue()==null)
        {
            // Μνμ λόγο μή επιλεγμένου ονόματος
            JOptionPane.showMessageDialog(null,"Παρακαλώ επιλέξτε πελάτη","Warning",
            JOptionPane.WARNING_MESSAGE);
        }
        // Επιλεγμένο πεδίο Ονόματος
        else
        {
            int intEpil=jList2.getSelectedIndex(); // θέση επιλεγμένου Ονόματος στην λίστα
            epil2 = codes[intEpil];
            counterEdit=false;
            System.out.println(epil2);
            new editCustomers2().setVisible(true);
        }
    }//GEN-LAST:event_Final_Button_EnimerosiActionPerformed

    private void jTextField2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField2ActionPerformed

    private void jTextField3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField3ActionPerformed

    private void jTextField5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField5ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField5ActionPerformed

    private void jTextField6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField6ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField6ActionPerformed

    private void jTextField7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField7ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField7ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(dateLijis2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(dateLijis2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(dateLijis2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(dateLijis2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new dateLijis2().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Final_Button_Enimerosi;
    private javax.swing.JList<String> jList2;
    private javax.swing.JList<String> jList3;
    private javax.swing.JList<String> jList5;
    private javax.swing.JList<String> jList6;
    private javax.swing.JList<String> jList7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField5;
    private javax.swing.JTextField jTextField6;
    private javax.swing.JTextField jTextField7;
    // End of variables declaration//GEN-END:variables
}

