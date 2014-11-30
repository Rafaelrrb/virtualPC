/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package M68000;

import M68000.assembler.Assembler;

/**
 *
 * @author glaucomunsberg
 */
public class Interface extends javax.swing.JDialog{
    
    private javax.swing.JButton jButtonReset;
    private javax.swing.JButton jButtonStart1;
    private javax.swing.JCheckBox jCheckBoxAssembler;
    private javax.swing.JCheckBox jCheckBoxLinker;
    private javax.swing.JCheckBox jCheckBoxLoader;
    private javax.swing.JCheckBox jCheckBoxVirtualMachine;
    private javax.swing.JLabel jLabelCommands1;
    private javax.swing.JLabel jLabelCommands2;
    private javax.swing.JLabel jLabelDisplayA0;
    private javax.swing.JLabel jLabelDisplayA1;
    private javax.swing.JLabel jLabelDisplayA2;
    private javax.swing.JLabel jLabelDisplayA3;
    private javax.swing.JLabel jLabelDisplayA4;
    private javax.swing.JLabel jLabelDisplayA5;
    private javax.swing.JLabel jLabelDisplayA6;
    private javax.swing.JLabel jLabelDisplayACC;
    private javax.swing.JLabel jLabelDisplayAddress;
    private javax.swing.JLabel jLabelDisplayC;
    private javax.swing.JLabel jLabelDisplayD0;
    private javax.swing.JLabel jLabelDisplayD1;
    private javax.swing.JLabel jLabelDisplayD2;
    private javax.swing.JLabel jLabelDisplayD3;
    private javax.swing.JLabel jLabelDisplayD4;
    private javax.swing.JLabel jLabelDisplayD5;
    private javax.swing.JLabel jLabelDisplayD6;
    private javax.swing.JLabel jLabelDisplayD7;
    private javax.swing.JLabel jLabelDisplayN;
    private javax.swing.JLabel jLabelDisplayPC;
    private javax.swing.JLabel jLabelDisplaySSP;
    private javax.swing.JLabel jLabelDisplayUSP;
    private javax.swing.JLabel jLabelDisplayV;
    private javax.swing.JLabel jLabelDisplayZ;
    private javax.swing.JLabel jLabelIn;
    private javax.swing.JLabel jLabelMOP;
    private javax.swing.JLabel jLabelName;
    private javax.swing.JLabel jLabelOperatingMode;
    private javax.swing.JLabel jLabelOperatingMode1;
    private javax.swing.JLabel jLabelOut;
    private javax.swing.JLabel jLabelOut1;
    private javax.swing.JLabel jLabelPC;
    private javax.swing.JLabel jLabelPC10;
    private javax.swing.JLabel jLabelPC11;
    private javax.swing.JLabel jLabelPC12;
    private javax.swing.JLabel jLabelPC13;
    private javax.swing.JLabel jLabelPC14;
    private javax.swing.JLabel jLabelPC15;
    private javax.swing.JLabel jLabelPC16;
    private javax.swing.JLabel jLabelPC17;
    private javax.swing.JLabel jLabelPC18;
    private javax.swing.JLabel jLabelPC19;
    private javax.swing.JLabel jLabelPC3;
    private javax.swing.JLabel jLabelPC4;
    private javax.swing.JLabel jLabelPC5;
    private javax.swing.JLabel jLabelPC6;
    private javax.swing.JLabel jLabelPC7;
    private javax.swing.JLabel jLabelPC8;
    private javax.swing.JLabel jLabelPC9;
    private javax.swing.JLabel jLabelRE;
    private javax.swing.JLabel jLabelRE1;
    private javax.swing.JLabel jLabelRI;
    private javax.swing.JLabel jLabelSP;
    private javax.swing.JLabel jLabelVersion;
    private javax.swing.JLabel jLabelddresss;
    private javax.swing.JPanel jPanelConfiguration;
    private javax.swing.JPanel jPanelDisplayRE;
    private javax.swing.JPanel jPanelGeneral;
    private javax.swing.JPanel jPanelLog;
    private javax.swing.JPanel jPanelMemory;
    private javax.swing.JPopupMenu jPopupMenu1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JTabbedPane jTabbedPane;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextArea jTextAreaLog;
    private javax.swing.JTextField jTextFieldInput;
    private javax.swing.JTextField jTextFieldOutput;
    private javax.swing.JTextArea jTextLinkFileList;
    
    public Interface(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        Assembler assembler = new Assembler();
        initComponents();
    }
    
    private void initComponents() {

        jPopupMenu1 = new javax.swing.JPopupMenu();
        jPanelDisplayRE = new javax.swing.JPanel();
        jLabelName = new javax.swing.JLabel();
        jLabelVersion = new javax.swing.JLabel();
        jSeparator2 = new javax.swing.JSeparator();
        jLabelIn = new javax.swing.JLabel();
        jLabelOut = new javax.swing.JLabel();
        jTabbedPane = new javax.swing.JTabbedPane();
        jPanelGeneral = new javax.swing.JPanel();
        jLabelPC = new javax.swing.JLabel();
        jLabelDisplayPC = new javax.swing.JLabel();
        jLabelSP = new javax.swing.JLabel();
        jLabelDisplayACC = new javax.swing.JLabel();
        jLabelMOP = new javax.swing.JLabel();
        jLabelDisplayN = new javax.swing.JLabel();
        jLabelDisplayZ = new javax.swing.JLabel();
        jLabelRI = new javax.swing.JLabel();
        jLabelRE = new javax.swing.JLabel();
        jLabelDisplayV = new javax.swing.JLabel();
        jLabelddresss = new javax.swing.JLabel();
        jLabelDisplayAddress = new javax.swing.JLabel();
        jLabelCommands1 = new javax.swing.JLabel();
        jLabelCommands2 = new javax.swing.JLabel();
        jLabelRE1 = new javax.swing.JLabel();
        jLabelDisplayC = new javax.swing.JLabel();
        jCheckBoxLinker = new javax.swing.JCheckBox();
        jCheckBoxAssembler = new javax.swing.JCheckBox();
        jCheckBoxLoader = new javax.swing.JCheckBox();
        jCheckBoxVirtualMachine = new javax.swing.JCheckBox();
        jPanelConfiguration = new javax.swing.JPanel();
        jLabelOperatingMode = new javax.swing.JLabel();
        jLabelOperatingMode1 = new javax.swing.JLabel();
        jLabelPC3 = new javax.swing.JLabel();
        jLabelDisplayD0 = new javax.swing.JLabel();
        jLabelPC5 = new javax.swing.JLabel();
        jLabelDisplayA0 = new javax.swing.JLabel();
        jLabelDisplayA1 = new javax.swing.JLabel();
        jLabelPC6 = new javax.swing.JLabel();
        jLabelDisplayD1 = new javax.swing.JLabel();
        jLabelPC4 = new javax.swing.JLabel();
        jLabelPC7 = new javax.swing.JLabel();
        jLabelDisplayD2 = new javax.swing.JLabel();
        jLabelDisplayA2 = new javax.swing.JLabel();
        jLabelPC8 = new javax.swing.JLabel();
        jLabelDisplayA3 = new javax.swing.JLabel();
        jLabelPC9 = new javax.swing.JLabel();
        jLabelPC10 = new javax.swing.JLabel();
        jLabelDisplayD3 = new javax.swing.JLabel();
        jLabelDisplayA4 = new javax.swing.JLabel();
        jLabelPC11 = new javax.swing.JLabel();
        jLabelDisplayD4 = new javax.swing.JLabel();
        jLabelPC12 = new javax.swing.JLabel();
        jLabelDisplayA5 = new javax.swing.JLabel();
        jLabelPC13 = new javax.swing.JLabel();
        jLabelDisplayD5 = new javax.swing.JLabel();
        jLabelPC14 = new javax.swing.JLabel();
        jLabelDisplayD6 = new javax.swing.JLabel();
        jLabelPC15 = new javax.swing.JLabel();
        jLabelDisplayA6 = new javax.swing.JLabel();
        jLabelPC16 = new javax.swing.JLabel();
        jLabelDisplayD7 = new javax.swing.JLabel();
        jLabelPC17 = new javax.swing.JLabel();
        jLabelPC18 = new javax.swing.JLabel();
        jLabelDisplayUSP = new javax.swing.JLabel();
        jLabelPC19 = new javax.swing.JLabel();
        jLabelDisplaySSP = new javax.swing.JLabel();
        jPanelMemory = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jPanelLog = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTextAreaLog = new javax.swing.JTextArea();
        jTextFieldInput = new javax.swing.JTextField();
        jButtonReset = new javax.swing.JButton();
        jButtonStart1 = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTextLinkFileList = new javax.swing.JTextArea();
        jLabelOut1 = new javax.swing.JLabel();
        jTextFieldOutput = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanelDisplayRE.setBackground(new java.awt.Color(255, 255, 255));

        jLabelName.setFont(new java.awt.Font("DIN Light", 0, 48)); // NOI18N
        jLabelName.setText("Motorola 68k");

        jLabelVersion.setFont(new java.awt.Font("DIN Light", 0, 12)); // NOI18N
        jLabelVersion.setText("Version Alpha");

        jLabelIn.setFont(new java.awt.Font("DIN Medium", 1, 14)); // NOI18N
        jLabelIn.setText("Input file");

        jLabelOut.setFont(new java.awt.Font("DIN Medium", 1, 14)); // NOI18N
        jLabelOut.setText("Link files list");

        jLabelPC.setFont(new java.awt.Font("DIN Light", 0, 14)); // NOI18N
        jLabelPC.setText("PC");

        jLabelDisplayPC.setBackground(new java.awt.Color(0, 0, 0));
        jLabelDisplayPC.setFont(new java.awt.Font("Courier New", 1, 14)); // NOI18N
        jLabelDisplayPC.setText("--");

        jLabelSP.setFont(new java.awt.Font("DIN Light", 0, 14)); // NOI18N
        jLabelSP.setText("ACC");

        jLabelDisplayACC.setBackground(new java.awt.Color(0, 0, 0));
        jLabelDisplayACC.setFont(new java.awt.Font("Courier New", 1, 14)); // NOI18N
        jLabelDisplayACC.setText("--");

        jLabelMOP.setFont(new java.awt.Font("DIN Light", 0, 14)); // NOI18N
        jLabelMOP.setText("N");

        jLabelDisplayN.setBackground(new java.awt.Color(0, 0, 0));
        jLabelDisplayN.setFont(new java.awt.Font("Courier New", 1, 14)); // NOI18N
        jLabelDisplayN.setText("-");

        jLabelDisplayZ.setBackground(new java.awt.Color(0, 0, 0));
        jLabelDisplayZ.setFont(new java.awt.Font("Courier New", 1, 14)); // NOI18N
        jLabelDisplayZ.setText("-");

        jLabelRI.setFont(new java.awt.Font("DIN Light", 0, 14)); // NOI18N
        jLabelRI.setText("Z");

        jLabelRE.setFont(new java.awt.Font("DIN Light", 0, 14)); // NOI18N
        jLabelRE.setText("V");

        jLabelDisplayV.setBackground(new java.awt.Color(0, 0, 0));
        jLabelDisplayV.setFont(new java.awt.Font("Courier New", 1, 14)); // NOI18N
        jLabelDisplayV.setText("-");

        jLabelddresss.setFont(new java.awt.Font("DIN Light", 0, 14)); // NOI18N
        jLabelddresss.setText("Address");

        jLabelDisplayAddress.setBackground(new java.awt.Color(0, 0, 0));
        jLabelDisplayAddress.setFont(new java.awt.Font("Courier New", 1, 14)); // NOI18N
        jLabelDisplayAddress.setText("--");

        jLabelCommands1.setFont(new java.awt.Font("DIN Medium", 1, 14)); // NOI18N
        jLabelCommands1.setText("Engine");

        jLabelCommands2.setFont(new java.awt.Font("DIN Medium", 1, 14)); // NOI18N
        jLabelCommands2.setText("Step");

        jLabelRE1.setFont(new java.awt.Font("DIN Light", 0, 14)); // NOI18N
        jLabelRE1.setText("C");

        jLabelDisplayC.setBackground(new java.awt.Color(0, 0, 0));
        jLabelDisplayC.setFont(new java.awt.Font("Courier New", 1, 14)); // NOI18N
        jLabelDisplayC.setText("-");

        jCheckBoxLinker.setText("Linker");
        jCheckBoxLinker.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBoxLinkerActionPerformed(evt);
            }
        });

        jCheckBoxAssembler.setText("Assembler");
        jCheckBoxAssembler.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBoxAssemblerActionPerformed(evt);
            }
        });

        jCheckBoxLoader.setText("Loader");
        jCheckBoxLoader.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBoxLoaderActionPerformed(evt);
            }
        });

        jCheckBoxVirtualMachine.setText("VirtualMachine");
        jCheckBoxVirtualMachine.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBoxVirtualMachineActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanelGeneralLayout = new javax.swing.GroupLayout(jPanelGeneral);
        jPanelGeneral.setLayout(jPanelGeneralLayout);
        jPanelGeneralLayout.setHorizontalGroup(
            jPanelGeneralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelGeneralLayout.createSequentialGroup()
                .addGroup(jPanelGeneralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelGeneralLayout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addComponent(jLabelddresss)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanelGeneralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabelDisplayAddress, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabelDisplayACC, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabelDisplayPC, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanelGeneralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanelGeneralLayout.createSequentialGroup()
                                .addComponent(jLabelRE1)
                                .addGap(28, 28, 28)
                                .addComponent(jLabelDisplayC, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanelGeneralLayout.createSequentialGroup()
                                .addComponent(jLabelRE)
                                .addGap(31, 31, 31)
                                .addComponent(jLabelDisplayV, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanelGeneralLayout.createSequentialGroup()
                                .addComponent(jLabelRI)
                                .addGap(30, 30, 30)
                                .addComponent(jLabelDisplayZ, javax.swing.GroupLayout.DEFAULT_SIZE, 152, Short.MAX_VALUE))
                            .addGroup(jPanelGeneralLayout.createSequentialGroup()
                                .addComponent(jLabelMOP)
                                .addGap(28, 28, 28)
                                .addComponent(jLabelDisplayN, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jPanelGeneralLayout.createSequentialGroup()
                        .addGroup(jPanelGeneralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanelGeneralLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jLabelCommands1))
                            .addGroup(jPanelGeneralLayout.createSequentialGroup()
                                .addGap(12, 12, 12)
                                .addComponent(jLabelPC))
                            .addGroup(jPanelGeneralLayout.createSequentialGroup()
                                .addGap(12, 12, 12)
                                .addComponent(jLabelSP)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap(58, Short.MAX_VALUE))
            .addGroup(jPanelGeneralLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelGeneralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabelCommands2)
                    .addComponent(jCheckBoxAssembler)
                    .addComponent(jCheckBoxLinker)
                    .addComponent(jCheckBoxLoader)
                    .addComponent(jCheckBoxVirtualMachine))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanelGeneralLayout.setVerticalGroup(
            jPanelGeneralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelGeneralLayout.createSequentialGroup()
                .addContainerGap(26, Short.MAX_VALUE)
                .addComponent(jLabelCommands1)
                .addGap(7, 7, 7)
                .addGroup(jPanelGeneralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanelGeneralLayout.createSequentialGroup()
                        .addGroup(jPanelGeneralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabelMOP)
                            .addComponent(jLabelDisplayN))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanelGeneralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabelRI)
                            .addComponent(jLabelDisplayZ))
                        .addGap(7, 7, 7)
                        .addGroup(jPanelGeneralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabelRE)
                            .addComponent(jLabelDisplayV)
                            .addComponent(jLabelddresss)
                            .addComponent(jLabelDisplayAddress)))
                    .addGroup(jPanelGeneralLayout.createSequentialGroup()
                        .addGroup(jPanelGeneralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanelGeneralLayout.createSequentialGroup()
                                .addComponent(jLabelDisplayPC)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabelDisplayACC))
                            .addGroup(jPanelGeneralLayout.createSequentialGroup()
                                .addComponent(jLabelPC)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabelSP)))
                        .addGap(23, 23, 23)))
                .addGroup(jPanelGeneralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelRE1)
                    .addComponent(jLabelDisplayC))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabelCommands2)
                .addGap(12, 12, 12)
                .addComponent(jCheckBoxAssembler)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jCheckBoxLinker)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jCheckBoxLoader)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jCheckBoxVirtualMachine)
                .addContainerGap())
        );

        jTabbedPane.addTab("General", jPanelGeneral);

        jLabelOperatingMode.setFont(new java.awt.Font("DIN Medium", 1, 14)); // NOI18N
        jLabelOperatingMode.setText("Registrators Data");

        jLabelOperatingMode1.setFont(new java.awt.Font("DIN Medium", 1, 14)); // NOI18N
        jLabelOperatingMode1.setText("Registrators Anddress");

        jLabelPC3.setFont(new java.awt.Font("DIN Light", 0, 14)); // NOI18N
        jLabelPC3.setText("D0");

        jLabelDisplayD0.setBackground(new java.awt.Color(0, 0, 0));
        jLabelDisplayD0.setFont(new java.awt.Font("Courier New", 1, 14)); // NOI18N
        jLabelDisplayD0.setText("--");

        jLabelPC5.setFont(new java.awt.Font("DIN Light", 0, 14)); // NOI18N
        jLabelPC5.setText("A0");

        jLabelDisplayA0.setBackground(new java.awt.Color(0, 0, 0));
        jLabelDisplayA0.setFont(new java.awt.Font("Courier New", 1, 14)); // NOI18N
        jLabelDisplayA0.setText("--");

        jLabelDisplayA1.setBackground(new java.awt.Color(0, 0, 0));
        jLabelDisplayA1.setFont(new java.awt.Font("Courier New", 1, 14)); // NOI18N
        jLabelDisplayA1.setText("--");

        jLabelPC6.setFont(new java.awt.Font("DIN Light", 0, 14)); // NOI18N
        jLabelPC6.setText("A1");

        jLabelDisplayD1.setBackground(new java.awt.Color(0, 0, 0));
        jLabelDisplayD1.setFont(new java.awt.Font("Courier New", 1, 14)); // NOI18N
        jLabelDisplayD1.setText("--");

        jLabelPC4.setFont(new java.awt.Font("DIN Light", 0, 14)); // NOI18N
        jLabelPC4.setText("D1");

        jLabelPC7.setFont(new java.awt.Font("DIN Light", 0, 14)); // NOI18N
        jLabelPC7.setText("D2");

        jLabelDisplayD2.setBackground(new java.awt.Color(0, 0, 0));
        jLabelDisplayD2.setFont(new java.awt.Font("Courier New", 1, 14)); // NOI18N
        jLabelDisplayD2.setText("--");

        jLabelDisplayA2.setBackground(new java.awt.Color(0, 0, 0));
        jLabelDisplayA2.setFont(new java.awt.Font("Courier New", 1, 14)); // NOI18N
        jLabelDisplayA2.setText("--");

        jLabelPC8.setFont(new java.awt.Font("DIN Light", 0, 14)); // NOI18N
        jLabelPC8.setText("A2");

        jLabelDisplayA3.setBackground(new java.awt.Color(0, 0, 0));
        jLabelDisplayA3.setFont(new java.awt.Font("Courier New", 1, 14)); // NOI18N
        jLabelDisplayA3.setText("--");

        jLabelPC9.setFont(new java.awt.Font("DIN Light", 0, 14)); // NOI18N
        jLabelPC9.setText("A3");

        jLabelPC10.setFont(new java.awt.Font("DIN Light", 0, 14)); // NOI18N
        jLabelPC10.setText("D3");

        jLabelDisplayD3.setBackground(new java.awt.Color(0, 0, 0));
        jLabelDisplayD3.setFont(new java.awt.Font("Courier New", 1, 14)); // NOI18N
        jLabelDisplayD3.setText("--");

        jLabelDisplayA4.setBackground(new java.awt.Color(0, 0, 0));
        jLabelDisplayA4.setFont(new java.awt.Font("Courier New", 1, 14)); // NOI18N
        jLabelDisplayA4.setText("--");

        jLabelPC11.setFont(new java.awt.Font("DIN Light", 0, 14)); // NOI18N
        jLabelPC11.setText("D4");

        jLabelDisplayD4.setBackground(new java.awt.Color(0, 0, 0));
        jLabelDisplayD4.setFont(new java.awt.Font("Courier New", 1, 14)); // NOI18N
        jLabelDisplayD4.setText("--");

        jLabelPC12.setFont(new java.awt.Font("DIN Light", 0, 14)); // NOI18N
        jLabelPC12.setText("A4");

        jLabelDisplayA5.setBackground(new java.awt.Color(0, 0, 0));
        jLabelDisplayA5.setFont(new java.awt.Font("Courier New", 1, 14)); // NOI18N
        jLabelDisplayA5.setText("--");

        jLabelPC13.setFont(new java.awt.Font("DIN Light", 0, 14)); // NOI18N
        jLabelPC13.setText("A5");

        jLabelDisplayD5.setBackground(new java.awt.Color(0, 0, 0));
        jLabelDisplayD5.setFont(new java.awt.Font("Courier New", 1, 14)); // NOI18N
        jLabelDisplayD5.setText("--");

        jLabelPC14.setFont(new java.awt.Font("DIN Light", 0, 14)); // NOI18N
        jLabelPC14.setText("D5");

        jLabelDisplayD6.setBackground(new java.awt.Color(0, 0, 0));
        jLabelDisplayD6.setFont(new java.awt.Font("Courier New", 1, 14)); // NOI18N
        jLabelDisplayD6.setText("--");

        jLabelPC15.setFont(new java.awt.Font("DIN Light", 0, 14)); // NOI18N
        jLabelPC15.setText("D6");

        jLabelDisplayA6.setBackground(new java.awt.Color(0, 0, 0));
        jLabelDisplayA6.setFont(new java.awt.Font("Courier New", 1, 14)); // NOI18N
        jLabelDisplayA6.setText("--");

        jLabelPC16.setFont(new java.awt.Font("DIN Light", 0, 14)); // NOI18N
        jLabelPC16.setText("A6");

        jLabelDisplayD7.setBackground(new java.awt.Color(0, 0, 0));
        jLabelDisplayD7.setFont(new java.awt.Font("Courier New", 1, 14)); // NOI18N
        jLabelDisplayD7.setText("--");

        jLabelPC17.setFont(new java.awt.Font("DIN Light", 0, 14)); // NOI18N
        jLabelPC17.setText("USP");

        jLabelPC18.setFont(new java.awt.Font("DIN Light", 0, 14)); // NOI18N
        jLabelPC18.setText("D7");

        jLabelDisplayUSP.setBackground(new java.awt.Color(0, 0, 0));
        jLabelDisplayUSP.setFont(new java.awt.Font("Courier New", 1, 14)); // NOI18N
        jLabelDisplayUSP.setText("--");

        jLabelPC19.setFont(new java.awt.Font("DIN Light", 0, 14)); // NOI18N
        jLabelPC19.setText("SSP");

        jLabelDisplaySSP.setBackground(new java.awt.Color(0, 0, 0));
        jLabelDisplaySSP.setFont(new java.awt.Font("Courier New", 1, 14)); // NOI18N
        jLabelDisplaySSP.setText("--");

        javax.swing.GroupLayout jPanelConfigurationLayout = new javax.swing.GroupLayout(jPanelConfiguration);
        jPanelConfiguration.setLayout(jPanelConfigurationLayout);
        jPanelConfigurationLayout.setHorizontalGroup(
            jPanelConfigurationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelConfigurationLayout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(jPanelConfigurationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelConfigurationLayout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addGroup(jPanelConfigurationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabelPC3, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabelPC4, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabelPC7, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabelPC10, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabelPC11, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabelPC14, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabelPC15, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabelPC18, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addGap(18, 18, 18)
                        .addGroup(jPanelConfigurationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabelDisplayD0, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabelDisplayD2, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabelDisplayD1, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabelDisplayD3, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabelDisplayD4, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabelDisplayD5, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabelDisplayD6, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabelDisplayD7, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanelConfigurationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabelPC8, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabelPC9, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabelPC12, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabelPC13, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabelPC16, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabelPC17, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabelPC19, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelConfigurationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jLabelPC5, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabelPC6, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addGap(18, 18, 18)
                        .addGroup(jPanelConfigurationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabelDisplayA0, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabelDisplayA2, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabelDisplayA1, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabelDisplayA3, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabelDisplayA4, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabelDisplayA5, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabelDisplayA6, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabelDisplayUSP, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabelDisplaySSP, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanelConfigurationLayout.createSequentialGroup()
                        .addComponent(jLabelOperatingMode)
                        .addGap(91, 91, 91)
                        .addComponent(jLabelOperatingMode1)))
                .addContainerGap(45, Short.MAX_VALUE))
        );
        jPanelConfigurationLayout.setVerticalGroup(
            jPanelConfigurationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelConfigurationLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jPanelConfigurationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelOperatingMode)
                    .addComponent(jLabelOperatingMode1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanelConfigurationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabelDisplayA0)
                    .addComponent(jLabelPC5)
                    .addComponent(jLabelDisplayD0)
                    .addComponent(jLabelPC3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanelConfigurationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabelDisplayA1)
                    .addComponent(jLabelPC6)
                    .addComponent(jLabelDisplayD1)
                    .addComponent(jLabelPC4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanelConfigurationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabelDisplayA2)
                    .addComponent(jLabelPC8)
                    .addComponent(jLabelDisplayD2)
                    .addComponent(jLabelPC7))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanelConfigurationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabelDisplayA3)
                    .addComponent(jLabelPC9)
                    .addComponent(jLabelDisplayD3)
                    .addComponent(jLabelPC10))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanelConfigurationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabelDisplayA4)
                    .addComponent(jLabelPC12)
                    .addComponent(jLabelDisplayD4)
                    .addComponent(jLabelPC11))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanelConfigurationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabelDisplayA5)
                    .addComponent(jLabelPC13)
                    .addComponent(jLabelDisplayD5)
                    .addComponent(jLabelPC14))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanelConfigurationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabelDisplayA6)
                    .addComponent(jLabelPC16)
                    .addComponent(jLabelDisplayD6)
                    .addComponent(jLabelPC15))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanelConfigurationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabelDisplayUSP)
                    .addComponent(jLabelPC17)
                    .addComponent(jLabelDisplayD7)
                    .addComponent(jLabelPC18))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanelConfigurationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabelDisplaySSP)
                    .addComponent(jLabelPC19))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTabbedPane.addTab("Registers", jPanelConfiguration);

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "Position", "Data"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Short.class, java.lang.Short.class
            };
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable1.setColumnSelectionAllowed(true);
        jScrollPane1.setViewportView(jTable1);
        jTable1.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);

        javax.swing.GroupLayout jPanelMemoryLayout = new javax.swing.GroupLayout(jPanelMemory);
        jPanelMemory.setLayout(jPanelMemoryLayout);
        jPanelMemoryLayout.setHorizontalGroup(
            jPanelMemoryLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelMemoryLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 455, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(7, Short.MAX_VALUE))
        );
        jPanelMemoryLayout.setVerticalGroup(
            jPanelMemoryLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelMemoryLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 264, Short.MAX_VALUE)
                .addContainerGap())
        );

        jTabbedPane.addTab("Memory", jPanelMemory);

        jTextAreaLog.setColumns(20);
        jTextAreaLog.setFont(new java.awt.Font("DIN Alternate", 1, 14)); // NOI18N
        jTextAreaLog.setRows(5);
        jTextAreaLog.setEnabled(false);
        jScrollPane3.setViewportView(jTextAreaLog);

        javax.swing.GroupLayout jPanelLogLayout = new javax.swing.GroupLayout(jPanelLog);
        jPanelLog.setLayout(jPanelLogLayout);
        jPanelLogLayout.setHorizontalGroup(
            jPanelLogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelLogLayout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 446, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanelLogLayout.setVerticalGroup(
            jPanelLogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelLogLayout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 254, Short.MAX_VALUE)
                .addContainerGap())
        );

        jTabbedPane.addTab("Logs", jPanelLog);

        jTextFieldInput.setFont(new java.awt.Font("DIN Light", 0, 12)); // NOI18N
        jTextFieldInput.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldInputActionPerformed(evt);
            }
        });

        jButtonReset.setFont(new java.awt.Font("DIN Light", 0, 14)); // NOI18N
        jButtonReset.setText("Reset");
        jButtonReset.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonResetActionPerformed(evt);
            }
        });

        jButtonStart1.setFont(new java.awt.Font("DIN Light", 0, 14)); // NOI18N
        jButtonStart1.setText("Start");
        jButtonStart1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonStart1ActionPerformed(evt);
            }
        });

        jTextLinkFileList.setEditable(false);
        jTextLinkFileList.setColumns(20);
        jTextLinkFileList.setFont(new java.awt.Font("DIN Alternate", 1, 14)); // NOI18N
        jTextLinkFileList.setRows(5);
        jTextLinkFileList.setEnabled(false);
        jScrollPane2.setViewportView(jTextLinkFileList);

        jLabelOut1.setFont(new java.awt.Font("DIN Medium", 1, 14)); // NOI18N
        jLabelOut1.setText("Output");

        jTextFieldOutput.setFont(new java.awt.Font("DIN Light", 0, 12)); // NOI18N
        jTextFieldOutput.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldOutputActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanelDisplayRELayout = new javax.swing.GroupLayout(jPanelDisplayRE);
        jPanelDisplayRE.setLayout(jPanelDisplayRELayout);
        jPanelDisplayRELayout.setHorizontalGroup(
            jPanelDisplayRELayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelDisplayRELayout.createSequentialGroup()
                .addGroup(jPanelDisplayRELayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jSeparator2, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanelDisplayRELayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanelDisplayRELayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanelDisplayRELayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(jLabelVersion)
                                .addComponent(jLabelName))
                            .addGroup(jPanelDisplayRELayout.createSequentialGroup()
                                .addComponent(jTabbedPane, javax.swing.GroupLayout.PREFERRED_SIZE, 489, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanelDisplayRELayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(jPanelDisplayRELayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabelIn)
                                        .addComponent(jLabelOut)
                                        .addGroup(jPanelDisplayRELayout.createSequentialGroup()
                                            .addComponent(jButtonStart1, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGap(53, 53, 53)
                                            .addComponent(jButtonReset, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jTextFieldInput, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 247, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabelOut1))
                                    .addComponent(jTextFieldOutput, javax.swing.GroupLayout.PREFERRED_SIZE, 247, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(0, 15, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanelDisplayRELayout.setVerticalGroup(
            jPanelDisplayRELayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelDisplayRELayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabelName, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabelVersion, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(47, 47, 47)
                .addComponent(jLabelIn)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextFieldInput, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabelOut)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabelOut1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextFieldOutput, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(21, 21, 21)
                .addGroup(jPanelDisplayRELayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonReset)
                    .addComponent(jButtonStart1))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanelDisplayRELayout.createSequentialGroup()
                .addGap(86, 86, 86)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTabbedPane)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanelDisplayRE, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanelDisplayRE, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 39, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>                        

    private void jButtonResetActionPerformed(java.awt.event.ActionEvent evt) {                                             
        // TODO add your handling code here:
    }                                            

    private void jTextFieldInputActionPerformed(java.awt.event.ActionEvent evt) {                                                
        // TODO add your handling code here:
    }                                               

    private void jButtonStart1ActionPerformed(java.awt.event.ActionEvent evt) {                                              
        // TODO add your handling code here:
    }                                             

    private void jCheckBoxLinkerActionPerformed(java.awt.event.ActionEvent evt) {                                                
        if(jCheckBoxLinker.isSelected()){
            System.out.println("selecionado");
        }else{
            System.out.println("não elecionado");
        }
    }                                               

    private void jCheckBoxAssemblerActionPerformed(java.awt.event.ActionEvent evt) {                                                   
        // TODO add your handling code here:
    }                                                  

    private void jCheckBoxLoaderActionPerformed(java.awt.event.ActionEvent evt) {                                                
        // TODO add your handling code here:
    }                                               

    private void jCheckBoxVirtualMachineActionPerformed(java.awt.event.ActionEvent evt) {                                                        
        // TODO add your handling code here:
    }                                                       

    private void jTextFieldOutputActionPerformed(java.awt.event.ActionEvent evt) {                                                 
        // TODO add your handling code here:
    }
}
