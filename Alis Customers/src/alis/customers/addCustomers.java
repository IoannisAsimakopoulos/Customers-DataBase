/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package alis.customers;

import static alis.customers.editCustomers.codeEpil;
import java.awt.Color;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import static java.lang.System.out;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;


public class addCustomers extends javax.swing.JFrame {
    // Τοπικές μεταβλητές φόρμας 
    static String [] prosorinaStixia = new String [36];   // πίνακας προσωρινών στοιχείων (Ημ/νίες έναρξης - Ημ/νίες Λήξης - Ποσά)
    static String [] stixia = new String[13];             // πίνακας στοιχείων (Πρώτου σκέλους της φόρμας)
    static boolean flag1=false;                           // Flag για να ξέρω εάν ο πελάτης υπάρχει είδη (Επωνυμία)
    static boolean flag2=false;                           // Flag για να ξέρω εάν ο πελάτης υπάρχει είδη (Τίτλος)
    static boolean flag3=false;                           // Flag για να ξέρω εάν ο πελάτης υπάρχει είδη (Κωδικός)
    static int  apoth=4;
    // Τέλος τοπικών μεταβλητών φόρμας
    
    
    // Μέθοδος που δημιουργεί txt αρχείο        
    public void createTxt(String eponimia,String titlos,String kodikos,String kinito,String tilefono,String xristes,String email,String adress1,String adress2,String tk,String afm,String doi,String onIpal) throws FileNotFoundException
    {
        // δημιουργεία txt file (για καταχώριση γενικών στοιχείων πελάτη)
        try
        {
            File f = new File("c:\\JohnProject\\Στοιχεία Πελατών\\Γενικά Στοιχεία\\"+kodikos+" (Γενικά Στοιχεία).txt");
            if(f.exists())
            {
                flag1=true;
                // μνμ για Error
                JOptionPane.showMessageDialog(null,"O συγκεκριμένος Κωδικός είναι είδη καταχωρημένη στο σύστημα");
            }
            else
            {
                File f1 = new File("c:\\JohnProject\\Στοιχεία Πελατών\\Επωνυμίες\\Επωνυμίες.txt");
                File f2 = new File("c:\\JohnProject\\Στοιχεία Πελατών\\Τίτλοι\\Τίτλοι.txt");
                File f3 = new File("c:\\JohnProject\\Στοιχεία Πελατών\\Κωδικοί\\Κωδικοί.txt");
                
                if(f1.exists() || f2.exists() || f3.exists())
                {
                    String epilEpon=jTextField3.getText();
                    boolean foundEpil1=false;
                    String epilTitle=jTextField5.getText();
                    boolean foundEpil2=false;
                    int counterEpil=0;

                    boolean found1=false;
                    flag1=false;
                    flag2=false;
                    flag3=false;
                    String [] everythingi= new String[5000];
                    int ei=0;
                    File myObj= new File("c:\\JohnProject\\Στοιχεία Πελατών\\Επωνυμίες\\Επωνυμίες.txt");
                    Scanner myReader = new Scanner(myObj);
                    while(myReader.hasNext() && flag1==false)
                    {
                        everythingi[ei]=myReader.next();
                        if(epilEpon.equals(everythingi[ei].replace('_',' ')))
                        {
                            foundEpil1=true;
                            counterEpil=ei;
                            System.out.println("Βρέθηκε Επωνυμία");
                            flag1=true;
                            System.out.println();
                            // μνμ για Error
                            JOptionPane.showMessageDialog(null,"Η συγκεκριμένη Επωνυμία είναι είδη καταχωρημένη στο σύστημα");
                        }
                        else
                        {
                            ei++;
                        }
                    }
                    boolean found=false;
                    //String [] everythingi= new String[5000];
                    //int ei=0;
                    File myObj2= new File("c:\\JohnProject\\Στοιχεία Πελατών\\Τίτλοι\\Τίτλοι.txt");
                    myReader = new Scanner(myObj2);
                    while(myReader.hasNext() && flag2==false)
                    {
                        everythingi[ei]=myReader.next();
                        if(epilTitle.equals(everythingi[ei].replace('_',' ')))
                        {
                            foundEpil2=true;
                            counterEpil=ei;
                            System.out.println("Βρέθηκε Τίτλος");
                            flag2=true;
                            System.out.println();
                            // μνμ για Error
                            JOptionPane.showMessageDialog(null,"Ο συγκεκριμένος Τίτλος είναι είδη καταχωρημένη στο σύστημα");
                        }
                        else
                        {
                            ei++;
                        }
                    }
                    if(flag1==false && flag2==false && flag3== false )
                    {
                        File fileCreate= new File("c:\\JohnProject\\Στοιχεία Πελατών\\Γενικά Στοιχεία\\"+kodikos+" (Γενικά Στοιχεία).txt",  "UTF-8");    // create of the file    
                        FileWriter fileWrite = new FileWriter("c:\\JohnProject\\Στοιχεία Πελατών\\Γενικά Στοιχεία\\"+kodikos+" (Γενικά Στοιχεία).txt");  // write of the file 

                        // ΓΕΜΙΣΜΑ FILE ΑΠΟ ΠΙΝΑΚΑ

                        //antik[x]=antik[x].replace(' ','_');
                        //fileWrite.write(antik[x]+"\n");

                        stixia[0]=eponimia.replace(' ','_');    // Επωνυμία
                        stixia[1]=titlos.replace(' ','_');      // Τίτλος    
                        stixia[2]=kodikos.replace(' ','_');     // Κωδικός  
                        stixia[3]=kinito.replace(' ','_');      // Κινητό
                        stixia[4]=tilefono.replace(' ','_');    // Τηλέφωνο
                        stixia[5]=xristes.replace(' ','_');     // Αριθμός Χειριστών
                        stixia[6]=email.replace(' ','_');       // ΕΜΑΙL
                        stixia[7]=adress1.replace(' ','_');     // Διεύθηνση 1
                        stixia[8]=adress2.replace(' ','_');     // Διεύθηνση 2
                        stixia[9]=tk.replace(' ','_');     // Διεύθηνση 1
                        stixia[10]=afm.replace(' ','_');         // ΑΦΜ
                        stixia[11]=doi.replace(' ','_');         // ΔΟΥ
                        stixia[12]=onIpal.replace(' ','_');     // Όνομα υπαλλήλου

                        for(int x=0; x<13; x++)
                        {
                            fileWrite.write(stixia[x].replace(' ','_')+"\n");
                        }
                        for(int x=0; x<36; x++)
                        {
                            if(x==((prosorinaStixia.length)-1))
                            {
                                fileWrite.write(prosorinaStixia[x].replace(' ','_'));
                            }
                            else
                            {
                                fileWrite.write(prosorinaStixia[x].replace(' ','_')+"\n");
                            }
                        }
                        fileWrite.close(); // ΚΛΕΙΣΙΜΟ FILE    
                        // ΤΕΛΟΣ ΓΕΜΙΣΜΑΤΟΣ FILE
                        createTxt2(apoth);
                        flag1=false;
                        flag2=false;
                        flag3=false;
                    }
                }
                else
                {
                    File fileCreate= new File("c:\\JohnProject\\Στοιχεία Πελατών\\Γενικά Στοιχεία\\"+kodikos+" (Γενικά Στοιχεία).txt",  "UTF-8");    // create of the file    
                        FileWriter fileWrite = new FileWriter("c:\\JohnProject\\Στοιχεία Πελατών\\Γενικά Στοιχεία\\"+kodikos+" (Γενικά Στοιχεία).txt");  // write of the file 

                        // ΓΕΜΙΣΜΑ FILE ΑΠΟ ΠΙΝΑΚΑ

                        //antik[x]=antik[x].replace(' ','_');
                        //fileWrite.write(antik[x]+"\n");

                        stixia[0]=eponimia.replace(' ','_');    // Επωνυμία
                        stixia[1]=titlos.replace(' ','_');      // Τίτλος    
                        stixia[2]=kodikos.replace(' ','_');     // Κωδικός  
                        stixia[3]=kinito.replace(' ','_');      // Κινητό
                        stixia[4]=tilefono.replace(' ','_');    // Τηλέφωνο
                        stixia[5]=xristes.replace(' ','_');     // Αριθμός Χειριστών
                        stixia[6]=email.replace(' ','_');       // ΕΜΑΙL
                        stixia[7]=adress1.replace(' ','_');     // Διεύθηνση 1
                        stixia[8]=adress1.replace(' ','_');     // Διεύθηνση 2
                        stixia[9]=adress1.replace(' ','_');     // TK
                        stixia[10]=afm.replace(' ','_');         // ΑΦΜ
                        stixia[11]=doi.replace(' ','_');         // ΔΟΥ
                        stixia[12]=onIpal.replace(' ','_');     // Όνομα υπαλλήλου

                        for(int x=0; x<13; x++)
                        {
                            fileWrite.write(stixia[x].replace(' ','_')+"\n");
                        }
                        for(int x=0; x<36; x++)
                        {
                            if(x==((prosorinaStixia.length)-1))
                            {
                                fileWrite.write(prosorinaStixia[x].replace(' ','_'));
                            }
                            else
                            {
                                fileWrite.write(prosorinaStixia[x].replace(' ','_')+"\n");
                            }
                        }
                        fileWrite.close(); // ΚΛΕΙΣΙΜΟ FILE    
                        // ΤΕΛΟΣ ΓΕΜΙΣΜΑΤΟΣ FILE
                        apoth=4;
                        createTxt2(apoth);
                        
                }
            }       
        }
        // ERROR MESAGE
        catch(IOException e)
        {
            System.out.println("An error occurred. Please try again..."); 
            System.out.println(e);
        } 
    }
    // Tέλος Μεθόδου καταχώρισης γενικών στοιχείων πελάτη
    
    
    // Μέθοδος που δημιουργεί txt αρχείο        
    public void createTxt2(int apoth) throws FileNotFoundException
    {
        // δημιουργεία txt file (για καταχώριση ειδικών στοιχείων πελάτη)
        File f = new File("c:\\JohnProject\\Στοιχεία Πελατών\\Γενικά Στοιχεία\\"+jTextField7.getText()+" (Γενικά Στοιχεία).txt");
        if(f.exists())
        {
            try
            {
                // Αποθήκευση file Επωνυμιών
                File file1 = new File("c:\\JohnProject\\Στοιχεία Πελατών\\Κωδικοί\\Κωδικοί.txt");
                if(file1.exists()) // το file υπάρχει
                { 
                    FileWriter fileWrite1 = new FileWriter("c:\\JohnProject\\Στοιχεία Πελατών\\Κωδικοί\\Κωδικοί.txt",true);
                    BufferedWriter out = new BufferedWriter(fileWrite1);
                    String ep = jTextField7.getText().replace(' ','_');
                    out.write(ep+"\n");
                    out.close();
                }
                else // το file δεν υπάρχει
                {
                    File fileCreate1= new File("c:\\JohnProject\\Στοιχεία Πελατών\\Κωδικοί\\Κωδικοί.txt",  "UTF-8");    // create of the file    
                    FileWriter fileWrite1 = new FileWriter("c:\\JohnProject\\Στοιχεία Πελατών\\Κωδικοί\\Κωδικοί.txt");  // write of the file
                    String ep=jTextField7.getText().replace(' ','_');
                    fileWrite1.write(ep+"\n");
                    fileWrite1.close(); // ΚΛΕΙΣΙΜΟ FILE    
                    // ΤΕΛΟΣ ΓΕΜΙΣΜΑΤΟΣ FILE
                } 
                
                // Αποθήκευση file Τίτλων
                File file2 = new File("c:\\JohnProject\\Στοιχεία Πελατών\\Τίτλοι\\Τίτλοι.txt");
                if(file2.exists()) // το file υπάρχει
                { 
                    FileWriter fileWrite1 = new FileWriter("c:\\JohnProject\\Στοιχεία Πελατών\\Τίτλοι\\Τίτλοι.txt",true);
                    BufferedWriter out = new BufferedWriter(fileWrite1);
                    String ep = jTextField5.getText().replace(' ','_');
                    out.write(ep+"\n");
                    out.close();
                }
                else // το file δεν υπάρχει
                {
                    File fileCreate1= new File("c:\\JohnProject\\Στοιχεία Πελατών\\Τίτλοι\\Τίτλοι.txt",  "UTF-8");    // create of the file    
                    FileWriter fileWrite1 = new FileWriter("c:\\JohnProject\\Στοιχεία Πελατών\\Τίτλοι\\Τίτλοι.txt");  // write of the file
                    String ep=jTextField5.getText().replace(' ','_');
                    fileWrite1.write(ep+"\n");
                    fileWrite1.close(); // ΚΛΕΙΣΙΜΟ FILE    
                    // ΤΕΛΟΣ ΓΕΜΙΣΜΑΤΟΣ FILE
                }
                
                // Αποθήκευση file Κωδικών
                File file3 = new File("c:\\JohnProject\\Στοιχεία Πελατών\\Επωνυμίες\\Επωνυμίες.txt");
                if(file3.exists()) // το file υπάρχει
                { 
                    FileWriter fileWrite1 = new FileWriter("c:\\JohnProject\\Στοιχεία Πελατών\\Επωνυμίες\\Επωνυμίες.txt",true);
                    BufferedWriter out = new BufferedWriter(fileWrite1);
                    String ep = jTextField3.getText().replace(' ','_');
                    out.write(ep+"\n");
                    out.close();
                }
                else // το file δεν υπάρχει
                {
                    File fileCreate1= new File("c:\\JohnProject\\Στοιχεία Πελατών\\Επωνυμίες\\Επωνυμίες.txt",  "UTF-8");    // create of the file    
                    FileWriter fileWrite1 = new FileWriter("c:\\JohnProject\\Στοιχεία Πελατών\\Επωνυμίες\\Επωνυμίες.txt");  // write of the file
                    String ep=jTextField3.getText().replace(' ','_');
                    fileWrite1.write(ep+"\n");
                    fileWrite1.close(); // ΚΛΕΙΣΙΜΟ FILE    
                    // ΤΕΛΟΣ ΓΕΜΙΣΜΑΤΟΣ FILE
                }
                File file31 = new File("c:\\JohnProject\\Στοιχεία Πελατών\\Ημερομηνίες\\Ημερομηνίες.txt");
                String  [] dates = new String [9];
                if(file31.exists())
                {
                    File myObj = new File("c:\\JohnProject\\Στοιχεία Πελατών\\Γενικά Στοιχεία\\"+jTextField7.getText()+" (Γενικά Στοιχεία).txt");
                    Scanner myReader = new Scanner(myObj);
                    String [] data = new String[49];
                    int datesCounter=0;
                    for (int x=0; myReader.hasNextLine(); x++) 
                    {  
                      data[x] = myReader.nextLine();
                    }
                    myReader.close();
                    if(data[13].equals("Alis_Insurance_SQL"))
                    {
                        dates[datesCounter] = data[2]+"        --        Alis_Insurance_SQL        --        "+data[0]+"        --  "+data[16]+"  --  "+data[14]+"  --  "+data[15];
                        datesCounter++;
                    }
                    if(data[17].equals("Alis_Insurance_ΝΕΤ"))
                    {
                        dates[datesCounter] = data[2]+"        --        Alis_Insurance_ΝΕΤ        --        "+data[0]+"        --  "+data[20]+"  --  "+data[18]+"  --  "+data[19];
                        datesCounter++;
                    }
                    if(data[21].equals("Alis_Ins_SQL_Lease"))
                    {
                        dates[datesCounter] = data[2]+"        --        Alis_Ins_SQL_Lease        --        "+data[0]+"        --  "+data[24]+"  --  "+data[22]+"  --  "+data[23];
                        datesCounter++;
                    }
                    if(data[25].equals("Alis_Ins_NET_Lease"))
                    {
                        dates[datesCounter] = data[2]+"        --        Alis_Ins_NET_Lease        --        "+data[0]+"        --  "+data[28]+"  --  "+data[26]+"  --  "+data[27];
                        datesCounter++;
                    }
                    if(data[29].equals("Alis_Import"))
                    {
                        dates[datesCounter] = data[2]+"        --        Alis_Import        --        "+data[0]+"        --  "+data[32]+"  --  "+data[30]+"  --  "+data[31];
                        datesCounter++;
                    }
                    if(data[33].equals("Alis_Portal"))
                    {
                        dates[datesCounter] = data[2]+"        --        Alis_Portal        --        "+data[0]+"        --  "+data[36]+"  --  "+data[34]+"  --  "+data[35];
                        datesCounter++;
                    }
                    if(data[37].equals("ALFA_Contract"))
                    {
                        dates[datesCounter] = data[2]+"        --        ALFA_Contract        --        "+data[0]+"        --  "+data[40]+"  --  "+data[38]+"  --  "+data[39];
                        datesCounter++;
                    }
                    if(data[41].equals("ALFA_Protocol"))
                    {
                        dates[datesCounter] = data[2]+"        --        ALFA_Protocol        --        "+data[0]+"        --  "+data[44]+"  --  "+data[42]+"  --  "+data[43];
                        datesCounter++;
                    }
                    if(data[45].equals("Alis_Bridge"))
                    {
                        dates[datesCounter] = data[2]+"        --        Alis_Bridge        --        "+data[0]+"        --        "+data[48]+"  --  "+data[46]+"  --  "+data[47];
                        datesCounter++;
                    }
                    //datesCounter--;
                    FileWriter fileWrite1 = new FileWriter("c:\\JohnProject\\Στοιχεία Πελατών\\Ημερομηνίες\\Ημερομηνίες.txt",true);
                    BufferedWriter out = new BufferedWriter(fileWrite1);
                    for(int x=0; x<datesCounter; x++)
                    {
                        /*
                        if(datesCounter-1==x)
                        {
                            fileWrite1.write(dates[datesCounter].replace(' ','_'));
                            //fileWrite1.close(); // ΚΛΕΙΣΙΜΟ FILE 
                        }
                        else
                        {
                            fileWrite1.write(dates[datesCounter].replace(' ','_')+"\n");
                            //fileWrite1.close(); // ΚΛΕΙΣΙΜΟ FILE 
                        } 
                        */
                        out.write(dates[x].replace(' ','_')+"\n");
                    }
                    //out.write(ep+"\n");
                    out.close();
                    /*
                    File fileCreate1= new File("c:\\JohnProject\\Στοιχεία Πελατών\\Ημερωμηνίες\\Ημερωμηνίες.txt",  "UTF-8");    // create of the file    
                    FileWriter fileWrite1 = new FileWriter("c:\\JohnProject\\Στοιχεία Πελατών\\Ημερωμηνίες\\Ημερωμηνίες.txt");  // write of the file
                    for(int x=0; x<datesCounter; x++)
                    {
                        if(datesCounter-1==x)
                        {
                            fileWrite1.write(dates[datesCounter].replace(' ','_'));
                            fileWrite1.close(); // ΚΛΕΙΣΙΜΟ FILE 
                        }
                        else
                        {
                            fileWrite1.write(dates[datesCounter].replace(' ','_')+"\n");
                            fileWrite1.close(); // ΚΛΕΙΣΙΜΟ FILE 
                        }    
                    }
                    fileWrite1.close(); // ΚΛΕΙΣΙΜΟ FILE
                    */
                }
                else
                {
                    
                    File myObj = new File("c:\\JohnProject\\Στοιχεία Πελατών\\Γενικά Στοιχεία\\"+jTextField7.getText()+" (Γενικά Στοιχεία).txt");
                    Scanner myReader = new Scanner(myObj);
                    String [] data = new String[49];
                    int datesCounter=0;
                    for (int x=0; myReader.hasNextLine(); x++) 
                    {  
                      data[x] = myReader.nextLine();
                    }
                    
                    if(data[13].equals(";") && data[17].equals(";") && data[21].equals(";") && data[25].equals(";") && data[29].equals(";") && data[33].equals(";") && data[37].equals(";") &&data[41].equals(";") &&data[45].equals(";"))
                    {
                    }
                    
                    else
                    {    
                        myReader.close();
                        if(data[13].equals("Alis_Insurance_SQL"))
                        {
                            dates[datesCounter] = data[2]+"        --        Alis_Insurance_SQL        --        "+data[0]+"        --  "+data[16]+"  --  "+data[14]+"  --  "+data[15];
                            datesCounter++;
                        }
                        if(data[17].equals("Alis_Insurance_ΝΕΤ"))
                        {
                            dates[datesCounter] = data[2]+"        --        Alis_Insurance_ΝΕΤ        --        "+data[0]+"        --  "+data[20]+"  --  "+data[18]+"  --  "+data[19];
                            datesCounter++;
                        }
                        if(data[21].equals("Alis_Ins_SQL_Lease"))
                        {
                            dates[datesCounter] = data[2]+"        --        Alis_Ins_SQL_Lease        --        "+data[0]+"        --  "+data[24]+"  --  "+data[22]+"  --  "+data[23];
                            datesCounter++;
                        }
                        if(data[25].equals("Alis_Ins_NET_Lease"))
                        {
                            dates[datesCounter] = data[2]+"        --        Alis_Ins_NET_Lease        --        "+data[0]+"        --  "+data[28]+"  --  "+data[26]+"  --  "+data[27];
                            datesCounter++;
                        }
                        if(data[29].equals("Alis_Import"))
                        {
                            dates[datesCounter] = data[2]+"        --        Alis_Import        --        "+data[0]+"        --  "+data[32]+"  --  "+data[30]+"  --  "+data[31];
                            datesCounter++;
                        }
                        if(data[33].equals("Alis_Portal"))
                        {
                            dates[datesCounter] = data[2]+"        --        Alis_Portal        --        "+data[0]+"        --  "+data[36]+"  --  "+data[34]+"  --  "+data[35];
                            datesCounter++;
                        }
                        if(data[37].equals("ALFA_Contract"))
                        {
                            dates[datesCounter] = data[2]+"        --        ALFA_Contract        --        "+data[0]+"        --  "+data[40]+"  --  "+data[38]+"  --  "+data[39];
                            datesCounter++;
                        }
                        if(data[41].equals("ALFA_Protocol"))
                        {
                            dates[datesCounter] = data[2]+"        --        ALFA_Protocol        --        "+data[0]+"        --  "+data[44]+"  --  "+data[42]+"  --  "+data[43];
                            datesCounter++;
                        }
                        if(data[45].equals("Alis_Bridge"))
                        {
                            dates[datesCounter] = data[2]+"        --        Alis_Bridge        --        "+data[0]+"        --        "+data[48]+"  --  "+data[46]+"  --  "+data[47];
                            datesCounter++;
                        }
                        //datesCounter--;
                        File fileCreate1= new File("c:\\JohnProject\\Στοιχεία Πελατών\\Ημερομηνίες\\Ημερομηνίες.txt",  "UTF-8");    // create of the file    
                        FileWriter fileWrite1 = new FileWriter("c:\\JohnProject\\Στοιχεία Πελατών\\Ημερομηνίες\\Ημερομηνίες.txt");  // write of the file
                        for(int x=0; x<datesCounter; x++)
                        {
                            if(datesCounter==x+1)
                            {
                                fileWrite1.write(dates[x].replace(' ','_'));
                                //fileWrite1.close(); // ΚΛΕΙΣΙΜΟ FILE 
                            }
                            else
                            {
                                fileWrite1.write(dates[x].replace(' ','_')+"\n");
                                //fileWrite1.close(); // ΚΛΕΙΣΙΜΟ FILE 
                            }    
                        }
                        fileWrite1.close(); // ΚΛΕΙΣΙΜΟ FILE
                    }    
                }
                
                if(apoth==4 && jTextArea1.getText().length()!=0)
                {
                    // Αποθήκευση σχολίων
                    System.out.println("Αποθήκευση σχολίων:");
                    String sxolia="";
                    sxolia=(jTextArea1.getText().replace(' ','_'));
                    System.out.println(sxolia);
                    File file4 = new File("c:\\JohnProject\\Στοιχεία Πελατών\\Σχόλια\\"+jTextField7.getText()+".txt");
                    if(file4.exists()) // το file υπάρχει
                    { 
                        /*
                        JOptionPane.showMessageDialog(null,"Προέκυψε σφάλμα κατα την αποθήκευση των σχολίων","Warning",
                        JOptionPane.WARNING_MESSAGE);
                        System.out.println("");
                        System.out.println("Προέκυψε σφάλμα κατα την αποθήκευση των σχολίων");
                        */
                    }
                    else // το file δεν υπάρχει
                    {
                        File fileCreate1= new File("c:\\JohnProject\\Στοιχεία Πελατών\\Σχόλια\\"+jTextField7.getText()+".txt",  "UTF-8");    // create of the file    
                        FileWriter fileWrite1 = new FileWriter("c:\\JohnProject\\Στοιχεία Πελατών\\Σχόλια\\"+jTextField7.getText()+".txt");  // write of the file
                        fileWrite1.write(sxolia);
                        fileWrite1.close(); // ΚΛΕΙΣΙΜΟ FILE    
                        // ΤΕΛΟΣ ΓΕΜΙΣΜΑΤΟΣ FILE
                    }
                    
                }
                /*
                // μνμ για επιτυχή καταχώριση
                JOptionPane.showMessageDialog(null,"Η καταχώριση του πελάτη έγινε με επιτυχία!");
                this.dispose(); // κλήσιμο φόρμας
                */
            }
            catch(Exception e)
            {
                JOptionPane.showMessageDialog(null,"Η αποθήκευση του πελάτη απέτυχε. Παρακαλώ προσπαθήστε ξανά!!!","Warning",
                JOptionPane.WARNING_MESSAGE);
            }
        }
        else
        {
            JOptionPane.showMessageDialog(null,"Η αποθήκευση του πελάτη απέτυχε. Παρακαλώ προσπαθήστε ξανά!!!","Warning",
            JOptionPane.WARNING_MESSAGE);
        }
            
    }
    // Tέλος Μεθόδου καταχώρισης ειδικών στοιχείων πελάτη
    
    
    static void init()
    {
        for(int x=0; x<prosorinaStixia.length; x++)
        {
            prosorinaStixia[x]=";";
        }
        for(int x=0; x<stixia.length; x++)
        {
            stixia[x]=";";
        }
    }
    public addCustomers() {
        initComponents();
        init(); // αρχικοποίηση πινάκων: prosorinaStixia και 
        jPanel3.setVisible(false);
    }
    

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jPopupMenu1 = new javax.swing.JPopupMenu();
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
        jTextField12 = new javax.swing.JTextField();
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
        jTextField15 = new javax.swing.JTextField();
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
        jTextField24 = new javax.swing.JTextField();
        jTextField26 = new javax.swing.JTextField();
        jTextField27 = new javax.swing.JTextField();
        jTextField31 = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 204));
        jPanel1.setMinimumSize(new java.awt.Dimension(1275, 1047));

        jPanel2.setBackground(new java.awt.Color(211, 238, 255));
        jPanel2.setMinimumSize(new java.awt.Dimension(976, 950));

        jTextField1.setFont(new java.awt.Font("Tahoma", 0, 21)); // NOI18N
        jTextField1.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField1.setText("Προσθήκη Νέου Πελάτη");
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
        jTextField3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField3ActionPerformed(evt);
            }
        });

        jTextField4.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jTextField4.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField4.setText("*Τίτλος Εταιρίας");
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

        jTextField12.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jTextField12.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField12.setText("E-Mail");
        jTextField12.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        jTextField12.setCaretColor(new java.awt.Color(255, 255, 204));
        jTextField12.setDisabledTextColor(new java.awt.Color(255, 255, 204));
        jTextField12.setFocusable(false);
        jTextField12.setRequestFocusEnabled(false);
        jTextField12.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField12ActionPerformed(evt);
            }
        });

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

        jTextField17.setFont(new java.awt.Font("Tahoma", 1, 15)); // NOI18N
        jTextField17.setHorizontalAlignment(javax.swing.JTextField.CENTER);
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
        Final_Button_Enimerosi.setText("Καταχώριση Πελάτη");
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

        jPanel3.setDoubleBuffered(false);
        jPanel3.setRequestFocusEnabled(false);
        jPanel3.setVerifyInputWhenFocusTarget(false);

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

        jTextField15.setFont(new java.awt.Font("Tahoma", 1, 15)); // NOI18N
        jTextField15.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField15.setBorder(null);
        jTextField15.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField15ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTextField34, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addContainerGap(82, Short.MAX_VALUE)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addGroup(jPanel3Layout.createSequentialGroup()
                                    .addComponent(jFormattedTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 85, Short.MAX_VALUE)
                                    .addComponent(jFormattedTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                                    .addComponent(jTextField28, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jTextField29, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(Final_Button_Enimerosi10, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(86, 86, 86)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jTextField30, javax.swing.GroupLayout.DEFAULT_SIZE, 150, Short.MAX_VALUE)
                            .addComponent(jTextField15))))
                .addContainerGap(83, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(jTextField34, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(6, 6, 6)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField28, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField29, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField30, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(3, 3, 3)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jFormattedTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jFormattedTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField15, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(Final_Button_Enimerosi10, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10))
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
            .addComponent(Final_Button_Enimerosi1, javax.swing.GroupLayout.DEFAULT_SIZE, 166, Short.MAX_VALUE)
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
                .addComponent(Final_Button_Enimerosi2, javax.swing.GroupLayout.DEFAULT_SIZE, 167, Short.MAX_VALUE))
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
            .addComponent(Final_Button_Enimerosi3, javax.swing.GroupLayout.DEFAULT_SIZE, 166, Short.MAX_VALUE)
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
            .addComponent(Final_Button_Enimerosi4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 166, Short.MAX_VALUE)
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addComponent(Final_Button_Enimerosi4))
        );

        jPanel8.setBackground(new java.awt.Color(188, 188, 188));

        Final_Button_Enimerosi5.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        Final_Button_Enimerosi5.setText("Alis Import");
        Final_Button_Enimerosi5.setAutoscrolls(true);
        Final_Button_Enimerosi5.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
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
                .addComponent(Final_Button_Enimerosi6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel10Layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(Final_Button_Enimerosi7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel11Layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(Final_Button_Enimerosi8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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
                .addComponent(Final_Button_Enimerosi9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(0, 0, 0))
        );
        jPanel12Layout.setVerticalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel12Layout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addComponent(Final_Button_Enimerosi9))
        );

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

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(Final_Button_Enimerosi, javax.swing.GroupLayout.PREFERRED_SIZE, 494, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap(99, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jTextField22)
                        .addGap(431, 431, 431))
                    .addComponent(jTextField25)
                    .addComponent(jScrollPane1)
                    .addComponent(jTextField1)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jPanel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jCheckBox5, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jPanel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jCheckBox6)
                                .addGap(6, 6, 6)
                                .addComponent(jPanel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jCheckBox7)
                                .addGap(10, 10, 10)
                                .addComponent(jPanel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jCheckBox8, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(7, 7, 7)
                                .addComponent(jPanel12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(1, 1, 1))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jCheckBox1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(7, 7, 7)
                                .addComponent(jCheckBox2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(4, 4, 4)
                                .addComponent(jCheckBox3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jCheckBox9)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jCheckBox4))))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTextField4, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jTextField2, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jTextField6, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jTextField7)))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jTextField10, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jTextField11, javax.swing.GroupLayout.DEFAULT_SIZE, 247, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                .addGap(14, 14, 14)
                                .addComponent(jFormattedTextField6, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jTextField5)
                            .addComponent(jTextField3)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jTextField8, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTextField18, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTextField12, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTextField24, javax.swing.GroupLayout.Alignment.LEADING))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTextField23, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 413, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jTextField9, javax.swing.GroupLayout.PREFERRED_SIZE, 204, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(jTextField13, javax.swing.GroupLayout.DEFAULT_SIZE, 204, Short.MAX_VALUE)
                                        .addComponent(jTextField26)
                                        .addComponent(jTextField19))
                                    .addGap(18, 18, 18)
                                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(jPanel2Layout.createSequentialGroup()
                                            .addComponent(jTextField20, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGap(18, 18, 18)
                                            .addComponent(jTextField21, javax.swing.GroupLayout.PREFERRED_SIZE, 248, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                .addComponent(jTextField27)
                                                .addComponent(jTextField16, javax.swing.GroupLayout.DEFAULT_SIZE, 147, Short.MAX_VALUE))
                                            .addGap(18, 18, 18)
                                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                .addComponent(jTextField31, javax.swing.GroupLayout.DEFAULT_SIZE, 248, Short.MAX_VALUE)
                                                .addComponent(jTextField17)))
                                        .addComponent(jTextField14, javax.swing.GroupLayout.PREFERRED_SIZE, 304, javax.swing.GroupLayout.PREFERRED_SIZE)))))))
                .addContainerGap(102, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap(20, Short.MAX_VALUE)
                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 20, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextField5, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jTextField11, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextField10, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jTextField2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jTextField6, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextField7, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jTextField8, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jTextField14))
                    .addComponent(jFormattedTextField6, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField9, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jTextField17, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jTextField16, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jTextField13, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jTextField12, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jTextField31, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jTextField27, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jTextField26, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jTextField24, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jTextField21, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jTextField20))
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jTextField19, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jTextField18, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField22, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField23, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 16, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jCheckBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jCheckBox3, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addComponent(jPanel5, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jCheckBox2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jPanel6, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jCheckBox4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(4, 4, 4))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jCheckBox5, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jCheckBox6, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addComponent(jPanel10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jCheckBox7, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jCheckBox8, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jCheckBox9, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 20, Short.MAX_VALUE)
                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 18, Short.MAX_VALUE)
                .addComponent(jTextField25, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, Short.MAX_VALUE)
                .addComponent(Final_Button_Enimerosi, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(21, Short.MAX_VALUE))
        );

        jPanel2Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {jTextField10, jTextField18, jTextField20});

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(146, Short.MAX_VALUE)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap(145, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(49, Short.MAX_VALUE)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap(48, Short.MAX_VALUE))
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

    private void jTextField6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField6ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField6ActionPerformed

    private void jTextField8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField8ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField8ActionPerformed

    private void jTextField10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField10ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField10ActionPerformed

    private void jTextField12ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField12ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField12ActionPerformed

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

    private void jTextField5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField5ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField5ActionPerformed

    private void jTextField9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField9ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField9ActionPerformed

    private void Final_Button_EnimerosiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Final_Button_EnimerosiActionPerformed

        //int times=0;
        String str1="";
        String str2="";
        String str3="";
        
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
                String eponimia = jTextField3.getText();
                String titlos   = jTextField5.getText();
                String kodikos  = jTextField7.getText();
                String kinito   = jTextField11.getText();
                    //  Διόρθωση Πεδίου
                        if(kinito.equals(""))
                        {
                            kinito=";";
                        }
                    // Τέλος διόρθωσης Πεδίου
                String tilefono = jTextField9.getText();
                    //  Διόρθωση Πεδίου
                        if(tilefono.equals(""))
                        {
                            tilefono=";";
                        }
                    // Τέλος διόρθωσης Πεδίου
                String xristes  = jFormattedTextField6.getText();
                    //  Διόρθωση Πεδίου
                        if(xristes.equals(""))
                        {
                            xristes=";";
                        }
                    // Τέλος διόρθωσης Πεδίου
                String email    = jTextField13.getText();
                    //  Διόρθωση Πεδίου
                        if(email.equals(""))
                        {
                            email=";";
                        }
                    // Τέλος διόρθωσης Πεδίου
                String adress1   = jTextField17.getText();
                    //  Διόρθωση Πεδίου
                        if(adress1.equals(""))
                        {
                            adress1=";";
                        }
                    // Τέλος διόρθωσης Πεδίου
                String adress2   = jTextField26.getText();
                    //  Διόρθωση Πεδίου
                        if(adress2.equals(""))
                        {
                            adress2=";";
                        }
                    // Τέλος διόρθωσης Πεδίου
                String tk   = jTextField31.getText();
                    //  Διόρθωση Πεδίου
                        if(tk.equals(""))
                        {
                            tk=";";
                        }
                    // Τέλος διόρθωσης Πεδίου
                String afm      = jTextField19.getText();
                    //  Διόρθωση Πεδίου
                        if(afm.equals(""))
                        {
                            afm=";";
                        }
                    // Τέλος διόρθωσης Πεδίου
                String doi      = jTextField21.getText();
                    //  Διόρθωση Πεδίου
                        if(doi.equals(""))
                        {
                            doi=";";
                        }
                    // Τέλος διόρθωσης Πεδίου
                String onIpal   = jTextField23.getText();
                    //  Διόρθωση Πεδίου
                        if(onIpal.equals(""))
                        {
                            onIpal=";";
                        }
                    // Τέλος διόρθωσης Πεδίου
                    
                
                // Kλήση μεθόδου για δημιουργία txt και καταχώριση γενικών στοιχέιων πελάτη
                createTxt(eponimia,titlos,kodikos,kinito,tilefono,xristes,email,adress1,adress2,tk,afm,doi,onIpal);
                
                if(jTextArea1.getText().isEmpty())
                {   
                    System.out.println(" ");
                    System.out.println("jTextArea1 is empty");
                    System.out.println(" ");
                }
                else
                {
                    System.out.println(" ");
                    System.out.println("jTextArea1 is NOT empty");
                    apoth=4;
                    System.out.println(" ");
                }    
                
                
                if(flag1==true || flag2==true ||flag3==true)
                {
                    // μνμ για Λανθασμένη καταχώρηση στοιχείων λόγο προυπάρχοντος πελάτη
                    //JOptionPane.showMessageDialog(null,"Ο συγκεκριμένος πελάτης έχει εισαχθεί είδη στην βάση. Παρακαλώ ελέγξτε τα πεδία: (Επωνυμία - Τίτλος Εταιρίας - Κωδικός)");
                }
                else
                {
                    // μνμ για επιτυχή καταχώριση
                    JOptionPane.showMessageDialog(null,"Η καταχώριση έγινε με επιτυχία!");
                    this.dispose(); // κλήσιμο φόρμας
                }
            }
        }
        catch(Exception e)
        {
            System.out.println("Προέκυψε σφάλμα. Προσπαθήστε ξανά"); // μνμ λάθους για admin
        }
    }//GEN-LAST:event_Final_Button_EnimerosiActionPerformed

    private void jTextField25ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField25ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField25ActionPerformed

    private void Final_Button_Enimerosi1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Final_Button_Enimerosi1ActionPerformed
        if(jCheckBox1.isSelected())
        {
            if(jTextField34.getText().equals("Alis Insurance SQL"))
            {
                
            }
            else
            {
                jTextField34.setText("Alis Insurance SQL");
                jPanel3.setVisible(true);
                jFormattedTextField2.setText(prosorinaStixia[1].replace(';',' '));
                jFormattedTextField4.setText(prosorinaStixia[2].replace(';',' '));
                jTextField15.setText(prosorinaStixia[3].replace(';',' '));
            }    
        }    
    }//GEN-LAST:event_Final_Button_Enimerosi1ActionPerformed

    private void Final_Button_Enimerosi2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Final_Button_Enimerosi2ActionPerformed
        if(jCheckBox2.isSelected())
        {
            if(jTextField34.getText().equals("Alis Insurance ΝΕΤ"))
            {
                
            }
            else
            {
                jTextField34.setText("Alis Insurance ΝΕΤ");
                jPanel3.setVisible(true);
                jFormattedTextField2.setText(prosorinaStixia[5].replace(';',' '));
                jFormattedTextField4.setText(prosorinaStixia[6].replace(';',' '));
                jTextField15.setText(prosorinaStixia[7].replace(';',' '));
            }    
        } 
        
    }//GEN-LAST:event_Final_Button_Enimerosi2ActionPerformed

    private void Final_Button_Enimerosi3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Final_Button_Enimerosi3ActionPerformed
        if(jCheckBox3.isSelected())
        {
            if(jTextField34.getText().equals("Alis Ins SQL Lease"))
            {
                
            }
            else
            {
                jTextField34.setText("Alis Ins SQL Lease");
                jPanel3.setVisible(true);
                jFormattedTextField2.setText(prosorinaStixia[9].replace(';',' '));
                jFormattedTextField4.setText(prosorinaStixia[10].replace(';',' '));
                jTextField15.setText(prosorinaStixia[11].replace(';',' '));
            }    
        } 
    }//GEN-LAST:event_Final_Button_Enimerosi3ActionPerformed

    private void Final_Button_Enimerosi4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Final_Button_Enimerosi4ActionPerformed
        if(jCheckBox4.isSelected())
        {
            if(jTextField34.getText().equals("Alis Ins NET Lease"))
            {
                
            }
            else
            {
                jTextField34.setText("Alis Ins NET Lease");
                jPanel3.setVisible(true);
                jFormattedTextField2.setText(prosorinaStixia[13].replace(';',' '));
                jFormattedTextField4.setText(prosorinaStixia[14].replace(';',' '));
                jTextField15.setText(prosorinaStixia[15].replace(';',' '));
            }
        } 
    }//GEN-LAST:event_Final_Button_Enimerosi4ActionPerformed

    private void Final_Button_Enimerosi5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Final_Button_Enimerosi5ActionPerformed
        if(jCheckBox5.isSelected())
        {
            if(jTextField34.getText().equals("Alis Import"))
            {
                
            }
            else
            {
                jTextField34.setText("Alis Import");
                jPanel3.setVisible(true);
                jFormattedTextField2.setText(prosorinaStixia[17].replace(';',' '));
                jFormattedTextField4.setText(prosorinaStixia[18].replace(';',' '));
                jTextField15.setText(prosorinaStixia[19].replace(';',' '));
            }
        }
    }//GEN-LAST:event_Final_Button_Enimerosi5ActionPerformed

    private void Final_Button_Enimerosi6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Final_Button_Enimerosi6ActionPerformed
        if(jCheckBox6.isSelected())
        {
            if(jTextField34.getText().equals("Alis Portal"))
            {
                
            }
            else
            {   
                jTextField34.setText("Alis Portal");
                jPanel3.setVisible(true);
                jFormattedTextField2.setText(prosorinaStixia[21].replace(';',' '));
                jFormattedTextField4.setText(prosorinaStixia[22].replace(';',' '));
                jTextField15.setText(prosorinaStixia[23].replace(';',' '));
            }
        }
    }//GEN-LAST:event_Final_Button_Enimerosi6ActionPerformed

    private void Final_Button_Enimerosi7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Final_Button_Enimerosi7ActionPerformed
        if(jCheckBox7.isSelected())
        {
            if(jTextField34.getText().equals("ALFA Contract"))
            {
                
            }
            else
            {
                jTextField34.setText("ALFA Contract");
                jPanel3.setVisible(true);
                jFormattedTextField2.setText(prosorinaStixia[25].replace(';',' '));
                jFormattedTextField4.setText(prosorinaStixia[26].replace(';',' '));
                jTextField15.setText(prosorinaStixia[27].replace(';',' '));
            }
        }
    }//GEN-LAST:event_Final_Button_Enimerosi7ActionPerformed

    private void Final_Button_Enimerosi8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Final_Button_Enimerosi8ActionPerformed
        if(jCheckBox8.isSelected())
        {
            if(jTextField34.getText().equals("ALFA Protocol"))
            {
                
            }
            else
            {
                jTextField34.setText("ALFA Protocol");
                jPanel3.setVisible(true);
                jFormattedTextField2.setText(prosorinaStixia[29].replace(';',' '));
                jFormattedTextField4.setText(prosorinaStixia[30].replace(';',' '));
                jTextField15.setText(prosorinaStixia[31].replace(';',' '));
            }
        }
    }//GEN-LAST:event_Final_Button_Enimerosi8ActionPerformed

    private void Final_Button_Enimerosi9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Final_Button_Enimerosi9ActionPerformed
        if(jCheckBox9.isSelected())
        {
            if(jTextField34.getText().equals("Alis Bridge"))
            {
                
            }
            else
            {
                jTextField34.setText("Alis Bridge");
                jPanel3.setVisible(true);
                jFormattedTextField2.setText(prosorinaStixia[33].replace(';',' '));
                jFormattedTextField4.setText(prosorinaStixia[34].replace(';',' '));
                jTextField15.setText(prosorinaStixia[35].replace(';',' '));
            }
        }
    }//GEN-LAST:event_Final_Button_Enimerosi9ActionPerformed

    private void jCheckBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox1ActionPerformed
        if(jCheckBox1.isSelected())
        {
            jPanel4.setBackground(Color.red);
        }
        else
        {
            jFormattedTextField2.setText("");
            jFormattedTextField4.setText("");
            //jFormattedTextField7.setText("");
            jTextField34.setText("");
            jPanel3.setVisible(false);
            jPanel4.setBackground(Color.lightGray);
            // Διόρθωση τιμών πίνακα
                prosorinaStixia[0]="";
                prosorinaStixia[1]="";
                prosorinaStixia[2]="";
                prosorinaStixia[3]="";
            // Τέλος διόρθωσης τιμών πίνακα  
            
            //jPanel4.setVisible(false);
        }
    }//GEN-LAST:event_jCheckBox1ActionPerformed

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
            if(s4.equals("") || s5.equals("") || s6.equals(""))
            {
                flag= false;
            }
            else
            {
                jTextField3.setEnabled(false);
                jTextField5.setEnabled(false);
                jTextField7.setEnabled(false);
            }
            if(s1.equals("") || s2.equals(""))
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
                        prosorinaStixia[0]="Alis Insurance SQL";
                        prosorinaStixia[1]=(jFormattedTextField2.getText());
                        prosorinaStixia[2]=(jFormattedTextField4.getText());
                        prosorinaStixia[3]=(jTextField15.getText().replaceAll("[a-zA-Z]", " ").replaceAll("[α-ωΑ-Ω]", " ").replace('!',' ').replace(';',' ').replace('-',' ').replace('_',' ').replace('=',' ').replace('+',' ').replace('`',' ').replace('¬',' ').replace('£',' ').replace('%',' ').replace('^',' ').replace('&',' ').replace('*',' ').replace('(',' ').replace(')',' ').replace('{',' ').replace('}',' ').replace('[',' ').replace(']',' ').replace(':',' ').replace(';',' ').replace('@',' ').replace('#',' ').replace('~',' ').replace('<',' ').replace('>',' ').replace('/',' ').replace('?',' ').trim().replace(' ','-'));
                        if(prosorinaStixia[3].equals(""))
                        {
                            prosorinaStixia[3]="-";
                        }
                        jPanel4.setBackground(Color.green.darker());
                        System.out.println();
                    }
                    else if(jTextField34.getText().equals("Alis Insurance ΝΕΤ"))
                    {
                        prosorinaStixia[4]=("Alis Insurance ΝΕΤ");
                        prosorinaStixia[5]=(jFormattedTextField2.getText());
                        prosorinaStixia[6]=(jFormattedTextField4.getText());
                        prosorinaStixia[7]=(jTextField15.getText().replaceAll("[a-zA-Z]", " ").replaceAll("[α-ωΑ-Ω]", " ").replace('!',' ').replace(';',' ').replace('-',' ').replace('_',' ').replace('=',' ').replace('+',' ').replace('`',' ').replace('¬',' ').replace('£',' ').replace('%',' ').replace('^',' ').replace('&',' ').replace('*',' ').replace('(',' ').replace(')',' ').replace('{',' ').replace('}',' ').replace('[',' ').replace(']',' ').replace(':',' ').replace(';',' ').replace('@',' ').replace('#',' ').replace('~',' ').replace('<',' ').replace('>',' ').replace('/',' ').replace('?',' ').trim().replace(' ','-'));
                        if(prosorinaStixia[7].equals(""))
                        {
                            prosorinaStixia[7]="-";
                        }
                        jPanel5.setBackground(Color.green.darker());
                    }
                    else if(jTextField34.getText().equals("Alis Ins SQL Lease"))
                    {
                        prosorinaStixia[8]=("Alis Ins SQL Lease");
                        prosorinaStixia[9]=(jFormattedTextField2.getText());
                        prosorinaStixia[10]=(jFormattedTextField4.getText());
                        prosorinaStixia[11]=(jTextField15.getText().replaceAll("[a-zA-Z]", " ").replaceAll("[α-ωΑ-Ω]", " ").replace('!',' ').replace(';',' ').replace('-',' ').replace('_',' ').replace('=',' ').replace('+',' ').replace('`',' ').replace('¬',' ').replace('£',' ').replace('%',' ').replace('^',' ').replace('&',' ').replace('*',' ').replace('(',' ').replace(')',' ').replace('{',' ').replace('}',' ').replace('[',' ').replace(']',' ').replace(':',' ').replace(';',' ').replace('@',' ').replace('#',' ').replace('~',' ').replace('<',' ').replace('>',' ').replace('/',' ').replace('?',' ').trim().replace(' ','-'));
                        if(prosorinaStixia[11].equals(""))
                        {
                            prosorinaStixia[11]="-";
                        }
                        jPanel6.setBackground(Color.green.darker());
                    }
                    else if(jTextField34.getText().equals("Alis Ins NET Lease"))
                    {
                        prosorinaStixia[12]=("Alis Ins NET Lease");
                        prosorinaStixia[13]=(jFormattedTextField2.getText());
                        prosorinaStixia[14]=(jFormattedTextField4.getText());
                        prosorinaStixia[15]=(jTextField15.getText().replaceAll("[a-zA-Z]", " ").replaceAll("[α-ωΑ-Ω]", " ").replace('!',' ').replace(';',' ').replace('-',' ').replace('_',' ').replace('=',' ').replace('+',' ').replace('`',' ').replace('¬',' ').replace('£',' ').replace('%',' ').replace('^',' ').replace('&',' ').replace('*',' ').replace('(',' ').replace(')',' ').replace('{',' ').replace('}',' ').replace('[',' ').replace(']',' ').replace(':',' ').replace(';',' ').replace('@',' ').replace('#',' ').replace('~',' ').replace('<',' ').replace('>',' ').replace('/',' ').replace('?',' ').trim().replace(' ','-'));
                        if(prosorinaStixia[15].equals(""))
                        {
                            prosorinaStixia[15]="-";
                        }
                        jPanel7.setBackground(Color.green.darker());
                    }
                    else if(jTextField34.getText().equals("Alis Import"))
                    {
                        prosorinaStixia[16]=("Alis Import");
                        prosorinaStixia[17]=(jFormattedTextField2.getText());
                        prosorinaStixia[18]=(jFormattedTextField4.getText());
                        prosorinaStixia[19]=(jTextField15.getText().replaceAll("[a-zA-Z]", " ").replaceAll("[α-ωΑ-Ω]", " ").replace('!',' ').replace(';',' ').replace('-',' ').replace('_',' ').replace('=',' ').replace('+',' ').replace('`',' ').replace('¬',' ').replace('£',' ').replace('%',' ').replace('^',' ').replace('&',' ').replace('*',' ').replace('(',' ').replace(')',' ').replace('{',' ').replace('}',' ').replace('[',' ').replace(']',' ').replace(':',' ').replace(';',' ').replace('@',' ').replace('#',' ').replace('~',' ').replace('<',' ').replace('>',' ').replace('/',' ').replace('?',' ').trim().replace(' ','-'));
                        if(prosorinaStixia[19].equals(""))
                        {
                            prosorinaStixia[19]="-";
                        }
                        jPanel8.setBackground(Color.green.darker());
                    }
                    else if(jTextField34.getText().equals("Alis Portal"))
                    {
                        prosorinaStixia[20]=("Alis Portal");
                        prosorinaStixia[21]=(jFormattedTextField2.getText());
                        prosorinaStixia[22]=(jFormattedTextField4.getText());
                        prosorinaStixia[23]=(jTextField15.getText().replaceAll("[a-zA-Z]", " ").replaceAll("[α-ωΑ-Ω]", " ").replace('!',' ').replace(';',' ').replace('-',' ').replace('_',' ').replace('=',' ').replace('+',' ').replace('`',' ').replace('¬',' ').replace('£',' ').replace('%',' ').replace('^',' ').replace('&',' ').replace('*',' ').replace('(',' ').replace(')',' ').replace('{',' ').replace('}',' ').replace('[',' ').replace(']',' ').replace(':',' ').replace(';',' ').replace('@',' ').replace('#',' ').replace('~',' ').replace('<',' ').replace('>',' ').replace('/',' ').replace('?',' ').trim().replace(' ','-'));
                        if(prosorinaStixia[23].equals(""))
                        {
                            prosorinaStixia[23]="-";
                        }
                        jPanel9.setBackground(Color.green.darker());
                    }
                    else if(jTextField34.getText().equals("ALFA Contract"))
                    {
                        prosorinaStixia[24]=("ALFA Contract");
                        prosorinaStixia[25]=(jFormattedTextField2.getText());
                        prosorinaStixia[26]=(jFormattedTextField4.getText());
                        prosorinaStixia[27]=(jTextField15.getText().replaceAll("[a-zA-Z]", " ").replaceAll("[α-ωΑ-Ω]", " ").replace('!',' ').replace(';',' ').replace('-',' ').replace('_',' ').replace('=',' ').replace('+',' ').replace('`',' ').replace('¬',' ').replace('£',' ').replace('%',' ').replace('^',' ').replace('&',' ').replace('*',' ').replace('(',' ').replace(')',' ').replace('{',' ').replace('}',' ').replace('[',' ').replace(']',' ').replace(':',' ').replace(';',' ').replace('@',' ').replace('#',' ').replace('~',' ').replace('<',' ').replace('>',' ').replace('/',' ').replace('?',' ').trim().replace(' ','-'));
                        if(prosorinaStixia[27].equals(""))
                        {
                            prosorinaStixia[27]="-";
                        }
                        jPanel10.setBackground(Color.green.darker());
                    }
                    else if(jTextField34.getText().equals("ALFA Protocol"))
                    {
                        prosorinaStixia[28]=("ALFA Protocol");
                        prosorinaStixia[29]=(jFormattedTextField2.getText());
                        prosorinaStixia[30]=(jFormattedTextField4.getText());
                        prosorinaStixia[31]=(jTextField15.getText().replaceAll("[a-zA-Z]", " ").replaceAll("[α-ωΑ-Ω]", " ").replace('!',' ').replace(';',' ').replace('-',' ').replace('_',' ').replace('=',' ').replace('+',' ').replace('`',' ').replace('¬',' ').replace('£',' ').replace('%',' ').replace('^',' ').replace('&',' ').replace('*',' ').replace('(',' ').replace(')',' ').replace('{',' ').replace('}',' ').replace('[',' ').replace(']',' ').replace(':',' ').replace(';',' ').replace('@',' ').replace('#',' ').replace('~',' ').replace('<',' ').replace('>',' ').replace('/',' ').replace('?',' ').trim().replace(' ','-'));
                        if(prosorinaStixia[31].equals(""))
                        {
                            prosorinaStixia[31]="-";
                        }
                        jPanel11.setBackground(Color.green.darker());
                    }
                    else if(jTextField34.getText().equals("Alis Bridge"))
                    {
                        prosorinaStixia[32]=("Alis Bridge");
                        prosorinaStixia[33]=(jFormattedTextField2.getText());
                        prosorinaStixia[34]=(jFormattedTextField4.getText());
                        prosorinaStixia[35]=(jTextField15.getText().replaceAll("[a-zA-Z]", " ").replaceAll("[α-ωΑ-Ω]", " ").replace('!',' ').replace(';',' ').replace('-',' ').replace('_',' ').replace('=',' ').replace('+',' ').replace('`',' ').replace('¬',' ').replace('£',' ').replace('%',' ').replace('^',' ').replace('&',' ').replace('*',' ').replace('(',' ').replace(')',' ').replace('{',' ').replace('}',' ').replace('[',' ').replace(']',' ').replace(':',' ').replace(';',' ').replace('@',' ').replace('#',' ').replace('~',' ').replace('<',' ').replace('>',' ').replace('/',' ').replace('?',' ').trim().replace(' ','-'));
                        if(prosorinaStixia[35].equals(""))
                        {
                            prosorinaStixia[35]="-";
                        }
                        jPanel12.setBackground(Color.green.darker());
                    }
                    
                    // μνμ για συμπλήρωση υποχρεωτικών πεδίων
                    JOptionPane.showMessageDialog(null,"Επιτυχής Καταχώριση");
                }
            }
        }    
    }//GEN-LAST:event_Final_Button_Enimerosi10ActionPerformed

    private void jCheckBox2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox2ActionPerformed
        if(jCheckBox2.isSelected())
        {
            jPanel5.setBackground(Color.red);
        }
        else
        {
            jFormattedTextField2.setText("");
            jFormattedTextField4.setText("");
            //jFormattedTextField7.setText("");
            jTextField34.setText("");
            jPanel3.setVisible(false);
            jPanel5.setBackground(Color.lightGray);
            // Διόρθωση τιμών πίνακα
                prosorinaStixia[4]="";
                prosorinaStixia[5]="";
                prosorinaStixia[6]="";
                prosorinaStixia[7]="";
            // Τέλος διόρθωσης τιμών πίνακα
        }
    }//GEN-LAST:event_jCheckBox2ActionPerformed

    private void jCheckBox3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox3ActionPerformed
        if(jCheckBox3.isSelected())
        {
            jPanel6.setBackground(Color.red);
        }
        else
        {
            jFormattedTextField2.setText("");
            jFormattedTextField4.setText("");
            //jFormattedTextField7.setText("");
            jTextField34.setText("");
            jPanel3.setVisible(false);
            jPanel6.setBackground(Color.lightGray);
            // Διόρθωση τιμών πίνακα
                prosorinaStixia[8]="";
                prosorinaStixia[9]="";
                prosorinaStixia[10]="";
                prosorinaStixia[11]="";
            // Τέλος διόρθωσης τιμών πίνακα
        }
    }//GEN-LAST:event_jCheckBox3ActionPerformed

    private void jCheckBox4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox4ActionPerformed
        if(jCheckBox4.isSelected())
        {
            jPanel7.setBackground(Color.red);
        }
        else
        {
            jFormattedTextField2.setText("");
            jFormattedTextField4.setText("");
            //jFormattedTextField7.setText("");
            jTextField34.setText("");
            jPanel3.setVisible(false);
            jPanel7.setBackground(Color.lightGray);
            // Διόρθωση τιμών πίνακα
                prosorinaStixia[12]="";
                prosorinaStixia[13]="";
                prosorinaStixia[14]="";
                prosorinaStixia[15]="";
            // Τέλος διόρθωσης τιμών πίνακα
        }
    }//GEN-LAST:event_jCheckBox4ActionPerformed

    private void jCheckBox5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox5ActionPerformed
        if(jCheckBox5.isSelected())
        {
            jPanel8.setBackground(Color.red);
        }
        else
        {
            jFormattedTextField2.setText("");
            jFormattedTextField4.setText("");
            //jFormattedTextField7.setText("");
            jTextField34.setText("");
            jPanel3.setVisible(false);
            jPanel8.setBackground(Color.lightGray);
            // Διόρθωση τιμών πίνακα
                prosorinaStixia[16]="";
                prosorinaStixia[17]="";
                prosorinaStixia[18]="";
                prosorinaStixia[19]="";
            // Τέλος διόρθωσης τιμών πίνακα
        }
    }//GEN-LAST:event_jCheckBox5ActionPerformed

    private void jCheckBox6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox6ActionPerformed
        if(jCheckBox6.isSelected())
        {
            jPanel9.setBackground(Color.red);
        }
        else
        {
            jFormattedTextField2.setText("");
            jFormattedTextField4.setText("");
            //jFormattedTextField7.setText("");
            jTextField34.setText("");
            jPanel3.setVisible(false);
            jPanel9.setBackground(Color.lightGray);
            // Διόρθωση τιμών πίνακα
                prosorinaStixia[20]="";
                prosorinaStixia[21]="";
                prosorinaStixia[22]="";
                prosorinaStixia[23]="";
            // Τέλος διόρθωσης τιμών πίνακα
        }
    }//GEN-LAST:event_jCheckBox6ActionPerformed

    private void jCheckBox7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox7ActionPerformed
        if(jCheckBox7.isSelected())
        {
            jPanel10.setBackground(Color.red);
        }
        else
        {
            jFormattedTextField2.setText("");
            jFormattedTextField4.setText("");
            //jFormattedTextField7.setText("");
            jTextField34.setText("");
            jPanel3.setVisible(false);
            jPanel10.setBackground(Color.lightGray);
            // Διόρθωση τιμών πίνακα
                prosorinaStixia[24]="";
                prosorinaStixia[25]="";
                prosorinaStixia[26]="";
                prosorinaStixia[27]="";
            // Τέλος διόρθωσης τιμών πίνακα
        }
    }//GEN-LAST:event_jCheckBox7ActionPerformed

    private void jCheckBox8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox8ActionPerformed
        if(jCheckBox8.isSelected())
        {
            jPanel11.setBackground(Color.red);
        }
        else
        {
            jFormattedTextField2.setText("");
            jFormattedTextField4.setText("");
            //jFormattedTextField7.setText("");
            jTextField34.setText("");
            jPanel3.setVisible(false);
            jPanel11.setBackground(Color.lightGray);
            // Διόρθωση τιμών πίνακα
                prosorinaStixia[28]="";
                prosorinaStixia[29]="";
                prosorinaStixia[30]="";
                prosorinaStixia[31]="";
            // Τέλος διόρθωσης τιμών πίνακα
        }
    }//GEN-LAST:event_jCheckBox8ActionPerformed

    private void jCheckBox9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox9ActionPerformed
        if(jCheckBox9.isSelected())
        {
            jPanel12.setBackground(Color.red);
        }
        else
        {
            jFormattedTextField2.setText("");
            jFormattedTextField4.setText("");
            //jFormattedTextField7.setText("");
            jTextField34.setText("");
            jPanel3.setVisible(false);
            jPanel12.setBackground(Color.lightGray);
            // Διόρθωση τιμών πίνακα
                prosorinaStixia[32]="";
                prosorinaStixia[33]="";
                prosorinaStixia[34]="";
                prosorinaStixia[35]="";
            // Τέλος διόρθωσης τιμών πίνακα
        }
    }//GEN-LAST:event_jCheckBox9ActionPerformed

    private void jFormattedTextField2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jFormattedTextField2ActionPerformed
        
    }//GEN-LAST:event_jFormattedTextField2ActionPerformed

    private void jFormattedTextField6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jFormattedTextField6ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jFormattedTextField6ActionPerformed

    private void jTextField3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField3ActionPerformed
        
    }//GEN-LAST:event_jTextField3ActionPerformed

    private void jTextField24ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField24ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField24ActionPerformed

    private void jTextField26ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField26ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField26ActionPerformed

    private void jTextField27ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField27ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField27ActionPerformed

    private void jTextField15ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField15ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField15ActionPerformed

    
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
            java.util.logging.Logger.getLogger(addCustomers.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(addCustomers.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(addCustomers.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(addCustomers.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new addCustomers().setVisible(true);
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
    private javax.swing.ButtonGroup buttonGroup1;
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
    private javax.swing.JPopupMenu jPopupMenu1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField10;
    private javax.swing.JTextField jTextField11;
    private javax.swing.JTextField jTextField12;
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
    private javax.swing.JTextField jTextField34;
    private javax.swing.JTextField jTextField4;
    private javax.swing.JTextField jTextField5;
    private javax.swing.JTextField jTextField6;
    private javax.swing.JTextField jTextField7;
    private javax.swing.JTextField jTextField8;
    private javax.swing.JTextField jTextField9;
    // End of variables declaration//GEN-END:variables
}