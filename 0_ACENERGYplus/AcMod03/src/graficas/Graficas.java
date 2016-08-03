package graficas;

import java.awt.Dimension;

import java.awt.image.BufferedImage;

import java.io.*;

import java.util.logging.Level;

import java.util.logging.Logger;

import javax.swing.ImageIcon;

import javax.swing.JFileChooser;

import javax.swing.JLabel;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartUtilities;

import org.jfree.chart.JFreeChart;

import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.util.PublicCloneable;
import org.jfree.ui.Drawable;

import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.axis.NumberTickUnit;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.XYPlot;

public class Graficas {

    private BufferedImage _image;//para la imagen en memoria

    private JFreeChart grafico;// el grafico

    private Dimension d;//dimension del grafico

    public Graficas() {
    }

    /* Crea el grafico */
    public void crear_grafico_de_barras(Dimension d, double[] v, String[] arg1, String arg2[], String[] data) {

        this.d = d;

        DefaultCategoryDataset dataset = new DefaultCategoryDataset();

        //se llenan los datos
        for (int i = 0; i <= v.length - 1; i++) {

            dataset.setValue(v[i], arg1[i], arg2[i]);

        }

        //se crea el grafico
        grafico = ChartFactory.createBarChart(data[0], data[1], data[2], dataset, PlotOrientation.VERTICAL, false, false, false);
        
        // Se ajustan los ejes
      
        // get a reference to the plot for further customisation...
        CategoryPlot plot = (CategoryPlot) grafico.getPlot();
      
        // set the range axis to display integers only...
        NumberAxis rangeAxis = (NumberAxis) plot.getRangeAxis();
        rangeAxis.setStandardTickUnits(NumberAxis.createIntegerTickUnits());
    //    rangeAxis.setUpperMargin(1.0);
        rangeAxis.setUpperBound(1.0);
        
        
        //se coloca el grafico en memoria
        _image = grafico.createBufferedImage(this.d.width, this.d.height);
        

    }

    /* carga la imagen que esta en memoria en el objeto jLabel */
    public void cargar_grafico(JLabel lb) {

        ImageIcon imagenFondo = new ImageIcon(_image);

        lb.setIcon(imagenFondo);

        lb.repaint();

    }

    /* presenta la ventana de dialogo "guardar" y salva el grafico generado en JPG */
    public void Guardar() {

        JFileChooser fileChooser = new JFileChooser();

        int result = fileChooser.showSaveDialog(null);

        if (result == JFileChooser.APPROVE_OPTION) {

            try {

                //se obtiene la direccion donde se guardara la imagen
                String url = fileChooser.getSelectedFile().toString();

                //Se guarda la imagen
                ChartUtilities.saveChartAsJPEG(new File(url + ".jpg"), grafico, d.width, d.height);

            } catch (IOException ex) {

                Logger.getLogger(Graficas.class.getName()).log(Level.SEVERE, null, ex);

            }

        }

    }

}
