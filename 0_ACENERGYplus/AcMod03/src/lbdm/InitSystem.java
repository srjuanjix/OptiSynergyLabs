/*
 * Copyright 2014 jab7b7.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package lbdm;

import com.csvreader.CsvReader;
import com.csvreader.CsvWriter;
import java.io.FileNotFoundException;
import java.io.IOException;

/*
 * CLASE InitSystem (Linear Bounde Discret Model)
 * Autor: Juan José Albarracín 2005-2014
 * Active Energy Model Group.
 */

public class InitSystem {
    
    private boolean readRecord;
    public String sLineas[]                                   = new String [20] ;
    public int nLineas                                           = 0 ;
    public  String tablaInventario[][][]                  = new String[8][5][100] ;    
    public int nElementos[]                                  = new int[20];
    public String  sTemporadas[]                        = new String[12] ;
    public int nTemporadas                                 = 0 ;
    public int nMesesTipo                                    = 0;
    public int nDiasTipo                                       = 0;
    public String sDiasTipo[]                               = new String[7] ;

    
        /**
	 * Metodo que permite leer un archivo CSV y cargarlo en memoria el inventario convenientemente parseado
	 * Entradas:    
         *              
	 * @return tabla string de 7 columnas ("Codigo", "Linea", "Zona", "Local","Elemento", "Cantidad","Pot. Nom. KW")
         * @throws java.io.FileNotFoundException
	 */
     public String[][] leeDatosCsvEntrada(String sNombre) throws FileNotFoundException {
       
            int n       = 0 ;         // Numero de elementos a leer de la tabla
            int p       = 0 ;           // Posicion de inicio de lectura de la tabla
            int d       = 0 ;
            int cnt     = 0 ;           // contador principal
            int intcnt  = 0 ;           // contador interno.   
            int dias    = 0 ;           // Cuenta dias de la semama
            int nInventario=0 ;
            
            int fInicio = 0 ;           // flag inicio de lectura del bloque de inventario
            String sEntrada = "" ;
            
           System.out.println("ESTOY DENTRO");
            
           String tablaInventario[][][] = new String[8][5][100] ;    // Tabla temporal con los datos a procesar.
           String tablaResultado[][] = new String[100][7] ;
            // ............................................................................ 
            //Le pasamos la URL del archivo CSV a leer.

           CsvReader reader = new CsvReader(sNombre);

            // ............................................................................ 
          
            try {
            while (reader.readRecord())
            {
               sEntrada    = reader.get(0);           //reader.get(Integer) - devuelve el contenido del numero de columna que le pasamos.
             //   System.out.println("ANALIZO palabro :"+sEntrada);
               // ------------------------------------ 
               if ("INVENTARIO".equals(sEntrada)) {             
                    nInventario =  Integer.parseInt(reader.get(1)); System.out.println("INVENTARIO ="+nInventario);
                    fInicio = 1;                          // flag inicio activado   
               }
               // ------------------------------------     Sacamos los nombres de las líneas           
       //        System.out.println(" Sacamos los nombres de las líneas   ");
               this.nLineas = nInventario ;
               if ( nInventario > 0 && fInicio == 1 ) {  
                   boolean readRecord = reader.readRecord()   ;                   // cambiamos de registro.
                   sEntrada    = reader.get(0);                                              // el primer registro no sirve 
                   for (n=0; n< nInventario; n++){
                        tablaInventario[n][0][0] = sEntrada ; 
                        this.sLineas[n]         = sEntrada ;
                       System.out.println(n+" -SEntrada="+sEntrada);
                      
                        sEntrada    = reader.get(n+1);
                    }                  
                   fInicio = 2 ;                   
               }
               // ------------------------------------
               if ( nInventario > 0 && fInicio == 2 ) {
                   readRecord = reader.readRecord()   ;                   // cambiamos de registro.
                           
                   for ( n=0 ; n < nInventario; n++){
                       sEntrada = reader.get(0) ;
                       p = Integer.parseInt(reader.get(1)) ;               // sacamos el número de elementos
                       this.nElementos[n] = p;                                  System.out.println("Tenemos n elementos:"+this.nElementos[n]+" para la línea: "+this.sLineas[n]);
                       for (d=0; d < p; d++){
                           readRecord = reader.readRecord()   ;                   // cambiamos de registro.
                                
                           tablaInventario[n][d][0] = reader.get(0);  
                           tablaInventario[n][d][1] = reader.get(1);  
                           tablaInventario[n][d][2] = reader.get(2);  
                           tablaInventario[n][d][3] = reader.get(3);  
                           tablaInventario[n][d][4] = reader.get(4); 
                           tablaInventario[n][d][5] = reader.get(5); 
                          
                           tablaResultado[intcnt][0] = reader.get(0); 
                           tablaResultado[intcnt][1] = sEntrada; 
                           tablaResultado[intcnt][2] = reader.get(1); 
                           tablaResultado[intcnt][3] = reader.get(2); 
                           tablaResultado[intcnt][4] = reader.get(3); 
                           tablaResultado[intcnt][5] = reader.get(4); 
                           tablaResultado[intcnt][6] = reader.get(5); 
                           intcnt ++ ;
                       }                       
                       readRecord = reader.readRecord()   ;  // volvemos a cambiar de registro                                            
                   }
                                   
                   fInicio = 3 ;                   
               }           
               
               if ( fInicio == 3 ){ break; }    // Salimos si hemos cumplido la mision.   
               
            }
            } catch (IOException e) {
            }
            reader.close();
    //        System.out.println("El contador interno marca al salir:"+intcnt);
            
            
            this.tablaInventario = tablaInventario ;                                        // pasamos a la tabla publica
            
            return tablaResultado;
        }
    /**
	 * Metodo que permite leer un archivo CSV y cargarlo en memoria el inventario convenientemente parseado
	 * 
	 * @return
         * @throws java.io.FileNotFoundException
	 */
        public String[][][] leeDatosCsvPerfilesString(int Q,String sNombre) throws FileNotFoundException {
       
            int n       = 0 ;         // Numero de elementos a leer de la tabla
            int p       = 0 ;           // Posicion de inicio de lectura de la tabla
            int d       = 0 ;
            int cnt     = 0 ;           // contador principal
            int intcnt  = 0 ;           // contador interno.   
            int dias    = 0 ;           // Cuenta dias de la semama
            int nInventario=0 ;
            int nDiasTipo = 0 ;
            
            int fInicio = 0 ;           // flag inicio de lectura del bloque de inventario
           String sEntrada = "" ;
            
       //    System.out.println("ESTOY DENTRO de PERFILES");
            
           String tablaResultado[][][] = new String[200][49][7] ;
            // ............................................................................ 
            //Le pasamos la URL del archivo CSV a leer.
           CsvReader reader = new CsvReader(sNombre);
           
           boolean readRecord   ;                  
              
            // ............................................................................ 
            
            try {
            while (reader.readRecord())
            {
                
                sEntrada    = reader.get(0);           //reader.get(Integer) - devuelve el contenido del numero de columna que le pasamos.
          //      System.out.println("Analizo sEntrada = "+sEntrada);  
               // ------------------------------------ 
               if ("PERFILQ24".equals(sEntrada)) {             
                    nInventario =  Integer.parseInt(reader.get(1)); 
                    nDiasTipo   = Integer.parseInt(reader.get(2));
                    fInicio     = 1;    
                    intcnt      =0 ;   
            //        System.out.println("Hemos encontrado la palabra PERFILQ24 ("+nInventario+") num total ="+nInventario+" dias Tipo ="+nDiasTipo);
               } 
               // ------------------------------------ 
               if ("PERFILQ3".equals(sEntrada)) {             
                    nInventario =  Integer.parseInt(reader.get(1)); 
                    nDiasTipo   = Integer.parseInt(reader.get(2));
                    fInicio = 2;   
                    intcnt      =0 ;   
             //        System.out.println("Hemos encontrado la palabra PERFILQ3 ("+nInventario+") num total ="+nInventario+" dias Tipo ="+nDiasTipo);// flag inicio activado   
              } 
               if ("PERFILQ1".equals(sEntrada)) {             
                    nInventario =  Integer.parseInt(reader.get(1)); 
                    nDiasTipo   = Integer.parseInt(reader.get(2));
                    fInicio = 3;
                    intcnt      =0 ;   
              //       System.out.println("Hemos encontrado la palabra PERFILQ1 ("+nInventario+") num total ="+nInventario+" dias Tipo ="+nDiasTipo);// flag inicio activado   
              } 
               // ------------------------------------     Sacamos los datos para el perfil primavera-otoño   
               if ( nInventario > 0 && fInicio == 1 && Q == 1) {  
                   readRecord = reader.readRecord()   ;       // cambiamos de registro.       
                   for (n=0; n< nInventario; n++){
                //       System.out.println("dt="+nDiasTipo +" -Sacamos los datos de las línea: " + intcnt );
                       for (d=0; d<=48; d++){
                            tablaResultado[intcnt][d][nDiasTipo] = reader.get(d) ;               
                            
                        }    
                        readRecord = reader.readRecord()   ;                   // cambiamos de registro.
                  
                        intcnt ++;           
                   }                  
                   fInicio = 0 ;                   
               }
               // ------------------------------------     Sacamos los datos para el perfil primavera-otoño   
               if ( nInventario > 0 && fInicio == 2 && Q == 2) {  
               //    String tablaResultado[][] = new String[nInventario][48] ;
                // System.out.println("Nos piden inventario Q2 dia tipo="+nDiasTipo);
                   readRecord = reader.readRecord()   ;                   // cambiamos de registro.
                               
                   for (n=0; n< nInventario; n++){
                  //      System.out.println("Q="+Q+" -Sacamos los datos de las línea: " + intcnt );
                        for (d=0; d<=48; d++){
                            tablaResultado[intcnt][d][nDiasTipo] = reader.get(d) ;                          
                        }   
                        readRecord = reader.readRecord()   ;                   // cambiamos de registro.
                        intcnt ++;           
                   }                  
                   fInicio = 0 ;                   
               }
               // ------------------------------------     Sacamos los datos para el perfil primavera-otoño   
               if ( nInventario > 0 && fInicio == 3 && Q == 3) {  
               //    System.out.println("Nos piden inventario Q3");
                    readRecord = reader.readRecord()   ;                   // cambiamos de registro.
               //    String tablaResultado[][] = new String[nInventario][48] ;           
                   for (n=0; n< nInventario; n++){
                    //   System.out.println("Q="+Q+" -Sacamos los datos de las línea: " + intcnt );
                        for (d=0; d<=48; d++){
                           tablaResultado[intcnt][d][nDiasTipo] = reader.get(d) ;                           
                        }       
                        readRecord = reader.readRecord()   ;                   // cambiamos de registro.
                        intcnt ++;           
                   }                  
                   fInicio = 0 ;                   
               }
               // ------------------------------------              
               
               if ( fInicio == 4 ){ break; }    // Salimos si hemos cumplido la mision.   
               
            }
            } catch (IOException e) {
            }
            reader.close();
       //     System.out.println("El contador interno marca al salir:"+intcnt);
            
            
            
            
            return tablaResultado;
        }
        
        /**
	 * Metodo que permite leer un archivo CSV de inventario y sacar el número de elementos
	 * 
	 * @return int numero de filas (elementos) del inventario.
         * @throws java.io.FileNotFoundException
	 */
        
        public int leeCantidadInventario(String nombre) throws FileNotFoundException {
       
            int n       = 0 ;         // Numero de elementos a leer de la tabla
            int p       = 0 ;           // Posicion de inicio de lectura de la tabla
            int d       = 0 ;
            int cnt     = 0 ;           // contador principal
            int intcnt  = 0 ;           // contador interno.   
            int dias    = 0 ;           // Cuenta dias de la semama
            int nInventario=0 ;
            
            int fInicio = 0 ;           // flag inicio de lectura del bloque de inventario
            String sEntrada = "" ;
            
           System.out.println("ESTOY DENTRO CONTROL NUMERO INVENTARIO");
            
           String tablaInventario[][][] = new String[8][5][100] ;    // Tabla temporal con los datos a procesar.
           String tablaResultado[][] = new String[100][7] ;
            // ............................................................................ 
            //Le pasamos la URL del archivo CSV a leer.
           //  CsvReader reader = new CsvReader("/home/jab7b7/Energia/Aldi.csv");
            CsvReader reader = new CsvReader(nombre);
            //CsvReader reader = new CsvReader("~/Energia/Aldi.csv");
            //Le pasamos la URL del archivo CSV a escribir.
            // ............................................................................ 
          
            try {
            while (reader.readRecord())
            {
               sEntrada    = reader.get(0);           //reader.get(Integer) - devuelve el contenido del numero de columna que le pasamos.
        //       System.out.println("ANALIZO palabro :"+sEntrada);
               // ------------------------------------ 
               if ("INVENTARIO".equals(sEntrada)) {             
                    nInventario =  Integer.parseInt(reader.get(1)); 
                    fInicio = 1;                          // flag inicio activado   
    //                  System.out.println("Hemos encontrado la palabra INVENTARIO num total ="+nInventario);
               }
               // ------------------------------------     Sacamos los nombres de las líneas           
               if ( nInventario > 0 && fInicio == 1 ) {  
                   boolean readRecord = reader.readRecord()   ;                   // cambiamos de registro.
                               
                   for (n=0; n< nInventario; n++){
                        tablaInventario[n][0][0] = sEntrada ;
                        sEntrada    = reader.get(n);
         //                System.out.println("Sacamos los nombres de las líneas: " + n + " -> "+sEntrada);
                   }                  
                   fInicio = 2 ;                   
               }
               // ------------------------------------
               if ( nInventario > 0 && fInicio == 2 ) {
                   readRecord = reader.readRecord()   ;                   // cambiamos de registro.
                           
                   for ( n=0 ; n < nInventario; n++){
                       sEntrada = reader.get(0) ;
                       p = Integer.parseInt(reader.get(1)) ;               // sacamos el número de elementos
          //             System.out.println("........................... Empezamos con línea :"+n+" ... Hay "+p+" elementos a procesar");
                       for (d=0; d < p; d++){
                           readRecord = reader.readRecord()   ;                   // cambiamos de registro.                          
                           intcnt ++ ;
                       }                       
                       readRecord = reader.readRecord()   ;  // volvemos a cambiar de registro                                            
                   }
                                   
                   fInicio = 3 ;                   
               }           
               
               if ( fInicio == 3 ){ break; }    // Salimos si hemos cumplido la mision.   
               
            }
            } catch (IOException e) {
            }
            reader.close();
       //     System.out.println("El contador interno marca al salir:"+intcnt);
                                  
            
            return intcnt;
        }
        

         public String[][] ResultadoCero() throws FileNotFoundException {
       
                             
        //  String tablaResultado[][] = new String[3][9] ;
         
         int i,j ;
             
         String tablaResultado[][] = new String[5][9] ;    
             
         
         for ( i=0 ; i<5; i++){
             for (j=0;j<9; j++){
                 tablaResultado[i][j] = "0" ;
             }
         }
         
           
         return tablaResultado ; 
         }
         
         /**
	 * Metodo que permite leer un archivo CSV el calendario laboral
	 * @param sNombre => ruta y nombre del archivo
         * @return    => tablaRes[n][3] 
	 * @throws java.io.FileNotFoundException
	 */       
         
         
         
         
 public int[][] leeDatosCsvCalendario(String sNombre) throws FileNotFoundException {
       
            int d       = 0 ;
            int n       = 0 ;
            int cnt     = 0 ;           // contador principal
            int intcnt  = 0 ;           // contador interno.   
            int dias    = 0 ;           // Cuenta dias de la semama
            int nMesesTipo=0 ;
            String sEntrada ="";
            int fInicio = 0 ;           // flag inicio de lectura del bloque de inventario
            int i;
            
           System.out.println("ESTOY DENTRO LEER DATOS CALENDARIO");
            
           int tablaResultado[][] = new int[365][3] ;
            // ............................................................................ 
            //Le pasamos la URL del archivo CSV a leer.

           CsvReader reader = new CsvReader(sNombre);

            // ............................................................................ 
          
            try {
            while (reader.readRecord())
            {
               sEntrada    = reader.get(0);           //reader.get(Integer) - devuelve el contenido del numero de columna que le pasamos.
           //    System.out.println("ANALIZO palabro :"+sEntrada);
               // ------------------------------------ 
               if ("CALENDARIO".equals(sEntrada)) {             
                    nMesesTipo =  Integer.parseInt(reader.get(1)); 
                    this.nDiasTipo    = Integer.parseInt(reader.get(2)) ;   System.out.println("----- numero de días tipo:"+this.nDiasTipo) ;
                    for (i=0; i<this.nDiasTipo; i++) {
                            this.sDiasTipo[i] = reader.get(i+3);        System.out.println("Cargo dia tipo: "+this.sDiasTipo[i]) ;
                    }
                    fInicio = 1;    
        //            System.out.println("ANALIZO palabro : CALENDARIO, nMeses ="+nMesesTipo);
                      // flag inicio activado   
               }
               // ------------------------------------     Sacamos los nombres de las líneas           
               if ( nMesesTipo > 0 && fInicio == 1 ) {  
                   boolean readRecord = reader.readRecord()   ;                   // cambiamos de registro.
                               
                   for (n=0; n< nMesesTipo; n++){
                        tablaResultado[n][0] = Integer.parseInt(reader.get(1)); 
                        tablaResultado[n][1] = Integer.parseInt(reader.get(2)); 
                        tablaResultado[n][2] = Integer.parseInt(reader.get(3)); 
                        System.out.println("Estoy leyendo n="+n+ " y los datos son (a,b,c):"+tablaResultado[n][0]+","+tablaResultado[n][1]+","+tablaResultado[n][2]);
             
                        readRecord = reader.readRecord()   ;  // volvemos a cambiar de registro      
                    }    
                    break;                                      // hemos terminado por ahora
                                
               }
               // ------------------------------------
              
            }
            } catch (IOException e) {
            }
            reader.close();     
                                   
            return tablaResultado;
        }
 public int[][] leeDatosCsvTemporadas(String sNombre) throws FileNotFoundException {
       
            int d       = 0 ;
            int n       = 0 ;
            int cnt     = 0 ;           // contador principal
            int intcnt  = 0 ;           // contador interno.   
            int dias    = 0 ;           // Cuenta dias de la semama
            int nTemporadas=0 ;
            String sEntrada ="";
            int fInicio = 0,i ;           // flag inicio de lectura del bloque de inventario
            
           System.out.println("ESTOY DENTRO LEER DATOS TEMPORADAS");
            
           int tablaResultado[][] = new int[12][12] ;
            // ............................................................................ 
            //Le pasamos la URL del archivo CSV a leer.

           CsvReader reader = new CsvReader(sNombre);

            // ............................................................................ 
          
            try {
            while (reader.readRecord())
            {
               sEntrada    = reader.get(0);           //reader.get(Integer) - devuelve el contenido del numero de columna que le pasamos.
                // ------------------------------------ 
               if ("TEMPORADAS".equals(sEntrada)) {             
                    nTemporadas=  Integer.parseInt(reader.get(1)); 
                    this.nTemporadas = nTemporadas ;
                    fInicio = 1;    
               }
               for (i=0; i<nTemporadas; i++) {
                   
                   this.sTemporadas[i] = reader.get(i+2) ;
                   
               }
               // ------------------------------------     Sacamos los nombres de las líneas           
               if ( nTemporadas > 0 && fInicio == 1 ) {  
                   boolean readRecord = reader.readRecord()   ;                   // cambiamos de registro.
                                             // numero de meses de la temporada               
                   for (n=0; n< nTemporadas; n++){
                       cnt = Integer.parseInt(reader.get(0)); 
                        tablaResultado[n][0] = cnt; 
                       for (i=1; i<=cnt; i++){
                        tablaResultado[n][i] = Integer.parseInt(reader.get(i)); 
                        System.out.println("Estoy leyendo n="+n+ " y los datos son ("+i+"):"+tablaResultado[n][i]);             
                       }                    
                       readRecord = reader.readRecord()   ;  // volvemos a cambiar de registro      
                    }    
                    break;                                      // hemos terminado por ahora
                                
               }
               // ------------------------------------
              
            }
            } catch (IOException e) {
            }
            reader.close();     
                                   
            return tablaResultado;
        }          
         
}

        
   