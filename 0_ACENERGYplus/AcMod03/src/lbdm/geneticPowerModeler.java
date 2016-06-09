/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lbdm;


/**
 *
 * @author jab7b7
 */
public class geneticPowerModeler {
                  // ..................................................................................................
	public  int numIndividuos             = 1;
                  
	public  int numCromosomas       = 6;
                  public int numGenes                    = 12;
	public  int numGeneraciones      = 10;
                  
        
	public  double [][] individuos               = new double [numIndividuos][numCromosomas*numGenes];
	public  double [] valorIndividuos          = new double [numIndividuos];
	public  double [] valorFuncionCalidadIndividuos = new double [numIndividuos];
	public  double pEmparejamiento = 0.7;
	public  double pMutacion = 0.3;
	public  double [][] mutaciones = new double [numIndividuos][numCromosomas*numGenes];
	public  double [][] tramosSeleccion = new double [numIndividuos][2];
	public  double [][] tramosCorte = new double [numCromosomas-1][2];
                 // ..................................................................................................
                 public String slog = "";
                 public int tfGeneracion = 0 ;
                 public double  tfMejorIndividuo = 0 ;
                 public double tfFuncionCalidad = 0 ;
                 // ..................................................................................................
                
                 public double [][] defCromosomas = {
                                                                    {4,0,3,1,1,1},
                                                                    {6,1,3,0,1,0},
                                                                    {2,0,3,0,0,1},
                                                                    {1,0,3,0,1,1},
                                                                    {2,0,3,0,1,1},
                                                                    {2,0,3,0,1,1},
                                                                     };
                 
                 public double[] maximetros = {4,4,4,4,12,12,12,12,10,10,10,10} ;
                 
                 public double valorObjetivo = 18.0 ;
                 
                 public double curvaPotencia[] = {0,0,0,0,0,0,0,0,0,0,0,0};
                 
    /**
     * Método que se ejecuta al pulsar el boton start
     * @param event
     */
    
    public  void  accionStart(int nIndividuos,int cromosomas,int generaciones, int genes, double pEmparejamiento, double pMutacion) {
    /*	
        numIndividuos       = Integer.parseInt((String) chIndividuos.getValue());
        numCromosomas   = Integer.parseInt((String) cdCromosomas.getValue());
        numGeneraciones = Integer.parseInt(tfGeneraciones.getText());
        pEmparejamiento  = Double.parseDouble((String) chEmparejamiento.getValue());
        pMutacion             = Double.parseDouble((String) chMutacion.getValue());
        
        */
    
        this.numIndividuos         = nIndividuos ;
        this.numCromosomas   = cromosomas;
        this.numGenes               = genes;
        this.numGeneraciones  = generaciones;
        this.pEmparejamiento    = pEmparejamiento;
        this.pMutacion                = pMutacion;
        
        individuos                                  = new double [numIndividuos][numCromosomas*numGenes];
        valorIndividuos                          = new double [numIndividuos];
        valorFuncionCalidadIndividuos= new double [numIndividuos];
        mutaciones                               = new double [numIndividuos][numCromosomas*numGenes];
        tramosSeleccion                       = new double [numIndividuos][2];
        tramosCorte                              = new double [numCromosomas-1][2];
        
        
        
   //     inicializarGrafica();
        inicializarTramosCorte();
        generarIndividuos();
        
		
		this.slog = "\n/======== INICIALIZACIÓN DE INDIVIDUOS ========/\n";
		this.slog += Utils.toString(individuos)+"\n\n";
		
		for (int i=0; i<numGeneraciones; i++){
			this.slog += "\n/======== GENERACIÓN "+(i+1)+" ========/\n";
			this.slog += "\n/ 1.- Individuos de la generación "+(i+1)+" /\n";
			this.slog += Utils.toString(individuos)+"\n";
			// Aplicación de la función de calidad
			this.slog += "\n/2.- Aplicamos la función de calidad a los individuos /\n";
			setValorIndividuo();
			for(int j=0; j<numIndividuos; j++){
				double valor = Utils.funcion(valorIndividuos[j], this.valorObjetivo);
				this.slog += "I"+(j+1)+" -> f("+valorIndividuos[j]+") = "+valor+"\n";
				valorFuncionCalidadIndividuos[j] = valor;
			}
                      
			// Calculo de las probabilidades para que un individuo sea seleccionado
			calcularTramosSelección ();
			this.slog += "\n/3.- Seleccion de un individuo /\n";
			this.slog += "Calculamos las probabilidades de seleccón de cada individuo\n";
			
			for (int j = 0; j < tramosSeleccion.length; ++j) {
				this.slog += "I"+(j+1)+" -> ["+tramosSeleccion[j][0]+" , "+tramosSeleccion[j][1]+")\n";
			}
			
			// Seleccionamos al candidato
			double random = Math.random();
			this.slog += "\nSeleccionamos un Individuo. \nNº Aleatorio obtenido = "+random+"\n";
			int seleccionado = getIndividuoSeleccionado(random);
			this.slog += "Individuo seleccionado: "+seleccionado+"\n";
			 
			// Operación de emparejamiento
			this.slog += "\n/ 4.- Operación de emparejamiento /\n";
			random = Math.random();
			this.slog += "\n¿Hay emparejamiento en esta generación?\nNº Aleatorio obtenido = "+random+" es menor que "+pEmparejamiento+" \n";
			if (random<pEmparejamiento){
				this.slog += "SI => Hay emparejamiento en esta generación\n";
				random = Math.random();
				this.slog += "Calculo la posición del corte. Nº Aleatorio para el corte = "+random+"\n";
				int corte = getCorte(random);
				this.slog += "Realizo el corte en el cromosoma numero "+corte+"\n";
				emparejar(seleccionado, corte);
				this.slog += "Nuevos individuos despues del emparejamiento:\n\n";
				this.slog += Utils.toString(individuos)+"\n";
			}else{
				this.slog += "NO => No hay emparejamiento en esta generación\n";
			}
			 
			// Operación de mutación
			this.slog += "\n/ 5.- Operación de mutación /\n";
			this.slog += "\nGeneramos numeros aleatorios para las mutaciones. \nLos cromosomas que tengan numeros aleatorios menores que 0.3 mutaran\n\n";
			generarMutaciones();
			this.slog += Utils.toString(mutaciones)+"\n";
			mutar();
			this.slog += "\nIndividuos despues de sufrir las mutaciones\n";
			this.slog += Utils.toString(individuos)+"\n";
			setValorIndividuo();
			this.slog += "\nEl mejor individuo de la generación "+(i+1)+" es el individuo numero "+getMejorIndividuo()+"\n";
			this.slog += "\nEl valor de su función de calidad es: "+Utils.funcion( valorIndividuos[getMejorIndividuo()-1],this.valorObjetivo)+"\n";
		
			tfGeneracion = (i+1);
			tfMejorIndividuo= valorIndividuos[getMejorIndividuo()-1];
			tfFuncionCalidad = Utils.funcion(valorIndividuos[getMejorIndividuo()-1],this.valorObjetivo);
			calcularCurvaPotencia(individuos,getMejorIndividuo()-1);
		}
    
    }
    
    public void initialize() {
    	// Pongo valores por defecto para aplicar el algoritmo
        this.numIndividuos         = 1;
        this.numCromosomas   = 6;
        this.numGenes               = 12;
        this.pEmparejamiento    = 0.7;
        this.pMutacion                = 0.3;
   
    }  
    
    
    
    /**
	 * Método para generar el conjunto inicial de individuos
	 */
                  // -------------------------------------------------------------------------------------------------------------------------------
	/*
                   public  void generarIndividuos(){
		for (int i=0; i<this.numIndividuos; i++){
			for (int j=0; j<this.numCromosomas; j++){
				double aleatorio = Math.random();
				if (aleatorio < 0.5)
					this.individuos[i][j] = 0;
				else
					this.individuos[i][j] = 1;
			}
		}
	}*/
    // ------------------------------------------------------------------------------------------------------------------------------------------
	public  void generarIndividuos(){
                            double potnom              =0 ;
                            double  numPeriod        = 0;   
                            int comporta                   = 0;
                            int numCromoperPeriod = 0 ;
                            int ind                                =0 ;
                            boolean cumpleMaximetros    = false;
                            int iteracion            = 0 ;
                            int maxIteraciones = 500 ;
                           
            
		for (int i=0; i<this.numIndividuos; i++){
                                                    cumpleMaximetros = false;
                                                    // ---------------------------------------------------------------------------------------------------
                                                    while (!cumpleMaximetros) {
                                                        ind = 0 ;
                                                         for (int k=0;k<this.numCromosomas;k++){
                                                                    // ...................................................................................
                                                                    potnom      = this.defCromosomas[k][0];          
                                                                    comporta   = (int) (this.defCromosomas[k][1]);
                                                                    numPeriod = this.defCromosomas[k][2]; 

                                                                    numCromoperPeriod =  (int) (this.numGenes/numPeriod );
                                                                    // ...................................................................................
                                                                   for ( int l=0; l<numPeriod; l++) { 
                                                                            // System.out.println("defCromosomas["+k+"]["+(3+l)+"]= "+this.defCromosomas[k][3+l] );
                                                                            if ( this.defCromosomas[k][3+l] > 0   ) {
                                                                           
                                                                            // ................................................................................... Si está definido consumo en este periodo
                                                                                 for (int j=0; j<numCromoperPeriod; j++){

                                                                                     switch (comporta) {                                            // Vemos que tipo de consumo segun su definicion

                                                                                         case 0:
                                                                                             double aleatorio = Math.random();
                                                                                             if (aleatorio < 0.5)
                                                                                                     this.individuos[i][ind] = 0;
                                                                                             else
                                                                                                     this.individuos[i][ind] = potnom;
                                                                                         break;
                                                                                         case 1:
                                                                                                    this.individuos[i][ind] = potnom;
                                                                                          break;


                                                                                      }   

                                                                                      // System.out.println("Individuo:"+i+" - Cromosoma:"+k+" ind:"+ind+" - valor:"+this.individuos[i][ind]);
                                                                                      ind ++ ;  
                                                                                 }
                                                                                // ................................................................................... Si no, apuntamos 0 kw en ese gen y continuamos
                                                                            } else {
                                                                                     for (int j=0; j<numCromoperPeriod; j++){
                                                                                        this.individuos[i][ind] = 0;
                                                                                        // System.out.println("Individuo:"+i+" - Cromosoma:"+k+" ind:"+ind+" - valor:"+this.individuos[i][ind]);

                                                                                         ind ++ ;  
                                                                                     }
                                                                                      
                                                                            }
                                                                            
                                                                            // ...................................................................................
                                                                   }
                                                         }
                                                         if ( compruebaMaximetrosIndividuo(this.individuos,i)){
                                                             cumpleMaximetros = true;
                                                         } else {
                                                             iteracion ++;
                                                             if (iteracion > maxIteraciones){
                                                               // Utils. avisaProblemas(1);
                                                                 cumpleMaximetros = true ;          // Salimos pero con problemas
                                                             }
                                                         }
                                                          // ---------------------------------------------------------------------------------------------------
                                                    }
		}
	} 
	
	/**
	 * Método para calcular el valor de cada individuo
	 */
                 // -------------------------------------------------------------------------------------------------------------------------------
	public  void setValorIndividuo (){
		for (int i=0; i<this.numIndividuos; i++){
			this.valorIndividuos [i] = Utils.CalculoValorIndividuo(this.individuos[i]);
		}
	}
	
	
	/**
	 * Método para calcular los tramos de seleccion de cada individuo
	 */
                 // -------------------------------------------------------------------------------------------------------------------------------
	public  void calcularTramosSelección (){
		double sum = 0;
		
		// Calculamos la suma de todos los valores de los individuos
		for (int i=0; i<this.numIndividuos; i++){
			sum += Utils.funcion(this.valorIndividuos[i], this.valorObjetivo);
		}
		
		double contador = 0;
		// Normalizamos los valores para hacer la seleccion
		for (int i=0; i<this.numIndividuos; i++){
			double val = Utils.funcion( this.valorIndividuos[i],this.valorObjetivo)/(double) sum;
			tramosSeleccion[i][0] = contador;
			contador += val;
			tramosSeleccion[i][1] = contador;
                                                      // System.out.println("Tramos seleccion i:"+i+" [0]="+tramosSeleccion[i][0]+" - [1]="+tramosSeleccion[i][1]);
		}
		
	}
	
	
	/**
	 * Método que nos da el individuo seleccionado en cada generacion
	 * @param random
	 * @return individuo seleccionado
	 */
	public  int getIndividuoSeleccionado (double random){
		int seleccion = 0;
		boolean encontrado = false;
		
		while (!encontrado){
			if (tramosSeleccion[seleccion][0]<=random & tramosSeleccion[seleccion][1]>random)
				encontrado = true;
			else
				seleccion ++;			
		}
		return seleccion+1;
	}
	
	
	/**
	 * Metodo para crear los tramos de corte para el emparejamiento
	 */
	public  void inicializarTramosCorte (){
		double x = 1/(double) (this.numCromosomas-1);
		double contador = 0;
		for (int i=0; i<this.numCromosomas-1; i++){
			this.tramosCorte[i][0] = contador;
			contador += x;
			this.tramosCorte[i][1] = contador;
		}
	}
	
	
	/**
	 * Método que calcula el punto en el que hay que hacer el corte para el emparejamiento
	 * @param random
	 * @return numero del corte
	 */
	public  int getCorte (double random){
		int corte = 0;
		boolean encontrado = false;
		
		while (!encontrado){
			if (this.tramosCorte[corte][0]<=random & this.tramosCorte[corte][1]>random)
				encontrado = true;
			else
				corte ++;			
		}
		return corte+1;
	}
	
	
	/**
	 * Metodo para realizar los emparejamientos
	 * @param mejorIndividuo
	 * @param numCromosoma
	 */
	public  void emparejar (int mejorIndividuo, int numCromosoma){
                                    int genesTotal=this.numCromosomas*this.numGenes ;
		double [] bestIndividuo = new double [genesTotal];
		// Copio el mejor individuo
		for (int i=0; i<genesTotal; i++){
			bestIndividuo[i] = this.individuos[mejorIndividuo-1][i];
		}
		
		// Emparejo el mejor individuo con el resto
		for (int i=0; i<this.numIndividuos; i++){
			for (int j=numCromosoma*this.numGenes; j<(numCromosoma+1)*this.numGenes; j++){
				this.individuos[i][j] = bestIndividuo[j];
			}
		}
		
	}
	
	
	/**
	 * Método que genera una matriz para ver que cromosomas mutar
	 */
	public  void generarMutaciones(){
		for (int i=0; i<this.numIndividuos; i++){
			for (int j=0; j<(this.numCromosomas*this.numGenes); j++){
				this.mutaciones[i][j] = Math.random();
			}
		}
	}
	
	// -----------------------------------------------------------------------------------------------------------------------------------
	/**
	 * Método que realiza las mutaciones
	 */
	public  void mutar(){
                  int k ;
                  double potnom ;
                  boolean cumpleMaximetros = false ;
                  int maxIteraciones = 100 ;
                  int iteracion = 0 ;
                  int comporta = 0 ;
		for (int i=0; i<this.numIndividuos; i++){
                                                      while (!cumpleMaximetros) {
                                                                for (int j=0; j<(this.numCromosomas*this.numGenes); j++){
                                                                        double mutacion = mutaciones[i][j];
                                                                        if (mutacion < pMutacion){
                                                                                                                                   k = (int) j/this.numGenes ;
                                                                                                                                  // ...................................................................................
                                                                                                                                    potnom      = this.defCromosomas[k][0];          
                                                                                                                                    comporta   = (int) (this.defCromosomas[k][1]);

                                                                                if (individuos[i][j] == 0 && comporta==0)

                                                                                        this.individuos[i][j] = potnom;
                                                                                else
                                                                                        this.individuos[i][j] = 0;
                                                                        }
                                                                }
                                                                if ( compruebaMaximetrosIndividuo(this.individuos,i)){
                                                                         cumpleMaximetros = true;
                                                               } else {
                                                                         iteracion ++;
                                                                         if (iteracion > maxIteraciones){
                                                                           // Utils. avisaProblemas(2);
                                                                             cumpleMaximetros = true ;          // Salimos pero con problemas
                                                                         }
                                                               }
                                                      }
                                    }   
		
	}
	
	
	/**
	 * Metodo que calcula el mejor individuo de los que hay
	 * @return mejor individuo
	 */
	public  int getMejorIndividuo (){
		int individuo = 0;
		double fun = 1;
		// System.out.println("Calculamos el mejor individuo de la camada... ");
		for (int i=0; i<this.numIndividuos; i++){
			double valorFuncion = Utils.funcion(this.valorIndividuos[i],this.valorObjetivo);
                                                      // System.out.println("valorFuncion ="+valorFuncion);
			if (Math.abs(1-valorFuncion) < fun){
				fun = Math.abs(1-valorFuncion);
				individuo = i;
                                                                        // System.out.println("Nuevo valor de fun:"+fun);
			}
		}
		return individuo+1;
	}
	
		
	public static int getRango(int numCromosomas) {
		switch (numCromosomas) {
		case 4:
			return 15;
		case 5:
			return 31;
		case 6:
			return 63;
		case 7:
			return 127;
		case 8:
			return 255;
		default:
			return 15;
		}
	}
        // ---------------------------------------------------------------------------------------------------------------------------------------------------------------------
        public boolean compruebaMaximetrosIndividuo(double m[][],int indInd) {
        boolean res = true;
        double potenciaTotal = 0 ;
        int k =0 ;
            
        for (int i=0; i<this.numGenes; i++){
            potenciaTotal = 0 ;
            for (int j=0; j<this.numCromosomas; j++) {
                
                k = i+(j*this.numGenes) ;           // gen dentro del cromosoma
                // System.out.println("Calculando para k:"+k);
                potenciaTotal += m[indInd][k] ; // sumatorio para este cuartohorario
                
                
            }
            if ( potenciaTotal >  this.maximetros[i]){
                // System.out.println(" No cumple con gen i:"+i+" potenciaTotal="+potenciaTotal+" y maximetro es:"+this.maximetros[i]);
                res = false ;         // no cumple en algun gen
                break;                  // salimos ya
            
          }    
        }
        
            
         return res;
        }
        // --------------------------------------------------------------------------------------------------------------------------------------------------------------------
        
        public void calcularCurvaPotencia(double m[][],int indInd) {
            boolean res = true;
            double potenciaTotal = 0 ;
            int k =0 ;

            for (int i=0; i<this.numGenes; i++){
                potenciaTotal = 0 ;
                for (int j=0; j<this.numCromosomas; j++) {

                    k = i+(j*this.numGenes) ;           // gen dentro del cromosoma
                    // System.out.println("Calculando para k:"+k);
                    potenciaTotal += m[indInd][k] ; // sumatorio para este cuartohorario


                }
                 this.curvaPotencia[i] = potenciaTotal ; 
                 
           } 
               
        }
}
