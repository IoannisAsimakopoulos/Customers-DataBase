
package alis.customers;

// Imports

    import static alis.customers.catalogMain.searchResults;
    import static alis.customers.catalogMain.counterEdit;
    import static alis.customers.editCustomers.etc;
    import static alis.customers.editCustomers.etcEpon;
    import static alis.customers.editCustomers.etcTitle;
    import static alis.customers.editCustomers.etcCode;
    //import static alis.ins.customers.editCustomers.filter1;
    //import static alis.ins.customers.editCustomers.filter2;
    //import static alis.ins.customers.editCustomers.filter3;
    import javax.swing.JOptionPane;

// Τέλος Imports


public class editCustomers1 extends javax.swing.JFrame {

    // Τοπικές μεταβλητές
        static String epil="";
    // Τέλος τοπικών μεταβλητών
        
    // Μέθοδος Initialise Πεδίων - Πινάκων Φόρμας    
    public void init()
    {
        jList2.setSize(0,0); // setSize (jList2)
        jList3.setSize(0,0); // setSize (jList3)
        jList4.setSize(0,0); // setSize (jList4)
        boolean found=false; // flag για τέλος αποτελεσμάτων πίνακα αναζήτησης
        int counter=0;       // Αθριστής μεταβλητών πίνακα αποτελεσμάτων
        
        // For για να βρούμε τον αθριστή των αποτελεσμάτων του πίνακα
        for(int x=0;found==false; x++)
        {
            counter++;
            if(searchResults[x]=="")
            {
                found=true;
            }
        }
        // Τέλος For για αριθμό αποτελεσμάτων πίνακα
        
        String [] searchResultsEpon  = new String[counter]; // Τοπικός Πίνακας μεγέθους όσο τα αποτελέσματα της αναζήτησης με τις Επωνυμίες της αναξήτησης
        String [] searchResultsTitle = new String[counter]; // Τοπικός Πίνακας μεγέθους όσο τα αποτελέσματα της αναζήτησης με τους Τίτλος Εταιρίας της αναξήτησης
        String [] searchResultsCode  = new String[counter]; // Τοπικός Πίνακας μεγέθους όσο τα αποτελέσματα της αναζήτησης με τις Κωδικούς Πελατών της αναξήτησης
        
        jList2.setSize(1,counter); // setSize της φόρμας (jList2) ίσο με τα αποτεσλέματα της αναζήτησης
        jList3.setSize(1,counter); // setSize της φόρμας (jList3) ίσο με τα αποτεσλέματα της αναζήτησης
        jList4.setSize(1,counter); // setSize της φόρμας (jList4) ίσο με τα αποτεσλέματα της αναζήτησης
        
        // Τοποθέτιση τιμών αναζήτησης απο Πίνακες σε Λίστες
        for(int x=0; x<counter; x++)
        {
            searchResultsEpon [x]  = etcEpon [x]; // Τοποθέτιση Επωνυμιών Πίνακα στην αντίστοιχη Λίστα
            searchResultsTitle[x]  = etcTitle[x]; // Τοποθέτιση Τίτλων Πίνακα στην αντίστοιχη Λίστα
            searchResultsCode [x]  = etcCode [x]; // Τοποθέτιση Κωδικών Πίνακα στην αντίστοιχη Λίστα
        }
        
        jList2.setListData(searchResultsEpon ); // setLListData με τις τιμές του αντίστοιχου πίνακα
        jList3.setListData(searchResultsTitle); // setLListData με τις τιμές του αντίστοιχου πίνακα
        jList4.setListData(searchResultsCode ); // setLListData με τις τιμές του αντίστοιχου πίνακα
        System.out.println();   
        
        counter=0;
        for(int x=0; searchResults[x]!=""; x++)
        {
            searchResults[x]=""; // Αρχικοποίηση Πίνακα (searchReults)
            etcEpon[x] =null;    // Αρχικοποίηση Πίνακα (etcEpon )
            etcTitle[x]=null;    // Αρχικοποίηση Πίνακα (etcTitle)
            etcCode[x] =null;    // Αρχικοποίηση Πίνακα (etcCode )
        }
    }        
    public editCustomers1() {
        initComponents();
        init(); // Μέθοδος Initialise Πεδίων - Πινάκων Φόρμας
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
        jTextField4 = new javax.swing.JTextField();
        jScrollPane4 = new javax.swing.JScrollPane();
        jList4 = new javax.swing.JList<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

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
        jTextField3.setText("Τίτλοι");
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

        jTextField4.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jTextField4.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField4.setText("Κωδικοί");
        jTextField4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jTextField4.setCaretColor(new java.awt.Color(255, 255, 204));
        jTextField4.setDisabledTextColor(new java.awt.Color(255, 255, 204));
        jTextField4.setFocusable(false);
        jTextField4.setRequestFocusEnabled(false);
        jTextField4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField4ActionPerformed(evt);
            }
        });

        jList4.setFont(new java.awt.Font("Tahoma", 3, 18)); // NOI18N
        jList4.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jList4.setFocusable(false);
        jList4.setRequestFocusEnabled(false);
        jList4.setSelectionBackground(new java.awt.Color(255, 255, 255));
        jScrollPane4.setViewportView(jList4);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap(81, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 387, Short.MAX_VALUE)
                            .addComponent(jTextField2))
                        .addGap(0, 0, 0)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 329, Short.MAX_VALUE)
                            .addComponent(jTextField3))
                        .addGap(0, 0, 0)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                            .addComponent(jTextField4, javax.swing.GroupLayout.DEFAULT_SIZE, 172, Short.MAX_VALUE)))
                    .addComponent(jTextField1))
                .addContainerGap(81, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(250, Short.MAX_VALUE)
                .addComponent(Final_Button_Enimerosi, javax.swing.GroupLayout.PREFERRED_SIZE, 550, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(250, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap(29, Short.MAX_VALUE)
                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, 0)
                        .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 163, Short.MAX_VALUE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, 0)
                        .addComponent(jScrollPane2))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addComponent(jScrollPane3)))
                .addGap(30, 30, 30)
                .addComponent(Final_Button_Enimerosi, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
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
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(0, 0, 0))
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
        // Δεν έχει επιλεχτεί Όνομα Πελάτη
        if(jList2.getSelectedValue()==null)
        {
            // Μνμ για μή επιλεγμένο Όνομα Πελάτη
            JOptionPane.showMessageDialog(null,"Παρακαλώ επιλέξτε πελάτη","Warning",
            JOptionPane.WARNING_MESSAGE);
        }
        // Επιλεγμένο Όνομα Πελάτη
        else
        {
            int intEpil=jList2.getSelectedIndex(); // Θέση επιλεγμένου ονόματος
            epil = etc[intEpil].substring(etc[intEpil].length() - 5); // Επιλεγμένο όνομα πελάτη
            epil = epil.replace('/',' ').trim();  // Απομάκρινση τυχόν σκουπιδιών απο την ονομασία του πελάτη
            counterEdit = true;                   // Μεταβλητή για το εάν γίνεται Καταχώριση Νέου Πελάτη ή Επαιξεργασία Παλαιού Πελάτη
            System.out.println(epil);             // Εμφάνηση Ονόματος επιλογής κατα το debug
            new editCustomers2().setVisible(true);// Εμφάνηση Φόρμας (editCustomers2)
        }
    }//GEN-LAST:event_Final_Button_EnimerosiActionPerformed

    private void jTextField2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField2ActionPerformed

    private void jTextField3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField3ActionPerformed

    private void jTextField4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField4ActionPerformed

    
    public static void main(String args[]) {
        
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(editCustomers1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(editCustomers1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(editCustomers1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(editCustomers1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new editCustomers1().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Final_Button_Enimerosi;
    private javax.swing.JList<String> jList2;
    private javax.swing.JList<String> jList3;
    private javax.swing.JList<String> jList4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField4;
    // End of variables declaration//GEN-END:variables
}
