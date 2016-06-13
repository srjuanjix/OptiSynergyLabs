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

/*
 * CLASE LBDM (Linear Bounde Discret Model)
 * Autor: Juan José Albarracín 2005-2014
 * Active Energy Model Group.
 */

package lbdm;
import lbdm.InitSystem ;
import java.io.FileNotFoundException;


/**
 *
 * @author jab7b7
 * LINEAR BOUNDED DISCRET MODEL 2014
 */
public class Lbdm {
      
    // ...........................................  DEFINICIONES PÚBLICAS DE LA CLASE
    
    public float    fTablaInventario[]                      =   new float[500] ;
    public float    fTablaPotenciasInst[][][][]        =   new float[3][500][48][7];
    public float    fTablaPonderaciones[][][]       =   new float[3][500][7];
    public String   sTablaInventario[][]                =   new String[500][6] ;  
    public String   sTablaPotenciasInst[][][]       =   new String[500][49][7];
    public String   sTablaLineas[]                        =   new String[20] ;
    public String   sTablaPeriodosP3[][]             =   new String[14][24];
    public String   sTablaPeriodosP6[][]             =   new String[15][24];
    public float    fTablaCoeficientesP6[]            =   new float[6];
    public int      iTablaDiasFestivos[]                  =  new int[12];
    public int      nInventario                                 =   0 ;
    public float    fCoefPs6                                    =   1.4064f ;
    public int      diasMes[]                                    =  new int[12] ;
    public float    fTablaPreciosPotenciaP6[]       =  new float[6] ;
    public float    fTablaPotenciasP6[]                 =  {1000f,1000f,1.1000f,1.1000f,1000f,1600f} ;
    public int      iTablaCalendario[][]                   =   new int[365][7] ;
    public int      iTablaTemporadas[][]                =  new int[12][12];
    public int      nLineas                                       = 0 ;
    
     // ........................................... 
    
    
        /**
	 * Metodo de inicio de la clase. Carga todos los datos necesarios para trabajar desde el archivo CSV
	 *   
         *              	   
         * @throws java.io.FileNotFoundException
	 */    
    public Lbdm(String nombre) throws FileNotFoundException {
         
        int i,j,k,cant ;
        float pot;
        int nDiasTipo = 3 ;
       
        
         InitSystem myinit ;                               // Hacemos una instancia de la clase de lectura de datos desde CSV
         myinit                                 = new InitSystem();              
         nInventario                        = myinit.leeCantidadInventario(nombre);                
        
         iTablaCalendario               = myinit.leeDatosCsvCalendario(nombre);   
         iTablaTemporadas            = myinit.leeDatosCsvTemporadas(nombre);
         
         sTablaInventario                = myinit.leeDatosCsvEntrada(nombre);      // Cargo la tabla de inventario en formato caracter
         
         sTablaLineas                     = myinit.sLineas ;                        // Lineas de consumo formato texto
         nLineas                              = myinit.nLineas ;                        System.out.println(" ----- TENEMOS nLineas ="+nLineas);
         
         
         
                  
         // ............................... Calculamos las potencias totales y las guardamos en una lista
         
         for (i=0; i<nInventario; i++){
             
             cant   = Integer.parseInt(sTablaInventario[i][5]) ;
             pot    = Float.parseFloat(sTablaInventario[i][6]) ;
            
             fTablaInventario[i] = cant * pot ;                     // Calculamos la potencia total de la fila
             
   //          System.out.println("Calculamos potencia de fila: " + i + " es = "+(cant*pot));                      
         }
           // ............................... Convertimos a float los perfiles medio-horarios y los guardamos en una lista
         
         int nDt =0;
              
            for (i=0 ; i<3; i++){        
                sTablaPotenciasInst    = myinit.leeDatosCsvPerfilesString(i+1,nombre) ;
                for (j=0; j<=nInventario; j++ ) {
                    for (nDt=0; nDt<nDiasTipo; nDt++){  
                        fTablaPonderaciones[i][j][nDt]        =  Float.parseFloat(sTablaPotenciasInst[j][0][nDt]) ;  
             //               System.out.println("Calculamos ponderacion de fila: " + j + " es = "+(fTablaPonderaciones[i][j][nDt])); 
                           for (k=1; k<=48; k++) {
                               fTablaPotenciasInst[i][j][k-1][nDt] = Float.parseFloat(sTablaPotenciasInst[j][k][nDt]) ;  
                           }                   
                    }
                }
            }
         
        // ............................... Damos de alta las tablas con los periodos tarifarios
         
        String sTablaPeriodosP3[][] = {
        {"P3","P3","P3","P3","P3","P3","P3","P3","P3","P2","P2","P2","P2","P2","P2","P2","P2","P1","P1","P1","P1","P1","P1","P2"},
        {"P3","P3","P3","P3","P3","P3","P3","P3","P3","P2","P2","P2","P2","P2","P2","P2","P2","P1","P1","P1","P1","P1","P1","P2"},
        {"P3","P3","P3","P3","P3","P3","P3","P3","P3","P2","P2","P2","P2","P2","P2","P2","P2","P1","P1","P1","P1","P1","P1","P2"},
        {"P3","P3","P3","P3","P3","P3","P3","P3","P3","P2","P2","P1","P1","P1","P1","P1","P2","P2","P2","P2","P2","P2","P2","P2"},
        {"P3","P3","P3","P3","P3","P3","P3","P3","P3","P2","P2","P1","P1","P1","P1","P1","P2","P2","P2","P2","P2","P2","P2","P2"},
        {"P3","P3","P3","P3","P3","P3","P3","P3","P3","P2","P2","P1","P1","P1","P1","P1","P2","P2","P2","P2","P2","P2","P2","P2"},
        {"P3","P3","P3","P3","P3","P3","P3","P3","P3","P2","P2","P1","P1","P1","P1","P1","P2","P2","P2","P2","P2","P2","P2","P2"},
        {"P3","P3","P3","P3","P3","P3","P3","P3","P3","P2","P2","P1","P1","P1","P1","P1","P2","P2","P2","P2","P2","P2","P2","P2"},
        {"P3","P3","P3","P3","P3","P3","P3","P3","P3","P2","P2","P1","P1","P1","P1","P1","P2","P2","P2","P2","P2","P2","P2","P2"},
        {"P3","P3","P3","P3","P3","P3","P3","P3","P3","P2","P2","P1","P1","P1","P1","P1","P2","P2","P2","P2","P2","P2","P2","P2"},
        {"P3","P3","P3","P3","P3","P3","P3","P3","P3","P2","P2","P2","P2","P2","P2","P2","P2","P2","P1","P1","P1","P1","P1","P1"},
        {"P3","P3","P3","P3","P3","P3","P3","P3","P3","P3","P3","P3","P3","P3","P3","P3","P3","P3","P3","P3","P2","P2","P2","P2"},
        {"P3","P3","P3","P3","P3","P3","P3","P3","P3","P3","P3","P3","P3","P3","P3","P3","P3","P3","P3","P3","P2","P2","P2","P2"},
        
        };
        
        String sTablaPeriodosP6[][] = {
        {"P2","P6","P6","P6","P6","P6","P6","P6","P6","P2","P2","P1","P1","P1","P2","P2","P2","P2","P2","P1","P1","P1","P2","P2"},
        {"P2","P6","P6","P6","P6","P6","P6","P6","P6","P2","P2","P1","P1","P1","P2","P2","P2","P2","P2","P1","P1","P1","P2","P2"},
        {"P4","P6","P6","P6","P6","P6","P6","P6","P6","P4","P4","P4","P4","P4","P4","P4","P4","P3","P3","P3","P3","P3","P3","P4"},
        {"P5","P6","P6","P6","P6","P6","P6","P6","P6","P5","P5","P5","P5","P5","P5","P5","P5","P5","P5","P5","P5","P5","P5","P5"},
        {"P5","P6","P6","P6","P6","P6","P6","P6","P6","P5","P5","P5","P5","P5","P5","P5","P5","P5","P5","P5","P5","P5","P5","P5"},
        {"P4","P6","P6","P6","P6","P6","P6","P6","P6","P4","P3","P3","P3","P3","P3","P3","P4","P4","P4","P4","P4","P4","P4","P4"},
        {"P2","P6","P6","P6","P6","P6","P6","P6","P6","P2","P2","P2","P1","P1","P1","P1","P1","P1","P1","P1","P2","P2","P2","P2"},
        {"P2","P6","P6","P6","P6","P6","P6","P6","P6","P2","P2","P2","P1","P1","P1","P1","P1","P1","P1","P1","P2","P2","P2","P2"},
        {"P6","P6","P6","P6","P6","P6","P6","P6","P6","P6","P6","P6","P6","P6","P6","P6","P6","P6","P6","P6","P6","P6","P6","P6"},
        {"P4","P6","P6","P6","P6","P6","P6","P6","P6","P4","P3","P3","P3","P3","P3","P3","P4","P4","P4","P4","P4","P4","P4","P4"},
        {"P5","P6","P6","P6","P6","P6","P6","P6","P6","P5","P5","P5","P5","P5","P5","P5","P5","P5","P5","P5","P5","P5","P5","P5"},
        {"P4","P6","P6","P6","P6","P6","P6","P6","P6","P4","P4","P4","P4","P4","P4","P4","P4","P3","P3","P3","P3","P3","P3","P4"},
        {"P2","P6","P6","P6","P6","P6","P6","P6","P6","P2","P2","P1","P1","P1","P2","P2","P2","P2","P2","P1","P1","P1","P2","P2"},
        {"P6","P6","P6","P6","P6","P6","P6","P6","P6","P6","P6","P6","P6","P6","P6","P6","P6","P6","P6","P6","P6","P6","P6","P6"},
        {"P6","P6","P6","P6","P6","P6","P6","P6","P6","P6","P6","P6","P6","P6","P6","P6","P6","P6","P6","P6","P6","P6","P6","P6"},        
        };
        
         // ............................... Coeficientes asociados a la potencia contratada
        
        float fTablaCoeficientesP6[]    = {1.0f, 0.5f, 0.37f, 0.37f, 0.37f, 0.37f, 0.17f};
        
         // ............................... Tabla dias festivos
        
        int iTablaDiasFestivos[]        = {1,6,78,107,108,111,121,285,305,340,342,359} ;
        
        // ............................... Tabla dias festivos  
        
        int diasMes[]                   = {31,28,31,30,31,15,16,30,31,30,31,30,31} ;
        
        // ............................... Tabla precios de termino potencia P6
        
        float fTablaPreciosPotenciaP6[]   = {3.175178f,1.588963f,1.162857f,1.162857f,1.162857f,0.530570f} ;
                
        // ............................... Tabla potencias contratadas P6
        
     //   float fTablaPotenciasP6[]         = {1000f,1000f,1.1000f,1.1000f,1000f,1600f} ;
        
        
       
    }
         /**
	 * Metodo de calculo de cargas teoricas totales para un periodo determinado 
	 *   
         *              	   
         * @param Qtr => (1,2 o 3)
         * @param nDt => (1,2 o 3)
         * @return    => tablaRes[48]
	 */  
    public String[] CalculaCargasTeoricas(int Qtr,int nDiasTipo) {
        
        int filas, i, j, nDt ;
        float st ;
   
        
        System.out.println("Calculamos Cargas teoricas para nInventario = "+nInventario);
        String tablaRes[] = new String[48] ;
        
            for (j=0; j<48; j++){
                st = 0 ;
                for (i=0; i<nInventario; i++){

                    st = st + (this.fTablaPonderaciones[Qtr-1][i][nDiasTipo] * this.fTablaInventario[i] * this.fTablaPotenciasInst[Qtr-1][i][j][nDiasTipo] );

                }
          //       System.out.println("Calculamos potencia para j="+j+" es igual a ="+st+" kW");
                tablaRes[j] = Float.toString(st) ;
            }
        
        
        return tablaRes ;
    }
    /**
	 * Metodo de calculo de cargas Cuarto-Horarias teoricas  para un año 
	 *   
         *              	   
         * @param Qtr => ninguno
         * @return    => tablaRes[35040]
	 */  
    public String[] CalculaCargasCuartoHorarias() {
        
        int filas, i, j,y, Qtr, cnt ;
        float st ;
      
        String tablaRes[] = new String[35040] ;
        
        
        System.out.println("Calculamos Cargas CUARTO-HORARIAS teoricas para nInventario = "+nInventario);
        
        Qtr=1 ;
        cnt = 0 ;
        int nDt= 0;
        // ---------------------------------------------------------------------------
        for (y=0; y<365; y++){
               
            // ....................................
            if (y>0 && y<60)        { Qtr= 1 ; }   // estamos en primer trimestre
            if (y>334 && y <366 )   { Qtr= 1 ; }   // estamos en primer trimestre
            
            if (y>59 && y<152)      { Qtr= 2 ; }   // estamos en segundo trimestre
            if (y>242 && y<334)     { Qtr= 2 ; }   // estamos en segundo trimestre
            
            if (y>151 && y <242)    { Qtr= 3 ; }   // estamos en segundo trimestre
                                  
            // .....................................
                                    
            for (j=0; j<48; j++){
                st = 0 ;
                for (i=0; i<nInventario; i++){

                    st = st + (this.fTablaPonderaciones[Qtr-1][i][nDt] * this.fTablaInventario[i] * this.fTablaPotenciasInst[Qtr-1][i][j][nDt] );

                }
                tablaRes[cnt]=Float.toString(st) ;      // Potencia Cuarto-horaria
                cnt ++;
                tablaRes[cnt]=Float.toString(st) ;       // Potencia Cuarto-horaria (virtual)
                cnt ++;
                System.out.println("cnt->"+cnt+" -Calculamos potencia para y="+y+" Para cuarto-hora "+j+ " es igual a ="+st+" W");
                
            }
        
        }
        // ---------------------------------------------------------------------------
      
        return tablaRes ;
    }
    
      /**
	 * Metodo de calculo de costes de potencia para P6 anuales
	 *   
         *              	   
         * @param sTablaReg
         * @return    => tablaRes[12][3] ;
	 */  
    public float[][] CalculaCostePotenciaP6(String sTablaReg[]) {
   
      int m,n,i,j,cntDia,ndm, cntQtr ;  
      int tipoDia ;
      float fPrecioMes ; 
      float fFp[]           = new float[13] ;
      float potQ1,potQ2,potQ3,potQ4,potMax, sA, sB = 0;
      float coefPot      ;
      float tablaRes[][]   = new float[13][6] ;  
      
      
      float fPreciosPot[]     = {3.175178f,1.588963f,1.162857f,1.162857f,1.162857f,0.530570f} ;  // Carga la tabla de precios potencia para este mes
         
      // ...................... Iniciamos los contadores
      cntDia = 1;   // contador de dias
      cntQtr = 0;   // contador de cuartos-hora (0 a 35040)
      // -----------------------------------------------------------------------------------
      for (m=0; m<12; m++) {                    // Para cada mes del año
          
          ndm = this.diasMes[m] ;
          
          // ........................  Calcula precio para ese mes
          
         System.out.println("fPreciosPot[0]"+fPreciosPot[0]+" -fTablaPotenciasP6[0] ="+this.fTablaPotenciasP6[0]);
                        
          
          fPrecioMes =  fPreciosPot[0]*this.fTablaPotenciasP6[0]+ 
                        fPreciosPot[1]*this.fTablaPotenciasP6[1]+
                        fPreciosPot[2]*this.fTablaPotenciasP6[2]+
                        fPreciosPot[3]*this.fTablaPotenciasP6[3]+
                        fPreciosPot[4]*this.fTablaPotenciasP6[4]+
                        fPreciosPot[5]*this.fTablaPotenciasP6[5] ;
         
          // ........................   Comprueba si hay exesos de potencia y calcula la penalización
          
          for (n=0; n<ndm; n++){                // Para cada dia del mes
              
             tipoDia = 0 ;                      // Mira tipo de dia (normal,sabado,domingo,festivo) -> (0,1,2,3)
              
             String sTPeriodos[]   = {"P1","P2","P6"} ;       // Carga la tabla de periodos para este  mes
                        
             // Escoge el coeficientes para estos periodo
                                       
              
             // ...........................    Calcula sobre precio para este dia
             
             
             sB = 0 ;
             
             for (i=0; i<24; i++){ 
                 sA = 0 ;
                 potMax = 1000 ;                // Obtiene potencia maxima para ese periodo
                 coefPot = 0.5f ;                // Escoge el coeficientes para este periodo
                   
                 potQ1 = Float.parseFloat(sTablaReg[cntQtr]) ; cntQtr++;  
                 potQ2 = Float.parseFloat(sTablaReg[cntQtr]) ; cntQtr++;  
                 potQ3 = Float.parseFloat(sTablaReg[cntQtr]) ; cntQtr++;  
                 potQ4 = Float.parseFloat(sTablaReg[cntQtr]) ; cntQtr++;  
                 
               
                 
                 // Comprueba si se sobre pasa la potencia para cada cuarto de hora
                  
                 if (potQ1 > potMax) {
                     sA = sA + ((potQ1-potMax)*(potQ1-potMax)) ;       // calcula la formula                                  
                 } 
                 if (potQ2 > potMax) {
                     sA = sA + ((potQ2-potMax)*(potQ2-potMax)) ;       // calcula la formula                                  
                 } 
                 if (potQ3 > potMax) {
                     sA = sA + ((potQ3-potMax)*(potQ3-potMax)) ;       // calcula la formula                                  
                 } 
                  if (potQ4 > potMax) {
                     sA = sA + ((potQ4-potMax)*(potQ4-potMax)) ;       // calcula la formula                                  
                 } 
                                             
                 sA = (float) Math.sqrt(sA)      ;   
                 
                 sB = sB + ( coefPot *  this.fCoefPs6 * sA ) ;
                 
             }
               
          }
          
        tablaRes[m][0] = fPrecioMes ;
        tablaRes[m][1] = sB ;        
              
        System.out.println("m->"+m+" -Coste potencia ="+fPrecioMes+" Y coste exesos = "+sB+ " €");
            
       }
       // -----------------------------------------------------------------------------------    
          
       return tablaRes ;    
      }        
      
    public float[][] CalculaCargasResumen(int periodos,int numPerfiles) {
  
    String res[][] = new String[3][6]; 
    int i,j,k,ic,m,numMeses,diasTotales=0;
    int diasMes=0;
       
    String res1[] = new String[48];
         
     float total[][] = new float[periodos][3] ;
     
    
     int iTablaTemporada[][] = {
        {3,1,2,12},
        {6,3,4,5,6,10,11},
        {3,7,8,9}
       };
         
     // ........................ Calculo dias totales
    
     for (i=0; i< periodos; i++){         
         for (j=0; j<numPerfiles; j++){
            diasTotales = diasTotales + this.iTablaCalendario[i][j] ;
         }         
     }
     
     // ........................ Calculo total de cada periodo
     
     for (i=0; i<periodos; i++) {
         
         ic= i-1; 
         
         numMeses = iTablaTemporada[i][0] ;                        // numero de meses por periodo
         
         for (m=1; m<=numMeses; m++) {
             
             diasMes = iTablaTemporada[i][m];
         
            for (k=0; k<numPerfiles; k++) {

                 res1 = this.CalculaCargasTeoricas(ic,k);

                for (j=0; j<48; j++) {

                    total[i][2] += iTablaCalendario[i][k] * Float.parseFloat(res1[j]);
                }


            }
         }
     }
    
    
    return total;
    }
    
}
