
package alis.customers;

import static alis.customers.catalogMain.searchResultsFinal;
import java.io.File;
import java.util.Scanner;
import javax.swing.JOptionPane;

public class dateLijis extends javax.swing.JFrame {

    
    public dateLijis() {
        initComponents();
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jTextField1 = new javax.swing.JTextField();
        Final_Button_Enimerosi = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jTextField6 = new javax.swing.JTextField();
        jTextField7 = new javax.swing.JTextField();
        jTextField4 = new javax.swing.JTextField();
        jFormattedTextField2 = new javax.swing.JFormattedTextField();
        jFormattedTextField4 = new javax.swing.JFormattedTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 204));

        jPanel2.setBackground(new java.awt.Color(211, 238, 255));

        jTextField1.setFont(new java.awt.Font("Tahoma", 0, 21)); // NOI18N
        jTextField1.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField1.setText("Αναζήτηση Ημ/νίας Λήξης Συμβολαίων");
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
        Final_Button_Enimerosi.setText("Αναζήτηση ");
        Final_Button_Enimerosi.setAutoscrolls(true);
        Final_Button_Enimerosi.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        Final_Button_Enimerosi.setFocusPainted(false);
        Final_Button_Enimerosi.setRequestFocusEnabled(false);
        Final_Button_Enimerosi.setRolloverEnabled(false);
        Final_Button_Enimerosi.setSelected(true);
        Final_Button_Enimerosi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Final_Button_EnimerosiActionPerformed(evt);
            }
        });

        jPanel3.setDoubleBuffered(false);
        jPanel3.setEnabled(false);

        jTextField6.setFont(new java.awt.Font("Tahoma", 0, 17)); // NOI18N
        jTextField6.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField6.setText("Έως:");
        jTextField6.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        jTextField6.setCaretColor(new java.awt.Color(255, 255, 204));
        jTextField6.setDisabledTextColor(new java.awt.Color(255, 255, 204));
        jTextField6.setFocusable(false);
        jTextField6.setRequestFocusEnabled(false);
        jTextField6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField6ActionPerformed(evt);
            }
        });

        jTextField7.setBackground(new java.awt.Color(240, 240, 240));
        jTextField7.setFont(new java.awt.Font("Tahoma", 1, 15)); // NOI18N
        jTextField7.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField7.setText("Ημ/νία Λήξης");
        jTextField7.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        jTextField7.setCaretColor(new java.awt.Color(255, 255, 204));
        jTextField7.setDisabledTextColor(new java.awt.Color(255, 255, 204));
        jTextField7.setFocusable(false);
        jTextField7.setRequestFocusEnabled(false);
        jTextField7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField7ActionPerformed(evt);
            }
        });

        jTextField4.setFont(new java.awt.Font("Tahoma", 0, 17)); // NOI18N
        jTextField4.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField4.setText("Από:");
        jTextField4.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        jTextField4.setCaretColor(new java.awt.Color(255, 255, 204));
        jTextField4.setDisabledTextColor(new java.awt.Color(255, 255, 204));
        jTextField4.setFocusable(false);
        jTextField4.setRequestFocusEnabled(false);
        jTextField4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField4ActionPerformed(evt);
            }
        });

        jFormattedTextField2.setBorder(null);
        jFormattedTextField2.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.DateFormatter(new java.text.SimpleDateFormat("dd/MM/yyyy"))));
        jFormattedTextField2.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jFormattedTextField2.setAutoscrolls(false);
        jFormattedTextField2.setFont(new java.awt.Font("Tahoma", 1, 15)); // NOI18N
        jFormattedTextField2.setVerifyInputWhenFocusTarget(false);
        jFormattedTextField2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jFormattedTextField2ActionPerformed(evt);
            }
        });

        jFormattedTextField4.setBorder(null);
        jFormattedTextField4.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.DateFormatter(new java.text.SimpleDateFormat("dd/MM/yyyy"))));
        jFormattedTextField4.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jFormattedTextField4.setAutoscrolls(false);
        jFormattedTextField4.setFont(new java.awt.Font("Tahoma", 1, 15)); // NOI18N
        jFormattedTextField4.setVerifyInputWhenFocusTarget(false);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel3Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jTextField7, javax.swing.GroupLayout.DEFAULT_SIZE, 113, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 318, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel3Layout.createSequentialGroup()
                        .addGap(80, 80, 80)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTextField4)
                            .addComponent(jFormattedTextField2))
                        .addGap(38, 38, 38)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTextField6)
                            .addComponent(jFormattedTextField4))))
                .addGap(80, 80, 80))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jTextField7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField6, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jFormattedTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jFormattedTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(30, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap(121, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTextField1)
                    .addComponent(Final_Button_Enimerosi, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(120, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap(30, Short.MAX_VALUE)
                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(30, 30, 30)
                .addComponent(Final_Button_Enimerosi, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(30, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(150, Short.MAX_VALUE)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap(150, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(60, Short.MAX_VALUE)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap(60, Short.MAX_VALUE))
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

    private void jFormattedTextField2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jFormattedTextField2ActionPerformed

    }//GEN-LAST:event_jFormattedTextField2ActionPerformed

    private void jTextField4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField4ActionPerformed

    private void jTextField7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField7ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField7ActionPerformed

    private void jTextField6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField6ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField6ActionPerformed

    private void Final_Button_EnimerosiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Final_Button_EnimerosiActionPerformed
        
        String apo = jFormattedTextField2.getText(); // Μεταβλητή για ημερομηνία Από
        String eos = jFormattedTextField4.getText(); // Μεταβλητή για ημερομηνία Έως
        
        // Συνθήκη για κενά πεδία
        if((apo.equals("") || apo==null) || (eos.equals("") || eos==null))
        {
            // Μνμ για συμπλήρωση κενών πεδίων
            JOptionPane.showMessageDialog(null,"Παρακαλώ συμπληρώστε και τα δύο υποχρεωτικά πεδία (Λήξη Απο  -  Λήξη Έως)","Warning",
            JOptionPane.WARNING_MESSAGE);
        }
        // Τέλος συνθήκης
        
        // Σωστά πεδία για αναζήτηση
        else
        {
            if(apo.length()==10 && eos.length()==10)
            {
                String apoYear  = apo.substring(apo.length() - 4);  //  έτος από
                int apoYearInt  = Integer.valueOf(apoYear);
                String eosYear  = eos.substring(eos.length() - 4);  //  έτος έως
                int eosYearInt  = Integer.valueOf(eosYear);
                String apoMonth = apo.substring(3,5);               // μήνας από
                int apoMonthInt = Integer.valueOf(apoMonth);
                String eosMonth = eos.substring(3,5);               // μήνας έως
                int eosMonthInt = Integer.valueOf(eosMonth);
                String apoDays  = apo.substring(0,2);               // μέρες από
                int apoDaysInt  = Integer.valueOf(apoDays);
                String eosDays  = eos.substring(0,2);               // μέρες μέχρι
                int eosDaysInt  = Integer.valueOf(eosDays);
                System.out.println();

                // Διασφάληση σωστής αναζήτησης
                String eti=""; // Μεταβλητή για να ξέρουμε το φίλτρο της αναζήτησης
                if(apoYearInt < eosYearInt)
                {
                    eti="μικρότερο";
                }
                else if(apoYearInt == eosYearInt)
                {
                    eti="ίσα";
                }
                else
                {
                    // Μνμ λανθασμένων ημερομηνιών(Έτος από > Έτος έως)
                    JOptionPane.showMessageDialog(null,"Λανθασμένες ημερωμηνίες αναζήτησης.","Warning",
                    JOptionPane.WARNING_MESSAGE);
                }
                if(eti.equals("μικρότερο") || eti.equals("ίσα"))
                {
                    // Ίσα έτη - Μήνας απο > Μήνας έως
                    if(eti.equals("ίσα") && apoMonthInt>eosMonthInt)
                    {
                        // Μνμ λανθασμένης ημερομηνίας αναζήτησης (Ίσα έτη - Μήνας απο > Μήνας έως)
                        JOptionPane.showMessageDialog(null,"Λανθασμένες ημερωμηνίες αναζήτησης.","Warning",
                        JOptionPane.WARNING_MESSAGE);
                    }
                    else if(eti.equals("ίσα") && apoMonthInt<eosMonthInt)
                    {
                        eti="ίσα έτη - μεγαλύτερος μήνας"; // Καταχόρηση φίλτρου αναζήτησης
                    }
                    else if(eti.equals("ίσα") && apoMonthInt==eosMonthInt)
                    {
                        eti="ίσα έτη - ίσοι μήνες"; // Καταχόρηση φίλτρου αναζήτησης
                    }
                    else if(eti.equals("μικρότερο") && apoMonthInt<eosMonthInt)
                    {
                        eti="μικρότερο έτος - μικρότεροι μήνες"; // Καταχόρηση φίλτρου αναζήτησης
                        // Μνμ για μελλοντική αναβάθμιση (Έτος αναζήτησης από > Έτος αναζήτησης έως+1), αναζήτηση για μεγαλύτερο χρονικό διάστημα του 1 έτους
                        JOptionPane.showMessageDialog(null,"Η συγκεκριμένη αναζήτηση αποτελεί κομμάτι μελλοντικής αναβάθμισης του προγράμματος.","Warning",
                        JOptionPane.WARNING_MESSAGE);
                    }
                    else if(eti.equals("μικρότερο") && apoMonthInt>eosMonthInt)
                    {
                        eti="μικρότερο έτος - μεγαλύτεροι μήνες"; // Καταχόρηση φίλτρου αναζήτησης
                    }
                    else if(eti.equals("μικρότερο") && apoMonthInt==eosMonthInt)
                    {
                        eti="μικρότερο έτος - ίσοι μήνες"; // Καταχόρηση φίλτρου αναζήτησης
                    }
                }
                // Λανθασμένο φίλτρο αναζήτησης
                if(eti.equals(""))
                {
                }
                // Σωστά φίλτρα αναζήτησης
                else
                {
                    if(eti.equals("ίσα έτη - ίσοι μήνες") && (apoDaysInt==eosDaysInt))
                    {
                        eti="ίσα έτη - ίσοι μήνες - ίσες μέρες"; // Καταχόρηση φίλτρου αναζήτησης
                    }
                    else if(eti.equals("ίσα έτη - ίσοι μήνες") && (apoDaysInt>eosDaysInt))
                    {
                        // Λαναθσμένη ημερομηνία (ίσα έτη - ίσοι μήνες - Ημέρα από < Ημέρα έως)
                        JOptionPane.showMessageDialog(null,"Λανθασμένες ημερωμηνίες αναζήτησης.","Warning",
                        JOptionPane.WARNING_MESSAGE);
                    }
                    else if(eti.equals("ίσα έτη - ίσοι μήνες") && (apoDaysInt<eosDaysInt))
                    {
                        eti="ίσα έτη - ίσοι μήνες - μικρότερες μέρες"; // Καταχόρηση φίλτρου αναζήτησης
                    }
                    else if(eti.equals("μικρότερο έτος - ίσοι μήνες") && (apoDaysInt==eosDaysInt))
                    {
                        eti="μικρότερο έτος - ίσοι μήνες - ίσες μέρες"; // Καταχόρηση φίλτρου αναζήτησης
                    }
                    else if(eti.equals("μικρότερο έτος - ίσοι μήνες") && (apoDaysInt>eosDaysInt))
                    {   
                        // Λαναθσμένη ημερομηνία (μικρότερο έτος - ίσοι μήνες - Ημέρα από > Ημέρα έως)
                        JOptionPane.showMessageDialog(null,"Λανθασμένες ημερωμηνίες αναζήτησης.","Warning",
                        JOptionPane.WARNING_MESSAGE);
                    }
                    else if(eti.equals("μικρότερο έτος - ίσοι μήνες") && (apoDaysInt<eosDaysInt))
                    {
                        eti="μικρότερο έτος - ίσοι μήνες - μικρότερες μέρες"; // Καταχόρηση φίλτρου αναζήτησης
                    }
                    if(apo.equals(eos))
                    {
                        eti="ίσα έτη - ίσοι μήνες - ίσες μέρες"; // Καταχόρηση φίλτρου αναζήτησης
                    }
                }
                // Εμφάνησης τιμής φίλτρου αναζήτησης
                System.out.println(eti);

                int counterSearchResults=0; // Μεταβλητή μετρητή Αποτελεσμάτων αναζήτησης
                try
                {
                    // Άνοιγμα αρχείου
                    File myObj = new File("c:\\JohnProject\\Στοιχεία Πελατών\\Ημερομηνίες\\Ημερομηνίες.txt");
                    Scanner myReader = new Scanner(myObj);
                    int counterData1=0; // αθριστής στοιχείων αρχείου 
                    String [] sData1 = new String [5000]; // πίνακας με τα στοιχεία του αρχείου
                    // Αρχικοποίηση πίνακα 
                    for(int x=0; x<5000; x++)
                    {
                        sData1[x]="";
                    }
                    // Αρχικοπίηση πίνακα με τα στοιχεία του αρχείου
                    while (myReader.hasNext())
                    {
                        sData1[counterData1]=myReader.next();
                        counterData1++;
                    }
                    
                    // Έλεγχος για το εάν η ημερομηνία του αρχείου είναι ανάμεσα στις ημερομηνίες που έχουμε ορίσει
                    for(int x=0; x<counterData1; x++)
                    {
                        // Μεταβλητή με ολόκληρη την ημερομηνία που έχει το αρχείο κάθε φορά
                        String time = (sData1[x].substring(sData1[x].length()-10));
                        String timeString = time;
                        if(eti.equals("ίσα έτη - ίσοι μήνες - ίσες μέρες"))
                        {
                            if(time.equals(apo) && time.equals(eos))
                            {
                                searchResultsFinal[counterSearchResults]=(sData1[x]);
                                counterSearchResults++;
                            }
                        }
                        else if(eti.equals("ίσα έτη - ίσοι μήνες - μικρότερες μέρες"))
                        {
                            //String xYears = time.substring(time.length() - 4);
                            int xYears  = Integer.valueOf(timeString.substring(timeString.length() - 4)); // Χρονιά μεταβλητής αρχείου
                            int xMonths = Integer.valueOf(timeString.substring(3,5)); // Μήνας μεταβλητής αρχείου
                            int xDays   = Integer.valueOf(timeString.substring(0,2)); // Ημέρα μεταβλητής αρχείου
                            if((xYears==apoYearInt) && (xMonths==apoMonthInt) && (xYears==eosYearInt) && (xMonths==apoMonthInt) && (xDays>=apoDaysInt) && (xDays<=apoDaysInt))
                            {
                                searchResultsFinal[counterSearchResults]=(sData1[x]);
                                counterSearchResults++;
                            }
                        }
                        else if(eti.equals("ίσα έτη - μεγαλύτερος μήνας"))
                        {
                            int xYears  = Integer.valueOf(timeString.substring(timeString.length() - 4)); // Χρονιά μεταβλητής αρχείου
                            int xMonths = Integer.valueOf(timeString.substring(3,5)); // Μήνας μεταβλητής αρχείου
                            int xDays   = Integer.valueOf(timeString.substring(0,2)); // Ημέρα μεταβλητής αρχείου
                            if((xYears==apoYearInt) && (xYears==eosYearInt) && (xMonths>=apoMonthInt)  && (xMonths<=eosMonthInt))
                            {
                                boolean foundTelik=false;
                                if((xMonths==apoMonthInt) && (xDays>=apoDaysInt))
                                {
                                    searchResultsFinal[counterSearchResults]=(sData1[x]);
                                    counterSearchResults++;
                                    foundTelik=true;
                                }
                                else if((xMonths==eosMonthInt) && (xDays<=eosDaysInt))
                                {
                                    searchResultsFinal[counterSearchResults]=(sData1[x]);
                                    counterSearchResults++;
                                    foundTelik=true;
                                }
                                else if((xMonths>apoMonthInt && xMonths<eosMonthInt))
                                {
                                    searchResultsFinal[counterSearchResults]=(sData1[x]);
                                    counterSearchResults++;
                                }
                            }
                        }
                        else if(eti.equals("μικρότερο έτος - ίσοι μήνες - ίσες μέρες"))
                        {
                            int xYears  = Integer.valueOf(timeString.substring(timeString.length() - 4)); // Χρονιά μεταβλητής αρχείου
                            int xMonths = Integer.valueOf(timeString.substring(3,5)); // Μήνας μεταβλητής αρχείου
                            int xDays   = Integer.valueOf(timeString.substring(0,2)); // Ημέρα μεταβλητής αρχείου
                            if((xYears>=apoYearInt) && (xYears<=eosYearInt))
                            {
                                if((xYears>apoYearInt) && (xYears<apoYearInt))
                                {
                                    searchResultsFinal[counterSearchResults]=(sData1[x]);
                                    counterSearchResults++;
                                }
                                else if((xYears==apoYearInt) && (xMonths>=apoMonthInt))
                                {
                                    if((xYears==apoYearInt) && (xMonths==apoMonthInt) &&(xDays>=apoDaysInt))
                                    {
                                        searchResultsFinal[counterSearchResults]=(sData1[x]);
                                        counterSearchResults++;
                                    }
                                    else if((xYears==apoYearInt) && (xMonths>apoMonthInt))
                                    {
                                        searchResultsFinal[counterSearchResults]=(sData1[x]);
                                        counterSearchResults++;
                                    }
                                }
                                else if((xYears==eosYearInt) && (xMonths<=apoMonthInt))
                                {
                                    if((xMonths==apoMonthInt) && (xDays<=apoDaysInt))
                                    {
                                        searchResultsFinal[counterSearchResults]=(sData1[x]);
                                        counterSearchResults++;
                                    }
                                    else if(xMonths<apoMonthInt)
                                    {
                                        searchResultsFinal[counterSearchResults]=(sData1[x]);
                                        counterSearchResults++;
                                    }
                                }
                            }
                        }
                        else if(eti.equals("μικρότερο έτος - ίσοι μήνες - μικρότερες μέρες"))
                        {
                            int xYears  = Integer.valueOf(timeString.substring(timeString.length() - 4)); // Χρονιά μεταβλητής αρχείου
                            int xMonths = Integer.valueOf(timeString.substring(3,5)); // Μήνας μεταβλητής αρχείου
                            int xDays   = Integer.valueOf(timeString.substring(0,2)); // Ημέρα μεταβλητής αρχείου
                            if((xYears<=apoYearInt) && (xYears>=eosYearInt) && (xMonths==apoMonthInt)  && (xMonths==eosMonthInt)&& (xDays>=apoDaysInt)  && (xDays<=eosDaysInt))
                            {
                                searchResultsFinal[counterSearchResults]=(sData1[x]);
                                counterSearchResults++;
                            }
                        }
                        else if(eti.equals("μικρότερο έτος - μεγαλύτεροι μήνες"))
                        {
                            int xYears  = Integer.valueOf(timeString.substring(timeString.length() - 4)); // Χρονιά μεταβλητής αρχείου
                            int xMonths = Integer.valueOf(timeString.substring(3,5)); // Μήνας μεταβλητής αρχείου
                            int xDays   = Integer.valueOf(timeString.substring(0,2)); // Ημέρα μεταβλητής αρχείου
                            if((xMonths==eosMonthInt) && (xYears==eosYearInt) && (xDays<=eosDaysInt))
                            {
                                searchResultsFinal[counterSearchResults]=(sData1[x]);
                                counterSearchResults++;
                            }
                            else if((xMonths==apoMonthInt)&& (xYears==apoYearInt) && (xDays>=apoDaysInt))
                            {
                                searchResultsFinal[counterSearchResults]=(sData1[x]);
                                counterSearchResults++;
                            }
                            else if((xYears>apoYearInt) && (xYears<=eosYearInt))
                            {
                                if((xYears==eosYearInt) && (xMonths<eosMonthInt))
                                {
                                    if((xMonths==eosMonthInt) && (xDays<=eosDaysInt))
                                    {
                                        searchResultsFinal[counterSearchResults]=(sData1[x]);
                                        counterSearchResults++;
                                    }
                                    else if(xMonths<eosMonthInt)
                                    {
                                        searchResultsFinal[counterSearchResults]=(sData1[x]);
                                        counterSearchResults++;
                                    }
                                }
                                else if((xYears==eosYearInt) && (xMonths==eosMonthInt))
                                {
                                    if(xDays<=eosDaysInt)
                                    {
                                        searchResultsFinal[counterSearchResults]=(sData1[x]);
                                        counterSearchResults++;
                                    }
                                }

                            }
                            else if((xYears<eosYearInt) && (xYears>=apoYearInt))
                            {
                                if((xYears==apoYearInt)&&(xMonths==apoMonthInt)&&(xDays>=apoDaysInt))
                                {
                                    searchResultsFinal[counterSearchResults]=(sData1[x]);
                                    counterSearchResults++;
                                }
                                else if((xYears==apoYearInt)&&(xMonths>apoMonthInt))
                                {
                                    searchResultsFinal[counterSearchResults]=(sData1[x]);
                                    counterSearchResults++;
                                }
                            }
                            else if((xYears==eosYearInt) && (xMonths<=eosMonthInt))
                            {
                                if((xYears==eosYearInt) && (xMonths==eosMonthInt) && (xDays<=eosDaysInt))
                                {
                                    searchResultsFinal[counterSearchResults]=(sData1[x]);
                                    counterSearchResults++;
                                }
                                else if((xYears==eosYearInt) && (xMonths<eosMonthInt))
                                {
                                    searchResultsFinal[counterSearchResults]=(sData1[x]);
                                    counterSearchResults++;
                                }
                            }
                            else if((xYears==apoYearInt) && (xMonths>=apoMonthInt))
                            {
                                if((xYears==apoYearInt) && (xMonths>apoMonthInt))
                                {
                                    searchResultsFinal[counterSearchResults]=(sData1[x]);
                                    counterSearchResults++;
                                }
                                else if((xYears==apoYearInt) && (xMonths==apoMonthInt) && (xDays>=apoDaysInt))
                                {
                                    searchResultsFinal[counterSearchResults]=(sData1[x]);
                                    counterSearchResults++;
                                }
                            }
                        }
                    }
                    System.out.println();
                    if(counterSearchResults!=0)
                    {
                        // Ενεργοποίηση φόρμας (datreLijis2)
                        new dateLijis2().setVisible(true);
                        counterSearchResults=0;
                    }
                    else
                    {
                        // Μνμ ότι δεν βρέθηκαν αποτελέσματα
                        JOptionPane.showMessageDialog(null,"Δεν βρέθηκαν αποτελέσματα για τις συγκεκριμένες ημερωμηνίες","Warning",
                        JOptionPane.WARNING_MESSAGE);
                    }

                }
                catch(Exception e)
                {
                    // Μνμ σφάλματος κατα την αναζήτηση
                    JOptionPane.showMessageDialog(null,"Προέκυψε σφάλμα κατά την αναζήτηση","Warning",
                    JOptionPane.WARNING_MESSAGE);
                    System.out.println(e);
                }

            }
            
            // Λανθασμένη πληκτρολόγηση πεδίων ημερομηνιών
            else
            {
                if(apo.length()<10)
                {
                    // Λάθος ημερομηνία Από
                    JOptionPane.showMessageDialog(null,"Λανθασμένη πληκτρολόγηση ημερωμηνίας (Ημερομηνία Από:)","Warning",
                    JOptionPane.WARNING_MESSAGE);
                }
                else
                {
                    // Λάθος ημερομηνία Έως
                    JOptionPane.showMessageDialog(null,"Λανθασμένη πληκτρολόγηση ημερωμηνίας (Ημερομηνία Έως:)","Warning",
                    JOptionPane.WARNING_MESSAGE);
                }
            }
        }
    }//GEN-LAST:event_Final_Button_EnimerosiActionPerformed

    private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField1ActionPerformed

    }//GEN-LAST:event_jTextField1ActionPerformed

    
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
            java.util.logging.Logger.getLogger(dateLijis.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(dateLijis.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(dateLijis.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(dateLijis.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new dateLijis().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Final_Button_Enimerosi;
    private javax.swing.JFormattedTextField jFormattedTextField2;
    private javax.swing.JFormattedTextField jFormattedTextField4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField4;
    private javax.swing.JTextField jTextField6;
    private javax.swing.JTextField jTextField7;
    // End of variables declaration//GEN-END:variables
}
