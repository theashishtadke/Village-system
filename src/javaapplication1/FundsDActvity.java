/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author ADMIN
 */
public class FundsDActvity extends javax.swing.JFrame {

    /**
     * Creates new form FundsDActvity
     */
    public FundsDActvity() {
        initComponents();
        this.setLocationRelativeTo(null);
    }
    int basic, education, health, san;
    int grade = 0;
    final int Distance_W = 5;
    final int Distance_ps = 2;

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        funds = new javax.swing.JTextField();
        Distribute = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Enter Funds");

        funds.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fundsActionPerformed(evt);
            }
        });

        Distribute.setText("Distribute");
        Distribute.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DistributeActionPerformed(evt);
            }
        });

        jButton1.setText("Back");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(funds, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(Distribute))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jButton1)))
                .addContainerGap(46, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButton1)
                .addGap(26, 26, 26)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(funds, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Distribute))
                .addContainerGap(23, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void fundsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fundsActionPerformed

        // TODO add your handling code here:
    }//GEN-LAST:event_fundsActionPerformed

    private void DistributeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DistributeActionPerformed
        try {

            String Query = "update village set grade=? where id=?";
            Class.forName("com.mysql.jdbc.Driver");
            Connection con;
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/village", "root", "vinay");
            PreparedStatement pr = con.prepareStatement("select * from village ");
            PreparedStatement st = con.prepareStatement(Query);
            ResultSet rs = pr.executeQuery();
            //rs.next();
            int i = 0;
            System.out.println("1 for " + (i + 1));
            while (rs.next()) {
                //electricity
                if (rs.getBoolean(7)) {
                    System.out.println("inside if");
                    basic++;
                    grade++;
                }
                    //hosptial
                    if (rs.getBoolean(8)) {
                        grade++;
                        health++;
                    }
                    //medical
                    if (rs.getBoolean(9)) {
                        grade++;
                        health++;
                    }
                    //water
                    if (rs.getBoolean(10)) {
                        grade++;
                        basic++;
                    }
                    // diatnce from water
                    if (rs.getInt(11) <= Distance_W) {
                        basic++;
                        grade++;
                    }
                    //pharmasi
                    if (rs.getBoolean(12)) {
                        health++;
                        grade++;
                    }
                    //primary school
                    if (rs.getBoolean(13)) {
                        education++;
                        grade++;
                    }
                    // diatnce from ps
                    if (rs.getInt(14) <= Distance_ps) {
                        education++;
                        grade++;
                    }

                    //scondary school
                    if (rs.getBoolean(15)) {
                        education++;
                        grade++;
                    }
                    // diatnce from ss
                    if (rs.getInt(16) <= Distance_ps) {
                        education++;
                        grade++;
                    }
                    //market
                    if (rs.getBoolean(17)) {
                        basic++;
                        grade++;
                    }

                    // diatnce from market
                    if (rs.getInt(18) <= Distance_ps) {
                        basic++;
                        grade++;
                    }
                    //internet
                    if (rs.getBoolean(19)) {
                        education++;
                        grade++;
                    }

                    //roads
                    if (rs.getInt(20) != 0) {
                        basic++;
                        grade++;
                    }
                    //transport
                    if (rs.getBoolean(21)) {
                        basic++;
                        grade++;
                    }
                    //no of toilets
                    if (rs.getBoolean(24)) {
                        san++;
                        grade++;
                    }
                    //no of dustbin
                    if (rs.getBoolean(25)) {
                        san++;
                        grade++;
                    }
                    System.out.println("2 update grade id=> " + (i + 1) + "\t basic " + basic + "\t san" + san + "\t edcuation " + education);
                    st.setInt(1, grade);
                    st.setInt(2, rs.getInt("id"));
                    st.executeUpdate();
                    i++;
                    System.out.println("updated" + (i + 1));

                }

            }catch (SQLException e) {
                JOptionPane.showMessageDialog(null, "SQL Query Exception","SQL config Error",JOptionPane.WARNING_MESSAGE);
        } catch (ClassNotFoundException ex) {
            JOptionPane.showMessageDialog(null, "Incorrect Class Path","SQL config Error",JOptionPane.WARNING_MESSAGE);
        }
        try{
            MainResultActivity main = new MainResultActivity(Integer.parseInt(funds.getText()));
            main.show();
            this.dispose();
        }catch(NumberFormatException e)
        {
            JOptionPane.showMessageDialog(null, "Incorrect ID","Input Error",JOptionPane.WARNING_MESSAGE);
        }
            // TODO add your handling code here:
    }//GEN-LAST:event_DistributeActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
         IndexForm1 index=new IndexForm1();
        index.show();
        this.dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

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
            java.util.logging.Logger.getLogger(FundsDActvity.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FundsDActvity.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FundsDActvity.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FundsDActvity.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FundsDActvity().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Distribute;
    private javax.swing.JTextField funds;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    // End of variables declaration//GEN-END:variables
}
