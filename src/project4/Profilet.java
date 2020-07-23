/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project4;

import java.awt.ComponentOrientation;
import java.awt.Desktop;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Point;
import java.awt.TextArea;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import static java.awt.event.KeyEvent.VK_ENTER;
import java.awt.event.MouseEvent;
import java.io.IOException;
import static java.lang.Thread.sleep;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.DataLine;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;

/**
 *
 * @author Amen
 */
public class Profilet extends javax.swing.JFrame {
    static int n;
    
  
    /**
     * Creates new form Profilet
     */
    
    //fonction eli 9olti 3liha tableau resultat t edha hajtk mn b3d b taille mt3a n  rodha  static 
    /****************************************
     * 
     * @param s
     * @return 
     */
    
    public String  newChaine(String s){
        String []t =null;
        String s1="";
        int i,j=0;
        
            n= s.length()/50+1;
            t=new String[n];
            for(i=0;i<n;i++){
                if(j+50<=n)
                t[i]=s.substring(i+j,j+50);
                else
                    t[i]=s.substring(i+j,s.length());
                j=50;
                s1+=t[i];
                s1+="\n";
            }
        System.out.println(s1);
        return s1;
  
    }
    
    public Profilet() {
        
        initComponents();
          String name=Home4.userName;
          this.jLabel4.setText(name);
    }
   
    String util;
        int a=430,c=430,x=10,h=0;
        

private void createtextfield () throws ClassNotFoundException, IOException, URISyntaxException, InterruptedException
    {
        
       boolean test=false;
        String reponse="";
       n=1;
   
      
h=h+1;
//******************importation des images
                JLabel jLabelb = new javax.swing.JLabel();
                JLabel jLabelp = new javax.swing.JLabel();
                jLabelb.setIcon(new javax.swing.ImageIcon("C:\\Users\\nesri\\Desktop\\ProjectBot\\src\\project4\\bot-icon.png"));
                jLabelp.setIcon(new javax.swing.ImageIcon("C:\\Users\\nesri\\Desktop\\ProjectBot\\src\\project4\\USER.png"));
                
//******************declaration person
       JTextArea jTextArea2= new javax.swing.JTextArea(50,50);
        jTextArea2.setLineWrap(true);
        jTextArea2.setWrapStyleWord(true);
        jTextArea2.setColumns(20);
        jTextArea2.setRows(5);
        jTextArea2.setBackground(new java.awt.Color(36,47,65));
        jTextArea2.setFont(new java.awt.Font("Monospaced", 0, 16)); // NOI18N
        jTextArea2.setForeground(new java.awt.Color(255, 255, 255));
        jTextArea2.setText("");
        jTextArea2.setToolTipText("");
        jTextArea2.setBorder(null);
        jTextArea2.setEditable(false);
        jTextArea2.setDisabledTextColor(new java.awt.Color(204, 204, 204));
 //******************declaration bot
       JTextArea jTextArea3= new javax.swing.JTextArea(50,50);
        jTextArea3.setLineWrap(true);
        jTextArea3.setWrapStyleWord(true);
        jTextArea3.setColumns(20);
        jTextArea3.setRows(5);
        jTextArea3.setBackground(new java.awt.Color(36,47,65));
        jTextArea3.setFont(new java.awt.Font("Monospaced", 0, 16)); // NOI18N
        jTextArea3.setForeground(new java.awt.Color(255, 255, 255));
        jTextArea3.setText("");
        jTextArea3.setToolTipText("");
        jTextArea3.setBorder(null);
        jTextArea3.setEditable(false);
        jTextArea3.setDisabledTextColor(new java.awt.Color(204, 204, 204));
        jTextArea2.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);


//******************recuperation de la chaine du textarea et l'affichage person
            
                util= jTextArea1.getText();
               if(util.length()>50){
                util=newChaine(util);
                //System.out.println("ggggggg"+n);
                 //System.out.println("dqsdqsdqsdqsd "+util);
               }
                jTextArea2.setText(util);
                jScrollPane3.setViewportView(jTextArea2);
                jLabelp.setBounds(550, x, 50, 50);
                x=x+15;
                jTextArea2.setBounds(20, x, 520, n*22);
                x=x+22*n;
                jPanel5.add(jTextArea2);
                jPanel5.add(jLabelp);

                
        //image bot in jlabel
              
//****************** ajout d'un separateur 
         JSeparator jSeparator5 = new javax.swing.JSeparator();
         x=x+22;
         jSeparator5.setBounds(20, x, 580, 10);
         x=x+6;
         //jPanel5.setViewportView(jSeparator5);

         jSeparator5.setBackground(new java.awt.Color(37,183,211));
         jSeparator5.setForeground(new java.awt.Color(37,183,211));

        jPanel5.setPreferredSize(new Dimension(640, 430));//soluuuutionnnnnnnn
        

           jPanel5.add(jSeparator5);

 //******************recuperation de la chaine du bd et l'affichage bot
                try{
               Class.forName("oracle.jdbc.driver.OracleDriver");
               System.out.println("no erreur ");
             try(Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","manager"))
             {
                 System.out.println("connection :D");
                 Statement st=conn.createStatement();
                 String s1;
                 s1=jTextArea1.getText().toUpperCase();
                 
                 // ResultSet rs=st.executeQuery("select * from question where qut='"+s+"'");
                   ResultSet rs=st.executeQuery("select reponse from question where qut='"+s1+"'");
                 // if(rs.next())
                 
                     while(rs.next()){
                          reponse=rs.getString(1);
                          System.out.println(reponse);
                          test=true;
                          //System.out.println(test+"moi test");
                    }
                
                  
                   //ask google a question
                  
                    
                   
                
                  
               
                     conn.close();
                } catch (SQLException ex) {
                    Logger.getLogger(Home4.class.getName()).log(Level.SEVERE, null, ex);
                }
           
       }catch(ClassNotFoundException ex){
           System.out.println("erreur Driver");
       }

 
 
                  
                jScrollPane3.setViewportView(jTextArea3);
                    
                String s="I don t know the answer , Do you want me to search \nfor it on Google ";
                if(test==false){
                         x=x+5;
                         jLabelb.setBounds(20, x, 50,50);
                         x=x+15;
                         jTextArea3.setBounds(80, x, 520,44);
                        x=x+44;
                        jTextArea3.setText(s);
                        JButton jButton1=new javax.swing.JButton("YES");
                        JButton jButton2=new javax.swing.JButton("NO");
                        x=x+5;
                        jButton1.setBounds(80,x,60,22);
                        x=x;
                        jButton2.setBounds(150,x,60,22);
                        x=x+44;
                        jPanel5.add(jButton1);
                        jPanel5.add(jButton2);
                        jButton1.addActionListener(new ActionListener(){
                            @Override
                            public void actionPerformed(ActionEvent e) {
                                  try{
                                   
                                     Desktop d=Desktop.getDesktop()  ;
                                     try{
                                     d.browse(new URI("https://www.google.tn/search?safe=active&source=hp&ei=gxbUWr_mC8HVwQK0uqLQAQ&q="+util+"&oq="+util+"&gs_l=psy-ab.3..0l10.1416.1780.0.1928.5.4.0.0.0.0.130.354.0j3.4.0....0...1c.1.64.psy-ab..1.3.352.0..0i131k1j0i3k1.108.Kqk_lQrU0Jg"));
                                     }catch(URISyntaxException ex){
                                        d.browse(new URI("https://www.google.com"));
                                     }
                               } catch (IOException ex) {
                                    Logger.getLogger(Profilet.class.getName()).log(Level.SEVERE, null, ex);
                                } catch (URISyntaxException ex) {
                                    Logger.getLogger(Profilet.class.getName()).log(Level.SEVERE, null, ex);
                                }
                    
                            }
                        });
                            jButton2.addActionListener(new ActionListener(){
                            @Override
                            public void actionPerformed(ActionEvent e) {
                                  jTextArea3.setText("As you want"); 
                                  jButton1.setVisible(false);
                                  jButton2.setVisible(false);
                            }
                                
                                
                                
                            });
                            
                            
                            
                            
                            
                       
                
                }
                else{
                    n=1;
                    if(reponse.length()>50){
                        reponse=newChaine(reponse);
                         System.out.println(reponse);
                    }
                     x=x+5;
                         jLabelb.setBounds(20, x, 50,50);
                         x=x+15;
                         jTextArea3.setBounds(80, x, 520, n*22);
                        x=x+n*20;
                    jTextArea3.setText(reponse);
                    
                 
                }  
                    test=false;
                
                jPanel5.add(jTextArea3);
                jPanel5.add(jLabelb);
               
            //jPanel5.setViewportView(jSeparator5);
//******************ajout d'un separateur
        JSeparator jSeparator6 = new javax.swing.JSeparator();
            x=x+22;
            jSeparator6.setBounds(20, x, 580, 10);
            x=x+6;
            jSeparator6.setBackground(new java.awt.Color(37,183,211));
            jSeparator6.setForeground(new java.awt.Color(37,183,211));
            
            //jPanel5.setPreferredSize(new Dimension(640, 430));//soluuuutionnnnnnnn
            jPanel5.add(jSeparator6);
           

            a=a+113;
        jPanel5.setPreferredSize(new Dimension(640, a));
        //jScrollPane1.getViewport().setViewPosition(new Point(0,c+55));
        if (x>430)
        {  c=c+(x-c);//you are a genuisssssssssssss <3
        System.out.println(a);
        System.out.println(c);

        jPanel5.setPreferredSize(new Dimension(640, c));
        jScrollPane1.getViewport().setViewPosition(new Point(0,c));
        }
        

        jScrollPane3.setViewportView(jTextArea1);
        jTextArea1.setText(null);
        jTextArea1.requestFocusInWindow();



    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel4 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jPanel5 = new javax.swing.JPanel();
        jSeparator1 = new javax.swing.JSeparator();
        jSeparator2 = new javax.swing.JSeparator();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jLabel3 = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 310, Short.MAX_VALUE)
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 340, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(36, 47, 65));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(37, 183, 211));
        jPanel2.setToolTipText("");
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/project4/USER.png"))); // NOI18N
        jLabel4.setText("                    ");
        jPanel2.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 40, -1, -1));

        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/project4/fb.png"))); // NOI18N
        jLabel6.setText("Facebook Page");
        jLabel6.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel6.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel6MouseClicked(evt);
            }
        });
        jPanel2.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 360, -1, -1));

        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/project4/tw.png"))); // NOI18N
        jLabel7.setText("Twitter Page");
        jLabel7.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel7.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel7MouseClicked(evt);
            }
        });
        jPanel2.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 420, -1, -1));

        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/project4/yt.png"))); // NOI18N
        jLabel8.setText("Youtube Channel");
        jLabel8.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel8MouseClicked(evt);
            }
        });
        jPanel2.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 480, -1, -1));

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/project4/bg.png"))); // NOI18N
        jLabel5.setText("jLabel5");
        jPanel2.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 200, 560));

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 200, 560));

        jScrollPane1.setBorder(null);
        jScrollPane1.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        jScrollPane1.setAutoscrolls(true);
        jScrollPane1.setFocusCycleRoot(true);

        jPanel5.setBackground(new java.awt.Color(36, 47, 65));
        jPanel5.setPreferredSize(new java.awt.Dimension(808, 323));

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 808, Short.MAX_VALUE)
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 430, Short.MAX_VALUE)
        );

        jScrollPane1.setViewportView(jPanel5);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 60, 640, 430));
        jPanel1.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 52, 640, 10));
        jPanel1.add(jSeparator2, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 490, 640, 10));

        jScrollPane3.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        jScrollPane3.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);

        jTextArea1.setColumns(20);
        jTextArea1.setRows(1);
        jTextArea1.setBorder(null);
        jTextArea1.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        jTextArea1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jTextArea1MousePressed(evt);
            }
        });
        jTextArea1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTextArea1KeyPressed(evt);
            }
        });
        jScrollPane3.setViewportView(jTextArea1);
        jTextArea1.getAccessibleContext().setAccessibleDescription("");

        jPanel1.add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 500, 590, 60));

        jLabel3.setFont(new java.awt.Font("Monospaced", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(37, 183, 211));
        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/project4/bot-icon.png"))); // NOI18N
        jLabel3.setText("BANP beta");
        jLabel3.setAutoscrolls(true);
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 0, 160, 50));

        jPanel6.setBackground(new java.awt.Color(37, 183, 211));

        jLabel2.setBackground(new java.awt.Color(22, 22, 22));
        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/project4/send.png"))); // NOI18N
        jLabel2.setText("jLabel2");
        jLabel2.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jLabel2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel2MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 10, Short.MAX_VALUE))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addComponent(jLabel2)
                .addGap(0, 10, Short.MAX_VALUE))
        );

        jPanel1.add(jPanel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(790, 500, 60, 60));

        jLabel1.setFont(new java.awt.Font("Monospaced", 1, 15)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/project4/lg.png"))); // NOI18N
        jLabel1.setText("Log out");
        jLabel1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel1MouseClicked(evt);
            }
        });
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 0, -1, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 842, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 842, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 551, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 551, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jLabel2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel2MouseClicked
        try {
            // TODO add your handling code here:

            createtextfield ();
          
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Profilet.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Profilet.class.getName()).log(Level.SEVERE, null, ex);
        } catch (URISyntaxException ex) {
            Logger.getLogger(Profilet.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InterruptedException ex) {
            Logger.getLogger(Profilet.class.getName()).log(Level.SEVERE, null, ex);
        }
        jTextArea1.setText(null);
    }//GEN-LAST:event_jLabel2MouseClicked

    private void jTextArea1KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextArea1KeyPressed
        if(evt.getKeyCode()==VK_ENTER){
            try {
                // TODO add your handling code here:

                createtextfield ();
                evt.consume();
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(Profilet.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                Logger.getLogger(Profilet.class.getName()).log(Level.SEVERE, null, ex);
            } catch (URISyntaxException ex) {
                Logger.getLogger(Profilet.class.getName()).log(Level.SEVERE, null, ex);
            }   catch (InterruptedException ex) {
                Logger.getLogger(Profilet.class.getName()).log(Level.SEVERE, null, ex);
            }
        jTextArea1.setText(null);
        }
        

    }//GEN-LAST:event_jTextArea1KeyPressed

    private void jTextArea1MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTextArea1MousePressed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextArea1MousePressed

    private void jLabel1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel1MouseClicked
        System.exit(0);
    }//GEN-LAST:event_jLabel1MouseClicked

    private void jLabel6MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel6MouseClicked
       Desktop d=Desktop.getDesktop();
        try {
            d.browse(new URI("https://www.Facebook.com"));
        } catch (IOException ex) {
            Logger.getLogger(Profilet.class.getName()).log(Level.SEVERE, null, ex);
        } catch (URISyntaxException ex) {
            Logger.getLogger(Profilet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jLabel6MouseClicked

    private void jLabel7MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel7MouseClicked
       Desktop d=Desktop.getDesktop();
        try {
            d.browse(new URI("https://www.twitter.com"));
        } catch (IOException ex) {
            Logger.getLogger(Profilet.class.getName()).log(Level.SEVERE, null, ex);
        } catch (URISyntaxException ex) {
            Logger.getLogger(Profilet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jLabel7MouseClicked

    private void jLabel8MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel8MouseClicked
       Desktop d=Desktop.getDesktop();
        try {
            d.browse(new URI("https://www.youtube.com"));
        } catch (IOException ex) {
            Logger.getLogger(Profilet.class.getName()).log(Level.SEVERE, null, ex);
        } catch (URISyntaxException ex) {
            Logger.getLogger(Profilet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jLabel8MouseClicked
    
   
    
    
        
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
            java.util.logging.Logger.getLogger(Profilet.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Profilet.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Profilet.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Profilet.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
      
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Profilet().setVisible(true);
                
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JTextArea jTextArea1;
    // End of variables declaration//GEN-END:variables
}
