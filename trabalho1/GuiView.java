/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templatesasasa
 * and open the template in the editor.
 */

import services.Config;
import services.Line;
import system.Assembler;

/**
 *
 * @author glaucomunsberg
 */
public class GuiView extends javax.swing.JDialog {

    Assembler assembler;
    /**
     * Creates new form Tela
     */
    public GuiView(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        Config config = Config.getInstance();
        config.setLog(this.jTextAreaOutPut);
        config.setLog("Iniciando...");
        config.recordACC = this.jLabelDisplayACC;
        config.recordMOP = this.jLabelDisplayMOP;
        config.recordPC     = this.jLabelDisplayPC;
        config.recordRE     = this.jLabelDisplayRE;
        config.recordRI     = this.jLabelDisplayRI;
        config.recordSP     = this.jLabelDisplaySP;
        
        assembler = new Assembler();
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void initComponents() {

        jPopupMenu1 = new javax.swing.JPopupMenu();
        jPanelDisplayRE = new javax.swing.JPanel();
        jLabelName = new javax.swing.JLabel();
        jLabelVersion = new javax.swing.JLabel();
        jComboMode = new javax.swing.JComboBox();
        jLabelOperatingMode = new javax.swing.JLabel();
        jButtonNextStep = new javax.swing.JButton();
        jButtonReset = new javax.swing.JButton();
        jSeparator2 = new javax.swing.JSeparator();
        jLabelCommands = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTextAreaOutPut = new javax.swing.JTextArea();
        jLabelIn = new javax.swing.JLabel();
        jLabelOut = new javax.swing.JLabel();
        jTextFieldInput = new javax.swing.JTextField();
        jLabelCommands1 = new javax.swing.JLabel();
        jLabelPC = new javax.swing.JLabel();
        jLabelSP = new javax.swing.JLabel();
        jLabelACC = new javax.swing.JLabel();
        jLabelMOP = new javax.swing.JLabel();
        jLabelRI = new javax.swing.JLabel();
        jLabelRE = new javax.swing.JLabel();
        jLabelDisplayMOP = new javax.swing.JLabel();
        jLabelDisplaySP = new javax.swing.JLabel();
        jLabelDisplayACC = new javax.swing.JLabel();
        jLabelDisplayPC = new javax.swing.JLabel();
        jLabelDisplayRI = new javax.swing.JLabel();
        jLabelDisplayRE = new javax.swing.JLabel();
        jButtonStart1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanelDisplayRE.setBackground(new java.awt.Color(255, 255, 255));

        jLabelName.setFont(new java.awt.Font("DIN Light", 0, 48)); // NOI18N
        jLabelName.setText("VirtualPC");

        jLabelVersion.setFont(new java.awt.Font("DIN Light", 0, 12)); // NOI18N
        jLabelVersion.setText("Version Calingaert");

        jComboMode.setFont(new java.awt.Font("DIN Light", 0, 14)); // NOI18N
        jComboMode.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Modo Contínuo (Sem Interação)", "Modo Contínuo (Com Interação)", "Modo de Depuração" }));
        jComboMode.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboModeActionPerformed(evt);
            }
        });

        jLabelOperatingMode.setFont(new java.awt.Font("DIN Medium", 1, 14)); // NOI18N
        jLabelOperatingMode.setText("Modo de Operação");

        jButtonNextStep.setFont(new java.awt.Font("DIN Light", 0, 14)); // NOI18N
        jButtonNextStep.setText("Next Step");
        jButtonNextStep.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonNextStepActionPerformed(evt);
            }
        });

        jButtonReset.setFont(new java.awt.Font("DIN Light", 0, 14)); // NOI18N
        jButtonReset.setText("Reset");
        jButtonReset.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonResetActionPerformed(evt);
            }
        });

        jLabelCommands.setFont(new java.awt.Font("DIN Medium", 1, 14)); // NOI18N
        jLabelCommands.setText("Comandos");

        jTextAreaOutPut.setColumns(20);
        jTextAreaOutPut.setFont(new java.awt.Font("DIN Alternate", 1, 14)); // NOI18N
        jTextAreaOutPut.setRows(5);
        jTextAreaOutPut.setEnabled(false);
        jScrollPane2.setViewportView(jTextAreaOutPut);

        jLabelIn.setFont(new java.awt.Font("DIN Medium", 1, 14)); // NOI18N
        jLabelIn.setText("In");

        jLabelOut.setFont(new java.awt.Font("DIN Medium", 1, 14)); // NOI18N
        jLabelOut.setText("Log");

        jTextFieldInput.setFont(new java.awt.Font("DIN Light", 0, 12)); // NOI18N
        jTextFieldInput.setText("Choose...");
        jTextFieldInput.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldInputActionPerformed(evt);
                //Config.getInstance().setLog(jTextFieldInput.getText());
                Line line = new Line(jTextFieldInput.getText());
                jTextFieldInput.setText("");
            }
        });

        jLabelCommands1.setFont(new java.awt.Font("DIN Medium", 1, 14)); // NOI18N
        jLabelCommands1.setText("Engine");

        jLabelPC.setFont(new java.awt.Font("DIN Light", 0, 14)); // NOI18N
        jLabelPC.setText("PC");

        jLabelSP.setFont(new java.awt.Font("DIN Light", 0, 14)); // NOI18N
        jLabelSP.setText("SP");

        jLabelACC.setFont(new java.awt.Font("DIN Light", 0, 14)); // NOI18N
        jLabelACC.setText("ACC");

        jLabelMOP.setFont(new java.awt.Font("DIN Light", 0, 14)); // NOI18N
        jLabelMOP.setText("MOP");

        jLabelRI.setFont(new java.awt.Font("DIN Light", 0, 14)); // NOI18N
        jLabelRI.setText("RI");

        jLabelRE.setFont(new java.awt.Font("DIN Light", 0, 14)); // NOI18N
        jLabelRE.setText("RE");

        jLabelDisplayMOP.setBackground(new java.awt.Color(0, 0, 0));
        jLabelDisplayMOP.setFont(new java.awt.Font("Courier New", 1, 14)); // NOI18N
        jLabelDisplayMOP.setText("000000");

        jLabelDisplaySP.setBackground(new java.awt.Color(0, 0, 0));
        jLabelDisplaySP.setFont(new java.awt.Font("Courier New", 1, 14)); // NOI18N
        jLabelDisplaySP.setText("000000");

        jLabelDisplayACC.setBackground(new java.awt.Color(0, 0, 0));
        jLabelDisplayACC.setFont(new java.awt.Font("Courier New", 1, 14)); // NOI18N
        jLabelDisplayACC.setText("000000");

        jLabelDisplayPC.setBackground(new java.awt.Color(0, 0, 0));
        jLabelDisplayPC.setFont(new java.awt.Font("Courier New", 1, 14)); // NOI18N
        jLabelDisplayPC.setText("000000");

        jLabelDisplayRI.setBackground(new java.awt.Color(0, 0, 0));
        jLabelDisplayRI.setFont(new java.awt.Font("Courier New", 1, 14)); // NOI18N
        jLabelDisplayRI.setText("000000");

        jLabelDisplayRE.setBackground(new java.awt.Color(0, 0, 0));
        jLabelDisplayRE.setFont(new java.awt.Font("Courier New", 1, 14)); // NOI18N
        jLabelDisplayRE.setText("000000");

        jButtonStart1.setFont(new java.awt.Font("DIN Light", 0, 14)); // NOI18N
        jButtonStart1.setText("Start");
        jButtonStart1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonStart1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanelDisplayRELayout = new javax.swing.GroupLayout(jPanelDisplayRE);
        jPanelDisplayRE.setLayout(jPanelDisplayRELayout);
        jPanelDisplayRELayout.setHorizontalGroup(
            jPanelDisplayRELayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelDisplayRELayout.createSequentialGroup()
                .addGroup(jPanelDisplayRELayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jSeparator2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 652, Short.MAX_VALUE)
                    .addGroup(jPanelDisplayRELayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanelDisplayRELayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabelName)
                            .addGroup(jPanelDisplayRELayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addGroup(jPanelDisplayRELayout.createSequentialGroup()
                                    .addGroup(jPanelDisplayRELayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabelCommands1)
                                        .addGroup(jPanelDisplayRELayout.createSequentialGroup()
                                            .addGap(23, 23, 23)
                                            .addGroup(jPanelDisplayRELayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(jLabelSP)
                                                .addGroup(jPanelDisplayRELayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanelDisplayRELayout.createSequentialGroup()
                                                        .addComponent(jLabelRE)
                                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                        .addComponent(jLabelDisplayRE, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanelDisplayRELayout.createSequentialGroup()
                                                        .addComponent(jLabelRI)
                                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                        .addComponent(jLabelDisplayRI, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                    .addGroup(jPanelDisplayRELayout.createSequentialGroup()
                                                        .addComponent(jLabelPC)
                                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                        .addComponent(jLabelDisplayPC, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                    .addGroup(jPanelDisplayRELayout.createSequentialGroup()
                                                        .addGroup(jPanelDisplayRELayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                            .addComponent(jLabelACC)
                                                            .addComponent(jLabelMOP))
                                                        .addGap(18, 18, 18)
                                                        .addGroup(jPanelDisplayRELayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                            .addGroup(jPanelDisplayRELayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                                .addComponent(jLabelDisplayMOP, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addComponent(jLabelDisplaySP, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                            .addComponent(jLabelDisplayACC, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)))))))
                                    .addGap(161, 161, 161)
                                    .addComponent(jScrollPane2))
                                .addGroup(jPanelDisplayRELayout.createSequentialGroup()
                                    .addGroup(jPanelDisplayRELayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabelOperatingMode)
                                        .addComponent(jLabelCommands)
                                        .addGroup(jPanelDisplayRELayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(jComboMode, javax.swing.GroupLayout.PREFERRED_SIZE, 342, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGroup(jPanelDisplayRELayout.createSequentialGroup()
                                                .addComponent(jButtonStart1, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(jButtonReset, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(jButtonNextStep, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                    .addGap(18, 18, 18)
                                    .addGroup(jPanelDisplayRELayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabelIn)
                                        .addComponent(jLabelOut)
                                        .addGroup(jPanelDisplayRELayout.createSequentialGroup()
                                            .addGap(6, 6, 6)
                                            .addComponent(jTextFieldInput, javax.swing.GroupLayout.PREFERRED_SIZE, 257, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(jPanelDisplayRELayout.createSequentialGroup()
                .addGap(163, 163, 163)
                .addComponent(jLabelVersion)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanelDisplayRELayout.setVerticalGroup(
            jPanelDisplayRELayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelDisplayRELayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabelName, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabelVersion, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanelDisplayRELayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanelDisplayRELayout.createSequentialGroup()
                        .addComponent(jLabelOperatingMode)
                        .addGap(12, 12, 12)
                        .addComponent(jComboMode, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(30, 30, 30)
                        .addComponent(jLabelCommands)
                        .addGap(18, 18, 18)
                        .addGroup(jPanelDisplayRELayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButtonReset)
                            .addComponent(jButtonNextStep)
                            .addComponent(jButtonStart1))
                        .addGap(18, 18, 18))
                    .addGroup(jPanelDisplayRELayout.createSequentialGroup()
                        .addGroup(jPanelDisplayRELayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanelDisplayRELayout.createSequentialGroup()
                                .addGap(26, 26, 26)
                                .addComponent(jTextFieldInput, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabelIn))
                        .addGap(18, 18, 18)
                        .addComponent(jLabelOut)
                        .addGap(9, 9, 9)))
                .addGroup(jPanelDisplayRELayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelDisplayRELayout.createSequentialGroup()
                        .addComponent(jLabelCommands1)
                        .addGap(18, 18, 18)
                        .addGroup(jPanelDisplayRELayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabelPC)
                            .addComponent(jLabelDisplayPC))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanelDisplayRELayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabelSP)
                            .addComponent(jLabelDisplaySP))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanelDisplayRELayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabelACC)
                            .addComponent(jLabelDisplayACC))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanelDisplayRELayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabelMOP)
                            .addComponent(jLabelDisplayMOP))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanelDisplayRELayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabelRI)
                            .addComponent(jLabelDisplayRI)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelDisplayRELayout.createSequentialGroup()
                        .addGap(9, 9, 9)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanelDisplayRELayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelRE)
                    .addComponent(jLabelDisplayRE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanelDisplayRE, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanelDisplayRE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>                        

    private void jComboModeActionPerformed(java.awt.event.ActionEvent evt) {                                           
        // TODO add your handling code here:
    }                                          

    private void jButtonNextStepActionPerformed(java.awt.event.ActionEvent evt) {                                                
        // TODO add your handling code here:
    }                                               

    private void jButtonResetActionPerformed(java.awt.event.ActionEvent evt) {                                             
        assembler.reset();
    }                                            

    private void jTextFieldInputActionPerformed(java.awt.event.ActionEvent evt) {                                                
        // TODO add your handling code here:
    }                                               

    private void jButtonStart1ActionPerformed(java.awt.event.ActionEvent evt) {                                              
        assembler.start();
    }                                             

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
            java.util.logging.Logger.getLogger(GuiView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(GuiView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(GuiView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GuiView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                GuiView dialog = new GuiView(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify                     
    private javax.swing.JButton jButtonNextStep;
    private javax.swing.JButton jButtonReset;
    private javax.swing.JButton jButtonStart1;
    private javax.swing.JComboBox jComboMode;
    private javax.swing.JLabel jLabelACC;
    private javax.swing.JLabel jLabelCommands;
    private javax.swing.JLabel jLabelCommands1;
    private javax.swing.JLabel jLabelDisplayACC;
    private javax.swing.JLabel jLabelDisplayMOP;
    private javax.swing.JLabel jLabelDisplayPC;
    private javax.swing.JLabel jLabelDisplayRI;
    private javax.swing.JLabel jLabelDisplaySP;
    private javax.swing.JLabel jLabelIn;
    private javax.swing.JLabel jLabelMOP;
    private javax.swing.JLabel jLabelName;
    private javax.swing.JLabel jLabelOperatingMode;
    private javax.swing.JLabel jLabelOut;
    private javax.swing.JLabel jLabelPC;
    private javax.swing.JLabel jLabelDisplayRE;
    private javax.swing.JLabel jLabelRE;
    private javax.swing.JLabel jLabelRI;
    private javax.swing.JLabel jLabelSP;
    private javax.swing.JLabel jLabelVersion;
    private javax.swing.JPanel jPanelDisplayRE;
    private javax.swing.JPopupMenu jPopupMenu1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JTextArea jTextAreaOutPut;
    private javax.swing.JTextField jTextFieldInput;
    // End of variables declaration                   
}
