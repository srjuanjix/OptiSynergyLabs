/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lbdm;

import java.text.DecimalFormat;
import javax.swing.JOptionPane;


public class Utils {
 
	/**
	 * Metodo para pasar un numero binario a entero
	 */
	public static int binario_a_entero(int[] Bit_Vector) {
		int resultado = 0; /* Resultado en entero */
		int lon = Bit_Vector.length - 1;

		for (int i = 0; i < Bit_Vector.length; i++) {
			if (Bit_Vector[i] == 1) {
				resultado += Math.pow(2, lon - i);
			}
		}
		return resultado;
	}
	
	/**
	 * Metodo que devuelve el valor de la funcion 
	 */
	public static double funcion (double x, double valorObjetivo){
                                    double res=0;
                                    res = Math.abs(res-x)/valorObjetivo;
		return res;
	}
	
	
	/*
	 * Imprime una matriz con formato
	 */
	public static String toString(double [][] m) {
                                    double valor = 0;
		StringBuffer sb = new StringBuffer();
		sb.append("\t");
		for (int i = 0; i < m[0].length; ++i) {
			sb.append("C"+(i+1)).append("\t");
		}
		sb.append("\n\n");
		for (int r = 0; r < m.length; ++r) {
			sb.append("I"+(r+1)).append("\t");
			for (int c = 0; c < m[0].length; ++c) {
				sb.append(String.valueOf(m[r][c])).append("\t");
			}
                                                      valor = CalculoValorIndividuo(m[r]);
                                                      sb.append("Valor Ind. "+(r+1)+" = "+String.valueOf(valor)+"\n");
		}
		return sb.toString();
	}
	
	
	/*
	 * Imprime una matriz con formato
	 */
        /*
	public static String toString(double [][] m) {
		StringBuffer sb = new StringBuffer();
		sb.append("\t");
		for (int i = 0; i < m[0].length; ++i) {
			sb.append("C"+(i+1)).append("\t");
		}
		sb.append("\n\n");
		for (int r = 0; r < m.length; ++r) {
			sb.append("I"+(r+1)).append("\t");
			for (int c = 0; c < m[0].length; ++c) {
				sb.append(customFormat("###.###",m[r][c])).append("\t");
			}
			sb.append("\n");
		}
		return sb.toString();
	}
	*/
	/*
	 * Da formato a la matriz que se imprime
	 */
	public static String customFormat(String pattern, double value) {
		DecimalFormat myFormatter = new DecimalFormat(pattern);
		String output = myFormatter.format(value);
		return output;
	}
        // --------------------------------------------------------------------------------------------------------------------------------------
        /**
	 * Metodo para calcular el valor de un individuo
	 */
	public  static double  CalculoValorIndividuo(double[]  vectorIndividuo) {
		double resultado = 0;                                                                           //  Resultado en coma flotante
		int lon = vectorIndividuo.length - 1;

		for (int i = 0; i < vectorIndividuo.length; i++) {
			resultado += vectorIndividuo[i];                                       // sumamos todos los genes (registros cuartohorarios sinteticos) 
		}
                                    resultado = resultado / 4 ;                                                                   // calculo energía
                                    // System.out.println(" Valor del individuo:"+resultado);
		return resultado;
	}
        // --------------------------------------------------------------------------------------------------------------------------------------
                    /**
	 * Metodo para generar mensajes de aviso durante la ejecución
	 */
	public static void avisaProblemas(int p) {
            
            switch (p) {
                case 1:
                    JOptionPane.showMessageDialog(null,
                     "\nNo se ha conseguido cumplir la restricción de maximetros para generar un individuo",
	    "ADVERTENCIA!!!",JOptionPane.WARNING_MESSAGE);
                 break;
                case 2:
                   JOptionPane.showMessageDialog(null,
                     "\nNo se ha conseguido cumplir la restricción de maximetros para mutacion de un individuo",
	    "ADVERTENCIA!!!",JOptionPane.WARNING_MESSAGE); 
                    
                break;
            }
            
            
        }
}
