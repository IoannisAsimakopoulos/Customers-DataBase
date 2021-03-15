
package alis.customers;

import java.io.File;
import javax.swing.JOptionPane;


public class catalogMain extends javax.swing.JFrame {
    static String courentEpil=""; // μεταβλητή επιλογής για courentForm='add' και buttons παροχών Alis
    static String courentForm=""; // τωρινή φόρμα που βρίσκομαι
    static String [] searchResults = new String [5000];
    static String [] searchResultsFinal = new String [10000];
    static boolean counterEdit=false;
    
    public catalogMain() {
        initComponents();
    }
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        newOrder = new javax.swing.JButton();
        newOrder1 = new javax.swing.JButton();
        newOrder2 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 204));

        jPanel2.setBackground(new java.awt.Color(211, 238, 255));

        newOrder.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        newOrder.setText("Προσθήκη Πελατών");
        newOrder.setAutoscrolls(true);
        newOrder.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        newOrder.setFocusCycleRoot(true);
        newOrder.setFocusable(false);
        newOrder.setSelected(true);
        newOrder.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                newOrderActionPerformed(evt);
            }
        });

        newOrder1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        newOrder1.setText("Επεξεργασία Πελατών");
        newOrder1.setAutoscrolls(true);
        newOrder1.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        newOrder1.setFocusCycleRoot(true);
        newOrder1.setFocusable(false);
        newOrder1.setSelected(true);
        newOrder1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                newOrder1ActionPerformed(evt);
            }
        });

        newOrder2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        newOrder2.setText("Αναζήτηση Ημ/νίας Λήξης Συμβολαίων");
        newOrder2.setAutoscrolls(true);
        newOrder2.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        newOrder2.setFocusCycleRoot(true);
        newOrder2.setFocusable(false);
        newOrder2.setSelected(true);
        newOrder2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                newOrder2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap(120, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(newOrder1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(newOrder, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(newOrder2, javax.swing.GroupLayout.DEFAULT_SIZE, 506, Short.MAX_VALUE))
                .addContainerGap(120, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap(50, Short.MAX_VALUE)
                .addComponent(newOrder, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12)
                .addComponent(newOrder1, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12)
                .addComponent(newOrder2, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(50, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(150, Short.MAX_VALUE)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap(150, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(80, Short.MAX_VALUE)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap(80, Short.MAX_VALUE))
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

    private void newOrderActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_newOrderActionPerformed
        courentForm="add";
        // Κλήση Φόρμας: addCustomer
        new addCustomers().setVisible(true); 
    }//GEN-LAST:event_newOrderActionPerformed

    private void newOrder1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_newOrder1ActionPerformed
        // Κλήση Φόρμας: editCustomer
        File f = new File("c:\\JohnProject\\Στοιχεία Πελατών\\Κωδικοί\\Κωδικοί.txt");
        if(f.exists())
        {
            new editCustomers().setVisible(true);
            courentForm="add";
        }
        else
        {
            JOptionPane.showMessageDialog(null,"Η Βάση σας είναι άδεια. Παρακαλώ εισάγετε κινήσεις για να σας επιτραπεί η χρήση της Επεξεργασίας Πελατών");
        }
        
    }//GEN-LAST:event_newOrder1ActionPerformed

    private void newOrder2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_newOrder2ActionPerformed
        // Κλήση Φόρμας: searchCustomer
        File f = new File("c:\\JohnProject\\Στοιχεία Πελατών\\Ημερομηνίες\\Ημερομηνίες.txt");
        if(f.exists())
        {
            new dateLijis().setVisible(true);
            courentForm="add";
        }
        else
        {
            JOptionPane.showMessageDialog(null,"Δεν υπάρχουν οικονομικές κινήσεις");
        }
    }//GEN-LAST:event_newOrder2ActionPerformed

    
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
            java.util.logging.Logger.getLogger(catalogMain.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(catalogMain.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(catalogMain.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(catalogMain.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new catalogMain().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JButton newOrder;
    private javax.swing.JButton newOrder1;
    private javax.swing.JButton newOrder2;
    // End of variables declaration//GEN-END:variables
}
