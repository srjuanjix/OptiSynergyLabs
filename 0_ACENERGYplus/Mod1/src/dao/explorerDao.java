/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import conexion.Conexion;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;

/**
 *
 * @author jab7b7
 */
public class explorerDao {
       
    // ------------------------------------------------------------------------------------------------------------------
    public String listaArbol[][]                             = new String[500][2];  
    public String listaDatos[][]                           = new String[1000][4];  
    
    public int nClientes = 0; 
    public int nPuntos = 0;
  // ------------------------------------------------------------------------------------------------------------------     
          
 // ------------------------------------------------------------------------------------------------------------------
 public int cargarDatosClientes(int id_sup_user) {
		 
            Conexion conex = new Conexion();
            int estadoInsert = 0 ;
            
            
            String sqlStr="SELECT alias,id  FROM t_customers WHERE id_sup_user="+id_sup_user+" ORDER BY id asc";

            try {
	Statement estatuto = conex.getConnection().createStatement();
	ResultSet rs = estatuto.executeQuery(sqlStr);

                  int contador = 0;

                  while (rs.next()) {

                            contador++;

                  }
                        
                   this.nClientes = contador;
                         
                   if (contador >0){
                           
                            rs.beforeFirst();
                            contador = 0;
                            while (rs.next()) {
                                    listaArbol[contador][0] = Integer.toString(rs.getInt("id")) ;   
                                    listaArbol[contador][1] = rs.getString("alias");     
                                    contador++;
                            }
                  } 
                  rs.close();
	estatuto.close();
	conex.desconectar();
                  
                  System.out.println("He cargado "+this.nClientes+" P");             

	} catch (SQLException e) {
			System.out.println(e.getMessage());
                     
	}
                   return 1;
 }
 // ------------------------------------------------------------------------------------------------------------------   
  public int cargarDatosPuntos(int id_customer) {
		 
            Conexion conex = new Conexion();
            int estadoInsert = 0 ;
            
            
            String sqlStr="SELECT alias,id  FROM t_customers_contact WHERE id_customer="+id_customer+" ORDER BY id asc";

            try {
	Statement estatuto = conex.getConnection().createStatement();
	ResultSet rs = estatuto.executeQuery(sqlStr);

                  int contador = 0;

                  while (rs.next()) {

                            contador++;

                  }
                        
                   this.nPuntos = contador;
                         
                   if (contador >0){
                           
                            rs.beforeFirst();
                            contador = 0;
                            while (rs.next()) {
                                    listaArbol[contador][0] = Integer.toString(rs.getInt("id")) ;   
                                    listaArbol[contador][1] = rs.getString("alias");     
                                    contador++;
                            }
                  } 
                  rs.close();
	estatuto.close();
	conex.desconectar();
                  
                  System.out.println("He cargado "+this.nPuntos+" P");             

	} catch (SQLException e) {
			System.out.println(e.getMessage());
                     
	}
                   return 1;
 }
 // ------------------------------------------------------------------------------------------------------------------ 
  
  public int cargarDatosGeograficosPuntos(int id_customer) {
             String sqlStr = "";
            Conexion conex = new Conexion();
            int estadoInsert = 0 ;
            
            if (id_customer ==0) {
            
                 sqlStr="SELECT id,alias,lat,lon  FROM t_customers_contact  ORDER BY id asc";
                
            } else {
            
                 sqlStr="SELECT id,alias,lat,lon FROM t_customers_contact WHERE id_customer="+id_customer+" ORDER BY id asc";
                
            }
            // .................................................................................................................
            try {
	Statement estatuto = conex.getConnection().createStatement();
	ResultSet rs = estatuto.executeQuery(sqlStr);

                  int contador = 0;

                  while (rs.next()) {

                            contador++;

                  }
                        
                   this.nPuntos = contador;
                         
                   if (contador >0){
                           
                            rs.beforeFirst();
                            contador = 0;
                            while (rs.next()) {
                                    listaDatos[contador][0] = Integer.toString(rs.getInt("id")) ;   
                                    listaDatos[contador][1] = rs.getString("alias");     
                                    listaDatos[contador][2] = rs.getString("lat");   
                                    listaDatos[contador][3] = rs.getString("lon");   
                                    contador++;
                            }
                  } 
                  rs.close();
	estatuto.close();
	conex.desconectar();
                  
                  System.out.println("He cargado "+this.nPuntos+" P");             

	} catch (SQLException e) {
			System.out.println(e.getMessage());
                     
	}
                   return 1;
 }
 // ------------------------------------------------------------------------------------------------------------------ 
}
