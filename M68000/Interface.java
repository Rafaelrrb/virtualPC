/*
 * Interface é a GUI usada pela Principal para ser o meio entre a aplicação (application) e o usuário
 */
package M68000;

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
    private javax.swing.JDialog jDialog1;
    private javax.swing.JLabel jLabelAssemblerUsage;
    private javax.swing.JLabel jLabelCommands1;
    private javax.swing.JLabel jLabelCommands2;
    private javax.swing.JLabel jLabelCommands3;
    private javax.swing.JLabel jLabelCommands4;
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
    private javax.swing.JLabel jLabelDisplayX;
    private javax.swing.JLabel jLabelX;
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
    private javax.swing.JLabel jLabelSymbols;
    private javax.swing.JLabel jLabelVersion;
    private javax.swing.JLabel jLabelddresss;
    private javax.swing.JPanel jPanelDisplayRE;
    private javax.swing.JPanel jPanelGeneral;
    private javax.swing.JPanel jPanelLog;
    private javax.swing.JPanel jPanelObjectCode;
    private javax.swing.JPanel jPanelRegisters;
    private javax.swing.JPanel jPanelTablet;
    private javax.swing.JPopupMenu jPopupMenu1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JTabbedPane jTabbedPane;
    private javax.swing.JTable jTableAssemblerUsage;
    private javax.swing.JTable jTableMemory;
    private javax.swing.JTable jTableSymbols;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JTextArea jTextAreaLog;
    private javax.swing.JTextField jTextFieldInput;
    private javax.swing.JTextField jTextFieldOutput;
    private javax.swing.JTextArea jTextLinkFileList;
    private Application application;
    
    public Interface(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        application = new Application();
        initComponents();
        jScrollPane2.setVisible(false);
        jLabelOut.setVisible(false);
        
        javax.swing.JLabel[] registersA = new javax.swing.JLabel[7];
        registersA[0] = jLabelDisplayA0;
        registersA[1] = jLabelDisplayA1;
        registersA[2] = jLabelDisplayA2;
        registersA[3] = jLabelDisplayA3;
        registersA[4] = jLabelDisplayA4;
        registersA[5] = jLabelDisplayA5;
        registersA[6] = jLabelDisplayA6;
        javax.swing.JLabel[] registersD = new javax.swing.JLabel[9];
        registersD[0] = jLabelDisplayA0;
        registersD[1] = jLabelDisplayA1;
        registersD[2] = jLabelDisplayA2;
        registersD[3] = jLabelDisplayA3;
        registersD[4] = jLabelDisplayA4;
        registersD[5] = jLabelDisplayA5;
        registersD[6] = jLabelDisplayA6;
        registersD[7] = jLabelDisplayUSP;
        registersD[8] = jLabelDisplaySSP;
        application.configuration.setRegisterAnddress(registersA);
        application.configuration.setRegisterData(registersD);
        application.configuration.setGeralComboBox(jCheckBoxAssembler, jCheckBoxLinker, jCheckBoxLoader, jCheckBoxVirtualMachine);
        application.configuration.setInPut(jTextFieldInput);
        application.configuration.setOutPut(jTextFieldOutput);
        application.configuration.setLog(jTextAreaLog);
        application.configuration.setGeneralLabels(jLabelDisplayPC, jLabelDisplayACC, jLabelDisplayAddress, jLabelDisplayN, jLabelDisplayZ, jLabelDisplayV, jLabelDisplayC, jLabelDisplayX);
        application.configuration.setLinkerListFile(this.jTextLinkFileList);
        application.memory.setTableMemory(jTableMemory);
        application.tableSymbol.setTableSymbol(jTableSymbols);
        application.tableUsage.setTableAssemblerUsage(jTableAssemblerUsage);
    }
    
    private void initComponents() {
        
        jPopupMenu1 = new javax.swing.JPopupMenu();
        jDialog1 = new javax.swing.JDialog();
        jPanelDisplayRE = new javax.swing.JPanel();
        jLabelName = new javax.swing.JLabel();
        jLabelVersion = new javax.swing.JLabel();
        jSeparator2 = new javax.swing.JSeparator();
        jTabbedPane = new javax.swing.JTabbedPane();
        jPanelGeneral = new javax.swing.JPanel();
        jLabelCommands2 = new javax.swing.JLabel();
        jCheckBoxLinker = new javax.swing.JCheckBox();
        jCheckBoxAssembler = new javax.swing.JCheckBox();
        jCheckBoxLoader = new javax.swing.JCheckBox();
        jCheckBoxVirtualMachine = new javax.swing.JCheckBox();
        jLabelIn = new javax.swing.JLabel();
        jTextFieldInput = new javax.swing.JTextField();
        jLabelOut = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTextLinkFileList = new javax.swing.JTextArea();
        jLabelOut1 = new javax.swing.JLabel();
        jTextFieldOutput = new javax.swing.JTextField();
        jButtonStart1 = new javax.swing.JButton();
        jButtonReset = new javax.swing.JButton();
        jScrollPane6 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jPanelRegisters = new javax.swing.JPanel();
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
        jLabelddresss = new javax.swing.JLabel();
        jLabelSP = new javax.swing.JLabel();
        jLabelPC = new javax.swing.JLabel();
        jLabelCommands1 = new javax.swing.JLabel();
        jLabelDisplayPC = new javax.swing.JLabel();
        jLabelDisplayACC = new javax.swing.JLabel();
        jLabelDisplayAddress = new javax.swing.JLabel();
        jLabelDisplayC = new javax.swing.JLabel();
        jLabelRE1 = new javax.swing.JLabel();
        jLabelRE = new javax.swing.JLabel();
        jLabelRI = new javax.swing.JLabel();
        jLabelMOP = new javax.swing.JLabel();
        jLabelDisplayN = new javax.swing.JLabel();
        jLabelDisplayZ = new javax.swing.JLabel();
        jLabelDisplayV = new javax.swing.JLabel();
        jLabelX = new javax.swing.JLabel();
        jLabelDisplayX = new javax.swing.JLabel();
        jLabelCommands3 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableMemory = new javax.swing.JTable();
        jLabelCommands4 = new javax.swing.JLabel();
        jPanelTablet = new javax.swing.JPanel();
        jLabelSymbols = new javax.swing.JLabel();
        jScrollPane4 = new javax.swing.JScrollPane();
        jTableAssemblerUsage = new javax.swing.JTable();
        jLabelAssemblerUsage = new javax.swing.JLabel();
        jScrollPane5 = new javax.swing.JScrollPane();
        jTableSymbols = new javax.swing.JTable();
        jPanelObjectCode = new javax.swing.JPanel();
        jPanelLog = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTextAreaLog = new javax.swing.JTextArea();

        javax.swing.GroupLayout jDialog1Layout = new javax.swing.GroupLayout(jDialog1.getContentPane());
        jDialog1.getContentPane().setLayout(jDialog1Layout);
        jDialog1Layout.setHorizontalGroup(
            jDialog1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        jDialog1Layout.setVerticalGroup(
            jDialog1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanelDisplayRE.setBackground(new java.awt.Color(255, 255, 255));

        jLabelName.setFont(new java.awt.Font("DIN Light", 0, 48)); // NOI18N
        jLabelName.setText("Moto 68k");

        jLabelVersion.setFont(new java.awt.Font("DIN Light", 0, 12)); // NOI18N
        jLabelVersion.setText("Version Alpha");

        jLabelCommands2.setFont(new java.awt.Font("DIN Medium", 1, 14)); // NOI18N
        jLabelCommands2.setText("Step");

        jCheckBoxLinker.setText("Linker");
        jCheckBoxLinker.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBoxLinkerActionPerformed(evt);
            }
        });

        jCheckBoxAssembler.setSelected(true);
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

        jLabelIn.setFont(new java.awt.Font("DIN Medium", 1, 14)); // NOI18N
        jLabelIn.setText("Input file");

        jTextFieldInput.setFont(new java.awt.Font("DIN Light", 0, 12)); // NOI18N
        jTextFieldInput.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldInputActionPerformed(evt);
            }
        });

        jLabelOut.setFont(new java.awt.Font("DIN Medium", 1, 14)); // NOI18N
        jLabelOut.setText("Link files list");

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

        jButtonStart1.setFont(new java.awt.Font("DIN Light", 0, 14)); // NOI18N
        jButtonStart1.setText("Start");
        jButtonStart1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonStart1ActionPerformed(evt);
            }
        });

        jButtonReset.setFont(new java.awt.Font("DIN Light", 0, 14)); // NOI18N
        jButtonReset.setText("Reset");
        jButtonReset.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonResetActionPerformed(evt);
            }
        });

        jTextArea1.setBackground(new java.awt.Color(238, 238, 238));
        jTextArea1.setColumns(20);
        jTextArea1.setLineWrap(true);
        jTextArea1.setRows(5);
        jTextArea1.setWrapStyleWord(true);
        jScrollPane6.setViewportView(jTextArea1);

        javax.swing.GroupLayout jPanelGeneralLayout = new javax.swing.GroupLayout(jPanelGeneral);
        jPanelGeneral.setLayout(jPanelGeneralLayout);
        jPanelGeneralLayout.setHorizontalGroup(
            jPanelGeneralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelGeneralLayout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(jPanelGeneralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanelGeneralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabelIn)
                        .addComponent(jLabelOut)
                        .addComponent(jLabelOut1)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelGeneralLayout.createSequentialGroup()
                            .addGap(16, 16, 16)
                            .addGroup(jPanelGeneralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jTextFieldInput, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 247, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addComponent(jLabelCommands2)
                        .addComponent(jCheckBoxAssembler)
                        .addComponent(jCheckBoxLinker)
                        .addComponent(jCheckBoxLoader)
                        .addComponent(jCheckBoxVirtualMachine))
                    .addComponent(jTextFieldOutput, javax.swing.GroupLayout.PREFERRED_SIZE, 247, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 150, Short.MAX_VALUE)
                .addGroup(jPanelGeneralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 286, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelGeneralLayout.createSequentialGroup()
                        .addComponent(jButtonStart1, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(53, 53, 53)
                        .addComponent(jButtonReset, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(12, 12, 12)))
                .addGap(23, 23, 23))
        );
        jPanelGeneralLayout.setVerticalGroup(
            jPanelGeneralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelGeneralLayout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(jPanelGeneralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelGeneralLayout.createSequentialGroup()
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
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabelCommands2)
                        .addGap(12, 12, 12)
                        .addComponent(jCheckBoxAssembler)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jCheckBoxLinker))
                    .addGroup(jPanelGeneralLayout.createSequentialGroup()
                        .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 357, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 9, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jCheckBoxLoader)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanelGeneralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jCheckBoxVirtualMachine)
                    .addGroup(jPanelGeneralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jButtonReset)
                        .addComponent(jButtonStart1)))
                .addGap(63, 63, 63))
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

        jLabelddresss.setFont(new java.awt.Font("DIN Light", 0, 14)); // NOI18N
        jLabelddresss.setText("Address");

        jLabelSP.setFont(new java.awt.Font("DIN Light", 0, 14)); // NOI18N
        jLabelSP.setText("ACC");

        jLabelPC.setFont(new java.awt.Font("DIN Light", 0, 14)); // NOI18N
        jLabelPC.setText("PC");

        jLabelCommands1.setFont(new java.awt.Font("DIN Medium", 1, 14)); // NOI18N
        jLabelCommands1.setText("Engine");

        jLabelDisplayPC.setBackground(new java.awt.Color(0, 0, 0));
        jLabelDisplayPC.setFont(new java.awt.Font("Courier New", 1, 14)); // NOI18N
        jLabelDisplayPC.setText("--");

        jLabelDisplayACC.setBackground(new java.awt.Color(0, 0, 0));
        jLabelDisplayACC.setFont(new java.awt.Font("Courier New", 1, 14)); // NOI18N
        jLabelDisplayACC.setText("--");

        jLabelDisplayAddress.setBackground(new java.awt.Color(0, 0, 0));
        jLabelDisplayAddress.setFont(new java.awt.Font("Courier New", 1, 14)); // NOI18N
        jLabelDisplayAddress.setText("--");

        jLabelDisplayC.setBackground(new java.awt.Color(0, 0, 0));
        jLabelDisplayC.setFont(new java.awt.Font("Courier New", 1, 14)); // NOI18N
        jLabelDisplayC.setText("-");

        jLabelRE1.setFont(new java.awt.Font("DIN Light", 0, 14)); // NOI18N
        jLabelRE1.setText("C");

        jLabelRE.setFont(new java.awt.Font("DIN Light", 0, 14)); // NOI18N
        jLabelRE.setText("V");

        jLabelRI.setFont(new java.awt.Font("DIN Light", 0, 14)); // NOI18N
        jLabelRI.setText("Z");

        jLabelMOP.setFont(new java.awt.Font("DIN Light", 0, 14)); // NOI18N
        jLabelMOP.setText("N");

        jLabelDisplayN.setBackground(new java.awt.Color(0, 0, 0));
        jLabelDisplayN.setFont(new java.awt.Font("Courier New", 1, 14)); // NOI18N
        jLabelDisplayN.setText("-");

        jLabelDisplayZ.setBackground(new java.awt.Color(0, 0, 0));
        jLabelDisplayZ.setFont(new java.awt.Font("Courier New", 1, 14)); // NOI18N
        jLabelDisplayZ.setText("-");

        jLabelDisplayV.setBackground(new java.awt.Color(0, 0, 0));
        jLabelDisplayV.setFont(new java.awt.Font("Courier New", 1, 14)); // NOI18N
        jLabelDisplayV.setText("-");

        jLabelCommands3.setFont(new java.awt.Font("DIN Medium", 1, 14)); // NOI18N
        jLabelCommands3.setText("CCR");

        jTableMemory.setModel(new javax.swing.table.DefaultTableModel(
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
        jTableMemory.setColumnSelectionAllowed(true);
        jScrollPane1.setViewportView(jTableMemory);
        jTableMemory.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        if (jTableMemory.getColumnModel().getColumnCount() > 0) {
            jTableMemory.getColumnModel().getColumn(0).setResizable(false);
            jTableMemory.getColumnModel().getColumn(1).setResizable(false);
        }

        jLabelCommands4.setFont(new java.awt.Font("DIN Medium", 1, 14)); // NOI18N
        jLabelCommands4.setText("Memory");

        jLabelX.setFont(new java.awt.Font("DIN Light", 0, 14)); // NOI18N
        jLabelX.setText("X");

        jLabelDisplayX.setBackground(new java.awt.Color(0, 0, 0));
        jLabelDisplayX.setFont(new java.awt.Font("Courier New", 1, 14)); // NOI18N
        jLabelDisplayX.setText("-");
        
        javax.swing.GroupLayout jPanelRegistersLayout = new javax.swing.GroupLayout(jPanelRegisters);
        jPanelRegisters.setLayout(jPanelRegistersLayout);
        jPanelRegistersLayout.setHorizontalGroup(
            jPanelRegistersLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelRegistersLayout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(jPanelRegistersLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelRegistersLayout.createSequentialGroup()
                        .addGroup(jPanelRegistersLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanelRegistersLayout.createSequentialGroup()
                                .addGap(6, 6, 6)
                                .addGroup(jPanelRegistersLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabelPC3, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabelPC4, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabelPC7, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabelPC10, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabelPC11, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabelPC14, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabelPC15, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabelPC18, javax.swing.GroupLayout.Alignment.TRAILING))
                                .addGap(18, 18, 18)
                                .addGroup(jPanelRegistersLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabelDisplayD0, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabelDisplayD2, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabelDisplayD1, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabelDisplayD3, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabelDisplayD4, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabelDisplayD5, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabelDisplayD6, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabelDisplayD7, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanelRegistersLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabelPC8, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabelPC9, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabelPC12, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabelPC13, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabelPC16, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabelPC17, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabelPC19, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelRegistersLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(jLabelPC5, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jLabelPC6, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                                .addGap(18, 18, 18)
                                .addGroup(jPanelRegistersLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabelDisplayA0, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabelDisplayA2, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabelDisplayA1, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabelDisplayA3, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabelDisplayA4, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabelDisplayA5, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabelDisplayA6, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabelDisplayUSP, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabelDisplaySSP, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanelRegistersLayout.createSequentialGroup()
                                .addComponent(jLabelOperatingMode)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabelOperatingMode1)
                                .addGap(64, 64, 64)))
                        .addGroup(jPanelRegistersLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanelRegistersLayout.createSequentialGroup()
                                .addGroup(jPanelRegistersLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabelCommands1)
                                    .addComponent(jLabelCommands3))
                                .addGap(353, 353, 353))
                            .addGroup(jPanelRegistersLayout.createSequentialGroup()
                                .addGroup(jPanelRegistersLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanelRegistersLayout.createSequentialGroup()
                                        .addComponent(jLabelRE1)
                                        .addGap(28, 28, 28)
                                        .addComponent(jLabelDisplayC, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanelRegistersLayout.createSequentialGroup()
                                        .addComponent(jLabelRE)
                                        .addGap(31, 31, 31)
                                        .addComponent(jLabelDisplayV, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanelRegistersLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanelRegistersLayout.createSequentialGroup()
                                            .addComponent(jLabelRI)
                                            .addGap(30, 30, 30)
                                            .addComponent(jLabelDisplayZ, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanelRegistersLayout.createSequentialGroup()
                                            .addComponent(jLabelMOP)
                                            .addGap(28, 28, 28)
                                            .addComponent(jLabelDisplayN, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addComponent(jLabelPC)
                                    .addComponent(jLabelSP)
                                    .addGroup(jPanelRegistersLayout.createSequentialGroup()
                                        .addComponent(jLabelddresss)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(jPanelRegistersLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabelDisplayAddress, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabelDisplayACC, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabelDisplayPC, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addGroup(jPanelRegistersLayout.createSequentialGroup()
                                        .addComponent(jLabelX)
                                        .addGap(28, 28, 28)
                                        .addComponent(jLabelDisplayX, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                    .addGroup(jPanelRegistersLayout.createSequentialGroup()
                        .addComponent(jLabelCommands4)
                        .addGap(0, 0, Short.MAX_VALUE))))
            .addGroup(jPanelRegistersLayout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 700, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanelRegistersLayout.setVerticalGroup(
            jPanelRegistersLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelRegistersLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jPanelRegistersLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelRegistersLayout.createSequentialGroup()
                        .addGroup(jPanelRegistersLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabelOperatingMode)
                            .addComponent(jLabelOperatingMode1, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanelRegistersLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabelDisplayA0)
                            .addComponent(jLabelPC5)
                            .addComponent(jLabelDisplayD0)
                            .addComponent(jLabelPC3))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanelRegistersLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabelDisplayA1)
                            .addComponent(jLabelPC6)
                            .addComponent(jLabelDisplayD1)
                            .addComponent(jLabelPC4))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanelRegistersLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabelDisplayA2)
                            .addComponent(jLabelPC8)
                            .addComponent(jLabelDisplayD2)
                            .addComponent(jLabelPC7))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanelRegistersLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanelRegistersLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabelDisplayA3)
                                .addComponent(jLabelCommands3))
                            .addComponent(jLabelPC9)
                            .addComponent(jLabelDisplayD3)
                            .addComponent(jLabelPC10)))
                    .addGroup(jPanelRegistersLayout.createSequentialGroup()
                        .addComponent(jLabelCommands1)
                        .addGap(7, 7, 7)
                        .addGroup(jPanelRegistersLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanelRegistersLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addGroup(jPanelRegistersLayout.createSequentialGroup()
                                    .addComponent(jLabelDisplayPC)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(jLabelDisplayACC))
                                .addGroup(jPanelRegistersLayout.createSequentialGroup()
                                    .addComponent(jLabelPC)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(jLabelSP)))
                            .addGroup(jPanelRegistersLayout.createSequentialGroup()
                                .addGap(47, 47, 47)
                                .addGroup(jPanelRegistersLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabelddresss)
                                    .addComponent(jLabelDisplayAddress))))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanelRegistersLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelRegistersLayout.createSequentialGroup()
                        .addGroup(jPanelRegistersLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabelMOP)
                            .addComponent(jLabelDisplayN))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanelRegistersLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabelRI)
                            .addComponent(jLabelDisplayZ))
                        .addGap(7, 7, 7)
                        .addGroup(jPanelRegistersLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabelRE)
                            .addComponent(jLabelDisplayV))
                        .addGroup(jPanelRegistersLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabelRE1)
                            .addComponent(jLabelDisplayC))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanelRegistersLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabelX)
                            .addComponent(jLabelDisplayX)))
                    .addGroup(jPanelRegistersLayout.createSequentialGroup()
                        .addGroup(jPanelRegistersLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabelDisplayA4)
                            .addComponent(jLabelPC12)
                            .addComponent(jLabelDisplayD4)
                            .addComponent(jLabelPC11))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanelRegistersLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabelDisplayA5)
                            .addComponent(jLabelPC13)
                            .addComponent(jLabelDisplayD5)
                            .addComponent(jLabelPC14))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanelRegistersLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabelDisplayA6)
                            .addComponent(jLabelPC16)
                            .addComponent(jLabelDisplayD6)
                            .addComponent(jLabelPC15))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanelRegistersLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabelDisplayUSP)
                            .addComponent(jLabelPC17)
                            .addComponent(jLabelDisplayD7)
                            .addComponent(jLabelPC18))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanelRegistersLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabelDisplaySSP)
                            .addComponent(jLabelPC19))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 35, Short.MAX_VALUE)
                .addComponent(jLabelCommands4)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 209, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jTabbedPane.addTab("Registers and Memory", jPanelRegisters);

        jLabelSymbols.setFont(new java.awt.Font("DIN Medium", 1, 14)); // NOI18N
        jLabelSymbols.setText("Table Symbols");

        jTableAssemblerUsage.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Global", "Symbol", "Andress"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Boolean.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTableAssemblerUsage.setColumnSelectionAllowed(true);
        jScrollPane4.setViewportView(jTableAssemblerUsage);
        jTableAssemblerUsage.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        if (jTableAssemblerUsage.getColumnModel().getColumnCount() > 0) {
            jTableAssemblerUsage.getColumnModel().getColumn(0).setResizable(false);
            jTableAssemblerUsage.getColumnModel().getColumn(1).setResizable(false);
            jTableAssemblerUsage.getColumnModel().getColumn(2).setResizable(false);
        }

        jLabelAssemblerUsage.setFont(new java.awt.Font("DIN Medium", 1, 14)); // NOI18N
        jLabelAssemblerUsage.setText("Table Usage");

        jTableSymbols.setModel(new javax.swing.table.DefaultTableModel(
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
                "Symbol", "Global"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.Boolean.class
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
        jTableSymbols.setColumnSelectionAllowed(true);
        jScrollPane5.setViewportView(jTableSymbols);
        jTableSymbols.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        if (jTableSymbols.getColumnModel().getColumnCount() > 0) {
            jTableSymbols.getColumnModel().getColumn(0).setResizable(false);
            jTableSymbols.getColumnModel().getColumn(1).setResizable(false);
        }

        javax.swing.GroupLayout jPanelTabletLayout = new javax.swing.GroupLayout(jPanelTablet);
        jPanelTablet.setLayout(jPanelTabletLayout);
        jPanelTabletLayout.setHorizontalGroup(
            jPanelTabletLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelTabletLayout.createSequentialGroup()
                .addGroup(jPanelTabletLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 693, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanelTabletLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanelTabletLayout.createSequentialGroup()
                            .addContainerGap()
                            .addComponent(jLabelSymbols))
                        .addGroup(jPanelTabletLayout.createSequentialGroup()
                            .addGap(31, 31, 31)
                            .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 694, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanelTabletLayout.createSequentialGroup()
                            .addContainerGap()
                            .addComponent(jLabelAssemblerUsage))))
                .addContainerGap(23, Short.MAX_VALUE))
        );
        jPanelTabletLayout.setVerticalGroup(
            jPanelTabletLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelTabletLayout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(jLabelSymbols)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabelAssemblerUsage)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(239, Short.MAX_VALUE))
        );

        jTabbedPane.addTab("Assembler", jPanelTablet);

        javax.swing.GroupLayout jPanelObjectCodeLayout = new javax.swing.GroupLayout(jPanelObjectCode);
        jPanelObjectCode.setLayout(jPanelObjectCodeLayout);
        jPanelObjectCodeLayout.setHorizontalGroup(
            jPanelObjectCodeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 748, Short.MAX_VALUE)
        );
        jPanelObjectCodeLayout.setVerticalGroup(
            jPanelObjectCodeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 523, Short.MAX_VALUE)
        );

        jTabbedPane.addTab("Linker", jPanelObjectCode);

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
                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 726, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanelLogLayout.setVerticalGroup(
            jPanelLogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelLogLayout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 501, Short.MAX_VALUE)
                .addContainerGap())
        );

        jTabbedPane.addTab("Logs", jPanelLog);

        javax.swing.GroupLayout jPanelDisplayRELayout = new javax.swing.GroupLayout(jPanelDisplayRE);
        jPanelDisplayRE.setLayout(jPanelDisplayRELayout);
        jPanelDisplayRELayout.setHorizontalGroup(
            jPanelDisplayRELayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSeparator2, javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(jPanelDisplayRELayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelDisplayRELayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelDisplayRELayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(jLabelVersion)
                        .addComponent(jLabelName))
                    .addComponent(jTabbedPane, javax.swing.GroupLayout.PREFERRED_SIZE, 769, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanelDisplayRELayout.setVerticalGroup(
            jPanelDisplayRELayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelDisplayRELayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabelName, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabelVersion, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
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
                .addGap(324, 324, 324))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanelDisplayRE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>                        

    private void jButtonResetActionPerformed(java.awt.event.ActionEvent evt) {                                             
        application.restart();
    }                                            

    private void jTextFieldInputActionPerformed(java.awt.event.ActionEvent evt) {                                                
        // TODO add your handling code here:
    }                                               

    private void jButtonStart1ActionPerformed(java.awt.event.ActionEvent evt) {                                              
        application.start();
    }                                             

    private void jCheckBoxLinkerActionPerformed(java.awt.event.ActionEvent evt) {                                                
        if(jCheckBoxLinker.isSelected()){
            jScrollPane2.setVisible(true);
            jLabelOut.setVisible(true);
            
            jCheckBoxAssembler.setSelected(true);
            
        }else{
            jScrollPane2.setVisible(false);
            jLabelOut.setVisible(false);
        }
    }                                               

    private void jCheckBoxAssemblerActionPerformed(java.awt.event.ActionEvent evt) {                                                   
       if(!jCheckBoxAssembler.isSelected()){
           jCheckBoxLoader.setSelected(false);
           jCheckBoxLinker.setSelected(false);
           jCheckBoxVirtualMachine.setSelected(false);
           jScrollPane2.setVisible(false);
           jLabelOut.setVisible(false);
       }
    }                                                  

    private void jCheckBoxLoaderActionPerformed(java.awt.event.ActionEvent evt) {                                                
        if(jCheckBoxLoader.isSelected()){
            jCheckBoxAssembler.setSelected(true);
            jCheckBoxLinker.setSelected(true);
            jScrollPane2.setVisible(true);
            jLabelOut.setVisible(true);
        }
    }                                               

    private void jCheckBoxVirtualMachineActionPerformed(java.awt.event.ActionEvent evt) {                                                        
        if(jCheckBoxVirtualMachine.isSelected()){
            //jCheckBoxAssembler.setSelected(true);
            //jCheckBoxLoader.setSelected(true);
            //jCheckBoxLinker.setSelected(true);
            //jScrollPane2.setVisible(true);
            //jLabelOut.setVisible(true);
        }
    }                                                       

    private void jTextFieldOutputActionPerformed(java.awt.event.ActionEvent evt) {                                                 
        // TODO add your handling code here:
    }
}
