/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.myorg.acmod01;

import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JTree;
import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
import org.netbeans.api.settings.ConvertAsProperties;
import org.openide.awt.ActionID;
import org.openide.awt.ActionReference;
import org.openide.windows.TopComponent;
import org.openide.util.NbBundle.Messages;

import conexion.Conexion;

import dao.explorerDao;
import javax.swing.JOptionPane;

/**
 * Top component which displays something.
 */
@ConvertAsProperties(
        dtd = "-//org.myorg.acmod01//arbolExplorador//EN",
        autostore = false
)
@TopComponent.Description(
        preferredID = "arbolExploradorTopComponent",
        //iconBase="SET/PATH/TO/ICON/HERE",
        persistenceType = TopComponent.PERSISTENCE_ALWAYS
)
@TopComponent.Registration(mode = "explorer", openAtStartup = true)
@ActionID(category = "Window", id = "org.myorg.acmod01.arbolExploradorTopComponent")
@ActionReference(path = "Menu/Window" /*, position = 333 */)
@TopComponent.OpenActionRegistration(
        displayName = "#CTL_arbolExploradorAction",
        preferredID = "arbolExploradorTopComponent"
)
@Messages({
    "CTL_arbolExploradorAction=Explorer",
    "CTL_arbolExploradorTopComponent=Explorer",
    "HINT_arbolExploradorTopComponent=Arbol explorador"
})
public final class arbolExploradorTopComponent extends TopComponent {
    // ..........................................................
    
    public int sup_user    = 0;
    public int nClientes    = 0;
    public int nPuntos      = 0;
    
    public String listaClientesArbol[][]  = new String [500][2];    // Alias - ID
    public String listaPuntosArbol[][]    = new String [500][2];   // Alias - ID

    // ..........................................................
    public int indGen = 0;
    public int tipo_Act, tipo_Sim;
    public int id_punto_actual;
    public int id_cliente_actual = 0;
    public double ahorro_total_actual;
    public double pAhorro = 0;
    public int nCalculosPunto;
    public int id_tipo_Actual, id_tipo_Actual_Anterior;
    public int id_tipo_Sim, id_tipo_Sim_Anterior;
    public int indiceCalculo = 0;

    // ..........................................................
    public int id_cliente_general = 0;

    // ..........................................................
    public arbolExploradorTopComponent() {
        initComponents();
        setName(Bundle.CTL_arbolExploradorTopComponent());
        setToolTipText(Bundle.HINT_arbolExploradorTopComponent());
        putClientProperty(TopComponent.PROP_CLOSING_DISABLED, Boolean.TRUE);
        putClientProperty(TopComponent.PROP_MAXIMIZATION_DISABLED, Boolean.TRUE);

        crearArbol();
     
    
        //     modificarArbolNuevos() ;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane4 = new javax.swing.JScrollPane();
        arbol = new javax.swing.JTree();

        jScrollPane4.setViewportView(arbol);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 271, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 882, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTree arbol;
    private javax.swing.JScrollPane jScrollPane4;
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

    // ------------------------------------------------------------------------------------------------------------
    public final void crearArbol() {
        int i,j,k ;
        int id_customer = 0;
        System.out.println("Voy a crear el arbol (si puedo) ");
 
        cargarDatosArbolClientes();
        
        
            DefaultMutableTreeNode carpetaRaiz = new DefaultMutableTreeNode("CLIENTES ("+this.nClientes+")");
            /**
             * Definimos el modelo donde se agregaran los nodos
             */
            DefaultTreeModel modelo;
            modelo = new DefaultTreeModel(carpetaRaiz);
            /**
             * agregamos el modelo al arbol, donde previamente establecimos la raiz
             */
            arbol = new JTree(modelo);
        
      
        jScrollPane4.setViewportView(arbol);
        
        for (i=0; i<this.nClientes; i++){
                                                                 
                              
                DefaultMutableTreeNode carpeta = new DefaultMutableTreeNode(i+":"+this.listaClientesArbol[i][1]);
                modelo.insertNodeInto(carpeta, carpetaRaiz, i);   
               
                id_customer = Integer.valueOf(this.listaClientesArbol[i][0]) ;
                cargarDatosArbolPuntos(id_customer);                                            // cargamos datos de puntos y actualizamos nPuntos
                 
                for (j=0; j<this.nPuntos; j++){
                    
                    DefaultMutableTreeNode carpeta2 = new DefaultMutableTreeNode(j+" -"+this.listaPuntosArbol[j][1]);
                    modelo.insertNodeInto(carpeta2, carpeta, j);   
                      
                    for (k=0; k<5; k++) {
                        
                        DefaultMutableTreeNode carpeta3 = new DefaultMutableTreeNode("Dato "+k);
                        modelo.insertNodeInto(carpeta3, carpeta2, k);   
                        
                    }
                    
                    
                }
                  
             
           }    
            // ................................................................................
        /**
         * definimos los eventos
         */
        //  arbol.getSelectionModel().addTreeSelectionListener((TreeSelectionListener) this);
        /**
         * Definimos mas nodos del arbol y se lo agregamos al modelo
         */
        /*
        DefaultMutableTreeNode carpeta2 = new DefaultMutableTreeNode("San Juan de Alicante");
        DefaultMutableTreeNode archivo1 = new DefaultMutableTreeNode("Municipio: Alicante");
        DefaultMutableTreeNode archivo2 = new DefaultMutableTreeNode("Tarifa: 3.0A");
        DefaultMutableTreeNode archivo3 = new DefaultMutableTreeNode("Superficie: 765 m2");

        DefaultMutableTreeNode carpeta3 = new DefaultMutableTreeNode("CENTRO LOGISTICO");
        DefaultMutableTreeNode archivo31 = new DefaultMutableTreeNode("Municipio: Jumilla");
        DefaultMutableTreeNode archivo32 = new DefaultMutableTreeNode("Tarifa: 3.1A");
        DefaultMutableTreeNode archivo33 = new DefaultMutableTreeNode("Superficie: 20.793 m2");

        DefaultMutableTreeNode carpeta4 = new DefaultMutableTreeNode("Arnau de Vilanova 5");
        DefaultMutableTreeNode archivo41 = new DefaultMutableTreeNode("Municipio: Sueca");
        DefaultMutableTreeNode archivo42 = new DefaultMutableTreeNode("Tarifa: 3.0A");
        DefaultMutableTreeNode archivo43 = new DefaultMutableTreeNode("Superficie: 769 m2");

        DefaultMutableTreeNode carpeta5 = new DefaultMutableTreeNode("Av. Miguel Hernandez 3, BJO-1");
        DefaultMutableTreeNode archivo51 = new DefaultMutableTreeNode("Municipio: Finestrat");
        DefaultMutableTreeNode archivo52 = new DefaultMutableTreeNode("Tarifa: 3.0A");
        DefaultMutableTreeNode archivo53 = new DefaultMutableTreeNode("Superficie: 746 m2");

        DefaultMutableTreeNode carpeta6 = new DefaultMutableTreeNode("Av. Mediterrani, 145 bis");
        DefaultMutableTreeNode archivo61 = new DefaultMutableTreeNode("Municipio: Petrer");
        DefaultMutableTreeNode archivo62 = new DefaultMutableTreeNode("Tarifa: 3.1A");
        DefaultMutableTreeNode archivo63 = new DefaultMutableTreeNode("Superficie: 801 m2");

        DefaultMutableTreeNode carpeta7 = new DefaultMutableTreeNode("C. Paris, 2. 2 esc. B, bajo 1");
        DefaultMutableTreeNode archivo71 = new DefaultMutableTreeNode("Municipio: Moraira");
        DefaultMutableTreeNode archivo72 = new DefaultMutableTreeNode("Tarifa: 3.0A");
        DefaultMutableTreeNode archivo73 = new DefaultMutableTreeNode("Superficie: 746 m2");

        DefaultMutableTreeNode carpeta8 = new DefaultMutableTreeNode("Pais Vaencia, 1");
        DefaultMutableTreeNode archivo81 = new DefaultMutableTreeNode("Municipio: Alqueria de la Comtessa");
        DefaultMutableTreeNode archivo82 = new DefaultMutableTreeNode("Tarifa: 3.1A");
        DefaultMutableTreeNode archivo83 = new DefaultMutableTreeNode("Superficie: 773 m2");
*/
        /**
         * Definimos donde se agrega el nodo, dentro de que rama y que posicion
         */
        /*
        modelo2.insertNodeInto(carpeta2, carpetaRaiz, 0);
        modelo2.insertNodeInto(carpeta3, carpetaRaiz, 1);
        modelo2.insertNodeInto(carpeta4, carpetaRaiz, 2);
        modelo2.insertNodeInto(carpeta5, carpetaRaiz, 3);
        modelo2.insertNodeInto(carpeta6, carpetaRaiz, 4);
        modelo2.insertNodeInto(carpeta7, carpetaRaiz, 5);
        modelo2.insertNodeInto(carpeta8, carpetaRaiz, 6);

        modelo2.insertNodeInto(archivo1, carpeta2, 0);
        modelo2.insertNodeInto(archivo2, carpeta2, 1);
        modelo2.insertNodeInto(archivo3, carpeta2, 2);

        modelo2.insertNodeInto(archivo31, carpeta3, 0);
        modelo2.insertNodeInto(archivo32, carpeta3, 1);
        modelo2.insertNodeInto(archivo33, carpeta3, 2);

        modelo2.insertNodeInto(archivo41, carpeta4, 0);
        modelo2.insertNodeInto(archivo42, carpeta4, 1);
        modelo2.insertNodeInto(archivo43, carpeta4, 2);

        modelo2.insertNodeInto(archivo51, carpeta5, 0);
        modelo2.insertNodeInto(archivo52, carpeta5, 1);
        modelo2.insertNodeInto(archivo53, carpeta5, 2);

        modelo2.insertNodeInto(archivo61, carpeta6, 0);
        modelo2.insertNodeInto(archivo62, carpeta6, 1);
        modelo2.insertNodeInto(archivo63, carpeta6, 2);

        modelo2.insertNodeInto(archivo71, carpeta7, 0);
        modelo2.insertNodeInto(archivo72, carpeta7, 1);
        modelo2.insertNodeInto(archivo73, carpeta7, 2);

        modelo2.insertNodeInto(archivo81, carpeta8, 0);
        modelo2.insertNodeInto(archivo82, carpeta8, 1);
        modelo2.insertNodeInto(archivo83, carpeta8, 2);
*/
    }

    // ----------------------------------------------------------------------------------------------------------------
    public final void modificarArbolNuevos() {

        int i, j, k, cnt, nCUPS, dia = 1, ndia = 0, cdia = 1, ind = 0;
        String fecha = "", contrato = "";
        String nombre = "";
        String sdia = "", CUPS, str = "";

        cnt = this.nPuntos;

        System.out.println("Voy a modificar el arbol nuevo tenemos un total de puntos de:" + cnt);

        DefaultMutableTreeNode carpetaRaiz = new DefaultMutableTreeNode("PUNTOS SUMINISTRO");
        /**
         * Definimos el modelo donde se agregaran los nodos
         */
        DefaultTreeModel modelo2;
        modelo2 = new DefaultTreeModel(carpetaRaiz);
        /**
         * agregamos el modelo al arbol, donde previamente establecimos la raiz
         */

        arbol = new JTree(modelo2);
        jScrollPane4.setViewportView(arbol);

        DefaultMutableTreeNode carpeta = new DefaultMutableTreeNode("CARGADOS (" + this.nPuntos + ")");     // Comenzamos con el primer punto
        modelo2.insertNodeInto(carpeta, carpetaRaiz, 0);

        /*
            for (i=0; i<this.nPuntos; i++){
               CUPS = this.listaPuntosSum[i][2] ;                                                           // Insertamos primero el cups
               CUPS = CUPS.trim();
               nCUPS = CUPS.length();

               if ( nCUPS>0){
                    DefaultMutableTreeNode archivo = new DefaultMutableTreeNode(i+" "+this.listaPuntosSum[i][2]);
                    modelo2.insertNodeInto(archivo, carpeta, i);
               } else {


                        DefaultMutableTreeNode archivo = new DefaultMutableTreeNode(i+" -");
                        modelo2.insertNodeInto(archivo, carpeta, i);

              }
           }
         */
        // ................................................................................
        arbol.addTreeSelectionListener(new TreeSelectionListener() {
            @Override

            public void valueChanged(TreeSelectionEvent e) {
                // se obtiene el nodo seleccionado
                DefaultMutableTreeNode nseleccionado = (DefaultMutableTreeNode) arbol.getLastSelectedPathComponent();

                int nivel = nseleccionado.getDepth();
                System.out.println("El nivel de campo es =" + nivel);

                if (nivel == 0) {

                    String nodo = nseleccionado.getUserObject().toString();
                    String[] campos = nodo.split("\\s+");
                    int indice = Integer.parseInt(campos[0]);

                    System.out.println("El indice de campo es =" + indice);
                    // actualizarFormularios(indice);

                }
            }
        });

        // ................................................................................
    }
    // ------------------------------------------------------------------------------------------------------------

    public void cargarDatosArbolClientes()  {
        int i, j;
        
         explorerDao miexplorerDao = new explorerDao();
               
        // .......................................................
         miexplorerDao.cargarDatosClientes(this.sup_user);                    

        this.nClientes               = miexplorerDao.nClientes;   System.out.println("nPuntos="+this.nPuntos  );
        this.listaClientesArbol  = miexplorerDao.listaArbol ;

    }
    // ------------------------------------------------------------------------------------------------------------
    public void cargarDatosArbolPuntos(int id_customer)  {
        int i, j;
        
         explorerDao miexplorerDao = new explorerDao();
               
        // .......................................................
         miexplorerDao.cargarDatosPuntos(id_customer);                    

        this.nPuntos             = miexplorerDao.nPuntos;   System.out.println("nPuntos="+this.nPuntos  );
        this.listaPuntosArbol = miexplorerDao.listaArbol ;

    }
    // ------------------------------------------------------------------------------------------------------------
 
  

}
