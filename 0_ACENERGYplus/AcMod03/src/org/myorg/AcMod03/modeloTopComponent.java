/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.myorg.AcMod03;

import graficas.Graficas;
import lbdm.geneticPowerModeler;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTree;
import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
import lbdm.Lbdm;
import org.netbeans.api.settings.ConvertAsProperties;
import org.openide.awt.ActionID;
import org.openide.awt.ActionReference;
import org.openide.windows.TopComponent;
import org.openide.util.NbBundle.Messages;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.labels.StandardXYItemLabelGenerator;
import org.jfree.chart.labels.XYItemLabelGenerator;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.xy.XYLineAndShapeRenderer;
import org.jfree.data.general.DefaultPieDataset;
import org.jfree.data.xy.XYDataset;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;
import org.openide.util.Exceptions;

/**
 * Top component which displays something.
 */
@ConvertAsProperties(
        dtd = "-//org.myorg.AcMod03//modelo//EN",
        autostore = false
)
@TopComponent.Description(
        preferredID = "modeloTopComponent",
        //iconBase="SET/PATH/TO/ICON/HERE",
        persistenceType = TopComponent.PERSISTENCE_ALWAYS
)
@TopComponent.Registration(mode = "editor", openAtStartup = true)
@ActionID(category = "Window", id = "org.myorg.AcMod03.modeloTopComponent")
@ActionReference(path = "Menu/Window" /*, position = 333 */)
@TopComponent.OpenActionRegistration(
        displayName = "#CTL_modeloAction",
        preferredID = "modeloTopComponent"
)
@Messages({
    "CTL_modeloAction=modelo",
    "CTL_modeloTopComponent=Modelado",
    "HINT_modeloTopComponent=This is a modelo window"
})
public final class modeloTopComponent extends TopComponent {

    // ..........................................................
    private BufferedImage _image;       //para la imagen en memoria
    private JFreeChart grafico;         // el grafico
    // ..........................................................
    
    public double energiaConsumida[]    = {2, 10, 6} ;

    
    public int numDias                               = 365;
    public int  nGenes                                = 12 ;
    
     public double [][] defCromosomas    = {
                                                                    {4,0,3,1,1,1},
                                                                    {6,1,3,0,1,0},
                                                                    {2,0,3,0,0,1},
                                                                    {1,0,3,0,1,1},
                                                                    {2,0,3,0,1,1},
                                                                    {2,0,3,0,1,1},
                                                                     };
    public double[] maximetros                 = {4,4,4,4,12,12,12,12,10,10,10,10} ;
    public double curvaPotencia[]             = {0,0,0,0,0,0,0,0,0,0,0,0};
    public double curvaPotenciaAnual[]    = new double[4380];
    public double curvasPotencias[][]       = new double[numDias][nGenes];
    public int     nLineas                            = 0;
    public String sLineas[]                        = new String[10];
    public String   sTablaInventario[][]     =  new String[500][6] ;  
    public  String tablaInventario[][][]      = new String[8][5][100] ;    
    public int nElementos[]                       = new int[20];
    public String  sTemporadas[]              = new String[12] ;
    public int nTemporadas                       = 0 ;
    public int nDiasTipo                             = 0;
    public int nInventario                           = 0 ;
    public String sDiasTipo[]                     = new String[7] ;
  // ..........................................................
    
    public float    fTablaPotenciasInst[][][][]        =   new float[3][500][48][7];
    public float    fTablaPonderaciones[][][]        =   new float[3][500][7];
    
    public float fCargasTeoricas[][][]          = new float[3][3][48] ;
 // ..........................................................
    
  public String sFileTxt = "" ;
  
  public  DefaultTableModel model;
    
   // ----------------------------------------------------------------------------------------------------------------------------------------------------------------------- 
    public modeloTopComponent() {
        initComponents();
        setName(Bundle.CTL_modeloTopComponent());
        setToolTipText(Bundle.HINT_modeloTopComponent());
        putClientProperty(TopComponent.PROP_CLOSING_DISABLED, Boolean.TRUE);
        for (int i=0; i<4380; i++) { this.curvaPotenciaAnual[i] = 0;}
        this.curvaPotenciaAnual[0] = 15;
       activarGraficas(this.curvaPotencia, this.curvaPotenciaAnual);
       crearArboles();
       iniciarTablas();

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel12 = new javax.swing.JPanel();
        jPanel13 = new javax.swing.JPanel();
        jPanel16 = new javax.swing.JPanel();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jTextField18 = new javax.swing.JTextField();
        jTextField19 = new javax.swing.JTextField();
        jLabel21 = new javax.swing.JLabel();
        jTextField20 = new javax.swing.JTextField();
        jLabel33 = new javax.swing.JLabel();
        jTextField31 = new javax.swing.JTextField();
        jButton20 = new javax.swing.JButton();
        jButton21 = new javax.swing.JButton();
        jLabel37 = new javax.swing.JLabel();
        jPanel17 = new javax.swing.JPanel();
        jTabbedPane11 = new javax.swing.JTabbedPane();
        jPanel24 = new javax.swing.JPanel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jComboBox7 = new javax.swing.JComboBox<>();
        jTextField9 = new javax.swing.JTextField();
        jTextField11 = new javax.swing.JTextField();
        jTextField12 = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel38 = new javax.swing.JLabel();
        jLabel40 = new javax.swing.JLabel();
        jPanel21 = new javax.swing.JPanel();
        jScrollPane14 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        PCContrato = new javax.swing.JPanel();
        jLabel22 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        jTextField22 = new javax.swing.JTextField();
        jTextField23 = new javax.swing.JTextField();
        jLabel25 = new javax.swing.JLabel();
        jTextField24 = new javax.swing.JTextField();
        jLabel26 = new javax.swing.JLabel();
        jTextField25 = new javax.swing.JTextField();
        jLabel27 = new javax.swing.JLabel();
        jLabel28 = new javax.swing.JLabel();
        jLabel29 = new javax.swing.JLabel();
        jTextField26 = new javax.swing.JTextField();
        jTextField27 = new javax.swing.JTextField();
        jTextField28 = new javax.swing.JTextField();
        jLabel30 = new javax.swing.JLabel();
        jLabel31 = new javax.swing.JLabel();
        jLabel32 = new javax.swing.JLabel();
        jLabel34 = new javax.swing.JLabel();
        jTextField29 = new javax.swing.JTextField();
        jLabel35 = new javax.swing.JLabel();
        jTextField30 = new javax.swing.JTextField();
        jLabel48 = new javax.swing.JLabel();
        jLabel54 = new javax.swing.JLabel();
        jTextField33 = new javax.swing.JTextField();
        jLabel56 = new javax.swing.JLabel();
        jLabel57 = new javax.swing.JLabel();
        jTextField35 = new javax.swing.JTextField();
        jLabel58 = new javax.swing.JLabel();
        jLabel59 = new javax.swing.JLabel();
        jTextField36 = new javax.swing.JTextField();
        jLabel60 = new javax.swing.JLabel();
        jScrollPane13 = new javax.swing.JScrollPane();
        jTextArea5 = new javax.swing.JTextArea();
        botonValidarCAct = new javax.swing.JButton();
        jComboBox4 = new javax.swing.JComboBox();
        jLabel96 = new javax.swing.JLabel();
        jTextField73 = new javax.swing.JTextField();
        jLabel97 = new javax.swing.JLabel();
        jLabel149 = new javax.swing.JLabel();
        jTextField111 = new javax.swing.JTextField();
        jLabel152 = new javax.swing.JLabel();
        jCheckBox5 = new javax.swing.JCheckBox();
        jComboBox5 = new javax.swing.JComboBox<>();
        jPanel72 = new javax.swing.JPanel();
        jLabel238 = new javax.swing.JLabel();
        botonValidarCAct1 = new javax.swing.JButton();
        jComboBox11 = new javax.swing.JComboBox();
        jTextField243 = new javax.swing.JTextField();
        jLabel239 = new javax.swing.JLabel();
        jLabel240 = new javax.swing.JLabel();
        jTextField244 = new javax.swing.JTextField();
        jLabel241 = new javax.swing.JLabel();
        jTextField245 = new javax.swing.JTextField();
        jLabel242 = new javax.swing.JLabel();
        jTextField246 = new javax.swing.JTextField();
        jTextField247 = new javax.swing.JTextField();
        jLabel244 = new javax.swing.JLabel();
        jTextField248 = new javax.swing.JTextField();
        jLabel245 = new javax.swing.JLabel();
        jTextField249 = new javax.swing.JTextField();
        jTextField250 = new javax.swing.JTextField();
        jTextField251 = new javax.swing.JTextField();
        jLabel248 = new javax.swing.JLabel();
        jLabel249 = new javax.swing.JLabel();
        jLabel250 = new javax.swing.JLabel();
        jLabel251 = new javax.swing.JLabel();
        jLabel252 = new javax.swing.JLabel();
        jLabel253 = new javax.swing.JLabel();
        jTextField252 = new javax.swing.JTextField();
        jTextField253 = new javax.swing.JTextField();
        jTextField254 = new javax.swing.JTextField();
        jTextField255 = new javax.swing.JTextField();
        jTextField256 = new javax.swing.JTextField();
        jTextField257 = new javax.swing.JTextField();
        jTextField258 = new javax.swing.JTextField();
        jTextField259 = new javax.swing.JTextField();
        jTextField260 = new javax.swing.JTextField();
        jTextField261 = new javax.swing.JTextField();
        jTextField262 = new javax.swing.JTextField();
        jTextField263 = new javax.swing.JTextField();
        jLabel243 = new javax.swing.JLabel();
        jTextField266 = new javax.swing.JTextField();
        jLabel246 = new javax.swing.JLabel();
        jLabel247 = new javax.swing.JLabel();
        jTextField267 = new javax.swing.JTextField();
        jLabel254 = new javax.swing.JLabel();
        jCheckBox7 = new javax.swing.JCheckBox();
        jScrollPane16 = new javax.swing.JScrollPane();
        jTextArea6 = new javax.swing.JTextArea();
        jComboBox6 = new javax.swing.JComboBox<>();
        jPanel22 = new javax.swing.JPanel();
        jPanel23 = new javax.swing.JPanel();
        jLabel39 = new javax.swing.JLabel();
        jPanel18 = new javax.swing.JPanel();
        jLabel20 = new javax.swing.JLabel();
        jPanel19 = new javax.swing.JPanel();
        jLabel36 = new javax.swing.JLabel();
        jTabbedPane3 = new javax.swing.JTabbedPane();
        jPanel26 = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jPanel27 = new javax.swing.JPanel();
        jLabel41 = new javax.swing.JLabel();
        jLabel42 = new javax.swing.JLabel();
        jLabel43 = new javax.swing.JLabel();
        jPanel20 = new javax.swing.JPanel();
        jPanel14 = new javax.swing.JPanel();
        jPanel15 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jPanel6 = new javax.swing.JPanel();
        jButton9 = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        arbol3 = new javax.swing.JTree();
        jButton15 = new javax.swing.JButton();
        jScrollPane6 = new javax.swing.JScrollPane();
        arbol2 = new javax.swing.JTree();
        jTabbedPane2 = new javax.swing.JTabbedPane();
        jPanel10 = new javax.swing.JPanel();
        jPanel11 = new javax.swing.JPanel();
        jGraficaModelo = new javax.swing.JPanel();
        jGraficaLineas = new javax.swing.JPanel();
        jScrollPane9 = new javax.swing.JScrollPane();
        jTableModeloGeneral = new javax.swing.JTable();
        jPanel9 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jPanelGrafica02 = new javax.swing.JPanel();
        jPanelGrafica01 = new javax.swing.JPanel();
        jButton8 = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jScrollPane5 = new javax.swing.JScrollPane();
        jTable3 = new javax.swing.JTable();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton7 = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTable4 = new javax.swing.JTable();
        jPanel3 = new javax.swing.JPanel();
        jComboBox2 = new javax.swing.JComboBox();
        jComboBox1 = new javax.swing.JComboBox();
        jTextField1 = new javax.swing.JTextField();
        jButton5 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        jComboBox3 = new javax.swing.JComboBox();
        jLabel1 = new javax.swing.JLabel();
        jPanel31 = new javax.swing.JPanel();
        jTextField2 = new javax.swing.JTextField();
        jButton14 = new javax.swing.JButton();
        jButton10 = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jTextField4 = new javax.swing.JTextField();
        jTextField5 = new javax.swing.JTextField();
        jTextField6 = new javax.swing.JTextField();
        jTextField7 = new javax.swing.JTextField();
        jTextField8 = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        tfGeneracion = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jTextField10 = new javax.swing.JTextField();
        jButton11 = new javax.swing.JButton();
        jButton12 = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();
        jTextField3 = new javax.swing.JTextField();
        jButton13 = new javax.swing.JButton();
        pGrafico02 = new javax.swing.JPanel();
        jPanel8 = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jProgressBar1 = new javax.swing.JProgressBar();
        pGrafico03 = new javax.swing.JPanel();
        pGrafico01 = new javax.swing.JPanel();
        jPanel25 = new javax.swing.JPanel();
        jPanel28 = new javax.swing.JPanel();
        jScrollPane15 = new javax.swing.JScrollPane();
        arbolPrecios = new javax.swing.JTree();
        jPanel29 = new javax.swing.JPanel();
        miBarra13 = new javax.swing.JScrollPane();
        miTabla13 = new javax.swing.JTable();
        jTabbedPane10 = new javax.swing.JTabbedPane();
        jPanel56 = new javax.swing.JPanel();
        jLabel181 = new javax.swing.JLabel();
        jTextField129 = new javax.swing.JTextField();
        jLabel182 = new javax.swing.JLabel();
        jTextField130 = new javax.swing.JTextField();
        jLabel183 = new javax.swing.JLabel();
        jTextField131 = new javax.swing.JTextField();
        jButton22 = new javax.swing.JButton();
        jTextField134 = new javax.swing.JTextField();
        jTextField135 = new javax.swing.JTextField();
        jTextField136 = new javax.swing.JTextField();
        jTextField137 = new javax.swing.JTextField();
        jTextField138 = new javax.swing.JTextField();
        jTextField139 = new javax.swing.JTextField();
        jLabel187 = new javax.swing.JLabel();
        jLabel188 = new javax.swing.JLabel();
        jLabel189 = new javax.swing.JLabel();
        jLabel190 = new javax.swing.JLabel();
        jLabel191 = new javax.swing.JLabel();
        jLabel192 = new javax.swing.JLabel();
        jLabel194 = new javax.swing.JLabel();
        jLabel195 = new javax.swing.JLabel();
        jTextField147 = new javax.swing.JTextField();
        jLabel196 = new javax.swing.JLabel();
        jTextField148 = new javax.swing.JTextField();
        jTextField149 = new javax.swing.JTextField();
        jTextField150 = new javax.swing.JTextField();
        jTextField151 = new javax.swing.JTextField();
        jTextField152 = new javax.swing.JTextField();
        jTextField153 = new javax.swing.JTextField();
        jTextField154 = new javax.swing.JTextField();
        jLabel199 = new javax.swing.JLabel();
        jTextField185 = new javax.swing.JTextField();
        jPanel62 = new javax.swing.JPanel();
        jLabel186 = new javax.swing.JLabel();
        jTextField178 = new javax.swing.JTextField();
        jTextField172 = new javax.swing.JTextField();
        jTextField173 = new javax.swing.JTextField();
        jTextField174 = new javax.swing.JTextField();
        jTextField175 = new javax.swing.JTextField();
        jTextField176 = new javax.swing.JTextField();
        jTextField177 = new javax.swing.JTextField();
        jLabel185 = new javax.swing.JLabel();
        jTextField132 = new javax.swing.JTextField();
        jTextField155 = new javax.swing.JTextField();
        jTextField156 = new javax.swing.JTextField();
        jTextField157 = new javax.swing.JTextField();
        jTextField158 = new javax.swing.JTextField();
        jTextField159 = new javax.swing.JTextField();
        jTextField160 = new javax.swing.JTextField();
        jLabel184 = new javax.swing.JLabel();
        jTextField268 = new javax.swing.JTextField();
        jTextField269 = new javax.swing.JTextField();
        jTextField270 = new javax.swing.JTextField();
        jTextField271 = new javax.swing.JTextField();
        jTextField272 = new javax.swing.JTextField();
        jTextField273 = new javax.swing.JTextField();
        jPanel61 = new javax.swing.JPanel();
        jLabel197 = new javax.swing.JLabel();
        jTextField133 = new javax.swing.JTextField();
        jTextField167 = new javax.swing.JTextField();
        jTextField168 = new javax.swing.JTextField();
        jTextField169 = new javax.swing.JTextField();
        jTextField170 = new javax.swing.JTextField();
        jTextField171 = new javax.swing.JTextField();
        jTextField184 = new javax.swing.JTextField();
        jTextField183 = new javax.swing.JTextField();
        jTextField182 = new javax.swing.JTextField();
        jTextField181 = new javax.swing.JTextField();
        jTextField180 = new javax.swing.JTextField();
        jTextField179 = new javax.swing.JTextField();
        jLabel198 = new javax.swing.JLabel();
        jLabel193 = new javax.swing.JLabel();
        jTextField141 = new javax.swing.JTextField();
        jTextField142 = new javax.swing.JTextField();
        jTextField143 = new javax.swing.JTextField();
        jTextField144 = new javax.swing.JTextField();
        jTextField145 = new javax.swing.JTextField();
        jTextField146 = new javax.swing.JTextField();
        jCheckBox12 = new javax.swing.JCheckBox();
        jPanel59 = new javax.swing.JPanel();
        jPanel63 = new javax.swing.JPanel();
        jLabel203 = new javax.swing.JLabel();
        jLabel204 = new javax.swing.JLabel();
        jTextField161 = new javax.swing.JTextField();
        jLabel205 = new javax.swing.JLabel();
        jTextField162 = new javax.swing.JTextField();
        jLabel206 = new javax.swing.JLabel();
        jTextField186 = new javax.swing.JTextField();
        jPanel64 = new javax.swing.JPanel();
        jLabel207 = new javax.swing.JLabel();
        jLabel208 = new javax.swing.JLabel();
        jLabel209 = new javax.swing.JLabel();
        jTextField140 = new javax.swing.JTextField();
        jTextField163 = new javax.swing.JTextField();
        jTextField164 = new javax.swing.JTextField();
        jLabel210 = new javax.swing.JLabel();
        jLabel211 = new javax.swing.JLabel();
        jLabel212 = new javax.swing.JLabel();
        jTextField165 = new javax.swing.JTextField();
        jTextField166 = new javax.swing.JTextField();
        jTextField187 = new javax.swing.JTextField();
        jTextField188 = new javax.swing.JTextField();
        jTextField189 = new javax.swing.JTextField();
        jTextField190 = new javax.swing.JTextField();
        jPanel65 = new javax.swing.JPanel();
        jLabel213 = new javax.swing.JLabel();
        jLabel214 = new javax.swing.JLabel();
        jLabel215 = new javax.swing.JLabel();
        jTextField191 = new javax.swing.JTextField();
        jTextField192 = new javax.swing.JTextField();
        jTextField193 = new javax.swing.JTextField();
        jTextField194 = new javax.swing.JTextField();
        jTextField195 = new javax.swing.JTextField();
        jTextField196 = new javax.swing.JTextField();
        jTextField197 = new javax.swing.JTextField();
        jTextField198 = new javax.swing.JTextField();
        jTextField274 = new javax.swing.JTextField();
        jTextField275 = new javax.swing.JTextField();
        jLabel219 = new javax.swing.JLabel();
        jTextField208 = new javax.swing.JTextField();
        jTextField209 = new javax.swing.JTextField();
        jTextField210 = new javax.swing.JTextField();
        jTextField276 = new javax.swing.JTextField();
        jCheckBox8 = new javax.swing.JCheckBox();
        jButton24 = new javax.swing.JButton();
        jCheckBox11 = new javax.swing.JCheckBox();
        jPanel66 = new javax.swing.JPanel();
        jLabel216 = new javax.swing.JLabel();
        jLabel217 = new javax.swing.JLabel();
        jLabel218 = new javax.swing.JLabel();
        jTextField199 = new javax.swing.JTextField();
        jTextField200 = new javax.swing.JTextField();
        jTextField201 = new javax.swing.JTextField();
        jTextField202 = new javax.swing.JTextField();
        jTextField203 = new javax.swing.JTextField();
        jTextField204 = new javax.swing.JTextField();
        jTextField205 = new javax.swing.JTextField();
        jTextField206 = new javax.swing.JTextField();
        jTextField207 = new javax.swing.JTextField();
        jPanel67 = new javax.swing.JPanel();
        jPanel68 = new javax.swing.JPanel();
        jLabel221 = new javax.swing.JLabel();
        jLabel222 = new javax.swing.JLabel();
        jTextField211 = new javax.swing.JTextField();
        jLabel223 = new javax.swing.JLabel();
        jTextField212 = new javax.swing.JTextField();
        jLabel224 = new javax.swing.JLabel();
        jTextField213 = new javax.swing.JTextField();
        jPanel69 = new javax.swing.JPanel();
        jLabel225 = new javax.swing.JLabel();
        jLabel226 = new javax.swing.JLabel();
        jLabel227 = new javax.swing.JLabel();
        jTextField214 = new javax.swing.JTextField();
        jTextField215 = new javax.swing.JTextField();
        jTextField216 = new javax.swing.JTextField();
        jLabel228 = new javax.swing.JLabel();
        jLabel229 = new javax.swing.JLabel();
        jLabel230 = new javax.swing.JLabel();
        jTextField217 = new javax.swing.JTextField();
        jTextField218 = new javax.swing.JTextField();
        jTextField219 = new javax.swing.JTextField();
        jTextField220 = new javax.swing.JTextField();
        jTextField221 = new javax.swing.JTextField();
        jTextField222 = new javax.swing.JTextField();
        jButton25 = new javax.swing.JButton();
        jCheckBox10 = new javax.swing.JCheckBox();
        jPanel70 = new javax.swing.JPanel();
        jLabel231 = new javax.swing.JLabel();
        jLabel232 = new javax.swing.JLabel();
        jLabel233 = new javax.swing.JLabel();
        jTextField223 = new javax.swing.JTextField();
        jTextField224 = new javax.swing.JTextField();
        jTextField225 = new javax.swing.JTextField();
        jTextField226 = new javax.swing.JTextField();
        jTextField227 = new javax.swing.JTextField();
        jTextField228 = new javax.swing.JTextField();
        jTextField229 = new javax.swing.JTextField();
        jTextField230 = new javax.swing.JTextField();
        jLabel234 = new javax.swing.JLabel();
        jTextField231 = new javax.swing.JTextField();
        jTextField232 = new javax.swing.JTextField();
        jTextField233 = new javax.swing.JTextField();
        jTextField277 = new javax.swing.JTextField();
        jTextField278 = new javax.swing.JTextField();
        jTextField279 = new javax.swing.JTextField();
        jCheckBox9 = new javax.swing.JCheckBox();
        jPanel71 = new javax.swing.JPanel();
        jLabel235 = new javax.swing.JLabel();
        jLabel236 = new javax.swing.JLabel();
        jLabel237 = new javax.swing.JLabel();
        jTextField234 = new javax.swing.JTextField();
        jTextField235 = new javax.swing.JTextField();
        jTextField236 = new javax.swing.JTextField();
        jTextField237 = new javax.swing.JTextField();
        jTextField238 = new javax.swing.JTextField();
        jTextField239 = new javax.swing.JTextField();
        jTextField240 = new javax.swing.JTextField();
        jTextField241 = new javax.swing.JTextField();
        jTextField242 = new javax.swing.JTextField();
        jPanel30 = new javax.swing.JPanel();
        jTabbedPane9 = new javax.swing.JTabbedPane();
        miBarra14 = new javax.swing.JScrollPane();
        miTabla14 = new javax.swing.JTable();
        jPanel57 = new javax.swing.JPanel();
        miBarra15 = new javax.swing.JScrollPane();
        miTabla16 = new javax.swing.JTable();
        jPanel58 = new javax.swing.JPanel();
        miBarra16 = new javax.swing.JScrollPane();
        miTabla15 = new javax.swing.JTable();
        jPanel60 = new javax.swing.JPanel();
        jComboBox9 = new javax.swing.JComboBox();
        jLabel201 = new javax.swing.JLabel();
        jLabel202 = new javax.swing.JLabel();
        jLabel200 = new javax.swing.JLabel();
        jLabel220 = new javax.swing.JLabel();
        jPanel7 = new javax.swing.JPanel();
        jScrollPane8 = new javax.swing.JScrollPane();
        jScrollPane7 = new javax.swing.JScrollPane();
        jTextAreaArchivo = new javax.swing.JTextArea();
        jPanel2 = new javax.swing.JPanel();

        jPanel12.setBackground(new java.awt.Color(204, 255, 255));

        jPanel13.setBackground(new java.awt.Color(255, 255, 255));

        jPanel16.setBackground(new java.awt.Color(255, 255, 255));
        jPanel16.setPreferredSize(new java.awt.Dimension(1400, 120));

        org.openide.awt.Mnemonics.setLocalizedText(jLabel18, org.openide.util.NbBundle.getMessage(modeloTopComponent.class, "modeloTopComponent.jLabel18.text")); // NOI18N

        org.openide.awt.Mnemonics.setLocalizedText(jLabel19, org.openide.util.NbBundle.getMessage(modeloTopComponent.class, "modeloTopComponent.jLabel19.text")); // NOI18N

        jTextField18.setText(org.openide.util.NbBundle.getMessage(modeloTopComponent.class, "modeloTopComponent.jTextField18.text")); // NOI18N
        jTextField18.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField18ActionPerformed(evt);
            }
        });

        jTextField19.setText(org.openide.util.NbBundle.getMessage(modeloTopComponent.class, "modeloTopComponent.jTextField19.text")); // NOI18N

        org.openide.awt.Mnemonics.setLocalizedText(jLabel21, org.openide.util.NbBundle.getMessage(modeloTopComponent.class, "modeloTopComponent.jLabel21.text")); // NOI18N

        jTextField20.setText(org.openide.util.NbBundle.getMessage(modeloTopComponent.class, "modeloTopComponent.jTextField20.text")); // NOI18N

        org.openide.awt.Mnemonics.setLocalizedText(jLabel33, org.openide.util.NbBundle.getMessage(modeloTopComponent.class, "modeloTopComponent.jLabel33.text")); // NOI18N

        jTextField31.setText(org.openide.util.NbBundle.getMessage(modeloTopComponent.class, "modeloTopComponent.jTextField31.text")); // NOI18N

        org.openide.awt.Mnemonics.setLocalizedText(jButton20, org.openide.util.NbBundle.getMessage(modeloTopComponent.class, "modeloTopComponent.jButton20.text")); // NOI18N
        jButton20.setPreferredSize(new java.awt.Dimension(89, 16));

        org.openide.awt.Mnemonics.setLocalizedText(jButton21, org.openide.util.NbBundle.getMessage(modeloTopComponent.class, "modeloTopComponent.jButton21.text")); // NOI18N

        jLabel37.setBackground(new java.awt.Color(153, 153, 255));
        jLabel37.setIcon(new javax.swing.ImageIcon(getClass().getResource("/org/myorg/AcMod03/foto01.png"))); // NOI18N
        org.openide.awt.Mnemonics.setLocalizedText(jLabel37, org.openide.util.NbBundle.getMessage(modeloTopComponent.class, "modeloTopComponent.jLabel37.text")); // NOI18N

        javax.swing.GroupLayout jPanel16Layout = new javax.swing.GroupLayout(jPanel16);
        jPanel16.setLayout(jPanel16Layout);
        jPanel16Layout.setHorizontalGroup(
            jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel16Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(jLabel19, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel21, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(jLabel33)
                    .addComponent(jLabel18))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTextField18, javax.swing.GroupLayout.PREFERRED_SIZE, 1, Short.MAX_VALUE)
                    .addComponent(jTextField20)
                    .addComponent(jTextField19)
                    .addComponent(jTextField31, javax.swing.GroupLayout.DEFAULT_SIZE, 172, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton20, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton21, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(70, 70, 70)
                .addComponent(jLabel37, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(100, 100, 100))
        );
        jPanel16Layout.setVerticalGroup(
            jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel16Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel18)
                    .addComponent(jTextField18, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton20, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(2, 2, 2)
                .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField19, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton21, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel33)
                    .addComponent(jTextField31, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel21)
                    .addComponent(jTextField20, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
            .addComponent(jLabel37, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jPanel24.setBackground(new java.awt.Color(255, 255, 255));

        org.openide.awt.Mnemonics.setLocalizedText(jLabel13, org.openide.util.NbBundle.getMessage(modeloTopComponent.class, "modeloTopComponent.jLabel13.text")); // NOI18N

        org.openide.awt.Mnemonics.setLocalizedText(jLabel14, org.openide.util.NbBundle.getMessage(modeloTopComponent.class, "modeloTopComponent.jLabel14.text")); // NOI18N

        org.openide.awt.Mnemonics.setLocalizedText(jLabel15, org.openide.util.NbBundle.getMessage(modeloTopComponent.class, "modeloTopComponent.jLabel15.text")); // NOI18N

        jComboBox7.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "ACTUALIDAD", "2015", "2014", "2013" }));

        jTextField9.setText(org.openide.util.NbBundle.getMessage(modeloTopComponent.class, "modeloTopComponent.jTextField9.text")); // NOI18N

        jTextField11.setText(org.openide.util.NbBundle.getMessage(modeloTopComponent.class, "modeloTopComponent.jTextField11.text")); // NOI18N

        jTextField12.setText(org.openide.util.NbBundle.getMessage(modeloTopComponent.class, "modeloTopComponent.jTextField12.text")); // NOI18N

        org.openide.awt.Mnemonics.setLocalizedText(jLabel16, org.openide.util.NbBundle.getMessage(modeloTopComponent.class, "modeloTopComponent.jLabel16.text")); // NOI18N

        org.openide.awt.Mnemonics.setLocalizedText(jLabel17, org.openide.util.NbBundle.getMessage(modeloTopComponent.class, "modeloTopComponent.jLabel17.text")); // NOI18N

        org.openide.awt.Mnemonics.setLocalizedText(jLabel38, org.openide.util.NbBundle.getMessage(modeloTopComponent.class, "modeloTopComponent.jLabel38.text")); // NOI18N

        jLabel40.setIcon(new javax.swing.ImageIcon(getClass().getResource("/org/myorg/AcMod03/grafico09.png"))); // NOI18N
        org.openide.awt.Mnemonics.setLocalizedText(jLabel40, org.openide.util.NbBundle.getMessage(modeloTopComponent.class, "modeloTopComponent.jLabel40.text")); // NOI18N

        javax.swing.GroupLayout jPanel24Layout = new javax.swing.GroupLayout(jPanel24);
        jPanel24.setLayout(jPanel24Layout);
        jPanel24Layout.setHorizontalGroup(
            jPanel24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel24Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel24Layout.createSequentialGroup()
                        .addGroup(jPanel24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jLabel14, javax.swing.GroupLayout.DEFAULT_SIZE, 178, Short.MAX_VALUE)
                            .addComponent(jComboBox7, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel13, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel15, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jTextField9)
                            .addComponent(jTextField11)
                            .addComponent(jTextField12, javax.swing.GroupLayout.DEFAULT_SIZE, 90, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel16)
                            .addComponent(jLabel17)
                            .addComponent(jLabel38)))
                    .addComponent(jLabel40))
                .addContainerGap(229, Short.MAX_VALUE))
        );
        jPanel24Layout.setVerticalGroup(
            jPanel24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel24Layout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addComponent(jComboBox7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel13)
                    .addComponent(jTextField9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel16))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel17))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel15)
                    .addComponent(jTextField12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel38))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel40)
                .addContainerGap(19, Short.MAX_VALUE))
        );

        jTabbedPane11.addTab(org.openide.util.NbBundle.getMessage(modeloTopComponent.class, "modeloTopComponent.jPanel24.TabConstraints.tabTitle"), jPanel24); // NOI18N

        jTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane14.setViewportView(jTable2);

        javax.swing.GroupLayout jPanel21Layout = new javax.swing.GroupLayout(jPanel21);
        jPanel21.setLayout(jPanel21Layout);
        jPanel21Layout.setHorizontalGroup(
            jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane14, javax.swing.GroupLayout.DEFAULT_SIZE, 721, Short.MAX_VALUE)
        );
        jPanel21Layout.setVerticalGroup(
            jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane14, javax.swing.GroupLayout.DEFAULT_SIZE, 279, Short.MAX_VALUE)
        );

        jTabbedPane11.addTab(org.openide.util.NbBundle.getMessage(modeloTopComponent.class, "modeloTopComponent.jPanel21.TabConstraints.tabTitle"), jPanel21); // NOI18N

        PCContrato.setBackground(new java.awt.Color(255, 255, 255));

        jLabel22.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        org.openide.awt.Mnemonics.setLocalizedText(jLabel22, org.openide.util.NbBundle.getMessage(modeloTopComponent.class, "modeloTopComponent.jLabel22.text")); // NOI18N

        org.openide.awt.Mnemonics.setLocalizedText(jLabel23, org.openide.util.NbBundle.getMessage(modeloTopComponent.class, "modeloTopComponent.jLabel23.text")); // NOI18N

        org.openide.awt.Mnemonics.setLocalizedText(jLabel24, org.openide.util.NbBundle.getMessage(modeloTopComponent.class, "modeloTopComponent.jLabel24.text")); // NOI18N

        jTextField23.setBackground(new java.awt.Color(204, 255, 204));
        jTextField23.setText(org.openide.util.NbBundle.getMessage(modeloTopComponent.class, "modeloTopComponent.jTextField23.text")); // NOI18N
        jTextField23.addInputMethodListener(new java.awt.event.InputMethodListener() {
            public void caretPositionChanged(java.awt.event.InputMethodEvent evt) {
            }
            public void inputMethodTextChanged(java.awt.event.InputMethodEvent evt) {
                jTextField23InputMethodTextChanged(evt);
            }
        });
        jTextField23.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextField23KeyTyped(evt);
            }
        });

        org.openide.awt.Mnemonics.setLocalizedText(jLabel25, org.openide.util.NbBundle.getMessage(modeloTopComponent.class, "modeloTopComponent.jLabel25.text")); // NOI18N

        jTextField24.setBackground(new java.awt.Color(204, 255, 204));
        jTextField24.setText(org.openide.util.NbBundle.getMessage(modeloTopComponent.class, "modeloTopComponent.jTextField24.text")); // NOI18N
        jTextField24.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextField24KeyTyped(evt);
            }
        });

        org.openide.awt.Mnemonics.setLocalizedText(jLabel26, org.openide.util.NbBundle.getMessage(modeloTopComponent.class, "modeloTopComponent.jLabel26.text")); // NOI18N

        jTextField25.setBackground(new java.awt.Color(204, 255, 204));
        jTextField25.setText(org.openide.util.NbBundle.getMessage(modeloTopComponent.class, "modeloTopComponent.jTextField25.text")); // NOI18N
        jTextField25.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField25ActionPerformed(evt);
            }
        });
        jTextField25.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextField25KeyTyped(evt);
            }
        });

        org.openide.awt.Mnemonics.setLocalizedText(jLabel27, org.openide.util.NbBundle.getMessage(modeloTopComponent.class, "modeloTopComponent.jLabel27.text")); // NOI18N

        org.openide.awt.Mnemonics.setLocalizedText(jLabel28, org.openide.util.NbBundle.getMessage(modeloTopComponent.class, "modeloTopComponent.jLabel28.text")); // NOI18N

        org.openide.awt.Mnemonics.setLocalizedText(jLabel29, org.openide.util.NbBundle.getMessage(modeloTopComponent.class, "modeloTopComponent.jLabel29.text")); // NOI18N

        jTextField26.setBackground(new java.awt.Color(204, 255, 204));
        jTextField26.setText(org.openide.util.NbBundle.getMessage(modeloTopComponent.class, "modeloTopComponent.jTextField26.text")); // NOI18N
        jTextField26.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextField26KeyTyped(evt);
            }
        });

        jTextField27.setBackground(new java.awt.Color(204, 255, 204));
        jTextField27.setText(org.openide.util.NbBundle.getMessage(modeloTopComponent.class, "modeloTopComponent.jTextField27.text")); // NOI18N
        jTextField27.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextField27KeyTyped(evt);
            }
        });

        jTextField28.setBackground(new java.awt.Color(204, 255, 204));
        jTextField28.setText(org.openide.util.NbBundle.getMessage(modeloTopComponent.class, "modeloTopComponent.jTextField28.text")); // NOI18N
        jTextField28.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField28ActionPerformed(evt);
            }
        });
        jTextField28.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextField28KeyTyped(evt);
            }
        });

        org.openide.awt.Mnemonics.setLocalizedText(jLabel30, org.openide.util.NbBundle.getMessage(modeloTopComponent.class, "modeloTopComponent.jLabel30.text")); // NOI18N

        org.openide.awt.Mnemonics.setLocalizedText(jLabel31, org.openide.util.NbBundle.getMessage(modeloTopComponent.class, "modeloTopComponent.jLabel31.text")); // NOI18N

        org.openide.awt.Mnemonics.setLocalizedText(jLabel32, org.openide.util.NbBundle.getMessage(modeloTopComponent.class, "modeloTopComponent.jLabel32.text")); // NOI18N

        org.openide.awt.Mnemonics.setLocalizedText(jLabel34, org.openide.util.NbBundle.getMessage(modeloTopComponent.class, "modeloTopComponent.jLabel34.text")); // NOI18N

        jTextField29.setBackground(new java.awt.Color(204, 255, 204));
        jTextField29.setText(org.openide.util.NbBundle.getMessage(modeloTopComponent.class, "modeloTopComponent.jTextField29.text")); // NOI18N
        jTextField29.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextField29KeyTyped(evt);
            }
        });

        org.openide.awt.Mnemonics.setLocalizedText(jLabel35, org.openide.util.NbBundle.getMessage(modeloTopComponent.class, "modeloTopComponent.jLabel35.text")); // NOI18N

        org.openide.awt.Mnemonics.setLocalizedText(jLabel48, org.openide.util.NbBundle.getMessage(modeloTopComponent.class, "modeloTopComponent.jLabel48.text")); // NOI18N

        org.openide.awt.Mnemonics.setLocalizedText(jLabel54, org.openide.util.NbBundle.getMessage(modeloTopComponent.class, "modeloTopComponent.jLabel54.text")); // NOI18N

        jLabel56.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        org.openide.awt.Mnemonics.setLocalizedText(jLabel56, org.openide.util.NbBundle.getMessage(modeloTopComponent.class, "modeloTopComponent.jLabel56.text")); // NOI18N

        jLabel57.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        org.openide.awt.Mnemonics.setLocalizedText(jLabel57, org.openide.util.NbBundle.getMessage(modeloTopComponent.class, "modeloTopComponent.jLabel57.text")); // NOI18N

        jTextField35.setBackground(new java.awt.Color(204, 255, 204));
        jTextField35.setText(org.openide.util.NbBundle.getMessage(modeloTopComponent.class, "modeloTopComponent.jTextField35.text")); // NOI18N
        jTextField35.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextField35KeyTyped(evt);
            }
        });

        org.openide.awt.Mnemonics.setLocalizedText(jLabel58, org.openide.util.NbBundle.getMessage(modeloTopComponent.class, "modeloTopComponent.jLabel58.text")); // NOI18N

        jLabel59.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        org.openide.awt.Mnemonics.setLocalizedText(jLabel59, org.openide.util.NbBundle.getMessage(modeloTopComponent.class, "modeloTopComponent.jLabel59.text")); // NOI18N

        jTextField36.setBackground(new java.awt.Color(204, 255, 204));
        jTextField36.setText(org.openide.util.NbBundle.getMessage(modeloTopComponent.class, "modeloTopComponent.jTextField36.text")); // NOI18N
        jTextField36.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextField36KeyTyped(evt);
            }
        });

        org.openide.awt.Mnemonics.setLocalizedText(jLabel60, org.openide.util.NbBundle.getMessage(modeloTopComponent.class, "modeloTopComponent.jLabel60.text")); // NOI18N

        jTextArea5.setBackground(new java.awt.Color(255, 255, 204));
        jTextArea5.setColumns(20);
        jTextArea5.setRows(5);
        jScrollPane13.setViewportView(jTextArea5);

        org.openide.awt.Mnemonics.setLocalizedText(botonValidarCAct, org.openide.util.NbBundle.getMessage(modeloTopComponent.class, "modeloTopComponent.botonValidarCAct.text")); // NOI18N
        botonValidarCAct.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonValidarCActActionPerformed(evt);
            }
        });

        jComboBox4.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Seleccionar....", "TARIFA 2.0 A", "TARIFA 2.0 ADH", "TARIFA 2.1 A", "TARIFA 2.1 ADH", "TARIFA 3.0 A", "TARIFA 3.1 A", "TARIFA 6.1 A", "TARIFA 2.0 DHA INDX", "TARIFA 2.1 DHA INDX", "TARIFA 3.0 A INDX", "TARIFA 2.0  INDX", "TARIFA 2.1  INDX", "TARIFA 3.1 A INDX", "TARIFA 6.1 A INDX" }));
        jComboBox4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jComboBox4MouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jComboBox4MousePressed(evt);
            }
        });
        jComboBox4.addPopupMenuListener(new javax.swing.event.PopupMenuListener() {
            public void popupMenuCanceled(javax.swing.event.PopupMenuEvent evt) {
            }
            public void popupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {
            }
            public void popupMenuWillBecomeVisible(javax.swing.event.PopupMenuEvent evt) {
                jComboBox4PopupMenuWillBecomeVisible(evt);
            }
        });
        jComboBox4.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jComboBox4ItemStateChanged(evt);
            }
        });
        jComboBox4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox4ActionPerformed(evt);
            }
        });
        jComboBox4.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jComboBox4FocusGained(evt);
            }
        });
        jComboBox4.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                jComboBox4PropertyChange(evt);
            }
        });
        jComboBox4.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jComboBox4KeyTyped(evt);
            }
        });

        org.openide.awt.Mnemonics.setLocalizedText(jLabel96, org.openide.util.NbBundle.getMessage(modeloTopComponent.class, "modeloTopComponent.jLabel96.text")); // NOI18N

        jTextField73.setBackground(new java.awt.Color(204, 255, 204));
        jTextField73.setText(org.openide.util.NbBundle.getMessage(modeloTopComponent.class, "modeloTopComponent.jTextField73.text")); // NOI18N

        org.openide.awt.Mnemonics.setLocalizedText(jLabel97, org.openide.util.NbBundle.getMessage(modeloTopComponent.class, "modeloTopComponent.jLabel97.text")); // NOI18N

        org.openide.awt.Mnemonics.setLocalizedText(jLabel149, org.openide.util.NbBundle.getMessage(modeloTopComponent.class, "modeloTopComponent.jLabel149.text")); // NOI18N

        jTextField111.setText(org.openide.util.NbBundle.getMessage(modeloTopComponent.class, "modeloTopComponent.jTextField111.text")); // NOI18N

        org.openide.awt.Mnemonics.setLocalizedText(jLabel152, org.openide.util.NbBundle.getMessage(modeloTopComponent.class, "modeloTopComponent.jLabel152.text")); // NOI18N

        org.openide.awt.Mnemonics.setLocalizedText(jCheckBox5, org.openide.util.NbBundle.getMessage(modeloTopComponent.class, "modeloTopComponent.jCheckBox5.text")); // NOI18N

        jComboBox5.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "ACTUALES", "2015", "2014", "2013" }));

        javax.swing.GroupLayout PCContratoLayout = new javax.swing.GroupLayout(PCContrato);
        PCContrato.setLayout(PCContratoLayout);
        PCContratoLayout.setHorizontalGroup(
            PCContratoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PCContratoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(PCContratoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane13, javax.swing.GroupLayout.PREFERRED_SIZE, 480, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(PCContratoLayout.createSequentialGroup()
                        .addGroup(PCContratoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(PCContratoLayout.createSequentialGroup()
                                .addComponent(jLabel34)
                                .addGap(24, 24, 24)
                                .addComponent(jLabel56)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jTextField29, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel35)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel57)
                                .addGap(6, 6, 6)
                                .addComponent(jTextField35, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel58))
                            .addGroup(PCContratoLayout.createSequentialGroup()
                                .addComponent(jLabel96)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jTextField73, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel97)
                                .addGap(48, 48, 48)
                                .addComponent(jLabel149)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(PCContratoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(PCContratoLayout.createSequentialGroup()
                                .addComponent(jTextField111, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel152))
                            .addGroup(PCContratoLayout.createSequentialGroup()
                                .addComponent(jLabel59)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jTextField36, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel60)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jCheckBox5))))
                    .addGroup(PCContratoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(PCContratoLayout.createSequentialGroup()
                            .addComponent(jLabel54, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(jTextField33, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jComboBox4, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, PCContratoLayout.createSequentialGroup()
                            .addGroup(PCContratoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, PCContratoLayout.createSequentialGroup()
                                    .addComponent(jLabel26, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(jTextField25, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(18, 18, 18)
                                    .addComponent(jLabel29)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jTextField28, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, PCContratoLayout.createSequentialGroup()
                                    .addComponent(jLabel25, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(jTextField24, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(18, 18, 18)
                                    .addComponent(jLabel28)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jTextField27, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, PCContratoLayout.createSequentialGroup()
                                    .addComponent(jLabel24, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(jTextField23, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(18, 18, 18)
                                    .addComponent(jLabel27)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jTextField26, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, PCContratoLayout.createSequentialGroup()
                                    .addComponent(jLabel23)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(jTextField22, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(18, 18, 18)
                                    .addComponent(jLabel48, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(18, 18, 18)
                                    .addComponent(jTextField30, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addGroup(PCContratoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel31)
                                .addComponent(jLabel30)
                                .addComponent(jLabel32)))
                        .addGroup(PCContratoLayout.createSequentialGroup()
                            .addComponent(jLabel22)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jComboBox5, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(botonValidarCAct))))
                .addContainerGap(47, Short.MAX_VALUE))
        );
        PCContratoLayout.setVerticalGroup(
            PCContratoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PCContratoLayout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addGroup(PCContratoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel22)
                    .addComponent(botonValidarCAct)
                    .addComponent(jComboBox5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(4, 4, 4)
                .addGroup(PCContratoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel54)
                    .addComponent(jTextField33, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jComboBox4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(PCContratoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel23)
                    .addComponent(jTextField22, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel48)
                    .addComponent(jTextField30, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(PCContratoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel24)
                    .addComponent(jTextField23, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel27)
                    .addComponent(jTextField26, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel30))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(PCContratoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel25)
                    .addComponent(jTextField24, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel28)
                    .addComponent(jTextField27, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel31))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(PCContratoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel26)
                    .addComponent(jTextField25, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel29)
                    .addComponent(jTextField28, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel32))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(PCContratoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel34)
                    .addComponent(jTextField29, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel35)
                    .addComponent(jLabel56)
                    .addComponent(jLabel57)
                    .addComponent(jTextField35, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel58)
                    .addComponent(jLabel59)
                    .addComponent(jTextField36, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel60)
                    .addComponent(jCheckBox5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(PCContratoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel96)
                    .addComponent(jTextField73, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel97)
                    .addComponent(jLabel149)
                    .addComponent(jTextField111, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel152))
                .addGap(6, 6, 6)
                .addComponent(jScrollPane13, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(23, 23, 23))
        );

        jTabbedPane11.addTab(org.openide.util.NbBundle.getMessage(modeloTopComponent.class, "modeloTopComponent.PCContrato.TabConstraints.tabTitle"), PCContrato); // NOI18N

        jLabel238.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        org.openide.awt.Mnemonics.setLocalizedText(jLabel238, org.openide.util.NbBundle.getMessage(modeloTopComponent.class, "modeloTopComponent.jLabel238.text")); // NOI18N

        org.openide.awt.Mnemonics.setLocalizedText(botonValidarCAct1, org.openide.util.NbBundle.getMessage(modeloTopComponent.class, "modeloTopComponent.botonValidarCAct1.text")); // NOI18N
        botonValidarCAct1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonValidarCAct1ActionPerformed(evt);
            }
        });

        jComboBox11.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        jComboBox11.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Seleccionar....", "TARIFA 2.0 A", "TARIFA 2.0 ADH", "TARIFA 2.1 A", "TARIFA 2.1 ADH", "TARIFA 3.0 A", "TARIFA 3.1 A", "TARIFA 6.1 A", "TARIFA 2.0 DHA INDX", "TARIFA 2.1 DHA INDX", "TARIFA 3.0 A INDX", "TARIFA 2.0  INDX", "TARIFA 2.1  INDX", "TARIFA 3.1 A INDX", "TARIFA 6.1 A INDX" }));
        jComboBox11.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jComboBox11MouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jComboBox11MousePressed(evt);
            }
        });
        jComboBox11.addPopupMenuListener(new javax.swing.event.PopupMenuListener() {
            public void popupMenuCanceled(javax.swing.event.PopupMenuEvent evt) {
            }
            public void popupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {
            }
            public void popupMenuWillBecomeVisible(javax.swing.event.PopupMenuEvent evt) {
                jComboBox11PopupMenuWillBecomeVisible(evt);
            }
        });
        jComboBox11.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jComboBox11ItemStateChanged(evt);
            }
        });
        jComboBox11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox11ActionPerformed(evt);
            }
        });
        jComboBox11.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jComboBox11FocusGained(evt);
            }
        });
        jComboBox11.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                jComboBox11PropertyChange(evt);
            }
        });
        jComboBox11.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jComboBox11KeyTyped(evt);
            }
        });

        jTextField243.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N

        jLabel239.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        org.openide.awt.Mnemonics.setLocalizedText(jLabel239, org.openide.util.NbBundle.getMessage(modeloTopComponent.class, "modeloTopComponent.jLabel239.text")); // NOI18N

        jLabel240.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        org.openide.awt.Mnemonics.setLocalizedText(jLabel240, org.openide.util.NbBundle.getMessage(modeloTopComponent.class, "modeloTopComponent.jLabel240.text")); // NOI18N

        jTextField244.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N

        jLabel241.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        org.openide.awt.Mnemonics.setLocalizedText(jLabel241, org.openide.util.NbBundle.getMessage(modeloTopComponent.class, "modeloTopComponent.jLabel241.text")); // NOI18N

        jTextField245.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N

        jLabel242.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        org.openide.awt.Mnemonics.setLocalizedText(jLabel242, org.openide.util.NbBundle.getMessage(modeloTopComponent.class, "modeloTopComponent.jLabel242.text")); // NOI18N

        jTextField246.setBackground(new java.awt.Color(204, 255, 204));
        jTextField246.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        jTextField246.setText(org.openide.util.NbBundle.getMessage(modeloTopComponent.class, "modeloTopComponent.jTextField246.text")); // NOI18N
        jTextField246.addInputMethodListener(new java.awt.event.InputMethodListener() {
            public void caretPositionChanged(java.awt.event.InputMethodEvent evt) {
            }
            public void inputMethodTextChanged(java.awt.event.InputMethodEvent evt) {
                jTextField246InputMethodTextChanged(evt);
            }
        });
        jTextField246.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextField246KeyTyped(evt);
            }
        });

        jTextField247.setBackground(new java.awt.Color(204, 255, 204));
        jTextField247.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        jTextField247.setText(org.openide.util.NbBundle.getMessage(modeloTopComponent.class, "modeloTopComponent.jTextField247.text")); // NOI18N
        jTextField247.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextField247KeyTyped(evt);
            }
        });

        jLabel244.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N
        org.openide.awt.Mnemonics.setLocalizedText(jLabel244, org.openide.util.NbBundle.getMessage(modeloTopComponent.class, "modeloTopComponent.jLabel244.text")); // NOI18N

        jTextField248.setBackground(new java.awt.Color(204, 255, 204));
        jTextField248.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        jTextField248.setText(org.openide.util.NbBundle.getMessage(modeloTopComponent.class, "modeloTopComponent.jTextField248.text")); // NOI18N
        jTextField248.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField248ActionPerformed(evt);
            }
        });
        jTextField248.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextField248KeyTyped(evt);
            }
        });

        jLabel245.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        org.openide.awt.Mnemonics.setLocalizedText(jLabel245, org.openide.util.NbBundle.getMessage(modeloTopComponent.class, "modeloTopComponent.jLabel245.text")); // NOI18N

        jTextField249.setBackground(new java.awt.Color(204, 255, 204));
        jTextField249.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        jTextField249.setText(org.openide.util.NbBundle.getMessage(modeloTopComponent.class, "modeloTopComponent.jTextField249.text")); // NOI18N
        jTextField249.addInputMethodListener(new java.awt.event.InputMethodListener() {
            public void caretPositionChanged(java.awt.event.InputMethodEvent evt) {
            }
            public void inputMethodTextChanged(java.awt.event.InputMethodEvent evt) {
                jTextField249InputMethodTextChanged(evt);
            }
        });
        jTextField249.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextField249KeyTyped(evt);
            }
        });

        jTextField250.setBackground(new java.awt.Color(204, 255, 204));
        jTextField250.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        jTextField250.setText(org.openide.util.NbBundle.getMessage(modeloTopComponent.class, "modeloTopComponent.jTextField250.text")); // NOI18N
        jTextField250.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextField250KeyTyped(evt);
            }
        });

        jTextField251.setBackground(new java.awt.Color(204, 255, 204));
        jTextField251.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        jTextField251.setText(org.openide.util.NbBundle.getMessage(modeloTopComponent.class, "modeloTopComponent.jTextField251.text")); // NOI18N
        jTextField251.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField251ActionPerformed(evt);
            }
        });
        jTextField251.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextField251KeyTyped(evt);
            }
        });

        org.openide.awt.Mnemonics.setLocalizedText(jLabel248, org.openide.util.NbBundle.getMessage(modeloTopComponent.class, "modeloTopComponent.jLabel248.text")); // NOI18N

        org.openide.awt.Mnemonics.setLocalizedText(jLabel249, org.openide.util.NbBundle.getMessage(modeloTopComponent.class, "modeloTopComponent.jLabel249.text")); // NOI18N

        org.openide.awt.Mnemonics.setLocalizedText(jLabel250, org.openide.util.NbBundle.getMessage(modeloTopComponent.class, "modeloTopComponent.jLabel250.text")); // NOI18N

        org.openide.awt.Mnemonics.setLocalizedText(jLabel251, org.openide.util.NbBundle.getMessage(modeloTopComponent.class, "modeloTopComponent.jLabel251.text")); // NOI18N

        org.openide.awt.Mnemonics.setLocalizedText(jLabel252, org.openide.util.NbBundle.getMessage(modeloTopComponent.class, "modeloTopComponent.jLabel252.text")); // NOI18N

        org.openide.awt.Mnemonics.setLocalizedText(jLabel253, org.openide.util.NbBundle.getMessage(modeloTopComponent.class, "modeloTopComponent.jLabel253.text")); // NOI18N

        jTextField252.setBackground(new java.awt.Color(204, 255, 204));
        jTextField252.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        jTextField252.setText(org.openide.util.NbBundle.getMessage(modeloTopComponent.class, "modeloTopComponent.jTextField252.text")); // NOI18N
        jTextField252.addInputMethodListener(new java.awt.event.InputMethodListener() {
            public void caretPositionChanged(java.awt.event.InputMethodEvent evt) {
            }
            public void inputMethodTextChanged(java.awt.event.InputMethodEvent evt) {
                jTextField252InputMethodTextChanged(evt);
            }
        });
        jTextField252.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextField252KeyTyped(evt);
            }
        });

        jTextField253.setBackground(new java.awt.Color(204, 255, 204));
        jTextField253.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        jTextField253.setText(org.openide.util.NbBundle.getMessage(modeloTopComponent.class, "modeloTopComponent.jTextField253.text")); // NOI18N
        jTextField253.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextField253KeyTyped(evt);
            }
        });

        jTextField254.setBackground(new java.awt.Color(204, 255, 204));
        jTextField254.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        jTextField254.setText(org.openide.util.NbBundle.getMessage(modeloTopComponent.class, "modeloTopComponent.jTextField254.text")); // NOI18N
        jTextField254.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField254ActionPerformed(evt);
            }
        });
        jTextField254.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextField254KeyTyped(evt);
            }
        });

        jTextField255.setBackground(new java.awt.Color(204, 255, 204));
        jTextField255.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        jTextField255.setText(org.openide.util.NbBundle.getMessage(modeloTopComponent.class, "modeloTopComponent.jTextField255.text")); // NOI18N
        jTextField255.addInputMethodListener(new java.awt.event.InputMethodListener() {
            public void caretPositionChanged(java.awt.event.InputMethodEvent evt) {
            }
            public void inputMethodTextChanged(java.awt.event.InputMethodEvent evt) {
                jTextField255InputMethodTextChanged(evt);
            }
        });
        jTextField255.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextField255KeyTyped(evt);
            }
        });

        jTextField256.setBackground(new java.awt.Color(204, 255, 204));
        jTextField256.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        jTextField256.setText(org.openide.util.NbBundle.getMessage(modeloTopComponent.class, "modeloTopComponent.jTextField256.text")); // NOI18N
        jTextField256.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextField256KeyTyped(evt);
            }
        });

        jTextField257.setBackground(new java.awt.Color(204, 255, 204));
        jTextField257.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        jTextField257.setText(org.openide.util.NbBundle.getMessage(modeloTopComponent.class, "modeloTopComponent.jTextField257.text")); // NOI18N
        jTextField257.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField257ActionPerformed(evt);
            }
        });
        jTextField257.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextField257KeyTyped(evt);
            }
        });

        jTextField258.setBackground(new java.awt.Color(204, 255, 204));
        jTextField258.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        jTextField258.setText(org.openide.util.NbBundle.getMessage(modeloTopComponent.class, "modeloTopComponent.jTextField258.text")); // NOI18N
        jTextField258.addInputMethodListener(new java.awt.event.InputMethodListener() {
            public void caretPositionChanged(java.awt.event.InputMethodEvent evt) {
            }
            public void inputMethodTextChanged(java.awt.event.InputMethodEvent evt) {
                jTextField258InputMethodTextChanged(evt);
            }
        });
        jTextField258.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextField258KeyTyped(evt);
            }
        });

        jTextField259.setBackground(new java.awt.Color(204, 255, 204));
        jTextField259.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        jTextField259.setText(org.openide.util.NbBundle.getMessage(modeloTopComponent.class, "modeloTopComponent.jTextField259.text")); // NOI18N
        jTextField259.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextField259KeyTyped(evt);
            }
        });

        jTextField260.setBackground(new java.awt.Color(204, 255, 204));
        jTextField260.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        jTextField260.setText(org.openide.util.NbBundle.getMessage(modeloTopComponent.class, "modeloTopComponent.jTextField260.text")); // NOI18N
        jTextField260.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField260ActionPerformed(evt);
            }
        });
        jTextField260.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextField260KeyTyped(evt);
            }
        });

        jTextField261.setBackground(new java.awt.Color(204, 255, 204));
        jTextField261.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        jTextField261.setText(org.openide.util.NbBundle.getMessage(modeloTopComponent.class, "modeloTopComponent.jTextField261.text")); // NOI18N
        jTextField261.addInputMethodListener(new java.awt.event.InputMethodListener() {
            public void caretPositionChanged(java.awt.event.InputMethodEvent evt) {
            }
            public void inputMethodTextChanged(java.awt.event.InputMethodEvent evt) {
                jTextField261InputMethodTextChanged(evt);
            }
        });
        jTextField261.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextField261KeyTyped(evt);
            }
        });

        jTextField262.setBackground(new java.awt.Color(204, 255, 204));
        jTextField262.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        jTextField262.setText(org.openide.util.NbBundle.getMessage(modeloTopComponent.class, "modeloTopComponent.jTextField262.text")); // NOI18N
        jTextField262.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextField262KeyTyped(evt);
            }
        });

        jTextField263.setBackground(new java.awt.Color(204, 255, 204));
        jTextField263.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        jTextField263.setText(org.openide.util.NbBundle.getMessage(modeloTopComponent.class, "modeloTopComponent.jTextField263.text")); // NOI18N
        jTextField263.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField263ActionPerformed(evt);
            }
        });
        jTextField263.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextField263KeyTyped(evt);
            }
        });

        org.openide.awt.Mnemonics.setLocalizedText(jLabel243, org.openide.util.NbBundle.getMessage(modeloTopComponent.class, "modeloTopComponent.jLabel243.text")); // NOI18N

        jTextField266.setBackground(new java.awt.Color(204, 255, 204));
        jTextField266.setText(org.openide.util.NbBundle.getMessage(modeloTopComponent.class, "modeloTopComponent.jTextField266.text")); // NOI18N

        org.openide.awt.Mnemonics.setLocalizedText(jLabel246, org.openide.util.NbBundle.getMessage(modeloTopComponent.class, "modeloTopComponent.jLabel246.text")); // NOI18N

        org.openide.awt.Mnemonics.setLocalizedText(jLabel247, org.openide.util.NbBundle.getMessage(modeloTopComponent.class, "modeloTopComponent.jLabel247.text")); // NOI18N

        jTextField267.setText(org.openide.util.NbBundle.getMessage(modeloTopComponent.class, "modeloTopComponent.jTextField267.text")); // NOI18N

        org.openide.awt.Mnemonics.setLocalizedText(jLabel254, org.openide.util.NbBundle.getMessage(modeloTopComponent.class, "modeloTopComponent.jLabel254.text")); // NOI18N

        org.openide.awt.Mnemonics.setLocalizedText(jCheckBox7, org.openide.util.NbBundle.getMessage(modeloTopComponent.class, "modeloTopComponent.jCheckBox7.text")); // NOI18N

        jTextArea6.setBackground(new java.awt.Color(255, 255, 204));
        jTextArea6.setColumns(20);
        jTextArea6.setRows(5);
        jScrollPane16.setViewportView(jTextArea6);

        jComboBox6.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "ACTUALES", "2015", "2014", "2013" }));

        javax.swing.GroupLayout jPanel72Layout = new javax.swing.GroupLayout(jPanel72);
        jPanel72.setLayout(jPanel72Layout);
        jPanel72Layout.setHorizontalGroup(
            jPanel72Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel72Layout.createSequentialGroup()
                .addGroup(jPanel72Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel72Layout.createSequentialGroup()
                        .addGroup(jPanel72Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel72Layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(jPanel72Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel72Layout.createSequentialGroup()
                                        .addComponent(jLabel242, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jTextField246, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(jLabel243)
                                    .addGroup(jPanel72Layout.createSequentialGroup()
                                        .addGroup(jPanel72Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                            .addComponent(jLabel245, javax.swing.GroupLayout.DEFAULT_SIZE, 75, Short.MAX_VALUE)
                                            .addComponent(jLabel244, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(jPanel72Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jTextField249, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jTextField258, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel72Layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(jLabel240)
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel72Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jLabel248, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(57, 57, 57)))
                .addGroup(jPanel72Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel72Layout.createSequentialGroup()
                        .addComponent(jTextField244, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel241, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jTextField245, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel72Layout.createSequentialGroup()
                        .addGroup(jPanel72Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel72Layout.createSequentialGroup()
                                .addGroup(jPanel72Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel72Layout.createSequentialGroup()
                                        .addGroup(jPanel72Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel72Layout.createSequentialGroup()
                                                .addComponent(jTextField247, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(jTextField248, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(jTextField252, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(jTextField253, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel72Layout.createSequentialGroup()
                                                .addComponent(jLabel249, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(jLabel250, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(jLabel251, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(18, 18, 18)
                                                .addComponent(jLabel252, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED))
                                    .addGroup(jPanel72Layout.createSequentialGroup()
                                        .addComponent(jTextField250, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jTextField251, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jTextField255, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jTextField256, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(4, 4, 4)))
                                .addGroup(jPanel72Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jTextField257, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel253, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jTextField254, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel72Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel72Layout.createSequentialGroup()
                                    .addComponent(jTextField266, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(jLabel246)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(jLabel247)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(jTextField267, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(jLabel254)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jCheckBox7))
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel72Layout.createSequentialGroup()
                                    .addComponent(jTextField259, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(jTextField260, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(jTextField261, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(jTextField262, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(jTextField263, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addContainerGap())))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel72Layout.createSequentialGroup()
                .addGap(0, 251, Short.MAX_VALUE)
                .addGroup(jPanel72Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(botonValidarCAct1, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel72Layout.createSequentialGroup()
                        .addComponent(jLabel239, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jTextField243, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(17, 17, 17)
                        .addComponent(jComboBox11, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE))))
            .addGroup(jPanel72Layout.createSequentialGroup()
                .addGroup(jPanel72Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel72Layout.createSequentialGroup()
                        .addComponent(jLabel238)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jComboBox6, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel72Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane16)))
                .addContainerGap())
        );
        jPanel72Layout.setVerticalGroup(
            jPanel72Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel72Layout.createSequentialGroup()
                .addGroup(jPanel72Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel238)
                    .addComponent(botonValidarCAct1)
                    .addComponent(jComboBox6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(4, 4, 4)
                .addGroup(jPanel72Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel239)
                    .addComponent(jTextField243, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jComboBox11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel72Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel72Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel240)
                        .addComponent(jTextField244, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel72Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel241)
                        .addComponent(jTextField245, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel72Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel253)
                    .addComponent(jLabel252)
                    .addComponent(jLabel251)
                    .addComponent(jLabel250)
                    .addComponent(jLabel249)
                    .addComponent(jLabel248))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel72Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField246, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField247, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField248, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField252, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField253, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField254, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel242))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel72Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel244, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField249, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField250, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField251, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField255, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField256, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField257, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel72Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel245)
                    .addComponent(jTextField258, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField259, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField260, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField261, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField262, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField263, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel72Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel243)
                    .addComponent(jTextField266, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel247)
                    .addComponent(jLabel246)
                    .addComponent(jTextField267, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel254)
                    .addComponent(jCheckBox7))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 16, Short.MAX_VALUE)
                .addComponent(jScrollPane16, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jTabbedPane11.addTab(org.openide.util.NbBundle.getMessage(modeloTopComponent.class, "modeloTopComponent.jPanel72.TabConstraints.tabTitle"), jPanel72); // NOI18N

        javax.swing.GroupLayout jPanel22Layout = new javax.swing.GroupLayout(jPanel22);
        jPanel22.setLayout(jPanel22Layout);
        jPanel22Layout.setHorizontalGroup(
            jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 721, Short.MAX_VALUE)
        );
        jPanel22Layout.setVerticalGroup(
            jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 279, Short.MAX_VALUE)
        );

        jTabbedPane11.addTab(org.openide.util.NbBundle.getMessage(modeloTopComponent.class, "modeloTopComponent.jPanel22.TabConstraints.tabTitle"), jPanel22); // NOI18N

        jLabel39.setIcon(new javax.swing.ImageIcon(getClass().getResource("/org/myorg/AcMod03/esquema01.png"))); // NOI18N
        org.openide.awt.Mnemonics.setLocalizedText(jLabel39, org.openide.util.NbBundle.getMessage(modeloTopComponent.class, "modeloTopComponent.jLabel39.text")); // NOI18N

        javax.swing.GroupLayout jPanel23Layout = new javax.swing.GroupLayout(jPanel23);
        jPanel23.setLayout(jPanel23Layout);
        jPanel23Layout.setHorizontalGroup(
            jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel23Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel39)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel23Layout.setVerticalGroup(
            jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel23Layout.createSequentialGroup()
                .addComponent(jLabel39)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        jTabbedPane11.addTab(org.openide.util.NbBundle.getMessage(modeloTopComponent.class, "modeloTopComponent.jPanel23.TabConstraints.tabTitle"), jPanel23); // NOI18N

        javax.swing.GroupLayout jPanel17Layout = new javax.swing.GroupLayout(jPanel17);
        jPanel17.setLayout(jPanel17Layout);
        jPanel17Layout.setHorizontalGroup(
            jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane11, javax.swing.GroupLayout.PREFERRED_SIZE, 726, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        jPanel17Layout.setVerticalGroup(
            jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane11, javax.swing.GroupLayout.PREFERRED_SIZE, 306, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        jPanel18.setBackground(new java.awt.Color(255, 255, 255));

        jLabel20.setIcon(new javax.swing.ImageIcon(getClass().getResource("/org/myorg/AcMod03/grafica07.png"))); // NOI18N
        org.openide.awt.Mnemonics.setLocalizedText(jLabel20, org.openide.util.NbBundle.getMessage(modeloTopComponent.class, "modeloTopComponent.jLabel20.text")); // NOI18N

        javax.swing.GroupLayout jPanel18Layout = new javax.swing.GroupLayout(jPanel18);
        jPanel18.setLayout(jPanel18Layout);
        jPanel18Layout.setHorizontalGroup(
            jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel18Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel20, javax.swing.GroupLayout.PREFERRED_SIZE, 314, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(42, Short.MAX_VALUE))
        );
        jPanel18Layout.setVerticalGroup(
            jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel18Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel20)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel19.setBackground(new java.awt.Color(255, 255, 255));

        jLabel36.setIcon(new javax.swing.ImageIcon(getClass().getResource("/org/myorg/AcMod03/grafica04.png"))); // NOI18N
        org.openide.awt.Mnemonics.setLocalizedText(jLabel36, org.openide.util.NbBundle.getMessage(modeloTopComponent.class, "modeloTopComponent.jLabel36.text")); // NOI18N

        javax.swing.GroupLayout jPanel19Layout = new javax.swing.GroupLayout(jPanel19);
        jPanel19.setLayout(jPanel19Layout);
        jPanel19Layout.setHorizontalGroup(
            jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel19Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel36)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel19Layout.setVerticalGroup(
            jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel19Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel36)
                .addContainerGap(23, Short.MAX_VALUE))
        );

        jPanel26.setBackground(new java.awt.Color(255, 255, 255));

        jLabel10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/org/myorg/AcMod03/grafica01.png"))); // NOI18N
        org.openide.awt.Mnemonics.setLocalizedText(jLabel10, org.openide.util.NbBundle.getMessage(modeloTopComponent.class, "modeloTopComponent.jLabel10.text")); // NOI18N

        jLabel11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/org/myorg/AcMod03/grafica02.png"))); // NOI18N
        org.openide.awt.Mnemonics.setLocalizedText(jLabel11, org.openide.util.NbBundle.getMessage(modeloTopComponent.class, "modeloTopComponent.jLabel11.text")); // NOI18N

        jLabel12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/org/myorg/AcMod03/grafica03.png"))); // NOI18N
        org.openide.awt.Mnemonics.setLocalizedText(jLabel12, org.openide.util.NbBundle.getMessage(modeloTopComponent.class, "modeloTopComponent.jLabel12.text")); // NOI18N

        javax.swing.GroupLayout jPanel26Layout = new javax.swing.GroupLayout(jPanel26);
        jPanel26.setLayout(jPanel26Layout);
        jPanel26Layout.setHorizontalGroup(
            jPanel26Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel26Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel10)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel11)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel12)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel26Layout.setVerticalGroup(
            jPanel26Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel26Layout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addGroup(jPanel26Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel12)
                    .addComponent(jLabel11)
                    .addComponent(jLabel10))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTabbedPane3.addTab(org.openide.util.NbBundle.getMessage(modeloTopComponent.class, "modeloTopComponent.jPanel26.TabConstraints.tabTitle"), jPanel26); // NOI18N

        jPanel27.setBackground(new java.awt.Color(255, 255, 255));

        jLabel41.setIcon(new javax.swing.ImageIcon(getClass().getResource("/org/myorg/AcMod03/grafica04.png"))); // NOI18N
        org.openide.awt.Mnemonics.setLocalizedText(jLabel41, org.openide.util.NbBundle.getMessage(modeloTopComponent.class, "modeloTopComponent.jLabel41.text")); // NOI18N

        jLabel42.setIcon(new javax.swing.ImageIcon(getClass().getResource("/org/myorg/AcMod03/grafica05.png"))); // NOI18N
        org.openide.awt.Mnemonics.setLocalizedText(jLabel42, org.openide.util.NbBundle.getMessage(modeloTopComponent.class, "modeloTopComponent.jLabel42.text")); // NOI18N

        jLabel43.setIcon(new javax.swing.ImageIcon(getClass().getResource("/org/myorg/AcMod03/grafica06.png"))); // NOI18N
        org.openide.awt.Mnemonics.setLocalizedText(jLabel43, org.openide.util.NbBundle.getMessage(modeloTopComponent.class, "modeloTopComponent.jLabel43.text")); // NOI18N

        javax.swing.GroupLayout jPanel27Layout = new javax.swing.GroupLayout(jPanel27);
        jPanel27.setLayout(jPanel27Layout);
        jPanel27Layout.setHorizontalGroup(
            jPanel27Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel27Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel41)
                .addGap(18, 18, 18)
                .addComponent(jLabel42)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel43, javax.swing.GroupLayout.PREFERRED_SIZE, 339, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel27Layout.setVerticalGroup(
            jPanel27Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel27Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel27Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel43)
                    .addComponent(jLabel42)
                    .addComponent(jLabel41))
                .addContainerGap(75, Short.MAX_VALUE))
        );

        jTabbedPane3.addTab(org.openide.util.NbBundle.getMessage(modeloTopComponent.class, "modeloTopComponent.jPanel27.TabConstraints.tabTitle"), jPanel27); // NOI18N

        javax.swing.GroupLayout jPanel20Layout = new javax.swing.GroupLayout(jPanel20);
        jPanel20.setLayout(jPanel20Layout);
        jPanel20Layout.setHorizontalGroup(
            jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1095, Short.MAX_VALUE)
        );
        jPanel20Layout.setVerticalGroup(
            jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 322, Short.MAX_VALUE)
        );

        jTabbedPane3.addTab(org.openide.util.NbBundle.getMessage(modeloTopComponent.class, "modeloTopComponent.jPanel20.TabConstraints.tabTitle"), jPanel20); // NOI18N

        javax.swing.GroupLayout jPanel14Layout = new javax.swing.GroupLayout(jPanel14);
        jPanel14.setLayout(jPanel14Layout);
        jPanel14Layout.setHorizontalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1095, Short.MAX_VALUE)
        );
        jPanel14Layout.setVerticalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 322, Short.MAX_VALUE)
        );

        jTabbedPane3.addTab(org.openide.util.NbBundle.getMessage(modeloTopComponent.class, "modeloTopComponent.jPanel14.TabConstraints.tabTitle"), jPanel14); // NOI18N

        javax.swing.GroupLayout jPanel15Layout = new javax.swing.GroupLayout(jPanel15);
        jPanel15.setLayout(jPanel15Layout);
        jPanel15Layout.setHorizontalGroup(
            jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1095, Short.MAX_VALUE)
        );
        jPanel15Layout.setVerticalGroup(
            jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 322, Short.MAX_VALUE)
        );

        jTabbedPane3.addTab(org.openide.util.NbBundle.getMessage(modeloTopComponent.class, "modeloTopComponent.jPanel15.TabConstraints.tabTitle"), jPanel15); // NOI18N

        javax.swing.GroupLayout jPanel13Layout = new javax.swing.GroupLayout(jPanel13);
        jPanel13.setLayout(jPanel13Layout);
        jPanel13Layout.setHorizontalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel13Layout.createSequentialGroup()
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jTabbedPane3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addGroup(jPanel13Layout.createSequentialGroup()
                        .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel16, javax.swing.GroupLayout.PREFERRED_SIZE, 711, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jPanel17, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jPanel18, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanel19, javax.swing.GroupLayout.PREFERRED_SIZE, 368, Short.MAX_VALUE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel13Layout.setVerticalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel13Layout.createSequentialGroup()
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel13Layout.createSequentialGroup()
                        .addComponent(jPanel16, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jPanel17, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel13Layout.createSequentialGroup()
                        .addComponent(jPanel18, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel19, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTabbedPane3))
        );

        javax.swing.GroupLayout jPanel12Layout = new javax.swing.GroupLayout(jPanel12);
        jPanel12.setLayout(jPanel12Layout);
        jPanel12Layout.setHorizontalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addComponent(jPanel13, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 311, Short.MAX_VALUE))
        );
        jPanel12Layout.setVerticalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel13, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jTabbedPane1.addTab(org.openide.util.NbBundle.getMessage(modeloTopComponent.class, "modeloTopComponent.jPanel12.TabConstraints.tabTitle"), jPanel12); // NOI18N

        jPanel1.setBackground(new java.awt.Color(204, 204, 204));

        org.openide.awt.Mnemonics.setLocalizedText(jButton9, org.openide.util.NbBundle.getMessage(modeloTopComponent.class, "modeloTopComponent.jButton9.text")); // NOI18N
        jButton9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton9ActionPerformed(evt);
            }
        });

        jScrollPane2.setViewportView(arbol3);

        org.openide.awt.Mnemonics.setLocalizedText(jButton15, org.openide.util.NbBundle.getMessage(modeloTopComponent.class, "modeloTopComponent.jButton15.text")); // NOI18N

        jScrollPane6.setViewportView(arbol2);

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addComponent(jButton9)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton15)
                .addContainerGap())
            .addComponent(jScrollPane2)
            .addComponent(jScrollPane6, javax.swing.GroupLayout.Alignment.TRAILING)
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton9, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton15, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 439, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 419, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jGraficaModelo.setBackground(new java.awt.Color(204, 204, 204));

        javax.swing.GroupLayout jGraficaModeloLayout = new javax.swing.GroupLayout(jGraficaModelo);
        jGraficaModelo.setLayout(jGraficaModeloLayout);
        jGraficaModeloLayout.setHorizontalGroup(
            jGraficaModeloLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 597, Short.MAX_VALUE)
        );
        jGraficaModeloLayout.setVerticalGroup(
            jGraficaModeloLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jGraficaLineasLayout = new javax.swing.GroupLayout(jGraficaLineas);
        jGraficaLineas.setLayout(jGraficaLineasLayout);
        jGraficaLineasLayout.setHorizontalGroup(
            jGraficaLineasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 597, Short.MAX_VALUE)
        );
        jGraficaLineasLayout.setVerticalGroup(
            jGraficaLineasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 299, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel11Layout = new javax.swing.GroupLayout(jPanel11);
        jPanel11.setLayout(jPanel11Layout);
        jPanel11Layout.setHorizontalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addComponent(jGraficaModelo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jGraficaLineas, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel11Layout.setVerticalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jGraficaLineas, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jGraficaModelo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jScrollPane9.setMinimumSize(new java.awt.Dimension(1200, 200));

        jTableModeloGeneral.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jTableModeloGeneral.setMinimumSize(new java.awt.Dimension(1200, 200));
        jScrollPane9.setViewportView(jTableModeloGeneral);
        if (jTableModeloGeneral.getColumnModel().getColumnCount() > 0) {
            jTableModeloGeneral.getColumnModel().getColumn(0).setHeaderValue(org.openide.util.NbBundle.getMessage(modeloTopComponent.class, "modeloTopComponent.jTableModeloGeneral.columnModel.title0")); // NOI18N
            jTableModeloGeneral.getColumnModel().getColumn(1).setHeaderValue(org.openide.util.NbBundle.getMessage(modeloTopComponent.class, "modeloTopComponent.jTableModeloGeneral.columnModel.title1")); // NOI18N
            jTableModeloGeneral.getColumnModel().getColumn(2).setHeaderValue(org.openide.util.NbBundle.getMessage(modeloTopComponent.class, "modeloTopComponent.jTableModeloGeneral.columnModel.title2")); // NOI18N
            jTableModeloGeneral.getColumnModel().getColumn(3).setHeaderValue(org.openide.util.NbBundle.getMessage(modeloTopComponent.class, "modeloTopComponent.jTableModeloGeneral.columnModel.title3")); // NOI18N
        }

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane9, javax.swing.GroupLayout.PREFERRED_SIZE, 1199, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addComponent(jPanel11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane9, javax.swing.GroupLayout.PREFERRED_SIZE, 291, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(224, Short.MAX_VALUE))
        );

        jTabbedPane2.addTab(org.openide.util.NbBundle.getMessage(modeloTopComponent.class, "modeloTopComponent.jPanel10.TabConstraints.tabTitle"), jPanel10); // NOI18N

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        jPanelGrafica02.setBackground(new java.awt.Color(153, 204, 255));

        javax.swing.GroupLayout jPanelGrafica02Layout = new javax.swing.GroupLayout(jPanelGrafica02);
        jPanelGrafica02.setLayout(jPanelGrafica02Layout);
        jPanelGrafica02Layout.setHorizontalGroup(
            jPanelGrafica02Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanelGrafica02Layout.setVerticalGroup(
            jPanelGrafica02Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 116, Short.MAX_VALUE)
        );

        jPanelGrafica01.setBackground(new java.awt.Color(204, 204, 255));

        javax.swing.GroupLayout jPanelGrafica01Layout = new javax.swing.GroupLayout(jPanelGrafica01);
        jPanelGrafica01.setLayout(jPanelGrafica01Layout);
        jPanelGrafica01Layout.setHorizontalGroup(
            jPanelGrafica01Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 724, Short.MAX_VALUE)
        );
        jPanelGrafica01Layout.setVerticalGroup(
            jPanelGrafica01Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 120, Short.MAX_VALUE)
        );

        org.openide.awt.Mnemonics.setLocalizedText(jButton8, org.openide.util.NbBundle.getMessage(modeloTopComponent.class, "modeloTopComponent.jButton8.text")); // NOI18N

        org.openide.awt.Mnemonics.setLocalizedText(jButton1, org.openide.util.NbBundle.getMessage(modeloTopComponent.class, "modeloTopComponent.jButton1.text")); // NOI18N

        org.openide.awt.Mnemonics.setLocalizedText(jButton2, org.openide.util.NbBundle.getMessage(modeloTopComponent.class, "modeloTopComponent.jButton2.text")); // NOI18N

        jTable3.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane5.setViewportView(jTable3);

        org.openide.awt.Mnemonics.setLocalizedText(jButton3, org.openide.util.NbBundle.getMessage(modeloTopComponent.class, "modeloTopComponent.jButton3.text")); // NOI18N

        org.openide.awt.Mnemonics.setLocalizedText(jButton4, org.openide.util.NbBundle.getMessage(modeloTopComponent.class, "modeloTopComponent.jButton4.text")); // NOI18N

        org.openide.awt.Mnemonics.setLocalizedText(jButton7, org.openide.util.NbBundle.getMessage(modeloTopComponent.class, "modeloTopComponent.jButton7.text")); // NOI18N

        jTable4.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane3.setViewportView(jTable4);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 534, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 24, Short.MAX_VALUE)
        );

        jComboBox2.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "ILUMINACIÓN NORMAL", "ILUMINACION OPTIMIZADA", "CAFETERIA", "COCINA", "SERVICIO COMEDOR", "LIMPIEZA", "CAMARAS FRIO NORMAL", "CAMARAS FRIO OPTIMIZADO", "CLIMATIZACION NORMAL", "CLIMATIZACIÓN OPTIMIZADO", " " }));

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "L-V", "SABADOS", "DOMINGOS", "FESTIVOS" }));

        jTextField1.setText(org.openide.util.NbBundle.getMessage(modeloTopComponent.class, "modeloTopComponent.jTextField1.text")); // NOI18N

        org.openide.awt.Mnemonics.setLocalizedText(jButton5, org.openide.util.NbBundle.getMessage(modeloTopComponent.class, "modeloTopComponent.jButton5.text")); // NOI18N

        org.openide.awt.Mnemonics.setLocalizedText(jButton6, org.openide.util.NbBundle.getMessage(modeloTopComponent.class, "modeloTopComponent.jButton6.text")); // NOI18N

        jComboBox3.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "VERANO", "OTOÑO", "INVIERNO", "PRIMAVERA", "VACACIONES" }));

        org.openide.awt.Mnemonics.setLocalizedText(jLabel1, org.openide.util.NbBundle.getMessage(modeloTopComponent.class, "modeloTopComponent.jLabel1.text")); // NOI18N

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel9Layout.createSequentialGroup()
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jComboBox3, javax.swing.GroupLayout.PREFERRED_SIZE, 299, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel9Layout.createSequentialGroup()
                                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel9Layout.createSequentialGroup()
                                        .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 191, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, 238, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel9Layout.createSequentialGroup()
                                        .addGap(12, 12, 12)
                                        .addComponent(jButton4)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jButton7))
                                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 532, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addGroup(jPanel9Layout.createSequentialGroup()
                                            .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                            .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                            .addComponent(jButton1)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(jButton8))
                                        .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 518, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel9Layout.createSequentialGroup()
                                        .addComponent(jPanelGrafica01, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(0, 0, Short.MAX_VALUE))
                                    .addComponent(jPanelGrafica02, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                        .addGap(14, 14, 14))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton6)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel9Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton5)
                            .addComponent(jButton6))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jPanelGrafica01, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel9Layout.createSequentialGroup()
                                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel1)
                        .addComponent(jComboBox3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton7, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(4, 4, 4)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanelGrafica02, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton8)
                    .addComponent(jButton1)
                    .addComponent(jButton2)
                    .addComponent(jButton3))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(317, Short.MAX_VALUE))
        );

        jTabbedPane2.addTab(org.openide.util.NbBundle.getMessage(modeloTopComponent.class, "modeloTopComponent.jPanel9.TabConstraints.tabTitle"), jPanel9); // NOI18N

        javax.swing.GroupLayout jPanel31Layout = new javax.swing.GroupLayout(jPanel31);
        jPanel31.setLayout(jPanel31Layout);
        jPanel31Layout.setHorizontalGroup(
            jPanel31Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1203, Short.MAX_VALUE)
        );
        jPanel31Layout.setVerticalGroup(
            jPanel31Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 826, Short.MAX_VALUE)
        );

        jTabbedPane2.addTab(org.openide.util.NbBundle.getMessage(modeloTopComponent.class, "modeloTopComponent.jPanel31.TabConstraints.tabTitle"), jPanel31); // NOI18N

        jTextField2.setText(org.openide.util.NbBundle.getMessage(modeloTopComponent.class, "modeloTopComponent.jTextField2.text")); // NOI18N

        org.openide.awt.Mnemonics.setLocalizedText(jButton14, org.openide.util.NbBundle.getMessage(modeloTopComponent.class, "modeloTopComponent.jButton14.text")); // NOI18N
        jButton14.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton14ActionPerformed(evt);
            }
        });

        org.openide.awt.Mnemonics.setLocalizedText(jButton10, org.openide.util.NbBundle.getMessage(modeloTopComponent.class, "modeloTopComponent.jButton10.text")); // NOI18N

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 492, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton10)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton14))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jTabbedPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 1208, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, 896, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton14, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton10, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTabbedPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 853, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(0, 0, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab(org.openide.util.NbBundle.getMessage(modeloTopComponent.class, "modeloTopComponent.jPanel1.TabConstraints.tabTitle"), jPanel1); // NOI18N

        jPanel5.setBackground(new java.awt.Color(204, 204, 204));

        org.openide.awt.Mnemonics.setLocalizedText(jLabel2, org.openide.util.NbBundle.getMessage(modeloTopComponent.class, "modeloTopComponent.jLabel2.text")); // NOI18N

        org.openide.awt.Mnemonics.setLocalizedText(jLabel3, org.openide.util.NbBundle.getMessage(modeloTopComponent.class, "modeloTopComponent.jLabel3.text")); // NOI18N

        org.openide.awt.Mnemonics.setLocalizedText(jLabel4, org.openide.util.NbBundle.getMessage(modeloTopComponent.class, "modeloTopComponent.jLabel4.text")); // NOI18N

        org.openide.awt.Mnemonics.setLocalizedText(jLabel5, org.openide.util.NbBundle.getMessage(modeloTopComponent.class, "modeloTopComponent.jLabel5.text")); // NOI18N

        org.openide.awt.Mnemonics.setLocalizedText(jLabel6, org.openide.util.NbBundle.getMessage(modeloTopComponent.class, "modeloTopComponent.jLabel6.text")); // NOI18N

        jTextField4.setText(org.openide.util.NbBundle.getMessage(modeloTopComponent.class, "modeloTopComponent.jTextField4.text")); // NOI18N

        jTextField5.setText(org.openide.util.NbBundle.getMessage(modeloTopComponent.class, "modeloTopComponent.jTextField5.text")); // NOI18N

        jTextField6.setText(org.openide.util.NbBundle.getMessage(modeloTopComponent.class, "modeloTopComponent.jTextField6.text")); // NOI18N

        jTextField7.setText(org.openide.util.NbBundle.getMessage(modeloTopComponent.class, "modeloTopComponent.jTextField7.text")); // NOI18N

        jTextField8.setText(org.openide.util.NbBundle.getMessage(modeloTopComponent.class, "modeloTopComponent.jTextField8.text")); // NOI18N

        org.openide.awt.Mnemonics.setLocalizedText(jLabel7, org.openide.util.NbBundle.getMessage(modeloTopComponent.class, "modeloTopComponent.jLabel7.text")); // NOI18N

        tfGeneracion.setText(org.openide.util.NbBundle.getMessage(modeloTopComponent.class, "modeloTopComponent.tfGeneracion.text")); // NOI18N

        org.openide.awt.Mnemonics.setLocalizedText(jLabel8, org.openide.util.NbBundle.getMessage(modeloTopComponent.class, "modeloTopComponent.jLabel8.text")); // NOI18N

        jTextField10.setText(org.openide.util.NbBundle.getMessage(modeloTopComponent.class, "modeloTopComponent.jTextField10.text")); // NOI18N

        org.openide.awt.Mnemonics.setLocalizedText(jButton11, org.openide.util.NbBundle.getMessage(modeloTopComponent.class, "modeloTopComponent.jButton11.text")); // NOI18N
        jButton11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton11ActionPerformed(evt);
            }
        });

        org.openide.awt.Mnemonics.setLocalizedText(jButton12, org.openide.util.NbBundle.getMessage(modeloTopComponent.class, "modeloTopComponent.jButton12.text")); // NOI18N
        jButton12.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton12ActionPerformed(evt);
            }
        });

        org.openide.awt.Mnemonics.setLocalizedText(jLabel9, org.openide.util.NbBundle.getMessage(modeloTopComponent.class, "modeloTopComponent.jLabel9.text")); // NOI18N

        jTextField3.setText(org.openide.util.NbBundle.getMessage(modeloTopComponent.class, "modeloTopComponent.jTextField3.text")); // NOI18N

        org.openide.awt.Mnemonics.setLocalizedText(jButton13, org.openide.util.NbBundle.getMessage(modeloTopComponent.class, "modeloTopComponent.jButton13.text")); // NOI18N
        jButton13.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton13ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 210, Short.MAX_VALUE)
                        .addComponent(jLabel9, javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jTextField5)
                    .addComponent(jTextField6)
                    .addComponent(jTextField7, javax.swing.GroupLayout.DEFAULT_SIZE, 50, Short.MAX_VALUE)
                    .addComponent(jTextField8)
                    .addComponent(tfGeneracion)
                    .addComponent(jTextField4, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jTextField3))
                .addGap(32, 32, 32)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(jLabel8)
                        .addGap(4, 4, 4)
                        .addComponent(jTextField10, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jButton11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton13, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel5Layout.createSequentialGroup()
                        .addComponent(jTextField5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel5Layout.createSequentialGroup()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jButton11))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel9))
                            .addComponent(jButton12))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 7, Short.MAX_VALUE)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTextField6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(jTextField7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jTextField8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                        .addComponent(jButton13)
                        .addGap(16, 16, 16)))
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(tfGeneracion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8)
                    .addComponent(jTextField10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        javax.swing.GroupLayout pGrafico02Layout = new javax.swing.GroupLayout(pGrafico02);
        pGrafico02.setLayout(pGrafico02Layout);
        pGrafico02Layout.setHorizontalGroup(
            pGrafico02Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 492, Short.MAX_VALUE)
        );
        pGrafico02Layout.setVerticalGroup(
            pGrafico02Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 345, Short.MAX_VALUE)
        );

        jScrollPane4.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
        jScrollPane4.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jScrollPane4.setViewportView(jTextArea1);

        javax.swing.GroupLayout pGrafico03Layout = new javax.swing.GroupLayout(pGrafico03);
        pGrafico03.setLayout(pGrafico03Layout);
        pGrafico03Layout.setHorizontalGroup(
            pGrafico03Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 727, Short.MAX_VALUE)
        );
        pGrafico03Layout.setVerticalGroup(
            pGrafico03Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 287, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane4)
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(pGrafico03, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jProgressBar1, javax.swing.GroupLayout.PREFERRED_SIZE, 727, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jProgressBar1, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pGrafico03, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 307, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(15, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout pGrafico01Layout = new javax.swing.GroupLayout(pGrafico01);
        pGrafico01.setLayout(pGrafico01Layout);
        pGrafico01Layout.setHorizontalGroup(
            pGrafico01Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 492, Short.MAX_VALUE)
        );
        pGrafico01Layout.setVerticalGroup(
            pGrafico01Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 234, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jPanel5, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 492, Short.MAX_VALUE)
                    .addComponent(pGrafico02, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(pGrafico01, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 174, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pGrafico01, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pGrafico02, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab(org.openide.util.NbBundle.getMessage(modeloTopComponent.class, "modeloTopComponent.jPanel4.TabConstraints.tabTitle"), jPanel4); // NOI18N

        jScrollPane15.setViewportView(arbolPrecios);

        javax.swing.GroupLayout jPanel28Layout = new javax.swing.GroupLayout(jPanel28);
        jPanel28.setLayout(jPanel28Layout);
        jPanel28Layout.setHorizontalGroup(
            jPanel28Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
            .addGroup(jPanel28Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel28Layout.createSequentialGroup()
                    .addGap(2, 2, 2)
                    .addComponent(jScrollPane15, javax.swing.GroupLayout.PREFERRED_SIZE, 239, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
        jPanel28Layout.setVerticalGroup(
            jPanel28Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 347, Short.MAX_VALUE)
            .addGroup(jPanel28Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel28Layout.createSequentialGroup()
                    .addComponent(jScrollPane15, javax.swing.GroupLayout.PREFERRED_SIZE, 347, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );

        miTabla13.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        miBarra13.setViewportView(miTabla13);

        org.openide.awt.Mnemonics.setLocalizedText(jLabel181, org.openide.util.NbBundle.getMessage(modeloTopComponent.class, "modeloTopComponent.jLabel181.text")); // NOI18N

        jTextField129.setBackground(new java.awt.Color(204, 204, 255));
        jTextField129.setText(org.openide.util.NbBundle.getMessage(modeloTopComponent.class, "modeloTopComponent.jTextField129.text")); // NOI18N

        org.openide.awt.Mnemonics.setLocalizedText(jLabel182, org.openide.util.NbBundle.getMessage(modeloTopComponent.class, "modeloTopComponent.jLabel182.text")); // NOI18N

        jTextField130.setBackground(new java.awt.Color(204, 204, 255));
        jTextField130.setText(org.openide.util.NbBundle.getMessage(modeloTopComponent.class, "modeloTopComponent.jTextField130.text")); // NOI18N

        org.openide.awt.Mnemonics.setLocalizedText(jLabel183, org.openide.util.NbBundle.getMessage(modeloTopComponent.class, "modeloTopComponent.jLabel183.text")); // NOI18N

        jTextField131.setBackground(new java.awt.Color(204, 204, 255));
        jTextField131.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jTextField131.setText(org.openide.util.NbBundle.getMessage(modeloTopComponent.class, "modeloTopComponent.jTextField131.text")); // NOI18N
        jTextField131.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField131ActionPerformed(evt);
            }
        });

        org.openide.awt.Mnemonics.setLocalizedText(jButton22, org.openide.util.NbBundle.getMessage(modeloTopComponent.class, "modeloTopComponent.jButton22.text")); // NOI18N
        jButton22.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton22ActionPerformed(evt);
            }
        });

        jTextField134.setText(org.openide.util.NbBundle.getMessage(modeloTopComponent.class, "modeloTopComponent.jTextField134.text")); // NOI18N

        jTextField135.setText(org.openide.util.NbBundle.getMessage(modeloTopComponent.class, "modeloTopComponent.jTextField135.text")); // NOI18N

        jTextField136.setText(org.openide.util.NbBundle.getMessage(modeloTopComponent.class, "modeloTopComponent.jTextField136.text")); // NOI18N
        jTextField136.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField136ActionPerformed(evt);
            }
        });

        jTextField137.setText(org.openide.util.NbBundle.getMessage(modeloTopComponent.class, "modeloTopComponent.jTextField137.text")); // NOI18N

        jTextField138.setText(org.openide.util.NbBundle.getMessage(modeloTopComponent.class, "modeloTopComponent.jTextField138.text")); // NOI18N

        jTextField139.setText(org.openide.util.NbBundle.getMessage(modeloTopComponent.class, "modeloTopComponent.jTextField139.text")); // NOI18N

        org.openide.awt.Mnemonics.setLocalizedText(jLabel187, org.openide.util.NbBundle.getMessage(modeloTopComponent.class, "modeloTopComponent.jLabel187.text")); // NOI18N

        org.openide.awt.Mnemonics.setLocalizedText(jLabel188, org.openide.util.NbBundle.getMessage(modeloTopComponent.class, "modeloTopComponent.jLabel188.text")); // NOI18N

        org.openide.awt.Mnemonics.setLocalizedText(jLabel189, org.openide.util.NbBundle.getMessage(modeloTopComponent.class, "modeloTopComponent.jLabel189.text")); // NOI18N

        org.openide.awt.Mnemonics.setLocalizedText(jLabel190, org.openide.util.NbBundle.getMessage(modeloTopComponent.class, "modeloTopComponent.jLabel190.text")); // NOI18N

        org.openide.awt.Mnemonics.setLocalizedText(jLabel191, org.openide.util.NbBundle.getMessage(modeloTopComponent.class, "modeloTopComponent.jLabel191.text")); // NOI18N

        org.openide.awt.Mnemonics.setLocalizedText(jLabel192, org.openide.util.NbBundle.getMessage(modeloTopComponent.class, "modeloTopComponent.jLabel192.text")); // NOI18N

        jLabel194.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        org.openide.awt.Mnemonics.setLocalizedText(jLabel194, org.openide.util.NbBundle.getMessage(modeloTopComponent.class, "modeloTopComponent.jLabel194.text")); // NOI18N

        org.openide.awt.Mnemonics.setLocalizedText(jLabel195, org.openide.util.NbBundle.getMessage(modeloTopComponent.class, "modeloTopComponent.jLabel195.text")); // NOI18N

        jTextField147.setBackground(new java.awt.Color(255, 255, 204));

        org.openide.awt.Mnemonics.setLocalizedText(jLabel196, org.openide.util.NbBundle.getMessage(modeloTopComponent.class, "modeloTopComponent.jLabel196.text")); // NOI18N

        jTextField148.setBackground(new java.awt.Color(255, 255, 204));
        jTextField148.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField148ActionPerformed(evt);
            }
        });

        jTextField149.setText(org.openide.util.NbBundle.getMessage(modeloTopComponent.class, "modeloTopComponent.jTextField149.text")); // NOI18N

        jTextField150.setText(org.openide.util.NbBundle.getMessage(modeloTopComponent.class, "modeloTopComponent.jTextField150.text")); // NOI18N

        jTextField151.setText(org.openide.util.NbBundle.getMessage(modeloTopComponent.class, "modeloTopComponent.jTextField151.text")); // NOI18N

        jTextField152.setText(org.openide.util.NbBundle.getMessage(modeloTopComponent.class, "modeloTopComponent.jTextField152.text")); // NOI18N

        jTextField153.setText(org.openide.util.NbBundle.getMessage(modeloTopComponent.class, "modeloTopComponent.jTextField153.text")); // NOI18N

        jTextField154.setText(org.openide.util.NbBundle.getMessage(modeloTopComponent.class, "modeloTopComponent.jTextField154.text")); // NOI18N
        jTextField154.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField154ActionPerformed(evt);
            }
        });

        org.openide.awt.Mnemonics.setLocalizedText(jLabel199, org.openide.util.NbBundle.getMessage(modeloTopComponent.class, "modeloTopComponent.jLabel199.text")); // NOI18N

        jTextField185.setText(org.openide.util.NbBundle.getMessage(modeloTopComponent.class, "modeloTopComponent.jTextField185.text")); // NOI18N

        org.openide.awt.Mnemonics.setLocalizedText(jLabel186, org.openide.util.NbBundle.getMessage(modeloTopComponent.class, "modeloTopComponent.jLabel186.text")); // NOI18N

        jTextField178.setBackground(new java.awt.Color(204, 204, 255));
        jTextField178.setText(org.openide.util.NbBundle.getMessage(modeloTopComponent.class, "modeloTopComponent.jTextField178.text")); // NOI18N

        jTextField172.setText(org.openide.util.NbBundle.getMessage(modeloTopComponent.class, "modeloTopComponent.jTextField172.text")); // NOI18N

        jTextField173.setText(org.openide.util.NbBundle.getMessage(modeloTopComponent.class, "modeloTopComponent.jTextField173.text")); // NOI18N

        jTextField174.setText(org.openide.util.NbBundle.getMessage(modeloTopComponent.class, "modeloTopComponent.jTextField174.text")); // NOI18N

        jTextField175.setText(org.openide.util.NbBundle.getMessage(modeloTopComponent.class, "modeloTopComponent.jTextField175.text")); // NOI18N

        jTextField176.setText(org.openide.util.NbBundle.getMessage(modeloTopComponent.class, "modeloTopComponent.jTextField176.text")); // NOI18N

        jTextField177.setText(org.openide.util.NbBundle.getMessage(modeloTopComponent.class, "modeloTopComponent.jTextField177.text")); // NOI18N

        org.openide.awt.Mnemonics.setLocalizedText(jLabel185, org.openide.util.NbBundle.getMessage(modeloTopComponent.class, "modeloTopComponent.jLabel185.text")); // NOI18N

        jTextField132.setBackground(new java.awt.Color(204, 204, 255));
        jTextField132.setText(org.openide.util.NbBundle.getMessage(modeloTopComponent.class, "modeloTopComponent.jTextField132.text")); // NOI18N

        jTextField155.setText(org.openide.util.NbBundle.getMessage(modeloTopComponent.class, "modeloTopComponent.jTextField155.text")); // NOI18N

        jTextField156.setText(org.openide.util.NbBundle.getMessage(modeloTopComponent.class, "modeloTopComponent.jTextField156.text")); // NOI18N
        jTextField156.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField156ActionPerformed(evt);
            }
        });

        jTextField157.setText(org.openide.util.NbBundle.getMessage(modeloTopComponent.class, "modeloTopComponent.jTextField157.text")); // NOI18N

        jTextField158.setText(org.openide.util.NbBundle.getMessage(modeloTopComponent.class, "modeloTopComponent.jTextField158.text")); // NOI18N

        jTextField159.setText(org.openide.util.NbBundle.getMessage(modeloTopComponent.class, "modeloTopComponent.jTextField159.text")); // NOI18N

        jTextField160.setText(org.openide.util.NbBundle.getMessage(modeloTopComponent.class, "modeloTopComponent.jTextField160.text")); // NOI18N

        org.openide.awt.Mnemonics.setLocalizedText(jLabel184, org.openide.util.NbBundle.getMessage(modeloTopComponent.class, "modeloTopComponent.jLabel184.text")); // NOI18N

        jTextField268.setText(org.openide.util.NbBundle.getMessage(modeloTopComponent.class, "modeloTopComponent.jTextField268.text")); // NOI18N

        jTextField269.setText(org.openide.util.NbBundle.getMessage(modeloTopComponent.class, "modeloTopComponent.jTextField269.text")); // NOI18N

        jTextField270.setText(org.openide.util.NbBundle.getMessage(modeloTopComponent.class, "modeloTopComponent.jTextField270.text")); // NOI18N

        jTextField271.setText(org.openide.util.NbBundle.getMessage(modeloTopComponent.class, "modeloTopComponent.jTextField271.text")); // NOI18N

        jTextField272.setText(org.openide.util.NbBundle.getMessage(modeloTopComponent.class, "modeloTopComponent.jTextField272.text")); // NOI18N

        jTextField273.setText(org.openide.util.NbBundle.getMessage(modeloTopComponent.class, "modeloTopComponent.jTextField273.text")); // NOI18N

        javax.swing.GroupLayout jPanel62Layout = new javax.swing.GroupLayout(jPanel62);
        jPanel62.setLayout(jPanel62Layout);
        jPanel62Layout.setHorizontalGroup(
            jPanel62Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel62Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel62Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel184, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel62Layout.createSequentialGroup()
                        .addGroup(jPanel62Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jLabel186, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel185, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 1, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel62Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTextField132, javax.swing.GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE)
                            .addComponent(jTextField178))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel62Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jTextField172, javax.swing.GroupLayout.DEFAULT_SIZE, 80, Short.MAX_VALUE)
                    .addComponent(jTextField155)
                    .addComponent(jTextField268))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel62Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jTextField156, javax.swing.GroupLayout.DEFAULT_SIZE, 80, Short.MAX_VALUE)
                    .addComponent(jTextField173)
                    .addComponent(jTextField269))
                .addGap(6, 6, 6)
                .addGroup(jPanel62Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jTextField174)
                    .addComponent(jTextField157, javax.swing.GroupLayout.DEFAULT_SIZE, 80, Short.MAX_VALUE)
                    .addComponent(jTextField270))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel62Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jTextField158, javax.swing.GroupLayout.DEFAULT_SIZE, 80, Short.MAX_VALUE)
                    .addComponent(jTextField175)
                    .addComponent(jTextField271))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel62Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jTextField176, javax.swing.GroupLayout.DEFAULT_SIZE, 83, Short.MAX_VALUE)
                    .addComponent(jTextField159, javax.swing.GroupLayout.DEFAULT_SIZE, 83, Short.MAX_VALUE)
                    .addComponent(jTextField272))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel62Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jTextField177)
                    .addComponent(jTextField160, javax.swing.GroupLayout.DEFAULT_SIZE, 80, Short.MAX_VALUE)
                    .addComponent(jTextField273))
                .addGap(30, 30, 30))
        );
        jPanel62Layout.setVerticalGroup(
            jPanel62Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel62Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel62Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel184)
                    .addComponent(jTextField268, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField269, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField270, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField271, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField272, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField273, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 12, Short.MAX_VALUE)
                .addGroup(jPanel62Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField172, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField173, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField174, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField175, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField176, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField177, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel186)
                    .addComponent(jTextField178, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel62Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel185)
                    .addComponent(jTextField132, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField155, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField156, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField157, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField158, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField159, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField160, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        org.openide.awt.Mnemonics.setLocalizedText(jLabel197, org.openide.util.NbBundle.getMessage(modeloTopComponent.class, "modeloTopComponent.jLabel197.text")); // NOI18N

        jTextField133.setBackground(new java.awt.Color(255, 255, 204));
        jTextField133.setText(org.openide.util.NbBundle.getMessage(modeloTopComponent.class, "modeloTopComponent.jTextField133.text")); // NOI18N

        jTextField167.setBackground(new java.awt.Color(255, 255, 204));
        jTextField167.setText(org.openide.util.NbBundle.getMessage(modeloTopComponent.class, "modeloTopComponent.jTextField167.text")); // NOI18N
        jTextField167.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField167ActionPerformed(evt);
            }
        });

        jTextField168.setBackground(new java.awt.Color(255, 255, 204));
        jTextField168.setText(org.openide.util.NbBundle.getMessage(modeloTopComponent.class, "modeloTopComponent.jTextField168.text")); // NOI18N
        jTextField168.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField168ActionPerformed(evt);
            }
        });

        jTextField169.setBackground(new java.awt.Color(255, 255, 204));
        jTextField169.setText(org.openide.util.NbBundle.getMessage(modeloTopComponent.class, "modeloTopComponent.jTextField169.text")); // NOI18N

        jTextField170.setBackground(new java.awt.Color(255, 255, 204));
        jTextField170.setText(org.openide.util.NbBundle.getMessage(modeloTopComponent.class, "modeloTopComponent.jTextField170.text")); // NOI18N

        jTextField171.setBackground(new java.awt.Color(255, 255, 204));
        jTextField171.setText(org.openide.util.NbBundle.getMessage(modeloTopComponent.class, "modeloTopComponent.jTextField171.text")); // NOI18N
        jTextField171.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField171ActionPerformed(evt);
            }
        });

        jTextField184.setBackground(new java.awt.Color(255, 255, 204));
        jTextField184.setText(org.openide.util.NbBundle.getMessage(modeloTopComponent.class, "modeloTopComponent.jTextField184.text")); // NOI18N

        jTextField183.setBackground(new java.awt.Color(255, 255, 204));
        jTextField183.setText(org.openide.util.NbBundle.getMessage(modeloTopComponent.class, "modeloTopComponent.jTextField183.text")); // NOI18N

        jTextField182.setBackground(new java.awt.Color(255, 255, 204));
        jTextField182.setText(org.openide.util.NbBundle.getMessage(modeloTopComponent.class, "modeloTopComponent.jTextField182.text")); // NOI18N

        jTextField181.setBackground(new java.awt.Color(255, 255, 204));
        jTextField181.setText(org.openide.util.NbBundle.getMessage(modeloTopComponent.class, "modeloTopComponent.jTextField181.text")); // NOI18N

        jTextField180.setBackground(new java.awt.Color(255, 255, 204));
        jTextField180.setText(org.openide.util.NbBundle.getMessage(modeloTopComponent.class, "modeloTopComponent.jTextField180.text")); // NOI18N

        jTextField179.setBackground(new java.awt.Color(255, 255, 204));
        jTextField179.setText(org.openide.util.NbBundle.getMessage(modeloTopComponent.class, "modeloTopComponent.jTextField179.text")); // NOI18N

        org.openide.awt.Mnemonics.setLocalizedText(jLabel198, org.openide.util.NbBundle.getMessage(modeloTopComponent.class, "modeloTopComponent.jLabel198.text")); // NOI18N

        org.openide.awt.Mnemonics.setLocalizedText(jLabel193, org.openide.util.NbBundle.getMessage(modeloTopComponent.class, "modeloTopComponent.jLabel193.text")); // NOI18N

        jTextField141.setBackground(new java.awt.Color(255, 255, 204));
        jTextField141.setText(org.openide.util.NbBundle.getMessage(modeloTopComponent.class, "modeloTopComponent.jTextField141.text")); // NOI18N

        jTextField142.setBackground(new java.awt.Color(255, 255, 204));
        jTextField142.setText(org.openide.util.NbBundle.getMessage(modeloTopComponent.class, "modeloTopComponent.jTextField142.text")); // NOI18N

        jTextField143.setBackground(new java.awt.Color(255, 255, 204));
        jTextField143.setText(org.openide.util.NbBundle.getMessage(modeloTopComponent.class, "modeloTopComponent.jTextField143.text")); // NOI18N

        jTextField144.setBackground(new java.awt.Color(255, 255, 204));
        jTextField144.setText(org.openide.util.NbBundle.getMessage(modeloTopComponent.class, "modeloTopComponent.jTextField144.text")); // NOI18N

        jTextField145.setBackground(new java.awt.Color(255, 255, 204));
        jTextField145.setText(org.openide.util.NbBundle.getMessage(modeloTopComponent.class, "modeloTopComponent.jTextField145.text")); // NOI18N

        jTextField146.setBackground(new java.awt.Color(255, 255, 204));
        jTextField146.setText(org.openide.util.NbBundle.getMessage(modeloTopComponent.class, "modeloTopComponent.jTextField146.text")); // NOI18N
        jTextField146.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField146ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel61Layout = new javax.swing.GroupLayout(jPanel61);
        jPanel61.setLayout(jPanel61Layout);
        jPanel61Layout.setHorizontalGroup(
            jPanel61Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel61Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(jPanel61Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel198, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel197, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel193, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel61Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jTextField141)
                    .addComponent(jTextField133)
                    .addComponent(jTextField179))
                .addGap(6, 6, 6)
                .addGroup(jPanel61Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jTextField142)
                    .addComponent(jTextField167)
                    .addComponent(jTextField180))
                .addGap(6, 6, 6)
                .addGroup(jPanel61Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jTextField143)
                    .addComponent(jTextField168)
                    .addComponent(jTextField181, javax.swing.GroupLayout.DEFAULT_SIZE, 80, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel61Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel61Layout.createSequentialGroup()
                        .addGroup(jPanel61Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jTextField169)
                            .addComponent(jTextField182, javax.swing.GroupLayout.DEFAULT_SIZE, 80, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel61Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jTextField183, javax.swing.GroupLayout.DEFAULT_SIZE, 80, Short.MAX_VALUE)
                            .addComponent(jTextField170)))
                    .addGroup(jPanel61Layout.createSequentialGroup()
                        .addComponent(jTextField144, javax.swing.GroupLayout.DEFAULT_SIZE, 79, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextField145, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel61Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jTextField171)
                    .addComponent(jTextField184)
                    .addComponent(jTextField146, javax.swing.GroupLayout.DEFAULT_SIZE, 85, Short.MAX_VALUE))
                .addGap(31, 31, 31))
        );
        jPanel61Layout.setVerticalGroup(
            jPanel61Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel61Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel61Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel197)
                    .addComponent(jTextField133, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField167, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField168, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField169, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField170, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField171, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel61Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel198)
                    .addComponent(jTextField180, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField181, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField182, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField183, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField184, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField179, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel61Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel61Layout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addComponent(jLabel193))
                    .addGroup(jPanel61Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jTextField142, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jTextField143, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jTextField144, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jTextField145, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jTextField146, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jTextField141, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(16, Short.MAX_VALUE))
        );

        org.openide.awt.Mnemonics.setLocalizedText(jCheckBox12, org.openide.util.NbBundle.getMessage(modeloTopComponent.class, "modeloTopComponent.jCheckBox12.text")); // NOI18N

        javax.swing.GroupLayout jPanel56Layout = new javax.swing.GroupLayout(jPanel56);
        jPanel56.setLayout(jPanel56Layout);
        jPanel56Layout.setHorizontalGroup(
            jPanel56Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel56Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jPanel56Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jLabel194, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel183, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 1, Short.MAX_VALUE)
                    .addComponent(jLabel182, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel181, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel56Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel195, javax.swing.GroupLayout.DEFAULT_SIZE, 104, Short.MAX_VALUE)
                    .addComponent(jTextField129)
                    .addComponent(jTextField130)
                    .addComponent(jTextField131))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel56Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel56Layout.createSequentialGroup()
                        .addGroup(jPanel56Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel56Layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(jTextField147, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(8, 8, 8))
                            .addGroup(jPanel56Layout.createSequentialGroup()
                                .addGroup(jPanel56Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(jTextField149, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jTextField134, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel56Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jTextField150)
                                    .addComponent(jTextField135))))
                        .addGroup(jPanel56Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel56Layout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addComponent(jTextField151, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel56Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jTextField152, javax.swing.GroupLayout.DEFAULT_SIZE, 80, Short.MAX_VALUE)
                                    .addComponent(jTextField137, javax.swing.GroupLayout.Alignment.TRAILING))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel56Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jTextField153, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jTextField138, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel56Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jTextField139, javax.swing.GroupLayout.DEFAULT_SIZE, 80, Short.MAX_VALUE)
                                    .addComponent(jTextField154)))
                            .addGroup(jPanel56Layout.createSequentialGroup()
                                .addGap(22, 22, 22)
                                .addGroup(jPanel56Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel56Layout.createSequentialGroup()
                                        .addGap(10, 10, 10)
                                        .addComponent(jLabel189, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel56Layout.createSequentialGroup()
                                        .addComponent(jLabel196)
                                        .addGap(12, 12, 12)
                                        .addComponent(jTextField148, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(38, 38, 38)
                                        .addComponent(jLabel199)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jTextField185, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel56Layout.createSequentialGroup()
                        .addGap(177, 177, 177)
                        .addComponent(jTextField136)
                        .addGap(261, 261, 261))
                    .addGroup(jPanel56Layout.createSequentialGroup()
                        .addGap(25, 25, 25)
                        .addComponent(jLabel187, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(65, 65, 65)
                        .addComponent(jLabel188, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(jPanel56Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel56Layout.createSequentialGroup()
                                .addGap(140, 140, 140)
                                .addComponent(jLabel190, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(61, 61, 61)
                                .addComponent(jLabel191, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(jPanel56Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel192, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(29, 29, 29))))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel56Layout.createSequentialGroup()
                        .addComponent(jCheckBox12, javax.swing.GroupLayout.PREFERRED_SIZE, 268, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton22, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(136, 136, 136))
            .addGroup(jPanel56Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel56Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel62, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel61, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(84, Short.MAX_VALUE))
        );
        jPanel56Layout.setVerticalGroup(
            jPanel56Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel56Layout.createSequentialGroup()
                .addGroup(jPanel56Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel56Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel194)
                        .addComponent(jLabel195))
                    .addGroup(jPanel56Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jTextField147, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel196)
                        .addComponent(jTextField148, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel199)
                        .addComponent(jTextField185, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel56Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel56Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel190)
                        .addComponent(jLabel189)
                        .addComponent(jLabel191)
                        .addComponent(jLabel192)
                        .addComponent(jLabel188))
                    .addComponent(jLabel187))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel56Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField129, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel181)
                    .addComponent(jTextField134, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField135, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField136, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField137, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField138, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField139, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel56Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField130, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel182)
                    .addComponent(jTextField149, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField150, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField151, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField152, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField153, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField154, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel56Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField131, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel183)
                    .addComponent(jButton22)
                    .addComponent(jCheckBox12))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel62, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel61, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTabbedPane10.addTab(org.openide.util.NbBundle.getMessage(modeloTopComponent.class, "modeloTopComponent.jPanel56.TabConstraints.tabTitle"), jPanel56); // NOI18N

        jPanel63.setBackground(new java.awt.Color(255, 255, 255));

        jLabel203.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        org.openide.awt.Mnemonics.setLocalizedText(jLabel203, org.openide.util.NbBundle.getMessage(modeloTopComponent.class, "modeloTopComponent.jLabel203.text")); // NOI18N

        org.openide.awt.Mnemonics.setLocalizedText(jLabel204, org.openide.util.NbBundle.getMessage(modeloTopComponent.class, "modeloTopComponent.jLabel204.text")); // NOI18N

        jTextField161.setBackground(new java.awt.Color(255, 255, 204));

        org.openide.awt.Mnemonics.setLocalizedText(jLabel205, org.openide.util.NbBundle.getMessage(modeloTopComponent.class, "modeloTopComponent.jLabel205.text")); // NOI18N

        jTextField162.setBackground(new java.awt.Color(255, 255, 204));

        org.openide.awt.Mnemonics.setLocalizedText(jLabel206, org.openide.util.NbBundle.getMessage(modeloTopComponent.class, "modeloTopComponent.jLabel206.text")); // NOI18N

        jTextField186.setText(org.openide.util.NbBundle.getMessage(modeloTopComponent.class, "modeloTopComponent.jTextField186.text")); // NOI18N

        javax.swing.GroupLayout jPanel63Layout = new javax.swing.GroupLayout(jPanel63);
        jPanel63.setLayout(jPanel63Layout);
        jPanel63Layout.setHorizontalGroup(
            jPanel63Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel63Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel203, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel204, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(25, 25, 25)
                .addComponent(jTextField161)
                .addGap(22, 22, 22)
                .addComponent(jLabel205)
                .addGap(12, 12, 12)
                .addComponent(jTextField162, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(38, 38, 38)
                .addComponent(jLabel206)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextField186, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(182, 182, 182))
        );
        jPanel63Layout.setVerticalGroup(
            jPanel63Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel63Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel63Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel63Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel203)
                        .addComponent(jLabel204))
                    .addGroup(jPanel63Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jTextField161, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel205)
                        .addComponent(jTextField162, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel206)
                        .addComponent(jTextField186, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        org.openide.awt.Mnemonics.setLocalizedText(jLabel207, org.openide.util.NbBundle.getMessage(modeloTopComponent.class, "modeloTopComponent.jLabel207.text")); // NOI18N

        org.openide.awt.Mnemonics.setLocalizedText(jLabel208, org.openide.util.NbBundle.getMessage(modeloTopComponent.class, "modeloTopComponent.jLabel208.text")); // NOI18N

        org.openide.awt.Mnemonics.setLocalizedText(jLabel209, org.openide.util.NbBundle.getMessage(modeloTopComponent.class, "modeloTopComponent.jLabel209.text")); // NOI18N

        jTextField140.setBackground(new java.awt.Color(204, 204, 255));
        jTextField140.setText(org.openide.util.NbBundle.getMessage(modeloTopComponent.class, "modeloTopComponent.jTextField140.text")); // NOI18N

        jTextField163.setBackground(new java.awt.Color(204, 204, 255));
        jTextField163.setText(org.openide.util.NbBundle.getMessage(modeloTopComponent.class, "modeloTopComponent.jTextField163.text")); // NOI18N

        jTextField164.setBackground(new java.awt.Color(204, 204, 255));
        jTextField164.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jTextField164.setText(org.openide.util.NbBundle.getMessage(modeloTopComponent.class, "modeloTopComponent.jTextField164.text")); // NOI18N
        jTextField164.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField164ActionPerformed(evt);
            }
        });

        org.openide.awt.Mnemonics.setLocalizedText(jLabel210, org.openide.util.NbBundle.getMessage(modeloTopComponent.class, "modeloTopComponent.jLabel210.text")); // NOI18N

        org.openide.awt.Mnemonics.setLocalizedText(jLabel211, org.openide.util.NbBundle.getMessage(modeloTopComponent.class, "modeloTopComponent.jLabel211.text")); // NOI18N

        org.openide.awt.Mnemonics.setLocalizedText(jLabel212, org.openide.util.NbBundle.getMessage(modeloTopComponent.class, "modeloTopComponent.jLabel212.text")); // NOI18N

        jTextField165.setText(org.openide.util.NbBundle.getMessage(modeloTopComponent.class, "modeloTopComponent.jTextField165.text")); // NOI18N
        jTextField165.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField165ActionPerformed(evt);
            }
        });

        jTextField166.setText(org.openide.util.NbBundle.getMessage(modeloTopComponent.class, "modeloTopComponent.jTextField166.text")); // NOI18N

        jTextField187.setText(org.openide.util.NbBundle.getMessage(modeloTopComponent.class, "modeloTopComponent.jTextField187.text")); // NOI18N

        jTextField188.setText(org.openide.util.NbBundle.getMessage(modeloTopComponent.class, "modeloTopComponent.jTextField188.text")); // NOI18N

        jTextField189.setText(org.openide.util.NbBundle.getMessage(modeloTopComponent.class, "modeloTopComponent.jTextField189.text")); // NOI18N

        jTextField190.setText(org.openide.util.NbBundle.getMessage(modeloTopComponent.class, "modeloTopComponent.jTextField190.text")); // NOI18N

        org.openide.awt.Mnemonics.setLocalizedText(jLabel213, org.openide.util.NbBundle.getMessage(modeloTopComponent.class, "modeloTopComponent.jLabel213.text")); // NOI18N

        org.openide.awt.Mnemonics.setLocalizedText(jLabel214, org.openide.util.NbBundle.getMessage(modeloTopComponent.class, "modeloTopComponent.jLabel214.text")); // NOI18N

        org.openide.awt.Mnemonics.setLocalizedText(jLabel215, org.openide.util.NbBundle.getMessage(modeloTopComponent.class, "modeloTopComponent.jLabel215.text")); // NOI18N

        jTextField191.setBackground(new java.awt.Color(204, 204, 255));
        jTextField191.setText(org.openide.util.NbBundle.getMessage(modeloTopComponent.class, "modeloTopComponent.jTextField191.text")); // NOI18N

        jTextField192.setBackground(new java.awt.Color(204, 204, 255));
        jTextField192.setText(org.openide.util.NbBundle.getMessage(modeloTopComponent.class, "modeloTopComponent.jTextField192.text")); // NOI18N

        jTextField193.setText(org.openide.util.NbBundle.getMessage(modeloTopComponent.class, "modeloTopComponent.jTextField193.text")); // NOI18N

        jTextField194.setText(org.openide.util.NbBundle.getMessage(modeloTopComponent.class, "modeloTopComponent.jTextField194.text")); // NOI18N
        jTextField194.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField194ActionPerformed(evt);
            }
        });

        jTextField195.setText(org.openide.util.NbBundle.getMessage(modeloTopComponent.class, "modeloTopComponent.jTextField195.text")); // NOI18N

        jTextField196.setText(org.openide.util.NbBundle.getMessage(modeloTopComponent.class, "modeloTopComponent.jTextField196.text")); // NOI18N

        jTextField197.setText(org.openide.util.NbBundle.getMessage(modeloTopComponent.class, "modeloTopComponent.jTextField197.text")); // NOI18N
        jTextField197.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField197ActionPerformed(evt);
            }
        });

        jTextField198.setText(org.openide.util.NbBundle.getMessage(modeloTopComponent.class, "modeloTopComponent.jTextField198.text")); // NOI18N

        jTextField274.setText(org.openide.util.NbBundle.getMessage(modeloTopComponent.class, "modeloTopComponent.jTextField274.text")); // NOI18N

        jTextField275.setText(org.openide.util.NbBundle.getMessage(modeloTopComponent.class, "modeloTopComponent.jTextField275.text")); // NOI18N

        org.openide.awt.Mnemonics.setLocalizedText(jLabel219, org.openide.util.NbBundle.getMessage(modeloTopComponent.class, "modeloTopComponent.jLabel219.text")); // NOI18N

        jTextField208.setText(org.openide.util.NbBundle.getMessage(modeloTopComponent.class, "modeloTopComponent.jTextField208.text")); // NOI18N

        jTextField209.setText(org.openide.util.NbBundle.getMessage(modeloTopComponent.class, "modeloTopComponent.jTextField209.text")); // NOI18N

        jTextField210.setText(org.openide.util.NbBundle.getMessage(modeloTopComponent.class, "modeloTopComponent.jTextField210.text")); // NOI18N

        jTextField276.setText(org.openide.util.NbBundle.getMessage(modeloTopComponent.class, "modeloTopComponent.jTextField276.text")); // NOI18N

        org.openide.awt.Mnemonics.setLocalizedText(jCheckBox8, org.openide.util.NbBundle.getMessage(modeloTopComponent.class, "modeloTopComponent.jCheckBox8.text")); // NOI18N

        javax.swing.GroupLayout jPanel65Layout = new javax.swing.GroupLayout(jPanel65);
        jPanel65.setLayout(jPanel65Layout);
        jPanel65Layout.setHorizontalGroup(
            jPanel65Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel65Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel65Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel65Layout.createSequentialGroup()
                        .addComponent(jLabel219, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(235, 235, 235))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel65Layout.createSequentialGroup()
                        .addGroup(jPanel65Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel213, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel65Layout.createSequentialGroup()
                                .addGroup(jPanel65Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(jLabel214, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel215, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel65Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jTextField192)
                                    .addComponent(jTextField191))))
                        .addGap(29, 29, 29)
                        .addGroup(jPanel65Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jTextField193, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 80, Short.MAX_VALUE)
                            .addComponent(jTextField198, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 80, Short.MAX_VALUE)
                            .addComponent(jTextField208, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 80, Short.MAX_VALUE)
                            .addComponent(jTextField274, javax.swing.GroupLayout.Alignment.LEADING))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                .addGroup(jPanel65Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jTextField194, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 80, Short.MAX_VALUE)
                    .addComponent(jTextField197, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 80, Short.MAX_VALUE)
                    .addComponent(jTextField209)
                    .addComponent(jTextField275))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel65Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jTextField196, javax.swing.GroupLayout.DEFAULT_SIZE, 80, Short.MAX_VALUE)
                    .addComponent(jTextField195, javax.swing.GroupLayout.DEFAULT_SIZE, 80, Short.MAX_VALUE)
                    .addComponent(jTextField210)
                    .addComponent(jTextField276))
                .addGap(33, 33, 33)
                .addComponent(jCheckBox8, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(205, 205, 205))
        );
        jPanel65Layout.setVerticalGroup(
            jPanel65Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel65Layout.createSequentialGroup()
                .addGroup(jPanel65Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel65Layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel213))
                    .addGroup(jPanel65Layout.createSequentialGroup()
                        .addGroup(jPanel65Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jTextField274, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextField275, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextField276, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel65Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField193, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField194, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField195, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel214)
                    .addComponent(jTextField191, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel65Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel215)
                    .addComponent(jTextField192, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField198, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField197, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField196, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jCheckBox8))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel65Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel219)
                    .addComponent(jTextField208, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField209, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField210, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );

        org.openide.awt.Mnemonics.setLocalizedText(jButton24, org.openide.util.NbBundle.getMessage(modeloTopComponent.class, "modeloTopComponent.jButton24.text")); // NOI18N
        jButton24.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton24ActionPerformed(evt);
            }
        });

        org.openide.awt.Mnemonics.setLocalizedText(jCheckBox11, org.openide.util.NbBundle.getMessage(modeloTopComponent.class, "modeloTopComponent.jCheckBox11.text")); // NOI18N

        javax.swing.GroupLayout jPanel64Layout = new javax.swing.GroupLayout(jPanel64);
        jPanel64.setLayout(jPanel64Layout);
        jPanel64Layout.setHorizontalGroup(
            jPanel64Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel64Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel64Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jLabel209, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel208, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel207, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel64Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jTextField140)
                    .addComponent(jTextField163)
                    .addComponent(jTextField164, javax.swing.GroupLayout.DEFAULT_SIZE, 90, Short.MAX_VALUE))
                .addGroup(jPanel64Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel64Layout.createSequentialGroup()
                        .addGap(28, 28, 28)
                        .addGroup(jPanel64Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel64Layout.createSequentialGroup()
                                .addGap(27, 27, 27)
                                .addComponent(jLabel210, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(65, 65, 65)
                                .addComponent(jLabel211, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(51, 51, 51)
                                .addComponent(jLabel212, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel64Layout.createSequentialGroup()
                                .addGroup(jPanel64Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(jPanel64Layout.createSequentialGroup()
                                        .addComponent(jTextField187, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jTextField166, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel64Layout.createSequentialGroup()
                                        .addComponent(jTextField188, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jTextField189, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel64Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jTextField165, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jTextField190, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(18, 18, 18)
                        .addComponent(jCheckBox11, javax.swing.GroupLayout.PREFERRED_SIZE, 236, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel64Layout.createSequentialGroup()
                        .addGap(294, 294, 294)
                        .addComponent(jButton24, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(139, Short.MAX_VALUE))
            .addComponent(jPanel65, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel64Layout.setVerticalGroup(
            jPanel64Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel64Layout.createSequentialGroup()
                .addGroup(jPanel64Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel212)
                    .addComponent(jLabel211)
                    .addComponent(jLabel210))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel64Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField140, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel207)
                    .addComponent(jTextField187, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField166, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField165, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jCheckBox11))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel64Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField163, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel208)
                    .addComponent(jTextField188, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField189, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField190, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel64Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField164, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel209)
                    .addComponent(jButton24))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel65, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        org.openide.awt.Mnemonics.setLocalizedText(jLabel216, org.openide.util.NbBundle.getMessage(modeloTopComponent.class, "modeloTopComponent.jLabel216.text")); // NOI18N

        org.openide.awt.Mnemonics.setLocalizedText(jLabel217, org.openide.util.NbBundle.getMessage(modeloTopComponent.class, "modeloTopComponent.jLabel217.text")); // NOI18N

        org.openide.awt.Mnemonics.setLocalizedText(jLabel218, org.openide.util.NbBundle.getMessage(modeloTopComponent.class, "modeloTopComponent.jLabel218.text")); // NOI18N

        jTextField199.setBackground(new java.awt.Color(255, 255, 204));
        jTextField199.setText(org.openide.util.NbBundle.getMessage(modeloTopComponent.class, "modeloTopComponent.jTextField199.text")); // NOI18N

        jTextField200.setBackground(new java.awt.Color(255, 255, 204));
        jTextField200.setText(org.openide.util.NbBundle.getMessage(modeloTopComponent.class, "modeloTopComponent.jTextField200.text")); // NOI18N
        jTextField200.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField200ActionPerformed(evt);
            }
        });

        jTextField201.setBackground(new java.awt.Color(255, 255, 204));
        jTextField201.setText(org.openide.util.NbBundle.getMessage(modeloTopComponent.class, "modeloTopComponent.jTextField201.text")); // NOI18N
        jTextField201.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField201ActionPerformed(evt);
            }
        });

        jTextField202.setBackground(new java.awt.Color(255, 255, 204));
        jTextField202.setText(org.openide.util.NbBundle.getMessage(modeloTopComponent.class, "modeloTopComponent.jTextField202.text")); // NOI18N

        jTextField203.setBackground(new java.awt.Color(255, 255, 204));
        jTextField203.setText(org.openide.util.NbBundle.getMessage(modeloTopComponent.class, "modeloTopComponent.jTextField203.text")); // NOI18N

        jTextField204.setBackground(new java.awt.Color(255, 255, 204));
        jTextField204.setText(org.openide.util.NbBundle.getMessage(modeloTopComponent.class, "modeloTopComponent.jTextField204.text")); // NOI18N

        jTextField205.setBackground(new java.awt.Color(255, 255, 204));
        jTextField205.setText(org.openide.util.NbBundle.getMessage(modeloTopComponent.class, "modeloTopComponent.jTextField205.text")); // NOI18N
        jTextField205.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField205ActionPerformed(evt);
            }
        });

        jTextField206.setBackground(new java.awt.Color(255, 255, 204));
        jTextField206.setText(org.openide.util.NbBundle.getMessage(modeloTopComponent.class, "modeloTopComponent.jTextField206.text")); // NOI18N
        jTextField206.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField206ActionPerformed(evt);
            }
        });

        jTextField207.setBackground(new java.awt.Color(255, 255, 204));
        jTextField207.setText(org.openide.util.NbBundle.getMessage(modeloTopComponent.class, "modeloTopComponent.jTextField207.text")); // NOI18N

        javax.swing.GroupLayout jPanel66Layout = new javax.swing.GroupLayout(jPanel66);
        jPanel66.setLayout(jPanel66Layout);
        jPanel66Layout.setHorizontalGroup(
            jPanel66Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel66Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel66Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel217, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel216, javax.swing.GroupLayout.DEFAULT_SIZE, 284, Short.MAX_VALUE)
                    .addComponent(jLabel218, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel66Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jTextField205)
                    .addComponent(jTextField199)
                    .addComponent(jTextField204, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(6, 6, 6)
                .addGroup(jPanel66Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jTextField206)
                    .addComponent(jTextField200)
                    .addComponent(jTextField203, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(6, 6, 6)
                .addGroup(jPanel66Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jTextField207)
                    .addComponent(jTextField201)
                    .addComponent(jTextField202, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(407, 407, 407))
        );
        jPanel66Layout.setVerticalGroup(
            jPanel66Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel66Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel66Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel216)
                    .addComponent(jTextField199, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField200, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField201, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel66Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel217)
                    .addComponent(jTextField203, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField202, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField204, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel66Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel66Layout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addComponent(jLabel218))
                    .addGroup(jPanel66Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jTextField206, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jTextField207, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jTextField205, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel59Layout = new javax.swing.GroupLayout(jPanel59);
        jPanel59.setLayout(jPanel59Layout);
        jPanel59Layout.setHorizontalGroup(
            jPanel59Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel63, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel64, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel66, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel59Layout.setVerticalGroup(
            jPanel59Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel59Layout.createSequentialGroup()
                .addComponent(jPanel63, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel64, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel66, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(16, 16, 16))
        );

        jTabbedPane10.addTab(org.openide.util.NbBundle.getMessage(modeloTopComponent.class, "modeloTopComponent.jPanel59.TabConstraints.tabTitle"), jPanel59); // NOI18N

        jPanel68.setBackground(new java.awt.Color(255, 255, 255));

        jLabel221.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        org.openide.awt.Mnemonics.setLocalizedText(jLabel221, org.openide.util.NbBundle.getMessage(modeloTopComponent.class, "modeloTopComponent.jLabel221.text")); // NOI18N

        org.openide.awt.Mnemonics.setLocalizedText(jLabel222, org.openide.util.NbBundle.getMessage(modeloTopComponent.class, "modeloTopComponent.jLabel222.text")); // NOI18N

        jTextField211.setBackground(new java.awt.Color(255, 255, 204));

        org.openide.awt.Mnemonics.setLocalizedText(jLabel223, org.openide.util.NbBundle.getMessage(modeloTopComponent.class, "modeloTopComponent.jLabel223.text")); // NOI18N

        jTextField212.setBackground(new java.awt.Color(255, 255, 204));

        org.openide.awt.Mnemonics.setLocalizedText(jLabel224, org.openide.util.NbBundle.getMessage(modeloTopComponent.class, "modeloTopComponent.jLabel224.text")); // NOI18N

        jTextField213.setText(org.openide.util.NbBundle.getMessage(modeloTopComponent.class, "modeloTopComponent.jTextField213.text")); // NOI18N

        javax.swing.GroupLayout jPanel68Layout = new javax.swing.GroupLayout(jPanel68);
        jPanel68.setLayout(jPanel68Layout);
        jPanel68Layout.setHorizontalGroup(
            jPanel68Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel68Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel221, javax.swing.GroupLayout.DEFAULT_SIZE, 147, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel222, javax.swing.GroupLayout.DEFAULT_SIZE, 130, Short.MAX_VALUE)
                .addGap(25, 25, 25)
                .addComponent(jTextField211, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(62, 62, 62)
                .addComponent(jLabel223)
                .addGap(12, 12, 12)
                .addComponent(jTextField212, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(38, 38, 38)
                .addComponent(jLabel224)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextField213, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(182, 182, 182))
        );
        jPanel68Layout.setVerticalGroup(
            jPanel68Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel68Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel68Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel68Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel221)
                        .addComponent(jLabel222))
                    .addGroup(jPanel68Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jTextField211, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel223)
                        .addComponent(jTextField212, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel224)
                        .addComponent(jTextField213, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        org.openide.awt.Mnemonics.setLocalizedText(jLabel225, org.openide.util.NbBundle.getMessage(modeloTopComponent.class, "modeloTopComponent.jLabel225.text")); // NOI18N

        org.openide.awt.Mnemonics.setLocalizedText(jLabel226, org.openide.util.NbBundle.getMessage(modeloTopComponent.class, "modeloTopComponent.jLabel226.text")); // NOI18N

        org.openide.awt.Mnemonics.setLocalizedText(jLabel227, org.openide.util.NbBundle.getMessage(modeloTopComponent.class, "modeloTopComponent.jLabel227.text")); // NOI18N

        jTextField214.setBackground(new java.awt.Color(204, 204, 255));
        jTextField214.setText(org.openide.util.NbBundle.getMessage(modeloTopComponent.class, "modeloTopComponent.jTextField214.text")); // NOI18N

        jTextField215.setBackground(new java.awt.Color(204, 204, 255));
        jTextField215.setText(org.openide.util.NbBundle.getMessage(modeloTopComponent.class, "modeloTopComponent.jTextField215.text")); // NOI18N

        jTextField216.setBackground(new java.awt.Color(204, 204, 255));
        jTextField216.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jTextField216.setText(org.openide.util.NbBundle.getMessage(modeloTopComponent.class, "modeloTopComponent.jTextField216.text")); // NOI18N
        jTextField216.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField216ActionPerformed(evt);
            }
        });

        org.openide.awt.Mnemonics.setLocalizedText(jLabel228, org.openide.util.NbBundle.getMessage(modeloTopComponent.class, "modeloTopComponent.jLabel228.text")); // NOI18N

        org.openide.awt.Mnemonics.setLocalizedText(jLabel229, org.openide.util.NbBundle.getMessage(modeloTopComponent.class, "modeloTopComponent.jLabel229.text")); // NOI18N

        org.openide.awt.Mnemonics.setLocalizedText(jLabel230, org.openide.util.NbBundle.getMessage(modeloTopComponent.class, "modeloTopComponent.jLabel230.text")); // NOI18N

        jTextField217.setText(org.openide.util.NbBundle.getMessage(modeloTopComponent.class, "modeloTopComponent.jTextField217.text")); // NOI18N
        jTextField217.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField217ActionPerformed(evt);
            }
        });

        jTextField218.setText(org.openide.util.NbBundle.getMessage(modeloTopComponent.class, "modeloTopComponent.jTextField218.text")); // NOI18N

        jTextField219.setText(org.openide.util.NbBundle.getMessage(modeloTopComponent.class, "modeloTopComponent.jTextField219.text")); // NOI18N

        jTextField220.setText(org.openide.util.NbBundle.getMessage(modeloTopComponent.class, "modeloTopComponent.jTextField220.text")); // NOI18N

        jTextField221.setText(org.openide.util.NbBundle.getMessage(modeloTopComponent.class, "modeloTopComponent.jTextField221.text")); // NOI18N

        jTextField222.setText(org.openide.util.NbBundle.getMessage(modeloTopComponent.class, "modeloTopComponent.jTextField222.text")); // NOI18N

        org.openide.awt.Mnemonics.setLocalizedText(jButton25, org.openide.util.NbBundle.getMessage(modeloTopComponent.class, "modeloTopComponent.jButton25.text")); // NOI18N
        jButton25.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton25ActionPerformed(evt);
            }
        });

        org.openide.awt.Mnemonics.setLocalizedText(jCheckBox10, org.openide.util.NbBundle.getMessage(modeloTopComponent.class, "modeloTopComponent.jCheckBox10.text")); // NOI18N

        javax.swing.GroupLayout jPanel69Layout = new javax.swing.GroupLayout(jPanel69);
        jPanel69.setLayout(jPanel69Layout);
        jPanel69Layout.setHorizontalGroup(
            jPanel69Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel69Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel69Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jLabel227, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel226, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel225, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel69Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jTextField214)
                    .addComponent(jTextField215)
                    .addComponent(jTextField216, javax.swing.GroupLayout.DEFAULT_SIZE, 90, Short.MAX_VALUE))
                .addGroup(jPanel69Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel69Layout.createSequentialGroup()
                        .addGap(28, 28, 28)
                        .addGroup(jPanel69Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel69Layout.createSequentialGroup()
                                .addGap(27, 27, 27)
                                .addComponent(jLabel228, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(65, 65, 65)
                                .addComponent(jLabel229, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(51, 51, 51)
                                .addComponent(jLabel230, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel69Layout.createSequentialGroup()
                                .addGroup(jPanel69Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(jPanel69Layout.createSequentialGroup()
                                        .addComponent(jTextField220, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jTextField221, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel69Layout.createSequentialGroup()
                                        .addComponent(jTextField219, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jTextField218, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel69Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jTextField217, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jTextField222, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(18, 18, 18)
                        .addComponent(jCheckBox10, javax.swing.GroupLayout.PREFERRED_SIZE, 233, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel69Layout.createSequentialGroup()
                        .addGap(294, 294, 294)
                        .addComponent(jButton25, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(148, Short.MAX_VALUE))
        );
        jPanel69Layout.setVerticalGroup(
            jPanel69Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel69Layout.createSequentialGroup()
                .addGroup(jPanel69Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel230)
                    .addComponent(jLabel229)
                    .addComponent(jLabel228))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel69Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField214, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel225)
                    .addComponent(jTextField219, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField218, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField217, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jCheckBox10))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel69Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField215, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel226)
                    .addComponent(jTextField220, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField221, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField222, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel69Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField216, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel227)
                    .addComponent(jButton25)))
        );

        org.openide.awt.Mnemonics.setLocalizedText(jLabel231, org.openide.util.NbBundle.getMessage(modeloTopComponent.class, "modeloTopComponent.jLabel231.text")); // NOI18N

        org.openide.awt.Mnemonics.setLocalizedText(jLabel232, org.openide.util.NbBundle.getMessage(modeloTopComponent.class, "modeloTopComponent.jLabel232.text")); // NOI18N

        org.openide.awt.Mnemonics.setLocalizedText(jLabel233, org.openide.util.NbBundle.getMessage(modeloTopComponent.class, "modeloTopComponent.jLabel233.text")); // NOI18N

        jTextField223.setBackground(new java.awt.Color(204, 204, 255));
        jTextField223.setText(org.openide.util.NbBundle.getMessage(modeloTopComponent.class, "modeloTopComponent.jTextField223.text")); // NOI18N

        jTextField224.setBackground(new java.awt.Color(204, 204, 255));
        jTextField224.setText(org.openide.util.NbBundle.getMessage(modeloTopComponent.class, "modeloTopComponent.jTextField224.text")); // NOI18N

        jTextField225.setText(org.openide.util.NbBundle.getMessage(modeloTopComponent.class, "modeloTopComponent.jTextField225.text")); // NOI18N

        jTextField226.setText(org.openide.util.NbBundle.getMessage(modeloTopComponent.class, "modeloTopComponent.jTextField226.text")); // NOI18N
        jTextField226.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField226ActionPerformed(evt);
            }
        });

        jTextField227.setText(org.openide.util.NbBundle.getMessage(modeloTopComponent.class, "modeloTopComponent.jTextField227.text")); // NOI18N

        jTextField228.setText(org.openide.util.NbBundle.getMessage(modeloTopComponent.class, "modeloTopComponent.jTextField228.text")); // NOI18N

        jTextField229.setText(org.openide.util.NbBundle.getMessage(modeloTopComponent.class, "modeloTopComponent.jTextField229.text")); // NOI18N
        jTextField229.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField229ActionPerformed(evt);
            }
        });

        jTextField230.setText(org.openide.util.NbBundle.getMessage(modeloTopComponent.class, "modeloTopComponent.jTextField230.text")); // NOI18N

        org.openide.awt.Mnemonics.setLocalizedText(jLabel234, org.openide.util.NbBundle.getMessage(modeloTopComponent.class, "modeloTopComponent.jLabel234.text")); // NOI18N

        jTextField231.setText(org.openide.util.NbBundle.getMessage(modeloTopComponent.class, "modeloTopComponent.jTextField231.text")); // NOI18N

        jTextField232.setText(org.openide.util.NbBundle.getMessage(modeloTopComponent.class, "modeloTopComponent.jTextField232.text")); // NOI18N

        jTextField233.setText(org.openide.util.NbBundle.getMessage(modeloTopComponent.class, "modeloTopComponent.jTextField233.text")); // NOI18N

        jTextField277.setText(org.openide.util.NbBundle.getMessage(modeloTopComponent.class, "modeloTopComponent.jTextField277.text")); // NOI18N

        jTextField278.setText(org.openide.util.NbBundle.getMessage(modeloTopComponent.class, "modeloTopComponent.jTextField278.text")); // NOI18N
        jTextField278.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField278ActionPerformed(evt);
            }
        });

        jTextField279.setText(org.openide.util.NbBundle.getMessage(modeloTopComponent.class, "modeloTopComponent.jTextField279.text")); // NOI18N

        org.openide.awt.Mnemonics.setLocalizedText(jCheckBox9, org.openide.util.NbBundle.getMessage(modeloTopComponent.class, "modeloTopComponent.jCheckBox9.text")); // NOI18N

        javax.swing.GroupLayout jPanel70Layout = new javax.swing.GroupLayout(jPanel70);
        jPanel70.setLayout(jPanel70Layout);
        jPanel70Layout.setHorizontalGroup(
            jPanel70Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel70Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel70Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel70Layout.createSequentialGroup()
                        .addComponent(jLabel234, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(238, 238, 238))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel70Layout.createSequentialGroup()
                        .addGroup(jPanel70Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel70Layout.createSequentialGroup()
                                .addGroup(jPanel70Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(jLabel232, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel233, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel70Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jTextField224)
                                    .addComponent(jTextField223))
                                .addGap(29, 29, 29))
                            .addGroup(jPanel70Layout.createSequentialGroup()
                                .addComponent(jLabel231, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addGroup(jPanel70Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jTextField225, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextField230, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextField231, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextField277, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                .addGroup(jPanel70Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jTextField226, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 80, Short.MAX_VALUE)
                    .addComponent(jTextField229, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 80, Short.MAX_VALUE)
                    .addComponent(jTextField232)
                    .addComponent(jTextField278))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel70Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jTextField228, javax.swing.GroupLayout.DEFAULT_SIZE, 80, Short.MAX_VALUE)
                    .addComponent(jTextField227, javax.swing.GroupLayout.DEFAULT_SIZE, 80, Short.MAX_VALUE)
                    .addComponent(jTextField233)
                    .addComponent(jTextField279))
                .addGap(18, 18, 18)
                .addComponent(jCheckBox9, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(220, 220, 220))
        );
        jPanel70Layout.setVerticalGroup(
            jPanel70Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel70Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel70Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel231)
                    .addComponent(jTextField277, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField278, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField279, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel70Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField225, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField226, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField227, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel232)
                    .addComponent(jTextField223, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel70Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel233)
                    .addComponent(jTextField224, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField230, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField229, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField228, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jCheckBox9))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel70Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel234)
                    .addComponent(jTextField231, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField232, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField233, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );

        org.openide.awt.Mnemonics.setLocalizedText(jLabel235, org.openide.util.NbBundle.getMessage(modeloTopComponent.class, "modeloTopComponent.jLabel235.text")); // NOI18N

        org.openide.awt.Mnemonics.setLocalizedText(jLabel236, org.openide.util.NbBundle.getMessage(modeloTopComponent.class, "modeloTopComponent.jLabel236.text")); // NOI18N

        org.openide.awt.Mnemonics.setLocalizedText(jLabel237, org.openide.util.NbBundle.getMessage(modeloTopComponent.class, "modeloTopComponent.jLabel237.text")); // NOI18N

        jTextField234.setBackground(new java.awt.Color(255, 255, 204));
        jTextField234.setText(org.openide.util.NbBundle.getMessage(modeloTopComponent.class, "modeloTopComponent.jTextField234.text")); // NOI18N

        jTextField235.setBackground(new java.awt.Color(255, 255, 204));
        jTextField235.setText(org.openide.util.NbBundle.getMessage(modeloTopComponent.class, "modeloTopComponent.jTextField235.text")); // NOI18N
        jTextField235.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField235ActionPerformed(evt);
            }
        });

        jTextField236.setBackground(new java.awt.Color(255, 255, 204));
        jTextField236.setText(org.openide.util.NbBundle.getMessage(modeloTopComponent.class, "modeloTopComponent.jTextField236.text")); // NOI18N
        jTextField236.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField236ActionPerformed(evt);
            }
        });

        jTextField237.setBackground(new java.awt.Color(255, 255, 204));
        jTextField237.setText(org.openide.util.NbBundle.getMessage(modeloTopComponent.class, "modeloTopComponent.jTextField237.text")); // NOI18N

        jTextField238.setBackground(new java.awt.Color(255, 255, 204));
        jTextField238.setText(org.openide.util.NbBundle.getMessage(modeloTopComponent.class, "modeloTopComponent.jTextField238.text")); // NOI18N

        jTextField239.setBackground(new java.awt.Color(255, 255, 204));
        jTextField239.setText(org.openide.util.NbBundle.getMessage(modeloTopComponent.class, "modeloTopComponent.jTextField239.text")); // NOI18N

        jTextField240.setBackground(new java.awt.Color(255, 255, 204));
        jTextField240.setText(org.openide.util.NbBundle.getMessage(modeloTopComponent.class, "modeloTopComponent.jTextField240.text")); // NOI18N
        jTextField240.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField240ActionPerformed(evt);
            }
        });

        jTextField241.setBackground(new java.awt.Color(255, 255, 204));
        jTextField241.setText(org.openide.util.NbBundle.getMessage(modeloTopComponent.class, "modeloTopComponent.jTextField241.text")); // NOI18N

        jTextField242.setBackground(new java.awt.Color(255, 255, 204));
        jTextField242.setText(org.openide.util.NbBundle.getMessage(modeloTopComponent.class, "modeloTopComponent.jTextField242.text")); // NOI18N

        javax.swing.GroupLayout jPanel71Layout = new javax.swing.GroupLayout(jPanel71);
        jPanel71.setLayout(jPanel71Layout);
        jPanel71Layout.setHorizontalGroup(
            jPanel71Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel71Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel71Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel236, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel235, javax.swing.GroupLayout.DEFAULT_SIZE, 290, Short.MAX_VALUE)
                    .addComponent(jLabel237, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel71Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jTextField240)
                    .addComponent(jTextField234)
                    .addComponent(jTextField239, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(6, 6, 6)
                .addGroup(jPanel71Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jTextField241)
                    .addComponent(jTextField235)
                    .addComponent(jTextField238, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(6, 6, 6)
                .addGroup(jPanel71Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jTextField242)
                    .addComponent(jTextField236)
                    .addComponent(jTextField237, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(407, 407, 407))
        );
        jPanel71Layout.setVerticalGroup(
            jPanel71Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel71Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel71Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel235)
                    .addComponent(jTextField234, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField235, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField236, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel71Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel236)
                    .addComponent(jTextField238, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField237, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField239, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel71Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel71Layout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addComponent(jLabel237))
                    .addGroup(jPanel71Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jTextField241, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jTextField242, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jTextField240, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel67Layout = new javax.swing.GroupLayout(jPanel67);
        jPanel67.setLayout(jPanel67Layout);
        jPanel67Layout.setHorizontalGroup(
            jPanel67Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel68, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel67Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel67Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel69, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel70, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel71, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel67Layout.setVerticalGroup(
            jPanel67Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel67Layout.createSequentialGroup()
                .addComponent(jPanel68, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel69, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel70, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(3, 3, 3)
                .addComponent(jPanel71, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jTabbedPane10.addTab(org.openide.util.NbBundle.getMessage(modeloTopComponent.class, "modeloTopComponent.jPanel67.TabConstraints.tabTitle"), jPanel67); // NOI18N

        javax.swing.GroupLayout jPanel29Layout = new javax.swing.GroupLayout(jPanel29);
        jPanel29.setLayout(jPanel29Layout);
        jPanel29Layout.setHorizontalGroup(
            jPanel29Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel29Layout.createSequentialGroup()
                .addComponent(miBarra13, javax.swing.GroupLayout.PREFERRED_SIZE, 315, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTabbedPane10, javax.swing.GroupLayout.PREFERRED_SIZE, 965, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel29Layout.setVerticalGroup(
            jPanel29Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane10, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
            .addGroup(jPanel29Layout.createSequentialGroup()
                .addComponent(miBarra13, javax.swing.GroupLayout.PREFERRED_SIZE, 348, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 3, Short.MAX_VALUE))
        );

        miBarra14.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
        miBarra14.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);

        miTabla14.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        miBarra14.setViewportView(miTabla14);

        jTabbedPane9.addTab(org.openide.util.NbBundle.getMessage(modeloTopComponent.class, "modeloTopComponent.miBarra14.TabConstraints.tabTitle"), miBarra14); // NOI18N

        miBarra15.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
        miBarra15.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);

        miTabla16.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        miBarra15.setViewportView(miTabla16);

        javax.swing.GroupLayout jPanel57Layout = new javax.swing.GroupLayout(jPanel57);
        jPanel57.setLayout(jPanel57Layout);
        jPanel57Layout.setHorizontalGroup(
            jPanel57Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel57Layout.createSequentialGroup()
                .addComponent(miBarra15, javax.swing.GroupLayout.PREFERRED_SIZE, 1345, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel57Layout.setVerticalGroup(
            jPanel57Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(miBarra15, javax.swing.GroupLayout.DEFAULT_SIZE, 417, Short.MAX_VALUE)
        );

        jTabbedPane9.addTab(org.openide.util.NbBundle.getMessage(modeloTopComponent.class, "modeloTopComponent.jPanel57.TabConstraints.tabTitle"), jPanel57); // NOI18N

        miBarra16.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);

        miTabla15.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        miBarra16.setViewportView(miTabla15);

        jComboBox9.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "CALENDARIO ENERGÉTICO P6.1 ", "CALENDARIO ENERGÉTICO P3.0", "CALENDARIO ENERGÉTICO P3.1" }));
        jComboBox9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox9ActionPerformed(evt);
            }
        });

        org.openide.awt.Mnemonics.setLocalizedText(jLabel201, org.openide.util.NbBundle.getMessage(modeloTopComponent.class, "modeloTopComponent.jLabel201.text")); // NOI18N

        org.openide.awt.Mnemonics.setLocalizedText(jLabel202, org.openide.util.NbBundle.getMessage(modeloTopComponent.class, "modeloTopComponent.jLabel202.text")); // NOI18N

        org.openide.awt.Mnemonics.setLocalizedText(jLabel200, org.openide.util.NbBundle.getMessage(modeloTopComponent.class, "modeloTopComponent.jLabel200.text")); // NOI18N

        org.openide.awt.Mnemonics.setLocalizedText(jLabel220, org.openide.util.NbBundle.getMessage(modeloTopComponent.class, "modeloTopComponent.jLabel220.text")); // NOI18N

        javax.swing.GroupLayout jPanel60Layout = new javax.swing.GroupLayout(jPanel60);
        jPanel60.setLayout(jPanel60Layout);
        jPanel60Layout.setHorizontalGroup(
            jPanel60Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel60Layout.createSequentialGroup()
                .addGroup(jPanel60Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel60Layout.createSequentialGroup()
                        .addGap(34, 34, 34)
                        .addGroup(jPanel60Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel60Layout.createSequentialGroup()
                                .addGap(61, 61, 61)
                                .addComponent(jLabel201))
                            .addComponent(jComboBox9, javax.swing.GroupLayout.PREFERRED_SIZE, 228, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel60Layout.createSequentialGroup()
                        .addGroup(jPanel60Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel60Layout.createSequentialGroup()
                                .addGap(34, 34, 34)
                                .addComponent(jLabel200)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel60Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jLabel220, javax.swing.GroupLayout.PREFERRED_SIZE, 646, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(31, 31, 31)))
                        .addComponent(jLabel202, javax.swing.GroupLayout.PREFERRED_SIZE, 709, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel60Layout.setVerticalGroup(
            jPanel60Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel60Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jComboBox9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel60Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel202, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel60Layout.createSequentialGroup()
                        .addComponent(jLabel220, javax.swing.GroupLayout.PREFERRED_SIZE, 379, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel200)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel201)
                .addGap(365, 365, 365))
        );

        javax.swing.GroupLayout jPanel58Layout = new javax.swing.GroupLayout(jPanel58);
        jPanel58.setLayout(jPanel58Layout);
        jPanel58Layout.setHorizontalGroup(
            jPanel58Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel58Layout.createSequentialGroup()
                .addComponent(miBarra16, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel60, javax.swing.GroupLayout.PREFERRED_SIZE, 951, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel58Layout.setVerticalGroup(
            jPanel58Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(miBarra16, javax.swing.GroupLayout.DEFAULT_SIZE, 417, Short.MAX_VALUE)
            .addComponent(jPanel60, javax.swing.GroupLayout.PREFERRED_SIZE, 417, Short.MAX_VALUE)
        );

        jTabbedPane9.addTab(org.openide.util.NbBundle.getMessage(modeloTopComponent.class, "modeloTopComponent.jPanel58.TabConstraints.tabTitle"), jPanel58); // NOI18N

        javax.swing.GroupLayout jPanel30Layout = new javax.swing.GroupLayout(jPanel30);
        jPanel30.setLayout(jPanel30Layout);
        jPanel30Layout.setHorizontalGroup(
            jPanel30Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel30Layout.createSequentialGroup()
                .addComponent(jTabbedPane9, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel30Layout.setVerticalGroup(
            jPanel30Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel30Layout.createSequentialGroup()
                .addComponent(jTabbedPane9, javax.swing.GroupLayout.PREFERRED_SIZE, 444, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel25Layout = new javax.swing.GroupLayout(jPanel25);
        jPanel25.setLayout(jPanel25Layout);
        jPanel25Layout.setHorizontalGroup(
            jPanel25Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel25Layout.createSequentialGroup()
                .addComponent(jPanel28, javax.swing.GroupLayout.PREFERRED_SIZE, 245, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel29, javax.swing.GroupLayout.PREFERRED_SIZE, 1172, Short.MAX_VALUE))
            .addComponent(jPanel30, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel25Layout.setVerticalGroup(
            jPanel25Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel25Layout.createSequentialGroup()
                .addGroup(jPanel25Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel29, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel28, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel30, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab(org.openide.util.NbBundle.getMessage(modeloTopComponent.class, "modeloTopComponent.jPanel25.TabConstraints.tabTitle"), jPanel25); // NOI18N

        jTextAreaArchivo.setColumns(20);
        jTextAreaArchivo.setRows(5);
        jScrollPane7.setViewportView(jTextAreaArchivo);

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, 1197, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane8, javax.swing.GroupLayout.PREFERRED_SIZE, 1200, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 223, Short.MAX_VALUE))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, 661, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane8, javax.swing.GroupLayout.PREFERRED_SIZE, 551, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab(org.openide.util.NbBundle.getMessage(modeloTopComponent.class, "modeloTopComponent.jPanel7.TabConstraints.tabTitle"), jPanel7); // NOI18N

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 303, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(106, 106, 106)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addComponent(jTabbedPane1)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 797, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jButton12ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton12ActionPerformed
       activarGraficas(this.curvaPotencia, this.curvaPotenciaAnual) ;
    }//GEN-LAST:event_jButton12ActionPerformed

    private void jButton11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton11ActionPerformed
       iniciarModeladoGeneticoPotencias();
        
    }//GEN-LAST:event_jButton11ActionPerformed

    private void jButton13ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton13ActionPerformed
        
      activarThreadPotencias();
    }//GEN-LAST:event_jButton13ActionPerformed
    // -----------------------------------------------------------------------------------------------------------------------------------------
    // Boton carga de modelo en formato CSV
    private void jButton9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton9ActionPerformed
        try {
            cargarModeloCsv();
        } catch (IOException ex) {
            Exceptions.printStackTrace(ex);
        }
    }//GEN-LAST:event_jButton9ActionPerformed

    private void jButton14ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton14ActionPerformed
      //   new miJDialogDetallesArchivoModelo(this, true).setVisible(true);
    }//GEN-LAST:event_jButton14ActionPerformed

    private void jTextField18ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField18ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField18ActionPerformed

    private void jTextField23InputMethodTextChanged(java.awt.event.InputMethodEvent evt) {//GEN-FIRST:event_jTextField23InputMethodTextChanged
        botonValidarCAct.setVisible(true);
    }//GEN-LAST:event_jTextField23InputMethodTextChanged

    private void jTextField23KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField23KeyTyped
        botonValidarCAct.setVisible(true);
    }//GEN-LAST:event_jTextField23KeyTyped

    private void jTextField24KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField24KeyTyped
        botonValidarCAct.setVisible(true);
    }//GEN-LAST:event_jTextField24KeyTyped

    private void jTextField25ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField25ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField25ActionPerformed

    private void jTextField25KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField25KeyTyped
        botonValidarCAct.setVisible(true);
    }//GEN-LAST:event_jTextField25KeyTyped

    private void jTextField26KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField26KeyTyped
        botonValidarCAct.setVisible(true);
    }//GEN-LAST:event_jTextField26KeyTyped

    private void jTextField27KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField27KeyTyped
        botonValidarCAct.setVisible(true);
    }//GEN-LAST:event_jTextField27KeyTyped

    private void jTextField28ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField28ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField28ActionPerformed

    private void jTextField28KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField28KeyTyped
        botonValidarCAct.setVisible(true);
    }//GEN-LAST:event_jTextField28KeyTyped

    private void jTextField29KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField29KeyTyped
        botonValidarCAct.setVisible(true);
    }//GEN-LAST:event_jTextField29KeyTyped

    private void jTextField35KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField35KeyTyped
        botonValidarCAct.setVisible(true);
    }//GEN-LAST:event_jTextField35KeyTyped

    private void jTextField36KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField36KeyTyped
        botonValidarCAct.setVisible(true);
    }//GEN-LAST:event_jTextField36KeyTyped

    private void botonValidarCActActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonValidarCActActionPerformed
     
    }//GEN-LAST:event_botonValidarCActActionPerformed

    private void jComboBox4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jComboBox4MouseClicked

    }//GEN-LAST:event_jComboBox4MouseClicked

    private void jComboBox4MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jComboBox4MousePressed

    }//GEN-LAST:event_jComboBox4MousePressed

    private void jComboBox4PopupMenuWillBecomeVisible(javax.swing.event.PopupMenuEvent evt) {//GEN-FIRST:event_jComboBox4PopupMenuWillBecomeVisible
        botonValidarCAct.setVisible(true);
    }//GEN-LAST:event_jComboBox4PopupMenuWillBecomeVisible

    private void jComboBox4ItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jComboBox4ItemStateChanged
        // botonValidarCAct.setVisible(true);
    }//GEN-LAST:event_jComboBox4ItemStateChanged

    private void jComboBox4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox4ActionPerformed
      
    }//GEN-LAST:event_jComboBox4ActionPerformed

    private void jComboBox4FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jComboBox4FocusGained

    }//GEN-LAST:event_jComboBox4FocusGained

    private void jComboBox4PropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_jComboBox4PropertyChange

    }//GEN-LAST:event_jComboBox4PropertyChange

    private void jComboBox4KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jComboBox4KeyTyped

    }//GEN-LAST:event_jComboBox4KeyTyped

    private void botonValidarCAct1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonValidarCAct1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_botonValidarCAct1ActionPerformed

    private void jComboBox11MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jComboBox11MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBox11MouseClicked

    private void jComboBox11MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jComboBox11MousePressed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBox11MousePressed

    private void jComboBox11PopupMenuWillBecomeVisible(javax.swing.event.PopupMenuEvent evt) {//GEN-FIRST:event_jComboBox11PopupMenuWillBecomeVisible
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBox11PopupMenuWillBecomeVisible

    private void jComboBox11ItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jComboBox11ItemStateChanged
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBox11ItemStateChanged

    private void jComboBox11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox11ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBox11ActionPerformed

    private void jComboBox11FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jComboBox11FocusGained
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBox11FocusGained

    private void jComboBox11PropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_jComboBox11PropertyChange
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBox11PropertyChange

    private void jComboBox11KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jComboBox11KeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBox11KeyTyped

    private void jTextField246InputMethodTextChanged(java.awt.event.InputMethodEvent evt) {//GEN-FIRST:event_jTextField246InputMethodTextChanged
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField246InputMethodTextChanged

    private void jTextField246KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField246KeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField246KeyTyped

    private void jTextField247KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField247KeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField247KeyTyped

    private void jTextField248ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField248ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField248ActionPerformed

    private void jTextField248KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField248KeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField248KeyTyped

    private void jTextField249InputMethodTextChanged(java.awt.event.InputMethodEvent evt) {//GEN-FIRST:event_jTextField249InputMethodTextChanged
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField249InputMethodTextChanged

    private void jTextField249KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField249KeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField249KeyTyped

    private void jTextField250KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField250KeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField250KeyTyped

    private void jTextField251ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField251ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField251ActionPerformed

    private void jTextField251KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField251KeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField251KeyTyped

    private void jTextField252InputMethodTextChanged(java.awt.event.InputMethodEvent evt) {//GEN-FIRST:event_jTextField252InputMethodTextChanged
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField252InputMethodTextChanged

    private void jTextField252KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField252KeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField252KeyTyped

    private void jTextField253KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField253KeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField253KeyTyped

    private void jTextField254ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField254ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField254ActionPerformed

    private void jTextField254KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField254KeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField254KeyTyped

    private void jTextField255InputMethodTextChanged(java.awt.event.InputMethodEvent evt) {//GEN-FIRST:event_jTextField255InputMethodTextChanged
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField255InputMethodTextChanged

    private void jTextField255KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField255KeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField255KeyTyped

    private void jTextField256KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField256KeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField256KeyTyped

    private void jTextField257ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField257ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField257ActionPerformed

    private void jTextField257KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField257KeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField257KeyTyped

    private void jTextField258InputMethodTextChanged(java.awt.event.InputMethodEvent evt) {//GEN-FIRST:event_jTextField258InputMethodTextChanged
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField258InputMethodTextChanged

    private void jTextField258KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField258KeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField258KeyTyped

    private void jTextField259KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField259KeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField259KeyTyped

    private void jTextField260ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField260ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField260ActionPerformed

    private void jTextField260KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField260KeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField260KeyTyped

    private void jTextField261InputMethodTextChanged(java.awt.event.InputMethodEvent evt) {//GEN-FIRST:event_jTextField261InputMethodTextChanged
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField261InputMethodTextChanged

    private void jTextField261KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField261KeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField261KeyTyped

    private void jTextField262KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField262KeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField262KeyTyped

    private void jTextField263ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField263ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField263ActionPerformed

    private void jTextField263KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField263KeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField263KeyTyped

    private void jTextField131ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField131ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField131ActionPerformed

    private void jButton22ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton22ActionPerformed
       
    }//GEN-LAST:event_jButton22ActionPerformed

    private void jTextField136ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField136ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField136ActionPerformed

    private void jTextField148ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField148ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField148ActionPerformed

    private void jTextField154ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField154ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField154ActionPerformed

    private void jTextField156ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField156ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField156ActionPerformed

    private void jTextField167ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField167ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField167ActionPerformed

    private void jTextField168ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField168ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField168ActionPerformed

    private void jTextField171ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField171ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField171ActionPerformed

    private void jTextField146ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField146ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField146ActionPerformed

    private void jTextField164ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField164ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField164ActionPerformed

    private void jTextField165ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField165ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField165ActionPerformed

    private void jTextField194ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField194ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField194ActionPerformed

    private void jTextField197ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField197ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField197ActionPerformed

    private void jButton24ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton24ActionPerformed
    
    }//GEN-LAST:event_jButton24ActionPerformed

    private void jTextField200ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField200ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField200ActionPerformed

    private void jTextField201ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField201ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField201ActionPerformed

    private void jTextField205ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField205ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField205ActionPerformed

    private void jTextField206ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField206ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField206ActionPerformed

    private void jTextField216ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField216ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField216ActionPerformed

    private void jTextField217ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField217ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField217ActionPerformed

    private void jButton25ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton25ActionPerformed
     
    }//GEN-LAST:event_jButton25ActionPerformed

    private void jTextField226ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField226ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField226ActionPerformed

    private void jTextField229ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField229ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField229ActionPerformed

    private void jTextField278ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField278ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField278ActionPerformed

    private void jTextField235ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField235ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField235ActionPerformed

    private void jTextField236ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField236ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField236ActionPerformed

    private void jTextField240ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField240ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField240ActionPerformed

    private void jComboBox9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox9ActionPerformed
        // .................................... Marcar filtro de tipo de medida
        String str;
        str = jComboBox9.getSelectedItem().toString()  ;
        str = str.trim();

     
        if (str.equals("CALENDARIO ENERGÉTICO P6.1"))             {   this.jLabel220.setVisible(false);  this.jLabel200.setVisible(false); this.jLabel202.setVisible(true); }
        if (str.equals("CALENDARIO ENERGÉTICO P3.0"))             {   this.jLabel220.setVisible(true);    this.jLabel202.setVisible(false); this.jLabel200.setVisible(false); }
        if (str.equals("CALENDARIO ENERGÉTICO P3.1"))             {   this.jLabel220.setVisible(false);    this.jLabel202.setVisible(false); this.jLabel200.setVisible(true); }
    }//GEN-LAST:event_jComboBox9ActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel PCContrato;
    private javax.swing.JTree arbol2;
    private javax.swing.JTree arbol3;
    private javax.swing.JTree arbolPrecios;
    private javax.swing.JButton botonValidarCAct;
    private javax.swing.JButton botonValidarCAct1;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton10;
    private javax.swing.JButton jButton11;
    private javax.swing.JButton jButton12;
    private javax.swing.JButton jButton13;
    private javax.swing.JButton jButton14;
    private javax.swing.JButton jButton15;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton20;
    private javax.swing.JButton jButton21;
    private javax.swing.JButton jButton22;
    private javax.swing.JButton jButton24;
    private javax.swing.JButton jButton25;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton8;
    private javax.swing.JButton jButton9;
    private javax.swing.JCheckBox jCheckBox10;
    private javax.swing.JCheckBox jCheckBox11;
    private javax.swing.JCheckBox jCheckBox12;
    private javax.swing.JCheckBox jCheckBox5;
    private javax.swing.JCheckBox jCheckBox7;
    private javax.swing.JCheckBox jCheckBox8;
    private javax.swing.JCheckBox jCheckBox9;
    private javax.swing.JComboBox jComboBox1;
    private javax.swing.JComboBox jComboBox11;
    private javax.swing.JComboBox jComboBox2;
    private javax.swing.JComboBox jComboBox3;
    private javax.swing.JComboBox jComboBox4;
    private javax.swing.JComboBox<String> jComboBox5;
    private javax.swing.JComboBox<String> jComboBox6;
    private javax.swing.JComboBox<String> jComboBox7;
    private javax.swing.JComboBox jComboBox9;
    private javax.swing.JPanel jGraficaLineas;
    private javax.swing.JPanel jGraficaModelo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel149;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel152;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel181;
    private javax.swing.JLabel jLabel182;
    private javax.swing.JLabel jLabel183;
    private javax.swing.JLabel jLabel184;
    private javax.swing.JLabel jLabel185;
    private javax.swing.JLabel jLabel186;
    private javax.swing.JLabel jLabel187;
    private javax.swing.JLabel jLabel188;
    private javax.swing.JLabel jLabel189;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel190;
    private javax.swing.JLabel jLabel191;
    private javax.swing.JLabel jLabel192;
    private javax.swing.JLabel jLabel193;
    private javax.swing.JLabel jLabel194;
    private javax.swing.JLabel jLabel195;
    private javax.swing.JLabel jLabel196;
    private javax.swing.JLabel jLabel197;
    private javax.swing.JLabel jLabel198;
    private javax.swing.JLabel jLabel199;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel200;
    private javax.swing.JLabel jLabel201;
    private javax.swing.JLabel jLabel202;
    private javax.swing.JLabel jLabel203;
    private javax.swing.JLabel jLabel204;
    private javax.swing.JLabel jLabel205;
    private javax.swing.JLabel jLabel206;
    private javax.swing.JLabel jLabel207;
    private javax.swing.JLabel jLabel208;
    private javax.swing.JLabel jLabel209;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel210;
    private javax.swing.JLabel jLabel211;
    private javax.swing.JLabel jLabel212;
    private javax.swing.JLabel jLabel213;
    private javax.swing.JLabel jLabel214;
    private javax.swing.JLabel jLabel215;
    private javax.swing.JLabel jLabel216;
    private javax.swing.JLabel jLabel217;
    private javax.swing.JLabel jLabel218;
    private javax.swing.JLabel jLabel219;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel220;
    private javax.swing.JLabel jLabel221;
    private javax.swing.JLabel jLabel222;
    private javax.swing.JLabel jLabel223;
    private javax.swing.JLabel jLabel224;
    private javax.swing.JLabel jLabel225;
    private javax.swing.JLabel jLabel226;
    private javax.swing.JLabel jLabel227;
    private javax.swing.JLabel jLabel228;
    private javax.swing.JLabel jLabel229;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel230;
    private javax.swing.JLabel jLabel231;
    private javax.swing.JLabel jLabel232;
    private javax.swing.JLabel jLabel233;
    private javax.swing.JLabel jLabel234;
    private javax.swing.JLabel jLabel235;
    private javax.swing.JLabel jLabel236;
    private javax.swing.JLabel jLabel237;
    private javax.swing.JLabel jLabel238;
    private javax.swing.JLabel jLabel239;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel240;
    private javax.swing.JLabel jLabel241;
    private javax.swing.JLabel jLabel242;
    private javax.swing.JLabel jLabel243;
    private javax.swing.JLabel jLabel244;
    private javax.swing.JLabel jLabel245;
    private javax.swing.JLabel jLabel246;
    private javax.swing.JLabel jLabel247;
    private javax.swing.JLabel jLabel248;
    private javax.swing.JLabel jLabel249;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel250;
    private javax.swing.JLabel jLabel251;
    private javax.swing.JLabel jLabel252;
    private javax.swing.JLabel jLabel253;
    private javax.swing.JLabel jLabel254;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel36;
    private javax.swing.JLabel jLabel37;
    private javax.swing.JLabel jLabel38;
    private javax.swing.JLabel jLabel39;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel40;
    private javax.swing.JLabel jLabel41;
    private javax.swing.JLabel jLabel42;
    private javax.swing.JLabel jLabel43;
    private javax.swing.JLabel jLabel48;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel54;
    private javax.swing.JLabel jLabel56;
    private javax.swing.JLabel jLabel57;
    private javax.swing.JLabel jLabel58;
    private javax.swing.JLabel jLabel59;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel60;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLabel jLabel96;
    private javax.swing.JLabel jLabel97;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel13;
    private javax.swing.JPanel jPanel14;
    private javax.swing.JPanel jPanel15;
    private javax.swing.JPanel jPanel16;
    private javax.swing.JPanel jPanel17;
    private javax.swing.JPanel jPanel18;
    private javax.swing.JPanel jPanel19;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel20;
    private javax.swing.JPanel jPanel21;
    private javax.swing.JPanel jPanel22;
    private javax.swing.JPanel jPanel23;
    private javax.swing.JPanel jPanel24;
    private javax.swing.JPanel jPanel25;
    private javax.swing.JPanel jPanel26;
    private javax.swing.JPanel jPanel27;
    private javax.swing.JPanel jPanel28;
    private javax.swing.JPanel jPanel29;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel30;
    private javax.swing.JPanel jPanel31;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel56;
    private javax.swing.JPanel jPanel57;
    private javax.swing.JPanel jPanel58;
    private javax.swing.JPanel jPanel59;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel60;
    private javax.swing.JPanel jPanel61;
    private javax.swing.JPanel jPanel62;
    private javax.swing.JPanel jPanel63;
    private javax.swing.JPanel jPanel64;
    private javax.swing.JPanel jPanel65;
    private javax.swing.JPanel jPanel66;
    private javax.swing.JPanel jPanel67;
    private javax.swing.JPanel jPanel68;
    private javax.swing.JPanel jPanel69;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel70;
    private javax.swing.JPanel jPanel71;
    private javax.swing.JPanel jPanel72;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JPanel jPanelGrafica01;
    private javax.swing.JPanel jPanelGrafica02;
    private javax.swing.JProgressBar jProgressBar1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane13;
    private javax.swing.JScrollPane jScrollPane14;
    private javax.swing.JScrollPane jScrollPane15;
    private javax.swing.JScrollPane jScrollPane16;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JScrollPane jScrollPane8;
    private javax.swing.JScrollPane jScrollPane9;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTabbedPane jTabbedPane10;
    private javax.swing.JTabbedPane jTabbedPane11;
    private javax.swing.JTabbedPane jTabbedPane2;
    private javax.swing.JTabbedPane jTabbedPane3;
    private javax.swing.JTabbedPane jTabbedPane9;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable jTable2;
    private javax.swing.JTable jTable3;
    private javax.swing.JTable jTable4;
    private javax.swing.JTable jTableModeloGeneral;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JTextArea jTextArea5;
    private javax.swing.JTextArea jTextArea6;
    private javax.swing.JTextArea jTextAreaArchivo;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField10;
    private javax.swing.JTextField jTextField11;
    private javax.swing.JTextField jTextField111;
    private javax.swing.JTextField jTextField12;
    private javax.swing.JTextField jTextField129;
    private javax.swing.JTextField jTextField130;
    private javax.swing.JTextField jTextField131;
    private javax.swing.JTextField jTextField132;
    private javax.swing.JTextField jTextField133;
    private javax.swing.JTextField jTextField134;
    private javax.swing.JTextField jTextField135;
    private javax.swing.JTextField jTextField136;
    private javax.swing.JTextField jTextField137;
    private javax.swing.JTextField jTextField138;
    private javax.swing.JTextField jTextField139;
    private javax.swing.JTextField jTextField140;
    private javax.swing.JTextField jTextField141;
    private javax.swing.JTextField jTextField142;
    private javax.swing.JTextField jTextField143;
    private javax.swing.JTextField jTextField144;
    private javax.swing.JTextField jTextField145;
    private javax.swing.JTextField jTextField146;
    private javax.swing.JTextField jTextField147;
    private javax.swing.JTextField jTextField148;
    private javax.swing.JTextField jTextField149;
    private javax.swing.JTextField jTextField150;
    private javax.swing.JTextField jTextField151;
    private javax.swing.JTextField jTextField152;
    private javax.swing.JTextField jTextField153;
    private javax.swing.JTextField jTextField154;
    private javax.swing.JTextField jTextField155;
    private javax.swing.JTextField jTextField156;
    private javax.swing.JTextField jTextField157;
    private javax.swing.JTextField jTextField158;
    private javax.swing.JTextField jTextField159;
    private javax.swing.JTextField jTextField160;
    private javax.swing.JTextField jTextField161;
    private javax.swing.JTextField jTextField162;
    private javax.swing.JTextField jTextField163;
    private javax.swing.JTextField jTextField164;
    private javax.swing.JTextField jTextField165;
    private javax.swing.JTextField jTextField166;
    private javax.swing.JTextField jTextField167;
    private javax.swing.JTextField jTextField168;
    private javax.swing.JTextField jTextField169;
    private javax.swing.JTextField jTextField170;
    private javax.swing.JTextField jTextField171;
    private javax.swing.JTextField jTextField172;
    private javax.swing.JTextField jTextField173;
    private javax.swing.JTextField jTextField174;
    private javax.swing.JTextField jTextField175;
    private javax.swing.JTextField jTextField176;
    private javax.swing.JTextField jTextField177;
    private javax.swing.JTextField jTextField178;
    private javax.swing.JTextField jTextField179;
    private javax.swing.JTextField jTextField18;
    private javax.swing.JTextField jTextField180;
    private javax.swing.JTextField jTextField181;
    private javax.swing.JTextField jTextField182;
    private javax.swing.JTextField jTextField183;
    private javax.swing.JTextField jTextField184;
    private javax.swing.JTextField jTextField185;
    private javax.swing.JTextField jTextField186;
    private javax.swing.JTextField jTextField187;
    private javax.swing.JTextField jTextField188;
    private javax.swing.JTextField jTextField189;
    private javax.swing.JTextField jTextField19;
    private javax.swing.JTextField jTextField190;
    private javax.swing.JTextField jTextField191;
    private javax.swing.JTextField jTextField192;
    private javax.swing.JTextField jTextField193;
    private javax.swing.JTextField jTextField194;
    private javax.swing.JTextField jTextField195;
    private javax.swing.JTextField jTextField196;
    private javax.swing.JTextField jTextField197;
    private javax.swing.JTextField jTextField198;
    private javax.swing.JTextField jTextField199;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField20;
    private javax.swing.JTextField jTextField200;
    private javax.swing.JTextField jTextField201;
    private javax.swing.JTextField jTextField202;
    private javax.swing.JTextField jTextField203;
    private javax.swing.JTextField jTextField204;
    private javax.swing.JTextField jTextField205;
    private javax.swing.JTextField jTextField206;
    private javax.swing.JTextField jTextField207;
    private javax.swing.JTextField jTextField208;
    private javax.swing.JTextField jTextField209;
    private javax.swing.JTextField jTextField210;
    private javax.swing.JTextField jTextField211;
    private javax.swing.JTextField jTextField212;
    private javax.swing.JTextField jTextField213;
    private javax.swing.JTextField jTextField214;
    private javax.swing.JTextField jTextField215;
    private javax.swing.JTextField jTextField216;
    private javax.swing.JTextField jTextField217;
    private javax.swing.JTextField jTextField218;
    private javax.swing.JTextField jTextField219;
    private javax.swing.JTextField jTextField22;
    private javax.swing.JTextField jTextField220;
    private javax.swing.JTextField jTextField221;
    private javax.swing.JTextField jTextField222;
    private javax.swing.JTextField jTextField223;
    private javax.swing.JTextField jTextField224;
    private javax.swing.JTextField jTextField225;
    private javax.swing.JTextField jTextField226;
    private javax.swing.JTextField jTextField227;
    private javax.swing.JTextField jTextField228;
    private javax.swing.JTextField jTextField229;
    private javax.swing.JTextField jTextField23;
    private javax.swing.JTextField jTextField230;
    private javax.swing.JTextField jTextField231;
    private javax.swing.JTextField jTextField232;
    private javax.swing.JTextField jTextField233;
    private javax.swing.JTextField jTextField234;
    private javax.swing.JTextField jTextField235;
    private javax.swing.JTextField jTextField236;
    private javax.swing.JTextField jTextField237;
    private javax.swing.JTextField jTextField238;
    private javax.swing.JTextField jTextField239;
    private javax.swing.JTextField jTextField24;
    private javax.swing.JTextField jTextField240;
    private javax.swing.JTextField jTextField241;
    private javax.swing.JTextField jTextField242;
    private javax.swing.JTextField jTextField243;
    private javax.swing.JTextField jTextField244;
    private javax.swing.JTextField jTextField245;
    private javax.swing.JTextField jTextField246;
    private javax.swing.JTextField jTextField247;
    private javax.swing.JTextField jTextField248;
    private javax.swing.JTextField jTextField249;
    private javax.swing.JTextField jTextField25;
    private javax.swing.JTextField jTextField250;
    private javax.swing.JTextField jTextField251;
    private javax.swing.JTextField jTextField252;
    private javax.swing.JTextField jTextField253;
    private javax.swing.JTextField jTextField254;
    private javax.swing.JTextField jTextField255;
    private javax.swing.JTextField jTextField256;
    private javax.swing.JTextField jTextField257;
    private javax.swing.JTextField jTextField258;
    private javax.swing.JTextField jTextField259;
    private javax.swing.JTextField jTextField26;
    private javax.swing.JTextField jTextField260;
    private javax.swing.JTextField jTextField261;
    private javax.swing.JTextField jTextField262;
    private javax.swing.JTextField jTextField263;
    private javax.swing.JTextField jTextField266;
    private javax.swing.JTextField jTextField267;
    private javax.swing.JTextField jTextField268;
    private javax.swing.JTextField jTextField269;
    private javax.swing.JTextField jTextField27;
    private javax.swing.JTextField jTextField270;
    private javax.swing.JTextField jTextField271;
    private javax.swing.JTextField jTextField272;
    private javax.swing.JTextField jTextField273;
    private javax.swing.JTextField jTextField274;
    private javax.swing.JTextField jTextField275;
    private javax.swing.JTextField jTextField276;
    private javax.swing.JTextField jTextField277;
    private javax.swing.JTextField jTextField278;
    private javax.swing.JTextField jTextField279;
    private javax.swing.JTextField jTextField28;
    private javax.swing.JTextField jTextField29;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField30;
    private javax.swing.JTextField jTextField31;
    private javax.swing.JTextField jTextField33;
    private javax.swing.JTextField jTextField35;
    private javax.swing.JTextField jTextField36;
    private javax.swing.JTextField jTextField4;
    private javax.swing.JTextField jTextField5;
    private javax.swing.JTextField jTextField6;
    private javax.swing.JTextField jTextField7;
    private javax.swing.JTextField jTextField73;
    private javax.swing.JTextField jTextField8;
    private javax.swing.JTextField jTextField9;
    private javax.swing.JScrollPane miBarra13;
    private javax.swing.JScrollPane miBarra14;
    private javax.swing.JScrollPane miBarra15;
    private javax.swing.JScrollPane miBarra16;
    private javax.swing.JTable miTabla13;
    private javax.swing.JTable miTabla14;
    private javax.swing.JTable miTabla15;
    private javax.swing.JTable miTabla16;
    private javax.swing.JPanel pGrafico01;
    private javax.swing.JPanel pGrafico02;
    private javax.swing.JPanel pGrafico03;
    private javax.swing.JTextField tfGeneracion;
    // End of variables declaration//GEN-END:variables
    @Override
    public void componentOpened() {
        // TODO add custom code on component opening
    }

    @Override
    public void componentClosed() {
        // TODO add custom code on component closing
    }

    void writeProperties(java.util.Properties p) {
        // better to version settings since initial version as advocated at
        // http://wiki.apidesign.org/wiki/PropertyFiles
        p.setProperty("version", "1.0");
        // TODO store your settings
    }

    void readProperties(java.util.Properties p) {
        String version = p.getProperty("version");
        // TODO read your settings according to their version
    }

    public void iniciarModeladoGeneticoPotencias() {
        
        // ..........................................................................................................................
        int nIndividuos                          = Integer.valueOf(jTextField5.getText());
        int cromosomas                       = Integer.valueOf(jTextField4.getText());
        int generaciones                      = Integer.valueOf(jTextField6.getText());
        int genes                                   = Integer.valueOf(jTextField3.getText());
        double  pEmparejamiento       =Double.valueOf(jTextField7.getText());   
        double  pMutacion                   =Double.valueOf(jTextField8.getText());
        // .......................................................................................................................... 
        
        geneticPowerModeler  myGeneticModel ;                            // Hacemos unainstancia de la clase de cálculos algoritmo genético
        
        myGeneticModel  = new geneticPowerModeler();
       
        for (int i=0; i<this.numDias; i++) {
        
            myGeneticModel.accionStart( nIndividuos, cromosomas, generaciones, genes,  pEmparejamiento,  pMutacion);

            jTextArea1.setText(myGeneticModel.slog);

            this.curvaPotencia = myGeneticModel.curvaPotencia ;
            this.curvasPotencias[i] = this.curvaPotencia ;
            tfGeneracion.setText(String.valueOf(i));
            jTextField10.setText(String.valueOf(myGeneticModel.tfMejorIndividuo));
            activarGraficas(this.curvaPotencia, this.curvaPotenciaAnual);
        }
    }
    public void activarThreadPotencias() {
        // ..........................................................................................................................
        int nIndividuos                          = Integer.valueOf(jTextField5.getText());
        int cromosomas                       = Integer.valueOf(jTextField4.getText());
        int generaciones                      = Integer.valueOf(jTextField6.getText());
        int genes                                   = Integer.valueOf(jTextField3.getText());
        double  pEmparejamiento       =Double.valueOf(jTextField7.getText());   
        double  pMutacion                   =Double.valueOf(jTextField8.getText());
        // .......................................................................................................................... 
                    Runnable r = new threadCalculoPotencias(this.numDias);
                  
                   new Thread(r).start();  
        
        
    }
      // ----------------------------------------------------------------------------------------------------------------------------------
        // TRHEAD de inserción de datos genéricos en base de datos.
          public class threadCalculoPotencias implements Runnable {
               
               double curvaPotencia[]= new double[12] ; 
               double curvasPotencias[][] = new double[365][12] ; 
               public double curvaPotenciaAnual[] = new double[1095] ;
           
              
               public threadCalculoPotencias(int numDias  ) {
                   
                   for (int i=0; i<1095; i++){
                        curvaPotenciaAnual[i] =0 ;
                   }
                     
                 }
                    
                 //Implementamos el método run()
                @Override
                 public void run() {
                 
                  String sqlStr  ;
                  String str ;
                  int i,j,k,cnt=0, nDatos=100, nColumnas, cntg=0 ; 
                  int  ind=0 ;
                  int estadoInsert = 0 ;
            
                  int numIndividuos ;
                 
                   // ..........................................................................................................................
                    int nIndividuos                          = Integer.valueOf(jTextField5.getText());
                    int cromosomas                       = Integer.valueOf(jTextField4.getText());
                    int generaciones                      = Integer.valueOf(jTextField6.getText());
                    int genes                                   = Integer.valueOf(jTextField3.getText());
                    double  pEmparejamiento       =Double.valueOf(jTextField7.getText());   
                    double  pMutacion                   =Double.valueOf(jTextField8.getText());
                   // .......................................................................................................................... 
                 
                  // .....................................................................................................................
            
                    geneticPowerModeler  myGeneticModel ;                            // Hacemos unainstancia de la clase de cálculos algoritmo genético
        
                    myGeneticModel  = new geneticPowerModeler();
                 
                    //Permite mostrar el valor del progreso
                    jProgressBar1.setStringPainted(true);
                    int x = 0;
                    jProgressBar1.setMaximum(100);
              
                    
                    for ( i=0; i<numDias; i++) {
                        
                 
                        
                         myGeneticModel.accionStart( nIndividuos, cromosomas, generaciones, genes, pEmparejamiento,  pMutacion);

                        jTextArea1.setText(myGeneticModel.slog);

                        this.curvaPotencia = myGeneticModel.curvaPotencia ;
                        this.curvasPotencias[i] = this.curvaPotencia ;
                        System.out.println("ind="+ind+" -----> curvaPotencia dia ("+i+") = ("+this.curvaPotencia[2]+","+this.curvaPotencia[6]+","+  this.curvaPotencia[10]+")");
                        
                        // ........................................................................................................................
                                  this.curvaPotenciaAnual[ind] = this.curvaPotencia[2] ;          ind ++ ;
                                  this.curvaPotenciaAnual[ind] = this.curvaPotencia[6] ;          ind ++ ;
                                  this.curvaPotenciaAnual[ind]  = this.curvaPotencia[10] ;        ind ++ ;
                                  
                                    if ( cntg == 10 ) {
                                          activarGraficas(this.curvaPotencia,this.curvaPotenciaAnual);        
                                          cntg = 0 ;
                                    }
                       // ........................................................................................................................
                        /*
                        for (j=0; j<numDias; j++){
                         //   for (k=0; k<12; k++){
                                
                            if ( j <= i ) {
                                 // this.curvaPotenciaAnual[x] = this.curvasPotencias[j][k];
                                  this.curvaPotenciaAnual[x] = this.curvasPotencias[j][2] ;
                                  this.curvaPotenciaAnual[x+1] = this.curvasPotencias[j][6] ;
                                  this.curvaPotenciaAnual[x+2] = this.curvasPotencias[j][10] ;
                                  System.out.println(" x="+x+" --->CurvaPotenciaAnual dia ("+j+") = ("+this.curvaPotenciaAnual[x] +","+this.curvaPotenciaAnual[x+1] +","+  this.curvaPotenciaAnual[x+2]+")");
                            } else {
                                this.curvaPotenciaAnual[x] = 0 ;   
                            }
                               x = x +3; 
                          //  }                        
                        }
                        */
                        
                          tfGeneracion.setText(String.valueOf(i));
                          jTextField10.setText(String.valueOf(myGeneticModel.tfMejorIndividuo));
                        
                           x = (i * 100) / numDias ;  jProgressBar1.setValue(x);
                                 try {
                                    Thread.sleep(50);
                                } catch (InterruptedException ex) {
                                    Exceptions.printStackTrace(ex);
                                }
                                 cntg ++ ;
                }
                    
                    
                    
                          // .......................................................................
                        
                          // .....................................................................................................................   
                          
                            jProgressBar1.setValue(0);
                            jProgressBar1.setMaximum(0);
                            jProgressBar1.setString("");  
                        
                                
                          // .....................................................................................................................   
                  
                      
                    }
                  }
    
    // -------------------------------------------------------------------------------------------------------------------------------------
    public void activarGraficas(double curvaPotencia[], double curvaPotenciaAnual[] ) {

        // ...........................................................................................................................................
        Graficas migrafico = new Graficas(); //aqui debe de ir esta linea de programacion

        //tamaño del grafico
        Dimension d = jPanelGrafica01.getSize();        //toma el tamaño del contenedor

        // System.out.println("Dimensión del panel:" + d);

        d.setSize(650, 180);

        //se crean los datos
        
        double[] valores = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0.2, .4, 0.6, 0.8, 1, 1, 0.5, 0.5, 0.5, 0.5, 0.5, 1, 1, 1, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
        String[] arg1 = {"0:00", "0:30", "1:00", "1:30", "2:00", "2:30", "3:00", "3:30", "4:00", "4:30", "5:00", "5:30", "6:00", "6:30", "7:00", "7:30", "8:00", "8:30",
            "9:00", "9:30", "10:00", "10:30", "11:00", "11:30", "12:00", "12:30", "13:00", "13:30", "14:00", "14:30", "15:00", "15:30", "16:00", "16:30",
            "17:00", "17:30", "18:00", "18:30", "19:00", "19:30", "20:00", "20:30", "21:00", "21:30", "22:00", "22:30", "23:00", "23:30"};
        String[] arg2 = {"", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", ""};
          String[] data = {"","","FU"};
       
        //se crea el grafico

        migrafico.crear_grafico_de_barras(d, valores, arg2, arg1, data);

        //se crea un jlabel para colocar el grafico
        JLabel j = new JLabel();
        j.setBounds(0, 0, d.width, d.height);
        //se carga el grafico de memoria
        migrafico.cargar_grafico(j);
        //se añade al contenedor

        jPanelGrafica01.add(j);
        this.repaint();
        
        // ..............................................................................................................................................................................................
        Dimension d2 =pGrafico01.getSize();
        d2.setSize(450,230);

        //se crean los datos
        double[] valores2= energiaConsumida;
        String[] arg12 = {"1", "2", "3"};
        String[] arg22 = {"", "", ""};
        //titulo, lateral 1, lateral 2
        String[] data2 = {"", "", "kWh"};
             
        //se crea el grafico

        migrafico.crear_grafico_de_barras(d2, valores2, arg22, arg12, data2);

        //se crea un jlabel para colocar el grafico
        JLabel j2 = new JLabel();
        j2.setBounds(0, 0, d2.width, d2.height);
        //se carga el grafico de memoria
        migrafico.cargar_grafico(j2);
        //se añade al contenedor

        pGrafico01.add(j2);
         // ..............................................................................................................................................................................................
         pGrafico02.removeAll();
         Dimension d3 =pGrafico02.getSize();
        d3.setSize(450,230);

        //se crean los datos

        double[] valores3 = {0,0,0,0,0,0,0,0,0,0,0,0,0.5,.5,0.8,0.8,1,1,0.5,0.5,0.5,0.5,0.5,1,1,1,1,1,1,1,1,1,1,1,1,1,1,0.5,0.5,0.3,0,0,0,0,0,0,0,0};
        String[] arg13 = {"0:00","0:30","1:00","1:30","2:00","2:30","3:00","3:30","4:00","4:30","5:00","5:30","6:00","6:30","7:00","7:30","8:00","8:30",
                         "9:00","9:30","10:00","10:30","11:00","11:30","12:00","12:30","13:00","13:30","14:00","14:30","15:00","15:30","16:00","16:30",
                         "17:00","17:30","18:00","18:30","19:00","19:30","20:00","20:30","21:00","21:30","22:00","22:30","23:00","23:30"};
        String[] arg23 = {"","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","",""};
        //titulo, lateral 1, lateral 2
        String[] data3 = {"","","FU"};
        //se crea el grafico

        migrafico.crear_grafico_de_barras(d3, valores3, arg23, arg13, data3);

        //se crea un jlabel para colocar el grafico
        JLabel j3 = new JLabel();
        j3.setBounds(0, 0, d3.width, d3.height);
        //se carga el grafico de memoria
        migrafico.cargar_grafico(j3);
        //se añade al contenedor

     //   pGrafico02.add(j3);
        this.repaint();
  // .....................................................
  
        pGrafico02.removeAll();
        Dimension d4 = pGrafico02.getSize();
        d4.setSize(450,230);
        //se declara el grafico XY Lineal
        XYDataset xydataset = xyDataset(curvaPotencia);
       JFreeChart jfreechart = ChartFactory.createXYLineChart(
        "" , "hora", "kW / kWAR",
        xydataset, PlotOrientation.VERTICAL,  true, true, false);

        //personalización del grafico
        XYPlot xyplot = (XYPlot) jfreechart.getPlot();
        xyplot.setBackgroundPaint( Color.white );
        xyplot.setDomainGridlinePaint( Color.BLACK );
        xyplot.setRangeGridlinePaint( Color.BLACK );
        
        // -> Pinta Shapes en los puntos dados por el XYDataset
        XYLineAndShapeRenderer xylineandshaperenderer = (XYLineAndShapeRenderer) xyplot.getRenderer();
        xylineandshaperenderer.setBaseShapesVisible(true);
        //--> muestra los valores de cada punto XY
         
        XYItemLabelGenerator xy = new StandardXYItemLabelGenerator();
        xylineandshaperenderer.setBaseItemLabelGenerator( xy );
        xylineandshaperenderer.setBaseItemLabelsVisible(false);
        xylineandshaperenderer.setBaseLinesVisible(true);
        xylineandshaperenderer.setBaseItemLabelsVisible(false);
        //fin de personalización

        //se crea la imagen y se asigna a la clase ImageIcon
        JLabel j4 = new JLabel();
        j4.setBounds(0, 0, d4.width, d4.height);
        BufferedImage bufferedImage  = jfreechart.createBufferedImage( d4.width, d4.height);
        
        ImageIcon imagenFondo2 = new ImageIcon(bufferedImage);
        j4.setIcon(imagenFondo2);
        j4.repaint();
        pGrafico02.add(j4);
        j4.repaint();
        this.repaint();
        // .....................................................
        pGrafico03.removeAll();
        Dimension d5 = pGrafico03.getSize();
        d5.setSize(727,285);
        //se declara el grafico XY Lineal
        XYDataset xydataset2 = xyDataset2(curvaPotenciaAnual);
       JFreeChart jfreechart2 = ChartFactory.createXYLineChart(
        "" , "dia", "kW / kWAR",
        xydataset2, PlotOrientation.VERTICAL,  true, true, false); // true,true, false

        //personalización del grafico
        XYPlot xyplot2 = (XYPlot) jfreechart2.getPlot();
        xyplot2.setBackgroundPaint( Color.white );
        xyplot2.setDomainGridlinePaint( Color.BLACK );
        xyplot2.setRangeGridlinePaint( Color.BLACK );
        
        // -> Pinta Shapes en los puntos dados por el XYDataset
        XYLineAndShapeRenderer xylineandshaperenderer2 = (XYLineAndShapeRenderer) xyplot2.getRenderer();
        xylineandshaperenderer2.setBaseShapesVisible(false);  // true
      
        //--> muestra los valores de cada punto XY
         
        XYItemLabelGenerator xy2 = new StandardXYItemLabelGenerator();
        xylineandshaperenderer.setBaseItemLabelGenerator( xy2 );
        xylineandshaperenderer.setBaseItemLabelsVisible(false);
        xylineandshaperenderer.setBaseLinesVisible(false);                       // true
        xylineandshaperenderer.setBaseItemLabelsVisible(false);
        //fin de personalización

        //se crea la imagen y se asigna a la clase ImageIcon
        JLabel j5 = new JLabel();
        j5.setBounds(0, 0, d5.width, d5.height);
        BufferedImage bufferedImage2  = jfreechart2.createBufferedImage( d5.width, d5.height);
        
        ImageIcon imagenFondo3 = new ImageIcon(bufferedImage2);
        j5.setIcon(imagenFondo3);
        j5.repaint();
        pGrafico03.add(j5);
        j5.repaint();
        this.repaint();
/*
        Dimension d2 = jPanelGrafica02.getSize();
        DefaultPieDataset dataset = new DefaultPieDataset();


        // Establecemos unas categorías de ejemplo

        dataset.setValue("Ejemplo1", 43.2);
        dataset.setValue("Ejemplo2", 27.9);
        dataset.setValue("Ejemplo1", 79.5);
        dataset.setValue("Ejemplo2", 79.5);

        // Creamos la tabla

        grafico = ChartFactory.createPieChart("Distribución de consumos Kwh",dataset,true,true,false);

        JLabel j2 = new JLabel();
        j2.setBounds(0, 0, d2.width, d2.height);
        _image = grafico.createBufferedImage(d2.width, d2.height);
        ImageIcon imagenFondo = new ImageIcon(_image);
        j2.setIcon(imagenFondo);
        j2.repaint();
        jPanelGrafica02.add(j2);
        this.repaint();

         // .....................................................

        Dimension d3 = jPanelGrafica03.getSize();

        //se declara el grafico XY Lineal
        XYDataset xydataset = xyDataset();
        JFreeChart jfreechart = ChartFactory.createXYLineChart(
        "Consumos semanales" , "1ra semana del mes de Junio", "Consumos en KWh",
        xydataset, PlotOrientation.VERTICAL,  true, true, false);

        //personalización del grafico
        XYPlot xyplot = (XYPlot) jfreechart.getPlot();
        xyplot.setBackgroundPaint( Color.white );
        xyplot.setDomainGridlinePaint( Color.BLACK );
        xyplot.setRangeGridlinePaint( Color.BLACK );
        // -> Pinta Shapes en los puntos dados por el XYDataset
        XYLineAndShapeRenderer xylineandshaperenderer = (XYLineAndShapeRenderer) xyplot.getRenderer();
        xylineandshaperenderer.setBaseShapesVisible(true);
        //--> muestra los valores de cada punto XY
        XYItemLabelGenerator xy = new StandardXYItemLabelGenerator();
        xylineandshaperenderer.setBaseItemLabelGenerator( xy );
        xylineandshaperenderer.setBaseItemLabelsVisible(true);
        xylineandshaperenderer.setBaseLinesVisible(true);
        xylineandshaperenderer.setBaseItemLabelsVisible(true);
        //fin de personalización

        //se crea la imagen y se asigna a la clase ImageIcon
        JLabel j3 = new JLabel();
        j3.setBounds(0, 0, d3.width, d3.height);
        BufferedImage bufferedImage  = jfreechart.createBufferedImage( d3.width, d3.height);
        ImageIcon imagenFondo2 = new ImageIcon(bufferedImage);
        j3.setIcon(imagenFondo2);
        j3.repaint();
        jPanelGrafica03.add(j3);
        this.repaint();
         */
        // ...........................................................................................................................................
        Graficas migraficoModelo = new Graficas(); 
        jGraficaModelo.removeAll();
        //tamaño del grafico
        Dimension d6 = jGraficaModelo.getSize();        //toma el tamaño del contenedor

        // System.out.println("Dimensión del panel:" + d);

        d6.setSize(600, 300);

        //se crean los datos
        
        double[] valores6 = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
        String[] arg16 = {"0:00", "0:30", "1:00", "1:30", "2:00", "2:30", "3:00", "3:30", "4:00", "4:30", "5:00", "5:30", "6:00", "6:30", "7:00", "7:30", "8:00", "8:30",
            "9:00", "9:30", "10:00", "10:30", "11:00", "11:30", "12:00", "12:30", "13:00", "13:30", "14:00", "14:30", "15:00", "15:30", "16:00", "16:30",
            "17:00", "17:30", "18:00", "18:30", "19:00", "19:30", "20:00", "20:30", "21:00", "21:30", "22:00", "22:30", "23:00", "23:30"};
        String[] arg26 = {"", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", ""};
        String[] data6 = {"","","FU"};
       
        //se crea el grafico

        migraficoModelo.crear_grafico_de_barras(d6, valores6, arg26, arg16, data6);

        //se crea un jlabel para colocar el grafico
        JLabel j6 = new JLabel();
        j6.setBounds(0, 0, d6.width, d6.height);
        //se carga el grafico de memoria
        migraficoModelo.cargar_grafico(j6);
        //se añade al contenedor

        jGraficaModelo.add(j6);
        this.repaint();
          // .....................................................
        jGraficaLineas.removeAll();
        Dimension d7 = jGraficaLineas.getSize();
        d7.setSize(600,300);
        //se declara el grafico XY Lineal
        double curvaEnergiaDiaria[] = {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0} ;
        XYDataset xydataset3 = xyDataset3(curvaEnergiaDiaria);
       JFreeChart jfreechart3 = ChartFactory.createXYLineChart(
        "" , "hora", "kWh",
        xydataset3, PlotOrientation.VERTICAL,  true, true, false); // true,true, false

        //personalización del grafico
        XYPlot xyplot3 = (XYPlot) jfreechart3.getPlot();
        xyplot3.setBackgroundPaint( Color.white );
        xyplot3.setDomainGridlinePaint( Color.BLACK );
        xyplot3.setRangeGridlinePaint( Color.BLACK );
        
        // -> Pinta Shapes en los puntos dados por el XYDataset
        XYLineAndShapeRenderer xylineandshaperenderer3 = (XYLineAndShapeRenderer) xyplot3.getRenderer();
        xylineandshaperenderer3.setBaseShapesVisible(false);  // true
      
        //--> muestra los valores de cada punto XY
         
        XYItemLabelGenerator xy3 = new StandardXYItemLabelGenerator();
        xylineandshaperenderer.setBaseItemLabelGenerator( xy3 );
        xylineandshaperenderer.setBaseItemLabelsVisible(false);
        xylineandshaperenderer.setBaseLinesVisible(false);                       // true
        xylineandshaperenderer.setBaseItemLabelsVisible(false);
        //fin de personalización

        //se crea la imagen y se asigna a la clase ImageIcon
        JLabel j7 = new JLabel();
        j7.setBounds(0, 0, d7.width, d7.height);
        BufferedImage bufferedImage3  = jfreechart3.createBufferedImage( d7.width, d7.height);
        
        ImageIcon imagenFondo4 = new ImageIcon(bufferedImage3);
        j7.setIcon(imagenFondo4);
        j7.repaint();
        jGraficaLineas.add(j7);
        j7.repaint();
        this.repaint();
         // .....................................................
      
       
    }
    // -------------------------------------------------------------------------------------------------------------------------------------

    private XYDataset xyDataset(double curvaPotencia[]) {
        int i;
        //se declaran las series y se llenan los datos
        XYSeries sPActiva = new XYSeries("Potencia Activa");
        XYSeries sPReactiva = new XYSeries("Potencia Reactiva");
        //serie #1
      
        for (i=0; i<this.nGenes; i++) {
                sPActiva.add(i,curvaPotencia[i]); // System.out.println("actualizo grafica i:"+i+" --"+curvaPotencia[i]);
        }
        
        
        sPReactiva.add(1, 1);
        sPReactiva.add(2, 0);
        sPReactiva.add(3, 1);
        sPReactiva.add(4, 0);
        sPReactiva.add(5, 1);
        sPReactiva.add(6, 2);
        sPReactiva.add(7, 1);
        sPReactiva.add(8, 3);
        sPReactiva.add(9, 2);
        sPReactiva.add(10, 1);
        sPReactiva.add(11, 0);
        sPReactiva.add(12, 1);
       
        
        XYSeriesCollection xyseriescollection = new XYSeriesCollection();
        xyseriescollection.addSeries( sPActiva );
        xyseriescollection.addSeries( sPReactiva );

        return xyseriescollection;
    }
    // ------------------------------------------------------------------------------------------------------------
  // -------------------------------------------------------------------------------------------------------------------------------------

    private XYDataset xyDataset2(double curvaPotenciaAnual[]) {
        int i, nTotal=0;
        //se declaran las series y se llenan los datos
        XYSeries sPActiva2 = new XYSeries("Potencia Activa");
        XYSeries sPReactiva2 = new XYSeries("Potencia Reactiva");
      
       nTotal = curvaPotenciaAnual.length ;
       
        for (i=0; i<1095; i++) {
                sPActiva2.add(i,curvaPotenciaAnual[i]);
                // System.out.println(" sPActiva.add(i,curvaPotenciaAnual["+i+"])="+ curvaPotenciaAnual[i]) ;
                sPReactiva2.add(i, curvaPotenciaAnual[i]/10);
        }
       
        
        XYSeriesCollection xyseriescollection = new XYSeriesCollection();
        xyseriescollection.addSeries( sPActiva2 );
        xyseriescollection.addSeries( sPReactiva2 );

        return xyseriescollection;
    }
 // -------------------------------------------------------------------------------------------------------------------------------------

 private XYDataset xyDataset3(double curvaPotenciaDiaria[]) {
        int i, nTotal=0;
        //se declaran las series y se llenan los datos
        XYSeries sPActiva2    = new XYSeries("Energia L1");
        XYSeries sPReactiva2 = new XYSeries("Energia L2");
        XYSeries sPActiva4    = new XYSeries("Energia L3");
      
       nTotal = curvaPotenciaAnual.length ;
       
        for (i=0; i<48; i++) {
                sPActiva2.add(i,curvaPotenciaDiaria[i]);
                // System.out.println(" sPActiva.add(i,curvaPotenciaAnual["+i+"])="+ curvaPotenciaAnual[i]) ;
                sPReactiva2.add(i, curvaPotenciaDiaria[i]/10);
        }
       
        
        XYSeriesCollection xyseriescollection = new XYSeriesCollection();
        xyseriescollection.addSeries( sPActiva2 );
        xyseriescollection.addSeries( sPReactiva2 );
        xyseriescollection.addSeries( sPActiva4 );

        return xyseriescollection;
    }
 // ------------------------------------------------------------------------------------------------------------
 public final void crearArboles() {

        // System.out.println("Voy a crear el arbol CALENDARIOS  ");

        // ...........................................................................................................................................................
        DefaultMutableTreeNode carpetaRaiz = new DefaultMutableTreeNode("CALENDARIOS");
     
        DefaultTreeModel modelo2;
        modelo2 = new DefaultTreeModel(carpetaRaiz);
        /**
         * agregamos el modelo al arbol, donde previamente establecimos la raiz
         */
        arbol2 = new JTree(modelo2);
        jScrollPane6.setViewportView(arbol2);

        // ...........................................................................................................................................................
        
        DefaultMutableTreeNode carpetaRaiz2 = new DefaultMutableTreeNode("INVENTARIO");
     
        DefaultTreeModel modelo3;
        modelo3 = new DefaultTreeModel(carpetaRaiz2);
        /**
         * agregamos el modelo al arbol, donde previamente establecimos la raiz
         */
        arbol3 = new JTree(modelo3);
        jScrollPane2.setViewportView(arbol3);
        
    }
 // ----------------------------------------------------------------------------------------------------------------
    
 // ----------------------------------------------------------------------------------------------------------------
 public final void modificarArboles() {
          
           int i,j,k,cnt,ind=0,eCnt=0;
           int nElementos=0;
           
           cnt = this.nLineas ;
                      
           System.out.println("Voy a modificar el arbol nuevo tenemos un total de puntos de:"+cnt);
           
           DefaultMutableTreeNode carpetaRaiz = new DefaultMutableTreeNode("LINEAS ("+this.nLineas+")");
           /**Definimos el modelo donde se agregaran los nodos*/
           DefaultTreeModel modelo2;
           modelo2 = new DefaultTreeModel(carpetaRaiz);
           /**agregamos el modelo al arbol, donde previamente establecimos la raiz*/
           
         
           for (i=0; i<this.nLineas; i++){
                DefaultMutableTreeNode carpeta = new DefaultMutableTreeNode(i+"-"+ this.sLineas[i]);     // Comenzamos con el primer punto
                modelo2.insertNodeInto(carpeta, carpetaRaiz, i);
               
                for (j=0; j<this.nElementos[i]; j++){
                   DefaultMutableTreeNode carpeta2 = new DefaultMutableTreeNode(eCnt+"-"+ this.tablaInventario[i][j][3]);     // Comenzamos con el primer punto
                   modelo2.insertNodeInto(carpeta2, carpeta, j);
                   eCnt ++;
                }
           }   
          
            arbol3 = new JTree(modelo2);
           jScrollPane2.setViewportView(arbol3);
              
            //        DefaultMutableTreeNode archivo = new DefaultMutableTreeNode();
             //       modelo2.insertNodeInto(archivo, carpeta, i);       
             
          
            // ................................................................................
           
            arbol3.addTreeSelectionListener(new TreeSelectionListener() {
            @Override
           
            public void valueChanged(TreeSelectionEvent e) {
                // se obtiene el nodo seleccionado
                DefaultMutableTreeNode nseleccionado = (DefaultMutableTreeNode) arbol3.getLastSelectedPathComponent();
    
                int nivel = nseleccionado.getDepth() ;
                System.out.println("El nivel de campo es ="+nivel);
                
                if ( nivel == 0) {
                    
                    String nodo            = nseleccionado.getUserObject().toString() ;
                    String [] campos    = nodo.split("-");
                    int indice                = Integer.parseInt(campos[0]);
                    
                    System.out.println("El indice de campo es ="+indice);
                 
                    jTableModeloGeneral.getSelectionModel().setSelectionInterval(indice,indice);
 
                }
            }
            }); 
            
           // ................................................................................
           // ----------------------------------------------------------------------------------------------------------
           
            DefaultMutableTreeNode carpetaRaiz2 = new DefaultMutableTreeNode("TEMPORADAS ("+this.nTemporadas+")");
           /**Definimos el modelo donde se agregaran los nodos*/
           DefaultTreeModel modelo3;
           modelo3 = new DefaultTreeModel(carpetaRaiz2);
           /**agregamos el modelo al arbol, donde previamente establecimos la raiz*/
           
         
           for (i=0; i<this.nTemporadas; i++){
                DefaultMutableTreeNode carpeta3 = new DefaultMutableTreeNode(i+"-"+ this.sTemporadas[i]);     // Comenzamos con el primer punto
                modelo3.insertNodeInto(carpeta3, carpetaRaiz2, i);
                System.out.println("---------------->  nDiasTipo:"+this.nDiasTipo) ;
                for (j=0; j<this.nDiasTipo; j++){
                   DefaultMutableTreeNode carpeta4 = new DefaultMutableTreeNode(i+"-"+j+"-"+ this.sDiasTipo[j]);     // Comenzamos con el primer punto
                   modelo3.insertNodeInto(carpeta4, carpeta3, j);          System.out.println("Intento crear: "+this.sDiasTipo[j]) ;
                }
                
           }   
          
            arbol2 = new JTree(modelo3);
           jScrollPane6.setViewportView(arbol2);
              
            //        DefaultMutableTreeNode archivo = new DefaultMutableTreeNode();
             //       modelo2.insertNodeInto(archivo, carpeta, i);       
             
          
            // ................................................................................
           
            arbol2.addTreeSelectionListener(new TreeSelectionListener() {
            @Override
           
            public void valueChanged(TreeSelectionEvent e) {
                // se obtiene el nodo seleccionado
                DefaultMutableTreeNode nseleccionado = (DefaultMutableTreeNode) arbol2.getLastSelectedPathComponent();
    
                int nivel = nseleccionado.getDepth() ;
               
                
                if ( nivel == 0) {
                    
                    String nodo            = nseleccionado.getUserObject().toString() ;
                    String [] campos    = nodo.split("-");
                    int indice                = Integer.parseInt(campos[1]);
                    int temporada        =  Integer.parseInt(campos[0]);
                    
                    System.out.println("El indice de temporada es ="+temporada+" - "+indice);
                    
                    iniciarTablas() ;
                    actualizaTablas(temporada,indice)   ;                                 
                    
                }
            }
            }); 
            
           // ................................................................................
            
       }
 // ------------------------------------------------------------------------------------------------------------	
 public void cargarModeloCsv()  throws IOException {
         
        
       File  nombre ;
        JFileChooser fileChooser = new JFileChooser();
        
        fileChooser.showOpenDialog(this);
        File abre=fileChooser.getSelectedFile();
       
               
       nombre = abre ;
	       
        String filename = nombre.getAbsolutePath();
        // ...........................................................................................
         mostrarArchivo(nombre);       
         procesaDatos(filename);
         actualizaTablas(0,0);
        // ...........................................................................................
        modificarArboles();
        // ...........................................................................................
	    
 
    }
 // ------------------------------------------------------------------------------------------------------------	
 private void mostrarArchivo(File abre) throws FileNotFoundException, IOException {
            
         String aux=""; 		
	
             /*recorremos el archivo, lo leemos para plasmarlo
	  *en el area de texto*/
	 if(abre!=null)
	 { 				
	 	FileReader archivos=new FileReader(abre);
	 	BufferedReader lee=new BufferedReader(archivos);
	 	while((aux=lee.readLine())!=null)
	 	{
                    this.sFileTxt+= aux+ "\n";
	 	}

                lee.close();
	 	} 
                jTextAreaArchivo.setText(this.sFileTxt);
        return ;
}
 // ---------------------------------------------------------------------------------------------------------------------------------------------	
 private void procesaDatos(String  sNombre) {
            
            int i,j,n,m,nTemporadas,nMeses,indice,nPerfiles;
            int iDias[] = new int[7] ;
            
            float energia=0,potencia=0;
            float potencia1,potencia2,potencia3,potenciaTotal;
            String txt="",txt1,txt2,txt3;
            String res1[] = new String[48];
            String res2[] = new String[48];
            String res3[] = new String[48];
            
            
            
            // System.out.println("Voy A INICIAR LA CLASE LBDM ");
            Lbdm mylbdm ;                // Hacemos unainstancia de la clase de cálculos algoritmo lineal discreto ponderado
            try {
                mylbdm = new Lbdm(sNombre);
                // ................................................................
                
               this. nLineas               = mylbdm.nLineas ;
               this.sLineas                = mylbdm.sTablaLineas ;
               this.sTablaInventario  = mylbdm.sTablaInventario ;  
               this.tablaInventario     = mylbdm.tablaInventario ;
               this.nElementos          = mylbdm.nElementos ;
               this.sTemporadas       = mylbdm.sTemporadas;
               this.nTemporadas       = mylbdm.nTemporadas;
               this.nDiasTipo              = mylbdm.nDiasTipo ;
               this.sDiasTipo              = mylbdm.sDiasTipo ;
               this.nInventario            = mylbdm.nInventario ;
               
               this.fTablaPotenciasInst = mylbdm.fTablaPotenciasInst ;
               this.fTablaPonderaciones=mylbdm.fTablaPonderaciones;
               // ................................................................
               // Calcula cargas teóricas perfiles por días
                
                res1 = mylbdm.CalculaCargasTeoricas(1,0);
                res2 = mylbdm.CalculaCargasTeoricas(1,1);
                res3 = mylbdm.CalculaCargasTeoricas(1,2);
                // ................................................................ 
                for (n=0; n<48; n++) {
                        fCargasTeoricas[0][0][n] = Float.parseFloat(res1[n]) ;
                        fCargasTeoricas[0][1][n] = Float.parseFloat(res2[n]) ;
                        fCargasTeoricas[0][2][n] = Float.parseFloat(res3[n]) ;                     
                }
                
              
                txt1 = muestraResultados(res1,48,"- Datos primer periodo - Tipo dia 0") ;
                txt2= muestraResultados(res2,48,"- Tipo dia 1") ;
                txt3= muestraResultados(res3,48,"- Tipo dia 2") ;
                
                txt = txt + "\n" + txt1 + "\n" + txt2 + "\n" + txt3 ;
                
                res1 = mylbdm.CalculaCargasTeoricas(2,0);
                res2 = mylbdm.CalculaCargasTeoricas(2,1);
                res3 = mylbdm.CalculaCargasTeoricas(2,2);
                
                for (n=0; n<48; n++) {
                        fCargasTeoricas[1][0][n] = Float.parseFloat(res1[n]) ;
                        fCargasTeoricas[1][1][n] = Float.parseFloat(res2[n]) ;
                        fCargasTeoricas[1][2][n] = Float.parseFloat(res3[n]) ;                     
                }
                
              
                txt1 = muestraResultados(res1,48,"- Datos segundo periodo - Tipo dia 0") ;
                txt2= muestraResultados(res2,48,"- Tipo dia 1") ;
                txt3= muestraResultados(res3,48,"- Tipo dia 2") ;
                
                txt = txt + "\n" + txt1 + "\n" + txt2 + "\n" + txt3 ;
                
                res1 = mylbdm.CalculaCargasTeoricas(3,0);
                res2 = mylbdm.CalculaCargasTeoricas(3,1);
                res3 = mylbdm.CalculaCargasTeoricas(3,2);
               
                for (n=0; n<48; n++) {
                        fCargasTeoricas[2][0][n] = Float.parseFloat(res1[n]) ;
                        fCargasTeoricas[2][1][n] = Float.parseFloat(res2[n]) ;
                        fCargasTeoricas[2][2][n] = Float.parseFloat(res3[n]) ;                     
                }
                
                txt1 = muestraResultados(res1,48,"- Datos tercer periodo - Tipo dia 0") ;
                txt2= muestraResultados(res2,48,"- Tipo dia 1") ;
                txt3= muestraResultados(res3,48,"- Tipo dia 2") ;
                
                txt = txt + "\n" + txt1 + "\n" + txt2 + "\n" + txt3 ;
                // areaDeTextoProcesado.setText(txt);
                
                // ................................................................
                // Calcula cargas teóricas totales           
               // nMeses      = mylbdm.iTablaCalendario.length ;
               // nTemporadas = mylbdm.iTablaTemporadas.length ;
                nMeses = 0 ;
                nTemporadas = 3;
                nPerfiles = 3;
                
                // System.out.println("nTemporadas = "+nTemporadas);
                
                txt = txt + "------------- Energía consumida por temporada ----------------\n";
                txt = txt +"Temporada 1, Temporada 2, Temporada 3 \n" ;
                
                for (i=0; i<nTemporadas; i++) {
                    
                    nMeses = mylbdm.iTablaTemporadas[i][0]  ;
                    // System.out.println("nMeses = "+nMeses);               
                    potenciaTotal = 0 ;
                    for (m=0; m<nMeses; m++){

                            indice = mylbdm.iTablaTemporadas[i][m] ;
                          
                            for (n=0; n<nPerfiles; n++){
                                iDias[n] = mylbdm.iTablaCalendario[indice-1][n] ;
                            }    
                            potencia1=0 ;
                          
                            for (n=0; n<nPerfiles; n++){
                                for (j=0; j<48; j++){
                                        potencia1 += fCargasTeoricas[i][n][j] ;
                                } 
                                potenciaTotal +=  iDias[n] * potencia1  ;
                            }        
                             potenciaTotal = potenciaTotal / 2000 ;
                    }
                    potencia2 = potenciaTotal / nMeses ;
                    potencia3 = potencia2 / 30 ;
                    txt = txt + Float.toString(potencia3)+","+Float.toString(potencia2)+","+Float.toString(potenciaTotal) + "," ;
                } 
                
                 this.sFileTxt += txt ;
                 jTextAreaArchivo.setText(this.sFileTxt);
                
                /*
                String res4[] = mylbdm.CalculaCargasCuartoHorarias();
                
                float res5[][] = mylbdm.CalculaCostePotenciaP6(res4) ;
                */
               
                                
            } catch (FileNotFoundException ex) {
                //
            }
            return ;
        }   
// ---------------------------------------------------------------------------------------------------------------------------------------------
private String muestraResultados(String res1[],int num,String txt) 
{
        int i;
        
        String aux ="";
        String texto = txt + "\n";
        for (i=0; i<num; i++){
            aux = res1[i]+",";
            texto+= aux ;
        }
                 
         return texto;
}
// ---------------------------------------------------------------------------------------------------------------------------------------------
public void iniciarTablas() {
 
             //  DefaultTableModel model;
                this.model = new DefaultTableModel();                    // definimos el objeto tableModel
               
                jTableModeloGeneral = new JTable();                // creamos la instancia de la tabla
                jTableModeloGeneral.setModel(this.model);
                
                model.addColumn("p"); 
                model.addColumn("000");  model.addColumn("003"); 
                model.addColumn("010");  model.addColumn("013"); 
                model.addColumn("020");  model.addColumn("023"); 
                model.addColumn("030");  model.addColumn("033"); 
                model.addColumn("040");  model.addColumn("043"); 
                model.addColumn("050");  model.addColumn("053"); 
                model.addColumn("060");  model.addColumn("063"); 
                model.addColumn("070");  model.addColumn("073"); 
                model.addColumn("080");  model.addColumn("083"); 
                model.addColumn("090");  model.addColumn("093"); 
                model.addColumn("100");  model.addColumn("103");
                model.addColumn("110");  model.addColumn("113"); 
                model.addColumn("120");  model.addColumn("123"); 
                model.addColumn("130");  model.addColumn("133"); 
                model.addColumn("140");  model.addColumn("143"); 
                model.addColumn("150");  model.addColumn("153"); 
                model.addColumn("160");  model.addColumn("163"); 
                model.addColumn("170");  model.addColumn("173"); 
                model.addColumn("180");  model.addColumn("183"); 
                model.addColumn("190");  model.addColumn("193"); 
                model.addColumn("200");  model.addColumn("203"); 
                model.addColumn("210");  model.addColumn("213"); 
                model.addColumn("220");  model.addColumn("223"); 
                model.addColumn("230");  model.addColumn("233"); 
                
                TableColumn columna1 = jTableModeloGeneral.getColumn("p");
                TableColumn columna2 = jTableModeloGeneral.getColumn("000"); TableColumn columna3 = jTableModeloGeneral.getColumn("003"); 
                TableColumn columna4 = jTableModeloGeneral.getColumn("010"); TableColumn columna5 = jTableModeloGeneral.getColumn("013"); 
                TableColumn columna6 = jTableModeloGeneral.getColumn("020"); TableColumn columna7 = jTableModeloGeneral.getColumn("023"); 
                TableColumn columna8 = jTableModeloGeneral.getColumn("030"); TableColumn columna9 = jTableModeloGeneral.getColumn("033"); 
                TableColumn columna10 = jTableModeloGeneral.getColumn("040"); TableColumn columna11 = jTableModeloGeneral.getColumn("043");
                TableColumn columna12 = jTableModeloGeneral.getColumn("050"); TableColumn columna13 = jTableModeloGeneral.getColumn("053");
                TableColumn columna14 = jTableModeloGeneral.getColumn("060"); TableColumn columna15 = jTableModeloGeneral.getColumn("063");
                TableColumn columna16 = jTableModeloGeneral.getColumn("070"); TableColumn columna17 = jTableModeloGeneral.getColumn("073");
                TableColumn columna18 = jTableModeloGeneral.getColumn("080"); TableColumn columna19 = jTableModeloGeneral.getColumn("083");
                TableColumn columna20 = jTableModeloGeneral.getColumn("090"); TableColumn columna21 = jTableModeloGeneral.getColumn("093");
                TableColumn columna22 = jTableModeloGeneral.getColumn("100"); TableColumn columna23 = jTableModeloGeneral.getColumn("103");
                TableColumn columna24 = jTableModeloGeneral.getColumn("110"); TableColumn columna25 = jTableModeloGeneral.getColumn("113");
                TableColumn columna26 = jTableModeloGeneral.getColumn("120"); TableColumn columna27 = jTableModeloGeneral.getColumn("123");
                TableColumn columna28 = jTableModeloGeneral.getColumn("130"); TableColumn columna29 = jTableModeloGeneral.getColumn("133");
                TableColumn columna30 = jTableModeloGeneral.getColumn("140"); TableColumn columna31 = jTableModeloGeneral.getColumn("143");
                TableColumn columna32 = jTableModeloGeneral.getColumn("150"); TableColumn columna33 = jTableModeloGeneral.getColumn("153");
                TableColumn columna34 = jTableModeloGeneral.getColumn("160"); TableColumn columna35 = jTableModeloGeneral.getColumn("163");
                TableColumn columna36 = jTableModeloGeneral.getColumn("170"); TableColumn columna37 = jTableModeloGeneral.getColumn("173");
                TableColumn columna38 = jTableModeloGeneral.getColumn("180"); TableColumn columna39 = jTableModeloGeneral.getColumn("183");
                TableColumn columna40 = jTableModeloGeneral.getColumn("190"); TableColumn columna41 = jTableModeloGeneral.getColumn("193");
                TableColumn columna42 = jTableModeloGeneral.getColumn("200"); TableColumn columna43= jTableModeloGeneral.getColumn("203");
                TableColumn columna44 = jTableModeloGeneral.getColumn("210"); TableColumn columna45 = jTableModeloGeneral.getColumn("213");
                TableColumn columna46 = jTableModeloGeneral.getColumn("220"); TableColumn columna47 = jTableModeloGeneral.getColumn("223");
                TableColumn columna48 = jTableModeloGeneral.getColumn("230"); TableColumn columna49 = jTableModeloGeneral.getColumn("233");
               
                columna1.setMinWidth(25);                
                columna2.setMinWidth(20);                columna3.setMinWidth(20);                
                columna4.setMinWidth(20);                columna5.setMinWidth(20);         
                columna6.setMinWidth(20);                columna7.setMinWidth(20);         
                columna8.setMinWidth(20);                columna9.setMinWidth(20);     
                columna10.setMinWidth(20);             columna11.setMinWidth(20);
                columna12.setMinWidth(20);             columna13.setMinWidth(20);
                columna14.setMinWidth(20);             columna15.setMinWidth(20);
                columna16.setMinWidth(20);             columna17.setMinWidth(20);
                columna18.setMinWidth(20);             columna19.setMinWidth(20);
                columna20.setMinWidth(20);             columna21.setMinWidth(20);
                columna22.setMinWidth(20);             columna23.setMinWidth(20);
                columna24.setMinWidth(20);             columna25.setMinWidth(20);
                columna26.setMinWidth(20);             columna27.setMinWidth(20);
                columna28.setMinWidth(20);             columna29.setMinWidth(20);
                columna30.setMinWidth(20);             columna31.setMinWidth(20);
                columna32.setMinWidth(20);             columna33.setMinWidth(20);
                columna34.setMinWidth(20);             columna35.setMinWidth(20);
                columna36.setMinWidth(20);             columna37.setMinWidth(20);
                columna38.setMinWidth(20);             columna39.setMinWidth(20);
                columna40.setMinWidth(20);             columna41.setMinWidth(20);
                columna42.setMinWidth(20);             columna43.setMinWidth(20);
                columna44.setMinWidth(20);             columna45.setMinWidth(20);
                columna46.setMinWidth(20);             columna47.setMinWidth(20);
                columna48.setMinWidth(20);             columna49.setMinWidth(20);
                    
     //           jTableModeloGeneral.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
                jTableModeloGeneral.getTableHeader().setReorderingAllowed(false);
                
                jScrollPane9.setViewportView(jTableModeloGeneral);
        
}
public void actualizaTablas(int perfil,int diaTipo) {
    int i,j ;
    
    Object[] fila = new Object[49];
    for (i=0;i<this.nInventario; i++){
             
                 fila[0] = redondear(this.fTablaPonderaciones[perfil][i][diaTipo],2);  
               
                               
                  for ( j = 0; j <48; j++)  {
                                fila[j+1] = redondear(this.fTablaPotenciasInst[perfil][i][j][diaTipo],2);          // es para cargar los datos en filas a la tabla modelo
                      
                  }     
                                  
                  this.model.addRow(fila);                      // añadimos filas a la tabla
    }
    
    jScrollPane9.setViewportView(jTableModeloGeneral);
    
}
// ------------------------------------------------------------------------------------------------------------------------
   public double redondear( double numero, int decimales ) {
    return Math.round(numero*Math.pow(10,decimales))/Math.pow(10,decimales);
  }
}
