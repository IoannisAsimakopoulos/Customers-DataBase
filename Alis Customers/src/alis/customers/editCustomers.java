
package alis.customers;

// Imports

    //import static alis.ins.customers.addCustomers.flag1;
    import static alis.customers.catalogMain.searchResults;
    import java.io.File;
    import java.io.FileNotFoundException;
    import java.util.Scanner;
    import javax.swing.JOptionPane;
    import javax.swing.table.DefaultTableModel;
    //import javax.swing.table.DefaultTableModel;
    //import static jdk.nashorn.tools.ShellFunctions.input;

// Τέλος Imports

public class editCustomers extends javax.swing.JFrame {

    // Τοπικές Μεταβλητές Φόρμας
        
        static String str1;                             // String μεταβλητή ως φίλτρο αναζήτησης μέσω Επωνυμίας
        static String str2;                             // String μεταβλητή ως φίλτρο αναζήτησης μέσω Τίτλου Εταιρίας
        static String str3;                             // String μεταβλητή ως φίλτρο αναζήτησης μέσω Κωδικού Πελάτη
        
        static boolean filter1=false;                   // boolean μεταβλητή ώς flag για αλλαγή Επωνυμίας Πελάτη 
        static boolean filter2=false;                   // boolean μεταβλητή ώς flag για αλλαγή Τίτλου Εταιρίας 
        static boolean filter3=false;                   // boolean μεταβλητή ώς flag για αλλαγή Κωδικού (ΔΕΝ ΑΛΛΑΖΕΙ)
        
        static String[]ep;                              // πίνακας με τις επωνυμίες μετά την αναζήτηση
        static String[]title;                           // πίνακας με τους τίτλους μετά την αναζήτηση
        static String[]code;                            // πίνακας με τους κωδικούς μετά την αναζήτηση
        
        static int counterEpil;                         // Θέση που βρίσκετε η μεταβλητή που μας δίνεται στο αρχείο
        static String codeEpil;                         // Κωδικός επιλογής μετά την έβρεσηή του απο τα αρχεία
        static String titleEpil;                        // Τίτλος επιλογής μετά την έβρεσηή του απο τα αρχεία
        static String eponEpil;                         // Επωνυμία επιλογής μετά την έβρεσηή του απο τα αρχεία
        static String[] etcEpon  = new String[5000];    // Πίνακας με τις Επωνιμίες που βρήκαμε απο την αναζήτηση (Επωνυμίες) 
        static String[] etcTitle = new String[5000];    // Πίνακας με τους Τίτλους που βρήκαμε απο την αναζήτηση (Τίτλοι) 
        static String[] etcCode  = new String[5000];    // Πίνακας με τους Κωδικούς που βρήκαμε απο την αναζήτηση (Κωδικοί) 
        static String[] etc      = new String[5000];    // Πίνακας με τα Στοιχεία που βρήκαμε απο την αναζήτηση (Επωνυμίες - Τίτλοι - Κωδικοί) 
        
        static String [] codeEpil2 = new String[5000];  // Πίνακας με τους κωδικούς των πελατών που προέκυψαν μέσω της αναζήτησης 
    // Τέλος Τοπικών Μεταβλητών Φόρμας  
        
        // Μέθοδος για Αρχικοίηση χρησιμοποιημένων Μεταβλητών - Πινάκων 
        public void init2()
        {
            str1="";
            str2="";
            str3="";
            counterEpil=0;
            codeEpil="";
            eponEpil="";
            titleEpil="";
            for(int x=0; x<codeEpil2.length; x++)
            {
                codeEpil2[x]=null;
            }
            //filter1=false;
            //filter2=false;
            //filter3=false;
            /*
            for(int x=0; x<ep.length; x++)
            {
                ep[x]=null;
            }
            
            for(int x=0; x<title.length; x++)
            {
                title[x]=null;
            }
            for(int x=0; x<code.length; x++)
            {
                code[x]=null;
            }
            */
            /*
            for(int x=0; x<etcEpon.length; x++)
            {
                etcEpon[x]=null;
            }
            for(int x=0; x<etcTitle.length; x++)
            {
                etcTitle[x]=null;
            }
            for(int x=0; x<etcCode.length; x++)
            {
                etcCode[x]=null;
            }
            for(int x=0; x<etc.length; x++)
            {
                etc[x]=null;
            }
            */
        }
        // Τέλος Μεθόδου για Αρχικοίηση χρησιμοποιημένων Μεταβλητών - Πινάκων 
        
    // ΜΕΘΟΔΟΣ ΓΙΑ ΝΑ ΚΆΝΕΙ READ ΑΠΟ ΕΝΑ tXT FILE ΚΑΙ ΝΑ ΡΙΧΝΕΙ ΤΙΣ ΤΙΜΕΣ ΤΟΥ ΣΕ ΕΝΑ ARRAY STRING
            // Read anything.txt
            public  void readArray(String fileName,String str)
            {
                // Bήμα 1:
                    // Count how many lines are in the file
                // Βήμα 2:
                    //Create the array and copy the elements in it
                int counter1=0;
                try
                {
                    Scanner s1 = new Scanner(new File(fileName));
                    int x3=1;
                    while(s1.hasNextLine())
                    {
                        counter1++;
                        s1.nextLine();
                        x3++;
                    }
                        // Συνθήκη για να δούμε εάν το file είναι άδειο
                        if(x3==1)
                        {
                            JOptionPane.showMessageDialog(null,"Το αρχείο: '"+fileName+"' είναι κενό. ","Warning",
                            JOptionPane.WARNING_MESSAGE);
                        }
                        // Τέλος συνθήκης
                    String [] everything2 = new String[counter1];
                    Scanner s2 = new Scanner(new File(fileName));
                    for(int i=0; i<counter1; i++)
                    {
                        everything2[i]= s2.next().replace('_',' ');
                        //everything[i]=everything[i].replace('_',' ');
                    }
                    int z=0;
                    
                    for(int x=0; x<everything2.length; x++)
                    {
                        boolean exists = false;
                        exists = everything2[x].toUpperCase().contains(String.valueOf(str).toUpperCase());
                        if(exists==true)
                        {
                             searchResults[z]=everything2[x];
                             System.out.println(searchResults[z]);
                             z++;
                        }  
                    }
                    // Δεν βρέθηκαν αποτελέσματα
                    if(searchResults[0]=="")
                    {
                        // Μνμ για μη εύρεση αποτελεσμάτων
                        JOptionPane.showMessageDialog(null,"Δεν βρέθηκαν αποτελέσματα","Warning",
                        JOptionPane.WARNING_MESSAGE);
                    }
                    // Βρέθηκαν Αποτελέσματα
                    else if(searchResults[0]!="")
                    {
                        // Ενεργό Φίλτρο1
                        if (filter1==true)
                        {
                            
                            for(int x=0; searchResults[x]!=""; x++)
                            {
                                eponEpil=searchResults[x];
                                System.out.println("Επωνυμία: "+eponEpil);
                                System.out.println();
                                    boolean found1=false;
                                    String [] everythingi= new String[5000];
                                    int ei=0;
                                    File myObj= new File("c:\\JohnProject\\Στοιχεία Πελατών\\Επωνυμίες\\Επωνυμίες.txt");
                                    Scanner myReader = new Scanner(myObj);
                                    while(found1==false)
                                    {
                                        everythingi[ei]=myReader.next();
                                        if(eponEpil.equals(everythingi[ei].replace('_',' ')))
                                        {
                                            found1=true;
                                            counterEpil=ei;
                                            System.out.println("Θέση: "+counterEpil);
                                            System.out.println();
                                        }
                                        else
                                        {
                                            ei++;
                                        }
                                    }
                                    int xi=0;
                                    File myObj2= new File("c:\\JohnProject\\Στοιχεία Πελατών\\Τίτλοι\\Τίτλοι.txt");
                                    myReader = new Scanner(myObj2);
                                    while(xi<=counterEpil)
                                    {
                                        everythingi[xi]=myReader.next();
                                        if(xi==counterEpil)
                                        {
                                            titleEpil=everythingi[xi];
                                            System.out.println("Τίτλος: "+titleEpil);
                                            System.out.println();
                                            xi++;
                                        }
                                        else
                                        {
                                            xi++;
                                        }     
                                    }
                                    xi=0;
                                    File myObj3= new File("c:\\JohnProject\\Στοιχεία Πελατών\\Κωδικοί\\Κωδικοί.txt");
                                    myReader = new Scanner(myObj3);
                                    while(xi<=counterEpil)
                                    {
                                        everythingi[xi]=myReader.next();
                                        if(xi==counterEpil)
                                        {
                                            codeEpil=everythingi[xi];
                                            System.out.println("Κωδικός: "+codeEpil);
                                            codeEpil2[x]=codeEpil;
                                            System.out.println();
                                            
                                            etcEpon [x] = eponEpil.replace('_',' ');
                                            etcTitle[x] = titleEpil.replace('_',' ');
                                            etcCode [x] = codeEpil;  
                                            etc     [x] = eponEpil.replace('_',' ')+"       //      "+titleEpil.replace('_',' ')+"       //      "+codeEpil;
                                            //System.out.println(etcEpon[x]);
                                            System.out.println();
                                            xi++;
                                        }
                                        else
                                        {
                                            xi++;
                                        }     
                                    }       
                            }
                        }      
                        // Ενεργό Φίλτρο2
                        else if(filter2==true)
                        {
                            for(int x=0; searchResults[x]!=""; x++)
                            {
                                titleEpil=searchResults[x];
                                System.out.println("Τίτλος: "+eponEpil);
                                System.out.println();
                                    boolean found1=false;
                                    String [] everythingi= new String[5000];
                                    int ei=0;
                                    File myObj= new File("c:\\JohnProject\\Στοιχεία Πελατών\\Τίτλοι\\Τίτλοι.txt");
                                    Scanner myReader = new Scanner(myObj);
                                    while(found1==false)
                                    {
                                        everythingi[ei]=myReader.next();
                                        if(titleEpil.equals(everythingi[ei].replace('_',' ')))
                                        {
                                            found1=true;
                                            counterEpil=ei;
                                            System.out.println("Θέση: "+counterEpil);
                                            System.out.println();
                                        }
                                        else
                                        {
                                            ei++;
                                        }
                                    }
                                    int xi=0;
                                    File myObj2= new File("c:\\JohnProject\\Στοιχεία Πελατών\\Επωνυμίες\\Επωνυμίες.txt");
                                    myReader = new Scanner(myObj2);
                                    while(xi<=counterEpil)
                                    {
                                        everythingi[xi]=myReader.next();
                                        if(xi==counterEpil)
                                        {
                                            eponEpil=everythingi[xi];
                                            System.out.println("Επωνυμία: "+eponEpil);
                                            System.out.println();
                                            xi++;
                                        }
                                        else
                                        {
                                            xi++;
                                        }     
                                    }
                                    xi=0;
                                    File myObj3= new File("c:\\JohnProject\\Στοιχεία Πελατών\\Κωδικοί\\Κωδικοί.txt");
                                    myReader = new Scanner(myObj3);
                                    while(xi<=counterEpil)
                                    {
                                        everythingi[xi]=myReader.next();
                                        if(xi==counterEpil)
                                        {
                                            codeEpil=everythingi[xi];
                                            System.out.println("Κωδικός: "+codeEpil);
                                            codeEpil2[x]=codeEpil;
                                            System.out.println();
                                            
                                            etcEpon [x] = eponEpil.replace('_',' ');
                                            etcTitle[x] = titleEpil.replace('_',' ');
                                            etcCode [x] = codeEpil;
                                            etc     [x] = eponEpil.replace('_',' ')+"       //      "+titleEpil.replace('_',' ')+"       //      "+codeEpil;
                                            System.out.println();
                                            xi++;
                                        }
                                        else
                                        {
                                            xi++;
                                        }     
                                    } 
                            }
                        }
                        // Ενεργό Φίλτρο3
                        else if(filter3==true)
                        {
                            for(int x=0; searchResults[x]!=""; x++)
                            {
                                codeEpil=searchResults[x];
                                System.out.println("Κωδικός: "+codeEpil);
                                System.out.println();
                                    boolean found1=false;
                                    String [] everythingi= new String[5000];
                                    int ei=0;
                                    File myObj= new File("c:\\JohnProject\\Στοιχεία Πελατών\\Κωδικοί\\Κωδικοί.txt");
                                    Scanner myReader = new Scanner(myObj);
                                    while(found1==false)
                                    {
                                        everythingi[ei]=myReader.next();
                                        if(codeEpil.equals(everythingi[ei].replace('_',' ')))
                                        {   
                                            found1=true;
                                            counterEpil=ei;
                                            System.out.println("Θέση: "+counterEpil);
                                            System.out.println();
                                        }
                                        else
                                        {
                                            ei++;
                                        }
                                    }
                                    int xi=0;
                                    File myObj2= new File("c:\\JohnProject\\Στοιχεία Πελατών\\Τίτλοι\\Τίτλοι.txt");
                                    myReader = new Scanner(myObj2);
                                    while(xi<=counterEpil)
                                    {
                                        everythingi[xi]=myReader.next();
                                        if(xi==counterEpil)
                                        {
                                            titleEpil=everythingi[xi];
                                            System.out.println("Τίτλος: "+titleEpil);
                                            System.out.println();
                                            xi++;
                                        }
                                        else
                                        {
                                            xi++;
                                        }     
                                    }
                                    xi=0;
                                    File myObj3= new File("c:\\JohnProject\\Στοιχεία Πελατών\\Επωνυμίες\\Επωνυμίες.txt");
                                    myReader = new Scanner(myObj3);
                                    while(xi<=counterEpil)
                                    {
                                        everythingi[xi]=myReader.next();
                                        if(xi==counterEpil)
                                        {
                                            eponEpil=everythingi[xi];
                                            System.out.println("Επωνυμία: "+codeEpil);
                                            codeEpil2[x]=codeEpil;
                                            System.out.println();
                                            
                                            etcEpon [x] = eponEpil.replace('_',' ');
                                            etcTitle[x] = titleEpil.replace('_',' ');
                                            etcCode [x] = codeEpil;
                                            etc     [x] = eponEpil.replace('_',' ')+"       //      "+titleEpil.replace('_',' ')+"       //      "+codeEpil;
                                            System.out.println();
                                            xi++;
                                        }
                                        else
                                        {
                                            xi++;
                                        }     
                                    }  
                            }
                        }
                        
                        // Μέθοδος για αρχικοποίηση Πινάκων - Μεταβλητών που χρησιμοποιήθηκαν απο το πρόγραμμα
                            init2();
                        // Τέλος μεθόδου αρχικοποίησης
                        new editCustomers1().setVisible(true); // Set visible of the form (editCustomers1)
                    }    
                }
                // ERROR MESAGE (ΔΕΝ βρέθηκε αρχείο)
                catch(FileNotFoundException e)
                {
                    JOptionPane.showMessageDialog(null,"Δεν βρέθηκε αρχείο: '"+fileName+"'","Warning",
                    JOptionPane.WARNING_MESSAGE);
                }
            }
    // Tελος μεθόδου
    public editCustomers() {
        initComponents();
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jTextField1 = new javax.swing.JTextField();
        jTextField2 = new javax.swing.JTextField();
        jTextField3 = new javax.swing.JTextField();
        jTextField5 = new javax.swing.JTextField();
        jFormattedTextField1 = new javax.swing.JFormattedTextField();
        jFormattedTextField2 = new javax.swing.JFormattedTextField();
        jFormattedTextField3 = new javax.swing.JFormattedTextField();
        Final_Button_Enimerosi = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 204));

        jPanel2.setBackground(new java.awt.Color(211, 238, 255));

        jTextField1.setFont(new java.awt.Font("Tahoma", 0, 21)); // NOI18N
        jTextField1.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField1.setText("Eπεξεργασία Πελατών");
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

        jTextField2.setFont(new java.awt.Font("Tahoma", 0, 17)); // NOI18N
        jTextField2.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField2.setText("Επωνυμία ");
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

        jTextField3.setFont(new java.awt.Font("Tahoma", 0, 17)); // NOI18N
        jTextField3.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField3.setText("Tίτλος Εταιρίας ");
        jTextField3.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        jTextField3.setCaretColor(new java.awt.Color(255, 255, 204));
        jTextField3.setDisabledTextColor(new java.awt.Color(255, 255, 204));
        jTextField3.setFocusable(false);
        jTextField3.setRequestFocusEnabled(false);
        jTextField3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField3ActionPerformed(evt);
            }
        });

        jTextField5.setFont(new java.awt.Font("Tahoma", 0, 17)); // NOI18N
        jTextField5.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField5.setText("Κωδικός ");
        jTextField5.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        jTextField5.setCaretColor(new java.awt.Color(255, 255, 204));
        jTextField5.setDisabledTextColor(new java.awt.Color(255, 255, 204));
        jTextField5.setFocusable(false);
        jTextField5.setRequestFocusEnabled(false);
        jTextField5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField5ActionPerformed(evt);
            }
        });

        jFormattedTextField1.setBorder(null);
        jFormattedTextField1.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter()));
        jFormattedTextField1.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jFormattedTextField1.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        jFormattedTextField1.setFocusLostBehavior(javax.swing.JFormattedTextField.COMMIT);
        jFormattedTextField1.setFont(new java.awt.Font("Tahoma", 1, 15)); // NOI18N

        jFormattedTextField2.setBorder(null);
        jFormattedTextField2.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter()));
        jFormattedTextField2.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jFormattedTextField2.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        jFormattedTextField2.setFocusLostBehavior(javax.swing.JFormattedTextField.COMMIT);
        jFormattedTextField2.setFont(new java.awt.Font("Tahoma", 1, 15)); // NOI18N

        jFormattedTextField3.setBorder(null);
        jFormattedTextField3.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#0"))));
        jFormattedTextField3.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jFormattedTextField3.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        jFormattedTextField3.setFocusLostBehavior(javax.swing.JFormattedTextField.COMMIT);
        jFormattedTextField3.setFont(new java.awt.Font("Tahoma", 1, 15)); // NOI18N

        Final_Button_Enimerosi.setFont(new java.awt.Font("Tahoma", 1, 15)); // NOI18N
        Final_Button_Enimerosi.setText("Αναζήτηση ");
        Final_Button_Enimerosi.setAutoscrolls(true);
        Final_Button_Enimerosi.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        Final_Button_Enimerosi.setFocusPainted(false);
        Final_Button_Enimerosi.setFocusable(false);
        Final_Button_Enimerosi.setRequestFocusEnabled(false);
        Final_Button_Enimerosi.setRolloverEnabled(false);
        Final_Button_Enimerosi.setSelected(true);
        Final_Button_Enimerosi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Final_Button_EnimerosiActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap(108, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTextField1)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jTextField2)
                            .addComponent(jTextField3, javax.swing.GroupLayout.DEFAULT_SIZE, 295, Short.MAX_VALUE)
                            .addComponent(jTextField5))
                        .addGap(30, 30, 30)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jFormattedTextField1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 304, Short.MAX_VALUE)
                            .addComponent(jFormattedTextField2, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jFormattedTextField3))))
                .addContainerGap(109, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(Final_Button_Enimerosi, javax.swing.GroupLayout.PREFERRED_SIZE, 226, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap(30, Short.MAX_VALUE)
                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jFormattedTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(7, 7, 7)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jTextField3, javax.swing.GroupLayout.DEFAULT_SIZE, 36, Short.MAX_VALUE)
                    .addComponent(jFormattedTextField1))
                .addGap(7, 7, 7)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jTextField5, javax.swing.GroupLayout.DEFAULT_SIZE, 37, Short.MAX_VALUE)
                    .addComponent(jFormattedTextField3))
                .addGap(30, 30, 30)
                .addComponent(Final_Button_Enimerosi, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(31, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(125, Short.MAX_VALUE)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap(125, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(51, Short.MAX_VALUE)
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

    private void jTextField2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField2ActionPerformed

    }//GEN-LAST:event_jTextField2ActionPerformed

    private void jTextField3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField3ActionPerformed

    private void jTextField5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField5ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField5ActionPerformed

    private void Final_Button_EnimerosiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Final_Button_EnimerosiActionPerformed
        // Αρχικοποίηση πίνακα Search Results
        for(int x=0; x<searchResults.length; x++)
        {
            searchResults[x]="";
        }
        
        String str1=""; // φίλτρο Επωνυμίας
        String str2=""; // φίλτρο Τίτλου Εταιρίας
        String str3=""; // φίλτρο Κωδικού Πελάτη

        str1 = jFormattedTextField2.getText().trim(); // Καταχώρηση φίλτου απο TextField
        str2 = jFormattedTextField1.getText().trim(); // Καταχώρηση φίλτου απο TextField
        str3 = jFormattedTextField3.getText().trim(); // Καταχώρηση φίλτου απο TextField
        
        if(str1.equals("") && str2.equals("")&& str3.equals(""))
        {
            // μνμ για συμπλήρωση υποχρεωτικών πεδίων
            JOptionPane.showMessageDialog(null,"Παρακαλώ συμπληρώστε ΤΟΥΛΑΧΙΣΤΟΝ ένα απο τα υποχρεωτικά πεδία (Επωνυμία - Τίτλος Εταιρίας - Κωδικός)");
        }
        else
        {
            // set filters
            if(str1.equals(""))
            {
                filter1=false; // Λανθασμένο φίλτρο 1
            }
            else
            {
                filter1=true;
            }
            if(str2.equals(""))
            {
                filter2=false; // Λανθασμένο φίλτρο 2
            }
            else
            {
                filter2=true;
            }
            if(str3.equals(""))
            {
                filter3=false; // Λανθασμένο φίλτρο 3
            }
            else
            {
                filter3=true;
            }
            // end of set filters
            
            // Δοκιμή ενεργών φίλτρων αναζήτησης
            if(filter1==true)
            {
                // readArray from Επωνυμίες
                readArray("c:\\JohnProject\\Στοιχεία Πελατών\\Επωνυμίες\\Επωνυμίες.txt",str1);
            }
            else if(filter2==true)
            {
                
                // readArray from Τίτλο Εταιρίας
                readArray("c:\\JohnProject\\Στοιχεία Πελατών\\Τίτλοι\\Τίτλοι.txt",str2);
            }
            else if(filter3==true)
            {
                // readArray from Κωδικό
                readArray("c:\\JohnProject\\Στοιχεία Πελατών\\Κωδικοί\\Κωδικοί.txt",str3);
            }
            // Τέλος φιλτραρίσματος
            
        }    
    }//GEN-LAST:event_Final_Button_EnimerosiActionPerformed

    
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
            java.util.logging.Logger.getLogger(editCustomers.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(editCustomers.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(editCustomers.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(editCustomers.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new editCustomers().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Final_Button_Enimerosi;
    private javax.swing.JFormattedTextField jFormattedTextField1;
    private javax.swing.JFormattedTextField jFormattedTextField2;
    private javax.swing.JFormattedTextField jFormattedTextField3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField5;
    // End of variables declaration//GEN-END:variables
}

