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
        config.setDisplayLabels(jLabelDisplayPC, jLabelDisplayMOP,jLabelDisplayRE, jLabelDisplayRI, jLabelDisplaySP, jLabelDisplayACC, jLabelDisplayAddress);
        
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
        jButtonNextStep = new javax.swing.JButton();
        jSeparator2 = new javax.swing.JSeparator();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTextAreaOutPut = new javax.swing.JTextArea();
        jLabelIn = new javax.swing.JLabel();
        jLabelOut = new javax.swing.JLabel();
        jTextFieldInput = new javax.swing.JTextField();
        jTabbedPane = new javax.swing.JTabbedPane();
        jPanelGeneral = new javax.swing.JPanel();
        jLabelPC = new javax.swing.JLabel();
        jLabelDisplayPC = new javax.swing.JLabel();
        jLabelSP = new javax.swing.JLabel();
        jLabelDisplaySP = new javax.swing.JLabel();
        jLabelACC = new javax.swing.JLabel();
        jLabelDisplayACC = new javax.swing.JLabel();
        jLabelMOP = new javax.swing.JLabel();
        jLabelDisplayMOP = new javax.swing.JLabel();
        jLabelDisplayRI = new javax.swing.JLabel();
        jLabelRI = new javax.swing.JLabel();
        jLabelRE = new javax.swing.JLabel();
        jLabelDisplayRE = new javax.swing.JLabel();
        jLabelddresss = new javax.swing.JLabel();
        jLabelDisplayAddress = new javax.swing.JLabel();
        jLabelCommands1 = new javax.swing.JLabel();
        jLabelCommands2 = new javax.swing.JLabel();
        jPanelConfiguration = new javax.swing.JPanel();
        jComboMode = new javax.swing.JComboBox();
        jLabelOperatingMode = new javax.swing.JLabel();
        jPanelMemory = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jButtonReset = new javax.swing.JButton();
        jButtonStart1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanelDisplayRE.setBackground(new java.awt.Color(255, 255, 255));

        jLabelName.setFont(new java.awt.Font("DIN Light", 0, 48)); // NOI18N
        jLabelName.setText("VirtualPC");

        jLabelVersion.setFont(new java.awt.Font("DIN Light", 0, 12)); // NOI18N
        jLabelVersion.setText("Version Calingaert");

        jButtonNextStep.setFont(new java.awt.Font("DIN Light", 0, 14)); // NOI18N
        jButtonNextStep.setText("Step by Step");
        jButtonNextStep.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonNextStepActionPerformed(evt);
            }
        });

        jTextAreaOutPut.setColumns(20);
        jTextAreaOutPut.setFont(new java.awt.Font("DIN Alternate", 1, 14)); // NOI18N
        jTextAreaOutPut.setRows(5);
        jTextAreaOutPut.setEnabled(false);
        jScrollPane2.setViewportView(jTextAreaOutPut);

        jLabelIn.setFont(new java.awt.Font("DIN Medium", 1, 14)); // NOI18N
        jLabelIn.setText("In");

        jLabelOut.setFont(new java.awt.Font("DIN Medium", 1, 14)); // NOI18N
        jLabelOut.setText("Out");

        jTextFieldInput.setFont(new java.awt.Font("DIN Light", 0, 12)); // NOI18N
        jTextFieldInput.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldInputActionPerformed(evt);
                //Config.getInstance().setLog(jTextFieldInput.getText());
                Line line = new Line(jTextFieldInput.getText());
                jTextFieldInput.setText("");
            }
        });

        jLabelPC.setFont(new java.awt.Font("DIN Light", 0, 14)); // NOI18N
        jLabelPC.setText("PC");

        jLabelDisplayPC.setBackground(new java.awt.Color(0, 0, 0));
        jLabelDisplayPC.setFont(new java.awt.Font("Courier New", 1, 14)); // NOI18N
        jLabelDisplayPC.setText("--");

        jLabelSP.setFont(new java.awt.Font("DIN Light", 0, 14)); // NOI18N
        jLabelSP.setText("SP");

        jLabelDisplaySP.setBackground(new java.awt.Color(0, 0, 0));
        jLabelDisplaySP.setFont(new java.awt.Font("Courier New", 1, 14)); // NOI18N
        jLabelDisplaySP.setText("--");

        jLabelACC.setFont(new java.awt.Font("DIN Light", 0, 14)); // NOI18N
        jLabelACC.setText("ACC");

        jLabelDisplayACC.setBackground(new java.awt.Color(0, 0, 0));
        jLabelDisplayACC.setFont(new java.awt.Font("Courier New", 1, 14)); // NOI18N
        jLabelDisplayACC.setText("--");

        jLabelMOP.setFont(new java.awt.Font("DIN Light", 0, 14)); // NOI18N
        jLabelMOP.setText("MOP");

        jLabelDisplayMOP.setBackground(new java.awt.Color(0, 0, 0));
        jLabelDisplayMOP.setFont(new java.awt.Font("Courier New", 1, 14)); // NOI18N
        jLabelDisplayMOP.setText("--");

        jLabelDisplayRI.setBackground(new java.awt.Color(0, 0, 0));
        jLabelDisplayRI.setFont(new java.awt.Font("Courier New", 1, 14)); // NOI18N
        jLabelDisplayRI.setText("--");

        jLabelRI.setFont(new java.awt.Font("DIN Light", 0, 14)); // NOI18N
        jLabelRI.setText("RI");

        jLabelRE.setFont(new java.awt.Font("DIN Light", 0, 14)); // NOI18N
        jLabelRE.setText("RE");

        jLabelDisplayRE.setBackground(new java.awt.Color(0, 0, 0));
        jLabelDisplayRE.setFont(new java.awt.Font("Courier New", 1, 14)); // NOI18N
        jLabelDisplayRE.setText("--");

        jLabelddresss.setFont(new java.awt.Font("DIN Light", 0, 14)); // NOI18N
        jLabelddresss.setText("Address");

        jLabelDisplayAddress.setBackground(new java.awt.Color(0, 0, 0));
        jLabelDisplayAddress.setFont(new java.awt.Font("Courier New", 1, 14)); // NOI18N
        jLabelDisplayAddress.setText("--");

        jLabelCommands1.setFont(new java.awt.Font("DIN Medium", 1, 14)); // NOI18N
        jLabelCommands1.setText("Engine");

        jLabelCommands2.setFont(new java.awt.Font("DIN Medium", 1, 14)); // NOI18N
        jLabelCommands2.setText("Memory");

        javax.swing.GroupLayout jPanelGeneralLayout = new javax.swing.GroupLayout(jPanelGeneral);
        jPanelGeneral.setLayout(jPanelGeneralLayout);
        jPanelGeneralLayout.setHorizontalGroup(
            jPanelGeneralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelGeneralLayout.createSequentialGroup()
                .addGroup(jPanelGeneralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelGeneralLayout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(jPanelGeneralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanelGeneralLayout.createSequentialGroup()
                                .addGroup(jPanelGeneralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanelGeneralLayout.createSequentialGroup()
                                        .addComponent(jLabelACC)
                                        .addGap(28, 28, 28)
                                        .addGroup(jPanelGeneralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabelDisplayPC, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabelDisplayACC, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabelDisplaySP, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addComponent(jLabelSP)
                                    .addComponent(jLabelPC))
                                .addGap(18, 18, 18)
                                .addGroup(jPanelGeneralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanelGeneralLayout.createSequentialGroup()
                                        .addComponent(jLabelRE)
                                        .addGap(40, 40, 40)
                                        .addComponent(jLabelDisplayRE, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanelGeneralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanelGeneralLayout.createSequentialGroup()
                                            .addComponent(jLabelRI)
                                            .addGap(44, 44, 44)
                                            .addComponent(jLabelDisplayRI, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanelGeneralLayout.createSequentialGroup()
                                            .addComponent(jLabelMOP)
                                            .addGap(28, 28, 28)
                                            .addComponent(jLabelDisplayMOP, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                            .addGroup(jPanelGeneralLayout.createSequentialGroup()
                                .addComponent(jLabelddresss)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabelDisplayAddress, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jPanelGeneralLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabelCommands1))
                    .addGroup(jPanelGeneralLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabelCommands2)))
                .addContainerGap(41, Short.MAX_VALUE))
        );
        jPanelGeneralLayout.setVerticalGroup(
            jPanelGeneralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelGeneralLayout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jLabelCommands1)
                .addGap(18, 18, 18)
                .addGroup(jPanelGeneralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanelGeneralLayout.createSequentialGroup()
                        .addGroup(jPanelGeneralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabelMOP)
                            .addComponent(jLabelDisplayMOP))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanelGeneralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabelRI)
                            .addComponent(jLabelDisplayRI))
                        .addGap(7, 7, 7)
                        .addGroup(jPanelGeneralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabelRE)
                            .addComponent(jLabelDisplayRE)))
                    .addGroup(jPanelGeneralLayout.createSequentialGroup()
                        .addGroup(jPanelGeneralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanelGeneralLayout.createSequentialGroup()
                                .addComponent(jLabelDisplayPC)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabelDisplaySP))
                            .addGroup(jPanelGeneralLayout.createSequentialGroup()
                                .addComponent(jLabelPC)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabelSP)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanelGeneralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabelACC)
                            .addComponent(jLabelDisplayACC))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabelCommands2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanelGeneralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelddresss)
                    .addComponent(jLabelDisplayAddress))
                .addGap(45, 45, 45))
        );

        jTabbedPane.addTab("General", jPanelGeneral);

        jComboMode.setFont(new java.awt.Font("DIN Light", 0, 14)); // NOI18N
        jComboMode.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Modo Contínuo (Sem Interação)", "Modo Contínuo (Com Interação)", "Modo de Depuração" }));
        jComboMode.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboModeActionPerformed(evt);
            }
        });

        jLabelOperatingMode.setFont(new java.awt.Font("DIN Medium", 1, 14)); // NOI18N
        jLabelOperatingMode.setText("Operating Mode");

        javax.swing.GroupLayout jPanelConfigurationLayout = new javax.swing.GroupLayout(jPanelConfiguration);
        jPanelConfiguration.setLayout(jPanelConfigurationLayout);
        jPanelConfigurationLayout.setHorizontalGroup(
            jPanelConfigurationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelConfigurationLayout.createSequentialGroup()
                .addGap(52, 52, 52)
                .addComponent(jComboMode, javax.swing.GroupLayout.PREFERRED_SIZE, 342, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 74, Short.MAX_VALUE))
            .addGroup(jPanelConfigurationLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabelOperatingMode)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanelConfigurationLayout.setVerticalGroup(
            jPanelConfigurationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelConfigurationLayout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(jLabelOperatingMode)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jComboMode, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(98, Short.MAX_VALUE))
        );

        jTabbedPane.addTab("Configuration", jPanelConfiguration);
        Object[][] objectOnModel = new Object [][] {
                {0, null},
                {1, null},
                {2, null},
                {3, null},
                {5, null},
                {4, null},
                {6, null},
                {7, null},
                {8, null},
                {9, null},
                {10, null},
                {11, null},
                {12, null},
                {13, null},
                {14, null},
                {15, null},
                {16, null},
                {17, null},
                {18, null},
                {19, null},
                {20, null},
                {21, null},
                {22, null},
                {23, null},
                {24, null},
                {25, null},
                {26, null},
                {27, null},
                {28, null},
                {29, null},
                {30, null},
                {31, null},
                {32, null},
                {33, null},
                {34, null},
                {35, null},
                {36, null},
                {37, null},
                {38, null},
                {39, null},
                {40, null},
                {41, null},
                {42, null},
                {43, null},
                {44, null},
                {45, null},
                {46, null},
                {47, null},
                {48, null},
                {49, null},
                {50, null},
                {51, null},
                {52, null},
                {53, null},
                {54, null},
                {55, null},
                {56, null},
                {57, null},
                {58, null},
                {59, null},
                {60, null},
                {61, null},
                {62, null},
                {63, null}
            }; 
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            objectOnModel,
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
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 158, Short.MAX_VALUE)
                .addContainerGap())
        );

        jTabbedPane.addTab("Memory", jPanelMemory);

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

        javax.swing.GroupLayout jPanelDisplayRELayout = new javax.swing.GroupLayout(jPanelDisplayRE);
        jPanelDisplayRE.setLayout(jPanelDisplayRELayout);
        jPanelDisplayRELayout.setHorizontalGroup(
            jPanelDisplayRELayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelDisplayRELayout.createSequentialGroup()
                .addGroup(jPanelDisplayRELayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jSeparator2, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanelDisplayRELayout.createSequentialGroup()
                        .addGroup(jPanelDisplayRELayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanelDisplayRELayout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(jPanelDisplayRELayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanelDisplayRELayout.createSequentialGroup()
                                        .addGap(6, 6, 6)
                                        .addComponent(jButtonStart1, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(25, 25, 25)
                                        .addComponent(jButtonReset, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(jButtonNextStep, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(jTabbedPane, javax.swing.GroupLayout.PREFERRED_SIZE, 489, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(jPanelDisplayRELayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanelDisplayRELayout.createSequentialGroup()
                                        .addGap(8, 8, 8)
                                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 255, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanelDisplayRELayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabelIn)
                                        .addComponent(jLabelOut)
                                        .addGroup(jPanelDisplayRELayout.createSequentialGroup()
                                            .addGap(6, 6, 6)
                                            .addComponent(jTextFieldInput, javax.swing.GroupLayout.PREFERRED_SIZE, 257, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                            .addGroup(jPanelDisplayRELayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jLabelName))
                            .addGroup(jPanelDisplayRELayout.createSequentialGroup()
                                .addGap(163, 163, 163)
                                .addComponent(jLabelVersion)))
                        .addGap(0, 13, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanelDisplayRELayout.setVerticalGroup(
            jPanelDisplayRELayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelDisplayRELayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabelName, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabelVersion, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanelDisplayRELayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelDisplayRELayout.createSequentialGroup()
                        .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTabbedPane, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                        .addGap(15, 15, 15)
                        .addGroup(jPanelDisplayRELayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButtonReset)
                            .addComponent(jButtonStart1)
                            .addComponent(jButtonNextStep)))
                    .addGroup(jPanelDisplayRELayout.createSequentialGroup()
                        .addGap(0, 46, Short.MAX_VALUE)
                        .addGroup(jPanelDisplayRELayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanelDisplayRELayout.createSequentialGroup()
                                .addGap(26, 26, 26)
                                .addComponent(jTextFieldInput, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabelIn))
                        .addGap(18, 18, 18)
                        .addComponent(jLabelOut)
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(65, 65, 65))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanelDisplayRE, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(55, 55, 55))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanelDisplayRE, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 14, Short.MAX_VALUE))
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
    private javax.swing.JLabel jLabelCommands1;
    private javax.swing.JLabel jLabelCommands2;
    private javax.swing.JLabel jLabelDisplayACC;
    private javax.swing.JLabel jLabelDisplayAddress;
    private javax.swing.JLabel jLabelDisplayMOP;
    private javax.swing.JLabel jLabelDisplayPC;
    private javax.swing.JLabel jLabelDisplayRE;
    private javax.swing.JLabel jLabelDisplayRI;
    private javax.swing.JLabel jLabelDisplaySP;
    private javax.swing.JLabel jLabelIn;
    private javax.swing.JLabel jLabelMOP;
    private javax.swing.JLabel jLabelName;
    private javax.swing.JLabel jLabelOperatingMode;
    private javax.swing.JLabel jLabelOut;
    private javax.swing.JLabel jLabelPC;
    private javax.swing.JLabel jLabelRE;
    private javax.swing.JLabel jLabelRI;
    private javax.swing.JLabel jLabelSP;
    private javax.swing.JLabel jLabelVersion;
    private javax.swing.JLabel jLabelddresss;
    private javax.swing.JPanel jPanelConfiguration;
    private javax.swing.JPanel jPanelDisplayRE;
    private javax.swing.JPanel jPanelGeneral;
    private javax.swing.JPanel jPanelMemory;
    private javax.swing.JPopupMenu jPopupMenu1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JTabbedPane jTabbedPane;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextArea jTextAreaOutPut;
    private javax.swing.JTextField jTextFieldInput;
    // End of variables declaration                   
}
