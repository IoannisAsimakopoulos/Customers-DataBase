
package alis.customers;

// Imports

    import static alis.customers.catalogMain.counterEdit;
    import static alis.customers.editCustomers.filter1;
    import static alis.customers.editCustomers.filter2;
    import static alis.customers.editCustomers.filter3;
    import static alis.customers.editCustomers1.epil;
    import static alis.customers.dateLijis2.epil2;
    import java.awt.Color;
    import java.io.BufferedWriter;
    import java.io.File;
    import java.io.FileNotFoundException;
    import java.io.FileWriter;
    import java.io.IOException;
    import java.io.PrintWriter;
    import java.nio.file.Files;
    import java.nio.file.Path;
    import java.nio.file.Paths;
    import java.nio.file.StandardCopyOption;
    import java.util.Scanner;
    import javax.swing.JOptionPane;

// Τέλος Imports

public class editCustomers2 extends javax.swing.JFrame {

    // Τοπικές Μεταβλητές Φόρμας
    
        static String [] everything = new String[49]; // Πίνακας μετβλητών που υπάρχουν στο Txt file
        static String oldEpon;                  // Παλαιά Επωνυμία
        static String oldTitle;                 // Παλαιός Τίτλος
        static String initEpon;                 // Επωνυμία κατα το Initialize της Φόρμας
        static String initTitle;                // Τίτλος κατα το Initialize της Φόρμας
        static String string13="";              // Αρχικοποίηση String (Περιέχει το λεκτικό του Πρώτου πακέτου καλήψεων μας)
        static String string17="";              // Αρχικοποίηση String (Περιέχει το λεκτικό του Δεύτερου πακέτου καλήψεων μας)
        static String string21="";              // Αρχικοποίηση String (Περιέχει το λεκτικό του Τρίτου πακέτου καλήψεων μας)
        static String string25="";              // Αρχικοποίηση String (Περιέχει το λεκτικό του Τέταρτου πακέτου καλήψεων μας)
        static String string29="";              // Αρχικοποίηση String (Περιέχει το λεκτικό του Πέμπτου πακέτου καλήψεων μας)
        static String string33="";              // Αρχικοποίηση String (Περιέχει το λεκτικό του Έκτου πακέτου καλήψεων μας)
        static String string37="";              // Αρχικοποίηση String (Περιέχει το λεκτικό του Έβδομου πακέτου καλήψεων μας)
        static String string41="";              // Αρχικοποίηση String (Περιέχει το λεκτικό του Όγδοου πακέτου καλήψεων μας)
        static String string45="";              // Αρχικοποίηση String (Περιέχει το λεκτικό του Ένατου πακέτου καλήψεων μας)
        String [] sData = new String [49];      // Πίνακας με τις τιμές της Φόρμας αφότου έχουν Τροποποιηθεί
        
    // Τέλος Τοπικών Μεταβλητών Φόρμας
        
        
    // Μέθοδος που δημιουργεί txt αρχείο        
    public void createTxt() throws FileNotFoundException, IOException
    {
        // δημιουργεία txt file (για καταχώριση γενικών στοιχείων πελάτη)
        try
        {
            File myObj = new File("c:\\JohnProject\\Στοιχεία Πελατών\\Γενικά Στοιχεία\\"+jTextField7.getText()+" (Γενικά Στοιχεία).txt");
            Scanner myReader = new Scanner(myObj);
            String [] data = new String[49];
            for (int x=0; myReader.hasNextLine(); x++) 
            {  
              data[x] = myReader.nextLine();
            }
            myReader.close();
            boolean found=false;
            if(everything[0].equals(data[0].replace('_',' ')))
            {
                found=true;
            }
            //String courentName  = data[0];
            for(int x=0; x<49; x++)
            {   
                data[x]=everything[x].trim();
            }
            if(found==true)
            {
                FileWriter myWriter = new FileWriter("c:\\JohnProject\\Στοιχεία Πελατών\\Γενικά Στοιχεία\\"+jTextField7.getText()+" (Γενικά Στοιχεία).txt");
                for(int x=0; x<4; x++)
                {
                    if(everything[x].equals(""))
                    {
                        if((everything.length)-1==x)
                        {
                            myWriter.write(";");
                        }
                        else
                        {
                            myWriter.write(";"+"\n");
                        }    
                    }
                    else
                    {
                        if((everything.length)-1==x)
                        {
                            myWriter.write(everything[x].replace(' ','_'));
                        }
                        else
                        {
                            myWriter.write(everything[x].replace(' ','_')+"\n");
                        }
                    }
                }
                myWriter.close();
                System.out.println("Successfully wrote to the file.");
            } 
        }
        // ERROR MESAGE
        catch(Exception e)
        {
            System.out.println("An error occurred. Please try again..."); 
        }
    }    
        
    public void init()
    {
        jTextField7.setEnabled(false);
        jPanel3.setVisible(false);
        if (counterEdit==true)
        {
            readArray(epil);
        }
        else if(counterEdit==false)
        {
            readArray(epil2);
        }
        
        /*
        if(filter1==true)
        {
            readArray(epil);
        }
        else if(filter2==true)
        {
            readArray(epil);
        }   
        else if(filter3==true)
        {
            readArray(epil);
        }
        */
    }
    // ΜΕΘΟΔΟΣ ΓΙΑ ΝΑ ΚΆΝΕΙ READ ΑΠΟ ΕΝΑ tXT FILE ΚΑΙ ΝΑ ΡΙΧΝΕΙ ΤΙΣ ΤΙΜΕΣ ΤΟΥ ΣΕ ΕΝΑ ARRAY STRING
            // Για όλα τα ComboBoxes στον κώδικα αλλά και για το jList2
            // Read anything.txt
            public  void readArray(String epil)
            {
                // Bήμα 1:
                    // Count how many lines are in the file
                // Βήμα 2:
                    //Create the array and copy the elements in it
                int counter1=0;
                try
                {
                    Scanner s1 = new Scanner(new File("c:\\JohnProject\\Στοιχεία Πελατών\\Γενικά Στοιχεία\\"+epil+" (Γενικά Στοιχεία).txt"));
                    int x3=1;
                    while(s1.hasNextLine())
                    {
                        counter1++;
                        s1.nextLine();
                        x3++;
                    }
                    
                    //String [] everything = new String[counter1];
                    Scanner s2 = new Scanner(new File("c:\\JohnProject\\Στοιχεία Πελατών\\Γενικά Στοιχεία\\"+epil+" (Γενικά Στοιχεία).txt"));
                    for(int i=0; i<counter1; i++)
                    {
                        everything[i]= s2.next();
                        everything[i]=everything[i].replace('_',' ');
                    }
                    //  Eπαναφορά Βασικών Στοιχείων
                    initEpon=(everything[0].replace('_',' '));                                           // Επωνυμία στο Initialize 
                    initTitle=(everything[1].replace('_',' '));                                          // Τίτλος στο Initialize
                    jTextField3.setText(everything[0].replace(';',' ').replace('_',' '));                // Όνομα 
                    jTextField5.setText(everything[1].replace(';',' ').replace('_',' '));                // Τίτλος   
                    jTextField7.setText(everything[2].replace(';',' ').replace('_',' '));                // Κωδικός
                    jTextField11.setText(everything[3].replace(';',' ').replace('_',' '));               // Κινητό
                    jTextField9.setText(everything[4].replace(';',' ').replace('_',' '));                // Τηλέφωνο
                    jFormattedTextField6.setText(everything[5].replace(';',' ').replace('_',' '));       // Αριθμός Χειριστών
                    jTextField13.setText(everything[6].replace(';',' ').replace('_',' '));               // Ε-mail
                    jTextField15.setText(everything[7].replace(';',' ').replace('_',' '));               // Διεύθηνση 1
                    jTextField33.setText(everything[8].replace(';',' ').replace('_',' '));               // Διεύθηνση 2
                    jTextField36.setText(everything[9].replace(';',' ').replace('_',' '));               // TK
                    jTextField19.setText(everything[10].replace(';',' ').replace('_',' '));              // ΑΦΜ
                    jTextField21.setText(everything[11].replace(';',' ').replace('_',' '));              // ΔΟΥ
                    jTextField23.setText(everything[12].replace(';',' ').replace('_',' '));              // Όνομα Υπαλλήλου
                    //  Τέλος Επαναφοράς Βασικών Στοιχείων
                    
                    // Επαναφορά Οικονομικών Στοιχείων
                    if(everything[13].equals(";"))
                    {                     
                    }
                    else
                    {
                        jCheckBox1.setSelected(true);
                        jPanel4.setBackground(Color.green.darker());
                        string13="yes";
                    }
                    if(everything[17].equals(";"))
                    {
                    }
                    else
                    {
                        jPanel5.setBackground(Color.green.darker());
                        jCheckBox2.setSelected(true);
                        string17="yes";
                    }
                    if(everything[21].equals(";"))
                    {
                    }
                    else
                    {
                        jPanel6.setBackground(Color.green.darker());
                        jCheckBox3.setSelected(true);
                        string21="yes";
                    }
                    if(everything[25].equals(";"))
                    {
                    }
                    else
                    {
                        jPanel7.setBackground(Color.green.darker());
                        jCheckBox4.setSelected(true);
                        string25="yes";
                    }
                    if(everything[29].equals(";"))
                    {
                    }
                    else
                    {
                        jPanel8.setBackground(Color.green.darker());
                        jCheckBox5.setSelected(true);
                        string29="yes";
                    }
                    if(everything[33].equals(";"))
                    {
                    }
                    else
                    {
                        jPanel9.setBackground(Color.green.darker());
                        jCheckBox6.setSelected(true);
                        string33="yes";
                    }
                    if(everything[37].equals(";"))
                    {
                    }
                    else
                    {
                        jPanel10.setBackground(Color.green.darker());
                        jCheckBox7.setSelected(true);
                        string37="yes";
                    }
                    if(everything[41].equals(";"))
                    {
                    }
                    else
                    {
                        jPanel11.setBackground(Color.green.darker());
                        jCheckBox8.setSelected(true);
                        string41="yes";
                    }
                    if(everything[45].equals(";"))
                    {
                    }
                    else
                    {
                        jPanel12.setBackground(Color.green.darker());
                        jCheckBox9.setSelected(true);
                        string45="yes";
                    }
                    // Τέλος επαναφοράς οικονομικών Στοιχείων
                    /*
                    String[]everything1=new String[everything.length];
                    for(int x=0; x<everything.length; x++)
                    {
                        everything1[x]=everything[x];
                        System.out.println(everything1[x]);
                    }
                    */
                    String [] onSxolia = new String[1000];
                    int counterSxolia=0;
                    //onSxolia.equals(jTextField7.getText());
                    File file5 = new File("c:\\JohnProject\\Στοιχεία Πελατών\\Σχόλια\\"+jTextField7.getText()+".txt");
                    if(file5.exists()) // το file υπάρχει
                    { 
                        File myObj2 = new File("c:\\JohnProject\\Στοιχεία Πελατών\\Σχόλια\\"+jTextField7.getText()+".txt");
                        Scanner myReader = new Scanner(myObj2);
                        while(myReader.hasNext()) 
                        {
                            onSxolia[counterSxolia]=myReader.next();
                            counterSxolia++;
                        }
                        String finalSxolia="";
                        for(int x=0; x<counterSxolia; x++)
                        {
                            finalSxolia = finalSxolia.concat(onSxolia[x].replace('_',' ')+"\n");
                        }
                        jTextArea1.setText(finalSxolia);
                    }
                }
                catch(FileNotFoundException e)
                {
                    //JOptionPane.showMessageDialog(null,"Δεν βρέθηκε αρχείο: 'Τραπέζια.txt'","Warning",
                    JOptionPane.showMessageDialog(null,"Προέκυψε Σφάλμα","Warning",
                    JOptionPane.WARNING_MESSAGE);
                    this.dispose();
                }
            }
    // ΤΕΛΟΣ ΜΕΘΟΔΟΥ
    public editCustomers2() {
        initComponents();
        init();
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTextField24 = new javax.swing.JTextField();
        jTextField26 = new javax.swing.JTextField();
        jTextField27 = new javax.swing.JTextField();
        jTextField31 = new javax.swing.JTextField();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jTextField1 = new javax.swing.JTextField();
        jTextField2 = new javax.swing.JTextField();
        jTextField3 = new javax.swing.JTextField();
        jTextField4 = new javax.swing.JTextField();
        jTextField5 = new javax.swing.JTextField();
        jTextField6 = new javax.swing.JTextField();
        jTextField7 = new javax.swing.JTextField();
        jTextField8 = new javax.swing.JTextField();
        jTextField9 = new javax.swing.JTextField();
        jTextField10 = new javax.swing.JTextField();
        jTextField11 = new javax.swing.JTextField();
        jTextField13 = new javax.swing.JTextField();
        jTextField14 = new javax.swing.JTextField();
        jTextField16 = new javax.swing.JTextField();
        jTextField17 = new javax.swing.JTextField();
        jTextField18 = new javax.swing.JTextField();
        jTextField19 = new javax.swing.JTextField();
        jTextField20 = new javax.swing.JTextField();
        jTextField21 = new javax.swing.JTextField();
        jTextField22 = new javax.swing.JTextField();
        jTextField23 = new javax.swing.JTextField();
        Final_Button_Enimerosi = new javax.swing.JButton();
        jTextField25 = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jCheckBox1 = new javax.swing.JCheckBox();
        jCheckBox2 = new javax.swing.JCheckBox();
        jCheckBox3 = new javax.swing.JCheckBox();
        jCheckBox4 = new javax.swing.JCheckBox();
        jCheckBox5 = new javax.swing.JCheckBox();
        jCheckBox6 = new javax.swing.JCheckBox();
        jCheckBox7 = new javax.swing.JCheckBox();
        jCheckBox9 = new javax.swing.JCheckBox();
        jPanel3 = new javax.swing.JPanel();
        jTextField28 = new javax.swing.JTextField();
        jTextField29 = new javax.swing.JTextField();
        jTextField30 = new javax.swing.JTextField();
        jTextField34 = new javax.swing.JTextField();
        Final_Button_Enimerosi10 = new javax.swing.JButton();
        jFormattedTextField2 = new javax.swing.JFormattedTextField();
        jFormattedTextField4 = new javax.swing.JFormattedTextField();
        jTextField37 = new javax.swing.JTextField();
        jFormattedTextField6 = new javax.swing.JFormattedTextField();
        jPanel4 = new javax.swing.JPanel();
        Final_Button_Enimerosi1 = new javax.swing.JButton();
        jPanel5 = new javax.swing.JPanel();
        Final_Button_Enimerosi2 = new javax.swing.JButton();
        jPanel6 = new javax.swing.JPanel();
        Final_Button_Enimerosi3 = new javax.swing.JButton();
        jPanel7 = new javax.swing.JPanel();
        Final_Button_Enimerosi4 = new javax.swing.JButton();
        jPanel8 = new javax.swing.JPanel();
        Final_Button_Enimerosi5 = new javax.swing.JButton();
        jPanel9 = new javax.swing.JPanel();
        Final_Button_Enimerosi6 = new javax.swing.JButton();
        jPanel10 = new javax.swing.JPanel();
        Final_Button_Enimerosi7 = new javax.swing.JButton();
        jPanel11 = new javax.swing.JPanel();
        Final_Button_Enimerosi8 = new javax.swing.JButton();
        jCheckBox8 = new javax.swing.JCheckBox();
        jPanel12 = new javax.swing.JPanel();
        Final_Button_Enimerosi9 = new javax.swing.JButton();
        jTextField32 = new javax.swing.JTextField();
        jTextField33 = new javax.swing.JTextField();
        jTextField35 = new javax.swing.JTextField();
        jTextField36 = new javax.swing.JTextField();
        jTextField15 = new javax.swing.JTextField();

        jTextField24.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jTextField24.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField24.setText("Διεύθυνση 2");
        jTextField24.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        jTextField24.setCaretColor(new java.awt.Color(255, 255, 204));
        jTextField24.setDisabledTextColor(new java.awt.Color(255, 255, 204));
        jTextField24.setFocusable(false);
        jTextField24.setRequestFocusEnabled(false);
        jTextField24.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField24ActionPerformed(evt);
            }
        });

        jTextField26.setFont(new java.awt.Font("Tahoma", 1, 15)); // NOI18N
        jTextField26.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField26.setBorder(null);
        jTextField26.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField26ActionPerformed(evt);
            }
        });

        jTextField27.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jTextField27.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField27.setText("ΤΚ");
        jTextField27.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        jTextField27.setCaretColor(new java.awt.Color(255, 255, 204));
        jTextField27.setDisabledTextColor(new java.awt.Color(255, 255, 204));
        jTextField27.setFocusable(false);
        jTextField27.setRequestFocusEnabled(false);
        jTextField27.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField27ActionPerformed(evt);
            }
        });

        jTextField31.setFont(new java.awt.Font("Tahoma", 1, 15)); // NOI18N
        jTextField31.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField31.setBorder(null);

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 204));

        jPanel2.setBackground(new java.awt.Color(211, 238, 255));

        jTextField1.setFont(new java.awt.Font("Tahoma", 0, 21)); // NOI18N
        jTextField1.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField1.setText("Τροποποίηση Καρτέλας Στοιχείων Πελάτη");
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

        jTextField2.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jTextField2.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField2.setText("*Επωνυμία");
        jTextField2.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        jTextField2.setCaretColor(new java.awt.Color(255, 255, 204));
        jTextField2.setDisabledTextColor(new java.awt.Color(255, 255, 204));
        jTextField2.setFocusable(false);
        jTextField2.setRequestFocusEnabled(false);
        jTextField2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField2ActionPerformed(evt);
            }
        });

        jTextField3.setFont(new java.awt.Font("Tahoma", 1, 15)); // NOI18N
        jTextField3.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField3.setBorder(null);
        jTextField3.setDisabledTextColor(new java.awt.Color(51, 51, 51));

        jTextField4.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jTextField4.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField4.setText("*Τίτλος");
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

        jTextField5.setFont(new java.awt.Font("Tahoma", 1, 15)); // NOI18N
        jTextField5.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField5.setBorder(null);
        jTextField5.setDisabledTextColor(new java.awt.Color(51, 51, 51));
        jTextField5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField5ActionPerformed(evt);
            }
        });

        jTextField6.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jTextField6.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField6.setText("*Κωδικός");
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

        jTextField7.setFont(new java.awt.Font("Tahoma", 1, 15)); // NOI18N
        jTextField7.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField7.setBorder(null);
        jTextField7.setDisabledTextColor(new java.awt.Color(51, 51, 51));

        jTextField8.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jTextField8.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField8.setText("Τηλέφωνο");
        jTextField8.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        jTextField8.setCaretColor(new java.awt.Color(255, 255, 204));
        jTextField8.setDisabledTextColor(new java.awt.Color(255, 255, 204));
        jTextField8.setFocusable(false);
        jTextField8.setRequestFocusEnabled(false);
        jTextField8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField8ActionPerformed(evt);
            }
        });

        jTextField9.setFont(new java.awt.Font("Tahoma", 1, 15)); // NOI18N
        jTextField9.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField9.setBorder(null);
        jTextField9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField9ActionPerformed(evt);
            }
        });

        jTextField10.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jTextField10.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField10.setText("Κινητό");
        jTextField10.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        jTextField10.setCaretColor(new java.awt.Color(255, 255, 204));
        jTextField10.setDisabledTextColor(new java.awt.Color(255, 255, 204));
        jTextField10.setFocusable(false);
        jTextField10.setRequestFocusEnabled(false);
        jTextField10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField10ActionPerformed(evt);
            }
        });

        jTextField11.setFont(new java.awt.Font("Tahoma", 1, 15)); // NOI18N
        jTextField11.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField11.setBorder(null);

        jTextField13.setFont(new java.awt.Font("Tahoma", 1, 15)); // NOI18N
        jTextField13.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField13.setBorder(null);

        jTextField14.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jTextField14.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField14.setText("Χειριστές (Πλήθος -Νούμερο)");
        jTextField14.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        jTextField14.setCaretColor(new java.awt.Color(255, 255, 204));
        jTextField14.setDisabledTextColor(new java.awt.Color(255, 255, 204));
        jTextField14.setFocusable(false);
        jTextField14.setRequestFocusEnabled(false);
        jTextField14.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField14ActionPerformed(evt);
            }
        });

        jTextField16.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jTextField16.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField16.setText("Διεύθυνση 1");
        jTextField16.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        jTextField16.setCaretColor(new java.awt.Color(255, 255, 204));
        jTextField16.setDisabledTextColor(new java.awt.Color(255, 255, 204));
        jTextField16.setFocusable(false);
        jTextField16.setRequestFocusEnabled(false);
        jTextField16.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField16ActionPerformed(evt);
            }
        });

        jTextField17.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jTextField17.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField17.setText("E-Mail");
        jTextField17.setBorder(null);

        jTextField18.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jTextField18.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField18.setText("ΑΦΜ");
        jTextField18.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        jTextField18.setCaretColor(new java.awt.Color(255, 255, 204));
        jTextField18.setDisabledTextColor(new java.awt.Color(255, 255, 204));
        jTextField18.setFocusable(false);
        jTextField18.setRequestFocusEnabled(false);
        jTextField18.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField18ActionPerformed(evt);
            }
        });

        jTextField19.setFont(new java.awt.Font("Tahoma", 1, 15)); // NOI18N
        jTextField19.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField19.setBorder(null);

        jTextField20.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jTextField20.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField20.setText("ΔΟΥ");
        jTextField20.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        jTextField20.setCaretColor(new java.awt.Color(255, 255, 204));
        jTextField20.setDisabledTextColor(new java.awt.Color(255, 255, 204));
        jTextField20.setFocusable(false);
        jTextField20.setRequestFocusEnabled(false);
        jTextField20.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField20ActionPerformed(evt);
            }
        });

        jTextField21.setFont(new java.awt.Font("Tahoma", 1, 15)); // NOI18N
        jTextField21.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField21.setBorder(null);

        jTextField22.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jTextField22.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField22.setText("Όνομα Υπαλλήλου");
        jTextField22.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        jTextField22.setCaretColor(new java.awt.Color(255, 255, 204));
        jTextField22.setDisabledTextColor(new java.awt.Color(255, 255, 204));
        jTextField22.setFocusable(false);
        jTextField22.setRequestFocusEnabled(false);
        jTextField22.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField22ActionPerformed(evt);
            }
        });

        jTextField23.setFont(new java.awt.Font("Tahoma", 1, 15)); // NOI18N
        jTextField23.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField23.setBorder(null);

        Final_Button_Enimerosi.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        Final_Button_Enimerosi.setText("Ενημέρωση Καρτέλας Πελάτη");
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

        jTextField25.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jTextField25.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField25.setText("Σχόλια:");
        jTextField25.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jTextField25.setCaretColor(new java.awt.Color(255, 255, 204));
        jTextField25.setDisabledTextColor(new java.awt.Color(255, 255, 204));
        jTextField25.setFocusable(false);
        jTextField25.setRequestFocusEnabled(false);
        jTextField25.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField25ActionPerformed(evt);
            }
        });

        jTextArea1.setColumns(20);
        jTextArea1.setFont(new java.awt.Font("Arial Nova", 0, 22)); // NOI18N
        jTextArea1.setRows(5);
        jTextArea1.setBorder(null);
        jScrollPane1.setViewportView(jTextArea1);

        jCheckBox1.setBackground(new java.awt.Color(211, 238, 255));
        jCheckBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox1ActionPerformed(evt);
            }
        });

        jCheckBox2.setBackground(new java.awt.Color(211, 238, 255));
        jCheckBox2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox2ActionPerformed(evt);
            }
        });

        jCheckBox3.setBackground(new java.awt.Color(211, 238, 255));
        jCheckBox3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox3ActionPerformed(evt);
            }
        });

        jCheckBox4.setBackground(new java.awt.Color(211, 238, 255));
        jCheckBox4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox4ActionPerformed(evt);
            }
        });

        jCheckBox5.setBackground(new java.awt.Color(211, 238, 255));
        jCheckBox5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox5ActionPerformed(evt);
            }
        });

        jCheckBox6.setBackground(new java.awt.Color(211, 238, 255));
        jCheckBox6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox6ActionPerformed(evt);
            }
        });

        jCheckBox7.setBackground(new java.awt.Color(211, 238, 255));
        jCheckBox7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox7ActionPerformed(evt);
            }
        });

        jCheckBox9.setBackground(new java.awt.Color(211, 238, 255));
        jCheckBox9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox9ActionPerformed(evt);
            }
        });

        jTextField28.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jTextField28.setForeground(new java.awt.Color(44, 63, 68));
        jTextField28.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField28.setText("Ημ/νία Έναρξης:");
        jTextField28.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        jTextField28.setCaretColor(new java.awt.Color(255, 255, 204));
        jTextField28.setDisabledTextColor(new java.awt.Color(255, 255, 204));
        jTextField28.setFocusable(false);
        jTextField28.setRequestFocusEnabled(false);
        jTextField28.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField28ActionPerformed(evt);
            }
        });

        jTextField29.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jTextField29.setForeground(new java.awt.Color(44, 63, 68));
        jTextField29.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField29.setText("Ημ/νία Λήξης:");
        jTextField29.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        jTextField29.setCaretColor(new java.awt.Color(255, 255, 204));
        jTextField29.setDisabledTextColor(new java.awt.Color(255, 255, 204));
        jTextField29.setFocusable(false);
        jTextField29.setRequestFocusEnabled(false);
        jTextField29.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField29ActionPerformed(evt);
            }
        });

        jTextField30.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jTextField30.setForeground(new java.awt.Color(44, 63, 68));
        jTextField30.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField30.setText("Ποσό:");
        jTextField30.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        jTextField30.setCaretColor(new java.awt.Color(255, 255, 204));
        jTextField30.setDisabledTextColor(new java.awt.Color(255, 255, 204));
        jTextField30.setFocusable(false);
        jTextField30.setRequestFocusEnabled(false);
        jTextField30.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField30ActionPerformed(evt);
            }
        });

        jTextField34.setBackground(new java.awt.Color(240, 240, 240));
        jTextField34.setFont(new java.awt.Font("Tahoma", 1, 15)); // NOI18N
        jTextField34.setForeground(new java.awt.Color(44, 63, 68));
        jTextField34.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField34.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        jTextField34.setCaretColor(new java.awt.Color(255, 255, 204));
        jTextField34.setDisabledTextColor(new java.awt.Color(255, 255, 204));
        jTextField34.setFocusable(false);
        jTextField34.setRequestFocusEnabled(false);
        jTextField34.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField34ActionPerformed(evt);
            }
        });

        Final_Button_Enimerosi10.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        Final_Button_Enimerosi10.setText("Eνημέρωση");
        Final_Button_Enimerosi10.setAutoscrolls(true);
        Final_Button_Enimerosi10.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        Final_Button_Enimerosi10.setFocusCycleRoot(true);
        Final_Button_Enimerosi10.setFocusPainted(false);
        Final_Button_Enimerosi10.setSelected(true);
        Final_Button_Enimerosi10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Final_Button_Enimerosi10ActionPerformed(evt);
            }
        });

        jFormattedTextField2.setBorder(null);
        jFormattedTextField2.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.DateFormatter(new java.text.SimpleDateFormat("dd/MM/yyyy"))));
        jFormattedTextField2.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jFormattedTextField2.setAutoscrolls(false);
        jFormattedTextField2.setFont(new java.awt.Font("Tahoma", 1, 15)); // NOI18N
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

        jTextField37.setFont(new java.awt.Font("Tahoma", 1, 15)); // NOI18N
        jTextField37.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField37.setBorder(null);
        jTextField37.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField37ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(jTextField34, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap(100, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jTextField28, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jTextField29, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(Final_Button_Enimerosi10, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jFormattedTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 100, Short.MAX_VALUE)
                        .addComponent(jFormattedTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 101, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jTextField30, javax.swing.GroupLayout.DEFAULT_SIZE, 150, Short.MAX_VALUE)
                    .addComponent(jTextField37))
                .addContainerGap(101, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(jTextField34, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(5, 5, 5)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField28, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField29, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField30, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(3, 3, 3)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jFormattedTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jFormattedTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField37, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 8, Short.MAX_VALUE)
                .addComponent(Final_Button_Enimerosi10, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jFormattedTextField6.setBorder(null);
        jFormattedTextField6.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#0"))));
        jFormattedTextField6.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jFormattedTextField6.setFont(new java.awt.Font("Tahoma", 1, 15)); // NOI18N
        jFormattedTextField6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jFormattedTextField6ActionPerformed(evt);
            }
        });

        jPanel4.setBackground(new java.awt.Color(188, 188, 188));

        Final_Button_Enimerosi1.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        Final_Button_Enimerosi1.setText("Alis Insurance SQL");
        Final_Button_Enimerosi1.setAutoscrolls(true);
        Final_Button_Enimerosi1.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        Final_Button_Enimerosi1.setFocusCycleRoot(true);
        Final_Button_Enimerosi1.setFocusPainted(false);
        Final_Button_Enimerosi1.setSelected(true);
        Final_Button_Enimerosi1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Final_Button_Enimerosi1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addComponent(Final_Button_Enimerosi1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(0, 0, 0))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addComponent(Final_Button_Enimerosi1))
        );

        jPanel5.setBackground(new java.awt.Color(188, 188, 188));

        Final_Button_Enimerosi2.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        Final_Button_Enimerosi2.setText("Alis Insurance ΝΕΤ");
        Final_Button_Enimerosi2.setAutoscrolls(true);
        Final_Button_Enimerosi2.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        Final_Button_Enimerosi2.setFocusCycleRoot(true);
        Final_Button_Enimerosi2.setFocusPainted(false);
        Final_Button_Enimerosi2.setSelected(true);
        Final_Button_Enimerosi2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Final_Button_Enimerosi2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(Final_Button_Enimerosi2, javax.swing.GroupLayout.DEFAULT_SIZE, 163, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addComponent(Final_Button_Enimerosi2))
        );

        jPanel6.setBackground(new java.awt.Color(188, 188, 188));

        Final_Button_Enimerosi3.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        Final_Button_Enimerosi3.setText("Alis Ins SQL Lease");
        Final_Button_Enimerosi3.setAutoscrolls(true);
        Final_Button_Enimerosi3.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        Final_Button_Enimerosi3.setFocusCycleRoot(true);
        Final_Button_Enimerosi3.setFocusPainted(false);
        Final_Button_Enimerosi3.setSelected(true);
        Final_Button_Enimerosi3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Final_Button_Enimerosi3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Final_Button_Enimerosi3, javax.swing.GroupLayout.DEFAULT_SIZE, 168, Short.MAX_VALUE)
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addComponent(Final_Button_Enimerosi3))
        );

        jPanel7.setBackground(new java.awt.Color(188, 188, 188));

        Final_Button_Enimerosi4.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        Final_Button_Enimerosi4.setText("Alis Ins NET Lease");
        Final_Button_Enimerosi4.setAutoscrolls(true);
        Final_Button_Enimerosi4.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        Final_Button_Enimerosi4.setFocusCycleRoot(true);
        Final_Button_Enimerosi4.setFocusPainted(false);
        Final_Button_Enimerosi4.setSelected(true);
        Final_Button_Enimerosi4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Final_Button_Enimerosi4ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Final_Button_Enimerosi4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 191, Short.MAX_VALUE)
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                .addGap(0, 5, Short.MAX_VALUE)
                .addComponent(Final_Button_Enimerosi4))
        );

        jPanel8.setBackground(new java.awt.Color(188, 188, 188));

        Final_Button_Enimerosi5.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        Final_Button_Enimerosi5.setText("Alis Import");
        Final_Button_Enimerosi5.setAutoscrolls(true);
        Final_Button_Enimerosi5.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        Final_Button_Enimerosi5.setFocusCycleRoot(true);
        Final_Button_Enimerosi5.setFocusPainted(false);
        Final_Button_Enimerosi5.setSelected(true);
        Final_Button_Enimerosi5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Final_Button_Enimerosi5ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Final_Button_Enimerosi5, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel8Layout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addComponent(Final_Button_Enimerosi5))
        );

        jPanel9.setBackground(new java.awt.Color(188, 188, 188));

        Final_Button_Enimerosi6.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        Final_Button_Enimerosi6.setText("Alis Portal");
        Final_Button_Enimerosi6.setAutoscrolls(true);
        Final_Button_Enimerosi6.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        Final_Button_Enimerosi6.setFocusCycleRoot(true);
        Final_Button_Enimerosi6.setFocusPainted(false);
        Final_Button_Enimerosi6.setSelected(true);
        Final_Button_Enimerosi6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Final_Button_Enimerosi6ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(Final_Button_Enimerosi6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(0, 0, 0))
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel9Layout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addComponent(Final_Button_Enimerosi6))
        );

        jPanel10.setBackground(new java.awt.Color(188, 188, 188));

        Final_Button_Enimerosi7.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        Final_Button_Enimerosi7.setText("ALFA Contract");
        Final_Button_Enimerosi7.setAutoscrolls(true);
        Final_Button_Enimerosi7.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        Final_Button_Enimerosi7.setFocusCycleRoot(true);
        Final_Button_Enimerosi7.setFocusPainted(false);
        Final_Button_Enimerosi7.setSelected(true);
        Final_Button_Enimerosi7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Final_Button_Enimerosi7ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(Final_Button_Enimerosi7, javax.swing.GroupLayout.DEFAULT_SIZE, 156, Short.MAX_VALUE)
                .addGap(0, 0, 0))
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel10Layout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addComponent(Final_Button_Enimerosi7))
        );

        jPanel11.setBackground(new java.awt.Color(188, 188, 188));

        Final_Button_Enimerosi8.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        Final_Button_Enimerosi8.setText("ALFA Protocol");
        Final_Button_Enimerosi8.setAutoscrolls(true);
        Final_Button_Enimerosi8.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        Final_Button_Enimerosi8.setFocusCycleRoot(true);
        Final_Button_Enimerosi8.setFocusPainted(false);
        Final_Button_Enimerosi8.setSelected(true);
        Final_Button_Enimerosi8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Final_Button_Enimerosi8ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel11Layout = new javax.swing.GroupLayout(jPanel11);
        jPanel11.setLayout(jPanel11Layout);
        jPanel11Layout.setHorizontalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(Final_Button_Enimerosi8, javax.swing.GroupLayout.DEFAULT_SIZE, 150, Short.MAX_VALUE)
                .addGap(0, 0, 0))
        );
        jPanel11Layout.setVerticalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel11Layout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addComponent(Final_Button_Enimerosi8)
                .addGap(0, 0, 0))
        );

        jCheckBox8.setBackground(new java.awt.Color(211, 238, 255));
        jCheckBox8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox8ActionPerformed(evt);
            }
        });

        jPanel12.setBackground(new java.awt.Color(188, 188, 188));

        Final_Button_Enimerosi9.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        Final_Button_Enimerosi9.setText("Alis Bridge");
        Final_Button_Enimerosi9.setAutoscrolls(true);
        Final_Button_Enimerosi9.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        Final_Button_Enimerosi9.setFocusCycleRoot(true);
        Final_Button_Enimerosi9.setFocusPainted(false);
        Final_Button_Enimerosi9.setSelected(true);
        Final_Button_Enimerosi9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Final_Button_Enimerosi9ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel12Layout = new javax.swing.GroupLayout(jPanel12);
        jPanel12.setLayout(jPanel12Layout);
        jPanel12Layout.setHorizontalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(Final_Button_Enimerosi9, javax.swing.GroupLayout.DEFAULT_SIZE, 131, Short.MAX_VALUE)
                .addGap(0, 0, 0))
        );
        jPanel12Layout.setVerticalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel12Layout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addComponent(Final_Button_Enimerosi9))
        );

        jTextField32.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jTextField32.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField32.setText("Διεύθυνση 2");
        jTextField32.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        jTextField32.setCaretColor(new java.awt.Color(255, 255, 204));
        jTextField32.setDisabledTextColor(new java.awt.Color(255, 255, 204));
        jTextField32.setFocusable(false);
        jTextField32.setRequestFocusEnabled(false);
        jTextField32.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField32ActionPerformed(evt);
            }
        });

        jTextField33.setFont(new java.awt.Font("Tahoma", 1, 15)); // NOI18N
        jTextField33.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField33.setBorder(null);
        jTextField33.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField33ActionPerformed(evt);
            }
        });

        jTextField35.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jTextField35.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField35.setText("ΤΚ");
        jTextField35.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        jTextField35.setCaretColor(new java.awt.Color(255, 255, 204));
        jTextField35.setDisabledTextColor(new java.awt.Color(255, 255, 204));
        jTextField35.setFocusable(false);
        jTextField35.setRequestFocusEnabled(false);
        jTextField35.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField35ActionPerformed(evt);
            }
        });

        jTextField36.setFont(new java.awt.Font("Tahoma", 1, 15)); // NOI18N
        jTextField36.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField36.setBorder(null);

        jTextField15.setFont(new java.awt.Font("Tahoma", 1, 15)); // NOI18N
        jTextField15.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField15.setBorder(null);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(Final_Button_Enimerosi, javax.swing.GroupLayout.PREFERRED_SIZE, 494, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(100, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane1)
                    .addComponent(jTextField25, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(2, 2, 2)
                        .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jCheckBox1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(7, 7, 7)
                        .addComponent(jCheckBox2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(10, 10, 10)
                        .addComponent(jCheckBox3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(8, 8, 8)
                        .addComponent(jCheckBox4))
                    .addComponent(jTextField1, javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jPanel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jCheckBox5, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jPanel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jCheckBox6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jPanel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jCheckBox7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jPanel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(7, 7, 7)
                        .addComponent(jCheckBox8, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jCheckBox9))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jTextField18, javax.swing.GroupLayout.DEFAULT_SIZE, 151, Short.MAX_VALUE)
                                .addGap(254, 254, 254))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jTextField8, javax.swing.GroupLayout.DEFAULT_SIZE, 131, Short.MAX_VALUE)
                                .addGap(274, 274, 274))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jTextField6, javax.swing.GroupLayout.DEFAULT_SIZE, 151, Short.MAX_VALUE)
                                .addGap(254, 254, 254))
                            .addComponent(jTextField19, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 236, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextField22)
                            .addComponent(jTextField4)
                            .addComponent(jTextField13, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 256, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jTextField17, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jTextField32, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 131, Short.MAX_VALUE))
                                .addGap(18, 18, 18)
                                .addComponent(jTextField33, javax.swing.GroupLayout.PREFERRED_SIZE, 256, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jTextField9, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 256, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextField7, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 236, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextField2))
                        .addGap(20, 20, 20)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jTextField10)
                                .addGap(18, 18, 18)
                                .addComponent(jTextField11, javax.swing.GroupLayout.PREFERRED_SIZE, 247, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jTextField5)
                            .addComponent(jTextField3)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jTextField14)
                                .addGap(18, 18, 18)
                                .addComponent(jFormattedTextField6, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jTextField20)
                                .addGap(18, 18, 18)
                                .addComponent(jTextField21))
                            .addComponent(jTextField23, javax.swing.GroupLayout.DEFAULT_SIZE, 427, Short.MAX_VALUE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jTextField35)
                                    .addComponent(jTextField16))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jTextField15, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 247, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jTextField36, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 248, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                .addContainerGap(100, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap(20, Short.MAX_VALUE)
                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 26, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jTextField2, javax.swing.GroupLayout.DEFAULT_SIZE, 33, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jTextField6, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextField7, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jTextField8, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextField9, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTextField17, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                .addComponent(jTextField13, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(1, 1, 1)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jTextField33, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextField32, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(7, 7, 7)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jTextField18, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextField19, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextField22, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jTextField3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextField5, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jTextField11, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextField10, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTextField14, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jFormattedTextField6, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jTextField16, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextField15, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTextField35, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextField36, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 1, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jTextField21, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jTextField20, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextField23, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jCheckBox2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jCheckBox3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jCheckBox4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(jCheckBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(6, 6, 6)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addComponent(jCheckBox7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(18, 18, 18))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addGroup(jPanel2Layout.createSequentialGroup()
                                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(jPanel12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jPanel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jCheckBox8, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jCheckBox6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                    .addGap(3, 3, 3))
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jCheckBox5, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(jPanel10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jCheckBox9, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, Short.MAX_VALUE)))
                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 16, Short.MAX_VALUE)
                .addComponent(jTextField25, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, Short.MAX_VALUE)
                .addComponent(Final_Button_Enimerosi, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(19, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(130, Short.MAX_VALUE)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap(129, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(42, Short.MAX_VALUE)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap(44, Short.MAX_VALUE))
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

    private void jTextField2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField2ActionPerformed

    }//GEN-LAST:event_jTextField2ActionPerformed

    private void jTextField4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField4ActionPerformed

    private void jTextField5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField5ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField5ActionPerformed

    private void jTextField6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField6ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField6ActionPerformed

    private void jTextField8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField8ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField8ActionPerformed

    private void jTextField9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField9ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField9ActionPerformed

    private void jTextField10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField10ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField10ActionPerformed

    private void jTextField14ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField14ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField14ActionPerformed

    private void jTextField16ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField16ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField16ActionPerformed

    private void jTextField18ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField18ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField18ActionPerformed

    private void jTextField20ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField20ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField20ActionPerformed

    private void jTextField22ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField22ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField22ActionPerformed

    private void Final_Button_EnimerosiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Final_Button_EnimerosiActionPerformed

        
        String str1="";
        String str2="";
        String str3="";
        
        oldEpon  = everything[0];
        oldTitle = everything[1];
        str1 = jTextField3.getText();
        str2 = jTextField5.getText();
        str3 = jTextField7.getText();

        try
        {
            if(str1.equals("") || str2.equals("")||str3.equals(""))
            {
                // μνμ για συμπλήρωση υποχρεωτικών πεδίων
                JOptionPane.showMessageDialog(null,"Παρακαλώ συμπληρώστε ΌΛΑ τα υποχρεωτικά πεδία (Επωνυμία - Τίτλος - Κωδικός)");
            }
            else
            {
                everything[0]  = jTextField3.getText();
                everything[1]  = jTextField5.getText();
                boolean changed1=false;
                boolean changed2=false;
                if(everything[0].equals(initEpon))
                {
                    changed1=false;
                }
                else
                {
                    changed1=true;
                }
                if(everything[1].equals(initTitle))
                {
                    changed2=false;
                }
                else
                {
                    changed2=true;
                }
                
                boolean catach=false;
                if(changed1==true || changed2==true)
                {
                    if(changed1==true && changed2==true)
                    {
                        File myObj = new File("c:\\JohnProject\\Στοιχεία Πελατών\\Επωνυμίες\\Επωνυμίες.txt");
                        Scanner myReader = new Scanner(myObj);
                        int counterData1=0;
                        String [] sData1 = new String [5000];
                        for(int x=0; x<5000; x++)
                        {
                            sData1[x]="";
                        }
                        boolean found11=false;
                        while (myReader.hasNext()) 
                        {
                            sData1[counterData1]=myReader.next();
                            counterData1++;
                        }
                        System.out.println(counterData1);
                        System.out.println(sData1[0]);
                        System.out.println(sData1[1]);
                        for(int x=0; x<counterData1; x++)
                        {
                            if(sData1[x].equals(jTextField3.getText().replace(' ','_')))
                            {
                                found11=true;
                            }
                        }
                        if(found11==false)
                        {    
                            //String [] data = new String[5000];
                            myReader.close();
                            boolean found=false;
                            //String courentName  = data[0];
                            for(int x=0; x<counterData1; x++)
                            {   
                                if(sData1[x].replace('_',' ').equals(initEpon))
                                {
                                    sData1[x]=everything[0].trim().replace(' ','_');
                                    found=true;
                                }    
                            }
                            /*
                            if(found==true && found11==false)
                            {
                                FileWriter myWriter = new FileWriter("c:\\JohnProject\\Στοιχεία Πελατών\\Επωνυμίες\\Επωνυμίες.txt");
                                for(int x=0; x<counterData; x++)
                                {
                                    if((counterData)-1==x)
                                    {
                                        myWriter.write(sData[x]);
                                    }
                                    else
                                    {
                                        myWriter.write(sData[x]+"\n");
                                    }
                                }
                                myWriter.close();
                            }
                            */

                            File myObj2 = new File("c:\\JohnProject\\Στοιχεία Πελατών\\Τίτλοι\\Τίτλοι.txt");
                            myReader = new Scanner(myObj2);
                            int counterData2=0;
                            String [] sData2 = new String [5000];
                            for(int x=0; x<5000; x++)
                            {
                                sData2[x]="";
                            }
                            while (myReader.hasNext()) 
                            {
                                sData2[counterData2]=myReader.next();
                                counterData2++;
                            }
                            boolean found21=false;
                            for(int x=0; x<counterData2; x++)
                            {
                                if(sData2[x].equals(jTextField5.getText().replace(' ','_')))
                                {
                                    found21=true;
                                }
                            }
                            if(found21==false)
                            {    
                                System.out.println(counterData2);
                                //String [] data = new String[5000];
                                myReader.close();
                                boolean found2=false;
                                //String courentName  = data[0];
                                for(int x=0; x<counterData2; x++)
                                {   
                                    if(sData2[x].replace('_',' ').equals(initTitle))
                                    {
                                        sData2[x]=everything[1].trim().replace(' ','_');
                                        found2=true;
                                    }    
                                }

                                if(found2==true && found21==false)
                                {
                                    FileWriter myWriter = new FileWriter("c:\\JohnProject\\Στοιχεία Πελατών\\Τίτλοι\\Τίτλοι.txt");
                                    for(int x=0; x<counterData2; x++)
                                    {
                                        if((counterData2)-1==x)
                                        {
                                            myWriter.write(sData2[x]+"\n");
                                        }
                                        else
                                        {
                                            myWriter.write(sData2[x]+"\n");
                                        }
                                    }
                                    myWriter.close();

                                    myWriter = new FileWriter("c:\\JohnProject\\Στοιχεία Πελατών\\Επωνυμίες\\Επωνυμίες.txt");
                                    for(int x=0; x<counterData1; x++)
                                    {
                                        if((counterData1)-1==x)
                                        {
                                            myWriter.write(sData1[x]+"\n");
                                        }
                                        else
                                        {
                                            myWriter.write(sData1[x]+"\n");
                                        }
                                    }
                                    myWriter.close();

                                    changed1=false;
                                    changed2=false;
                                    catach=true;
                                }
                                if(jTextArea1.getText().length()==0)
                                {
                                    
                                }
                                else
                                {
                                    File file5 = new File("c:\\JohnProject\\Στοιχεία Πελατών\\Σχόλια\\"+jTextField7.getText()+".txt");
                                    if (file5.exists())
                                    {
                                        String sxolia = jTextArea1.getText().replace(' ','_');
                                        File fileCreate1= new File("c:\\JohnProject\\Στοιχεία Πελατών\\Σχόλια\\"+jTextField7.getText()+".txt",  "UTF-8");    // create of the file    
                                        FileWriter fileWrite1 = new FileWriter("c:\\JohnProject\\Στοιχεία Πελατών\\Σχόλια\\"+jTextField7.getText()+".txt");  // write of the file
                                        fileWrite1.write(sxolia);
                                        fileWrite1.close(); // ΚΛΕΙΣΙΜΟ FILE    
                                        // ΤΕΛΟΣ ΓΕΜΙΣΜΑΤΟΣ FILE
                                    }
                                    else
                                    {
                                        String sxolia = jTextArea1.getText().replace(' ','_');
                                        File fileCreate1= new File("c:\\JohnProject\\Στοιχεία Πελατών\\Σχόλια\\"+jTextField7.getText()+".txt",  "UTF-8");    // create of the file    
                                        FileWriter fileWrite1 = new FileWriter("c:\\JohnProject\\Στοιχεία Πελατών\\Σχόλια\\"+jTextField7.getText()+".txt");  // write of the file
                                        fileWrite1.write(sxolia);
                                        fileWrite1.close(); // ΚΛΕΙΣΙΜΟ FILE    
                                        // ΤΕΛΟΣ ΓΕΜΙΣΜΑΤΟΣ FILE
                                    }
                                }
                                catach=true;
                                changed1=false;
                                changed2=false;
                                
                            }    
                            else
                            {
                                // μνμ για είδη υπάρχουσα Επωνυμία
                                JOptionPane.showMessageDialog(null,"Ο Tίτλος: ("+jTextField5.getText()+") είναι είδη καταχωρημένος στο σύστημα");
                            }
                        }   
                        else
                        {
                            // μνμ για είδη υπάρχουσα Επωνυμία
                            JOptionPane.showMessageDialog(null,"Η Eπωνυμία: ("+jTextField3.getText()+") είναι είδη καταχωρημένη στο σύστημα");
                        }
                    }
                    else if(changed1==true && changed2==false)
                    {
                        File myObj = new File("c:\\JohnProject\\Στοιχεία Πελατών\\Επωνυμίες\\Επωνυμίες.txt");
                        Scanner myReader = new Scanner(myObj);
                        int counterData1=0;
                        String [] sData1 = new String [5000];
                        for(int x=0; x<5000; x++)
                        {
                            sData1[x]="";
                        }
                        boolean found11=false;
                        while (myReader.hasNext()) 
                        {
                            sData1[counterData1]=myReader.next();
                            counterData1++;
                        }
                        System.out.println(counterData1);
                        System.out.println(sData1[0]);
                        System.out.println(sData1[1]);
                        for(int x=0; x<counterData1; x++)
                        {
                            if(sData1[x].equals(jTextField3.getText().replace(' ','_')))
                            {
                                found11=true;
                            }
                        }
                        if(found11==false)
                        {    
                            //String [] data = new String[5000];
                            myReader.close();
                            boolean found=false;
                            //String courentName  = data[0];
                            for(int x=0; x<counterData1; x++)
                            {   
                                if(sData1[x].replace('_',' ').equals(initEpon))
                                {
                                    sData1[x]=everything[0].trim().replace(' ','_');
                                    found=true;
                                }    
                            }
                            FileWriter myWriter = new FileWriter("c:\\JohnProject\\Στοιχεία Πελατών\\Επωνυμίες\\Επωνυμίες.txt");
                            for(int x=0; x<counterData1; x++)
                            {
                                if((counterData1)-1==x)
                                {
                                    myWriter.write(sData1[x]+"\n");
                                }
                                else
                                {
                                    myWriter.write(sData1[x]+"\n");
                                }
                            }
                            myWriter.close();
                            changed1=false;
                            changed2=false;
                            //String text = jTextArea1.getText();
                            if(jTextArea1.getText().length()==0)
                            {
                                    
                            }
                            else
                            {
                                File file5 = new File("c:\\JohnProject\\Στοιχεία Πελατών\\Σχόλια\\"+jTextField7.getText()+".txt");
                                if (file5.exists())
                                {
                                    String sxolia = jTextArea1.getText().replace(' ','_');
                                    File fileCreate1= new File("c:\\JohnProject\\Στοιχεία Πελατών\\Σχόλια\\"+jTextField7.getText()+".txt",  "UTF-8");    // create of the file    
                                    FileWriter fileWrite1 = new FileWriter("c:\\JohnProject\\Στοιχεία Πελατών\\Σχόλια\\"+jTextField7.getText()+".txt");  // write of the file
                                    fileWrite1.write(sxolia);
                                    fileWrite1.close(); // ΚΛΕΙΣΙΜΟ FILE    
                                    // ΤΕΛΟΣ ΓΕΜΙΣΜΑΤΟΣ FILE
                                }
                                else
                                {
                                    String sxolia = jTextArea1.getText().replace(' ','_');
                                    File fileCreate1= new File("c:\\JohnProject\\Στοιχεία Πελατών\\Σχόλια\\"+jTextField7.getText()+".txt",  "UTF-8");    // create of the file    
                                    FileWriter fileWrite1 = new FileWriter("c:\\JohnProject\\Στοιχεία Πελατών\\Σχόλια\\"+jTextField7.getText()+".txt");  // write of the file
                                    fileWrite1.write(sxolia);
                                    fileWrite1.close(); // ΚΛΕΙΣΙΜΟ FILE    
                                    // ΤΕΛΟΣ ΓΕΜΙΣΜΑΤΟΣ FILE
                                }
                            }
                        }
                        else if(found11==true)
                        {
                            // μνμ για είδη υπάρχουσα Επωνυμία
                            JOptionPane.showMessageDialog(null,"Η Eπωνυμία: ("+jTextField3.getText()+") είναι είδη καταχωρημένη στο σύστημα");
                        }
                        
                    }
                    else if(changed2==true && changed1==false)
                    {
                        File myObj = new File("c:\\JohnProject\\Στοιχεία Πελατών\\Τίτλοι\\Τίτλοι.txt");
                        Scanner myReader = new Scanner(myObj);
                        int counterData2=0;
                        String [] sData2 = new String [5000];
                        for(int x=0; x<5000; x++)
                        {
                            sData2[x]="";
                        }
                        boolean found21=false;
                        while (myReader.hasNext()) 
                        {
                            sData2[counterData2]=myReader.next();
                            counterData2++;
                        }
                        System.out.println(counterData2);
                        //System.out.println(sData2[0]);
                        //System.out.println(sData2[1]);
                        for(int x=0; x<counterData2; x++)
                        {
                            if(sData2[x].equals(jTextField5.getText().replace(' ','_')))
                            {
                                found21=true;
                            }
                        }
                        if(found21==false)
                        {    
                            //String [] data = new String[5000];
                            myReader.close();
                            boolean found=false;
                            //String courentName  = data[0];
                            for(int x=0; x<counterData2; x++)
                            {   
                                if(sData2[x].equals(initTitle.replace(' ','_')))
                                {
                                    sData2[x]=everything[1].trim().replace(' ','_');
                                    found=true;
                                }    
                            }
                            FileWriter myWriter = new FileWriter("c:\\JohnProject\\Στοιχεία Πελατών\\Τίτλοι\\Τίτλοι.txt");
                            for(int x=0; x<counterData2; x++)
                            {
                                if((counterData2)-1==x)
                                {
                                    myWriter.write(sData2[x]);
                                }
                                else
                                {
                                    myWriter.write(sData2[x]+"\n");
                                }
                            }
                            myWriter.close();

                            changed1=false;
                            changed2=false;
                            catach=true;
                        }
                        else if(found21==true)
                        {
                            // μνμ για είδη υπάρχουσα Επωνυμία
                            JOptionPane.showMessageDialog(null,"Ο Tίτλος: ("+jTextField5.getText()+") είναι είδη καταχωρημένος στο σύστημα");
                        }
                    }
                }
                // Αλλαγή και στο αρχείο των Γενικών Στοιχείων
                if((changed1==false && changed2==false) || catach==true)
                {
                    File myObj = new File("c:\\JohnProject\\Στοιχεία Πελατών\\Γενικά Στοιχεία\\"+jTextField7.getText()+" (Γενικά Στοιχεία).txt");
                    Scanner myReader = new Scanner(myObj);
                    int counterData=0;
                    
                    for(int x=0; x<49; x++)
                    {
                        sData[x]="";
                    }
                    while(myReader.hasNext()) 
                    {
                        sData[counterData]=myReader.next();
                        counterData++;
                    }
                    System.out.println(counterData);
                    //String [] data = new String[5000];
                    myReader.close();
                    boolean found=false;
                    //String courentName  = data[0];
                    
                    sData[0] =jTextField3 .getText().replace(' ','_');    //  Eπωνυμία 
                    sData[1] =jTextField5 .getText().replace(' ','_');    //  Τίτλος
                    sData[2] =jTextField7 .getText().replace(' ','_');    //  Κωδικός
                    sData[3] =jTextField11.getText();                     //  Κινητό
                    //  Διόρθωση Πεδίου
                        if(sData[3].equals("") || sData[3].equals("_")|| sData[3].equals(" "))
                        {
                            sData[3]=";";
                        }
                        else
                        {
                            sData[3]=sData[3].trim().replace(' ','_');
                        }
                    // Τέλος διόρθωσης Πεδίου
                    sData[4] =jTextField9 .getText();                      //  Τηλέφωνο
                    //  Διόρθωση Πεδίου
                        if(sData[4].equals("")|| sData[4].equals("_")|| sData[4].equals(" "))
                        {
                            sData[4]=";";
                        }
                        else
                        {
                            sData[4]=sData[4].trim().replace(' ','_');
                        }
                    // Τέλος διόρθωσης Πεδίου
                    sData[5] =jFormattedTextField6.getText();              //  Πλήθος Χειριστών
                    //  Διόρθωση Πεδίου
                        if(sData[5].equals("")|| sData[5].equals("_")|| sData[5].equals(" "))
                        {
                            sData[5]=";";
                        }
                        else
                        {
                            sData[5]=sData[5].trim().replace(' ','_');
                        }
                    // Τέλος διόρθωσης Πεδίου
                    sData[6] =jTextField13 .getText();                     //  e-amil
                    //  Διόρθωση Πεδίου
                        if(sData[6].equals("")|| sData[6].equals("_")|| sData[6].equals(" "))
                        {
                            sData[6]=";";
                        }
                        else
                        {
                            sData[6]=sData[6].trim().replace(' ','_');
                        }
                    // Τέλος διόρθωσης Πεδίου
                    sData[7] =jTextField15 .getText();                     //  Διεύθηνση 1
                    //  Διόρθωση Πεδίου
                        if(sData[7].equals("")|| sData[7].equals("_")|| sData[7].equals(" "))
                        {
                            sData[7]=";";
                        }
                        else
                        {
                            sData[7]=sData[7].trim().replace(' ','_');
                        }
                    // Τέλος διόρθωσης Πεδίου
                    sData[8] =jTextField33 .getText();                     //  Διεύθηνση 2
                    //  Διόρθωση Πεδίου
                        if(sData[8].equals("")|| sData[8].equals("_")|| sData[8].equals(" "))
                        {
                            sData[8]=";";
                        }
                        else
                        {
                            sData[8]=sData[8].trim().replace(' ','_');
                        }
                    // Τέλος διόρθωσης Πεδίου
                    sData[9] =jTextField36 .getText();                     //  TK
                    //  Διόρθωση Πεδίου
                        if(sData[9].equals("")|| sData[9].equals("_")|| sData[9].equals(" "))
                        {
                            sData[9]=";";
                        }
                        else
                        {
                            sData[9]=sData[9].trim().replace(' ','_');
                        }
                    // Τέλος διόρθωσης Πεδίου
                    sData[10] =jTextField19 .getText();                     //  ΑΦΜ
                    //  Διόρθωση Πεδίου
                        if(sData[10].equals("")|| sData[10].equals("_")|| sData[10].equals(" "))
                        {
                            sData[10]=";";
                        }
                        else
                        {
                            sData[10]=sData[10].trim().replace(' ','_');
                        }
                    // Τέλος διόρθωσης Πεδίου
                    sData[11] =jTextField21 .getText();                     //  ΔΟΥ
                    //  Διόρθωση Πεδίου
                        if(sData[11].equals("")|| sData[11].equals("_")|| sData[11].equals(" "))
                        {
                            sData[11]=";";
                        }
                        else
                        {
                            sData[11]=sData[11].trim().replace(' ','_');
                        }
                    // Τέλος διόρθωσης Πεδίου
                    sData[12]=jTextField23 .getText();                     //  Όνομα Υπαλλήλου
                    //  Διόρθωση Πεδίου
                        if(sData[12].equals("")|| sData[12].equals("_")|| sData[12].equals(" "))
                        {
                            sData[12]=";";
                        }
                        else
                        {
                            sData[12]=sData[12].trim().replace(' ','_');
                        }
                    // Τέλος διόρθωσης Πεδίου
                    
                    
                    if(everything[13].equals("") || everything[13].equals(";"))
                    {
                        sData[13]=";";
                        sData[14]=";";
                        sData[15]=";";
                        sData[16]=";"; 
                    }
                    else
                    {
                        sData[13] = "Alis Insurance SQL";
                        sData[13] = sData     [13].replace(' ','_');
                        sData[14] = everything[14].replace(';',' ');
                        sData[15] = everything[15].replace(';',' ');
                        sData[16] = everything[16].replace(';',' ');
                    }
                    
                    if(everything[17].equals("") || everything[17].equals(";"))
                    {
                        sData[17]=";";
                        sData[18]=";";
                        sData[19]=";";
                        sData[20]=";"; 
                    }
                    else
                    {
                        sData[17] = "Alis Insurance ΝΕΤ";
                        sData[17] = sData     [17].replace(' ','_');
                        sData[18] = everything[18].replace(';',' ');
                        sData[19] = everything[19].replace(';',' ');
                        sData[20] = everything[20].replace(';',' ');
                    }
                    
                    if(everything[21].equals("") || everything[21].equals(";"))
                    {
                        sData[21]=";";
                        sData[22]=";";
                        sData[23]=";";
                        sData[24]=";"; 
                    }
                    else
                    {
                        sData[21] = "Alis Ins SQL Lease";
                        sData[21] = sData     [21].replace(' ','_');
                        sData[22] = everything[22].replace(';',' ');
                        sData[23] = everything[23].replace(';',' ');
                        sData[24] = everything[24].replace(';',' ');
                    }
                    
                    if(everything[25].equals("") || everything[25].equals(";"))
                    {
                        sData[25]=";";
                        sData[26]=";";
                        sData[27]=";";
                        sData[28]=";"; 
                    }
                    else
                    {
                        sData[25] = "Alis Ins NET Lease";
                        sData[25] = sData     [25].replace(' ','_');
                        sData[26] = everything[26].replace(';',' ');
                        sData[27] = everything[27].replace(';',' ');
                        sData[28] = everything[28].replace(';',' ');
                    }
                    
                    
                    if(everything[29].equals("") || everything[29].equals(";"))
                    {
                        sData[29]=";";
                        sData[30]=";";
                        sData[31]=";";
                        sData[32]=";"; 
                    }
                    else
                    {
                        sData[29] = "Alis Import";
                        sData[29] = sData     [29].replace(' ','_');
                        sData[30] = everything[30].replace(';',' ');
                        sData[31] = everything[31].replace(';',' ');
                        sData[32] = everything[32].replace(';',' ');
                    }
                    
                    if(everything[33].equals("") || everything[33].equals(";"))
                    {
                        sData[33]=";";
                        sData[34]=";";
                        sData[35]=";";
                        sData[36]=";"; 
                    }
                    else
                    {
                        sData[33] = "Alis Portal";
                        sData[33] = sData     [33].replace(' ','_');
                        sData[34] = everything[34].replace(';',' ');
                        sData[35] = everything[35].replace(';',' ');
                        sData[36] = everything[36].replace(';',' ');
                    }
                    
                    
                    if(everything[37].equals("") || everything[37].equals(";"))
                    {
                        sData[37]=";";
                        sData[38]=";";
                        sData[39]=";";
                        sData[40]=";"; 
                    }
                    else
                    {
                        sData[37] = "ALFA Contract";
                        sData[37] = sData     [37].replace(' ','_');
                        sData[38] = everything[38].replace(';',' ');
                        sData[39] = everything[39].replace(';',' ');
                        sData[40] = everything[40].replace(';',' ');
                    }
                    
                    if(everything[41].equals("") || everything[41].equals(";"))
                    {
                        sData[41]=";";
                        sData[42]=";";
                        sData[43]=";";
                        sData[44]=";"; 
                    }
                    else
                    {
                        sData[41] = "ALFA Protocol";
                        sData[41] = sData     [41].replace(' ','_');
                        sData[42] = everything[42].replace(';',' ');
                        sData[43] = everything[43].replace(';',' ');
                        sData[44] = everything[44].replace(';',' ');
                    }
                    
                    if(everything[45].equals("") || everything[45].equals(";"))
                    {
                        sData[45]=";";
                        sData[46]=";";
                        sData[47]=";";
                        sData[48]=";"; 
                    }
                    else
                    {
                        sData[45] = "Alis Bridge";
                        sData[45] = sData     [45].replace(' ','_');
                        sData[46] = everything[46].replace(';',' ');
                        sData[47] = everything[47].replace(';',' ');
                        sData[48] = everything[48].replace(';',' ');
                    }
                    
                    found=true;
                    
                    if(found==true)
                    {
                        FileWriter myWriter = new FileWriter("c:\\JohnProject\\Στοιχεία Πελατών\\Γενικά Στοιχεία\\"+sData[2]+" (Γενικά Στοιχεία).txt");
                        for(int x=0; x<49; x++)
                        {
                            if((sData.length)-1==x) 
                            {
                                myWriter.write(sData[x]);
                            }
                            else
                            {
                                myWriter.write(sData[x]+"\n");
                            }
                        }
                        myWriter.close();
                        //String text = jTextArea1.getText().replace(' ','_');
                        if(jTextArea1.getText().length()==0)
                        {
                                  
                        }
                        else
                        {
                            File file5 = new File("c:\\JohnProject\\Στοιχεία Πελατών\\Σχόλια\\"+jTextField7.getText()+".txt");
                            if (file5.exists())
                            {
                                String sxolia = jTextArea1.getText().replace(' ','_');
                                File fileCreate1= new File("c:\\JohnProject\\Στοιχεία Πελατών\\Σχόλια\\"+jTextField7.getText()+".txt",  "UTF-8");    // create of the file    
                                FileWriter fileWrite1 = new FileWriter("c:\\JohnProject\\Στοιχεία Πελατών\\Σχόλια\\"+jTextField7.getText()+".txt");  // write of the file
                                fileWrite1.write(sxolia);
                                fileWrite1.close(); // ΚΛΕΙΣΙΜΟ FILE    
                                // ΤΕΛΟΣ ΓΕΜΙΣΜΑΤΟΣ FILE
                            }
                            else
                            {
                                String sxolia = jTextArea1.getText().replace(' ','_');
                                File fileCreate1= new File("c:\\JohnProject\\Στοιχεία Πελατών\\Σχόλια\\"+jTextField7.getText()+".txt",  "UTF-8");    // create of the file    
                                FileWriter fileWrite1 = new FileWriter("c:\\JohnProject\\Στοιχεία Πελατών\\Σχόλια\\"+jTextField7.getText()+".txt");  // write of the file
                                fileWrite1.write(sxolia);
                                fileWrite1.close(); // ΚΛΕΙΣΙΜΟ FILE    
                                // ΤΕΛΟΣ ΓΕΜΙΣΜΑΤΟΣ FILE
                            }
                        }
                    }
                    
                    // Αποθήκευση Ημερομηνιών!!!
                    //
                    //
                    //
                    //
                    //
                    //
                    if(sData[13].equals(";") && sData[17].equals(";") && sData[21].equals(";") && sData[25].equals(";") && sData[29].equals(";") && sData[33].equals(";") && sData[37].equals(";") && sData[41].equals(";") && sData[45].equals(";"))
                    {
                        // Προσθήκη κώδικα
                        if((sData[13].equals(";") && string13.equals(""))&&(sData[17].equals(";") && string17.equals(""))&&(sData[21].equals(";") && string21.equals(""))&&(sData[25].equals(";") && string25.equals(""))&&(sData[29].equals(";") && string29.equals(""))&&(sData[33].equals(";") && string33.equals(""))&&(sData[37].equals(";") && string37.equals(""))&&(sData[41].equals(";") && string41.equals(""))&&(sData[45].equals(";") && string45.equals("")))
                        {
                            
                        }
                        else
                        {    
                            File myObj33 = new File("c:\\JohnProject\\Στοιχεία Πελατών\\Ημερομηνίες\\Ημερομηνίες.txt");
                            myReader = new Scanner(myObj33);
                            int counterEverythingDates=0;
                            String [] everythingDates = new String [10000];for(int x=0; myReader.hasNextLine(); x++)
                            {
                                everythingDates[x]=myReader.nextLine();
                            }
                            for(int x=0; everythingDates[x]!=null; x++)
                            {
                                counterEverythingDates++;
                            }
                            String changeCode = jTextField7.getText().trim();
                            //int counterChanegedcodes=0;
                            boolean changedOnes=false;
                            int counterEverythingDates2 = counterEverythingDates;
                            for(int x=0; x<counterEverythingDates2; x++)
                            {
                                changedOnes=false;
                                String met = everythingDates[x].substring(0,7).replace('_',' ').replace('-',' ').trim();
                                if(changeCode.equals(met) && changedOnes==false)
                                {
                                    for(int xi=x; xi<counterEverythingDates; xi++)
                                    {
                                        everythingDates[xi]=everythingDates[xi+1];
                                        counterEverythingDates2--;
                                    }
                                    changedOnes=true;
                                    //counterChanegedcodes++;
                                }
                            }
                            System.out.println();
                            FileWriter myWriter = new FileWriter("c:\\JohnProject\\Στοιχεία Πελατών\\Ημερομηνίες\\Ημερομηνίες.txt");
                            for(int x=0; x<counterEverythingDates2; x++)
                            {
                                if((counterEverythingDates2)-1==x)
                                {
                                    myWriter.write(everythingDates[x]);
                                }
                                else
                                {
                                    myWriter.write(everythingDates[x]+"\n");
                                }
                            }
                            myWriter.close();
                            
                        }
                        // Τέλος προσθήκης κώδικα
                    }
                    else 
                    {
                        String [] dates  = new String[9];
                        int datesCounter = 0;
                        
                        // Βλέπουμε εάν τα πεδία έχουν αλλάξει
                        boolean changedFinal1=false;
                        boolean changedFinal2=false;
                        boolean changedFinal3=false;
                        boolean changedFinal4=false;
                        boolean changedFinal5=false;
                        boolean changedFinal6=false;
                        boolean changedFinal7=false;
                        boolean changedFinal8=false;
                        boolean changedFinal9=false;
                        int counterChanged   =0;
                        
                            if(string13.equals("yes") && sData[13].equals(";"))
                            {
                                changedFinal1=true;
                                counterChanged++;
                                string13="";
                            } 
                            if(string17.equals("yes") && sData[17].equals(";"))
                            {
                                changedFinal2=true;
                                counterChanged++;
                                string17="";
                            }
                            if(string21.equals("yes") && sData[21].equals(";"))
                            {
                                changedFinal3=true;
                                counterChanged++;
                                string21="";
                            }
                            if(string25.equals("yes") && sData[25].equals(";"))
                            {
                                changedFinal4=true;
                                counterChanged++;
                                string25="";
                            }
                            if(string29.equals("yes") && sData[29].equals(";"))
                            {
                                changedFinal5=true;
                                counterChanged++;
                                string29="";
                            }
                            if(string33.equals("yes") && sData[33].equals(";"))
                            {
                                changedFinal6=true;
                                counterChanged++;
                                string33="";
                            }
                            if(string37.equals("yes") && sData[37].equals(";"))
                            {
                                changedFinal7=true;
                                counterChanged++;
                                string37="";
                            }
                            if(string41.equals("yes") && sData[41].equals(";"))
                            {
                                changedFinal8=true;
                                counterChanged++;
                                string41="";
                            }
                            if(string45.equals("yes") && sData[45].equals(";"))
                            {
                                changedFinal9=true;
                                counterChanged++;
                                string45="";
                            }
                        // Τέλος επιθεώρισης αλαγμένων πεδίων
                            
                        if(sData[13].replace('_',' ').equals("Alis Insurance SQL"))
                        {
                            dates[datesCounter] = sData[2]+"        --        Alis_Insurance_SQL        --        "+sData[0]+"        --  "+sData[16]+"  --  "+sData[14]+"  --  "+sData[15];
                            dates[datesCounter]=dates[datesCounter].replace(' ','_');
                            datesCounter++;        
                        }
                        if(sData[17].replace('_',' ').equals("Alis Insurance ΝΕΤ"))
                        {
                            dates[datesCounter] = sData[2]+"        --        Alis_Insurance_ΝΕΤ        --        "+sData[0]+"        --  "+sData[20]+"  --  "+sData[18]+"  --  "+sData[19];
                            dates[datesCounter]=dates[datesCounter].replace(' ','_');
                            datesCounter++;
                        }
                        if(sData[21].replace('_',' ').equals("Alis Ins SQL Lease"))
                        {
                            dates[datesCounter] = sData[2]+"        --        Alis_Ins_SQL_Lease        --        "+sData[0]+"        --  "+sData[24]+"  --  "+sData[22]+"  --  "+sData[23];
                            dates[datesCounter]=dates[datesCounter].replace(' ','_');
                            datesCounter++;
                        }
                        if(sData[25].replace('_',' ').equals("Alis Ins NET Lease"))
                        {
                            dates[datesCounter] = sData[2]+"        --        Alis_Ins_NET_Lease        --        "+sData[0]+"        --  "+sData[28]+"  --  "+sData[26]+"  --  "+sData[27];
                            dates[datesCounter]=dates[datesCounter].replace(' ','_');
                            datesCounter++;
                        }
                        if(sData[29].replace('_',' ').equals("Alis Import"))
                        {
                            dates[datesCounter] = sData[2]+"        --        Alis_Import        --        "+sData[0]+"        --  "+sData[32]+"  --  "+sData[30]+"  --  "+sData[31];
                            dates[datesCounter]=dates[datesCounter].replace(' ','_');
                            datesCounter++;
                        }
                        if(sData[33].replace('_',' ').equals("Alis Portal"))
                        {
                            dates[datesCounter] = sData[2]+"        --        Alis_Portal        --        "+sData[0]+"        --  "+sData[36]+"  --  "+sData[34]+"  --  "+sData[35];
                            dates[datesCounter]=dates[datesCounter].replace(' ','_');
                            datesCounter++;
                        }
                        if(sData[37].replace('_',' ').equals("ALFA Contract"))
                        {
                            dates[datesCounter] = sData[2]+"        --        ALFA_Contract        --        "+sData[0]+"        --  "+sData[40]+"  --  "+sData[38]+"  --  "+sData[39];
                            dates[datesCounter]=dates[datesCounter].replace(' ','_');
                            datesCounter++;
                        }
                        if(sData[41].replace('_',' ').equals("ALFA Protocol"))
                        {
                            dates[datesCounter] = sData[2]+"        --        ALFA_Protocol        --        "+sData[0]+"        --  "+sData[44]+"  --  "+sData[42]+"  --  "+sData[43];
                            dates[datesCounter]=dates[datesCounter].replace(' ','_');
                            datesCounter++;
                        }
                        if(sData[45].replace('_',' ').equals("Alis Bridge"))
                        {
                            dates[datesCounter] = sData[2]+"        --        Alis_Bridge        --        "+sData[0]+"        --        "+sData[48]+"  --  "+sData[46]+"  --  "+sData[47];
                            dates[datesCounter]=dates[datesCounter].replace(' ','_');
                            datesCounter++;
                        }
                        
                        boolean fileExist=false;
                        File file32 = new File("c:\\JohnProject\\Στοιχεία Πελατών\\Ημερομηνίες\\Ημερομηνίες.txt");
                        if(file32.exists())
                        {
                            fileExist=true;
                        }
                        if(fileExist==true)
                        {
                            File myObj33 = new File("c:\\JohnProject\\Στοιχεία Πελατών\\Ημερομηνίες\\Ημερομηνίες.txt");
                            myReader = new Scanner(myObj33);
                            int counterEverythingDates=0;
                            String [] everythingDates = new String [10000];for(int x=0; myReader.hasNextLine(); x++)
                            {
                                everythingDates[x]=myReader.nextLine();
                            }
                            for(int x=0; everythingDates[x]!=null; x++)
                            {
                                counterEverythingDates++;
                            }
                            for(int x=0; x<datesCounter; x++)
                            {
                                String s1= dates[x].substring(0,40).replace('_',' ').replace('-',' ').trim();
                                boolean did=false;
                                for(int xi=0; (xi<counterEverythingDates && did==false); xi++)
                                {
                                    String s2= everythingDates[xi].substring(0,40).replace('_',' ').replace('-',' ').trim();
                                    if(s2.equals(s1))
                                    {
                                        everythingDates[xi]= dates[x];
                                        did=true;
                                    }
                                    if((xi+1==counterEverythingDates) && (did==false)) //&& (string13!=null || string17!=null  || string21!=null || string25!=null|| string29!=null|| string33!=null|| string37!=null || string41!=null|| string45!=null))
                                    {
                                        everythingDates[counterEverythingDates]=dates[x];
                                        counterEverythingDates++;
                                    }
                                    
                                }
                            }
                            if(counterChanged!=0)
                            {
                                int counterChanged2=0;
                                int counterEverythingDates2=counterEverythingDates;
                                for(int x=0; ((x<counterEverythingDates-counterChanged)&&(counterChanged2<counterChanged)); x++)
                                {
                                    String s11=everythingDates[x].substring(0,40).replace('_',' ').replace('-',' ').trim();
                                    if(changedFinal1==true) 
                                    {
                                        String find = (jTextField7.getText().trim()+"                  Alis Insurance SQL");
                                        
                                        if(s11.equals(find))
                                        {
                                            counterEverythingDates--;
                                            for(int xi=x; xi<counterEverythingDates2; xi++)
                                            {
                                                everythingDates[xi] = everythingDates[xi+1];
                                            }
                                            changedFinal1=false;
                                        }
                                    } 
                                    if((changedFinal2==true) &&(changedFinal1==false)) 
                                    {
                                        String find = (jTextField7.getText().trim()+"                  Alis Insurance ΝΕΤ");
                                        
                                        if(s11.equals(find))
                                        {
                                            counterEverythingDates--;
                                            for(int xi=x; xi<counterEverythingDates2; xi++)
                                            {
                                                everythingDates[xi] = everythingDates[xi+1];
                                            }
                                        }
                                    }
                                    if((changedFinal3==true) &&(changedFinal2==false)) 
                                    {
                                        String find = (jTextField7.getText().trim()+"                  Alis Ins SQL Lease");
                                        
                                        if(s11.equals(find))
                                        {
                                            counterEverythingDates--;
                                            for(int xi=x; xi<counterEverythingDates2; xi++)
                                            {
                                                everythingDates[xi] = everythingDates[xi+1];
                                            }
                                        }
                                    }
                                    if((changedFinal4==true) &&(changedFinal3==false)) 
                                    {
                                        String find = (jTextField7.getText().trim()+"                  Alis Ins NET Lease");
                                        
                                        if(s11.equals(find))
                                        {
                                            counterEverythingDates--;
                                            for(int xi=x; xi<counterEverythingDates2; xi++)
                                            {
                                                everythingDates[xi] = everythingDates[xi+1];
                                            }
                                        }
                                    }
                                    if((changedFinal5==true) &&(changedFinal4==false))  
                                    {
                                        String find = (jTextField7.getText().trim()+"                  Alis Import");
                                        
                                        if(s11.equals(find))
                                        {
                                            counterEverythingDates--;
                                            for(int xi=x; xi<counterEverythingDates2; xi++)
                                            {
                                                everythingDates[xi] = everythingDates[xi+1];
                                            }
                                        }
                                    }
                                    if((changedFinal6==true) &&(changedFinal5==false)) 
                                    {
                                        String find = (jTextField7.getText().trim()+"                  Alis Portal");
                                        
                                        if(s11.equals(find))
                                        {
                                            counterEverythingDates--;
                                            for(int xi=x; xi<counterEverythingDates2; xi++)
                                            {
                                                everythingDates[xi] = everythingDates[xi+1];
                                            }
                                        }
                                    }
                                    if((changedFinal7==true) &&(changedFinal6==false)) 
                                    {
                                        String find = (jTextField7.getText().trim()+"                  ALFA Contract");
                                        
                                        if(s11.equals(find))
                                        {
                                            counterEverythingDates--;
                                            for(int xi=x; xi<counterEverythingDates2; xi++)
                                            {
                                                everythingDates[xi] = everythingDates[xi+1];
                                            }
                                        }
                                    }
                                    if((changedFinal8==true) &&(changedFinal7==false)) 
                                    {
                                        String find = (jTextField7.getText().trim()+"                  ALFA Protocol");
                                        
                                        if(s11.equals(find))
                                        {
                                            counterEverythingDates--;
                                            for(int xi=x; xi<counterEverythingDates2; xi++)
                                            {
                                                everythingDates[xi] = everythingDates[xi+1];
                                            }
                                        }
                                    }
                                    if((changedFinal9==true) &&(changedFinal8==false)) 
                                    {
                                        String find = (jTextField7.getText().trim()+"                  Alis Bridge");
                                        
                                        if(s11.equals(find))
                                        {
                                            counterEverythingDates--;
                                            for(int xi=x; xi<counterEverythingDates2; xi++)
                                            {
                                                everythingDates[xi] = everythingDates[xi+1];
                                            }
                                        }
                                    }
                                }    
                            }
                            
                            FileWriter myWriter = new FileWriter("c:\\JohnProject\\Στοιχεία Πελατών\\Ημερομηνίες\\Ημερομηνίες.txt");
                            for(int x=0; x<counterEverythingDates; x++)
                            {
                                if((counterEverythingDates)-1==x)
                                {
                                    myWriter.write(everythingDates[x]);
                                }
                                else
                                {
                                    myWriter.write(everythingDates[x]+"\n");
                                }
                            }
                            myWriter.close();
                        }
                        else
                        {
                            File fileCreate1= new File("c:\\JohnProject\\Στοιχεία Πελατών\\Ημερομηνίες\\Ημερομηνίες.txt",  "UTF-8");    // create of the file    
                            FileWriter fileWrite1 = new FileWriter("c:\\JohnProject\\Στοιχεία Πελατών\\Ημερομηνίες\\Ημερομηνίες.txt");  // write of the file
                            for(int x=0; x<datesCounter; x++)
                            {
                                fileWrite1.write(dates[x].replace(' ','_')+"\n");
                            }
                            fileWrite1.close(); // ΚΛΕΙΣΙΜΟ FILE
                            // ΤΕΛΟΣ ΓΕΜΙΣΜΑΤΟΣ FILE
                            
                        }
                    }
                    
                    
                    //
                    //
                    //
                    //
                    //
                    //
                    
                    
                    System.out.println("Successfully wrote to the files (Επωνυμία.txt - Τίτλος.txt - "+everything[2]+" (Γενικά Στοιχεία)");
                    // μνμ για επιτυχή καταχώριση
                    JOptionPane.showMessageDialog(null,"Η ενημέρωση της καρτέλας του πελάτη έγινε με επιτυχία!");
                    this.dispose(); // κλήσιμο φόρμας
                }
                /*
                // Αποθήκευση Σχολίων σε file
                if(jTextArea1.getText()!=null)
                {
                    
                }
                */
            }
            
            // Αρχικοποίηση Μεταβλητών - Πινάκων Φόρμας
            
            
            
            // Τέλος Αρχικοποίησης Μεταβλητών - Πινάκων Φόρμας
        }
        catch(Exception e)
        {
            System.out.println("Προέκυψε σφάλμα. Προσπαθήστε ξανά"); // μνμ λάθους για admin
            System.out.println();
            System.out.println(e);
        }
        
    }//GEN-LAST:event_Final_Button_EnimerosiActionPerformed

    private void jTextField25ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField25ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField25ActionPerformed

    private void jCheckBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox1ActionPerformed
        
        if(jCheckBox1.isSelected())
        {
            jPanel4.setBackground(Color.red);
            jTextField34.setText("Alis Insurance SQL");
            jFormattedTextField2.setText(everything[14].replace(';',' '));
            jFormattedTextField4.setText(everything[15].replace(';',' '));
            jTextField37.setText(everything[16].replace(';',' '));
        }
        else
        {
            jFormattedTextField2.setText("");
            jFormattedTextField4.setText("");
            jTextField37.setText("");
            jTextField34.setText("");
            jPanel3.setVisible(false);
            jPanel4.setBackground(Color.lightGray);
            // Διόρθωση τιμών πίνακα
            everything[13]=";";
            everything[14]=";";
            everything[15]=";";
            everything[16]=";";
            // Τέλος διόρθωσης τιμών πίνακα

            //jPanel4.setVisible(false);
        }
        
    }//GEN-LAST:event_jCheckBox1ActionPerformed

    private void jCheckBox2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox2ActionPerformed
        
        
        if(jCheckBox2.isSelected())
        {
            jPanel5.setBackground(Color.red);
            jTextField34.setText("Alis Insurance ΝΕΤ");
            jFormattedTextField2.setText(everything[18].replace(';',' '));
            jFormattedTextField4.setText(everything[19].replace(';',' '));
            jTextField37.setText(everything[20].replace(';',' '));
        }
        else
        {
            jFormattedTextField2.setText("");
            jFormattedTextField4.setText("");
            jTextField37.setText("");
            jTextField34.setText("");
            jPanel3.setVisible(false);
            jPanel5.setBackground(Color.lightGray);
            // Διόρθωση τιμών πίνακα
            everything[17]=";";
            everything[18]=";";
            everything[19]=";";
            everything[20]=";";
            // Τέλος διόρθωσης τιμών πίνακα
        }
        
    }//GEN-LAST:event_jCheckBox2ActionPerformed

    private void jCheckBox3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox3ActionPerformed
        
        
        if(jCheckBox3.isSelected())
        {
            jPanel6.setBackground(Color.red);
            jTextField34.setText("Alis Ins SQL Lease");
            jFormattedTextField2.setText(everything[22].replace(';',' '));
            jFormattedTextField4.setText(everything[23].replace(';',' '));
            jTextField37.setText(everything[24].replace(';',' '));
        }
        else
        {
            jFormattedTextField2.setText("");
            jFormattedTextField4.setText("");
            jTextField37.setText("");
            jTextField34.setText("");
            jPanel3.setVisible(false);
            jPanel6.setBackground(Color.lightGray);
            // Διόρθωση τιμών πίνακα
            everything[21]=";";
            everything[22]=";";
            everything[23]=";";
            everything[24]=";";
            // Τέλος διόρθωσης τιμών πίνακα
        }
        
    }//GEN-LAST:event_jCheckBox3ActionPerformed

    private void jCheckBox4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox4ActionPerformed
        if(jCheckBox4.isSelected())
        {
            jPanel7.setBackground(Color.red);
            jTextField34.setText("Alis Ins NET Lease");
            jFormattedTextField2.setText(everything[26].replace(';',' '));
            jFormattedTextField4.setText(everything[27].replace(';',' '));
            jTextField37.setText(everything[28].replace(';',' '));
        }
        else
        {
            jFormattedTextField2.setText("");
            jFormattedTextField4.setText("");
            jTextField37.setText("");
            jTextField34.setText("");
            jPanel3.setVisible(false);
            jPanel7.setBackground(Color.lightGray);
            // Διόρθωση τιμών πίνακα
            everything[25]=";";
            everything[26]=";";
            everything[27]=";";
            everything[28]=";";
            // Τέλος διόρθωσης τιμών πίνακα
        }
        
    }//GEN-LAST:event_jCheckBox4ActionPerformed

    private void jCheckBox5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox5ActionPerformed
        
        if(jCheckBox5.isSelected())
        {
            jPanel8.setBackground(Color.red);
            jTextField34.setText("Alis Import");
            jFormattedTextField2.setText(everything[30].replace(';',' '));
            jFormattedTextField4.setText(everything[31].replace(';',' '));
            jTextField37.setText(everything[32].replace(';',' '));
        }
        else
        {
            jFormattedTextField2.setText("");
            jFormattedTextField4.setText("");
            jTextField37.setText("");
            jTextField34.setText("");
            jPanel3.setVisible(false);
            jPanel8.setBackground(Color.lightGray);
            // Διόρθωση τιμών πίνακα
            everything[29]=";";
            everything[30]=";";
            everything[31]=";";
            everything[32]=";";
            // Τέλος διόρθωσης τιμών πίνακα
        }
    }//GEN-LAST:event_jCheckBox5ActionPerformed

    private void jCheckBox6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox6ActionPerformed
        
        if(jCheckBox6.isSelected())
        {
            jPanel9.setBackground(Color.red);
            jTextField34.setText("Alis Portal");
            jFormattedTextField2.setText(everything[34].replace(';',' '));
            jFormattedTextField4.setText(everything[35].replace(';',' '));
            jTextField37.setText(everything[36].replace(';',' '));
        }
        else
        {
            jFormattedTextField2.setText("");
            jFormattedTextField4.setText("");
            jTextField37.setText("");
            jTextField34.setText("");
            jPanel3.setVisible(false);
            jPanel9.setBackground(Color.lightGray);
            // Διόρθωση τιμών πίνακα
            everything[33]=";";
            everything[34]=";";
            everything[35]=";";
            everything[36]=";";
            // Τέλος διόρθωσης τιμών πίνακα
        }
    }//GEN-LAST:event_jCheckBox6ActionPerformed

    private void jCheckBox7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox7ActionPerformed
        
        if(jCheckBox7.isSelected())
        {
            jPanel10.setBackground(Color.red);
            jTextField34.setText("ALFA Contract");
            jFormattedTextField2.setText(everything[38].replace(';',' '));
            jFormattedTextField4.setText(everything[39].replace(';',' '));
            jTextField37.setText(everything[40].replace(';',' '));
        }
        else
        {
            jFormattedTextField2.setText("");
            jFormattedTextField4.setText("");
            jTextField37.setText("");
            jTextField34.setText("");
            jPanel3.setVisible(false);
            jPanel10.setBackground(Color.lightGray);
            // Διόρθωση τιμών πίνακα
            everything[37]=";";
            everything[38]=";";
            everything[39]=";";
            everything[40]=";";
            // Τέλος διόρθωσης τιμών πίνακα
        }
    }//GEN-LAST:event_jCheckBox7ActionPerformed

    private void jCheckBox9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox9ActionPerformed
        
        if(jCheckBox9.isSelected())
        {
            jPanel12.setBackground(Color.red);
            jTextField34.setText("Alis Bridge");
            jFormattedTextField2.setText(everything[46].replace(';',' '));
            jFormattedTextField4.setText(everything[47].replace(';',' '));
            jTextField37.setText(everything[48].replace(';',' '));
        }
        else
        {
            jFormattedTextField2.setText("");
            jFormattedTextField4.setText("");
            jTextField37.setText("");
            jTextField34.setText("");
            jPanel3.setVisible(false);
            jPanel12.setBackground(Color.lightGray);
            // Διόρθωση τιμών πίνακα
            everything[45]=";";
            everything[46]=";";
            everything[47]=";";
            everything[48]=";";
            // Τέλος διόρθωσης τιμών πίνακα
        }
    }//GEN-LAST:event_jCheckBox9ActionPerformed

    private void jTextField28ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField28ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField28ActionPerformed

    private void jTextField29ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField29ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField29ActionPerformed

    private void jTextField30ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField30ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField30ActionPerformed

    private void jTextField34ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField34ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField34ActionPerformed

    private void Final_Button_Enimerosi10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Final_Button_Enimerosi10ActionPerformed
        
        String s1=" ";
        s1 = jFormattedTextField2.getText(); //Ημ/νία Έναρξης
        String s2=" ";
        s2 = jFormattedTextField4.getText(); // Ημ/νία Λήξης
        String s3=" ";
        s3 = (jTextField37.getText().replaceAll("[a-zA-Z]", " ").replaceAll("[α-ωΑ-Ω]", " ").replace('!',' ').replace(';',' ').replace('-',' ').replace('_',' ').replace('=',' ').replace('+',' ').replace('`',' ').replace('¬',' ').replace('£',' ').replace('%',' ').replace('^',' ').replace('&',' ').replace('*',' ').replace('(',' ').replace(')',' ').replace('{',' ').replace('}',' ').replace('[',' ').replace(']',' ').replace(':',' ').replace(';',' ').replace('@',' ').replace('#',' ').replace('~',' ').replace('<',' ').replace('>',' ').replace('/',' ').replace('?',' ').trim().replace(' ','-')); // Ποσό
        
        // Έλεγχος αποδεκτών τιμών για ημερομηνίες
            int xYears1  = Integer.valueOf(s1.substring(s1.length() - 4));
            int xMonths1 = Integer.valueOf(s1.substring(3,5));
            
            int xYears2  = Integer.valueOf(s2.substring(s2.length() - 4));
            int xMonths2 = Integer.valueOf(s2.substring(3,5));
            
            boolean ok =false;
            boolean ok2=false;
            if(xYears1<=xYears2)
            {
                if((xYears1==xYears2)&&(xMonths1<=xMonths2))
                {
                    if(xMonths1<xMonths2)
                    {
                        ok=true;
                    }
                }
                else if(xYears1<xYears2)
                {
                    ok=true;
                }
            }
            else 
            {
                ok2=true;
            }
        // Τέλος ελέγχου αποδεκτών τιμών για ημερομηνίες
        if(ok==false)
        {
            // μνμ για σωστή συμπλήρωση πεδίων ημερωμηνιών
            JOptionPane.showMessageDialog(null,"Μη επιτρεπτές ημερωμηνίες. Ελάχιστη διάρκεια είναι ο ένας μήνας");
        }
        else if(ok2==true)
        {
            // μνμ για σωστή συμπλήρωση πεδίων ημερωμηνιών
            JOptionPane.showMessageDialog(null,"Μη επιτρεπτές ημερωμηνίες.");
        }
        else if(ok==true)
        {
            String s4=" ";
            s4 = jTextField3.getText(); // Επωνυμία
            String s5=" ";
            s5 = jTextField5.getText(); // Τίτλος
            String s6=" ";
            s6 = jTextField7.getText(); // Κωδικός
            boolean flag = true;
            if(s4.equals("") || s5.equals("") || s5.equals(""))
            {
                flag= false;
            }
            else
            {
                jTextField3.setEnabled(true);
                jTextField5.setEnabled(true);
                jTextField7.setEnabled(false);
            }
            if(s1.equals("") || s2.equals("")  )
            {
                // μνμ για συμπλήρωση υποχρεωτικών πεδίων
                JOptionPane.showMessageDialog(null,"Παρακαλώ συμπληρώστε ΌΛΑ τα υποχρεωτικά πεδία (Ημ/νία Έναρξης - Ημ/νία Λήξης)");

            }
            else
            {
                if(flag==false)
                {
                    // μνμ για συμπλήρωση υποχρεωτικών πεδίων
                    JOptionPane.showMessageDialog(null,"Παρακαλώ συμπληρώστε ΌΛΑ τα υποχρεωτικά πεδία (Επωνυμία - Τίτλος - Κωδικός)");
                }
                else
                {

                    // πρόσθεσε μέθοδο αποθήκευσης στοιχείων
                    if(jTextField34.getText().equals("Alis Insurance SQL"))
                    {
                        everything[13]="Alis Insurance SQL";
                        everything[13]=everything[13].replace(' ','_');
                        everything[14]=(jFormattedTextField2.getText());
                        everything[15]=(jFormattedTextField4.getText());
                        everything[16]=(jTextField37.getText().replaceAll("[a-zA-Z]", " ").replaceAll("[α-ωΑ-Ω]", " ").replace('!',' ').replace(';',' ').replace('-',' ').replace('_',' ').replace('=',' ').replace('+',' ').replace('`',' ').replace('¬',' ').replace('£',' ').replace('%',' ').replace('^',' ').replace('&',' ').replace('*',' ').replace('(',' ').replace(')',' ').replace('{',' ').replace('}',' ').replace('[',' ').replace(']',' ').replace(':',' ').replace(';',' ').replace('@',' ').replace('#',' ').replace('~',' ').replace('<',' ').replace('>',' ').replace('/',' ').replace('?',' ').trim().replace(' ','-'));
                        if(everything[16].equals(""))
                        {
                            everything[16]="-";
                        }
                        jPanel4.setBackground(Color.green.darker());
                        System.out.println();
                    }
                    else if(jTextField34.getText().equals("Alis Insurance ΝΕΤ"))
                    {
                        everything[17]=("Alis Insurance ΝΕΤ");
                        everything[17]=everything[17].replace(' ','_');
                        everything[18]=(jFormattedTextField2.getText());
                        everything[19]=(jFormattedTextField4.getText());
                        everything[20]=(jTextField37.getText().replaceAll("[a-zA-Z]", " ").replaceAll("[α-ωΑ-Ω]", " ").replace('!',' ').replace(';',' ').replace('-',' ').replace('_',' ').replace('=',' ').replace('+',' ').replace('`',' ').replace('¬',' ').replace('£',' ').replace('%',' ').replace('^',' ').replace('&',' ').replace('*',' ').replace('(',' ').replace(')',' ').replace('{',' ').replace('}',' ').replace('[',' ').replace(']',' ').replace(':',' ').replace(';',' ').replace('@',' ').replace('#',' ').replace('~',' ').replace('<',' ').replace('>',' ').replace('/',' ').replace('?',' ').trim().replace(' ','-'));
                        if(everything[20].equals(""))
                        {
                            everything[20]="-";
                        }
                        jPanel5.setBackground(Color.green.darker());
                    }
                    else if(jTextField34.getText().equals("Alis Ins SQL Lease"))
                    {
                        everything[21]=("Alis Ins SQL Lease");
                        everything[21]=everything[21].replace(' ','_');
                        everything[22]=(jFormattedTextField2.getText());
                        everything[23]=(jFormattedTextField4.getText());
                        everything[24]=(jTextField37.getText().replaceAll("[a-zA-Z]", " ").replaceAll("[α-ωΑ-Ω]", " ").replace('!',' ').replace(';',' ').replace('-',' ').replace('_',' ').replace('=',' ').replace('+',' ').replace('`',' ').replace('¬',' ').replace('£',' ').replace('%',' ').replace('^',' ').replace('&',' ').replace('*',' ').replace('(',' ').replace(')',' ').replace('{',' ').replace('}',' ').replace('[',' ').replace(']',' ').replace(':',' ').replace(';',' ').replace('@',' ').replace('#',' ').replace('~',' ').replace('<',' ').replace('>',' ').replace('/',' ').replace('?',' ').trim().replace(' ','-'));
                        if(everything[24].equals(""))
                        {
                            everything[24]="-";
                        }
                        jPanel6.setBackground(Color.green.darker());
                    }
                    else if(jTextField34.getText().equals("Alis Ins NET Lease"))
                    {
                        everything[25]=("Alis Ins NET Lease");
                        everything[25]=everything[25].replace(' ','_');
                        everything[26]=(jFormattedTextField2.getText());
                        everything[27]=(jFormattedTextField4.getText());
                        everything[28]=(jTextField37.getText().replaceAll("[a-zA-Z]", " ").replaceAll("[α-ωΑ-Ω]", " ").replace('!',' ').replace(';',' ').replace('-',' ').replace('_',' ').replace('=',' ').replace('+',' ').replace('`',' ').replace('¬',' ').replace('£',' ').replace('%',' ').replace('^',' ').replace('&',' ').replace('*',' ').replace('(',' ').replace(')',' ').replace('{',' ').replace('}',' ').replace('[',' ').replace(']',' ').replace(':',' ').replace(';',' ').replace('@',' ').replace('#',' ').replace('~',' ').replace('<',' ').replace('>',' ').replace('/',' ').replace('?',' ').trim().replace(' ','-'));
                        if(everything[28].equals(""))
                        {
                            everything[28]="-";
                        }
                        jPanel7.setBackground(Color.green.darker());
                    }
                    else if(jTextField34.getText().equals("Alis Import"))
                    {
                        everything[29]=("Alis Import");
                        everything[29]=everything[29].replace(' ','_');
                        everything[30]=(jFormattedTextField2.getText());
                        everything[31]=(jFormattedTextField4.getText());
                        everything[32]=(jTextField37.getText().replaceAll("[a-zA-Z]", " ").replaceAll("[α-ωΑ-Ω]", " ").replace('!',' ').replace(';',' ').replace('-',' ').replace('_',' ').replace('=',' ').replace('+',' ').replace('`',' ').replace('¬',' ').replace('£',' ').replace('%',' ').replace('^',' ').replace('&',' ').replace('*',' ').replace('(',' ').replace(')',' ').replace('{',' ').replace('}',' ').replace('[',' ').replace(']',' ').replace(':',' ').replace(';',' ').replace('@',' ').replace('#',' ').replace('~',' ').replace('<',' ').replace('>',' ').replace('/',' ').replace('?',' ').trim().replace(' ','-'));
                        if(everything[32].equals(""))
                        {
                            everything[32]="-";
                        }
                        jPanel8.setBackground(Color.green.darker());
                    }
                    else if(jTextField34.getText().equals("Alis Portal"))
                    {
                        everything[33]=("Alis Portal");
                        everything[33]=everything[33].replace(' ','_');
                        everything[34]=(jFormattedTextField2.getText());
                        everything[35]=(jFormattedTextField4.getText());
                        everything[36]=(jTextField37.getText().replaceAll("[a-zA-Z]", " ").replaceAll("[α-ωΑ-Ω]", " ").replace('!',' ').replace(';',' ').replace('-',' ').replace('_',' ').replace('=',' ').replace('+',' ').replace('`',' ').replace('¬',' ').replace('£',' ').replace('%',' ').replace('^',' ').replace('&',' ').replace('*',' ').replace('(',' ').replace(')',' ').replace('{',' ').replace('}',' ').replace('[',' ').replace(']',' ').replace(':',' ').replace(';',' ').replace('@',' ').replace('#',' ').replace('~',' ').replace('<',' ').replace('>',' ').replace('/',' ').replace('?',' ').trim().replace(' ','-'));
                        if(everything[36].equals(""))
                        {
                            everything[36]="-";
                        }
                        jPanel9.setBackground(Color.green.darker());
                    }
                    else if(jTextField34.getText().equals("ALFA Contract"))
                    {
                        everything[37]=("ALFA Contract");
                        everything[37]=everything[37].replace(' ','_');
                        everything[38]=(jFormattedTextField2.getText());
                        everything[39]=(jFormattedTextField4.getText());
                        everything[40]=(jTextField37.getText().replaceAll("[a-zA-Z]", " ").replaceAll("[α-ωΑ-Ω]", " ").replace('!',' ').replace(';',' ').replace('-',' ').replace('_',' ').replace('=',' ').replace('+',' ').replace('`',' ').replace('¬',' ').replace('£',' ').replace('%',' ').replace('^',' ').replace('&',' ').replace('*',' ').replace('(',' ').replace(')',' ').replace('{',' ').replace('}',' ').replace('[',' ').replace(']',' ').replace(':',' ').replace(';',' ').replace('@',' ').replace('#',' ').replace('~',' ').replace('<',' ').replace('>',' ').replace('/',' ').replace('?',' ').trim().replace(' ','-'));
                        if(everything[40].equals(""))
                        {
                            everything[40]="-";
                        }
                        jPanel10.setBackground(Color.green.darker());
                    }
                    else if(jTextField34.getText().equals("ALFA Protocol"))
                    {
                        everything[41]=("ALFA Protocol");
                        everything[41]=everything[41].replace(' ','_');
                        everything[42]=(jFormattedTextField2.getText());
                        everything[43]=(jFormattedTextField4.getText());
                        everything[44]=(jTextField37.getText().replaceAll("[a-zA-Z]", " ").replaceAll("[α-ωΑ-Ω]", " ").replace('!',' ').replace(';',' ').replace('-',' ').replace('_',' ').replace('=',' ').replace('+',' ').replace('`',' ').replace('¬',' ').replace('£',' ').replace('%',' ').replace('^',' ').replace('&',' ').replace('*',' ').replace('(',' ').replace(')',' ').replace('{',' ').replace('}',' ').replace('[',' ').replace(']',' ').replace(':',' ').replace(';',' ').replace('@',' ').replace('#',' ').replace('~',' ').replace('<',' ').replace('>',' ').replace('/',' ').replace('?',' ').trim().replace(' ','-'));
                        if(everything[44].equals(""))
                        {
                            everything[44]="-";
                        }
                        jPanel11.setBackground(Color.green.darker());
                    }
                    else if(jTextField34.getText().equals("Alis Bridge"))
                    {
                        everything[45]=("Alis Bridge");
                        everything[45]=everything[45].replace(' ','_');
                        everything[46]=(jFormattedTextField2.getText());
                        everything[47]=(jFormattedTextField4.getText());
                        everything[48]=(jTextField37.getText().replaceAll("[a-zA-Z]", " ").replaceAll("[α-ωΑ-Ω]", " ").replace('!',' ').replace(';',' ').replace('-',' ').replace('_',' ').replace('=',' ').replace('+',' ').replace('`',' ').replace('¬',' ').replace('£',' ').replace('%',' ').replace('^',' ').replace('&',' ').replace('*',' ').replace('(',' ').replace(')',' ').replace('{',' ').replace('}',' ').replace('[',' ').replace(']',' ').replace(':',' ').replace(';',' ').replace('@',' ').replace('#',' ').replace('~',' ').replace('<',' ').replace('>',' ').replace('/',' ').replace('?',' ').trim().replace(' ','-'));
                        if(everything[48].equals(""))
                        {
                            everything[48]="-";
                        }
                        jPanel12.setBackground(Color.green.darker());
                    }

                    // μνμ για συμπλήρωση υποχρεωτικών πεδίων
                    JOptionPane.showMessageDialog(null,"Επιτυχής ενημέρωση οικονομικών στοιχείων");
                }
            }
        }
    }//GEN-LAST:event_Final_Button_Enimerosi10ActionPerformed

    private void jFormattedTextField2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jFormattedTextField2ActionPerformed

    }//GEN-LAST:event_jFormattedTextField2ActionPerformed

    private void jFormattedTextField6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jFormattedTextField6ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jFormattedTextField6ActionPerformed

    private void Final_Button_Enimerosi1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Final_Button_Enimerosi1ActionPerformed

        if(jCheckBox1.isSelected())
        {
            jPanel3.setVisible(true);
            jTextField34.setText("Alis Insurance SQL");
            jFormattedTextField2.setText(everything[14].replace(';',' '));
            jFormattedTextField4.setText(everything[15].replace(';',' '));
            jTextField37.setText(everything[16].replace(';',' '));
        }
        
    }//GEN-LAST:event_Final_Button_Enimerosi1ActionPerformed

    private void Final_Button_Enimerosi2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Final_Button_Enimerosi2ActionPerformed
        if(jCheckBox2.isSelected())
        {
            jPanel3.setVisible(true);
            jTextField34.setText("Alis Insurance ΝΕΤ");
            jFormattedTextField2.setText(everything[18].replace(';',' '));
            jFormattedTextField4.setText(everything[19].replace(';',' '));
            jTextField37.setText(everything[20].replace(';',' '));
        }
    }//GEN-LAST:event_Final_Button_Enimerosi2ActionPerformed

    private void Final_Button_Enimerosi3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Final_Button_Enimerosi3ActionPerformed
        if(jCheckBox3.isSelected())
        {
            jPanel3.setVisible(true);
            jTextField34.setText("Alis Ins SQL Lease");
            jFormattedTextField2.setText(everything[22].replace(';',' '));
            jFormattedTextField4.setText(everything[23].replace(';',' '));
            jTextField37.setText(everything[24].replace(';',' '));
        }
    }//GEN-LAST:event_Final_Button_Enimerosi3ActionPerformed

    private void Final_Button_Enimerosi4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Final_Button_Enimerosi4ActionPerformed
        if(jCheckBox4.isSelected())
        {
            jPanel3.setVisible(true);
            jTextField34.setText("Alis Ins NET Lease");
            jFormattedTextField2.setText(everything[26].replace(';',' '));
            jFormattedTextField4.setText(everything[27].replace(';',' '));
            jTextField37.setText(everything[28].replace(';',' '));
        }
    }//GEN-LAST:event_Final_Button_Enimerosi4ActionPerformed

    private void Final_Button_Enimerosi5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Final_Button_Enimerosi5ActionPerformed
        if(jCheckBox5.isSelected())
        {
            jPanel3.setVisible(true);
            jTextField34.setText("Alis Import");
            jFormattedTextField2.setText(everything[30].replace(';',' '));
            jFormattedTextField4.setText(everything[31].replace(';',' '));
            jTextField37.setText(everything[32].replace(';',' '));
        }
    }//GEN-LAST:event_Final_Button_Enimerosi5ActionPerformed

    private void Final_Button_Enimerosi6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Final_Button_Enimerosi6ActionPerformed
        if(jCheckBox6.isSelected())
        {
            jPanel3.setVisible(true);
            jTextField34.setText("Alis Portal");
            jFormattedTextField2.setText(everything[34].replace(';',' '));
            jFormattedTextField4.setText(everything[35].replace(';',' '));
            jTextField37.setText(everything[36].replace(';',' '));
        }
    }//GEN-LAST:event_Final_Button_Enimerosi6ActionPerformed

    private void Final_Button_Enimerosi7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Final_Button_Enimerosi7ActionPerformed
        if(jCheckBox7.isSelected())
        {
            jPanel3.setVisible(true);
            jTextField34.setText("ALFA Contract");
            jFormattedTextField2.setText(everything[38].replace(';',' '));
            jFormattedTextField4.setText(everything[39].replace(';',' '));
            jTextField37.setText(everything[40].replace(';',' '));
        }
    }//GEN-LAST:event_Final_Button_Enimerosi7ActionPerformed

    private void Final_Button_Enimerosi8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Final_Button_Enimerosi8ActionPerformed
        if(jCheckBox8.isSelected())
        {
            jPanel3.setVisible(true);
            jTextField34.setText("ALFA Protocol");
            jFormattedTextField2.setText(everything[42].replace(';',' '));
            jFormattedTextField4.setText(everything[43].replace(';',' '));
            jTextField37.setText(everything[44].replace(';',' '));
        }
    }//GEN-LAST:event_Final_Button_Enimerosi8ActionPerformed

    private void jCheckBox8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox8ActionPerformed
        if(jCheckBox8.isSelected())
        {
            jPanel11.setBackground(Color.red);
            jTextField34.setText("ALFA Protocol");
            jFormattedTextField2.setText(everything[42].replace(';',' '));
            jFormattedTextField4.setText(everything[43].replace(';',' '));
            jTextField37.setText(everything[44].replace(';',' '));
        }
        else
        {
            jFormattedTextField2.setText("");
            jFormattedTextField4.setText("");
            jTextField37.setText("");
            jTextField34.setText("");
            jPanel3.setVisible(false);
            jPanel11.setBackground(Color.lightGray);
            // Διόρθωση τιμών πίνακα
            everything[41]=";";
            everything[42]=";";
            everything[43]=";";
            everything[44]=";";
            // Τέλος διόρθωσης τιμών πίνακα
        }
    }//GEN-LAST:event_jCheckBox8ActionPerformed

    private void Final_Button_Enimerosi9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Final_Button_Enimerosi9ActionPerformed
        if(jCheckBox9.isSelected())
        {
            jPanel3.setVisible(true);
            jTextField34.setText("Alis Bridge");
            jFormattedTextField2.setText(everything[46].replace(';',' '));
            jFormattedTextField4.setText(everything[47].replace(';',' '));
            jTextField37.setText(everything[48].replace(';',' '));
        }
    }//GEN-LAST:event_Final_Button_Enimerosi9ActionPerformed

    private void jTextField24ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField24ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField24ActionPerformed

    private void jTextField26ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField26ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField26ActionPerformed

    private void jTextField27ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField27ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField27ActionPerformed

    private void jTextField32ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField32ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField32ActionPerformed

    private void jTextField33ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField33ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField33ActionPerformed

    private void jTextField35ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField35ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField35ActionPerformed

    private void jTextField37ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField37ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField37ActionPerformed

    
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
            java.util.logging.Logger.getLogger(editCustomers2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(editCustomers2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(editCustomers2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(editCustomers2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new editCustomers2().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Final_Button_Enimerosi;
    private javax.swing.JButton Final_Button_Enimerosi1;
    private javax.swing.JButton Final_Button_Enimerosi10;
    private javax.swing.JButton Final_Button_Enimerosi2;
    private javax.swing.JButton Final_Button_Enimerosi3;
    private javax.swing.JButton Final_Button_Enimerosi4;
    private javax.swing.JButton Final_Button_Enimerosi5;
    private javax.swing.JButton Final_Button_Enimerosi6;
    private javax.swing.JButton Final_Button_Enimerosi7;
    private javax.swing.JButton Final_Button_Enimerosi8;
    private javax.swing.JButton Final_Button_Enimerosi9;
    private javax.swing.JCheckBox jCheckBox1;
    private javax.swing.JCheckBox jCheckBox2;
    private javax.swing.JCheckBox jCheckBox3;
    private javax.swing.JCheckBox jCheckBox4;
    private javax.swing.JCheckBox jCheckBox5;
    private javax.swing.JCheckBox jCheckBox6;
    private javax.swing.JCheckBox jCheckBox7;
    private javax.swing.JCheckBox jCheckBox8;
    private javax.swing.JCheckBox jCheckBox9;
    private javax.swing.JFormattedTextField jFormattedTextField2;
    private javax.swing.JFormattedTextField jFormattedTextField4;
    private javax.swing.JFormattedTextField jFormattedTextField6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField10;
    private javax.swing.JTextField jTextField11;
    private javax.swing.JTextField jTextField13;
    private javax.swing.JTextField jTextField14;
    private javax.swing.JTextField jTextField15;
    private javax.swing.JTextField jTextField16;
    private javax.swing.JTextField jTextField17;
    private javax.swing.JTextField jTextField18;
    private javax.swing.JTextField jTextField19;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField20;
    private javax.swing.JTextField jTextField21;
    private javax.swing.JTextField jTextField22;
    private javax.swing.JTextField jTextField23;
    private javax.swing.JTextField jTextField24;
    private javax.swing.JTextField jTextField25;
    private javax.swing.JTextField jTextField26;
    private javax.swing.JTextField jTextField27;
    private javax.swing.JTextField jTextField28;
    private javax.swing.JTextField jTextField29;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField30;
    private javax.swing.JTextField jTextField31;
    private javax.swing.JTextField jTextField32;
    private javax.swing.JTextField jTextField33;
    private javax.swing.JTextField jTextField34;
    private javax.swing.JTextField jTextField35;
    private javax.swing.JTextField jTextField36;
    private javax.swing.JTextField jTextField37;
    private javax.swing.JTextField jTextField4;
    private javax.swing.JTextField jTextField5;
    private javax.swing.JTextField jTextField6;
    private javax.swing.JTextField jTextField7;
    private javax.swing.JTextField jTextField8;
    private javax.swing.JTextField jTextField9;
    // End of variables declaration//GEN-END:variables
}
