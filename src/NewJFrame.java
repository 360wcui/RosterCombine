
import java.awt.AWTException;
import java.awt.datatransfer.UnsupportedFlavorException;
import utilities.XlsxGenerator;
import java.io.*;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import utilities.DMPORosterToMapGenerator;
import utilities.GlobalVar;
import utilities.NPDListFinder;
import utilities.PrintLES;
import utilities.RCFRosterToMapGenerator;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author SPC Cui
 */
public class NewJFrame extends javax.swing.JFrame {
    
    private String RCFRosterFile = null;
    private String DMPORosterFile = null;
   // private static String SSN_FILE_NAME = "roster.txt";
    /**
     * Creates new form NewJFrame
     */
    public NewJFrame() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        RCF_Roster = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        selectRCFButton = new javax.swing.JButton();
        selectDMPObutton = new javax.swing.JButton();
        submitButton = new javax.swing.JButton();
        RCFfileDir = new javax.swing.JLabel();
        DMPOfileDir = new javax.swing.JLabel();
        fileWarningMsg = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        RCF_Roster.setText("RCF Roster");

        jLabel2.setText("DMPO Roster");

        selectRCFButton.setText("Select");
        selectRCFButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                selectRCFButtonActionPerformed(evt);
            }
        });

        selectDMPObutton.setText("Select");
        selectDMPObutton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                selectDMPObuttonActionPerformed(evt);
            }
        });

        submitButton.setText("Submit");
        submitButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                submitButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(submitButton)
                .addGap(63, 63, 63))
            .addGroup(layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel2)
                    .addComponent(RCF_Roster))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(selectRCFButton)
                    .addComponent(selectDMPObutton))
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(fileWarningMsg)
                    .addComponent(DMPOfileDir)
                    .addComponent(RCFfileDir))
                .addContainerGap(414, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(72, 72, 72)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(RCF_Roster)
                    .addComponent(selectRCFButton)
                    .addComponent(RCFfileDir))
                .addGap(52, 52, 52)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(selectDMPObutton)
                    .addComponent(DMPOfileDir))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 79, Short.MAX_VALUE)
                .addComponent(submitButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(fileWarningMsg)
                .addGap(22, 22, 22))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void selectRCFButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_selectRCFButtonActionPerformed
        String dir = getHomeDirectory();
        System.out.println(dir);
        final JFileChooser fc = new JFileChooser(dir);
        FileNameExtensionFilter filter = new FileNameExtensionFilter("*.xlsx","xlsx");
        fc.setFileFilter(filter);
        fc.setDialogTitle("Please select a RCF roster...");
        //fc.setCurrentDirectory(new File("C:\\Users\\bob\\Desktop\\p.txt"));
        int response = fc.showOpenDialog(this);        
        String fileName;
        if (response == JFileChooser.APPROVE_OPTION) {
            fileName = fc.getSelectedFile().toString(); 
            RCFRosterFile = fileName;
            RCFfileDir.setText(fileName);
        }       
    }//GEN-LAST:event_selectRCFButtonActionPerformed
    
    // return directory where the program is located
    private String getHomeDirectory() {
        ClassLoader loader = NewJFrame.class.getClassLoader();
        //System.out.println(loader.toString());
        String dir = loader.getResource("NewJFrame.class").toString();
        dir = dir.replace("file:/","");
        dir = dir.replace("jar:","");
        dir = dir.replace("/RosterCombine.jar!","");
        dir = dir.replace("/NewJFrame.class","");
        dir = dir.replace("/build/classes","");
        return dir;
    }
    
    private void clearAllTexts() {
        fileWarningMsg.setText("");
        RCFfileDir.setText("");
        DMPOfileDir.setText("");
    }
    
    private void selectDMPObuttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_selectDMPObuttonActionPerformed
        String dir = getHomeDirectory();
        final JFileChooser fc = new JFileChooser(dir);
        FileNameExtensionFilter filter = new FileNameExtensionFilter("*.xlsx","xlsx");
        fc.setFileFilter(filter);
        fc.setDialogTitle("Please select a DMPO roster...");
        int response = fc.showOpenDialog(this);        
        String fileName;
        if (response == JFileChooser.APPROVE_OPTION) {
            fileName = fc.getSelectedFile().toString(); 
            DMPORosterFile = fileName;
            DMPOfileDir.setText(fileName);
        }       
    }//GEN-LAST:event_selectDMPObuttonActionPerformed
    
//    private void DMPOxlsxToMapGenerator(String xlsxFileName, MyDate cutoffDate) throws FileNotFoundException, IOException {
//        File myFile = new File(xlsxFileName);
//        FileInputStream fis = new FileInputStream(myFile);
//        XSSFWorkbook myWorkBook = new XSSFWorkbook(fis);
//    }
    
    private void submitButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_submitButtonActionPerformed
        if (RCFRosterFile != null && DMPORosterFile != null) {
             fileWarningMsg.setText("");
    
            try {
                DMPORosterToMapGenerator dmpo = new DMPORosterToMapGenerator(DMPORosterFile);
                RCFRosterToMapGenerator rcf = new RCFRosterToMapGenerator(RCFRosterFile);               
                List<String> ssnList = rcf.rosterGenerator();   // generate roster.txt       
                NPDListFinder npd = new NPDListFinder(GlobalVar.SSN_FILE_NAME);
                List<String> npdList = npd.getNPDList();
                
                
                PrintLES pLes = new PrintLES(ssnList);
                List<String> LesNAList = pLes.getLESnotProcdSSNList();
                
                XlsxGenerator xg = new XlsxGenerator(dmpo.getDb(), rcf.getDb(), npdList, LesNAList);
                                
                JOptionPane.showMessageDialog(null, "The NPD report is generated successfully!");


            } catch (IOException ex) {
                Logger.getLogger(NewJFrame.class.getName()).log(Level.SEVERE, null, ex);
                JOptionPane.showMessageDialog(null, "Fail to generate the report!");
            } catch (ParseException ex) {
                Logger.getLogger(NewJFrame.class.getName()).log(Level.SEVERE, null, ex);
                JOptionPane.showMessageDialog(null, "Fail to generate the report!");
            } catch (UnsupportedFlavorException ex) {
                Logger.getLogger(NewJFrame.class.getName()).log(Level.SEVERE, null, ex);
            } catch (AWTException ex) {
                Logger.getLogger(NewJFrame.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else if (RCFRosterFile == null && DMPORosterFile == null){
            fileWarningMsg.setText("Neither RCF nor DMPO file is not selected!");
        } else if (RCFRosterFile == null) {
            fileWarningMsg.setText("RCF file is not selected!");
        } else { //if (DMPORosterFile == null) {
            fileWarningMsg.setText("DMPO file is not selected!");
        }           
    }//GEN-LAST:event_submitButtonActionPerformed

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
            java.util.logging.Logger.getLogger(NewJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(NewJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(NewJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(NewJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new NewJFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel DMPOfileDir;
    private javax.swing.JLabel RCF_Roster;
    private javax.swing.JLabel RCFfileDir;
    private javax.swing.JLabel fileWarningMsg;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JButton selectDMPObutton;
    private javax.swing.JButton selectRCFButton;
    private javax.swing.JButton submitButton;
    // End of variables declaration//GEN-END:variables
}
